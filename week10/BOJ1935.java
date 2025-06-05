package da2sy.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1935 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        int num = Integer.parseInt(br.readLine());
        String postfix = br.readLine();
        double[] numArr = new double[num];

        for(int i = 0; i < numArr.length; i++) {
            numArr[i] = Double.parseDouble(br.readLine());
        }

        for(int i = 0; i < postfix.length(); i++) {
            if('A' <= postfix.charAt(i) && postfix.charAt(i) <= 'Z') {
                stack.push(numArr[postfix.charAt(i) - 'A']);
            } else {
                double firstNum = stack.pop();
                double secondNum = stack.pop();
                switch(postfix.charAt(i)) {
                    case '+':
                        stack.push(secondNum + firstNum);
                        break;
                    case '-':
                        stack.push(secondNum - firstNum);
                        break;
                    case '*':
                        stack.push(secondNum * firstNum);
                        break;
                    case '/':
                        stack.push(secondNum / firstNum);
                        break;
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
        br.close();

    }
}
