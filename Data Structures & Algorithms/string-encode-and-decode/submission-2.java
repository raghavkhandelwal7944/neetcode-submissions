class Solution {

    public String encode(List<String> strs) {
        char delimiter='=';
        String s="";
        for(String c:strs){
            s+=c;
            s+=delimiter;
        }
        return s;
    }

    public List<String> decode(String str) {
        char delimiter='=';
        List<String> s=new ArrayList<>();
        String r="";
        for(char c:str.toCharArray()){
            if(c!=delimiter){
            r+=c;
            }
            else{
                s.add(r);
                r="";
            }
            
        }
        return s;
    }
}
