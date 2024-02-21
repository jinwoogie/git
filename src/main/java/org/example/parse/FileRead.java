package org.example.parse;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileRead {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\sftpByIndexParse\\koast-receive.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\sftpByIndexParse\\sort\\koast-receive-sort.txt"));

        String line;
        List<String> list = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        Collections.sort(list);
        for (String s : list) {
            bw.write(s + "\n");
        }
        System.out.println("END");
        bw.close();
        br.close();
    }
}
