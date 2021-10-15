package com.ferdev.belajarspringbootonetomany.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Produk {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String kode;
    @Column(nullable = false)
    private String nama;
    @Column(nullable = false)
    private Long harga;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    @JoinTable(
            name = "pembelian_detail",
            joinColumns = {
                    @JoinColumn(name = "produk.id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "pembelian.id", referencedColumnName = "id",
                            nullable = false, updatable = false
                    )
            }
    )
    private Set<Pembelian> pembelian = new HashSet<>();

    // default construtor
    public Produk(){}

    public Produk(String kode, String nama, Long harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public Set<Pembelian> getPembelian() {
        return pembelian;
    }

    public void setPembelian(Set<Pembelian> pembelian) {
        this.pembelian = pembelian;
    }
}
