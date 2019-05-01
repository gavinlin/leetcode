class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();

        for(String word : words) {
            for(char c : word.toCharArray()) {
                degree.put(c, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int minLen = Math.min(s1.length(), s2.length());

            for(int j = 0; j < minLen; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (c1 != c2) {
                    if (!graph.containsKey(c1)) {
                        graph.put(c1, new HashSet<Character>());
                    }
                    Set<Character> siblings = graph.get(c1);
                    if (!siblings.contains(c2)) {
                        siblings.add(c2);
                        graph.put(c1, siblings);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();

        StringBuffer result = new StringBuffer();
        for (Map.Entry<Character, Integer> cursor : degree.entrySet()) {
            if (cursor.getValue() == 0) {
                q.add(cursor.getKey());
            }
        }

        while(!q.isEmpty()) {
            char c = q.poll();
            result.append(c);
            if (graph.containsKey(c)) {
                Set<Character> siblings = graph.get(c);
                for (char sibling : siblings) {
                    degree.put(sibling, degree.get(sibling)-1);
                    if (degree.get(sibling) == 0) {
                        q.add(sibling);
                    }
                }
            }
        }
        if (result.length() != degree.size()) return "";
        return result.toString();
    }
}
