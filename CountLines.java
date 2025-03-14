import java.io.*;

public class CountLines {
    public static void main(String[] args) {
        String fileName = "output.txt"; 
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int lineCount = 0;
            while (reader.readLine() != null) {
                lineCount++;
            }
            System.out.println("So dong trong file: " + lineCount);
        } catch (IOException e) {
            System.err.println("Loi: " + e.getMessage());
        }
    }
}