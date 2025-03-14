import java.io.*;
import java.util.concurrent.CountDownLatch;

class FileReaderThread extends Thread {
    private final RandomAccessFile file;
    private final byte[] buffer;
    private final int startPosition;
    private final CountDownLatch latch;
    private final int threadIndex;
    private final byte[][] results;

    public FileReaderThread(RandomAccessFile file, byte[] buffer, int startPosition,
                            CountDownLatch latch, int threadIndex, byte[][] results) {
        this.file = file;
        this.buffer = buffer;
        this.startPosition = startPosition;
        this.latch = latch;
        this.threadIndex = threadIndex;
        this.results = results;
    }

    @Override
    public void run() {
        try {
            file.seek(startPosition);  
            file.read(buffer);
            results[threadIndex] = buffer;  
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            latch.countDown(); 
        }
    }
}