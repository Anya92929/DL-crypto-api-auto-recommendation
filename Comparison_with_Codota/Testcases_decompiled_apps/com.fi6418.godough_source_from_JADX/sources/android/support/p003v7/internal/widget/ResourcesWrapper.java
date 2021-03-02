package android.support.p003v7.internal.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

/* renamed from: android.support.v7.internal.widget.ResourcesWrapper */
class ResourcesWrapper extends Resources {

    /* renamed from: a */
    private final Resources f2333a;

    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2333a = resources;
    }

    public XmlResourceParser getAnimation(int i) {
        return this.f2333a.getAnimation(i);
    }

    public boolean getBoolean(int i) {
        return this.f2333a.getBoolean(i);
    }

    public int getColor(int i) {
        return this.f2333a.getColor(i);
    }

    public ColorStateList getColorStateList(int i) {
        return this.f2333a.getColorStateList(i);
    }

    public Configuration getConfiguration() {
        return this.f2333a.getConfiguration();
    }

    public float getDimension(int i) {
        return this.f2333a.getDimension(i);
    }

    public int getDimensionPixelOffset(int i) {
        return this.f2333a.getDimensionPixelOffset(i);
    }

    public int getDimensionPixelSize(int i) {
        return this.f2333a.getDimensionPixelSize(i);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f2333a.getDisplayMetrics();
    }

    public Drawable getDrawable(int i) {
        return this.f2333a.getDrawable(i);
    }

    public Drawable getDrawable(int i, Resources.Theme theme) {
        return this.f2333a.getDrawable(i, theme);
    }

    public Drawable getDrawableForDensity(int i, int i2) {
        return this.f2333a.getDrawableForDensity(i, i2);
    }

    public Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) {
        return this.f2333a.getDrawableForDensity(i, i2, theme);
    }

    public float getFraction(int i, int i2, int i3) {
        return this.f2333a.getFraction(i, i2, i3);
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f2333a.getIdentifier(str, str2, str3);
    }

    public int[] getIntArray(int i) {
        return this.f2333a.getIntArray(i);
    }

    public int getInteger(int i) {
        return this.f2333a.getInteger(i);
    }

    public XmlResourceParser getLayout(int i) {
        return this.f2333a.getLayout(i);
    }

    public Movie getMovie(int i) {
        return this.f2333a.getMovie(i);
    }

    public String getQuantityString(int i, int i2) {
        return this.f2333a.getQuantityString(i, i2);
    }

    public String getQuantityString(int i, int i2, Object... objArr) {
        return this.f2333a.getQuantityString(i, i2, objArr);
    }

    public CharSequence getQuantityText(int i, int i2) {
        return this.f2333a.getQuantityText(i, i2);
    }

    public String getResourceEntryName(int i) {
        return this.f2333a.getResourceEntryName(i);
    }

    public String getResourceName(int i) {
        return this.f2333a.getResourceName(i);
    }

    public String getResourcePackageName(int i) {
        return this.f2333a.getResourcePackageName(i);
    }

    public String getResourceTypeName(int i) {
        return this.f2333a.getResourceTypeName(i);
    }

    public String getString(int i) {
        return this.f2333a.getString(i);
    }

    public String getString(int i, Object... objArr) {
        return this.f2333a.getString(i, objArr);
    }

    public String[] getStringArray(int i) {
        return this.f2333a.getStringArray(i);
    }

    public CharSequence getText(int i) {
        return this.f2333a.getText(i);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        return this.f2333a.getText(i, charSequence);
    }

    public CharSequence[] getTextArray(int i) {
        return this.f2333a.getTextArray(i);
    }

    public void getValue(int i, TypedValue typedValue, boolean z) {
        this.f2333a.getValue(i, typedValue, z);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) {
        this.f2333a.getValue(str, typedValue, z);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        this.f2333a.getValueForDensity(i, i2, typedValue, z);
    }

    public XmlResourceParser getXml(int i) {
        return this.f2333a.getXml(i);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f2333a.obtainAttributes(attributeSet, iArr);
    }

    public TypedArray obtainTypedArray(int i) {
        return this.f2333a.obtainTypedArray(i);
    }

    public InputStream openRawResource(int i) {
        return this.f2333a.openRawResource(i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) {
        return this.f2333a.openRawResource(i, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int i) {
        return this.f2333a.openRawResourceFd(i);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.f2333a.parseBundleExtra(str, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.f2333a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        if (this.f2333a != null) {
            this.f2333a.updateConfiguration(configuration, displayMetrics);
        }
    }
}
