class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count={}
        res=[]
        for num in nums:
            count[num] = 1 + count.get(num, 0)
        buckets=[[] for i in range(len(nums)+1)]
        for num, freq in count.items():
            buckets[freq].append(num)
        for i in range(len(buckets)-1,0,-1):
            for num in buckets[i]:
                res.append(num)
                if len(res)==k:
                    return res