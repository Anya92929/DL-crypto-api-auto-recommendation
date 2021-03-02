package p006nl.volkerinfradesign.checkandroid;

/* renamed from: nl.volkerinfradesign.checkandroid.OnBackPressedObservable */
public interface OnBackPressedObservable {

    /* renamed from: nl.volkerinfradesign.checkandroid.OnBackPressedObservable$OnBackPressedObserver */
    public interface OnBackPressedObserver {
        boolean onActivityBackPressed();
    }

    void registerOnBackPressedObserver(OnBackPressedObserver onBackPressedObserver);

    void unregisterOnBackPressedObserver(OnBackPressedObserver onBackPressedObserver);
}
