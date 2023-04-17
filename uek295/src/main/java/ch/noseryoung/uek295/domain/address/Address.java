package ch.noseryoung.uek295.domain.address;


import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor

@Table(name = "address")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adress_id")
    private Integer adressId;


    @Column(name = "country")
    @NotBlank(message = "Country must not be empty.")
    private String country;

    @Column(name = "plz")
    @NotBlank(message = "PLZ must not be empty.")
    private String plz;


    @Column(name = "street")
    @NotBlank(message = "Street must not be empty.")
    private String street;
}