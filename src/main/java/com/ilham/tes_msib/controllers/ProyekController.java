package com.ilham.tes_msib.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilham.tes_msib.models.entities.Proyek;
import com.ilham.tes_msib.services.ProyekService;

@RestController
@RequestMapping("/api/proyek")
public class ProyekController {
    
    @Autowired
    private ProyekService proyekService;

    @PostMapping
    public ResponseEntity<Proyek> createProyek(@RequestBody Proyek proyek) {
        Proyek newProyek = proyekService.createProyek(proyek);
        return new ResponseEntity<>(newProyek, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Proyek>> getAllProyek() {
        List<Proyek> proyekList = proyekService.getAllProyek();
        return new ResponseEntity<>(proyekList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable Long id, @RequestBody Proyek proyek) {
        Proyek updatedProyek = proyekService.updateProyek(id, proyek);
        return new ResponseEntity<>(updatedProyek, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyek(@PathVariable Long id) {
        proyekService.deleteProyek(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
