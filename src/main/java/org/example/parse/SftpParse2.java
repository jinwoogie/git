package org.example.parse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SftpParse2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\sftp.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] split = line.split(",");
            String index = split[0];

            String outputFilePath = "C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\sftpByIndex\\ " + index + ".txt";
            try (FileWriter fw = new FileWriter(outputFilePath, true)) {
                StringBuilder sb = new StringBuilder();
                sb.append(split[1] + " " + split[2] + " " + split[3] + "\n");
                fw.write(String.valueOf(sb));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("END");
    }
}
