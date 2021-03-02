package org.apache.commons.lang3.exception;

import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

public class ContextedException extends Exception implements ExceptionContext {
    private static final long serialVersionUID = 20110706;

    /* renamed from: a */
    private final ExceptionContext f7134a;

    public ContextedException() {
        this.f7134a = new DefaultExceptionContext();
    }

    public ContextedException(String str) {
        super(str);
        this.f7134a = new DefaultExceptionContext();
    }

    public ContextedException(Throwable th) {
        super(th);
        this.f7134a = new DefaultExceptionContext();
    }

    public ContextedException(String str, Throwable th) {
        super(str, th);
        this.f7134a = new DefaultExceptionContext();
    }

    public ContextedException(String str, Throwable th, ExceptionContext exceptionContext) {
        super(str, th);
        this.f7134a = exceptionContext == null ? new DefaultExceptionContext() : exceptionContext;
    }

    public ContextedException addContextValue(String str, Object obj) {
        this.f7134a.addContextValue(str, obj);
        return this;
    }

    public ContextedException setContextValue(String str, Object obj) {
        this.f7134a.setContextValue(str, obj);
        return this;
    }

    public List<Object> getContextValues(String str) {
        return this.f7134a.getContextValues(str);
    }

    public Object getFirstContextValue(String str) {
        return this.f7134a.getFirstContextValue(str);
    }

    public List<Pair<String, Object>> getContextEntries() {
        return this.f7134a.getContextEntries();
    }

    public Set<String> getContextLabels() {
        return this.f7134a.getContextLabels();
    }

    public String getMessage() {
        return getFormattedExceptionMessage(super.getMessage());
    }

    public String getFormattedExceptionMessage(String str) {
        return this.f7134a.getFormattedExceptionMessage(str);
    }
}
