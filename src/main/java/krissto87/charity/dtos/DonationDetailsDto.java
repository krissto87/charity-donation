package krissto87.charity.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationDetailsDto {

    private Long id;
    private Integer quantity;
    private List<CategoryDto> categories;
    private InstitutionDto institution;
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
