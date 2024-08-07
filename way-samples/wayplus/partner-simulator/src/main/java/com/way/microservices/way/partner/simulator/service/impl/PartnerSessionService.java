package com.way.microservices.way.partner.simulator.service.impl;

import com.way.microservices.way.partner.simulator.client.WayPartnerClient;
import com.way.microservices.way.partner.simulator.dto.PartnerSessionRequestDto;
import com.way.microservices.way.partner.simulator.dto.PartnerSessionResponseDto;
import com.way.microservices.way.partner.simulator.service.IPartnerSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PartnerSessionService implements IPartnerSessionService {

    private final WayPartnerClient wayPartnerClient;

    @Value("${way.partner.auth}") // This is the WAY API key - the value is stored in the /src/main/resources/application.properties file with the property name way.partner.auth
    private String wayPartnerAuth;

    @Value("${way.partner.user-agent}") // This is the WAY User-Agent - the value is stored in the /src/main/resources/application.properties file with the property name way.partner.user-agent
    private String wayPartnerUserAgent;

    @Override
    public ResponseEntity<PartnerSessionResponseDto> createPartnerSession(String partnerUserId, String email, String fullName, String planId, String planType) {
        ResponseEntity<PartnerSessionResponseDto> response;

        //Construct the request object
        PartnerSessionRequestDto partnerSessionRequestDto = new PartnerSessionRequestDto(planId, planType, partnerUserId, email, fullName);

        //Call the WAY API to get session token (Pass the request body and 2 headers - Authorization and User-Agent)
        response = wayPartnerClient.createPartnerSession(partnerSessionRequestDto, wayPartnerAuth, wayPartnerUserAgent);
        log.info("Response from createPartnerSession: {}", response);

        return response;
    }
}
