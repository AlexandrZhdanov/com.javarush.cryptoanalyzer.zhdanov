import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.*;


public class Decoding {
    public static void doDecrypt() throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите адрес файла на расшифровку.");
        String in = console.nextLine();
        System.out.println("Введите адрес файла для записи.");
        String adress = console.nextLine();
        System.out.println("Введите ключ для шифрования");
        int key = console.nextInt();
        key = key % Main.ALPHABET.length();
        String s = Files.readString(Path.of(in));
        StringBuilder strBuilder = new StringBuilder();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if (Character.isLetter(c)) {
                c = (char) (s.charAt(i) - key);

                if ((Character.isLowerCase(s.charAt(i)) && c > 'я')
                        || (Character.isUpperCase(s.charAt(i)) && c > 'Я'))

                    c = (char) (s.charAt(i) - (Main.ALPHABET.length() + key));
            }
            strBuilder.append(c);
            String cipherText = strBuilder.toString();

            try (PrintWriter out = new PrintWriter(adress)) {
                out.print(cipherText);
            }
        }
    }
}

