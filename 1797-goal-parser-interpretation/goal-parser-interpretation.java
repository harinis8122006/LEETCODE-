class Solution {
    public String interpret(String command) {
       String str = command.replace("()","o");
       return str.replace("(al)","al");
    }
}