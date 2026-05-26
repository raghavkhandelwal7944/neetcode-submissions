class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        freq_dict={}
        left=0
        longest=0
        max_freq=0
        for right in range(len(s)):
            char=s[right]
            freq_dict[char]=freq_dict.get(char,0)+1
            max_freq=max(max_freq,freq_dict[char])
            while (right-left+1-max_freq)>k:
                char_leaving=s[left]
                freq_dict[char_leaving]-=1
                left+=1
                
            longest=max(longest,right-left+1)
        return longest
