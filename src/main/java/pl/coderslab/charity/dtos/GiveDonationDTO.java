package pl.coderslab.charity.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.domain.entities.Category;
import pl.coderslab.charity.domain.entities.Institution;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class GiveDonationDTO {

    @NotNull
    private Integer quantity;
    private List<Category> categories;
    private Institution institutions;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank @Min(5) @Max(6)
    private String zipCode;
    @NotBlank @Min(9) @Max(13)
    private String phoneNumber;
    @NotBlank @FutureOrPresent @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotBlank @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;
    private String pickUpComment;

}
