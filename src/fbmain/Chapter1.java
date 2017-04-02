/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbmain;

/**
 *
 * @author jorgeaceves
 */
public class Chapter1 {
    public boolean question2(String str1, String str2){
        int[] letters = new int[52];
        if(str1.length() != str2.length()) return false;
        for(int x=0; x < str1.length(); x++){
            int value = str1.charAt(x) - 'a';
            letters[value]++;
        }
        for(int x=0; x < str2.length(); x++){
            int value = str2.charAt(x) - 'a';
            if(--letters[value] == -1){
                return false;
            }
        }
        return true;
    }
    public char[] question3(char[] url, int urlLength){
        if(urlLength == 0) return url;
        int op = urlLength - 1, np = url.length - 1;
        if(op == np) return url;
        while(op >= 0){
            if(url[op] == ' '){
                url[np--] = '0';
                url[np--] = '2';
                url[np--] = '%';
            } else {
                url[np--] = url[op];
            }
            op--;
        }
        return url;
    }
    public boolean question5(String str1, String str2){
        if(Math.abs(str1.length() - str2.length()) > 1){
            return false;
        }
        String s1 = str1.length() < str2.length() ? str1 : str2;
        String s2 = str1.length() < str2.length() ? str2 : str1;
        int index1 = 0, index2 = 0;
        boolean foundDiff = false;
        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(foundDiff) return false;
                foundDiff = true;
                if(s1.length() == s2.length()){
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }
    public String question6(String str){
        if(str.length() == 0) return str;
        
        int counter = 0;
        StringBuilder result = new StringBuilder();
        
        for(int x=0; x<str.length(); x++){
            counter++;
            if(x+1 == str.length() || str.charAt(x) != str.charAt(x+1)){
                result.append(str.charAt(x));
                result.append(String.valueOf(counter));
                counter = 0;
            }
        }
        String s = result.toString();
        return s.length() > str.length() ? str : s;
    }
}
