package com.way.microservices.way.partner.simulator.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPageController {

    @ApiOperation(value = "Checkout Page", notes = "This url is used to get the checkout page")
    @GetMapping("/checkout")
    public String checkOutPage() {
        return "checkout-page"; // This should match the name of the HTML file in src/main/resources/templates (checkout-page.html)
    }

}
