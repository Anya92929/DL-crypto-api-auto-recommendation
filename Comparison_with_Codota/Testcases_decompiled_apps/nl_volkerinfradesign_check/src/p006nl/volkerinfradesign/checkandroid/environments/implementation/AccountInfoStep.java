package p006nl.volkerinfradesign.checkandroid.environments.implementation;

@Deprecated
/* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.AccountInfoStep */
public enum AccountInfoStep {
    A_INITIAL_VALUES,
    B_CHANGED,
    C_UPDATED;

    public String ordinalString() {
        return Integer.valueOf(ordinal()).toString();
    }
}
