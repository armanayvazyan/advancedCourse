package com.company.lesson2;

public class Main {

    public static void main(String[] args) {
        String str = "(Hello world! its my [(code)])";
        System.out.println(isCorrect(str));
    }

    private static boolean isCorrect(String str) {
        MyStack<Character> stack = new MyStack<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '[' || arr[i] == '{' || arr[i] == '('){
                stack.push(arr[i]);
            }
            if(arr[i] == ']') {
                if(stack.isEmpty())
                    return false;
                else if(stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }
            if(arr[i] == '}') {
                if(stack.isEmpty())
                    return false;
                else if(stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            }
            if(arr[i] == ')') {
                if(stack.isEmpty())
                    return false;
                else if(stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            }
        }
        return true;
    }

}
