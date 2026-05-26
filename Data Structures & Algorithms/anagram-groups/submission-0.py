from collections import Counter

class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        res = []
        already_grouped = [False] * len(strs) # Keep track of what we've used

        for i in range(len(strs)):
            if already_grouped[i]: continue
            
            group = [strs[i]]
            already_grouped[i] = True
            
            for j in range(i + 1, len(strs)):
                if not already_grouped[j] and Counter(strs[i]) == Counter(strs[j]):
                    group.append(strs[j])
                    already_grouped[j] = True
            
            res.append(group)
        return res