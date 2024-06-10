package com.nti.corsafe.member;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MemberRequest {

    private String name;
    private String phoneNumber;
    private List<String> roles = new ArrayList<>();
    private List<String> skills = new ArrayList<>();
}
