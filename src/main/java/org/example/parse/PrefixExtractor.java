package org.example.parse;

import java.util.ArrayList;
import java.util.List;

public class PrefixExtractor {
    public static void main(String[] args) {
        // 주어진 데이터
        String data = "/home/kmaUser/comis/DFS_VSRT_GRD_GRB5_PTY.202401050230_202401051210\n" +
                "/home/kmaUser/comis/DFS_VSRT_GRD_GRB5_PTY.202401050330\n" +
                "/home/kmaUser/comis/DFS_VSRT_GRD_GRB5_PTY.202401050330\n" +
                "/home/kmaUser/comis/DFS_VSRT_GRD_GRB5_PTY.202401050330\n" +
                "/home/kmaUser/comis/DFS_VSRT_GRD_GRB5_PTY.202401050330\n" +
                "/home/kmaUser/comis/DFS_VSRT_GRD_GRB5_PTY.202401050330\n";
        // 각 행을 분할하고 첫 번째 열을 추출하여 리스트에 추가
        String[] lines = data.split("\n");
        List<String> prefixes = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split("/");
            if (parts.length > 2) {
                prefixes.add(parts[1]);
            }
        }

        // 중복된 접두사 제거
        prefixes = removeDuplicates(prefixes);

        // 추출된 접두사 출력
        for (String prefix : prefixes) {
            System.out.println("/" + prefix);
        }
    }

    // 중복된 항목 제거
    private static List<String> removeDuplicates(List<String> list) {
        List<String> result = new ArrayList<>();
        for (String item : list) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
