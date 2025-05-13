/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB2.Konstruktor;

/**
 *
 * @author Cloud
 */
// File: MainGym.java
public class MainGym {
    public static void main(String[] args) {
        // Objek dengan konstruktor default
        GymMember member1 = new GymMember();

        // Objek dengan konstruktor berparameter
        GymMember member2 = new GymMember("Aditya", 25, "Weight Training");

        // Tampilkan data anggota gym
        System.out.println("== Data Anggota Gym ==");
        member1.tampilkanData();
        member2.tampilkanData();
    }
}
