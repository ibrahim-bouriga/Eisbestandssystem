package com.kfru.Repository;

import com.kfru.Model.Foo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FooRepository {
    private final Map<Long, Foo> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Foo save(Foo foo) {
        if (foo.getId() == null) {
            foo.setId(idGenerator.getAndIncrement());
        }
        storage.put(foo.getId(), foo);
        return foo;
    }

    public Optional<Foo> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Foo> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

    public boolean existsById(Long id) {
        return storage.containsKey(id);
    }
}
