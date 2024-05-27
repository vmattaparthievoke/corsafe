package com.nti.corsafe.carrier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarrierService {

    @Autowired
    private CarrierRepository carrierRepository;

    public List<Carrier> getAll() {
        return carrierRepository.findAll();
    }

    public Carrier findByCarrierName(String name) {
        return carrierRepository.findByName(name);
    }

    public List<Carrier> findByCategory(Category category) {
        return carrierRepository.findByCategory(category.name());
    }

    public Carrier addCarrier(Carrier carrier) {
        carrier.setId(UUID.randomUUID().toString());
        return carrierRepository.save(carrier);
    }

}
