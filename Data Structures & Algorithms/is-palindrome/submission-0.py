class Solution:
    def isPalindrome(self, s: str) -> bool:
        s_cleaned="".join(char.lower() for char in s if char.isalnum())
        if s_cleaned==s_cleaned[::-1]:
            return True
        return False