class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        raghav=[]
        for i in range(len(nums)):
            if i>0 and nums[i]==nums[i-1]:
                continue
            k=len(nums)-1
            j=i+1
            while j<k:
                if nums[i]+nums[j]+nums[k]>0:
                    k-=1
                elif nums[i]+nums[j]+nums[k]<0:
                    j+=1
                else:
                    raghav.append([nums[i],nums[j],nums[k]])
                    j+=1
                    k-=1
                    while j<k and nums[j]==nums[j-1]:
                        j+=1
        return raghav
