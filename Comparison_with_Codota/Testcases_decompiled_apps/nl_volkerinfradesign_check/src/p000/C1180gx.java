package p000;

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
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: gx */
class C1180gx extends Resources {

    /* renamed from: a */
    private final Resources f4202a;

    public C1180gx(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f4202a = resources;
    }

    public CharSequence getText(int i) throws Resources.NotFoundException {
        return this.f4202a.getText(i);
    }

    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        return this.f4202a.getQuantityText(i, i2);
    }

    public String getString(int i) throws Resources.NotFoundException {
        return this.f4202a.getString(i);
    }

    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        return this.f4202a.getString(i, objArr);
    }

    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        return this.f4202a.getQuantityString(i, i2, objArr);
    }

    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        return this.f4202a.getQuantityString(i, i2);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        return this.f4202a.getText(i, charSequence);
    }

    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        return this.f4202a.getTextArray(i);
    }

    public String[] getStringArray(int i) throws Resources.NotFoundException {
        return this.f4202a.getStringArray(i);
    }

    public int[] getIntArray(int i) throws Resources.NotFoundException {
        return this.f4202a.getIntArray(i);
    }

    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.f4202a.obtainTypedArray(i);
    }

    public float getDimension(int i) throws Resources.NotFoundException {
        return this.f4202a.getDimension(i);
    }

    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        return this.f4202a.getDimensionPixelOffset(i);
    }

    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        return this.f4202a.getDimensionPixelSize(i);
    }

    public float getFraction(int i, int i2, int i3) {
        return this.f4202a.getFraction(i, i2, i3);
    }

    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        return this.f4202a.getDrawable(i);
    }

    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        return this.f4202a.getDrawable(i, theme);
    }

    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        return this.f4202a.getDrawableForDensity(i, i2);
    }

    public Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) {
        return this.f4202a.getDrawableForDensity(i, i2, theme);
    }

    public Movie getMovie(int i) throws Resources.NotFoundException {
        return this.f4202a.getMovie(i);
    }

    public int getColor(int i) throws Resources.NotFoundException {
        return this.f4202a.getColor(i);
    }

    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        return this.f4202a.getColorStateList(i);
    }

    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.f4202a.getBoolean(i);
    }

    public int getInteger(int i) throws Resources.NotFoundException {
        return this.f4202a.getInteger(i);
    }

    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        return this.f4202a.getLayout(i);
    }

    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        return this.f4202a.getAnimation(i);
    }

    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.f4202a.getXml(i);
    }

    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        return this.f4202a.openRawResource(i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f4202a.openRawResource(i, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        return this.f4202a.openRawResourceFd(i);
    }

    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f4202a.getValue(i, typedValue, z);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f4202a.getValueForDensity(i, i2, typedValue, z);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f4202a.getValue(str, typedValue, z);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f4202a.obtainAttributes(attributeSet, iArr);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        if (this.f4202a != null) {
            this.f4202a.updateConfiguration(configuration, displayMetrics);
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f4202a.getDisplayMetrics();
    }

    public Configuration getConfiguration() {
        return this.f4202a.getConfiguration();
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f4202a.getIdentifier(str, str2, str3);
    }

    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.f4202a.getResourceName(i);
    }

    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.f4202a.getResourcePackageName(i);
    }

    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.f4202a.getResourceTypeName(i);
    }

    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.f4202a.getResourceEntryName(i);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f4202a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f4202a.parseBundleExtra(str, attributeSet, bundle);
    }
}
