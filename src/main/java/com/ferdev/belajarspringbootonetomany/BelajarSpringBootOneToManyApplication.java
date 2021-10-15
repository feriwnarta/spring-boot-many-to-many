package com.ferdev.belajarspringbootonetomany;

import com.ferdev.belajarspringbootonetomany.entity.Pembelian;
import com.ferdev.belajarspringbootonetomany.entity.Produk;
import com.ferdev.belajarspringbootonetomany.repository.PembelianRepository;
import com.ferdev.belajarspringbootonetomany.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BelajarSpringBootOneToManyApplication implements CommandLineRunner {
	@Autowired
	PembelianRepository pembelianRepository;
	@Autowired
	ProdukRepository produkRepository;

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringBootOneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Produk produk1 = new Produk("P0001","Sukro",15500L);
		Produk produk2 = new Produk("P0002","Indomie Goreng",3000L);
		Produk produk3 = new Produk("P0003","Indomie Rendang",3500L);

		produkRepository.save(produk1);
		produkRepository.save(produk2);
		produkRepository.save(produk3);


		Pembelian pembelian1 = new Pembelian(6L);
		Pembelian pembelian2 = new Pembelian(10L);
		pembelianRepository.save(pembelian1);
		pembelianRepository.save(pembelian2);

		produk1.getPembelian().add(pembelian1);
		produkRepository.save(produk1);

		produk2.getPembelian().add(pembelian2);
		produk3.getPembelian().add(pembelian2);

		produkRepository.saveAll(Arrays.asList(produk2, produk3));

	}
}
