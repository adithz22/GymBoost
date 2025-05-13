/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB1.ClassObject;

/**
 *
 * @author Cloud
 */
// Class GymMember merepresentasikan anggota gym beserta data dan kegiatannya
public class GymMember {
    // Atribut dari anggota gym
    String nama, jenisKelamin, programLatihan;
    int usia;

    // Method untuk mengisi data anggota
    void setNama(String nama) {
        this.nama = nama;
    }

    void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    void setProgramLatihan(String programLatihan) {
        this.programLatihan = programLatihan;
    }

    void setUsia(int usia) {
        this.usia = usia;
    }

    // Method untuk mencetak data anggota gym
    String getNama() {
        return nama;
    }

    String getJenisKelamin() {
        return jenisKelamin;
    }

    String getProgramLatihan() {
        return programLatihan;
    }

    int getUsia() {
        return usia;
    }

    // Method tambahan untuk menampilkan aktivitas latihan
    void mulaiLatihan() {
        System.out.println(nama + " memulai program latihan: " + programLatihan);
    }

    void istirahat() {
        System.out.println(nama + " sedang beristirahat setelah latihan.");
    }
}
