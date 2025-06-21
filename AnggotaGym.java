/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymboots;

import models.Person;

/**
 *
 * @author Cloud
 */
public abstract class AnggotaGym extends Person {
    protected String program;
    protected int durasi;

    // Constructor overloading
    public AnggotaGym() {
        this("Belum diisi", "GYM000", "Basic", 1);
    }

    public AnggotaGym(String nama, String id) {
        this(nama, id, "Basic", 1);
    }

    public AnggotaGym(String nama, String id, String program, int durasi) {
        super(nama, id); // Panggil constructor milik Person
        this.program = program;
        this.durasi = durasi > 0 ? durasi : 1;
    }

    // Abstract method: wajib diimplementasikan di subclass
    public abstract void perpanjangMembership();

    // Overloaded method
    public void perpanjangMembership(int bulan) {
        this.durasi += (bulan > 0 ? bulan : 1);
    }

    // Getter & Setter
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi > 0 ? durasi : 1;
    }

    // Method umum untuk info
    public String getInfoAnggota() {
        return "Nama: " + getNama() +
               "\nID: " + getId() +
               "\nProgram: " + program +
               "\nDurasi: " + durasi + " bulan";
    }
}


