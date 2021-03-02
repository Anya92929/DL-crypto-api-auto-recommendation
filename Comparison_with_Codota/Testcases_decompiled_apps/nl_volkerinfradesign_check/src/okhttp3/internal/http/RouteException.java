package okhttp3.internal.http;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RouteException extends Exception {

    /* renamed from: a */
    private static final Method f6240a;

    /* renamed from: b */
    private IOException f6241b;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception e) {
            method = null;
        }
        f6240a = method;
    }

    public RouteException(IOException iOException) {
        super(iOException);
        this.f6241b = iOException;
    }

    public IOException getLastConnectException() {
        return this.f6241b;
    }

    public void addConnectException(IOException iOException) {
        m6855a(iOException, this.f6241b);
        this.f6241b = iOException;
    }

    /* renamed from: a */
    private void m6855a(IOException iOException, IOException iOException2) {
        if (f6240a != null) {
            try {
                f6240a.invoke(iOException, new Object[]{iOException2});
            } catch (IllegalAccessException | InvocationTargetException e) {
            }
        }
    }
}
