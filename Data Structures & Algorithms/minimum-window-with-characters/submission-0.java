class Solution {
    public String minWindow(String s, String t) {
        int x=s.length();
        int y=t.length();
        if (s==null||t==null||x==0||y==0||x<y){
            return "";
        }

        int[] targetFreq= new int[128];
        for (char c : t.toCharArray()){
            targetFreq[c]++;
        }

        int left=0;
        int right=0;
        int minLen=Integer.MAX_VALUE;
        int minStart=0;
        int required=t.length();
        while (right<s.length()){
            char rightChar=s.charAt(right);

            if (targetFreq[rightChar]>0){
                required--;
            }
            targetFreq[rightChar]--;
            right++;

            while (required==0){
                if(right-left<minLen){
                    minLen=right-left;
                    minStart=left;
                }
                char leftChar = s.charAt(left);
                
                
                targetFreq[leftChar]++;
                
                
                if (targetFreq[leftChar] > 0) {
                    required++;
                }
                left++;
            }
            
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
