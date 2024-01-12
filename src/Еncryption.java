import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.*;


public class Еncryption {
    public static void doEcrypt() throws IOException {

        Scanner console = new Scanner(System.in);
        System.out.println("Введите адрес файла на шифровку.");
        String in = console.nextLine();
        System.out.println("Введите адрес файла для записи.");
        String adress = console.nextLine();
        System.out.println("Введите ключ для шифрования");
        int key = console.nextInt();
        key = key % 32;


        String read = Files.readString(Path.of(in));
        StringBuilder strBuilder = new StringBuilder();
        char ch;
        for (int i = 0; i < read.length(); i++) {
            ch = read.charAt(i);


            if (Character.isLetter(ch)) {
                ch = (char) (read.charAt(i) + key);

                if ((Character.isLowerCase(read.charAt(i)) && ch > 'я')
                        || (Character.isUpperCase(read.charAt(i)) && ch > 'Я'))

                    ch = (char) (read.charAt(i) + key);
            }
            strBuilder.append(ch);
            String cipherText = strBuilder.toString();

            try (PrintWriter out = new PrintWriter(adress)) {
                out.print(cipherText);
            }
        }
    }
}