package org.example.parse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileSplitter {
    public static void splitFile(String inputFilePath, String outputPrefix, int chunkSize) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            int lineNumber = 0;
            int chunkNumber = 1;
            StringBuilder chunkContent = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                chunkContent.append(line).append("\n");
                lineNumber++;

                if (lineNumber % chunkSize == 0) {
                    writeChunk(outputPrefix, chunkNumber++, chunkContent.toString());
                    chunkContent.setLength(0);
                }
            }

            if (chunkContent.length() > 0) {
                writeChunk(outputPrefix, chunkNumber, chunkContent.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeChunk(String outputPrefix, int chunkNumber, String content) {
        String outputFilePath = String.format("C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\sftp\\%s_%d.csv", outputPrefix, chunkNumber);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\sftp.txt";
        String outputPrefix = "output_chunk";
        int chunkSize = 1000000;

        splitFile(inputFilePath, outputPrefix, chunkSize);
        System.out.println("END");
    }
}
