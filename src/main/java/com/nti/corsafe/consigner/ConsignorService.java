package com.nti.corsafe.consigner;

import com.nti.corsafe.carrier.Carrier;
import com.nti.corsafe.carrier.CarrierRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsignorService {

    @Autowired
    private ConsignorRepository consignorRepository;

    @Autowired
    private CarrierRepository carrierRepository;

    public List<Consignor> getAll() {
        return consignorRepository.findAll();
    }

    public Consignor findByConsignorName(String name) {
        return consignorRepository.findByName(name);
    }

    public Consignor addConsignor(Consignor consignor) {
        consignor.setId(UUID.randomUUID().toString());
        return consignorRepository.save(consignor);
    }

    public Consignor addCarrier(String id, Carrier carrier) throws BadRequestException {
        Optional<Consignor> optionalConsignor = consignorRepository.findById(id);
        if (optionalConsignor.isEmpty()) {
            throw new BadRequestException();
        } else {
            Consignor consignor = optionalConsignor.get();
            carrier.setId(UUID.randomUUID().toString());
            consignor.getCarriers().add(carrier);
            return consignorRepository.save(consignor);
        }

    }

    public Consignor addCarrier(String id, String carrierId) throws BadRequestException {
        Optional<Consignor> optionalConsignor = consignorRepository.findById(id);
        if (optionalConsignor.isEmpty()) {
            throw new BadRequestException("Invalid Consignor Id");
        } else {
            Consignor consignor = optionalConsignor.get();
            Optional<Carrier> optionalCarrier = carrierRepository.findById(carrierId);
            if (optionalCarrier.isEmpty()) {
                throw new BadRequestException("Invalid Carrier Id");
            } else {
                consignor.getCarriers().add(optionalCarrier.get());
                return consignorRepository.save(consignor);
            }
        }

    }
/*
    public Consignor deleteRelationByConsignor(String name) {
        System.out.println("name is::" + name);
        return consignorRepositry.deleteByName(name);
    }

    public List<RatedRelationship> setRatedRelationships(Consignor user, List<MovieRequest> movieRequests) {
        List<RatedRelationship> ratedRelationshipList = new ArrayList<>();
        for (MovieRequest movieRequest : movieRequests) {
            Movie movie = new Movie();
            movie.setDirector(movieRequest.getDirector());
            movie.setTitle(movieRequest.getTitle());
            RatedRelationship ratedRelationship = new RatedRelationship();
            ratedRelationship.setMovie(movie);
            ratedRelationship.setRating(movieRequest.getRating());
            ratedRelationshipList.add(ratedRelationship);
        }
        return ratedRelationshipList;
    }

    @Override
    public Consignor addMovie(String userName, List<MovieRequest> movieRequestList) {
        Consignor user = consignorRepositry.findOneByName(userName);
        System.out.println("u name::" + user.getName());
        List<RatedRelationship> ratedRelationshipList = setRatedRelationships(user, movieRequestList);
        user.setRatedRelationships(ratedRelationshipList);
        return consignorRepositry.save(user);
    }*/
}
