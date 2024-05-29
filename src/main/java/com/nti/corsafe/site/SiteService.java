package com.nti.corsafe.site;

import com.nti.corsafe.member.Member;
import com.nti.corsafe.member.MemberRequest;
import com.nti.corsafe.member.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.nti.corsafe.member.Role.valueOf;

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
                        .skills(memberRequest.getSkills())
                        .build();
                addMemberWithRespectToRole(site, member, memberRequest.getRoles());
            });
            return siteRepository.save(site);
        }
    }

    private void addMemberWithRespectToRole(Site site, Member member, List<String> roles) {
        roles.forEach(role -> {
            switch (valueOf(role)) {
                case DRIVER:
                    site.getDrivers().add(member);
                    break;
                case SITE_INSPECTOR:
                    site.getSiteInspectors().add(member);
                    break;
                case SITE_OWNER:
                    site.setSiteOwner(member);
                    break;
                case SITE_MANAGER:
                    site.getSiteManagers().add(member);
                    break;
                default:
                    System.out.println("Unknown role.");
                    break;
            }
        });
    }

    public void deleteSites(List<Site> sites) {
        for (Site site : sites) {
            memberService.deleteMembers(Stream.of(Collections.singletonList(site.getSiteOwner()), site.getDrivers(),
                    site.getSiteManagers(), site.getSiteInspectors()).flatMap(Collection::stream).toList());
            siteRepository.delete(site);
        }
    }
}
