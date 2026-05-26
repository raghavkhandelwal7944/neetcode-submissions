class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n=len(prices)
        raghav=0
        i=0
        j=1
        while i<n:
            if j>=n:
                break
            if prices[i]>prices[j]:
                i=j
                j+=1
            elif prices[i]<prices[j]:
                turn=prices[j]-prices[i]
                raghav=max(raghav,turn)
                j+=1
            elif prices[i]==prices[j]:
                i=j
                j+=1
        return raghav

