package mono.android;

public class Runtime {
    public static native void init(String str, String[] strArr, String str2, String[] strArr2, ClassLoader classLoader, String str3, String[] strArr3, String str4);

    public static native void notifyTimeZoneChanged();

    public static native void register(String str, Class cls, String str2);

    private Runtime() {
    }
}
