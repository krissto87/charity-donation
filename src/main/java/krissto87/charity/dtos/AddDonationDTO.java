package krissto87.charity.dtos;

import krissto87.charity.domain.entities.Category;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import krissto87.charity.domain.entities.Institution;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class AddDonationDTO {

    @NotNull @Min(1)
    private Integer quantity;
    @NotNull
    private List<Category> categories; //lista obiektow kageorii dto, moze starczy tylko id? lista longow a pole cagetogiresId
    @NotNull
    private Institution institution; // zamiast instytucja to long i instytution id
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

}
