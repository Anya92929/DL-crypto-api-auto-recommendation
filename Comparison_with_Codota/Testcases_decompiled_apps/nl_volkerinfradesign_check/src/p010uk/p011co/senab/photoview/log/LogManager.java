package p010uk.p011co.senab.photoview.log;

/* renamed from: uk.co.senab.photoview.log.LogManager */
public final class LogManager {
    private static Logger logger = new LoggerDefault();

    public static void setLogger(Logger logger2) {
        logger = logger2;
    }

    public static Logger getLogger() {
        return logger;
    }
}
