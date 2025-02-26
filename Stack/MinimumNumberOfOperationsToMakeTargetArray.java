class Solution {
    public int minNumberOperations(int[] target) {
        int sum = target[0];
        int len = target.length;
        Stack<Integer> s = new Stack<>();
        s.push(sum);
        for(int i = 0; i < len; i++){
            if(s.peek() < target[i]){
                sum += target[i] - s.peek();
            }
            s.push(target[i]);
        }
        return sum;
    }
}
