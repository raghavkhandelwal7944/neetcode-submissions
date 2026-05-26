class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int t = 1;
        int countzero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                t *= nums[i];
            } else {
                countzero++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (countzero > 1) {
                arr[i] = 0;
            } else if (countzero == 1) {
                arr[i] = nums[i] == 0 ? t : 0;
            } else {
                arr[i] = t / nums[i]; 
            }
        }

        return arr;
    }
}
