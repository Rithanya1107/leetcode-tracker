// Last updated: 7/10/2026, 8:46:32 AM
import java.util.*;

class Solution {
    public int maxDistance(String moves){
        int x = 0, y = 0, wildcards = 0;

        for(char c : moves.toCharArray()){
            switch (c){
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case '_':
                    wildcards++;
                    break;
            }
        }
        return Math.abs(x) + Math.abs(y) + wildcards;
    }
}