package org.apache.commons.lang3.exception;

import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

public class ContextedRuntimeException extends RuntimeException implements ExceptionContext {
    private static final long serialVersionUID = 20110706;

    /* renamed from: a */
    private final ExceptionContext f7135a;

    public ContextedRuntimeException() {
        this.f7135a = new DefaultExceptionContext();
    }

    public ContextedRuntimeException(String str) {
        super(str);
        this.f7135a = new DefaultExceptionContext();
    }

    public ContextedRuntimeException(Throwable th) {
        super(th);
        this.f7135a = new DefaultExceptionContext();
    }

    public ContextedRuntimeException(String str, Throwable th) {
        super(str, th);
        this.f7135a = new DefaultExceptionContext();
    }

    public ContextedRuntimeException(String str, Throwable th, ExceptionContext exceptionContext) {
        super(str, th);
        this.f7135a = exceptionContext == null ? new DefaultExceptionContext() : exceptionContext;
    }

    public ContextedRuntimeException addContextValue(String str, Object obj) {
        this.f7135a.addContextValue(str, obj);
        return this;
    }

    public ContextedRuntimeException setContextValue(String str, Object obj) {
        this.f7135a.setContextValue(str, obj);
        return this;
    }

    public List<Object> getContextValues(String str) {
        return this.f7135a.getContextValues(str);
    }

    public Object getFirstContextValue(String str) {
        return this.f7135a.getFirstContextValue(str);
    }

    public List<Pair<String, Object>> getContextEntries() {
        return this.f7135a.getContextEntries();
    }

    public Set<String> getContextLabels() {
        return this.f7135a.getContextLabels();
    }

    public String getMessage() {
        return getFormattedExceptionMessage(super.getMessage());
    }

    public String getFormattedExceptionMessage(String str) {
        return this.f7135a.getFormattedExceptionMessage(str);
    }
}
