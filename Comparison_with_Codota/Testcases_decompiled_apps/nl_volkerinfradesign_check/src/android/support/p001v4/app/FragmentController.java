package android.support.p001v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.p001v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.app.FragmentController */
public class FragmentController {

    /* renamed from: a */
    private final FragmentHostCallback<?> f192a;

    public static final FragmentController createController(FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController(fragmentHostCallback);
    }

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.f192a = fragmentHostCallback;
    }

    public FragmentManager getSupportFragmentManager() {
        return this.f192a.mo409e();
    }

    public LoaderManager getSupportLoaderManager() {
        return this.f192a.mo410f();
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.f192a.f196d.f7295f;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.f192a.f196d.f7295f == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.f192a.f196d.f7295f);
        return list;
    }

    public void attachHost(Fragment fragment) {
        this.f192a.f196d.mo13803a((FragmentHostCallback) this.f192a, (FragmentContainer) this.f192a, fragment);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f192a.f196d.onCreateView(view, str, context, attributeSet);
    }

    public void noteStateNotSaved() {
        this.f192a.f196d.mo13825f();
    }

    public Parcelable saveAllState() {
        return this.f192a.f196d.mo13821e();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.f192a.f196d.mo13798a(parcelable, list);
    }

    public List<Fragment> retainNonConfig() {
        return this.f192a.f196d.mo13818d();
    }

    public void dispatchCreate() {
        this.f192a.f196d.mo13826g();
    }

    public void dispatchActivityCreated() {
        this.f192a.f196d.mo13827h();
    }

    public void dispatchStart() {
        this.f192a.f196d.mo13828i();
    }

    public void dispatchResume() {
        this.f192a.f196d.mo13829j();
    }

    public void dispatchPause() {
        this.f192a.f196d.mo13830k();
    }

    public void dispatchStop() {
        this.f192a.f196d.mo13831l();
    }

    public void dispatchReallyStop() {
        this.f192a.f196d.mo13832m();
    }

    public void dispatchDestroyView() {
        this.f192a.f196d.mo13833n();
    }

    public void dispatchDestroy() {
        this.f192a.f196d.mo13834o();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.f192a.f196d.mo13797a(configuration);
    }

    public void dispatchLowMemory() {
        this.f192a.f196d.mo13835p();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.f192a.f196d.mo13807a(menu, menuInflater);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.f192a.f196d.mo13806a(menu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.f192a.f196d.mo13808a(menuItem);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.f192a.f196d.mo13814b(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.f192a.f196d.mo13812b(menu);
    }

    public boolean execPendingActions() {
        return this.f192a.f196d.mo13813b();
    }

    public void doLoaderStart() {
        this.f192a.mo412h();
    }

    public void doLoaderStop(boolean z) {
        this.f192a.mo405a(z);
    }

    public void doLoaderRetain() {
        this.f192a.mo413i();
    }

    public void doLoaderDestroy() {
        this.f192a.mo414j();
    }

    public void reportLoaderStart() {
        this.f192a.mo415k();
    }

    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return this.f192a.mo416l();
    }

    public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
        this.f192a.mo402a(simpleArrayMap);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f192a.mo404a(str, fileDescriptor, printWriter, strArr);
    }
}
