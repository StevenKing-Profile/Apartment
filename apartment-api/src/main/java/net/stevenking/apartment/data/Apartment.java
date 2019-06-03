package net.stevenking.apartment.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "APARTMENT")
public class Apartment {
    @EmbeddedId
    private ApartmentKey apartmentKey;

    private long sqft;
    private short price;

    @ManyToOne
    private Address address;
}
