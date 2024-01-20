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
        String address = console.nextLine();
        System.out.println("Введите ключ для шифрования");
        int key = console.nextInt();
        key = key % 32;

        String s = Files.readString(Path.of(in));
        StringBuilder strBuilder = new StringBuilder();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            if (Character.isLetter(ch)) {
                ch = (char) (s.charAt(i) - key);

                if ((Character.isLowerCase(s.charAt(i)) && ch > 'я')
                        || (Character.isUpperCase(s.charAt(i)) && ch > 'Я'))

                    ch = (char) (s.charAt(i) - key);
            }
            strBuilder.append(ch);
            String cipher = strBuilder.toString();

            try (PrintWriter out = new PrintWriter(address)) {
                out.print(cipher);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void doDecrypt(int j) throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите адрес файла на расшифровку.");
        String in = console.nextLine();
        System.out.println("Введите адрес файла для записи.");
        String line = console.nextLine();
        String string = Files.readString(Path.of(in));
        StringBuilder strBuilder = new StringBuilder();
        char ch;
        for (int i = 0; i < string.length(); i++) {
            ch = string.charAt(i);


            if (Character.isLetter(ch)) {
                ch = (char) (string.charAt(i) - j);

                if ((Character.isLowerCase(string.charAt(i)) && ch > 'я')
                        || (Character.isUpperCase(string.charAt(i)) && ch > 'Я'))

                    ch = (char) (string.charAt(i) - j);
            }
            strBuilder.append(ch);
            String cipherText = strBuilder.toString();

            try (PrintWriter out = new PrintWriter(line)) {
                out.print(cipherText);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

}