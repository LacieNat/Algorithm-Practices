public class Solution {
    HashMap<String, ArrayList<String>> hm;
    ArrayList<String> result;
    int numTickets;
    
    public List<String> findItinerary(String[][] tickets) {
        numTickets = tickets.length;
        hm = new HashMap<>();
        
        for(int i=0; i<tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];

            if(!hm.containsKey(from)) {
                hm.put(from, new ArrayList<String>());
            }
            
            hm.get(from).add(to);
        }
        
        for(ArrayList<String> a: hm.values()) {
            Collections.sort(a);
        }
        
        result = new ArrayList<>();
        solve("JFK");
        
        return result;
    }
    
    public boolean solve(String root) {
        result.add(root);
        if(result.size() == numTickets+1) {
            return true;
        }
        
        if(!hm.containsKey(root)) {
            return false;
        }
        
        ArrayList<String> q = hm.get(root);
        
        for(int i=0; i<q.size(); i++) {
            String item = q.remove(i);

            if(solve(item))
                return true;
            result.remove(result.size()-1);
            q.add(i, item);
        }
        
        return false;
    }
}