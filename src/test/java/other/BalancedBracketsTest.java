package other;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class BalancedBracketsTest {

//    Write a function that returns true if the brackets in a given string are balanced.
//    The function must handle curve brackets (), square brackets [], and curly brackets {}.
//    Examples:
//    check("[()]{}{[()()]()}") = true
//    check("[(])") = false

    @Test
    public void balancedBrackets() {
        List<Character> characterList = stringToCharList("[(])");
        boolean ok = isBalanced(characterList, '(', ')', 0) && isBalanced(characterList, '[', ']', 0) && isBalanced(characterList, '{', '}', 0);
        System.out.println(ok);
    }

    private boolean isBalanced(List<Character> characterList, Character first, Character last, int open) {
        if (characterList.isEmpty()) {
            return open == 0;
        } else {
            if (characterList.get(0).equals(first)) {
                characterList.remove(characterList.get(0));
                return isBalanced(characterList, first, last, open + 1);
            } else {
                if (characterList.get(0).equals(last)) {
                    characterList.remove(characterList.get(0));
                    return open > 0 && isBalanced(characterList, first, last, open - 1);
                } else {
                    characterList.remove(characterList.get(0));
                    return isBalanced(characterList, first, last, open);
                }
            }
        }
    }

    private List<Character> stringToCharList(String s) {
        return s.chars().mapToObj(x -> (char) x).collect(Collectors.toList());
    }
}
