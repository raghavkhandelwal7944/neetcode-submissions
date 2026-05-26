class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1,max=0;
        while(l<r){
            int current=Math.min(height[l],height[r])*(r-l);
            if(current>max) max=current;
            if(height[l]<height[r]) l++; else r--;
        }
        return max;
    }
}
