package BAB3.Inheritance;

/**
 * Parent class untuk semua jenis latihan di GymBoost
 */
public class Latihan {
    public int durasi; // dalam menit
    public double kalori;

    public Latihan() {
        durasi = 0;
        kalori = 0;
    }

    /**
     * Method untuk menghitung kalori, default 0
     */
    public double hitungKalori() {
        return 0;
    }
}
