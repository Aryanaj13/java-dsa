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
     //reverse string
    public static char[] reversestr(char[] s){
        int st = 0;
        int end = s.length-1;
        while(st<end){
            char temp = s[st];
            s[st] = s[end];
            s[end] = temp;
            st++;
            end--;
        }
        return s;
    }
    //valid anagram
    public static boolean validanagram(String str1, String str2){
        int[] freq = new int[26];
        if(str1.length() != str2.length()){
            return false;
        }else{
            for(int i=0;i<str1.length();i++){
                freq[str1.charAt(i)-'a']++;
            }
            for(int j=0;j<str2.length();j++){
                freq[str2.charAt(j)-'a']--;
            }
            for(int i=0;i<26;i++){
                if(freq[i]!=0){
                    return false;
                }
            }
        }
        return  true;
    }
    //first unique char in string
    public static int unique1stchar(String str){
        int[] freq = new int[26];
        for(int i=0;i<str.length();i++){
            freq[str.charAt(i) - 'a']++;
        }
        for(int i=0;i<str.length();i++){
            if(freq[str.charAt(i)-'a'] == 1){
            return i;
        }
        }
        return -1;
    }
     //rotate string
    public static boolean rotatestring(String str, String goal){
        if(str.length() != goal.length()){
            return false;
        }
            char[] arr = str.toCharArray();
            for(int j=0;j<str.length();j++){
                char temp = arr[0];
                for(int i=0;i<str.length()-1;i++){
                    arr[i] = arr[i+1];
                }
                arr[str.length()-1] = temp;
                if(new String(arr).equals(goal)){
                    return  true;
                }
            }
            return false;
}
    //reverse vowel of a string
public static String revvowel(String str){
    StringBuilder sb = new StringBuilder(str);
    int i = 0;
    int j = sb.length()-1;
    while(i < j){
        char ch = Character.toLowerCase(sb.charAt(i));
        char ch2 = Character.toLowerCase(sb.charAt(j));
        boolean isVowel1 = ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        boolean isVowel2 = ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u';
        if(isVowel1 && isVowel2){
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;  
            }
        if(!isVowel1){
            i++;
        }
        if(!isVowel2){
            j--;
        }
    }
    return sb.toString();
}
    //reverse string 2
        public static String revrsestr(String str, int k){
            char[] arr = str.toCharArray();
            for(int i=0;i<arr.length;i+=2*k){
                int left = i;
                int right = Math.min(i+k-1, arr.length-1);
                while(left<right){
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }
            }
           return new String(arr);
        }
//check plaindorme 2 (check palindrom after dleteing one char)
public static boolean ispalindrom(String str, int left,int  right){
    while(left < right){
        if(str.charAt(left) != str.charAt(right)){
            return false;
        }
        left++;
        right--;
    }
    return true;
}
public static boolean checkpalind(String str){
    int left = 0;
    int right = str.length()-1;
    while(left < right){
        if(str.charAt(left) == str.charAt(right)){
            left++;
            right--;
        }
        else{
            boolean leftdel = ispalindrom(str, left+1, right);
            boolean rightdel =ispalindrom(str, left, right-1);
            return leftdel || rightdel;
        }
    }
    return true;
}
    //revrse words in a string
public static String revword(String str){
    char[] arr = str.toCharArray();
    int left = 0;
    int right = str.length()-1;
    while(left < right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
    int start = 0;
    for(int i=0;i<arr.length;i++){
        if(arr[i] == ' '){
            int l = start;
            int r = i-1;
            while(l < r){
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
            start = i+1;
        }
    }
    int l = start;
    int r = arr.length-1;
    while (l < r) {
    char temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;

    l++;
    r--;
}
    return new String(arr);
}
    //min length of string after deleting similar ends
public static int minlenstrafterdelsimchar(String str){
    int left = 0;
    int right = str.length()-1;
    while(left < right && str.charAt(left) == str.charAt(right)){
        char ch = str.charAt(left);
        while (left < right && str.charAt(left) == ch) {
            left++;
        }
        while(left < right && str.charAt(right) == ch){
            right--;
        }
    }
    return right-left+1;
}
    // substring of size three with distinct character
public static int substrofsize3dischart(String str){
    int count = 0;
    for(int i=0;i<=str.length()-3;i++){
        char a = str.charAt(i);
            char b = str.charAt(i+1);
            char c = str.charAt(i+2);
            if(a != b && a != c && b != c){
                count++;
            }
}
return count;
}
    //minimum recolors to get k consecutive blcak block 
public static int minrectogetkconsblackblock(String str, int k){
    int left = 0;
    int right = k;
    int whitecount = 0;
    for(int i=0;i<k;i++){
        if(str.charAt(i) == 'w'){
            whitecount++;
        }
    }
        int min = whitecount;
        while(right < str.length()){
            if(str.charAt(right) == 'w'){
                whitecount++;
            }
            if(str.charAt(left) == 'w'){
                whitecount--;
            }
            left++;
            right++;
            min = Math.min(whitecount, min);
        }
        return min;
    }
}
