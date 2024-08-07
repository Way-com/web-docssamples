package com.way.microservices.way.partner.simulator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerSessionResponseDto {

    String apiStatus;
    String message;
    String token;
}
