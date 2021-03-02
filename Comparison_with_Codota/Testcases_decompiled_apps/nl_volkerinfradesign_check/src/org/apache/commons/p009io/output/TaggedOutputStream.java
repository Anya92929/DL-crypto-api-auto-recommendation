package org.apache.commons.p009io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.UUID;
import org.apache.commons.p009io.TaggedIOException;

/* renamed from: org.apache.commons.io.output.TaggedOutputStream */
public class TaggedOutputStream extends ProxyOutputStream {

    /* renamed from: a */
    private final Serializable f6999a = UUID.randomUUID();

    public TaggedOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public boolean isCauseOf(Exception exc) {
        return TaggedIOException.isTaggedWith(exc, this.f6999a);
    }

    public void throwIfCauseOf(Exception exc) throws IOException {
        TaggedIOException.throwCauseIfTaggedWith(exc, this.f6999a);
    }

    /* access modifiers changed from: protected */
    public void handleIOException(IOException iOException) throws IOException {
        throw new TaggedIOException(iOException, this.f6999a);
    }
}
