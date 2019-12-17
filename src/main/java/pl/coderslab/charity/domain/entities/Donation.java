package pl.coderslab.charity.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table (name = "donations")
@Getter @Setter
@EqualsAndHashCode(of = "id")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer quantity;
    @ManyToMany
    private List<Category> categories;
    @ManyToOne
    @JoinColumn(name = "institution_id", nullable = false)
    private Institution institution;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String zipCode;
    @Column(nullable = false)
    private LocalDate pickUpDate;
    @Column(nullable = false)
    private LocalTime pickUpTime;
    private String pickUpComment;

}
