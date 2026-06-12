package com.kfru.Controllers;

import com.kfru.Model.Standort;
import com.kfru.Services.StandortService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/standorte")
public class StandortController {
    private final StandortService standortService;

    public StandortController(StandortService standortService) {
        this.standortService = standortService;
    }

    @GetMapping
    public ResponseEntity<List<Standort>> getAllStandorte() {
        return ResponseEntity.ok(standortService.getAllStandorte());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Standort> getStandortById(@PathVariable Long id) {
        return standortService.getStandortById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
