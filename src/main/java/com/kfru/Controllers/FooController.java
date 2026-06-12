package com.kfru.Controllers;

import com.kfru.Model.Foo;
import com.kfru.Services.FooService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foos")
public class FooController {
    private final FooService fooService;

    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    @GetMapping
    public ResponseEntity<List<Foo>> getAllFoos() {
        return ResponseEntity.ok(fooService.getAllFoos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foo> getFooById(@PathVariable Long id) {
        return fooService.getFooById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Foo> createFoo(@RequestBody Foo foo) {
        Foo createdFoo = fooService.createFoo(foo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFoo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Foo> updateFoo(@PathVariable Long id, @RequestBody Foo foo) {
        return fooService.updateFoo(id, foo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoo(@PathVariable Long id) {
        if (fooService.deleteFoo(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
