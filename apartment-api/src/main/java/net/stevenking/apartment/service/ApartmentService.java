package net.stevenking.apartment.service;

import net.stevenking.apartment.data.Apartment;
import net.stevenking.apartment.data.Company;
import net.stevenking.apartment.data.FloorPlan;
import net.stevenking.apartment.repository.ApartmentRepository;
import net.stevenking.apartment.repository.CompanyRepository;
import net.stevenking.apartment.repository.FloorPlanRepository;
import net.stevenking.config.ApartmentNotFoundException;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    FloorPlanRepository floorPlanRepository;

    @Autowired
    ApartmentRepository apartmentRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<Company> findAllApartmentCompanies() {
        return companyRepository.findAll();
    }

    public List<FloorPlan> findAllApartmentFloorPlans(Long id) {
        return floorPlanRepository.findAllFloorPlanByCompany_Id(id);
    }

    public Apartment createApartment(Apartment apartment) {
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        apartment.setCreatedAt(currentTimestamp);
        return apartmentRepository.save(apartment);
    }

    public Apartment updatePrice(long id, short price) {
        Optional<Apartment> apartmentOptional = apartmentRepository.findById(id);
        if (apartmentOptional.isPresent()) {
            Apartment apartment = apartmentOptional.get();
            apartment.setPrice(price);
            return apartmentRepository.save(apartment);
        }

        return null;
    }

    public boolean deleteApartment(long id) {
        boolean isDeleted = false;
        Optional<Apartment> apartmentOptional = apartmentRepository.findById(id);
        if (apartmentOptional.isPresent()) {
            apartmentRepository.deleteById(id);
            isDeleted = true;
        }

        return isDeleted;
    }

    @ExceptionHandler(ApartmentNotFoundException.class)
    public void handleException(ApartmentNotFoundException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
