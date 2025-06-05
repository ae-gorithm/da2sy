package da2sy.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17829 {
    static int[][] matrix;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];

        for(int i = 0; i < matrix.length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(pooling(0, 0, n));
    }

    static int pooling(int i, int j, int n) {
        int arr[] = new int[4];
        if(n == 2) {
            int idx = 0;
            for(int x = i; x < i+2; x++) {
                for(int y = j; y < j+2; y++) {
                    arr[idx++] = matrix[x][y];
                }
            }
        } else {
            n /= 2;
            arr[0] = pooling(i, j, n);
            arr[1] = pooling(i, j+n, n);
            arr[2] = pooling(i+n, j, n);
            arr[3] = pooling(i+n, j+n, n);
        }

        Arrays.sort(arr);
        return arr[2];
    }
}
