import java.util.Stack;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        if (s.length() == 0)
            return s;
        char[] cha = s.toCharArray();
        int count = 0;
        Stack<Character> stack = new Stack<>();
        while (count < cha.length) {
            stack.push(cha[count]);
            count++;
            while (!stack.empty() && count < cha.length) {
                Character temp = stack.peek();
                if (helper(temp, cha[count])) {
                    stack.pop();
                    count++;
                } else {
                    if (count < cha.length) {
                        stack.push(cha[count++]);
                    }
                }
            }
        }
        String newS = "";
        while (!stack.empty()) {
            newS += stack.pop();
        }
        newS = new StringBuilder(newS).reverse().toString();
        return newS;
    }

    public Boolean helper(Character A, Character B) {
        int valueOfChara = (int) A;
        if (valueOfChara >= 97 && valueOfChara <= 122) {
            if (B == Character.toUpperCase(A)) {
                return true;
            }
        } else {
            if (B == Character.toLowerCase(A)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        MakeTheStringGreat t = new MakeTheStringGreat();
        System.out.println(t.makeGood(s));
    }
}
