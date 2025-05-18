package BAB3.Inheritance;

/**
 * Subclass dari Latihan untuk jenis latihan angkat beban
 */
public class AngkatBeban extends Latihan {

    @Override
    public double hitungKalori() {
        kalori = durasi * 6.0; // asumsi 6.0 kalori per menit
        return kalori;
    }
}
