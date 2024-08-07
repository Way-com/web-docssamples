package com.way.microservices.way.partner.simulator.service;

import com.way.microservices.way.partner.simulator.dto.PartnerSessionResponseDto;
import org.springframework.http.ResponseEntity;

public interface IPartnerSessionService {

    ResponseEntity<PartnerSessionResponseDto> createPartnerSession(String partnerUserId, String email, String fullName, String planId, String planType);

}
