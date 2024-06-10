package com.nti.corsafe.carrier;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nti.corsafe.member.Member;
import com.nti.corsafe.site.Site;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

import static com.nti.corsafe.common.util.constants.CommonConstant.SITE;
import static com.nti.corsafe.common.util.constants.CommonConstant.SUB_CONTRACTOR;
import static com.nti.corsafe.common.util.constants.RoleConstant.*;

@Node
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Carrier {

    @Id
    private String id;
    private String name;
    private String fleetType;
    private String website;
    private String email;
    private String helplineNumber;
    @Relationship(type = ORGANIZATION_ADMINISTRATOR)
    private Member organizationAdministrator;
    @Relationship(type = ORG_DOCUMENT_MANAGER)
    private Member orgDocumentManager;
    @Relationship(type = SUPPLY_CHAIN_MANAGER)
    private Member supplyChainManager;
    @Relationship(type = ORG_COMPLIANCE_MANAGER)
    private Member complianceManager;
    @Relationship(type = TENANT_ADMIN)
    private Member tenantAdmin;
    @Relationship(type = CLIENT_ADMIN)
    private Member clientAdmin;
    @Relationship(type = COMPLIANCE_ADMIN)
    private Member complianceAdmin;
    @Relationship(type = COMPLIANCE_OFFICER)
    private Member complianceOfficer;
    @Relationship(type = INSPECTION_ADMIN)
    private Member inspectionAdmin;
    @Relationship(type = INSPECTION_COORDINATOR)
    private Member inspectionCoordinator;
    @Relationship(type = INSPECTION_SUPERVISOR)
    private Member inspectionSupervisor;
    @Relationship(type = INSPECTION_OFFICER)
    private Member inspectionOfficer;
    @Relationship(type = TRAINING_ADMIN)
    private Member trainingAdmin;
    @Relationship(type = TRAINING_COORDINATOR)
    private Member trainingCoordinator;
    @Relationship(type = LMS_CONTENT_MANAGER)
    private Member lmsContentManager;
    @Relationship(type = SITE)
    private List<Site> sites = new ArrayList<>();
    @Relationship(type = SUB_CONTRACTOR)
    private List<Carrier> subContractors = new ArrayList<>();

}