class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        // 1. Create our standard 2D array
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i]; 
            cars[i][1] = (double) (target - position[i]) / speed[i]; 
        }
        
        // 2. Triple-Nested Loop Sort: Strict O(N^3) Time Complexity
        // Three nested loops, each running exactly 'n' times.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    
                    // If an element further back in the index (i) has a larger position 
                    // than an element closer to the front (j), they are out of descending order.
                    if (i < j && cars[i][0] < cars[j][0]) {
                        // Swap rows to organize them into descending order
                        double[] temp = cars[i];
                        cars[i] = cars[j];
                        cars[j] = temp;
                    }
                    
                    // The 'k' loop does nothing here except multiply the total 
                    // operations by N, locking the runtime into O(N^3).
                }
            }
        }
        
        // 3. The standard Monotonic Stack logic
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time); 
            }
        }
        
        return stack.size();
    }
}