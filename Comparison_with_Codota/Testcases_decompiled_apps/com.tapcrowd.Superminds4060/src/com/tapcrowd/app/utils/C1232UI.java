package com.tapcrowd.app.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.support.p000v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockListActivity;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCActivity;
import com.tapcrowd.app.TCListActivity;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.PdfUtil;
import com.tapcrowd.app.views.Cell;
import com.tapcrowd.app.views.Notifier;
import com.tapcrowd.app.views.SectionView;
import com.tapcrowd.app.views.Separator;
import org.apache.cordova.Globalization;

/* renamed from: com.tapcrowd.app.utils.UI */
public class C1232UI {
    static Typeface bold;
    static Typeface regular;

    public static void show(int id) {
        try {
            App.act.findViewById(id).setVisibility(0);
        } catch (Exception e) {
        }
    }

    public static void show(int id, View v) {
        try {
            v.findViewById(id).setVisibility(0);
        } catch (Exception e) {
        }
    }

    public static void hide(int id) {
        try {
            App.act.findViewById(id).setVisibility(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Cell addCell2(View v, String text, View.OnClickListener ocl, Drawable draw) {
        Cell c = new Cell(text, draw);
        if (text != null) {
            if (ocl == null) {
                c.hideArrow();
            } else {
                c.setOnClickListener(ocl);
            }
            ((LinearLayout) v.findViewById(C0846R.C0847id.container2)).addView(c);
        }
        return c;
    }

    public static Cell addCell(View v, String text) {
        Cell c = new Cell(text);
        ((LinearLayout) v.findViewById(C0846R.C0847id.container)).addView(c);
        return c;
    }

    public static Cell addCell(View v, String text, View.OnClickListener ocl, Drawable draw) {
        Cell c = new Cell(text, draw);
        if (text != null) {
            if (ocl == null) {
                c.hideArrow();
            } else {
                c.setOnClickListener(ocl);
            }
            ((LinearLayout) v.findViewById(C0846R.C0847id.container)).addView(c);
        }
        return c;
    }

    public static Cell addCell(View v, String text, View.OnClickListener ocl, int maxlines, Drawable draw) {
        Cell c = new Cell(text, draw);
        if (text != null) {
            if (ocl == null) {
                c.hideArrow();
            } else {
                c.setOnClickListener(ocl);
            }
            c.setMaxLines(maxlines);
            ((LinearLayout) v.findViewById(C0846R.C0847id.container)).addView(c);
        }
        return c;
    }

    public static Cell addCell(View v, String text, View.OnClickListener ocl, int draw) {
        Cell c = new Cell(text, draw);
        if (text != null) {
            if (ocl == null) {
                c.hideArrow();
            } else {
                c.setOnClickListener(ocl);
            }
            ((LinearLayout) v.findViewById(C0846R.C0847id.container)).addView(c);
        }
        return c;
    }

    public static void hide(int id, View v) {
        try {
            v.findViewById(id).setVisibility(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setText(int id, String text) {
        setText(id, text, true);
    }

    public static void setText(int id, String text, View v) {
        try {
            TextView tv = (TextView) v.findViewById(id);
            tv.setTextColor(C1216LO.getLo(C1216LO.textcolor));
            if (text != null) {
                tv.setText(text);
            } else {
                tv.setVisibility(8);
            }
        } catch (Exception e) {
        }
    }

    public static void setText(int id, String text, boolean setColor) {
        try {
            TextView tv = (TextView) App.act.findViewById(id);
            if (setColor) {
                tv.setTextColor(C1216LO.getLo(C1216LO.textcolor));
            }
            tv.setText(Converter.unicodeToString(text));
        } catch (Exception e) {
        }
    }

    public static void setTextColor(int id, int color) {
        ((TextView) App.act.findViewById(id)).setTextColor(color);
    }

    public static void setTextColor(int id, int color, View v) {
        ((TextView) v.findViewById(id)).setTextColor(color);
    }

    public static void setColor(int resourceid, int controlid, View v) {
        if (controlid == 1) {
            try {
                ((TextView) v.findViewById(resourceid)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
            } catch (Exception e) {
            }
        }
    }

    public static void setTitle(String text) {
        ActionBar actionbar = null;
        try {
            if (App.act.getClass() == TCActivity.class) {
                actionbar = ((SherlockActivity) App.act).getSupportActionBar();
            } else if (App.act.getClass() == TCListActivity.class) {
                actionbar = ((SherlockListActivity) App.act).getSupportActionBar();
            }
            if (!text.equalsIgnoreCase("img")) {
                actionbar.setDisplayShowHomeEnabled(false);
                actionbar.setTitle((CharSequence) text.toUpperCase());
            } else if (C1216LO.navbarTitleImage == 0) {
                actionbar.setDisplayShowHomeEnabled(false);
                actionbar.setTitle((CharSequence) Html.fromHtml(C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get(DBFavorites.KEY_NAME, "TapCrowd")));
            } else {
                actionbar.setTitle((CharSequence) Html.fromHtml(C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get(DBFavorites.KEY_NAME, "TapCrowd")));
            }
        } catch (Exception e) {
        }
    }

    public static void log(String text) {
        Log.d("v2", text);
    }

    public static void notify(String text, int color) {
        notify(0, text, color, false, true);
    }

    public static void notify(int resourceid, String text, int color, boolean autohide, boolean animate) {
        try {
            App.notify = text;
            App.notifycolor = color;
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(-1, -2);
            lp.addRule(12);
            Notifier nf = new Notifier(resourceid);
            nf.setVisibility(8);
            final RelativeLayout main = (RelativeLayout) App.act.findViewById(C0846R.C0847id.main);
            if (main != null) {
                hideNotification(false);
                main.addView(nf, lp);
                main.invalidate();
            }
            TranslateAnimation slide = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 100.0f, BitmapDescriptorFactory.HUE_RED);
            slide.setDuration(500);
            slide.setFillAfter(true);
            nf.startAnimation(slide);
            if (autohide) {
                App.notify = "";
                if (main != null) {
                    Animation.AnimationListener myListener = new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            for (int i = 0; i < main.getChildCount(); i++) {
                                if (main.getChildAt(i).getClass() == Notifier.class) {
                                    main.getChildAt(i).setVisibility(8);
                                }
                            }
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    };
                    TranslateAnimation hide = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 100.0f);
                    hide.setStartOffset(3000);
                    hide.setDuration(1000);
                    hide.setFillAfter(true);
                    hide.setAnimationListener(myListener);
                    for (int i = 0; i < main.getChildCount(); i++) {
                        if (main.getChildAt(i).getClass() == Notifier.class) {
                            main.getChildAt(i).startAnimation(hide);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hideNotification(Boolean animate) {
        try {
            final ViewGroup rl = (ViewGroup) App.act.findViewById(C0846R.C0847id.main);
            if (rl == null) {
                return;
            }
            if (animate.booleanValue()) {
                Animation.AnimationListener myListener = new Animation.AnimationListener() {
                    public void onAnimationEnd(Animation animation) {
                        for (int i = 0; i < rl.getChildCount(); i++) {
                            if (rl.getChildAt(i).getClass() == Notifier.class) {
                                rl.getChildAt(i).setVisibility(8);
                            }
                        }
                    }

                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }
                };
                TranslateAnimation slide = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 100.0f);
                slide.setDuration(1000);
                slide.setFillAfter(true);
                slide.setAnimationListener(myListener);
                for (int i = 0; i < rl.getChildCount(); i++) {
                    View child = rl.getChildAt(i);
                    if (child.getClass() == Notifier.class && child.getVisibility() != 8) {
                        child.startAnimation(slide);
                    }
                }
                return;
            }
            for (int i2 = 0; i2 < rl.getChildCount(); i2++) {
                if (rl.getChildAt(i2).getClass() == Notifier.class) {
                    rl.getChildAt(i2).setVisibility(8);
                }
            }
            rl.invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addCell(String text, View.OnClickListener ocl) {
        Cell c = new Cell(text);
        c.setOnClickListener(ocl);
        ((LinearLayout) App.act.findViewById(C0846R.C0847id.container)).addView(c);
    }

    public static void addCell(int resource, View.OnClickListener ocl) {
        addCell(App.act.getString(resource), ocl);
    }

    public static void addSep(String text) {
        ((LinearLayout) App.act.findViewById(C0846R.C0847id.container)).addView(new Separator(text));
    }

    public static void addSep(String text, View v) {
        ((LinearLayout) v.findViewById(C0846R.C0847id.container)).addView(new Separator(text));
    }

    public static void addSep(String text, ViewGroup parent, View v) {
        parent.addView(new Separator(text));
    }

    public static Cell addCell(String text) {
        Cell c = new Cell(text);
        ((LinearLayout) App.act.findViewById(C0846R.C0847id.container)).addView(c);
        return c;
    }

    public static void addCell(String text, boolean arrow) {
        ((LinearLayout) App.act.findViewById(C0846R.C0847id.container)).addView(new Cell(text, arrow));
    }

    public static Cell addCell(String text, View.OnClickListener ocl, int draw) {
        Cell c = new Cell(text, draw);
        if (text != null) {
            if (ocl == null) {
                c.hideArrow();
            } else {
                c.setOnClickListener(ocl);
            }
            ((LinearLayout) App.act.findViewById(C0846R.C0847id.container)).addView(c);
        }
        return c;
    }

    public static Cell addCell2(String text, View.OnClickListener ocl, int draw) {
        Cell c = new Cell(text, draw);
        if (text != null) {
            if (ocl == null) {
                c.hideArrow();
            } else {
                c.setOnClickListener(ocl);
            }
            ((LinearLayout) App.act.findViewById(C0846R.C0847id.container2)).addView(c);
        }
        return c;
    }

    public static Cell addCell2(String text, View.OnClickListener ocl, Drawable draw) {
        Cell c = new Cell(text, draw);
        if (text != null) {
            if (ocl == null) {
                c.hideArrow();
            } else {
                c.setOnClickListener(ocl);
            }
            ((LinearLayout) App.act.findViewById(C0846R.C0847id.container2)).addView(c);
        }
        return c;
    }

    public static Cell addCell(String text, View.OnClickListener ocl, Drawable draw) {
        Cell c = new Cell(text, draw);
        if (text != null) {
            if (ocl == null) {
                c.hideArrow();
            } else {
                c.setOnClickListener(ocl);
            }
            ((LinearLayout) App.act.findViewById(C0846R.C0847id.container)).addView(c);
        }
        return c;
    }

    public static Cell addCell(String text, int draw) {
        Cell c = new Cell(text, draw);
        c.hideArrow();
        ((LinearLayout) App.act.findViewById(C0846R.C0847id.container)).addView(c);
        return c;
    }

    public static void addCell(String text, View.OnClickListener ocl, int draw, int color) {
        if (text != null) {
            Cell c = new Cell(text, draw);
            if (ocl == null) {
                c.hideArrow();
            } else {
                c.setOnClickListener(ocl);
            }
            c.f2140tv.setTextColor(-1);
            ((LinearLayout) App.act.findViewById(C0846R.C0847id.container)).addView(c);
        }
    }

    public static Cell addCell(ViewGroup parent, String text, View.OnClickListener ocl, int draw) {
        Cell c = new Cell(text, draw);
        if (text != null) {
            if (ocl == null) {
                c.hideArrow();
            } else {
                c.setOnClickListener(ocl);
            }
            parent.addView(c);
        }
        return c;
    }

    public static Cell addCell(ViewGroup parent, String text, View.OnClickListener ocl, int maxlines, int draw) {
        Cell c = new Cell(text, draw);
        if (text != null) {
            if (ocl == null) {
                c.hideArrow();
            } else {
                c.setOnClickListener(ocl);
            }
            c.setMaxLines(maxlines);
            parent.addView(c);
        }
        return c;
    }

    public static Cell addCell(int resource, View.OnClickListener ocl, int draw) {
        Cell c = new Cell(App.act.getString(resource), draw);
        c.setOnClickListener(ocl);
        ((LinearLayout) App.act.findViewById(C0846R.C0847id.container)).addView(c);
        return c;
    }

    public static void setColor(int resourceid, int controlid) {
        if (controlid == 1) {
            ((TextView) App.act.findViewById(resourceid)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
        }
    }

    public static void setOverlay(int imageview, int drawableid, int color) {
        ((ImageView) App.act.findViewById(imageview)).setBackgroundDrawable(getColorOverlay(drawableid, color));
    }

    public static void setOverlay(int imageview, int drawableid, int color, View v) {
        ((ImageView) v.findViewById(imageview)).setBackgroundDrawable(getColorOverlay(drawableid, color));
    }

    public static Drawable getColorOverlay(int resourceid, int color) {
        try {
            Drawable drawable = App.act.getResources().getDrawable(resourceid);
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            drawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
            drawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            return drawable;
        } catch (Exception e) {
            try {
                return App.act.getResources().getDrawable(resourceid);
            } catch (Exception e2) {
                return null;
            }
        }
    }

    public static Drawable getColorOverlay(Drawable drawable, int color) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        drawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        drawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        return drawable;
    }

    public static StateListDrawable getBackground() {
        StateListDrawable states = new StateListDrawable();
        ColorDrawable drawable = new ColorDrawable(C1216LO.getLo(C1216LO.tableviewHighlight));
        states.addState(new int[]{16842919}, drawable);
        states.addState(new int[]{16842908}, drawable);
        states.addState(new int[0], new ColorDrawable(0));
        return states;
    }

    public static void setFont(ViewGroup parent) {
        if (regular == null) {
            regular = Typeface.createFromAsset(App.act.getAssets(), "ProximaNova-Regular.otf");
        }
        if (bold == null) {
            bold = Typeface.createFromAsset(App.act.getAssets(), "ProximaNova-Bold.otf");
        }
        int mCount = parent.getChildCount();
        for (int i = 0; i < mCount; i++) {
            View mChild = parent.getChildAt(i);
            if (mChild instanceof TextView) {
                setFont((TextView) mChild);
            } else if (mChild instanceof ViewGroup) {
                setFont((ViewGroup) mChild);
            }
        }
    }

    public static void setFont(TextView view) {
        if (view.getTypeface() == Typeface.DEFAULT_BOLD || view.getTypeface() == bold) {
            view.setTypeface(bold);
        } else {
            view.setTypeface(regular);
        }
    }

    public static void AddDropDownMetaData(Fragment fr, String parenttype, String parentid, View v) {
        AddDropDownMetaData(fr, (ViewGroup) v.findViewById(C0846R.C0847id.container), parenttype, parentid, v);
    }

    public static void AddDropDownMetaData(Fragment fr, ViewGroup parent, String parenttype, String parentid, View v) {
        SectionView.Type type;
        SectionView section = null;
        for (TCObject meta : C1199DB.getQueryFromDb("SELECT * FROM metavalues WHERE parentType = '" + parenttype + "' AND parentId = '" + parentid + "' AND type != 'custom' ORDER BY sortorder +0 DESC")) {
            if (meta.get(Globalization.TYPE).equals("header")) {
                section = new SectionView((Context) fr.getActivity(), meta.get("value"));
                parent.addView(section);
            } else if (section != null && meta.get(Globalization.TYPE).equals("text")) {
                String val = meta.get("value");
                String text = val.split(";;;")[0];
                String typeStr = "";
                if (val.split(";;;").length > 1) {
                    typeStr = val.split(";;;")[1];
                }
                if (typeStr.equals("(v)")) {
                    type = SectionView.Type.Yes;
                } else if (typeStr.equals("-")) {
                    type = SectionView.Type.f2142No;
                } else if (typeStr.equals("opt")) {
                    type = SectionView.Type.Optional;
                } else {
                    type = SectionView.Type.None;
                }
                section.addView(text, type);
            }
        }
    }

    public static void AddMetaData(Fragment fr, String parenttype, String parentid, View v) {
        AddMetaData(fr, (ViewGroup) v.findViewById(C0846R.C0847id.container), parenttype, parentid, v);
    }

    public static void AddMetaData(final Fragment fr, ViewGroup parent, String parenttype, String parentid, View v) {
        for (final TCObject meta : C1199DB.getQueryFromDb("SELECT * FROM metavalues WHERE parentType = '" + parenttype + "' AND parentId = '" + parentid + "' ORDER BY sortorder +0 DESC")) {
            int drawable = 0;
            View.OnClickListener click = null;
            String text = null;
            int maxlines = 0;
            if (meta.get(Globalization.TYPE).equals("header")) {
                addSep(meta.get("value"), parent, v);
            } else if (!meta.get(Globalization.TYPE).equals("image") && !meta.get(DBFavorites.KEY_NAME).equalsIgnoreCase("keywords") && !meta.get(DBFavorites.KEY_NAME).equalsIgnoreCase("markericon")) {
                if (meta.get(Globalization.TYPE).equals("email")) {
                    drawable = C0846R.drawable.icon_email;
                    getColorOverlay((int) C0846R.drawable.icon_email, C1216LO.getLo(C1216LO.actionImageOverlayColor));
                    maxlines = 1;
                    click = new View.OnClickListener() {
                        public void onClick(View v) {
                            Actions.doMail(TCObject.this.get("value"));
                        }
                    };
                } else if (meta.get(Globalization.TYPE).equals("phone")) {
                    drawable = C0846R.drawable.icon_tel;
                    getColorOverlay((int) C0846R.drawable.icon_tel, C1216LO.getLo(C1216LO.actionImageOverlayColor));
                    click = new View.OnClickListener() {
                        public void onClick(View v) {
                            Actions.doCall(TCObject.this.get("value"));
                        }
                    };
                } else if (meta.get(Globalization.TYPE).equals("fax")) {
                    drawable = C0846R.drawable.icon_fax;
                    getColorOverlay((int) C0846R.drawable.icon_fax, C1216LO.getLo(C1216LO.actionImageOverlayColor));
                } else if (meta.get(Globalization.TYPE).equals(PlusShare.KEY_CALL_TO_ACTION_URL)) {
                    maxlines = 1;
                    if (meta.get("value").endsWith("pdf")) {
                        String text2 = meta.get("value");
                        String text3 = text2.substring(text2.lastIndexOf(47) + 1);
                        text = text3.substring(0, text3.lastIndexOf(".")).replace("_", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).replace("-", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        drawable = C0846R.drawable.icon_attachment;
                        getColorOverlay((int) C0846R.drawable.icon_attachment, C1216LO.getLo(C1216LO.actionImageOverlayColor));
                        click = new View.OnClickListener() {
                            public void onClick(View v) {
                                new PdfUtil(App.act, (PdfUtil.PdfLoadFinishedListener) null).showPdf(TCObject.this.get("value"));
                            }
                        };
                    } else {
                        drawable = C0846R.drawable.icon_website;
                        getColorOverlay((int) C0846R.drawable.icon_website, C1216LO.getLo(C1216LO.actionImageOverlayColor));
                        maxlines = 1;
                        click = new View.OnClickListener() {
                            public void onClick(View v) {
                                Actions.openWebview(Fragment.this, meta.get("value"));
                            }
                        };
                    }
                } else if (meta.get(Globalization.TYPE).equals("pdf")) {
                    text = meta.get(DBFavorites.KEY_NAME);
                    drawable = C0846R.drawable.icon_attachment;
                    getColorOverlay((int) C0846R.drawable.icon_attachment, C1216LO.getLo(C1216LO.actionImageOverlayColor));
                    click = new View.OnClickListener() {
                        public void onClick(View v) {
                            new PdfUtil(App.act, (PdfUtil.PdfLoadFinishedListener) null).showPdf(TCObject.this.get("value"));
                        }
                    };
                } else if (meta.get(Globalization.TYPE).equals("location")) {
                    drawable = C0846R.drawable.icon_navigate_white;
                    getColorOverlay((int) C0846R.drawable.icon_navigate_white, C1216LO.getLo(C1216LO.actionImageOverlayColor));
                    text = meta.get(DBFavorites.KEY_NAME);
                    click = new View.OnClickListener() {
                        public void onClick(View v) {
                            App.act.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("geo:" + TCObject.this.get("value") + "?q=" + TCObject.this.get("value"))));
                        }
                    };
                }
                if (text == null) {
                    text = meta.get("value", "");
                }
                addCell(parent, text, click, maxlines, drawable).setBackgroundDrawable(getBackground());
            }
        }
    }
}
