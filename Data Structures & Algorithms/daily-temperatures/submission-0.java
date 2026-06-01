class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> numberStack = new Stack<>();
        int[] day = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
             while (!numberStack.isEmpty() && arr[i]>arr[numberStack.peek()]){
                int waitingDay=numberStack.pop();
                day[waitingDay]=i-waitingDay;
            }
             numberStack.push(i);
        
        }
        return day;
    }
}
