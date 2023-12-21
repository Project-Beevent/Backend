package itu.blg411.kanver.bloodRequest.model;

import itu.blg411.kanver.bloodRequest.model.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodRequestRepository extends JpaRepository<BloodRequest, Long> {

    boolean existsByUserIdAndHospitalIdAndStatus(Long userId, Long hospitalId, String status);
    List<BloodRequest> findByUserId(Long userId);

    List<BloodRequest> findByBloodType(String bloodType);
}
