package com.nti.corsafe.consigner;

import com.nti.corsafe.carrier.Carrier;
import com.nti.corsafe.common.model.NTIResponse;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consignor")
@AllArgsConstructor
public class ConsignorController {

    @Autowired
    ConsignorService consignorService;

    @GetMapping("/list")
    public NTIResponse<List<Consignor>> getAll() {
        return new NTIResponse<>(HttpStatus.OK, consignorService.getAll());
    }

    @GetMapping("/name/{name}")
    public NTIResponse<Consignor> findByName(@PathVariable String name) {
        return new NTIResponse<>(HttpStatus.OK, consignorService.findByConsignorName(name));
    }

    @PostMapping("/add")
    public NTIResponse<Consignor> add(@RequestBody Consignor consignor) {
        return new NTIResponse<>(HttpStatus.OK, consignorService.addConsignor(consignor));
    }

    @PostMapping("/{id}/Carrier/add")
    public NTIResponse<Consignor> addCarrier(@PathVariable String id, @RequestBody Carrier carrier) throws BadRequestException {
        return new NTIResponse<>(HttpStatus.OK, consignorService.addCarrier(id, carrier));
    }

    @PostMapping("/{id}/Carrier/{carrierId}")
    public NTIResponse<Consignor> addCarrier(@PathVariable String id, @PathVariable String carrierId) throws BadRequestException {
        return new NTIResponse<>(HttpStatus.OK, consignorService.addCarrier(id, carrierId));
    }

    //delete consignor node and it's relations
    @DeleteMapping("/{id}")
    public NTIResponse<Void> deleteById(@PathVariable String id) {
        consignorService.deleteById(id);
        return new NTIResponse<>(HttpStatus.OK, "Consignor deleted successfully");
    }
}
