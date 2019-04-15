package src.Product;
/**
 * @Kelas Product
 */

import java.util.*;

public class Product {
    protected int harga;
    protected String code;

    public Product(int harga, String code) {
        /**
         * Konstruktor untuk product, meminta 2 parameter harga dan code nama
         */
        this.code = code;
        assert (harga > 0);
        this.harga = harga; 
    }

    public int getHarga() {
        /**
         * Method untuk return harga
         */

        return this.harga;
    }

    // public void setHarga() {
    //     /**
    //      * Setter harga dari product
    //      */
    //     this.harga = harga;
    // }

    public String getCode() {
        /**
         * Getter untuk mendapatkan code dari product
         */
        return this.code;
    }
}
