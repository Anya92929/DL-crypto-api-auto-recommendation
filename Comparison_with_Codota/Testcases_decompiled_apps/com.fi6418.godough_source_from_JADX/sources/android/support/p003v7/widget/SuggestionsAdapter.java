package android.support.p003v7.widget;

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
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.widget.ResourceCursorAdapter;
import android.support.p003v7.appcompat.C0235R;
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

/* renamed from: android.support.v7.widget.SuggestionsAdapter */
class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {

    /* renamed from: j */
    private final SearchManager f3186j = ((SearchManager) this.f1432d.getSystemService("search"));

    /* renamed from: k */
    private final SearchView f3187k;

    /* renamed from: l */
    private final SearchableInfo f3188l;

    /* renamed from: m */
    private final Context f3189m;

    /* renamed from: n */
    private final WeakHashMap<String, Drawable.ConstantState> f3190n;

    /* renamed from: o */
    private final int f3191o;

    /* renamed from: p */
    private boolean f3192p = false;

    /* renamed from: q */
    private int f3193q = 1;

    /* renamed from: r */
    private ColorStateList f3194r;

    /* renamed from: s */
    private int f3195s = -1;

    /* renamed from: t */
    private int f3196t = -1;

    /* renamed from: u */
    private int f3197u = -1;

    /* renamed from: v */
    private int f3198v = -1;

    /* renamed from: w */
    private int f3199w = -1;

    /* renamed from: x */
    private int f3200x = -1;

    /* renamed from: android.support.v7.widget.SuggestionsAdapter$ChildViewCache */
    final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View view) {
            this.mText1 = (TextView) view.findViewById(16908308);
            this.mText2 = (TextView) view.findViewById(16908309);
            this.mIcon1 = (ImageView) view.findViewById(16908295);
            this.mIcon2 = (ImageView) view.findViewById(16908296);
            this.mIconRefine = (ImageView) view.findViewById(C0235R.C0237id.edit_query);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f3187k = searchView;
        this.f3188l = searchableInfo;
        this.f3191o = searchView.getSuggestionCommitIconResId();
        this.f3189m = context;
        this.f3190n = weakHashMap;
    }

    /* renamed from: a */
    private Drawable m2347a(ComponentName componentName) {
        Drawable.ConstantState constantState = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f3190n.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.f3190n.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f3189m.getResources());
        }
        Drawable b = m2355b(componentName);
        if (b != null) {
            constantState = b.getConstantState();
        }
        this.f3190n.put(flattenToShortString, constantState);
        return b;
    }

    /* renamed from: a */
    private Drawable m2348a(String str) {
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f3189m.getPackageName() + "/" + parseInt;
            Drawable b = m2358b(str2);
            if (b != null) {
                return b;
            }
            Drawable drawable = ContextCompat.getDrawable(this.f3189m, parseInt);
            m2354a(str2, drawable);
            return drawable;
        } catch (NumberFormatException e) {
            Drawable b2 = m2358b(str);
            if (b2 != null) {
                return b2;
            }
            Drawable b3 = m2357b(Uri.parse(str));
            m2354a(str, b3);
            return b3;
        } catch (Resources.NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    /* renamed from: a */
    private CharSequence m2349a(CharSequence charSequence) {
        if (this.f3194r == null) {
            TypedValue typedValue = new TypedValue();
            this.f1432d.getTheme().resolveAttribute(C0235R.attr.textColorSearchUrl, typedValue, true);
            this.f3194r = this.f1432d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.f3194r, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    /* renamed from: a */
    private static String m2350a(Cursor cursor, int i) {
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
    private void m2351a(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    /* renamed from: a */
    private void m2352a(ImageView imageView, Drawable drawable, int i) {
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
    private void m2353a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m2354a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f3190n.put(str, drawable.getConstantState());
        }
    }

    /* renamed from: b */
    private Drawable m2355b(ComponentName componentName) {
        PackageManager packageManager = this.f1432d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
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
    private Drawable m2356b(Cursor cursor) {
        if (this.f3198v == -1) {
            return null;
        }
        Drawable a = m2348a(cursor.getString(this.f3198v));
        return a == null ? m2360d(cursor) : a;
    }

    /* renamed from: b */
    private Drawable m2357b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return mo6095a(uri);
            }
            openInputStream = this.f3189m.getContentResolver().openInputStream(uri);
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
    private Drawable m2358b(String str) {
        Drawable.ConstantState constantState = this.f3190n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* renamed from: c */
    private Drawable m2359c(Cursor cursor) {
        if (this.f3199w == -1) {
            return null;
        }
        return m2348a(cursor.getString(this.f3199w));
    }

    /* renamed from: d */
    private Drawable m2360d(Cursor cursor) {
        Drawable a = m2347a(this.f3188l.getSearchActivity());
        return a != null ? a : this.f1432d.getPackageManager().getDefaultActivityIcon();
    }

    public static String getColumnString(Cursor cursor, String str) {
        return m2350a(cursor, cursor.getColumnIndex(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Cursor mo6094a(SearchableInfo searchableInfo, String str, int i) {
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
        return this.f1432d.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr, (String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Drawable mo6095a(Uri uri) {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f1432d.getPackageManager().getResourcesForApplication(authority);
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

    public void bindView(View view, Context context, Cursor cursor) {
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i = this.f3200x != -1 ? cursor.getInt(this.f3200x) : 0;
        if (childViewCache.mText1 != null) {
            m2353a(childViewCache.mText1, (CharSequence) m2350a(cursor, this.f3195s));
        }
        if (childViewCache.mText2 != null) {
            String a = m2350a(cursor, this.f3197u);
            CharSequence a2 = a != null ? m2349a((CharSequence) a) : m2350a(cursor, this.f3196t);
            if (TextUtils.isEmpty(a2)) {
                if (childViewCache.mText1 != null) {
                    childViewCache.mText1.setSingleLine(false);
                    childViewCache.mText1.setMaxLines(2);
                }
            } else if (childViewCache.mText1 != null) {
                childViewCache.mText1.setSingleLine(true);
                childViewCache.mText1.setMaxLines(1);
            }
            m2353a(childViewCache.mText2, a2);
        }
        if (childViewCache.mIcon1 != null) {
            m2352a(childViewCache.mIcon1, m2356b(cursor), 4);
        }
        if (childViewCache.mIcon2 != null) {
            m2352a(childViewCache.mIcon2, m2359c(cursor), 8);
        }
        if (this.f3193q == 2 || (this.f3193q == 1 && (i & 1) != 0)) {
            childViewCache.mIconRefine.setVisibility(0);
            childViewCache.mIconRefine.setTag(childViewCache.mText1.getText());
            childViewCache.mIconRefine.setOnClickListener(this);
            return;
        }
        childViewCache.mIconRefine.setVisibility(8);
    }

    public void changeCursor(Cursor cursor) {
        if (this.f3192p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.f3195s = cursor.getColumnIndex("suggest_text_1");
                this.f3196t = cursor.getColumnIndex("suggest_text_2");
                this.f3197u = cursor.getColumnIndex("suggest_text_2_url");
                this.f3198v = cursor.getColumnIndex("suggest_icon_1");
                this.f3199w = cursor.getColumnIndex("suggest_icon_2");
                this.f3200x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public void close() {
        changeCursor((Cursor) null);
        this.f3192p = true;
    }

    public CharSequence convertToString(Cursor cursor) {
        String columnString;
        String columnString2;
        if (cursor == null) {
            return null;
        }
        String columnString3 = getColumnString(cursor, "suggest_intent_query");
        if (columnString3 != null) {
            return columnString3;
        }
        if (this.f3188l.shouldRewriteQueryFromData() && (columnString2 = getColumnString(cursor, "suggest_intent_data")) != null) {
            return columnString2;
        }
        if (!this.f3188l.shouldRewriteQueryFromText() || (columnString = getColumnString(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return columnString;
    }

    public int getQueryRefinement() {
        return this.f3193q;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newView = newView(this.f1432d, this.f1431c, viewGroup);
            if (newView != null) {
                ((ChildViewCache) newView.getTag()).mText1.setText(e.toString());
            }
            return newView;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new ChildViewCache(newView));
        ((ImageView) newView.findViewById(C0235R.C0237id.edit_query)).setImageResource(this.f3191o);
        return newView;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m2351a(getCursor());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m2351a(getCursor());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f3187k.mo5944a((CharSequence) tag);
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f3187k.getVisibility() != 0 || this.f3187k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = mo6094a(this.f3188l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    public void setQueryRefinement(int i) {
        this.f3193q = i;
    }
}
