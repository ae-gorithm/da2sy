package da2sy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3085 {
    static char[][] board;  // 봄보니 board
    static int maxCandyCount = 0;   // 가장 많은 사탕의 개수를 담을 변수
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        // board 세팅
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        candyChangeRow();       // 행끼리 비교
        candyChangeColumn();    // 열끼리 비교

        sb.append(maxCandyCount);
        System.out.print(sb);
    }

    private static void candyChangeRow() {
        // (0,0),(0,1) / (0,1)(0,2) / ...
        for(int i = 0; i < board.length; i++) {
            for(int j = 1; j < board.length; j++) {
                char temp = board[i][j-1];
                board[i][j-1] = board[i][j];
                board[i][j] = temp;

                checkMaxCount();

                board[i][j] = board[i][j-1];
                board[i][j-1] = temp;
            }
        }
    }

    private static void candyChangeColumn() {
        // (0,0),(1,0) / (1,0)(2,0) / ...
        for(int i = 1; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                char temp = board[i-1][j];
                board[i-1][j] = board[i][j];
                board[i][j] = temp;

                checkMaxCount();

                board[i][j] = board[i-1][j];
                board[i-1][j] = temp;
            }
        }
    }

    private static void checkMaxCount() {
        // 행 maxCandyCount 계산
        for(int i = 0; i < board.length; i++) {
            int count = 1;
            for(int j = 0; j < board[i].length-1; j++) {
                if(board[i][j] == board[i][j+1]) {
                    count++;
                    maxCandyCount = Math.max(count, maxCandyCount);
                } else {
                    count = 1;
                }
            }
        }

        // 열 maxCandyCount 계산
        for(int i = 0; i < board.length; i++) {
            int count = 1;
            for(int j = 0; j < board[i].length-1; j++) {
                if(board[j][i] == board[j+1][i]) {
                    count++;
                    maxCandyCount = Math.max(count, maxCandyCount);
                } else {
                    count = 1;
                }
            }
        }
    }
}


