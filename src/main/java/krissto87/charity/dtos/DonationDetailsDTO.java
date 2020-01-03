package krissto87.charity.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationDetailsDTO {

    private Long id;
    private Integer quantity;
    private List<CategoryDTO> categories;
    private InstitutionDTO institution;
    private String street;
    private String city;
    private String zipCode;
    private String phoneNumber;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
    private Boolean delivered;
    private LocalDateTime createTime;
    private LocalDateTime deliverTime;
}
