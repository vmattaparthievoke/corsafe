package com.nti.corsafe.carrier;

import com.nti.corsafe.common.model.NTIResponse;
import com.nti.corsafe.site.Site;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
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

    @PostMapping("/add")
    public NTIResponse<Carrier> add(@RequestBody Carrier carrier) throws BadRequestException {
        return new NTIResponse<>(HttpStatus.OK, "Added Successfully", carrierService.add(carrier));
    }

    @PostMapping("/{id}/site/add")
    public NTIResponse<Site> add(@PathVariable String id, @RequestBody Site site) throws BadRequestException {
        return new NTIResponse<>(HttpStatus.OK, "Site Added Successfully", carrierService.addSite(id, site));
    }

    @PutMapping("/update")
    public NTIResponse<Carrier> update(@RequestBody Carrier carrier) throws BadRequestException {
        return new NTIResponse<>(HttpStatus.OK, "Updated Successfully", carrierService.update(carrier));
    }

    @GetMapping("/list")
    public NTIResponse<List<Carrier>> getAll() {
        return new NTIResponse<>(HttpStatus.OK, carrierService.getAll());
    }

    @GetMapping("/name/{name}")
    public NTIResponse<Carrier> findByName(@PathVariable String name) {
        return new NTIResponse<>(HttpStatus.OK, carrierService.findByCarrierName(name));
    }

    @GetMapping("/category/{category}")
    public NTIResponse<List<Carrier>> findByCategory(@PathVariable Category category) {
        return new NTIResponse<>(HttpStatus.OK, carrierService.findByCategory(category));
    }

    //delete consignor node and it's relations
    @DeleteMapping("/{id}")
    public NTIResponse<Void> deleteById(@PathVariable String id) throws BadRequestException {
        carrierService.deleteById(id);
        return new NTIResponse<>(HttpStatus.OK, "Carrier deleted successfully");
    }
}
