package da2sy.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1966 {
    static int priorityArr[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        int count = 0;
        boolean flag = false;

        for(int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 문서 개수
            int m = Integer.parseInt(st.nextToken()); // 궁금한 문서의 순서
            priorityArr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                priorityArr[j] = temp;
                priorityQueue.offer(temp);
            }

            while(!flag && !priorityQueue.isEmpty()){
                for(int j = 0; j < priorityArr.length; j++) {
                    if(priorityArr[j] == priorityQueue.peek()) {
                        priorityQueue.poll();
                        count++;
                        if (j == m) {
                            sb.append(count).append("\n");
                            flag = true;
                            break;
                        }
                    }
                }
            }
            flag = false;
            count = 0;
            priorityQueue.clear();

        }
        System.out.print(sb);
    }
}
