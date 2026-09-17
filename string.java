import java.util.*;
public class string {
    //check palindrom
    public  static boolean palindrom(String str){
        int st = 0;
        int end = str.length()-1;
        while(st<end){
            if(str.charAt(st) != str.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
    //find the shortest path to reach destination
    public static double findshortpath(String str){
        int x =0;
        int y=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == 'n'){
                y++;
            }else if(str.charAt(i) == 's'){
                y--;
            }else if(str.charAt(i) == 'e'){
                x++;
            }else if(str.charAt(i) == 'w'){
                x--;
            }
        }
        double shortpath = Math.sqrt(x*x+y*y);
        return shortpath;
    }
     // find substring
    public static String substring(String str, int si, int ei){
        String substr = "";
        for(int i= si;i<ei;i++){
            substr += str.charAt(i);
        }
        return substr;
    }
    //largest string find in lexicografically order
    public static String largstr(String[] str){
        String larg = str[0];
        for(int i=1;i<str.length;i++){
            if(larg.compareToIgnoreCase(str[i]) < 0){
                larg = str[i];
            }
        }
        return larg;
    }
    //converst each word 1st letter to uppercase
    public static StringBuilder firstletteruppercasechar(StringBuilder sb){
       char ch = Character.toUpperCase(sb.charAt(0));
       sb.setCharAt(0, ch);
       for(int i=1;i<sb.length();i++){
         if(sb.charAt(i) == ' ' && i+1 < sb.length()){
            sb.setCharAt(i+1, Character.toUpperCase(sb.charAt(i+1)));
         }
       }
       return sb;
    }
     //valid palindrm
    public static  boolean validpalindrom(String str){
        int st = 0;
        int end = str.length()-1;
        while(st<end){
            if(!Character.isLetterOrDigit(str.charAt(st))){
                st++;
                continue;
            }
            if(!Character.isLetterOrDigit(str.charAt(end))){
                end--;
                continue;
            }
            if(Character.toLowerCase(str.charAt(st))  !=  Character.toLowerCase(str.charAt(end))){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
     //count vowel
    public static int countvowel(String str){
        int count = 0;
        for(int i=0;i<=str.length()-1;i++){
           char ch = Character.toLowerCase(str.charAt(i));
            if(ch == 'a' || ch =='e' || ch=='i' || ch == 'o' || ch == 'u'){
                count++;
            }
        }
        return count;
    }
    //character freq count
    public static int charfreq(String str, char ch){
        int freq = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ch){
                freq++;
            }
        }
        return  freq;
    }
}
