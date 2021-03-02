package android.support.p001v4.content;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;

/* renamed from: android.support.v4.content.SharedPreferencesCompat */
public class SharedPreferencesCompat {

    /* renamed from: android.support.v4.content.SharedPreferencesCompat$EditorCompat */
    public static class EditorCompat {

        /* renamed from: a */
        private static EditorCompat f485a;

        /* renamed from: b */
        private final C0128c f486b;

        /* renamed from: android.support.v4.content.SharedPreferencesCompat$EditorCompat$c */
        interface C0128c {
            /* renamed from: a */
            void mo861a(@NonNull SharedPreferences.Editor editor);
        }

        /* renamed from: android.support.v4.content.SharedPreferencesCompat$EditorCompat$b */
        static class C0127b implements C0128c {
            private C0127b() {
            }

            /* renamed from: a */
            public void mo861a(@NonNull SharedPreferences.Editor editor) {
                editor.commit();
            }
        }

        /* renamed from: android.support.v4.content.SharedPreferencesCompat$EditorCompat$a */
        static class C0126a implements C0128c {
            private C0126a() {
            }

            /* renamed from: a */
            public void mo861a(@NonNull SharedPreferences.Editor editor) {
                C0598aq.m3398a(editor);
            }
        }

        private EditorCompat() {
            if (Build.VERSION.SDK_INT >= 9) {
                this.f486b = new C0126a();
            } else {
                this.f486b = new C0127b();
            }
        }

        public static EditorCompat getInstance() {
            if (f485a == null) {
                f485a = new EditorCompat();
            }
            return f485a;
        }

        public void apply(@NonNull SharedPreferences.Editor editor) {
            this.f486b.mo861a(editor);
        }
    }
}
