package android.support.p000v4.content;

import android.content.SharedPreferences;
import android.os.Build;

/* renamed from: android.support.v4.content.SharedPreferencesCompat */
public class SharedPreferencesCompat {

    /* renamed from: android.support.v4.content.SharedPreferencesCompat$EditorCompat */
    public class EditorCompat {

        /* renamed from: a */
        private static EditorCompat f778a;

        /* renamed from: b */
        private final Helper f779b;

        /* renamed from: android.support.v4.content.SharedPreferencesCompat$EditorCompat$EditorHelperApi9Impl */
        class EditorHelperApi9Impl implements Helper {
            private EditorHelperApi9Impl() {
            }

            public void apply(SharedPreferences.Editor editor) {
                EditorCompatGingerbread.apply(editor);
            }
        }

        /* renamed from: android.support.v4.content.SharedPreferencesCompat$EditorCompat$EditorHelperBaseImpl */
        class EditorHelperBaseImpl implements Helper {
            private EditorHelperBaseImpl() {
            }

            public void apply(SharedPreferences.Editor editor) {
                editor.commit();
            }
        }

        /* renamed from: android.support.v4.content.SharedPreferencesCompat$EditorCompat$Helper */
        interface Helper {
            void apply(SharedPreferences.Editor editor);
        }

        private EditorCompat() {
            if (Build.VERSION.SDK_INT >= 9) {
                this.f779b = new EditorHelperApi9Impl();
            } else {
                this.f779b = new EditorHelperBaseImpl();
            }
        }

        public static EditorCompat getInstance() {
            if (f778a == null) {
                f778a = new EditorCompat();
            }
            return f778a;
        }

        public void apply(SharedPreferences.Editor editor) {
            this.f779b.apply(editor);
        }
    }
}
