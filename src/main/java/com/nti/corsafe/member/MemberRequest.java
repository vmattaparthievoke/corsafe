package com.nti.corsafe.member;

import com.nti.corsafe.common.model.Address;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MemberRequest {

    private String name;
    private String phoneNumber;
    private List<String> roles = new ArrayList<>();
    private Address address;
}
