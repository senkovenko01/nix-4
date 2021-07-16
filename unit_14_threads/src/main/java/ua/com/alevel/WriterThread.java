package ua.com.alevel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WriterThread implements Runnable {
    private final String fileName;

    private volatile Boolean running = true;

    private final StringBuffer inputBuf = new StringBuffer();

    private final StringBuffer oldInputBuf = new StringBuffer();

    public WriterThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (RandomAccessFile writer = new RandomAccessFile(fileName, "rw")){
            writer.setLength(0L);
            while (running) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!inputBuf.toString().equals(oldInputBuf.toString())) {
                    oldInputBuf.delete(0, oldInputBuf.length());
                    oldInputBuf.append(inputBuf);
                    writer.seek(0);
                    writer.writeBytes(inputBuf.toString());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void changeValue(String newSting) {
        inputBuf.append(newSting);
    }
    public void stop(){
        running = false;
    }
}
