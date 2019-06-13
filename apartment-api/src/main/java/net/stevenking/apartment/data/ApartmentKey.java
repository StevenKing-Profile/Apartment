package net.stevenking.apartment.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ApartmentKey implements Serializable {
    @Size(max = 10)
    @Column(nullable = false)
    private String company;

    @Size(max=12)
    @Column(nullable = false)
    private String name;
}
