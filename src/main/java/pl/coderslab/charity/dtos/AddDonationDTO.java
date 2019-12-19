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
public class AddDonationDTO {

    @NotNull @Min(1)
    private Integer quantity;
    @NotNull
    private List<Category> categories;
    @NotNull
    private Institution institution;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank @Min(5) @Max(6)
    private String zipCode;
    @NotBlank @Min(9) @Max(13)
    private String phoneNumber;
    @NotNull @FutureOrPresent @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotNull @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;
    private String pickUpComment;

}
