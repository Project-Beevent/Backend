package com.SWprj.SWprj.BloodRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/blood_request")
public class BloodRequestController {
    public final BloodRequestService bloodRequestService;

    public BloodRequestController(BloodRequestService bloodRequestService) {
        this.bloodRequestService = bloodRequestService;
    }

    @GetMapping
    public List<BloodRequest> getBloodRequest() {
        return bloodRequestService.getBloodRequest();
    }
}
