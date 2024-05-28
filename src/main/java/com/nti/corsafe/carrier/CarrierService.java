package com.nti.corsafe.carrier;

import com.nti.corsafe.common.exception.UniqueConstraintException;
import com.nti.corsafe.site.Site;
import com.nti.corsafe.site.SiteRepository;
import jakarta.validation.ConstraintViolationException;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarrierService {

    @Autowired
    private CarrierRepository carrierRepository;

    @Autowired
    private SiteRepository siteRepository;

    public List<Carrier> getAll() {
        return carrierRepository.findAll();
    }

    public Carrier findByCarrierName(String name) {
        return carrierRepository.findByName(name);
    }

    public List<Carrier> findByCategory(Category category) {
        return carrierRepository.findByCategory(category.name());
    }

    public Carrier add(Carrier carrier) throws BadRequestException {
        if (!StringUtils.isEmpty(carrier.getId())) {
            throw new BadRequestException();
        }
        carrier.setId(UUID.randomUUID().toString());
        try{
            return carrierRepository.save(carrier);
        }catch (Exception e){
            throw new UniqueConstraintException(carrier.getName() +" Carrier already exists." );
        }
    }

    public Carrier update(Carrier carrier) throws BadRequestException {
        if (StringUtils.isEmpty(carrier.getId())) {
            throw new BadRequestException();
        }
        if (!carrierRepository.existsById(carrier.getId())) {
            throw new BadRequestException();
        }
        return carrierRepository.save(carrier);
    }

    public Site addSite(String id, Site site) throws BadRequestException {
        if (StringUtils.isEmpty(id)) {
            throw new BadRequestException();
        }
        Optional<Carrier> optionalCarrier = carrierRepository.findById(id);
        if (optionalCarrier.isEmpty()) {
            throw new BadRequestException("Invalid Carrier Id");
        } else {
            Carrier carrier = optionalCarrier.get();
            site.setId(UUID.randomUUID().toString());
            carrier.getSites().add(site);
            return siteRepository.save(site);
        }
    }

}
