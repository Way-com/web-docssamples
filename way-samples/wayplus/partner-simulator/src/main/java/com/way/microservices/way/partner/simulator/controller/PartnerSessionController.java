package com.way.microservices.way.partner.simulator.controller;

import com.way.microservices.way.partner.simulator.dto.PartnerSessionResponseDto;
import com.way.microservices.way.partner.simulator.service.IPartnerSessionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/partner/session")
@RequiredArgsConstructor
@Slf4j
public class PartnerSessionController {

    private final IPartnerSessionService partnerSessionService;

    @ApiOperation(value = "Get Partner Session Token", notes = "This endpoint is used to get the partner session token")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Session token created successfully", response = PartnerSessionResponseDto.class)})
    @GetMapping()
    public ResponseEntity<PartnerSessionResponseDto> partnerSessionPage(@ApiParam(value = "Partner User Id") @RequestParam(name = "partnerUserId") String partnerUserId,
                                                                        @ApiParam(value = "Email") @RequestParam(name = "email") String email,
                                                                        @ApiParam(value = "Full Name") @RequestParam(name = "fullName") String fullName,
                                                                        @ApiParam(value = "Plan Id selected by the user") @RequestParam(name = "planId") String planId,
                                                                        @ApiParam(value = "Plan Type of the selected plan") @RequestParam(name = "planType") String planType) {
        ResponseEntity<PartnerSessionResponseDto> response = null;
        try {
            response = partnerSessionService.createPartnerSession(partnerUserId, email, fullName, planId, planType);
        } catch (Exception e) {
            log.error("Error while creating partner session: {}", e.getMessage());
        }
        return response;
    }
}
