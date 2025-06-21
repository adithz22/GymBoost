/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymboots;

import models.interfaces.Payment;
import models.Person;

/**
 *
 * @author Cloud
 */
public class Pelatih extends Person implements Payment, Training {
    private String program;
    private double gaji;
    private boolean inTrainingSession;
    
    public Pelatih(String nama, String id, String program, double gaji) {
        super(nama, id);
        this.program = program;
        this.gaji = gaji;
        this.inTrainingSession = false;
    }
    
    // Implementasi Payment
    @Override
    public void processPayment(double amount) {
        this.gaji = amount;
    }
    
    @Override
    public String getPaymentInfo() {
        return "Gaji pelatih: Rp" + gaji + " per bulan";
    }
    
    // Implementasi Training
    @Override
    public void startTraining() {
        this.inTrainingSession = true;
    }
    
    @Override
    public void endTraining() {
        this.inTrainingSession = false;
    }
    
    @Override
    public String getTrainingSchedule() {
        return "Jadwal pelatihan " + getNama() + ": " + program + " (Senin-Jumat)";
    }
    
    // Getter untuk inTrainingSession
    public boolean isInTrainingSession() {
        return inTrainingSession;
    }
    
    // Getter untuk program
    public String getProgram() {
        return program;
    }
    
    // Method lainnya
    @Override
    public String getRole() {
        return "Pelatih";
    }
    
    public void setDurasi(int durasi) {
        // Implementasi jika diperlukan
    }
    
    @Override
    public String toString() {
        return "ID: " + getId() + ", Nama: " + getNama() + ", Program: " + program + ", Gaji: Rp" + gaji;
    }
}