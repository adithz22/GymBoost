/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymboots;

import models.interfaces.Payment;

/**
 *
 * @author Cloud
 */
public class AnggotaBiasa extends AnggotaGym implements Membership, Payment, Training {
    private String level;
    private boolean membershipActive;
    private double paymentAmount;
    private boolean trainingStarted;

    public AnggotaBiasa(String nama, String id, String program, int durasi, String level) {
        super(nama, id, program, durasi);
        this.level = level;
        this.membershipActive = true;
    }

    // Implementasi Membership
    @Override
    public void activateMembership() {
        this.membershipActive = true;
    }

    @Override
    public void deactivateMembership() {
        this.membershipActive = false;
    }

    @Override
    public boolean isMembershipActive() {
        return membershipActive;
    }

    // Implementasi Payment
    @Override
    public void processPayment(double amount) {
        this.paymentAmount = amount;
    }

    @Override
    public String getPaymentInfo() {
        return "Pembayaran terakhir: Rp" + paymentAmount + " untuk " + durasi + " bulan";
    }

    // Implementasi Training
    @Override
    public void startTraining() {
        trainingStarted = true;
    }

    @Override
    public void endTraining() {
        trainingStarted = false;
    }

    @Override
    public String getTrainingSchedule() {
        return "Senin, Rabu, Jumat pukul 07:00 - 08:30";
    }

    // Override dari AnggotaGym
    @Override
    public void perpanjangMembership() {
        this.durasi += 1;
    }

    @Override
    public String getRole() {
        return "Anggota Biasa";
    }

    @Override
    public String toString() {
        return "ID: " + getId() +
               ", Nama: " + getNama() +
               ", Program: " + getProgram() +
               ", Durasi: " + getDurasi() + " bulan" +
               ", Level: " + level;
    }
}
