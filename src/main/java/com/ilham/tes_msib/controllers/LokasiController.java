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

import com.ilham.tes_msib.models.entities.Lokasi;
import com.ilham.tes_msib.services.LokasiService;

@RestController
@RequestMapping("/api/lokasi")
public class LokasiController {
    @Autowired
    private LokasiService lokasiService;

    @PostMapping
    public ResponseEntity<Lokasi> createLokasi(@RequestBody Lokasi lokasi) {
        Lokasi newLokasi = lokasiService.createLokasi(lokasi);
        return new ResponseEntity<>(newLokasi, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Lokasi>> getAllLokasi() {
        List<Lokasi> lokasiList = lokasiService.getAllLokasi();
        return new ResponseEntity<>(lokasiList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lokasi> updateLokasi(@PathVariable Long id, @RequestBody Lokasi lokasi) {
        Lokasi updatedLokasi = lokasiService.updateLokasi(id, lokasi);
        return new ResponseEntity<>(updatedLokasi, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLokasi(@PathVariable Long id) {
        lokasiService.deleteLokasi(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
