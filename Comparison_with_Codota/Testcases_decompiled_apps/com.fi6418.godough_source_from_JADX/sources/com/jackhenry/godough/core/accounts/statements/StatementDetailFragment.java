package com.jackhenry.godough.core.accounts.statements;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.print.PrintAttributes;
import android.print.PrintManager;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.content.FileProvider;
import android.support.p000v4.view.MenuItemCompat;
import android.support.p003v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1497al;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.accounts.statements.model.StatementDetail;
import com.jackhenry.godough.core.accounts.statements.model.StatementDetailHeader;
import com.jackhenry.godough.core.accounts.statements.widget.GoDoughStatementWebView;
import com.jackhenry.godough.core.p038e.C1567a;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1578g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StatementDetailFragment extends C1802r {
    public static final String EXTRA_STATEMENT_DETAIL = "EXTRA_STATEMENT_DETAIL";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public StatementDetailHeader f5876a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public StatementDetail f5877b;

    /* renamed from: c */
    private ShareActionProvider f5878c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public GoDoughStatementWebView f5879d;

    /* renamed from: e */
    private View f5880e;

    /* renamed from: f */
    private int f5881f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f5882g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Runnable f5883h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public TextView f5884i;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5835a(int i) {
        getActivity().runOnUiThread(new C1446g(this, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m5841d(String str) {
        if (str == null) {
            str = getString(C1506am.statements_file_error);
        }
        TextView textView = (TextView) getView().findViewById(C1494ai.pdf_error_textView);
        textView.setText(str);
        textView.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m5851n() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", getString(C1506am.statements_subject));
        FragmentActivity activity = getActivity();
        if (!(this.f5877b == null || this.f5877b.getPdfFile() == null || activity == null)) {
            File file = new File(StatementDetail.TEMP_STATEMENT_DIRECTORY, this.f5876a.getFileName());
            intent.setType("application/pdf");
            intent.putExtra("android.intent.extra.TEXT", file.getName());
            intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(getContext(), activity.getPackageName() + ".fileprovider", file));
            intent.setFlags(1);
        }
        if (this.f5878c != null) {
            this.f5878c.setShareIntent(intent);
        }
    }

    @TargetApi(19)
    /* renamed from: o */
    private void m5853o() {
        if (this.f5877b.getPdfFile() != null) {
            ((PrintManager) getActivity().getSystemService("print")).print(getActivity().getString(C1506am.app_name) + " Document", new C1440a(this.f5877b.getPageCount(), this.f5876a.getFileName()), (PrintAttributes) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m5854p() {
        if (this.f5877b == null && getActivity() != null) {
            mo10988l();
            this.f5876a = (StatementDetailHeader) getActivity().getIntent().getSerializableExtra("EXTRA_STATEMENT_DETAIL");
            getActivity().getSupportLoaderManager().initLoader(1, (Bundle) null, new C1449j(this, this, new C1447h(this)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m5855q() {
        AbstractActivity abstractActivity = (AbstractActivity) getActivity();
        if (abstractActivity != null && abstractActivity.getSupportActionBar() != null) {
            String a = C1567a.m6122a(abstractActivity, Long.valueOf(this.f5876a.getStatementDate().getTimeInMillis()));
            if (this.f5876a.isTitleIsDate()) {
                a = "";
            }
            if (!(this.f5877b == null || this.f5877b.getPdfFileSize() == null)) {
                a = getString(C1506am.statements_file_format_size, a, this.f5877b.getPdfFileSize(), getString(C1506am.statements_pdf));
            }
            abstractActivity.getSupportActionBar().setSubtitle((CharSequence) a.trim());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m5856r() {
        AbstractActivity abstractActivity = (AbstractActivity) getActivity();
        if (abstractActivity != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1574c(0, getString(C1506am.btn_no)));
            arrayList.add(new C1574c(1, getString(C1506am.btn_yes)));
            C1576e eVar = new C1576e(C1577f.SUCCESS, 1, getString(C1506am.statements_title_pdf_not_supported), getString(C1506am.statements_msg_pdf_not_supported_dialog), (List<C1574c>) arrayList);
            eVar.mo9791a((C1578g) new C1450k(this));
            abstractActivity.showDialog(eVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m5857s() {
        File file = new File(StatementDetail.TEMP_STATEMENT_DIRECTORY, this.f5876a.getFileName());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(FileProvider.getUriForFile(getContext(), getActivity().getPackageName() + ".fileprovider", file), "application/pdf");
        intent.setFlags(1);
        StatementDetail.TEMP_STATEMENT_DIRECTORY.listFiles();
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            getActivity().startActivity(intent);
        } else {
            ((AbstractActivity) getActivity()).showDialog(getString(C1506am.statements_info_title), getString(C1506am.statements_no_pdf_viewer));
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ((AbstractActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) this.f5876a.getStatementTitle());
        m5855q();
        if (this.f5877b != null) {
            mo10989m();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        this.f5882g = new Handler();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(C1497al.statements, menu);
        MenuItem findItem = menu.findItem(C1494ai.menu_share);
        MenuItem findItem2 = menu.findItem(C1494ai.menu_print);
        this.f5878c = (ShareActionProvider) MenuItemCompat.getActionProvider(findItem);
        m5851n();
        if (Build.VERSION.SDK_INT <= 19) {
            findItem2.setVisible(false);
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle == null) {
            this.f5880e = layoutInflater.inflate(C1496ak.statement_detail_fragment, viewGroup, false);
            this.f5879d = (GoDoughStatementWebView) this.f5880e.findViewById(C1494ai.statement_webview);
            this.f5879d.setWebChromeClient(new C1453n(this));
            this.f5879d.addJavascriptInterface(new C1452m(this, getActivity()), "Statements");
            this.f5884i = (TextView) this.f5880e.findViewById(C1494ai.pageCounter);
            this.f5884i.setVisibility(8);
            this.f5883h = new C1445f(this);
        } else {
            ((ViewGroup) this.f5880e.getParent()).removeView(this.f5880e);
        }
        m5854p();
        return this.f5880e;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != C1494ai.menu_print) {
            return super.onOptionsItemSelected(menuItem);
        }
        m5853o();
        return true;
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem findItem = menu.findItem(C1494ai.menu_print);
        MenuItem findItem2 = menu.findItem(C1494ai.menu_share);
        if (this.f5877b == null || this.f5877b.getPdfFile() == null) {
            findItem2.setVisible(false);
            findItem.setVisible(false);
            return;
        }
        findItem2.setVisible(true);
        if (Build.VERSION.SDK_INT >= 21) {
            findItem.setVisible(true);
        } else {
            findItem.setVisible(false);
        }
    }
}
