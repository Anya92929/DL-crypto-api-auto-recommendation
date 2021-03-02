package mono.android;

public class TypeManager {
    private static native void n_activate(String str, String str2, Object obj, Object[] objArr);

    public static void Activate(String str, String str2, Object obj, Object[] objArr) {
        n_activate(str, str2, obj, objArr);
    }

    static {
        Runtime.register("Java.Interop.TypeManager, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null", TypeManager.class, "n_activate:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V:GetActivateHandler\n");
    }
}
