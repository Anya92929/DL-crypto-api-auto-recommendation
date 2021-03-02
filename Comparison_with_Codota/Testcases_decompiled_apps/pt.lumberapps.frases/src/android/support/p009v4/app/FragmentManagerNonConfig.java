package android.support.p009v4.app;

import java.util.List;

/* renamed from: android.support.v4.app.FragmentManagerNonConfig */
public class FragmentManagerNonConfig {
    private final List mChildNonConfigs;
    private final List mFragments;

    FragmentManagerNonConfig(List list, List list2) {
        this.mFragments = list;
        this.mChildNonConfigs = list2;
    }

    /* access modifiers changed from: package-private */
    public List getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    /* access modifiers changed from: package-private */
    public List getFragments() {
        return this.mFragments;
    }
}
