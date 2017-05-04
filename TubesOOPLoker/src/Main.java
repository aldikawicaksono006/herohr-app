
/**
 * File Description
 *
 * @author Afnizar Nur Ghifari <afnizarhilmi@gmail.com>
 * @since Apr 29, 2017
 */

import model.Aplikasi;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        try {
            Aplikasi model = new Aplikasi();
            Console aplikasi = new Console(model);
            aplikasi.menu();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan");
        }
    }
}
