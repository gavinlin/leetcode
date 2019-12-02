class Solution {

    private Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        helper(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void helper(String digits, int index, StringBuilder sb, List<String> result) {
        if (digits == null || digits.length() == 0) return;
        if (digits.length() == index) {
            result.add(sb.toString());
            return;
        }

        char ch = digits.charAt(index);
        if(map.containsKey(ch)) {
            for(char c : map.get(ch).toCharArray()) {
                sb.append(c);
                helper(digits, index + 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            helper(digits, index+1, sb, result);
        }
    }
}
