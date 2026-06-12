package com.kfru.Controllers;

import com.kfru.Model.Eis;
import com.kfru.Services.EisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eis")
public class EisController {
    private final EisService eisService;

    public EisController(EisService eisService) {
        this.eisService = eisService;
    }

    @GetMapping
    public ResponseEntity<List<Eis>> getAllEis() {
        return ResponseEntity.ok(eisService.getAllEis());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eis> getEisById(@PathVariable Long id) {
        return eisService.getEisById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Eis> createEis(@RequestBody Eis eis) {
        Eis createdEis = eisService.createEis(eis);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEis);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eis> updateEis(@PathVariable Long id, @RequestBody Eis eis) {
        return eisService.updateEis(id, eis)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEis(@PathVariable Long id) {
        if (eisService.deleteEis(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
