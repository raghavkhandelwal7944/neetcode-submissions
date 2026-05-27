class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        
        // Edge case: Odd length strings can never be valid
        if (n % 2 != 0) {
            return false;
        }

        char[] stack = new char[n];
        int top = -1;
        
        // Micro-optimization 1: toCharArray() avoids charAt() bounds checking overhead
        for (char c : s.toCharArray()) {
            
            // Micro-optimization 2: switch statements compile to faster bytecode jump tables
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