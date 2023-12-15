package com.SWprj.SWprj.BloodRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodRequestService {

    private final BloodRequestRepository bloodRequestRepository;

    @Autowired
    public BloodRequestService(BloodRequestRepository bloodRequestRepository) {
        this.bloodRequestRepository = bloodRequestRepository;
    }

    public List<BloodRequest> getBloodRequest() {
        return bloodRequestRepository.findAll();
    }
}
