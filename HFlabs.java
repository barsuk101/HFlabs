import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HFlabs {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("нет файла");
            System.exit(1);
        }

        String filePath = args[0];
        char targetChar = args[1].toLowerCase().charAt(0);

        try {
            int lineCount = countLines(filePath);
            int charCount = countTargetChar(filePath, targetChar);

            System.out.println("Строки" + lineCount);
            System.out.println("Символ '" + targetChar + "': " + charCount);
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static int countLines(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        }
    }

    private static int countTargetChar(String filePath, char targetChar) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int charCount = 0;
            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                char lowerCaseCurrentChar = Character.toLowerCase((char) currentChar);
                if (lowerCaseCurrentChar == targetChar) {
                    charCount++;
                }
            }
            return charCount;
        }
    }
}
