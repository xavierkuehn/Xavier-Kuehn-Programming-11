import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u'){
                answer++;
            }
        }
        return answer;
    }
    //Code you problem number two here
    static int problemTwo(String s){
        int answer = 0;
        int lastIndex = 0;
        String bob = "bob";
        while(lastIndex != -1){

            lastIndex = s.indexOf(bob, lastIndex);

            if(lastIndex != -1){
                answer++;
                lastIndex += bob.length() - 1;
            }
        }
        return answer;
    }
    //Code your solution to problem number 3 here
    static String problemThree(String s){
        int subStart = 0;
        int length = 1;
        int longestSubStart = -1;
        int longestLength = -1;

        for (int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) <= s.charAt(i + 1)){
                length ++;
            } else {
                if(longestLength < length){
                    longestSubStart = subStart;
                    longestLength = length;
                }
                subStart = i + 1;
                length = 1;
            }
        }

        if(longestLength < length){
            longestSubStart = subStart;
            longestLength = length;
        }

        return s.substring(longestSubStart, longestSubStart + longestLength);

    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */

        String s = "tunivklq";
        System.out.println(problemThree(s));
    }
}
