import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> book = new HashSet<>();
        for(String s : phone_book){
            book.add(s);
        }
        for(String number : phone_book){
            for(int i=1; i< number.length(); i++){
                String prefix = number.substring(0, i);
                if(book.contains(prefix)){
                    return false;
                }
            }
        }
        return true;
    }
}