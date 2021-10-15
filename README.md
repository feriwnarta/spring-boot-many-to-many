# Join Sql Many To Many
    ```sql 
        select produk.id, produk.kode, produk.nama, pembelian.create_order, pembelian.quantity
        from produk
        inner join pembelian_detail on produk.id = pembelian_detail.produk_id
        inner join pembelian on pembelian.id = pembelian_detail.pembelian_id;
    ```
