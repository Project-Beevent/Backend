package itu.blg411.kanver.bloodRequest.controller;

import itu.blg411.kanver.bloodRequest.BloodRequestService;
import itu.blg411.kanver.bloodRequest.model.BloodRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blood_requests")
@RequiredArgsConstructor
public class BloodRequestController {

    private final BloodRequestService bloodRequestService;

    @PostMapping("/users/{userId}/hospitals/{hospitalId}")
    public ResponseEntity<BloodRequest> createBloodRequest(@PathVariable Long userId,
                                                           @PathVariable Long hospitalId,
                                                           @RequestBody BloodRequest newBloodRequest) {
        BloodRequest createdBloodRequest = bloodRequestService.createBloodRequest(userId, hospitalId, newBloodRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBloodRequest);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<BloodRequest>> getBloodRequestsByUserId(@PathVariable Long userId) {
        List<BloodRequest> bloodRequests = bloodRequestService.getBloodRequestsByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(bloodRequests);
    }
    @GetMapping
    public ResponseEntity<List<BloodRequest>> getAllBloodRequests() {
        List<BloodRequest> bloodRequests = bloodRequestService.getAllBloodRequests();
        return ResponseEntity.status(HttpStatus.OK).body(bloodRequests);
    }

    @PutMapping("/{requestId}")
    public ResponseEntity<BloodRequest> updateBloodRequest(@PathVariable Long requestId, @RequestBody BloodRequest updatedBloodRequest) {
        BloodRequest updated =  bloodRequestService.updateBloodRequest(requestId, updatedBloodRequest);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
    @DeleteMapping("/{requestId}")
    public ResponseEntity<String> deleteBloodRequestById(@PathVariable Long requestId) {
        bloodRequestService.deleteBloodRequestById(requestId);
        return ResponseEntity.status(HttpStatus.OK).body("The blood request is deleted successfully");
    }

    @GetMapping("/filter/{blood_type}")
    public ResponseEntity<List<BloodRequest>> getBloodRequestsByBloodType(@PathVariable String blood_type) {
        List<BloodRequest> bloodRequests = bloodRequestService.getBloodRequestsByBloodType(blood_type);
        return ResponseEntity.status(HttpStatus.OK).body(bloodRequests);
    }

//    @GetMapping("/filter")
//    public ResponseEntity<List<BloodRequest>> getBloodRequestsByBloodType(@RequestParam String blood_type) {
//        List<BloodRequest> bloodRequests = bloodRequestService.getBloodRequestsByBloodType(blood_type);
//        return ResponseEntity.status(HttpStatus.OK).body(bloodRequests);
//    }

}
