package main.java.study.a03_gt.d02.p18513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_정우재 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new ArrayDeque<>();
        Set<Integer> isSelected = new HashSet<>();

        st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0 ;  i < N ; i++){
            int location  = Integer.parseInt(st.nextToken());
            queue.add( new int[] {location, 0} );
            isSelected.add(location); //본인 위치 추가
        }

        int count = 0;
        long unhappiness = 0;
        while(count != (N+K)){
            int[] value = queue.poll();
            int location = value[0];
            int score = value[1];
            unhappiness += score;
            count++;

            if( !isSelected.contains(location-1)){
                queue.add(new int[]{location-1, score+1});
                isSelected.add(location-1);
            }

            if( !isSelected.contains(location+1)){
                queue.add(new int[]{location+1, score+1});
                isSelected.add(location+1);
            }
        }

        System.out.println(unhappiness);

    }
}
