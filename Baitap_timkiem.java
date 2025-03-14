import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class Baitap_timkiem {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap tu khoa muon tim: ");
        String tuKhoa = scanner.nextLine();
        List<String> danhSachFile = Arrays.asList("History_java.txt", "Java (programming language).txt");

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<Future<Integer>> ketQua = new ArrayList<>();

        for (String file : danhSachFile) {
            Future<Integer> ketQuaFile = executor.submit(() -> demSoLanXuatHien(file, tuKhoa));
            ketQua.add(ketQuaFile);
        }

        int tongSoLanXuatHien = 0;
        for (Future<Integer> kq : ketQua) {
            tongSoLanXuatHien += kq.get();
        }

        executor.shutdown();

        System.out.println("Tu khoa \"" + tuKhoa + "\" xuat hien tong cong " + tongSoLanXuatHien + " lan trong cac file.");
    }

    private static int demSoLanXuatHien(String tenFile, String tuKhoa) {
        int soLan = 0;
        try {
            List<String> noiDung = Files.readAllLines(Paths.get(tenFile));
            for (String dong : noiDung) {
                soLan += demSoLanTrongDong(dong, tuKhoa);
            }
        } catch (IOException e) {
            System.err.println("Loi doc file: " + tenFile);
        }
        return soLan;
    }

    private static int demSoLanTrongDong(String text, String tuKhoa) {
        int count = 0, index = 0;
        while ((index = text.indexOf(tuKhoa, index)) != -1) {
            count++;
            index += tuKhoa.length();
        }
        return count;
    }
}