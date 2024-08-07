package com.way.microservices.way.partner.simulator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerSessionRequestDto {

    private String planId;
    private String planType;
    private String partnerUserId;
    private String email;
    private String fullName;

}
