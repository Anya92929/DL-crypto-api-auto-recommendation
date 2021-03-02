package com.jackhenry.android.widget.quickactionmenu;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class ActionItem {

    /* renamed from: a */
    private Drawable f5680a;

    /* renamed from: b */
    private Bitmap f5681b;

    /* renamed from: c */
    private String f5682c;

    /* renamed from: d */
    private int f5683d;

    /* renamed from: e */
    private boolean f5684e;

    /* renamed from: f */
    private boolean f5685f;

    public ActionItem() {
        this(-1, (String) null, (Drawable) null);
    }

    public ActionItem(int i, Drawable drawable) {
        this(i, (String) null, drawable);
    }

    public ActionItem(int i, String str) {
        this(i, str, (Drawable) null);
    }

    public ActionItem(int i, String str, Drawable drawable) {
        this.f5683d = -1;
        this.f5682c = str;
        this.f5680a = drawable;
        this.f5683d = i;
    }

    public ActionItem(Drawable drawable) {
        this(-1, (String) null, drawable);
    }

    public int getActionId() {
        return this.f5683d;
    }

    public Drawable getIcon() {
        return this.f5680a;
    }

    public Bitmap getThumb() {
        return this.f5681b;
    }

    public String getTitle() {
        return this.f5682c;
    }

    public boolean isSelected() {
        return this.f5684e;
    }

    public boolean isSticky() {
        return this.f5685f;
    }

    public void setActionId(int i) {
        this.f5683d = i;
    }

    public void setIcon(Drawable drawable) {
        this.f5680a = drawable;
    }

    public void setSelected(boolean z) {
        this.f5684e = z;
    }

    public void setSticky(boolean z) {
        this.f5685f = z;
    }

    public void setThumb(Bitmap bitmap) {
        this.f5681b = bitmap;
    }

    public void setTitle(String str) {
        this.f5682c = str;
    }
}
