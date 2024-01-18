package org.example.parse;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class VsftpParse {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\vsftp.log.20240106\\vsftpd.log-20231022");
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\vsftpd.log-20231022.csv"));
            String header = "index,fileName,user\n";
            wr.write(header);

            String line;
            int index = 0;
            String fileName = null, user = null;
            Set<String> uniqueFileNames = new HashSet<>();

            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, " ");
                int i = 0;

                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken().trim();
                    i++;

                    if (i == 8) {
                        index = Integer.parseInt(token);
                    } else if (i == 9) {
                        fileName = token;
                    } else if (i == 14) {
                        user = token;
                    }
                }

                if (uniqueFileNames.add(fileName)) {
                    wr.write(index + "," + fileName + "," + user + "\n");
                }
            }
            System.out.println("END");
            br.close();
            wr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
