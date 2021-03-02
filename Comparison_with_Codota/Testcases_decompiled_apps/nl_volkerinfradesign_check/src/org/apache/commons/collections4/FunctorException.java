package org.apache.commons.collections4;

public class FunctorException extends RuntimeException {
    private static final long serialVersionUID = -4704772662059351193L;

    public FunctorException() {
    }

    public FunctorException(String str) {
        super(str);
    }

    public FunctorException(Throwable th) {
        super(th);
    }

    public FunctorException(String str, Throwable th) {
        super(str, th);
    }
}
