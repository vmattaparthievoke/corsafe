package com.nti.corsafe.consigner;

import com.nti.corsafe.common.NTIResponse;
import lombok.AllArgsConstructor;
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
        return new NTIResponse<>(HttpStatus.OK.value(), null,
                consignorService.getAll());
    }

    @GetMapping("/name/{name}")
    public Consignor findByName(@PathVariable String name) {
        return consignorService.findByConsignorName(name);
    }

    @GetMapping("/category/{category}")
    public NTIResponse<List<Consignor>> findByCategory(@PathVariable String category) {
        return new NTIResponse<>(HttpStatus.OK.value(), null,
                consignorService.findByCategory(category));
    }

    @PostMapping("/add")
    public Consignor add(@RequestBody Consignor consignor) {
        return consignorService.addConsignor(consignor);
    }

    /*@PostMapping("add/movie")
    public User addMovie(@RequestParam String userName, @RequestBody List<MovieRequest> movieRequestList) {
        return userService.addMovie(userName, movieRequestList);
    }

    @DeleteMapping("delete")
    public User deleteRelationByUser(@RequestParam String name) {
        return userService.deleteRelationByUser(name);
    }*/
}
