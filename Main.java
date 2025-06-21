/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymboots;

/**
 *
 * @author Cloud
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEM MANAJEMEN GYM BOOTS ===");
        
        // Membuat beberapa anggota gym
        AnggotaBiasa anggota1 = new AnggotaBiasa("Dina", "GYM101", "Yoga", 3, "Beginner");
        AnggotaBiasa anggota2 = new AnggotaBiasa("Rudi", "GYM102", "Weight Lifting", 6, "Intermediate");
        
        // Membuat pelatih
        Pelatih pelatih1 = new Pelatih("Budi Santoso", "TRN201", "Yoga", 5000000);
        Pelatih pelatih2 = new Pelatih("Ani Wijaya", "TRN202", "Weight Lifting", 6000000);
        
        // Demonstrasi fitur anggota
        System.out.println("\n=== INFORMASI ANGGOTA ===");
        anggota1.processPayment(300000);
        anggota1.perpanjangMembership();
        anggota1.startTraining();
        tampilkanInfoAnggota(anggota1);
        
        anggota2.processPayment(450000);
        anggota2.perpanjangMembership(3);
        anggota2.startTraining();
        tampilkanInfoAnggota(anggota2);
        
        // Demonstrasi fitur pelatih
        System.out.println("\n=== INFORMASI PELATIH ===");
        pelatih1.processPayment(5500000);
        pelatih1.startTraining();
        tampilkanInfoPelatih(pelatih1);
        
        pelatih2.processPayment(6500000);
        pelatih2.startTraining();
        tampilkanInfoPelatih(pelatih2);
        
        // Demonstrasi interaksi antara anggota dan pelatih
        System.out.println("\n=== SESI LATIHAN ===");
        lakukanSesiLatihan(anggota1, pelatih1);
        lakukanSesiLatihan(anggota2, pelatih2);
        
        // Demonstrasi deaktivasi membership
        System.out.println("\n=== MANAJEMEN MEMBERSHIP ===");
        anggota1.deactivateMembership();
        System.out.println("Status membership " + anggota1.getNama() + ": " + 
                (anggota1.isMembershipActive() ? "Aktif" : "Nonaktif"));
        
        // Reaktivasi membership
        anggota1.activateMembership();
        System.out.println("Status membership " + anggota1.getNama() + " setelah reaktivasi: " + 
                (anggota1.isMembershipActive() ? "Aktif" : "Nonaktif"));
    }
    
    public static void tampilkanInfoAnggota(AnggotaBiasa anggota) {
        System.out.println("\n" + anggota.toString());
        System.out.println(anggota.getPaymentInfo());
        System.out.println("Role: " + anggota.getRole());
        System.out.println("Status Membership: " + (anggota.isMembershipActive() ? "Aktif" : "Nonaktif"));
        System.out.println("Jadwal Latihan: " + anggota.getTrainingSchedule());
        System.out.println("Durasi Membership: " + anggota.getDurasi() + " bulan");
    }
    
    public static void tampilkanInfoPelatih(Pelatih pelatih) {
        System.out.println("\n" + pelatih.toString());
        System.out.println(pelatih.getPaymentInfo());
        System.out.println("Role: " + pelatih.getRole());
        System.out.println("Status Sesi Latihan: "
                + (pelatih.getTrainingSchedule() + " - "
                + (pelatih.isInTrainingSession() ? "Sedang melatih" : "Tidak sedang melatih")));
    }
    
    public static void lakukanSesiLatihan(AnggotaBiasa anggota, Pelatih pelatih) {
        System.out.println("\nMemulai sesi latihan antara:");
        System.out.println("- Anggota: " + anggota.getNama() + " (Program: " + anggota.getProgram() + ")");
        System.out.println("- Pelatih: " + pelatih.getNama() + " (Spesialisasi: " + pelatih.getProgram() + ")");

        pelatih.startTraining();
        anggota.startTraining();

        System.out.println("Sesi latihan dimulai...");
        System.out.println("Jadwal: " + pelatih.getTrainingSchedule());

        // Akhiri sesi latihan
        pelatih.endTraining();
        anggota.endTraining();
        System.out.println("Sesi latihan selesai.");
    }
}
