package android.support.p000v4.content;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/* renamed from: android.support.v4.content.EditorCompatGingerbread */
class EditorCompatGingerbread {
    EditorCompatGingerbread() {
    }

    public static void apply(@NonNull SharedPreferences.Editor editor) {
        try {
            editor.apply();
        } catch (AbstractMethodError e) {
            editor.commit();
        }
    }
}
