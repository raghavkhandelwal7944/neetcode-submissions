class Solution:
    def maxArea(self, heights: List[int]) -> int:
        j=len(heights)-1
        maxing=0
        i=0
        while i<j:

            r=(j-i)*min(heights[i],heights[j])
            if r>maxing:
                maxing=r
            if heights[i]<heights[j]:
                i+=1
            else:
                j-=1
        return maxing