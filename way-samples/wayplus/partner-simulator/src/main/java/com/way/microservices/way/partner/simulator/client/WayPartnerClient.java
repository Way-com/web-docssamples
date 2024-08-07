package com.way.microservices.way.partner.simulator.client;

import com.way.microservices.way.partner.simulator.dto.PartnerSessionRequestDto;
import com.way.microservices.way.partner.simulator.dto.PartnerSessionResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "wayPartnerClient", url = "${way.base.url}/way-orders")
public interface WayPartnerClient {

    @PostMapping("/v1/public/wayplus/vendors/session-token")
    ResponseEntity<PartnerSessionResponseDto> createPartnerSession(@RequestBody PartnerSessionRequestDto partnerSessionRequestDto,
                                                                  @RequestHeader("Authorization") String authorization , @RequestHeader("User-Agent") String userAgent);
}
