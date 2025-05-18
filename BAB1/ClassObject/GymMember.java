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
    String nama, programLatihan;
    int usia, durasiLatihan;

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public void setProgramLatihan(String programLatihan) {
        this.programLatihan = programLatihan;
    }

    public void setDurasiLatihan(int durasiLatihan) {
        this.durasiLatihan = durasiLatihan;
    }

    public String getInfo() {
        return  "===== GymBoost Member Info =====\n" +
                "Nama              : " + nama + "\n" +
                "Usia              : " + usia + " tahun\n" +
                "Program Latihan   : " + programLatihan + "\n" +
                "Durasi Latihan    : " + durasiLatihan + " menit\n";
    }
}
