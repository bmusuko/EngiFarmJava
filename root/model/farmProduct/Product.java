package model.farmProduct;

/**
 * @Kelas Product
 */

import java.util.*;

public class Product {
    protected int harga;

    public Product(int harga) {
        /**
         * Konstruktor untuk product, meminta 2 parameter harga dan code nama
         */
        assert (harga > 0);
        this.harga = harga;
    }

    public int getHarga() {
        /**
         * Method untuk return harga
         */

        return this.harga;
    }
}
