package com.kfru.Repository;

import com.kfru.Model.Standort;
import com.kfru.Model.StandortTyp;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class StandortRepository {
    private final Map<Long, Standort> storage = new ConcurrentHashMap<>();

    public StandortRepository() {
        storage.put(1L, new Standort(1L, "Hauptladen", StandortTyp.LADEN, 100, null));
        storage.put(2L, new Standort(2L, "Zentrallager", StandortTyp.LAGER, 500, 200));
    }

    public Optional<Standort> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Standort> findAll() {
        return new ArrayList<>(storage.values());
    }
}
