class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return new int[0];
        }

        int left=0;
        int right=left+k;
        int[] arr = new int[nums.length - k + 1];
        while(right<=nums.length){
            int max=nums[left];
            for(int i=left; i<left+k; i++){
                if(nums[i]>max){
                    max=nums[i];
                }
            }
            arr[left]=max;
            left++;
            right++;
        }
        return arr;
    }
}
