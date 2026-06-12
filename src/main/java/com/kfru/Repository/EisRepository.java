package com.kfru.Repository;

import com.kfru.Model.Eis;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EisRepository {
    private final Map<Long, Eis> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Eis save(Eis eis) {
        if (eis.getId() == null) {
            eis.setId(idGenerator.getAndIncrement());
        }
        storage.put(eis.getId(), eis);
        return eis;
    }

    public Optional<Eis> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Eis> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

    public boolean existsById(Long id) {
        return storage.containsKey(id);
    }
}
