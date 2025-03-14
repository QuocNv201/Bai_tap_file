import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File folder = new File("D:/JV/Bai_tap");
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Thu mục khong chua file nao.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            List<Thread> threads = new ArrayList<>();

            for (File file : files) {
                if (file.isFile()) {
                    Thread thread = new docfile(file, writer);
                    threads.add(thread);
                    thread.start();
                }
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("\nHoan thanh viec ghi noi dung vào file 'output.txt'");
        } catch (IOException e) {
            System.err.println("Loi khi tao file đau ra.");
        }
    }
}
