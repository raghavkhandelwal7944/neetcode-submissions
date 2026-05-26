class Solution:
    def maxArea(self, heights: list[int]) -> int:
        max_area = 0
        n = len(heights)
        
        # Outer loop locks in the left wall
        for i in range(n):
            
            # Inner loop checks EVERY single wall to the right of 'i'
            for j in range(i + 1, n):
                
                # Calculate the area for this specific pair
                current_area = (j - i) * min(heights[i], heights[j])
                
                # Update our max area if this one is bigger
                if current_area > max_area:
                    max_area = current_area
                    
        return max_area