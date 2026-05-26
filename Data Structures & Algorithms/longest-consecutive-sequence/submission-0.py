class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        raghav=set(nums)
        longest_streak=0
        for num in nums:
            if (num-1) not in raghav:
                current_num=num
                current_streak=1
                while (current_num+1) in raghav:
                    current_num+=1
                    current_streak+=1
                longest_streak=max(current_streak, longest_streak)
        return longest_streak
            
            
            