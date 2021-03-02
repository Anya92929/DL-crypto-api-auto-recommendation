package com.tapcrowd.app.utils;

public class Normalizer {
    private static final String tab00c0 = "AAAAAAACEEEEIIIIDNOOOOO×ØUUUUYIßaaaaaaaceeeeiiiiðnooooo÷øuuuuyþyAaAaAaCcCcCcCcDdDdEeEeEeEeEeGgGgGgGgHhHhIiIiIiIiIiJjJjKkkLlLlLlLlLlNnNnNnnNnOoOoOoOoRrRrRrSsSsSsSsTtTtTtUuUuUuUuUuUuWwYyYZzZzZzF";

    public static String removeDiacritic(String source) {
        char[] vysl = new char[source.length()];
        for (int i = 0; i < source.length(); i++) {
            char one = source.charAt(i);
            if (one >= 192 && one <= 383) {
                one = tab00c0.charAt(one - 192);
            }
            vysl[i] = one;
        }
        return new String(vysl);
    }
}
