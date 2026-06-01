

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        // 1. Create our standard 2D array
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i]; 
            cars[i][1] = (double) (target - position[i]) / speed[i]; 
        }
        
        // 2. Bubble Sort: Systematically swap adjacent cars if they are out of order
        // This is O(N^2), which is "a little better" than BogoSort's O(N * N!)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // We want descending order based on position (closest to target first)
                if (cars[j][0] < cars[j + 1][0]) {
                    // Swap the rows
                    double[] temp = cars[j];
                    cars[j] = cars[j + 1];
                    cars[j + 1] = temp;
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