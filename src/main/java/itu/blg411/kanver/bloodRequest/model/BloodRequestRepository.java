package itu.blg411.kanver.bloodRequest.model;

import itu.blg411.kanver.bloodRequest.model.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRequestRepository extends JpaRepository<BloodRequest, Long> {

}
