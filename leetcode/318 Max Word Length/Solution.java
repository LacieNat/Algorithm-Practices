public class Solution {
    public int maxProduct(String[] words) {
        int size = words.length;
        int[] map = new int[size];
        
        //populating mask array
        for(int i=0; i<size; i++) {
            String curr = words[i];
            
            for(int j=0; j<curr.length(); j++) {
                char currChar = curr.charAt(j);
                map[i] = map[i] | (1<<(currChar-'a'));
            }
        }
        
        int pdt = 0;
        for(int i=0; i<size-1; i++) {
            
            for(int j= i+1; j<size; j++) {
                if ((map[i] & map[j]) == 0) {
                    pdt = Math.max(pdt, words[i].length() * words[j].length());
                }
            }
        }
        
        return pdt;
        
    }
}