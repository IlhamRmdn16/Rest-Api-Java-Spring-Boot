package com.ilham.tes_msib.models.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyek")
public class Proyek implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama_proyek;
    private String client;
    private LocalDateTime tgl_mulai;
    private LocalDateTime tgl_selesai;
    private String pimpinan_proyek;
    private String keterangan;
    private Timestamp created_at;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "proyek_lokasi",
        joinColumns = @JoinColumn(name = "proyek_id"),
        inverseJoinColumns = @JoinColumn(name = "lokasi_id")
    )
    private List<Lokasi> lokasiList;

    @PrePersist
    protected void onCreate() {
        this.created_at = new Timestamp(System.currentTimeMillis());
    }

    public Proyek() {
    }

    public Proyek(Long id, String nama_proyek, String client, LocalDateTime tgl_mulai, LocalDateTime tgl_selesai,
            String pimpinan_proyek, String keterangan, Timestamp created_at, List<Lokasi> lokasiList) {
        this.id = id;
        this.nama_proyek = nama_proyek;
        this.client = client;
        this.tgl_mulai = tgl_mulai;
        this.tgl_selesai = tgl_selesai;
        this.pimpinan_proyek = pimpinan_proyek;
        this.keterangan = keterangan;
        this.created_at = created_at;
        this.lokasiList = lokasiList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama_proyek() {
        return nama_proyek;
    }

    public void setNama_proyek(String nama_proyek) {
        this.nama_proyek = nama_proyek;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDateTime getTgl_mulai() {
        return tgl_mulai;
    }

    public void setTgl_mulai(LocalDateTime tgl_mulai) {
        this.tgl_mulai = tgl_mulai;
    }

    public LocalDateTime getTgl_selesai() {
        return tgl_selesai;
    }

    public void setTgl_selesai(LocalDateTime tgl_selesai) {
        this.tgl_selesai = tgl_selesai;
    }

    public String getPimpinan_proyek() {
        return pimpinan_proyek;
    }

    public void setPimpinan_proyek(String pimpinan_proyek) {
        this.pimpinan_proyek = pimpinan_proyek;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public List<Lokasi> getLokasiList() {
        return lokasiList;
    }

    public void setLokasiList(List<Lokasi> lokasiList) {
        this.lokasiList = lokasiList;
    }
}
