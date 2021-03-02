package android.support.annotation;

public @interface Size {
    long max();

    long min();

    long multiple();

    long value();
}
