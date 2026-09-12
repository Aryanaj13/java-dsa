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
    public static void main(String[] args) {
        String str ="nee";
        System.out.println(findshortpath(str));
    }
}
