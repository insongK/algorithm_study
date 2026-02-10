package main.java.study.a03_gt.d03.p1941;

import java.io.*;
import java.util.*;

public class Main_김인송 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static char[][] map = new char[5][5];
    static boolean[][] v;
    static int[][] b;
    static int ans = 0;

    static boolean inRange(int r, int c) {
        return r >= 0 && r < 5 && c >= 0 && c < 5;
    }

    static void dfs(int r, int c) {
        if(Y >= 4) return;
        if(C == 7) {
            ans++;
        }
        v[r][c] = true;
        System.out.println(r + " " + c + " " + Y + " " + S + " " + C);
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(inRange(nr, nc) && !v[nr][nc]) {
                if(map[nr][nc] == 'Y') dfs(nr, nc, Y + 1, S, C + 1);
                if(map[nr][nc] == 'S') dfs(nr, nc, Y, S + 1, C + 1);
                v[r][c] = false;
            }
        }
    }

    static void comb(int cnt, int start){
        if(cnt == 7) {

            return;
        }
        for(int i = start; i < 25; i++) {
            b[cnt] = a[i];
            comb(cnt + 1, i); // comb(cnt+1,i) <- 이렇게 하면 중복 조합

        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for(int i = 0; i < 5; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < 5; j++) {
                map[i][j] = s[j].charAt(0);
            }
        }

//        for(int i = 0; i < 5; i++) {
//        	for(int j = 0; j < 5; j++) {
//        		v = new boolean[5][5];
//
//        	}
//        }
        v = new boolean[5][5];
        dfs(0, 0, 1, 0, 0);

        System.out.println(ans);

    }
}
