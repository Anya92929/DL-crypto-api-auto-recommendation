package p006nl.volkerinfradesign.checkandroid.p007ui.main;

import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.EnumUtils;
import p006nl.volkerinfradesign.checkandroid.App;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.main.DrawerItem */
public enum DrawerItem {
    A_FORMS_HEADER {
        public String getMime() {
            throw new UnsupportedOperationException();
        }

        public CharSequence getText(Context context) {
            return "Formulieren";
        }

        public Uri getUri(App app) {
            throw new UnsupportedOperationException();
        }

        public int getViewType() {
            return 1;
        }

        public boolean isEnabled() {
            return false;
        }
    },
    B_NEW_FORM {
        public String getMime() {
            throw new UnsupportedOperationException();
        }

        public CharSequence getText(Context context) {
            return "Nieuw formulier";
        }

        public Uri getUri(App app) {
            throw new UnsupportedOperationException();
        }

        public int getViewType() {
            return 0;
        }

        public boolean isEnabled() {
            return true;
        }
    },
    C_OPEN_FORMS {
        public String getMime() {
            throw new UnsupportedOperationException();
        }

        public CharSequence getText(Context context) {
            return "Openstaand";
        }

        public Uri getUri(App app) {
            throw new UnsupportedOperationException();
        }

        public int getViewType() {
            return 0;
        }

        public boolean isEnabled() {
            return true;
        }
    },
    D_FINISHED_FORMS {
        public String getMime() {
            throw new UnsupportedOperationException();
        }

        public CharSequence getText(Context context) {
            return "Ingediend";
        }

        public Uri getUri(App app) {
            throw new UnsupportedOperationException();
        }

        public int getViewType() {
            return 0;
        }

        public boolean isEnabled() {
            return true;
        }
    },
    E_TODOS {
        public String getMime() {
            throw new UnsupportedOperationException();
        }

        public CharSequence getText(Context context) {
            return "Taken";
        }

        public Uri getUri(App app) throws IOException {
            throw new UnsupportedOperationException();
        }

        public int getViewType() {
            return 0;
        }

        public boolean isEnabled() {
            return true;
        }
    },
    O_MISCELLANEOUS_HEADER {
        public String getMime() {
            throw new UnsupportedOperationException();
        }

        public CharSequence getText(Context context) {
            return "Overig";
        }

        public Uri getUri(App app) throws IOException {
            throw new UnsupportedOperationException();
        }

        public int getViewType() {
            return 1;
        }

        public boolean isEnabled() {
            return false;
        }
    },
    Q_ACCOUNT_INFO {
        public String getMime() {
            throw new UnsupportedOperationException();
        }

        public CharSequence getText(Context context) {
            return "Gebruiker";
        }

        public Uri getUri(App app) throws IOException {
            throw new UnsupportedOperationException();
        }

        public int getViewType() {
            return 2;
        }

        public boolean isEnabled() {
            return false;
        }
    },
    R_HELP {
        public String getMime() {
            return "application/pdf";
        }

        public CharSequence getText(Context context) {
            return "Help";
        }

        public Uri getUri(App app) {
            throw new UnsupportedOperationException();
        }

        public int getViewType() {
            return 2;
        }

        public boolean isEnabled() {
            return false;
        }
    };

    public abstract String getMime();

    public abstract CharSequence getText(Context context);

    public abstract Uri getUri(App app) throws IOException;

    public abstract int getViewType();

    public abstract boolean isEnabled();

    public static List<DrawerItem> getAdapterContent() {
        return Collections.unmodifiableList(EnumUtils.getEnumList(DrawerItem.class));
    }
}
