
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.*;


public class BruteForce {
    public static void doBruteForce() throws IOException {

        Scanner console = new Scanner(System.in);

        System.out.println("Введите адрес файла на расшифровку.");
        String in = console.nextLine();
        System.out.println("Введите адрес файла для записи.");
        String str = console.nextLine();
        String read = Files.readString(Path.of(in));
        StringBuilder strBuilder = new StringBuilder();
        char c;
        for (int i = 1; i <= 32; i++) {
            for (int j = 0; j < read.length(); j++) {

                c = read.charAt(j);

                if (Character.isLetter(c)) {

                    c = (char) (read.charAt(j) - j);

                    if ((Character.isLowerCase(read.charAt(j)) && c > 'я')
                            || (Character.isUpperCase(read.charAt(j)) && c > 'Я'))

                        c = (char) (read.charAt(j) - (Main.ALPHABET.length() + j));
                }
                strBuilder.append(c);
                String cipher = strBuilder.toString();


                try (PrintWriter out = new PrintWriter(str)) {
                    out.print(cipher);

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
