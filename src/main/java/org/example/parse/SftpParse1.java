package org.example.parse;

import java.io.*;

public class SftpParse1 {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\KOAST\\Desktop\\log\\sftp.log.20240116\\sftp.log-20240107");
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            BufferedWriter wr = new BufferedWriter(new FileWriter("C:\\Users\\KOAST\\Desktop\\log\\test\\make.txt"));
            String line;
			String header = "index,username,receive,send\n";
			wr.write(header);

            while ((line = br.readLine()) != null) {
				String username = "", posixRename = "", removeName = "";
				int index = 0;

				// index
				int to = line.indexOf("]");
				if (to > 0) {
					index = Integer.parseInt(line.substring(38, to));
				}

				// userName
				int openFromIdx = line.indexOf("session opened for local user");
				if (openFromIdx > 0) {
					int openToIdx = line.indexOf("from");
					username = line.substring(openFromIdx + 30, openToIdx - 1);
				}

				//posix-rename
				int renameFromIdx = line.indexOf("new");
				if (renameFromIdx > 0) {
					posixRename = line.substring(renameFromIdx + 5, line.length() - 1);
				}

				//remove
				int removeFromIdx = line.indexOf("remove");
				if (removeFromIdx > 0) {
					removeName = line.substring(removeFromIdx + 13, line.length() - 1);
				}

				// open close opendir closedir
				if (line.indexOf("open ") > 0 || line.indexOf("close ") > 0 || line.indexOf("opendir") > 0 || line.indexOf("closedir") > 0
						|| (username == null && posixRename == null && removeName == null)) continue;
				wr.write(index + "," + username + "," + posixRename + "," + removeName + "\n");
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
