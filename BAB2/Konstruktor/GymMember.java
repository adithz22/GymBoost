/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB2.Konstruktor;

/**
 *
 * @author Cloud
 */
// File: GymMember.java
public class GymMember {
    String nama;
    int usia;
    String programLatihan;

    // Konstruktor default
    public GymMember() {
        nama = "Belum diisi";
        usia = 0;
        programLatihan = "Umum";
    }

    // Konstruktor berparameter
    public GymMember(String nama, int usia, String programLatihan) {
        this.nama = nama;
        this.usia = usia;
        this.programLatihan = programLatihan;
    }

    public void tampilkanData() {
        System.out.println("Nama: " + nama);
        System.out.println("Usia: " + usia + " tahun");
        System.out.println("Program Latihan: " + programLatihan);
        System.out.println("----------------------------------");
    }
}
