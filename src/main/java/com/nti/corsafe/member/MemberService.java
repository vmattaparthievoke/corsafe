package com.nti.corsafe.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void deleteMembers(List<Member> members) {
        memberRepository.deleteAll(members);
    }
}
