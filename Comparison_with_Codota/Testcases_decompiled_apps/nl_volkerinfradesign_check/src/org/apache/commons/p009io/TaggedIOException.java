package org.apache.commons.p009io;

import java.io.IOException;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.TaggedIOException */
public class TaggedIOException extends IOExceptionWithCause {
    private static final long serialVersionUID = -6994123481142850163L;

    /* renamed from: a */
    private final Serializable f6850a;

    public static boolean isTaggedWith(Throwable th, Object obj) {
        return obj != null && (th instanceof TaggedIOException) && obj.equals(((TaggedIOException) th).f6850a);
    }

    public static void throwCauseIfTaggedWith(Throwable th, Object obj) throws IOException {
        if (isTaggedWith(th, obj)) {
            throw ((TaggedIOException) th).getCause();
        }
    }

    public TaggedIOException(IOException iOException, Serializable serializable) {
        super(iOException.getMessage(), iOException);
        this.f6850a = serializable;
    }

    public Serializable getTag() {
        return this.f6850a;
    }

    public IOException getCause() {
        return (IOException) super.getCause();
    }
}
