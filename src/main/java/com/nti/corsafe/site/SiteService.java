package com.nti.corsafe.site;

import com.nti.corsafe.member.Member;
import com.nti.corsafe.member.MemberRequest;
import com.nti.corsafe.member.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.nti.corsafe.common.util.constants.RoleConstant.*;

@Service
public class SiteService {
    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private MemberService memberService;

    public Site addMember(String id, List<MemberRequest> memberRequests) throws BadRequestException {
        if (StringUtils.isEmpty(id)) {
            throw new BadRequestException();
        }
        Optional<Site> optionalSite = siteRepository.findById(Long.parseLong(id));
        if (optionalSite.isEmpty()) {
            throw new BadRequestException("Invalid Site Id");
        } else {
            Site site = optionalSite.get();
            memberRequests.forEach(memberRequest -> {
                Member member = Member.builder()
                        .name(memberRequest.getName())
                        .phoneNumber(memberRequest.getPhoneNumber())
                        .address(memberRequest.getAddress())
                        .build();
                addMemberWithRespectToRole(site, member, memberRequest.getRoles());
            });
            return siteRepository.save(site);
        }
    }

    private void addMemberWithRespectToRole(Site site, Member member, List<String> roles) {
        roles.forEach(role -> {
            switch (role) {
                case DRIVER:
                    site.getDrivers().add(member);
                    break;
                case LOADING_MANAGER:
                    site.getLoadingManagers().add(member);
                    break;
                case UNLOADING_MANAGER:
                    site.getUnloadingManagers().add(member);
                    break;
                case SITE_MANAGER:
                    site.getSiteManagers().add(member);
                    break;
                case SITE_COMPLIANCE_MANAGER:
                    site.setSiteComplianceManager(member);
                    break;
                case SITE_ADMINISTRATOR:
                    site.setSiteAdministrator(member);
                    break;
                case FLEET_MANAGER:
                    site.getFleetManagers().add(member);
                    break;
                case FLOOR_INCHARGE:
                    site.getFloorIncharges().add(member);
                    break;
                default:
                    System.out.println("Unknown role.");
                    break;
            }
        });
    }

    public void deleteSites(List<Site> sites) {
        for (Site site : sites) {
            memberService.deleteMembers(Stream.of(site.getDrivers(), site.getSiteManagers(),
                            site.getFloorIncharges(), Arrays.asList(site.getSiteComplianceManager(),
                                    site.getSiteAdministrator()), site.getUnloadingManagers(),
                            site.getLoadingManagers(), site.getFleetManagers())
                    .flatMap(Collection::stream).toList());
            siteRepository.delete(site);
        }
    }
}
