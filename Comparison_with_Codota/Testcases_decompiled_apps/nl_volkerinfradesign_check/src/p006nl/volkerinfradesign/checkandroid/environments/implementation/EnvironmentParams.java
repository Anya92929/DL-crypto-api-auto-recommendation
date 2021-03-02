package p006nl.volkerinfradesign.checkandroid.environments.implementation;

import android.content.Context;
import java.util.Locale;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.EnvironmentParams */
public final class EnvironmentParams {
    public final String accountType;
    public final Context context;
    public final String formsDir;
    public final C1510a nameSpace;

    EnvironmentParams(Context context2, C1510a aVar, String str, String str2) {
        this.context = context2;
        this.nameSpace = aVar;
        this.formsDir = str;
        this.accountType = str2;
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.EnvironmentParams$a */
    public enum C1510a {
        CHECK,
        SEKEUR,
        WAVE,
        STENA_LINE,
        ISALADELTA;

        public String toString() {
            return super.toString().toLowerCase(Locale.getDefault()) + "_";
        }
    }
}
