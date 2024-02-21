package org.example.parse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SftpMap {
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\sftp.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line;
        Map<Integer, Map<String, String[]>> map = new HashMap<>();

        while ((line = br.readLine()) != null) {
            String[] split = line.split(",");

        }
    }
}
