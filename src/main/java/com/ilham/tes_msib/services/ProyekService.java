package com.ilham.tes_msib.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilham.tes_msib.models.entities.Lokasi;
import com.ilham.tes_msib.models.entities.Proyek;
import com.ilham.tes_msib.models.repos.LokasiRepository;
import com.ilham.tes_msib.models.repos.ProyekRepository;

@Service
public class ProyekService {
    
    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private LokasiRepository lokasiRepository;

    public Proyek createProyek(Proyek proyek) {
        List<Lokasi> lokasiList = proyek.getLokasiList();
        if (lokasiList != null) {
            for (int i = 0; i < lokasiList.size(); i++) {
                Lokasi lokasi = lokasiRepository.findById(lokasiList.get(i).getId())
                            .orElseThrow(() -> new RuntimeException("Lokasi not found"));
                lokasiList.set(i, lokasi);
            }
        }
        proyek.setLokasiList(lokasiList);
        return proyekRepository.save(proyek);
    }

    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    public Proyek updateProyek(Long id, Proyek proyek) {
        Proyek existingProyek = proyekRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyek not found"));

        existingProyek.setNama_proyek(proyek.getNama_proyek());
        existingProyek.setClient(proyek.getClient());
        existingProyek.setTgl_mulai(proyek.getTgl_mulai());
        existingProyek.setTgl_selesai(proyek.getTgl_selesai());
        existingProyek.setPimpinan_proyek(proyek.getPimpinan_proyek());
        existingProyek.setKeterangan(proyek.getKeterangan());

        if (proyek.getLokasiList() != null) {
            for (Lokasi lokasi : proyek.getLokasiList()) {
                if (lokasi.getId() != null) {
                    if (lokasiRepository.existsById(lokasi.getId())) {
                        lokasi = lokasiRepository.findById(lokasi.getId()).get();
                    } else {
                        throw new RuntimeException("Lokasi with ID " + lokasi.getId() + " not found");
                    }
                }
            }
            existingProyek.setLokasiList(proyek.getLokasiList());
        }

        return proyekRepository.save(existingProyek);
    }

    public void deleteProyek(Long id) {
        proyekRepository.deleteById(id);
    }
}
