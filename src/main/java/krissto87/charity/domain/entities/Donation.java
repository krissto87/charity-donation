package krissto87.charity.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "donations")
@Getter @Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer quantity;
    @ManyToMany
    private List<Category> categories = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "institution_id", nullable = false)
    private Institution institution;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String city;
    @Column(name = "zip_code", nullable = false)
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="pick_up_date", nullable = false)
    private LocalDate pickUpDate;
    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "pick_up_time", nullable = false)
    private LocalTime pickUpTime;
    @Column(name = "pick_up_comment")
    private String pickUpComment;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private User donor;
    private Boolean delivered;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "create_time")
    private LocalDateTime createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "deliver_time")
    private LocalDateTime deliverTime;

}
