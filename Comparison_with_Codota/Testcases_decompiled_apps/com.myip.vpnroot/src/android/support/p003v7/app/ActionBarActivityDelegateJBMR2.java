package android.support.p003v7.app;

/* renamed from: android.support.v7.app.ActionBarActivityDelegateJBMR2 */
class ActionBarActivityDelegateJBMR2 extends ActionBarActivityDelegateJB {
    ActionBarActivityDelegateJBMR2(ActionBarActivity activity) {
        super(activity);
    }

    public ActionBar createSupportActionBar() {
        return new ActionBarImplJBMR2(this.mActivity, this.mActivity);
    }
}
