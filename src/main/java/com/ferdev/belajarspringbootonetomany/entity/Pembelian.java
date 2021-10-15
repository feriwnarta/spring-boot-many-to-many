package com.ferdev.belajarspringbootonetomany.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pembelian {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long quantity;

    @Basic(optional = false)
    // untuk mengisi current time stamp didatabase
    @Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createOrder;

    @ManyToMany(
            mappedBy = "pembelian",
            fetch = FetchType.LAZY
    )
    Set<Produk> produks = new HashSet<>();

    // default constructor
    public Pembelian(){};

    public Pembelian(Long quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Set<Produk> getProduks() {
        return produks;
    }

    public void setProduks(Set<Produk> produks) {
        this.produks = produks;
    }
}
