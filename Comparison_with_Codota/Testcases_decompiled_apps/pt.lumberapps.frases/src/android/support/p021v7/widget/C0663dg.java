package android.support.p021v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.p009v4.app.NotificationCompat;
import android.support.p009v4.p010a.C0025a;
import android.support.p009v4.widget.C0389be;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0511g;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.widget.dg */
class C0663dg extends C0389be implements View.OnClickListener {

    /* renamed from: j */
    private final SearchManager f1613j = ((SearchManager) this.f561d.getSystemService("search"));

    /* renamed from: k */
    private final SearchView f1614k;

    /* renamed from: l */
    private final SearchableInfo f1615l;

    /* renamed from: m */
    private final Context f1616m;

    /* renamed from: n */
    private final WeakHashMap f1617n;

    /* renamed from: o */
    private final int f1618o;

    /* renamed from: p */
    private boolean f1619p = false;

    /* renamed from: q */
    private int f1620q = 1;

    /* renamed from: r */
    private ColorStateList f1621r;

    /* renamed from: s */
    private int f1622s = -1;

    /* renamed from: t */
    private int f1623t = -1;

    /* renamed from: u */
    private int f1624u = -1;

    /* renamed from: v */
    private int f1625v = -1;

    /* renamed from: w */
    private int f1626w = -1;

    /* renamed from: x */
    private int f1627x = -1;

    public C0663dg(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f1614k = searchView;
        this.f1615l = searchableInfo;
        this.f1618o = searchView.getSuggestionCommitIconResId();
        this.f1616m = context;
        this.f1617n = weakHashMap;
    }

    /* renamed from: a */
    private Drawable m2980a(ComponentName componentName) {
        Drawable.ConstantState constantState = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f1617n.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = (Drawable.ConstantState) this.f1617n.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f1616m.getResources());
        }
        Drawable b = m2987b(componentName);
        if (b != null) {
            constantState = b.getConstantState();
        }
        this.f1617n.put(flattenToShortString, constantState);
        return b;
    }

    /* renamed from: a */
    private Drawable m2981a(String str) {
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1616m.getPackageName() + "/" + parseInt;
            Drawable b = m2989b(str2);
            if (b != null) {
                return b;
            }
            Drawable drawable = C0025a.getDrawable(this.f1616m, parseInt);
            m2986a(str2, drawable);
            return drawable;
        } catch (NumberFormatException e) {
            Drawable b2 = m2989b(str);
            if (b2 != null) {
                return b2;
            }
            Drawable b3 = m2988b(Uri.parse(str));
            m2986a(str, b3);
            return b3;
        } catch (Resources.NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    /* renamed from: a */
    private static String m2982a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* renamed from: a */
    public static String m2983a(Cursor cursor, String str) {
        return m2982a(cursor, cursor.getColumnIndex(str));
    }

    /* renamed from: a */
    private void m2984a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    /* renamed from: a */
    private void m2985a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m2986a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1617n.put(str, drawable.getConstantState());
        }
    }

    /* renamed from: b */
    private Drawable m2987b(ComponentName componentName) {
        PackageManager packageManager = this.f561d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, NotificationCompat.FLAG_HIGH_PRIORITY);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    /* renamed from: b */
    private Drawable m2988b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return mo3307a(uri);
            }
            openInputStream = this.f1616m.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, (String) null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (IOException e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (Resources.NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (IOException e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
            throw th;
        }
    }

    /* renamed from: b */
    private Drawable m2989b(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f1617n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* renamed from: b */
    private CharSequence m2990b(CharSequence charSequence) {
        if (this.f1621r == null) {
            TypedValue typedValue = new TypedValue();
            this.f561d.getTheme().resolveAttribute(C0506b.textColorSearchUrl, typedValue, true);
            this.f1621r = this.f561d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.f1621r, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    /* renamed from: d */
    private void m2991d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    /* renamed from: e */
    private Drawable m2992e(Cursor cursor) {
        if (this.f1625v == -1) {
            return null;
        }
        Drawable a = m2981a(cursor.getString(this.f1625v));
        return a == null ? m2994g(cursor) : a;
    }

    /* renamed from: f */
    private Drawable m2993f(Cursor cursor) {
        if (this.f1626w == -1) {
            return null;
        }
        return m2981a(cursor.getString(this.f1626w));
    }

    /* renamed from: g */
    private Drawable m2994g(Cursor cursor) {
        Drawable a = m2980a(this.f1615l.getSearchActivity());
        return a != null ? a : this.f561d.getPackageManager().getDefaultActivityIcon();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Cursor mo3306a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.f561d.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr, (String) null);
    }

    /* renamed from: a */
    public Cursor mo1877a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f1614k.getVisibility() != 0 || this.f1614k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = mo3306a(this.f1615l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Drawable mo3307a(Uri uri) {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f561d.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    /* renamed from: a */
    public View mo1805a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.mo1805a(context, cursor, viewGroup);
        a.setTag(new C0664dh(a));
        ((ImageView) a.findViewById(C0511g.edit_query)).setImageResource(this.f1618o);
        return a;
    }

    /* renamed from: a */
    public void mo3308a(int i) {
        this.f1620q = i;
    }

    /* renamed from: a */
    public void mo1879a(Cursor cursor) {
        if (this.f1619p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo1879a(cursor);
            if (cursor != null) {
                this.f1622s = cursor.getColumnIndex("suggest_text_1");
                this.f1623t = cursor.getColumnIndex("suggest_text_2");
                this.f1624u = cursor.getColumnIndex("suggest_text_2_url");
                this.f1625v = cursor.getColumnIndex("suggest_icon_1");
                this.f1626w = cursor.getColumnIndex("suggest_icon_2");
                this.f1627x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    /* renamed from: a */
    public void mo1880a(View view, Context context, Cursor cursor) {
        C0664dh dhVar = (C0664dh) view.getTag();
        int i = this.f1627x != -1 ? cursor.getInt(this.f1627x) : 0;
        if (dhVar.f1628a != null) {
            m2985a(dhVar.f1628a, (CharSequence) m2982a(cursor, this.f1622s));
        }
        if (dhVar.f1629b != null) {
            String a = m2982a(cursor, this.f1624u);
            CharSequence b = a != null ? m2990b((CharSequence) a) : m2982a(cursor, this.f1623t);
            if (TextUtils.isEmpty(b)) {
                if (dhVar.f1628a != null) {
                    dhVar.f1628a.setSingleLine(false);
                    dhVar.f1628a.setMaxLines(2);
                }
            } else if (dhVar.f1628a != null) {
                dhVar.f1628a.setSingleLine(true);
                dhVar.f1628a.setMaxLines(1);
            }
            m2985a(dhVar.f1629b, b);
        }
        if (dhVar.f1630c != null) {
            m2984a(dhVar.f1630c, m2992e(cursor), 4);
        }
        if (dhVar.f1631d != null) {
            m2984a(dhVar.f1631d, m2993f(cursor), 8);
        }
        if (this.f1620q == 2 || (this.f1620q == 1 && (i & 1) != 0)) {
            dhVar.f1632e.setVisibility(0);
            dhVar.f1632e.setTag(dhVar.f1628a.getText());
            dhVar.f1632e.setOnClickListener(this);
            return;
        }
        dhVar.f1632e.setVisibility(8);
    }

    /* renamed from: c */
    public CharSequence mo1883c(Cursor cursor) {
        String a;
        String a2;
        if (cursor == null) {
            return null;
        }
        String a3 = m2983a(cursor, "suggest_intent_query");
        if (a3 != null) {
            return a3;
        }
        if (this.f1615l.shouldRewriteQueryFromData() && (a2 = m2983a(cursor, "suggest_intent_data")) != null) {
            return a2;
        }
        if (!this.f1615l.shouldRewriteQueryFromText() || (a = m2983a(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return a;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = mo1805a(this.f561d, this.f560c, viewGroup);
            if (a != null) {
                ((C0664dh) a.getTag()).f1628a.setText(e.toString());
            }
            return a;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m2991d(mo1876a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m2991d(mo1876a());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1614k.mo2773a((CharSequence) tag);
        }
    }
}
