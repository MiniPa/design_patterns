package algorithm.hot100;

import net.minidev.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * SlidingWindow: 滑动窗口
 *
 * @version 0.0.1  @date: 2021-10-27
 * @author: <a href="mailto:jiushun.cheng@zhangmen.com">jiushun.cheng</a>
 */
public class SlidingWindow {

    public static String s = "ADOBECODEBANC";
    public static String t = "ABC";

    public static Map<Character, Integer> ori = new HashMap<>();
    public static Map<Character, Integer> cnt = new HashMap<>();

    public static void main(String[] args) {
        SlidingWindow window = new SlidingWindow();
        String result = window.minWindow(SlidingWindow.s, t);
        System.out.println(result);
    }


    public String minWindow(String s, String t) {
        int tlen = t.length();
        for (int i = 0; i < tlen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        System.out.println("ori ==> " + ori.toString());

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int slen = s.length();

        while (r < slen) {
            ++r;
            if (r < slen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator<Map.Entry<Character, Integer>> iterator = ori.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }










}
