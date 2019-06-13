package net.stevenking.apartment.controller;

import lombok.extern.slf4j.Slf4j;
import net.stevenking.apartment.data.Apartment;
import net.stevenking.apartment.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/apartment")
public class ApartmentController {

    @Autowired
    ApartmentService apartmentService;

    @GetMapping(path="/{id}")
    public Apartment getApartment(@PathVariable Long id) {
        return apartmentService.getApartment(id);
    }

    @GetMapping(path="/list")
    public ResponseEntity getAllApartmentCompanies() {
        List<String> apartmentList = apartmentService.getAllApartmentCompanies();
        if (apartmentList == null)
            return new ResponseEntity<>("Error retrieving apartment list", HttpStatus.NO_CONTENT);
        return new ResponseEntity(apartmentList, HttpStatus.OK);
    }

    @PostMapping(path="/create")
    public ResponseEntity createApartment(@RequestBody Resource<Apartment> apartmentResource) {
        Apartment apartment = apartmentResource.getContent();
        return new ResponseEntity<>(apartmentService.createApartment(apartment), HttpStatus.CREATED);
    }

    @PutMapping(path="/{id}/edit")
    public ResponseEntity updatePrice(@PathVariable Long id, @RequestParam Short price) {
        Apartment apartment = apartmentService.updatePrice(id, price);
        if (apartment == null)
            return new ResponseEntity<>("Error updating apartment list", HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(apartmentService.updatePrice(id, price), HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity deleteApartment(@PathVariable Long id) {
        if (apartmentService.deleteApartment(id))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
