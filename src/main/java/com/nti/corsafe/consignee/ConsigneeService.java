package com.nti.corsafe.consignee;
import com.nti.corsafe.carrier.Carrier;
import com.nti.corsafe.carrier.CarrierRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsigneeService {

    @Autowired
    private ConsigneeRepository consigneeRepository;

    @Autowired
    private CarrierRepository carrierRepository;

    //get all consignees
    public List<Consignee> getAll() {
        return consigneeRepository.findAll();
    }
    public Consignee addConsignee(Consignee consignee) {
        consignee.setId(UUID.randomUUID().toString());
        return consigneeRepository.save(consignee);
    }
    //get consignee by name
    public Consignee findByConsigneeName(String name) {
        return consigneeRepository.findByName(name);
    }
    //add carrier to consignee with exception handling
    public Consignee addCarrier(String id, Carrier carrier) throws BadRequestException {
        Optional<Consignee> optionalConsignee = consigneeRepository.findById(id);
        if (optionalConsignee.isEmpty()) {
            throw new BadRequestException("Invalid Consignee Id");
        } else {
            Consignee consignee = optionalConsignee.get();
            carrier.setId(UUID.randomUUID().toString());
            consignee.getCarriers().add(carrier);
            return consigneeRepository.save(consignee);
        }
    }
    //add carrier using carrier id to consignee with exception handling
    public Consignee addCarrier(String id, String carrierId) throws BadRequestException {
        Optional<Consignee> optionalConsignee = consigneeRepository.findById(id);
        if (optionalConsignee.isEmpty()) {
            throw new BadRequestException("Invalid Consignee Id");
        } else {
            Consignee consignee = optionalConsignee.get();
            Optional<Carrier> optionalCarrier = carrierRepository.findById(carrierId);
            if (optionalCarrier.isEmpty()) {
                throw new BadRequestException("Invalid Carrier Id");
            } else {
                consignee.getCarriers().add(optionalCarrier.get());
                return consigneeRepository.save(consignee);
            }
        }
    }
    //delete consignee
    public void deleteConsignee(String id) {
        consigneeRepository.deleteById(id);
    }

}
