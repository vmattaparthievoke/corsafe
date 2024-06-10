package com.nti.corsafe.consignee;

import com.nti.corsafe.carrier.Carrier;
import com.nti.corsafe.common.model.NTIResponse;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consignee")
@AllArgsConstructor
public class ConsigneeController {

    @Autowired
    ConsigneeService consigneeService;

    //get all consignees
    @GetMapping("/list")
    public NTIResponse<List<Consignee>> getAll() {
        return new NTIResponse<>(HttpStatus.OK, consigneeService.getAll());
    }
    //create consignee
    @PostMapping("/add")
    public NTIResponse<Consignee> add(Consignee consignee) {
        return new NTIResponse<>(HttpStatus.OK, consigneeService.addConsignee(consignee));
    }
    //find conignee by name
    @GetMapping("/name/{name}")
    public NTIResponse<Consignee> findByName(String name) {
        return new NTIResponse<>(HttpStatus.OK, consigneeService.findByConsigneeName(name));
    }
    //add carrier to consignee
    @PostMapping("/{id}/Carrier/add")
    public NTIResponse<Consignee> addCarrier(String id, @RequestBody Carrier carrier) throws BadRequestException{
        return new NTIResponse<>(HttpStatus.OK, consigneeService.addCarrier(id, carrier));
    }
    //add carrier to consignee using carrier id
    @PostMapping("/{id}/Carrier/{carrierId}")
    public NTIResponse<Consignee> addCarrier(String id, String carrierId) throws BadRequestException{
        return new NTIResponse<>(HttpStatus.OK, consigneeService.addCarrier(id, carrierId));
    }
    //delete consignee
    @DeleteMapping("/{id}")
    public NTIResponse<Void> deleteById(String id) {
        consigneeService.deleteConsignee(id);
        return new NTIResponse<>(HttpStatus.OK, "Consignee deleted successfully");
    }

}
