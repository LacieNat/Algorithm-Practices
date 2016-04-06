public class Solution {
    public int bulbSwitch(int n) {
        return ((int) (Math.floor(Math.sqrt(n)) - Math.ceil(Math.sqrt(1)) + 1));
    }
}