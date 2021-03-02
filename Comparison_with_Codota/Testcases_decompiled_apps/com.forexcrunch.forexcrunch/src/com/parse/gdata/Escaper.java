package com.parse.gdata;

public interface Escaper {
    Appendable escape(Appendable appendable);

    String escape(String str);
}
