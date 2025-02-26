class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int idx = 0; idx < n; idx++){
            indices[idx] = idx;
        }

        Arrays.sort(indices, Comparator.comparingInt(idx -> positions[idx]));

        for(int curr : indices){
            if(directions.charAt(curr) == 'R'){
                stack.push(curr);
            } else {
                while(!stack.isEmpty() && healths[curr] > 0){
                    int topIdx = stack.pop();
                    if(healths[topIdx] > healths[curr]){
                        healths[topIdx] -= 1;
                        healths[curr] = 0;
                        stack.push(topIdx);
                    } else if(healths[topIdx] < healths[curr]){
                        healths[curr] -= 1;
                        healths[topIdx] = 0;
                    } else {
                        healths[curr] = 0;
                        healths[topIdx] = 0;
                    }
                }
            }
        }

        for(int idx = 0; idx < n; idx++){
            if(healths[idx] > 0){
                result.add(healths[idx]);
            }
        }

        return result;
    }
}
