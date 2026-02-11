class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> s = new HashSet<>();
        for(char c= 'a';c<='z';c++){
            s.add(c);
        }
        for(char c:s){
            if(!sentence.contains(String.valueOf(c))){
                return false;
            }
        }
        return true;
        }
    }
