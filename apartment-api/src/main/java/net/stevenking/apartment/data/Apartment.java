package net.stevenking.apartment.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name = "APARTMENT")
public class Apartment extends AuditModel {
    @EmbeddedId
    private ApartmentKey apartmentKey;

    @Column(nullable = true)
    private Integer zpId;
    private Short sqFt;
    private Short price;

    @ManyToOne
    private Address address;
}
