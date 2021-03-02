package android.support.p000v4.content;

import android.content.SharedPreferences;

/* renamed from: android.support.v4.content.EditorCompatGingerbread */
class EditorCompatGingerbread {
    EditorCompatGingerbread() {
    }

    public static void apply(SharedPreferences.Editor editor) {
        try {
            editor.apply();
        } catch (AbstractMethodError e) {
            editor.commit();
        }
    }
}
