class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        
        // Edge case: Odd length strings can never be valid
        if (n % 2 != 0) {
            return false;
        }

        // We create a primitive array to act as our stack.
        // It is incredibly fast because it is a single contiguous block of memory.
        char[] stack = new char[n];
        
        // 'top' represents the index of the top element in our custom stack
        int top = -1; 

        // We use a traditional for-loop with charAt() to avoid the memory 
        // overhead of converting the whole string to a char array.
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            // Push expected closing brackets onto our array stack
            if (c == '(') {
                stack[++top] = ')';
            } else if (c == '{') {
                stack[++top] = '}';
            } else if (c == '[') {
                stack[++top] = ']';
            } 
            // If it's a closing bracket
            else {
                // top == -1 means the stack is empty (no opening bracket exists)
                // stack[top--] != c checks for a match AND pops the top element simultaneously
                if (top == -1 || stack[top--] != c) {
                    return false;
                }
            }
        }
        
        // If top is back to -1, everything matched perfectly
        return top == -1;
    }
}