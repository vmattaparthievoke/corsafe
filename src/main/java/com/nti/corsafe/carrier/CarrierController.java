package com.nti.corsafe.carrier;

import com.nti.corsafe.common.model.NTIResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrier")
@AllArgsConstructor
public class CarrierController {

    @Autowired
    CarrierService carrierService;

    @GetMapping("/list")
    public NTIResponse<List<Carrier>> getAll() {
        return new NTIResponse<>(HttpStatus.OK.value(), null,
                carrierService.getAll());
    }

    @GetMapping("/name/{name}")
    public Carrier findByName(@PathVariable String name) {
        return carrierService.findByCarrierName(name);
    }

    @GetMapping("/category/{category}")
    public NTIResponse<List<Carrier>> findByCategory(@PathVariable String category) {
        return new NTIResponse<>(HttpStatus.OK.value(), null,
                carrierService.findByCategory(category));
    }

    @PostMapping("/add")
    public Carrier add(@RequestBody Carrier consignor) {
        return carrierService.addCarrier(consignor);
    }
}
