class Solution:
    def encode(self, strs: list[str]) -> str:
        sol = ""
        for word in strs:
            a = len(word)
            message = str(a) + '#' + word
            sol += message
        return sol

    def decode(self, s: str) -> list[str]:
        strs = []
        i = 0  
        
        while i < len(s):
            j = i
            
            # Find the '#' delimiter
            while s[j] != '#':
                j += 1
                
            # Extract the length of the next word
            length = int(s[i:j])
            
            # Calculate the boundaries of the actual word
            word_start = j + 1
            word_end = word_start + length
            
            # Slice the word and add it to our result list
            strs.append(s[word_start:word_end])
            
            # Move 'i' to the start of the next encoded chunk
            i = word_end
            
        return strs