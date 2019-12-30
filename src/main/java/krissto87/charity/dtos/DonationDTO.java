package krissto87.charity.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationDTO {

    @NotNull @Min(1)
    private Integer quantity;
    @NotNull
    private List<Long> categoriesId;
    @NotNull
    private Long institutionId;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String zipCode;
    @NotBlank
    private String phoneNumber;
    @NotNull @FutureOrPresent @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotNull @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;
    private String pickUpComment;

    private Boolean delivered;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createTime;

}
