class Solution {
    public int longestValidParentheses(String str) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int res = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                s.push(i);
            } else {
                s.pop();
                if(s.isEmpty()){
                    s.push(i);
                } else {
                    res = Math.max(res, i - s.peek());
                }
            }
        }

        return res;
    }
}
