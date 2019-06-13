package net.stevenking.apartment.service;

import net.stevenking.apartment.data.Apartment;
import net.stevenking.apartment.repository.ApartmentRepository;
import net.stevenking.config.ApartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService {

    @Autowired
    ApartmentRepository apartmentRepository;

    public List<String> getAllApartmentCompanies() {
        return apartmentRepository.findDistinctCompany();
    }

    public Apartment getApartment(long id) {
        return apartmentRepository.findById(id)
                .orElseThrow(() -> new ApartmentNotFoundException(id));
    }

    public Apartment createApartment(Apartment apartment) {
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
