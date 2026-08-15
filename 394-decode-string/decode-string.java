class Solution {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>();
        String current = "";
        int n = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
            }
            else if (c == '[') {
                num.push(n);
                str.push(current);
                n = 0;
                current = "";
            }
            else if (c == ']') {
                int times = num.pop();
                String old = str.pop();
                String temp = "";
                for (int i = 0; i < times; i++) {
                    temp += current;
                }
                current = old + temp;
            }
            else {
                current += c;
            }
        }
        return current;
    }
}