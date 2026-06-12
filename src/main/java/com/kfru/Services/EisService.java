package com.kfru.Services;

import com.kfru.Model.Eis;
import com.kfru.Repository.EisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EisService {
    private final EisRepository eisRepository;

    public EisService(EisRepository eisRepository) {
        this.eisRepository = eisRepository;
    }

    public Eis createEis(Eis eis) {
        return eisRepository.save(eis);
    }

    public Optional<Eis> getEisById(Long id) {
        return eisRepository.findById(id);
    }

    public List<Eis> getAllEis() {
        return eisRepository.findAll();
    }

    public Optional<Eis> updateEis(Long id, Eis updatedEis) {
        if (eisRepository.existsById(id)) {
            updatedEis.setId(id);
            return Optional.of(eisRepository.save(updatedEis));
        }
        return Optional.empty();
    }

    public boolean deleteEis(Long id) {
        if (eisRepository.existsById(id)) {
            eisRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
