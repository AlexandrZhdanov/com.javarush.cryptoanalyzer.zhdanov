import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static final String ALPHABET = ".,«»:?! АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя0123456789";

    public static void main(String[] args) throws IOException {

        System.out.println("Выберите режим работы: ");
        System.out.println("1. Шифровка.");
        System.out.println("2. Дешифровка.");
        System.out.println("3. Подбор кода.");

        Scanner console = new Scanner(System.in);

        int i = console.nextInt();

        if (i == 1) {
            Еncryption.doEcrypt();
        } else if (i == 2) {
            Decoding.doDecrypt();
        } else if (i == 3) {
            BruteForce.toBruteForce();

        } else {
            System.out.println("Сделайте корректный выбор режима работы.");
        }


    }
}