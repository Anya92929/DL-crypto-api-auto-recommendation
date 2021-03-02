package p000;

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
import android.support.p001v4.content.ContextCompat;
import android.support.p001v4.widget.ResourceCursorAdapter;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.widget.SearchView;
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

/* renamed from: gz */
public class C1182gz extends ResourceCursorAdapter implements View.OnClickListener {

    /* renamed from: a */
    private final SearchManager f4211a = ((SearchManager) this.mContext.getSystemService("search"));

    /* renamed from: b */
    private final SearchView f4212b;

    /* renamed from: c */
    private final SearchableInfo f4213c;

    /* renamed from: d */
    private final Context f4214d;

    /* renamed from: e */
    private final WeakHashMap<String, Drawable.ConstantState> f4215e;

    /* renamed from: f */
    private final int f4216f;

    /* renamed from: g */
    private boolean f4217g = false;

    /* renamed from: h */
    private int f4218h = 1;

    /* renamed from: i */
    private ColorStateList f4219i;

    /* renamed from: j */
    private int f4220j = -1;

    /* renamed from: k */
    private int f4221k = -1;

    /* renamed from: l */
    private int f4222l = -1;

    /* renamed from: m */
    private int f4223m = -1;

    /* renamed from: n */
    private int f4224n = -1;

    /* renamed from: o */
    private int f4225o = -1;

    public C1182gz(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f4212b = searchView;
        this.f4213c = searchableInfo;
        this.f4216f = searchView.getSuggestionCommitIconResId();
        this.f4214d = context;
        this.f4215e = weakHashMap;
    }

    /* renamed from: a */
    public void mo8260a(int i) {
        this.f4218h = i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f4212b.getVisibility() != 0 || this.f4212b.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = mo8258a(this.f4213c, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m5239a(getCursor());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m5239a(getCursor());
    }

    /* renamed from: a */
    private void m5239a(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    public void changeCursor(Cursor cursor) {
        if (this.f4217g) {
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
                this.f4220j = cursor.getColumnIndex("suggest_text_1");
                this.f4221k = cursor.getColumnIndex("suggest_text_2");
                this.f4222l = cursor.getColumnIndex("suggest_text_2_url");
                this.f4223m = cursor.getColumnIndex("suggest_icon_1");
                this.f4224n = cursor.getColumnIndex("suggest_icon_2");
                this.f4225o = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new C1183a(newView));
        ((ImageView) newView.findViewById(C0505R.C0507id.edit_query)).setImageResource(this.f4216f);
        return newView;
    }

    /* renamed from: gz$a */
    static final class C1183a {

        /* renamed from: a */
        public final TextView f4226a;

        /* renamed from: b */
        public final TextView f4227b;

        /* renamed from: c */
        public final ImageView f4228c;

        /* renamed from: d */
        public final ImageView f4229d;

        /* renamed from: e */
        public final ImageView f4230e;

        public C1183a(View view) {
            this.f4226a = (TextView) view.findViewById(16908308);
            this.f4227b = (TextView) view.findViewById(16908309);
            this.f4228c = (ImageView) view.findViewById(16908295);
            this.f4229d = (ImageView) view.findViewById(16908296);
            this.f4230e = (ImageView) view.findViewById(C0505R.C0507id.edit_query);
        }
    }

    public void bindView(View view, Context context, Cursor cursor) {
        int i;
        CharSequence a;
        C1183a aVar = (C1183a) view.getTag();
        if (this.f4225o != -1) {
            i = cursor.getInt(this.f4225o);
        } else {
            i = 0;
        }
        if (aVar.f4226a != null) {
            m5241a(aVar.f4226a, (CharSequence) m5237a(cursor, this.f4220j));
        }
        if (aVar.f4227b != null) {
            String a2 = m5237a(cursor, this.f4222l);
            if (a2 != null) {
                a = m5236a((CharSequence) a2);
            } else {
                a = m5237a(cursor, this.f4221k);
            }
            if (TextUtils.isEmpty(a)) {
                if (aVar.f4226a != null) {
                    aVar.f4226a.setSingleLine(false);
                    aVar.f4226a.setMaxLines(2);
                }
            } else if (aVar.f4226a != null) {
                aVar.f4226a.setSingleLine(true);
                aVar.f4226a.setMaxLines(1);
            }
            m5241a(aVar.f4227b, a);
        }
        if (aVar.f4228c != null) {
            m5240a(aVar.f4228c, m5244b(cursor), 4);
        }
        if (aVar.f4229d != null) {
            m5240a(aVar.f4229d, m5247c(cursor), 8);
        }
        if (this.f4218h == 2 || (this.f4218h == 1 && (i & 1) != 0)) {
            aVar.f4230e.setVisibility(0);
            aVar.f4230e.setTag(aVar.f4226a.getText());
            aVar.f4230e.setOnClickListener(this);
            return;
        }
        aVar.f4230e.setVisibility(8);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f4212b.mo4422a((CharSequence) tag);
        }
    }

    /* renamed from: a */
    private CharSequence m5236a(CharSequence charSequence) {
        if (this.f4219i == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(C0505R.attr.textColorSearchUrl, typedValue, true);
            this.f4219i = this.mContext.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.f4219i, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    /* renamed from: a */
    private void m5241a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    /* renamed from: b */
    private Drawable m5244b(Cursor cursor) {
        if (this.f4223m == -1) {
            return null;
        }
        Drawable a = m5235a(cursor.getString(this.f4223m));
        return a == null ? m5248d(cursor) : a;
    }

    /* renamed from: c */
    private Drawable m5247c(Cursor cursor) {
        if (this.f4224n == -1) {
            return null;
        }
        return m5235a(cursor.getString(this.f4224n));
    }

    /* renamed from: a */
    private void m5240a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public CharSequence convertToString(Cursor cursor) {
        String a;
        String a2;
        if (cursor == null) {
            return null;
        }
        String a3 = m5238a(cursor, "suggest_intent_query");
        if (a3 != null) {
            return a3;
        }
        if (this.f4213c.shouldRewriteQueryFromData() && (a2 = m5238a(cursor, "suggest_intent_data")) != null) {
            return a2;
        }
        if (!this.f4213c.shouldRewriteQueryFromText() || (a = m5238a(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return a;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newView = newView(this.mContext, this.mCursor, viewGroup);
            if (newView != null) {
                ((C1183a) newView.getTag()).f4226a.setText(e.toString());
            }
            return newView;
        }
    }

    /* renamed from: a */
    private Drawable m5235a(String str) {
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f4214d.getPackageName() + "/" + parseInt;
            Drawable b = m5246b(str2);
            if (b != null) {
                return b;
            }
            Drawable drawable = ContextCompat.getDrawable(this.f4214d, parseInt);
            m5242a(str2, drawable);
            return drawable;
        } catch (NumberFormatException e) {
            Drawable b2 = m5246b(str);
            if (b2 != null) {
                return b2;
            }
            Drawable b3 = m5245b(Uri.parse(str));
            m5242a(str, b3);
            return b3;
        } catch (Resources.NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    /* renamed from: b */
    private Drawable m5245b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return mo8259a(uri);
            }
            openInputStream = this.f4214d.getContentResolver().openInputStream(uri);
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
    private Drawable m5246b(String str) {
        Drawable.ConstantState constantState = this.f4215e.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* renamed from: a */
    private void m5242a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f4215e.put(str, drawable.getConstantState());
        }
    }

    /* renamed from: d */
    private Drawable m5248d(Cursor cursor) {
        Drawable a = m5234a(this.f4213c.getSearchActivity());
        return a != null ? a : this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    /* renamed from: a */
    private Drawable m5234a(ComponentName componentName) {
        Drawable.ConstantState constantState = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f4215e.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.f4215e.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f4214d.getResources());
        }
        Drawable b = m5243b(componentName);
        if (b != null) {
            constantState = b.getConstantState();
        }
        this.f4215e.put(flattenToShortString, constantState);
        return b;
    }

    /* renamed from: b */
    private Drawable m5243b(ComponentName componentName) {
        PackageManager packageManager = this.mContext.getPackageManager();
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

    /* renamed from: a */
    public static String m5238a(Cursor cursor, String str) {
        return m5237a(cursor, cursor.getColumnIndex(str));
    }

    /* renamed from: a */
    private static String m5237a(Cursor cursor, int i) {
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

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Drawable mo8259a(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
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

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Cursor mo8258a(SearchableInfo searchableInfo, String str, int i) {
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
        return this.mContext.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr, (String) null);
    }
}
