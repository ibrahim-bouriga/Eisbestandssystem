package com.kfru.Services;

import com.kfru.Model.Foo;
import com.kfru.Repository.FooRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FooService {
    private final FooRepository fooRepository;

    public FooService(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    public Foo createFoo(Foo foo) {
        return fooRepository.save(foo);
    }

    public Optional<Foo> getFooById(Long id) {
        return fooRepository.findById(id);
    }

    public List<Foo> getAllFoos() {
        return fooRepository.findAll();
    }

    public Optional<Foo> updateFoo(Long id, Foo updatedFoo) {
        if (fooRepository.existsById(id)) {
            updatedFoo.setId(id);
            return Optional.of(fooRepository.save(updatedFoo));
        }
        return Optional.empty();
    }

    public boolean deleteFoo(Long id) {
        if (fooRepository.existsById(id)) {
            fooRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
