import java.util.*;

public class Solution {
    public static boolean isValid(String s) {
        s = s.replaceAll("\\s+", "");
        if (s.isEmpty() || "+-*/".contains(s.charAt(0) + "") || "+-*/".contains(s.charAt(s.length() - 1) + "")) {
            return false;
        }

        Stack<Character> st = new Stack<>();
        boolean lastWasOperator = true;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                lastWasOperator = false;
            } else if ("+-*/^".indexOf(ch) != -1) {
                if (lastWasOperator) return false;
                lastWasOperator = true;
            } else if (ch == '(') {
                st.push(ch);
                lastWasOperator = true;
            } else if (ch == ')') {
                if (st.isEmpty() || st.pop() != '(') return false;
                lastWasOperator = false;
            } else {
                return false;
            }
        }
        return st.isEmpty() && !lastWasOperator;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter expressions separated by a newline. Type 'END' to finish:");
        List<String> expressions = new ArrayList<>();

        while (sc.hasNextLine()) {
            String expr = sc.nextLine();
            if (expr.equalsIgnoreCase("END")) break;
            expressions.add(expr);
        }

        for (String expr : expressions) {
            System.out.println("Expression: " + expr + " → " + (isValid(expr) ? "Valid ✅" : "Invalid ❌"));
        }
        sc.close();
    }
}
