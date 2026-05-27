class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        char[] stack = new char[n];
        int top = -1;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': 
                    stack[++top] = ')'; 
                    break;
                case '{': 
                    stack[++top] = '}'; 
                    break;
                case '[': 
                    stack[++top] = ']'; 
                    break;
                default:
                    if (top == -1 || stack[top--] != c) {
                        return false;
                    }
            }
        }
        
        return top == -1;
    }
}