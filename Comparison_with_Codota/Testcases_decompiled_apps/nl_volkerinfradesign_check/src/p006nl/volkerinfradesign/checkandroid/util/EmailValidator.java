package p006nl.volkerinfradesign.checkandroid.util;

import java.util.regex.Pattern;

/* renamed from: nl.volkerinfradesign.checkandroid.util.EmailValidator */
public class EmailValidator {
    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isValid(String str) {
        return pattern.matcher(str).matches();
    }
}
