package net.stevenking.apartment.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRICE_HISTORY")
public class PriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name="PRICE")
    public long price;

    @Column(name = "DATE")
    public Date date;

    @Column(name = "APARTMENT_FK")
    public long apartment_Fk;
}
