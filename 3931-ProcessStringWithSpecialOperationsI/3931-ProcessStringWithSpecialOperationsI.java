// Last updated: 7/10/2026, 8:46:41 AM
class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder ();
        for(char ch : s.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                result.append(ch);
            }
            else if(ch == '*'){
                if(result.length() > 0){
                    result.deleteCharAt(result.length() - 1);
                }
            }
            else if(ch =='#'){
                result.append(result.toString());
            }
            else if(ch == '%'){
                result.reverse();
            }
        }
        return result.toString();
    }
}