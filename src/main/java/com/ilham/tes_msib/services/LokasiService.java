package com.ilham.tes_msib.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilham.tes_msib.models.entities.Lokasi;
import com.ilham.tes_msib.models.repos.LokasiRepository;

@Service
public class LokasiService {
    
    @Autowired
    private LokasiRepository lokasiRepository;

    public Lokasi createLokasi(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    public Lokasi updateLokasi(Long id, Lokasi lokasi) {
        Lokasi existingLokasi = lokasiRepository.findById(id).orElseThrow(() -> new RuntimeException("Lokasi not found"));
        existingLokasi.setNama_lokasi(lokasi.getNama_lokasi());
        existingLokasi.setNegara(lokasi.getNegara());
        existingLokasi.setProvinsi(lokasi.getProvinsi());
        existingLokasi.setKota(lokasi.getKota());
        // existingLokasi.setCreated_at(lokasi.getCreated_at());
        return lokasiRepository.save(existingLokasi);
    }

    public void deleteLokasi(Long id) {
        lokasiRepository.deleteById(id);
    }
}
