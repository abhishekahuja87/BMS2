package com.abhishek.bookmyshow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScreenDto {
    private Long screenId;
    private String screenName;
    private Double ticketPrice;
    private List<LocalDateTime> showtimes;
}
