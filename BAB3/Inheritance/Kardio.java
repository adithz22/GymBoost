package BAB3.Inheritance;

/**
 * Subclass dari Latihan untuk jenis latihan kardio
 */
public class Kardio extends Latihan {

    @Override
    public double hitungKalori() {
        kalori = durasi * 8.5; // asumsi 8.5 kalori per menit
        return kalori;
    }
}
