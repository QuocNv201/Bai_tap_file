import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String folderPath = "D:/JV/Bai_tap"; // Đường dẫn thư mục cần liệt kê
        
        File folder = new File(folderPath);
        
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            System.out.println("Danh sach cac file trong thu muc: " + folderPath);
            
            if (files != null && files.length > 0) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("Thu muc rong hoac khong co file nao.");
            }
        } else {
            System.out.println("Thu muc khong ton tai hoac khong hop le.");
        }
    }
}
