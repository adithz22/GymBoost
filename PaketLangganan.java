/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymboots;

/**
 *
 * @author Cloud
 */
public class PaketLangganan {
    private String namaPaket;
    private double harga;
    private int durasi;

    // Constructor Overloading
    public PaketLangganan() {
        this("Basic", 300000, 1);
    }

    public PaketLangganan(String namaPaket) {
        this(namaPaket, 300000, 1);
    }

    public PaketLangganan(String namaPaket, double harga, int durasi) {
        setNamaPaket(namaPaket);
        setHarga(harga);
        setDurasi(durasi);
    }

    // Method untuk menghitung diskon (akan di-override di subclass)
    public double hitungDiskon() {
        return 0;
    }

    // Method untuk menampilkan info (polimorfisme)
    public String getInfo() {
        return String.format("%s - Rp%,.0f (%d bulan)", namaPaket, harga, durasi);
    }

    // Getter & Setter
    public String getNamaPaket() { return namaPaket; }
    public void setNamaPaket(String namaPaket) {
        this.namaPaket = namaPaket.trim();
    }
    
    public double getHarga() { return harga; }
    public void setHarga(double harga) {
        this.harga = harga > 0 ? harga : 300000;
    }
    
    public int getDurasi() { return durasi; }
    public void setDurasi(int durasi) {
        this.durasi = durasi > 0 ? durasi : 1;
    }
}

