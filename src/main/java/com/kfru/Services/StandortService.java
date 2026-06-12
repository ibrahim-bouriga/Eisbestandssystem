package com.kfru.Services;

import com.kfru.Model.Standort;
import com.kfru.Repository.StandortRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandortService {
    private final StandortRepository standortRepository;

    public StandortService(StandortRepository standortRepository) {
        this.standortRepository = standortRepository;
    }

    public List<Standort> getAllStandorte() {
        return standortRepository.findAll();
    }

    public Optional<Standort> getStandortById(Long id) {
        return standortRepository.findById(id);
    }
}
