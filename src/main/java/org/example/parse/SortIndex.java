package org.example.parse;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortIndex {
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\sftp.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        List<String> lines = new ArrayList<>();
        BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\sftpSort\\sftp.csv"));
        String line;

        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        lines.sort((o1, o2) -> {
            int idx1 = Integer.parseInt(o1.split(",")[0]);
            int idx2 = Integer.parseInt(o2.split(",")[0]);
            return Integer.compare(idx1, idx2);
        });

        for (String s : lines) {
            wr.write(s + "\n");
        }
    }
}
