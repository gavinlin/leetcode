class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        
        for(char c : t.toCharArray()) {
            addChar(tmap, c);
        }
            
        int head = 0;
        int tail = 0;
        int[] ans = new int[3];
        ans[0] = -1;
        while(tail < s.length()) {
            
            addChar(smap, s.charAt(tail));
            
            while (head <= tail && isValid(smap, tmap)) {

                if (ans[0] == -1 || tail - head + 1 < ans[0]) {
                    ans[0] = tail - head + 1;
                    ans[1] = head;
                    ans[2] = tail;
                }
                
                deleteChar(smap, s.charAt(head++));
                
            }
            tail++;
        }
        if (ans[0] == -1) return "";
        return s.substring(ans[1], ans[2] + 1);
    }
    
    private void deleteChar(Map<Character, Integer> smap, char c) {
        smap.put(c, smap.get(c) - 1);
    }
    
    private void addChar(Map<Character, Integer> map, char c) {
        if (!map.containsKey(c)) {
            map.put(c, 0);
        }
        map.put(c, map.get(c) + 1);
    }
    
    private boolean isValid(Map<Character, Integer> smap, Map<Character, Integer> tmap) {
        for(Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            if (!smap.containsKey(entry.getKey()) ||
               smap.get(entry.getKey()) < entry.getValue()) return false;
        }
        return true;
    }
}
