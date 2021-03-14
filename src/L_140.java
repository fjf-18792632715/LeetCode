
import java.util.*;

public class L_140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        if (s.length() == 0 || wordDict.isEmpty()) return res;

        // 首先构造 bp 数组
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        // 使用深度优先搜索，暴力求解，并使用双端队列接受单词，并且组成字符串添加到res中
        if (dp[s.length()]) {
            Deque<String> deque = new LinkedList<>();
            dfs(s.length(), s, res, set, dp, deque);
        }

        return res;
    }

    public void dfs(int length, String str, List<String> res, Set<String> set, boolean[] dp, Deque<String> deque) {
        if (length == 0) {
            String string = String.join(" ", deque);
            res.add(string);
            return;
        }

        for (int i = 0; i < length; i++) {
            String subString = str.substring(i, length);
            if (dp[i] && set.contains(subString)) {
                deque.addFirst(subString);
                dfs(i, str, res, set, dp, deque);
                deque.removeFirst();
            }
        }
    }
}
