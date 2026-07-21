import java.util.Deque;
import java.util.ArrayDeque;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
        LongestValidParentheses obj = new LongestValidParentheses();
        
        System.out.println(obj.longestValidParentheses("(()"));
        System.out.println(obj.longestValidParentheses(")()())"));
        System.out.println(obj.longestValidParentheses(""));
    }
}