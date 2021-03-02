package android.support.p003v7.app;

/* renamed from: android.support.v7.app.ActionBarActivityDelegateHC */
class ActionBarActivityDelegateHC extends ActionBarActivityDelegateBase {
    ActionBarActivityDelegateHC(ActionBarActivity activity) {
        super(activity);
    }

    public ActionBar createSupportActionBar() {
        ensureSubDecor();
        return new ActionBarImplHC(this.mActivity, this.mActivity);
    }
}
