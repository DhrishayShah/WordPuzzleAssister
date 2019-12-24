package findwords;
import java.util.*;
import java.util.ArrayList;


public class Searcher {

    /**
     * Compares the front part of two character arrays for equality.
     * @param s the first character array
     * @param t the second character array
     * @param n number of characters to compare
     * @return true if s and t are equal up to the first n characters
     */
    public boolean equal(String s, String t, int n) {
        boolean equals = false;
        if(s.length() < n || t.length() < n){
            if(t.length() != s.length()){
                equals = false;
            }
            n = s.length();
        }
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == t.charAt(i)){
                equals = true;
            }else{
                equals = false;
            }
        }
        return equals;
    }

    /**
     * Compares the front part of two character arrays.
     * @param s the first character array
     * @param t the second character array
     * @param n number of characters to compare
     * @return true if s is less than t in the first n characters
     */
    public boolean lessThan(String s, String t, int n) {
        for(int i = 0; i < n; i++){
            if(i == t.length()){
                return false;
            }
            if (i == s.length()) {
                return true;
            }
            if(s.charAt(i) < t.charAt(i)){
                return true;
            }
            if(s.charAt(i) > t.charAt(i)){
                return false;
            }
        }
        return false;
    }

    /**
     * Finds the first position of a prefix in a dictionary.
     * @param d an ordered dictionary of words
     * @param w a prefix to search for
     * @param n number of characters to compare
     * @return the least index such that all earlier entries in the dictionary
     * are smaller than e when comparing the first n characters.
     */
    public int findPrefix(Dictionary d, String w, int n) {
        int lo = 0;
        int hi = d.size() - 1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(lessThan(d.getWord(mid),w,n)){
                lo = mid + 1;
            }else{
                lo = mid - 1;
            }
        }
        return lo;
    }

    /**
     * Searches a dictionary for words matching a clue.
     * @param d an ordered dictionary of words
     * @param clue a word to search for, with . standing for any character
     * @return a list of all the words in the dictionary that match the clue
     */
    public ArrayList<String> findMatches(Dictionary d, String clue) {
        ArrayList<String> matches = new ArrayList<>();
        for(int loc = 0; loc < d.size(); loc++){
            String w = d.getWord(loc);
            if(w.length() == clue.length()){
                int i = 0;
                while(i < clue.length() && (clue.charAt(i) == '.' || w.charAt(i) == clue.charAt(i))){
                    i++;
                }
                if( i == clue.length()){
                    matches.add(w);
                }
            }
        }
        return matches;
    }

}
