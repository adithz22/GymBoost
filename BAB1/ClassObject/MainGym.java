/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB1.ClassObject;

/**
 *
 * @author Cloud
 */
// Driver class untuk menjalankan program utama GymMember
public class MainGym {
    public static void main(String[] args) {
        // Membuat objek gymMember dari class GymMember
        GymMember gymMember = new GymMember();

        // Mengisi data anggota gym
        gymMember.setNama("Aditya Surya Pratama");
        gymMember.setJenisKelamin("Laki-laki");
        gymMember.setProgramLatihan("Cardio dan Weightlifting");
        gymMember.setUsia(20);

        // Menampilkan data anggota gym
        System.out.println("===== Data Anggota Gym =====");
        System.out.println("Nama            : " + gymMember.getNama());
        System.out.println("Jenis Kelamin   : " + gymMember.getJenisKelamin());
        System.out.println("Usia            : " + gymMember.getUsia() + " tahun");
        System.out.println("Program Latihan : " + gymMember.getProgramLatihan());
        System.out.println();

        // Menampilkan aktivitas latihan
        gymMember.mulaiLatihan();
        gymMember.istirahat();
    }
}
