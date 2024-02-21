package org.example.parse;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FolderRead {
    public static void main(String[] args) throws IOException {

        BufferedWriter kmaUserReceiveBw = new BufferedWriter(new FileWriter("C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\sftpByIndexParse\\kmauser-receive.txt"));
        BufferedWriter kmaUserSendBw = new BufferedWriter(new FileWriter("C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\sftpByIndexParse\\kmauser-send.txt"));
        BufferedWriter koastReceiveBw = new BufferedWriter(new FileWriter("C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\sftpByIndexParse\\koast-receive.txt"));
        BufferedWriter koastSendBw = new BufferedWriter(new FileWriter("C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\sftpByIndexParse\\koast-send.txt"));

        try(DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("C:\\Users\\koast\\Desktop\\woogie\\parse\\log\\result\\sftpByIndex"))) {
            for (Path file : stream) {
                BufferedReader br = new BufferedReader(new FileReader(String.valueOf(file)));
                String line;
                String username = "";
                while ((line = br.readLine()) != null) {
                    //TODO 각 파일 정리
                    String receiveFile = "", sendFile = "";
                    String[] split = line.split(" ");

                    if (!split[0].equals("null")) username = split[0];
                    else {
                        if (!split[1].equals("null")) {
                            receiveFile = split[1];
                            if (username.equals("kmaUser")) {
                                kmaUserReceiveBw.write(receiveFile + "\n");
                            } else if (username.equals("koast")) {
                                koastReceiveBw.write(receiveFile + "\n");
                            }
                        } else if (!split[2].equals("null")) {
                            sendFile = split[2];
                            if (username.equals("kmaUser")) {
                                kmaUserSendBw.write(sendFile + "\n");
                            } else if (username.equals("koast")) {
                                koastSendBw.write(sendFile + "\n");
                            }
                        }
                    }
                }
            }
            kmaUserSendBw.close();
            kmaUserReceiveBw.close();
            koastReceiveBw.close();
            koastSendBw.close();
            System.out.println("END");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
