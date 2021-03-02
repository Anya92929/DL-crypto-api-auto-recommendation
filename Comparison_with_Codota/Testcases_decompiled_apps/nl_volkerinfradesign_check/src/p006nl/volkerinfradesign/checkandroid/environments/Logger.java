package p006nl.volkerinfradesign.checkandroid.environments;

import java.io.File;
import java.io.IOException;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.Logger */
public interface Logger {

    /* renamed from: nl.volkerinfradesign.checkandroid.environments.Logger$LogCursor */
    public interface LogCursor extends ViTaCursor {
        String getMessage();

        String getThrowable(boolean z, boolean z2);

        Verbosity getVerbosity();

        boolean hasThrowable();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.environments.Logger$Verbosity */
    public enum Verbosity {
        DEBUG,
        ERROR,
        INFO,
        VERBOSE,
        WARN
    }

    LogCursor get(Verbosity... verbosityArr);

    void info(String str);

    void logError(String str, Throwable th);

    File writeReport(File file) throws IOException;
}
