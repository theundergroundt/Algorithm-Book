import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        String a;
        a = new_id.toLowerCase();       
        a = a.replaceAll("[^a-z0-9._-]", "");
        a = a.replaceAll("\\.{2,}",".");
        a = a.replaceAll("^\\.|\\.$", "");
        if(a.isEmpty()) a = "a";
        if(a.length()>=16) {
            a = a.substring(0,15);
            if(a.endsWith(".")) a = a.substring(0,a.length()-1);
        }
        
        while(a.length()<3){
            a+=a.charAt(a.length()-1);
        }
        
        
        
        return a;
    }
}