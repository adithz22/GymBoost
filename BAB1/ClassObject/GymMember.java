/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB1.ClassObject;

/**
 *
 * @author Cloud
 */
// Class GymMember merepresentasikan member dari sebuah pusat kebugaran (Gym)
public class GymMember {
    // Atribut dari member gym
    String nama;
    int usia;
    double beratBadan;
    double tinggiBadan;
    String jenisLatihan;

    // Method untuk mengatur data member
    void setDataMember(String nama, int usia, double berat, double tinggi, String latihan) {
        this.nama = nama;
        this.usia = usia;
        this.beratBadan = berat;
        this.tinggiBadan = tinggi;
        this.jenisLatihan = latihan;
    }

    // Method untuk mencetak informasi member
    void tampilkanInfo() {
        System.out.println("=== Data Member Gym ===");
        System.out.println("Nama            : " + nama);
        System.out.println("Usia            : " + usia + " tahun");
        System.out.println("Berat Badan     : " + beratBadan + " kg");
        System.out.println("Tinggi Badan    : " + tinggiBadan + " cm");
        System.out.println("Jenis Latihan   : " + jenisLatihan);
        System.out.println("========================");
    }

    // Method untuk menghitung indeks massa tubuh (BMI)
    double hitungBMI() {
        double tinggiMeter = tinggiBadan / 100;
        return beratBadan / (tinggiMeter * tinggiMeter);
    }
}
