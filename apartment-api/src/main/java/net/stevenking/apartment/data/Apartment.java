package net.stevenking.apartment.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "APARTMENT")
public class Apartment {
    @EmbeddedId
    private ApartmentKey apartmentKey;

    @Column(nullable = true)
    private Integer zpId;
    private Short sqFt;
    private Short price;

    @ManyToOne
    private Address address;
}
