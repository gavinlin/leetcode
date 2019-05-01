class Solution {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        if (s == null) return result;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;
        while(!queue.isEmpty()) {
            String a = queue.poll();

            if (isValid(a)) {
                result.add(a);
                found = true;
            }
            if (found == true) continue;

            for(int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                if (c != '(' && c != ')') continue;
                String newS = a.substring(0, i) + a.substring(i+1);
                if (!visited.contains(newS)) {
                    queue.add(newS);
                    visited.add(newS);
                }
            }
        }
        return result;

    }

    private boolean isValid(String s) {
        int count = 0;
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')' && count-- == 0) return false;
        }
        return count == 0;
    }
}
