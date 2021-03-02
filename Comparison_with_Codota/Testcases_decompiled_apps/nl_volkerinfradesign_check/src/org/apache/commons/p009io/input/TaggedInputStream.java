package org.apache.commons.p009io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.UUID;
import org.apache.commons.p009io.TaggedIOException;

/* renamed from: org.apache.commons.io.input.TaggedInputStream */
public class TaggedInputStream extends ProxyInputStream {

    /* renamed from: a */
    private final Serializable f6940a = UUID.randomUUID();

    public TaggedInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public boolean isCauseOf(Throwable th) {
        return TaggedIOException.isTaggedWith(th, this.f6940a);
    }

    public void throwIfCauseOf(Throwable th) throws IOException {
        TaggedIOException.throwCauseIfTaggedWith(th, this.f6940a);
    }

    /* access modifiers changed from: protected */
    public void handleIOException(IOException iOException) throws IOException {
        throw new TaggedIOException(iOException, this.f6940a);
    }
}
