package com.ferdev.belajarspringbootonetomany.repository;

import com.ferdev.belajarspringbootonetomany.entity.Produk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdukRepository extends JpaRepository<Produk, Long> {
}
