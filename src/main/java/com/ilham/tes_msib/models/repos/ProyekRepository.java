package com.ilham.tes_msib.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ilham.tes_msib.models.entities.Proyek;

@Repository
public interface ProyekRepository extends JpaRepository<Proyek, Long> {
    
}
