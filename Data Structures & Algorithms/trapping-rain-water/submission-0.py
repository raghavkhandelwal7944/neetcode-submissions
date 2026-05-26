class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        r=len(height)
        i,j=0,1
        raghav=0
        angsty=[0]*r
        angsty[0]=height[0]
        pangsty=[0]*r
        pangsty[r-1]=height[r-1]
        for i in range(1,r):
            angsty[i]=max(angsty[i-1],height[i])
        for i in range(r-2,-1,-1):
            pangsty[i]=max(pangsty[i+1],height[i])
        for i in range(r):
            water_level=min(pangsty[i],angsty[i])
            raghav=raghav+water_level-height[i]
        return raghav