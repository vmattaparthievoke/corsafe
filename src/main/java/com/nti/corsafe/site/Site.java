package com.nti.corsafe.site;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nti.corsafe.common.model.Address;
import com.nti.corsafe.common.model.AddressConverter;
import com.nti.corsafe.member.Member;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

import static com.nti.corsafe.common.util.constants.RoleConstant.*;

@Data
@Node
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Site {

    @Id
    @GeneratedValue
    private Long id;
    @CompositeProperty(prefix = "address", converter = AddressConverter.class)
    private Address address;
    private String name;
    private boolean headOffice;
    private List<String> functions = new ArrayList<>();
    @Relationship(type = SITE_COMPLIANCE_MANAGER)
    private Member siteComplianceManager;
    @Relationship(type = COMPLIANCE_COORDINATOR)
    private Member complianceCoordinator;
    @Relationship(type = DRIVER)
    private List<Member> drivers = new ArrayList<>();
    @Relationship(type = SITE_MANAGER)
    private List<Member> siteManagers = new ArrayList<>();
    @Relationship(type = "SITE ADMIN")
    private Member siteAdministrator;
    @Relationship(type = "FLOOR INCHARGE")
    private List<Member> floorIncharges = new ArrayList<>();
    @Relationship(type = "FLEET MANAGER")
    private List<Member> fleetManagers = new ArrayList<>();
    @Relationship(type = "LOADING MANAGER")
    private List<Member> loadingManagers = new ArrayList<>();
    @Relationship(type = "UNLOADING MANAGER")
    private List<Member> unloadingManagers = new ArrayList<>();

}