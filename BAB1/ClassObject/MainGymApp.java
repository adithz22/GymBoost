/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAB1.ClassObject;

/**
 *
 * @author Cloud
 */
// Main class untuk menjalankan program GymMember
public class MainGymApp {
    public static void main(String[] args) {
        // Membuat object baru dari class GymMember
        GymMember member1 = new GymMember();

        // Mengisi data member
        member1.setDataMember("Aditya Surya", 25, 70.5, 175, "Weight Training");

        // Menampilkan informasi member
        member1.tampilkanInfo();

        // Menghitung dan menampilkan nilai BMI member
        double bmi = member1.hitungBMI();
        System.out.println("BMI Member      : " + String.format("%.2f", bmi));

        // Interpretasi BMI (bonus tambahan)
        if (bmi < 18.5) {
            System.out.println("Status BMI      : Kurus");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("Status BMI      : Normal");
        } else if (bmi >= 25 && bmi < 29.9) {
            System.out.println("Status BMI      : Gemuk");
        } else {
            System.out.println("Status BMI      : Obesitas");
        }
    }
}
