package com.abhishek.bookmyshow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TheatreDto {
    private Long theatreId;
    private String theatreName;
    List<ScreenDto> screens;
}
