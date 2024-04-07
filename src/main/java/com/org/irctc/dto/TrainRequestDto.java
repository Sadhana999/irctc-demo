package com.org.irctc.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainRequestDto {
    private String trainId;
    private String trainNumber;
    private String trainName;
    private String source;
    private String destination;
}
