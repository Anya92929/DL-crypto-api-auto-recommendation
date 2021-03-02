package android.support.p000v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.p000v4.util.SimpleArrayMap;
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
    private final FragmentHostCallback<?> f426a;

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.f426a = fragmentHostCallback;
    }

    public static final FragmentController createController(FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController(fragmentHostCallback);
    }

    public void attachHost(Fragment fragment) {
        this.f426a.f430d.attachController(this.f426a, this.f426a, fragment);
    }

    public void dispatchActivityCreated() {
        this.f426a.f430d.dispatchActivityCreated();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.f426a.f430d.dispatchConfigurationChanged(configuration);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.f426a.f430d.dispatchContextItemSelected(menuItem);
    }

    public void dispatchCreate() {
        this.f426a.f430d.dispatchCreate();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.f426a.f430d.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public void dispatchDestroy() {
        this.f426a.f430d.dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.f426a.f430d.dispatchDestroyView();
    }

    public void dispatchLowMemory() {
        this.f426a.f430d.dispatchLowMemory();
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.f426a.f430d.dispatchOptionsItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.f426a.f430d.dispatchOptionsMenuClosed(menu);
    }

    public void dispatchPause() {
        this.f426a.f430d.dispatchPause();
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.f426a.f430d.dispatchPrepareOptionsMenu(menu);
    }

    public void dispatchReallyStop() {
        this.f426a.f430d.dispatchReallyStop();
    }

    public void dispatchResume() {
        this.f426a.f430d.dispatchResume();
    }

    public void dispatchStart() {
        this.f426a.f430d.dispatchStart();
    }

    public void dispatchStop() {
        this.f426a.f430d.dispatchStop();
    }

    public void doLoaderDestroy() {
        this.f426a.mo702h();
    }

    public void doLoaderRetain() {
        this.f426a.mo701g();
    }

    public void doLoaderStart() {
        this.f426a.mo700f();
    }

    public void doLoaderStop(boolean z) {
        this.f426a.mo695a(z);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f426a.mo694a(str, fileDescriptor, printWriter, strArr);
    }

    public boolean execPendingActions() {
        return this.f426a.f430d.execPendingActions();
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        if (this.f426a.f430d.f445f == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(getActiveFragmentsCount());
        }
        list.addAll(this.f426a.f430d.f445f);
        return list;
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.f426a.f430d.f445f;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public FragmentManager getSupportFragmentManager() {
        return this.f426a.mo698d();
    }

    public LoaderManager getSupportLoaderManager() {
        return this.f426a.mo699e();
    }

    public void noteStateNotSaved() {
        this.f426a.f430d.noteStateNotSaved();
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f426a.f430d.onCreateView(view, str, context, attributeSet);
    }

    public void reportLoaderStart() {
        this.f426a.mo703i();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.f426a.f430d.mo731a(parcelable, list);
    }

    public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
        this.f426a.mo692a(simpleArrayMap);
    }

    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return this.f426a.mo704j();
    }

    public List<Fragment> retainNonConfig() {
        return this.f426a.f430d.mo742c();
    }

    public Parcelable saveAllState() {
        return this.f426a.f430d.mo744d();
    }
}
