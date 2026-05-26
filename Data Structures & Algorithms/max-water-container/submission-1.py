class Solution:
    def maxArea(self, heights: List[int]) -> int:
        j=len(heights)-1
        maxing=[]
        i=0
        while i<j:

            r=(j-i)*min(heights[i],heights[j])
            maxing.append(r)
            if heights[i]<heights[j]:
                i+=1
            else:
                j-=1
        return max(maxing)