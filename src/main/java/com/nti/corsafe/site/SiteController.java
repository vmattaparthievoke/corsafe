package com.nti.corsafe.site;

import com.nti.corsafe.common.model.NTIResponse;
import com.nti.corsafe.member.MemberRequest;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/site")
@AllArgsConstructor
public class SiteController {

    @Autowired
    SiteService siteService;

    @PostMapping("/{id}/Member/add")
    public NTIResponse<Site> addMember(@PathVariable String id, @RequestBody List<MemberRequest> memberRequests) throws BadRequestException {
        return new NTIResponse<>(HttpStatus.OK.value(), siteService.addMember(id, memberRequests));
    }
}
