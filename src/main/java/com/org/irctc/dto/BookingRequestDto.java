package com.org.irctc.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDto {
    private String trainId;
    private String seatId;
    private String userId;
}
