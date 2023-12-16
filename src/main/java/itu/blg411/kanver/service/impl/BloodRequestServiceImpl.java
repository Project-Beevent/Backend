package itu.blg411.kanver.service.impl;

import itu.blg411.kanver.dto.BloodRequestDto;
import itu.blg411.kanver.entity.BloodRequest;
import itu.blg411.kanver.repository.BloodRequestRepository;
import itu.blg411.kanver.service.BloodRequestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BloodRequestServiceImpl implements BloodRequestService {

    private final BloodRequestRepository bloodRequestRepository;

    @Autowired
    public BloodRequestServiceImpl(BloodRequestRepository bloodRequestRepository) {
        this.bloodRequestRepository = bloodRequestRepository;
    }

    @Override
    public BloodRequestDto findById(Long id) {
        BloodRequest bloodRequest = this.bloodRequestRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "BloodRequest not found with id: " + id));

        return new BloodRequestDto(bloodRequest);
    }

    @Override
    public List<BloodRequestDto> findAll() {
        return this.bloodRequestRepository
                .findAll()
                .stream()
                .map(BloodRequestDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public BloodRequestDto save(BloodRequestDto bloodRequestDto) {
        BloodRequest bloodRequest = this.dtoToEntity(bloodRequestDto);
        BloodRequest savedBloodRequest = this.bloodRequestRepository.save(bloodRequest);
        return new BloodRequestDto(savedBloodRequest);
    }

    @Override
    public void deleteById(Long id) {
        this.bloodRequestRepository.deleteById(id);
    }

    private BloodRequest dtoToEntity(BloodRequestDto bloodRequestDto) {
        BloodRequest bloodRequest = new BloodRequest();
        BeanUtils.copyProperties(bloodRequestDto, bloodRequest);
        return bloodRequest;
    }
}
