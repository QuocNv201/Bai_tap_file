import java.io.*;

public class DataStreamExample {
    public static void main(String[] args) {
        String fileName = "numbers.dat"; 
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            int[] numbers = {10, 20, 30, 40, 50};
            for (int num : numbers) {
                dos.writeInt(num); 
            }
            System.out.println("Ghi du lieu thanh cong vao " + fileName);
        } catch (IOException e) {
            System.err.println("Loi khi ghi file: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Du lieu doc tu file:");
            while (dis.available() > 0) {
                System.out.println(dis.readInt()); 
            }
        } catch (IOException e) {
            System.err.println("Loi khi doc file: " + e.getMessage());
        }
    }
}
