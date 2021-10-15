package com.ferdev.belajarspringbootonetomany.repository;

import com.ferdev.belajarspringbootonetomany.entity.Pembelian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PembelianRepository extends JpaRepository<Pembelian, Long> {
}
