package krissto87.charity.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourierStatusDTO {

    private Long id;
    private Boolean delivered;
    private LocalDateTime deliverTime;
}
