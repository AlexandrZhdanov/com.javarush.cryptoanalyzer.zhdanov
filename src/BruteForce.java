
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.*;


public class BruteForce {
    public static void toBruteForce() throws IOException {

        Scanner console = new Scanner(System.in);

        System.out.println("Введите адрес файла на расшифровку.");
        String in = console.nextLine();
        System.out.println("Введите адрес файла для записи.");
        String str = console.nextLine();
        String read = Files.readString(Path.of(in));
        StringBuilder strBuilder = new StringBuilder();
        char c;
        for (int j = 1; j <= Main.ALPHABET.length(); j++) {
            for (int i = 0; i < read.length(); i++) {

                c = read.charAt(i);

                if (Character.isLetter(c)) {

                    c = (char) (read.charAt(i) - j);

                    if ((Character.isLowerCase(read.charAt(i)) && c > 'я')
                            || (Character.isUpperCase(read.charAt(i)) && c > 'Я'))

                        c = (char) (read.charAt(i) - (Main.ALPHABET.length() + j));
                }
                strBuilder.append(c);
                String cipherText = strBuilder.toString();


                try (PrintWriter out = new PrintWriter(str)) {
                    out.print(cipherText);

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
