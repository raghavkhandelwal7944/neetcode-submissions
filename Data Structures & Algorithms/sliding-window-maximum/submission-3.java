class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return new int[0];
        }

        int left=0;
        int[] arr = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int right=0;right<nums.length;right++){
            if(!deque.isEmpty() && deque.peekFirst()<right-k+1){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[right]){
                deque.pollLast();
            }
            deque.offerLast(right);
            if(right>=k-1){
                arr[left]=nums[deque.peekFirst()];
                left++;
            }
        }
        return arr;
    }
}
