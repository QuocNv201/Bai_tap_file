import java.io.*;

public class docfile extends Thread{
    private final File file;
    private final BufferedWriter writer;

    public docfile(File file, BufferedWriter writer) {
        this.file = file;
        this.writer = writer;
    }

    @Override
    public void run() {
        synchronized (writer) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
                System.out.println("Hoàn thành đọc file: " + file.getName());
            } catch (IOException e) {
                System.err.println("Lỗi khi đọc file: " + file.getName());
            }
        }
    }
}

