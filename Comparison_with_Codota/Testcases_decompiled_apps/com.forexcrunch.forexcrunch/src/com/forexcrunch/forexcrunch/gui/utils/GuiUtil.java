package com.forexcrunch.forexcrunch.gui.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.app.FragmentTransaction;
import android.support.p000v4.view.MotionEventCompat;
import android.text.Html;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.gui.SearchResultsActivity;
import com.forexcrunch.forexcrunch.local.LocalFragmentManager;
import com.forexcrunch.forexcrunch.model.Post;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.TimeZone;

public class GuiUtil {
    static final int REQUEST_CODE_RECOVER_PLAY_SERVICES = 1001;
    private static boolean isPaused;
    /* access modifiers changed from: private */
    public static boolean isShowingDialog = false;
    private static FragmentTransaction pendingTransaction;

    public static void attachFragment(FragmentActivity activity, int id, Fragment fragment) {
        if (pushToFragmentStack(activity, fragment)) {
            LocalFragmentManager.getInstance(activity).removeFromStack(fragment);
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(C0089R.anim.fragment_right_in_animation, C0089R.anim.fragment_left_out_animation);
            if (fragmentManager.findFragmentById(id) == null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(id, fragment);
                fragmentTransaction.addToBackStack((String) null);
                fragmentTransaction.commit();
                return;
            }
            FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
            fragmentTransaction2.replace(id, fragment);
            fragmentTransaction2.addToBackStack((String) null);
            if (!isPaused) {
                fragmentTransaction2.commit();
            } else {
                pendingTransaction = fragmentTransaction2;
            }
        }
    }

    public static void executePending(FragmentActivity activity) {
        if (pendingTransaction != null && !isPaused) {
            pendingTransaction.commit();
            pendingTransaction = null;
        }
    }

    public static boolean pushToFragmentStack(FragmentActivity activity, Fragment fragment) {
        LocalFragmentManager.getInstance(activity).getFragmentStack(-1).push(activity.getSupportFragmentManager().findFragmentById(C0089R.idTabsActivity.fragment));
        return true;
    }

    public static Bitmap scaleBitmap(Context context, Bitmap sourceBitmap, int width, int height) {
        int targetWidth = width;
        int targetHeight = height;
        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addRect(new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) targetWidth, (float) targetHeight), Path.Direction.CW);
        canvas.clipPath(path);
        canvas.drawBitmap(sourceBitmap, new Rect(0, 0, sourceBitmap.getWidth(), sourceBitmap.getHeight()), new Rect(0, 0, targetWidth, targetHeight), (Paint) null);
        return targetBitmap;
    }

    public static Bitmap cropBitmap(Context context, Bitmap sourceBitmap, int width, int height) {
        Bitmap tempBitmap = sourceBitmap;
        int IMAGE_SIZE_WIDTH = width;
        int IMAGE_SIZE_HEIGHT = height;
        boolean landscape = sourceBitmap.getWidth() > sourceBitmap.getHeight();
        float scale_factor = 1.0f;
        if (landscape) {
            if (sourceBitmap != null) {
                scale_factor = ((float) IMAGE_SIZE_HEIGHT) / ((float) sourceBitmap.getHeight());
            }
        } else if (sourceBitmap != null) {
            scale_factor = ((float) IMAGE_SIZE_WIDTH) / ((float) sourceBitmap.getWidth());
        }
        Matrix matrix = new Matrix();
        matrix.postScale(scale_factor, scale_factor);
        if (landscape) {
            return Bitmap.createBitmap(tempBitmap, (tempBitmap.getWidth() - tempBitmap.getHeight()) / 2, 0, tempBitmap.getHeight(), tempBitmap.getHeight(), matrix, true);
        }
        return Bitmap.createBitmap(tempBitmap, 0, (tempBitmap.getHeight() - tempBitmap.getWidth()) / 2, tempBitmap.getWidth(), tempBitmap.getWidth(), matrix, true);
    }

    public static void hideKeyBoard(EditText editText) {
        ((InputMethodManager) editText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 1);
    }

    public static Bitmap loadImage(String URL, BitmapFactory.Options options) {
        Bitmap bitmap = null;
        try {
            InputStream in = openHttpConnection(URL);
            bitmap = BitmapFactory.decodeStream(in, (Rect) null, options);
            in.close();
            return bitmap;
        } catch (IOException e) {
            return bitmap;
        }
    }

    private static InputStream openHttpConnection(String strURL) throws IOException {
        try {
            HttpURLConnection httpConn = (HttpURLConnection) new URL(strURL).openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            if (httpConn.getResponseCode() == 200) {
                return httpConn.getInputStream();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isPaused() {
        return isPaused;
    }

    public static void setPaused(boolean isPaused2) {
        isPaused = isPaused2;
    }

    public static String formatStringFromHtml(String original) {
        return Html.fromHtml(original).toString();
    }

    public static ArrayList<Post> mergePosts(ArrayList<Post> postList1, ArrayList<Post> postList2) {
        ArrayList<Post> mergedPostist = new ArrayList<>();
        Iterator<Post> it = postList1.iterator();
        while (it.hasNext()) {
            mergedPostist.add(it.next());
        }
        Iterator<Post> it2 = postList2.iterator();
        while (it2.hasNext()) {
            mergedPostist.add(it2.next());
        }
        return mergedPostist;
    }

    public static void initImageLoader(Context context) {
        int memoryCacheSize;
        if (Build.VERSION.SDK_INT >= 5) {
            memoryCacheSize = (((ActivityManager) context.getSystemService("activity")).getMemoryClass() / 8) * 1024 * 1024;
        } else {
            memoryCacheSize = 2097152;
        }
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(context).threadPriority(3).memoryCacheSize(memoryCacheSize).denyCacheImageMultipleSizesInMemory().discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).enableLogging().build());
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(src).openConnection();
            connection.setDoInput(true);
            connection.connect();
            return BitmapFactory.decodeStream(connection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void showErrorDialog(final Activity actiivty, String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(actiivty);
        builder.setMessage(error).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                actiivty.onBackPressed();
                GuiUtil.isShowingDialog = false;
            }
        });
        AlertDialog alert = builder.create();
        alert.setCancelable(false);
        synchronized (actiivty) {
            if (!isShowingDialog) {
                isShowingDialog = true;
                alert.show();
            }
        }
    }

    public static String sha1Hash(String toHash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] result = MessageDigest.getInstance("SHA-1").digest(toHash.getBytes("UTF-8")); // CRYPTOGRAPHIC API CALLSITE 9, CRYPTOGRAPHIC API CALLSITE 11
        StringBuilder sb = new StringBuilder();
        int length = result.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X", new Object[]{Byte.valueOf(result[i])}));
        }
        return sb.toString().toLowerCase();
    }

    public static String getDateTime() {
        String month;
        String day;
        String hour;
        String minute;
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT"));
        String year = String.valueOf(c.get(1));
        if (c.get(2) + 1 < 10) {
            month = "0" + (c.get(2) + 1);
        } else {
            month = String.valueOf(c.get(2) + 1);
        }
        if (c.get(5) < 10) {
            day = "0" + c.get(5);
        } else {
            day = String.valueOf(c.get(5));
        }
        if (c.get(11) < 10) {
            hour = "0" + c.get(11);
        } else {
            hour = String.valueOf(c.get(11));
        }
        if (c.get(12) < 10) {
            minute = "0" + c.get(12);
        } else {
            minute = String.valueOf(c.get(12));
        }
        return String.valueOf(year) + month + day + hour + minute;
    }

    public static Dialog showErrorDialog(final FragmentActivity activity, String message, final boolean callOnBackPressed) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C0089R.layout.error_dialog);
        dialog.getWindow().setBackgroundDrawableResource(C0089R.drawable.rounded_shape);
        ((TextView) dialog.findViewById(C0089R.idErrorDialog.text)).setText(message);
        ((Button) dialog.findViewById(C0089R.idErrorDialog.btnOk)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
                if (callOnBackPressed) {
                    LocalFragmentManager.getInstance(activity).removeFromStack(activity.getSupportFragmentManager().findFragmentById(C0089R.idTabsActivity.fragment));
                    activity.onBackPressed();
                }
            }
        });
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog showErrorDialog(final FragmentActivity activity, String message, String title, final boolean callOnBackPressed) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C0089R.layout.error_dialog);
        dialog.getWindow().setBackgroundDrawableResource(C0089R.drawable.rounded_shape);
        ((TextView) dialog.findViewById(C0089R.idErrorDialog.text)).setText(message);
        ((TextView) dialog.findViewById(C0089R.idErrorDialog.title)).setText(title);
        ((Button) dialog.findViewById(C0089R.idErrorDialog.btnOk)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
                if (callOnBackPressed) {
                    LocalFragmentManager.getInstance(activity).removeFromStack(activity.getSupportFragmentManager().findFragmentById(C0089R.idTabsActivity.fragment));
                    activity.onBackPressed();
                }
            }
        });
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog showErrorDialog(FragmentActivity activity, String message, boolean callOnBackPressed, View.OnClickListener listener) {
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setContentView(C0089R.layout.error_dialog);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawableResource(C0089R.drawable.rounded_shape);
        ((TextView) dialog.findViewById(C0089R.idErrorDialog.text)).setText(message);
        ((Button) dialog.findViewById(C0089R.idErrorDialog.btnOk)).setOnClickListener(listener);
        dialog.setCancelable(false);
        return dialog;
    }

    public static void attachFragmentWithoutSaving(FragmentActivity activity, int id, Fragment fragment) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment findFragmentById = activity.getSupportFragmentManager().findFragmentById(C0089R.idTabsActivity.fragment);
        fragmentTransaction.setCustomAnimations(C0089R.anim.fragment_right_in_animation, C0089R.anim.fragment_left_out_animation);
        if (fragmentManager.findFragmentById(id) == null) {
            fragmentTransaction.add(id, fragment);
            fragmentTransaction.addToBackStack((String) null);
            fragmentTransaction.commit();
            return;
        }
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.addToBackStack((String) null);
        if (!isPaused) {
            fragmentTransaction.commit();
        } else {
            pendingTransaction = fragmentTransaction;
        }
    }

    public static void disableImageButton(Context ctx, ImageView imgButton, int resId) {
        Drawable d = ctx.getResources().getDrawable(resId);
        d.setAlpha(60);
        imgButton.setImageDrawable(d);
    }

    public static void enableImageButton(Context ctx, ImageView imgButton, int resId) {
        Drawable d = ctx.getResources().getDrawable(resId);
        d.setAlpha(MotionEventCompat.ACTION_MASK);
        imgButton.setImageDrawable(d);
    }

    public static void postWallFacebook(Context context, String link) {
        Intent sharingIntent = new Intent("android.intent.action.SEND");
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra("android.intent.extra.TEXT", link);
        sharingIntent.setFlags(270532608);
        sharingIntent.setPackage(Constants.FACEBOOK_PACKAGE);
        try {
            context.startActivity(sharingIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, C0089R.string.nofoundapplication, 1).show();
        }
    }

    public static void sendGmail(Context context, String subject, String text) {
        Intent gmailIntent = new Intent();
        gmailIntent.setClassName(Constants.GMAIL_PACKAGE, Constants.GMAIL_ACTIVITY);
        gmailIntent.putExtra("android.intent.extra.SUBJECT", subject);
        gmailIntent.putExtra("android.intent.extra.TEXT", text);
        gmailIntent.setFlags(270532608);
        try {
            context.startActivity(gmailIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, C0089R.string.nofoundapplication, 1).show();
        }
    }

    public static void shareTwitter(Context context, String text) {
        Intent twitterIntent = new Intent("android.intent.action.SEND");
        twitterIntent.setPackage(Constants.TWITTER_PACKAGE);
        twitterIntent.setType("text/plain");
        twitterIntent.setFlags(270532608);
        twitterIntent.putExtra("android.intent.extra.TEXT", text);
        try {
            context.startActivity(twitterIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, C0089R.string.nofoundapplication, 1).show();
        }
    }

    public static void shareWhatsApp(Context context, String text) {
        Intent wAppIntent = new Intent("android.intent.action.SEND");
        wAppIntent.setPackage(Constants.WHATSAPP_PACKAGE);
        wAppIntent.setType("text/plain");
        wAppIntent.setFlags(270532608);
        wAppIntent.putExtra("android.intent.extra.TEXT", text);
        try {
            context.startActivity(Intent.createChooser(wAppIntent, "Share with"));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, C0089R.string.nofoundapplication, 1).show();
        }
    }

    public static Dialog showShareDialog(Context activity, String post, String NewsTitle, boolean shareApp) {
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawableResource(C0089R.drawable.rounded_border_shape);
        dialog.setContentView(C0089R.layout.share_dialog);
        Button gmail = (Button) dialog.findViewById(C0089R.idShareDialog.gmail);
        Button twitter = (Button) dialog.findViewById(C0089R.idShareDialog.twitter);
        Button facebook = (Button) dialog.findViewById(C0089R.idShareDialog.facebook);
        Button whatsapp = (Button) dialog.findViewById(C0089R.idShareDialog.whatsApp);
        Drawable dt = null;
        Drawable dw = null;
        final String shareStr = String.valueOf(NewsTitle) + "\n\n" + post + "\n\n" + Constants.FOREX_VIA;
        final String shareStrTw = String.valueOf(NewsTitle) + " " + post + " " + Constants.FOREX_VIA_TWITTER;
        int appNum = 4;
        try {
            facebook.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, activity.getPackageManager().getApplicationIcon(Constants.FACEBOOK_PACKAGE), (Drawable) null, (Drawable) null);
        } catch (PackageManager.NameNotFoundException e) {
            facebook.setVisibility(8);
            appNum = 4 - 1;
        }
        try {
            gmail.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, activity.getPackageManager().getApplicationIcon(Constants.GMAIL_PACKAGE), (Drawable) null, (Drawable) null);
        } catch (PackageManager.NameNotFoundException e2) {
            gmail.setVisibility(8);
            appNum--;
        }
        try {
            dt = activity.getPackageManager().getApplicationIcon(Constants.TWITTER_PACKAGE);
            twitter.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, dt, (Drawable) null, (Drawable) null);
        } catch (PackageManager.NameNotFoundException e3) {
            twitter.setVisibility(8);
            appNum--;
        }
        try {
            dw = activity.getPackageManager().getApplicationIcon(Constants.WHATSAPP_PACKAGE);
            whatsapp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, dw, (Drawable) null, (Drawable) null);
        } catch (PackageManager.NameNotFoundException e4) {
            whatsapp.setVisibility(8);
            appNum--;
        }
        if (appNum >= 4) {
            twitter.setVisibility(8);
            whatsapp.setVisibility(8);
            ((LinearLayout) dialog.findViewById(C0089R.idShareDialog.btnSecondContainer)).setVisibility(0);
            twitter = (Button) dialog.findViewById(C0089R.idShareDialog.secondTwitter);
            whatsapp = (Button) dialog.findViewById(C0089R.idShareDialog.secondWhatsApp);
            twitter.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, dt, (Drawable) null, (Drawable) null);
            whatsapp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, dw, (Drawable) null, (Drawable) null);
        }
        if (!shareApp) {
            final Context context = activity;
            twitter.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GuiUtil.shareTwitter(context, shareStrTw);
                }
            });
            final Context context2 = activity;
            facebook.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GuiUtil.postWallFacebook(context2, shareStr);
                }
            });
            final Context context3 = activity;
            final String str = NewsTitle;
            final String str2 = post;
            gmail.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GuiUtil.sendGmail(context3, str, String.valueOf(str2) + "\n\n" + Constants.FOREX_VIA);
                }
            });
            final Context context4 = activity;
            whatsapp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GuiUtil.shareWhatsApp(context4, shareStr);
                }
            });
        } else {
            final Context context5 = activity;
            twitter.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GuiUtil.shareTwitter(context5, "Get @forexcrunch App. Forex thoughts, analysis, daily and weekly outlooks, live calendar & everything forex. http://tinyurl.com/pgnyvyn");
                }
            });
            final Context context6 = activity;
            final String str3 = post;
            facebook.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GuiUtil.postWallFacebook(context6, "Get Forex Crunch App. Forex thoughts, analysis, daily and weekly outlooks, live calendar & everything forex " + str3 + context6.getPackageName());
                }
            });
            final Context context7 = activity;
            final String str4 = NewsTitle;
            final String str5 = post;
            gmail.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GuiUtil.sendGmail(context7, str4, Constants.FOREX_TEXT_RATE + str5 + context7.getPackageName());
                }
            });
            final Context context8 = activity;
            final String str6 = post;
            whatsapp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GuiUtil.shareWhatsApp(context8, "Get Forex Crunch App. Forex thoughts, analysis, daily and weekly outlooks, live calendar & everything forex " + str6 + context8.getPackageName());
                }
            });
        }
        return dialog;
    }

    public static void seeFacebookProfile(Context context, String facebookId, boolean throwBrowser) {
        Intent facebookIntent = new Intent("android.intent.action.VIEW", Uri.parse(Constants.FACEBOOK_SCHEME_APP_ACCES_ID + facebookId));
        facebookIntent.setFlags(270532608);
        try {
            context.startActivity(facebookIntent);
        } catch (ActivityNotFoundException e) {
            if (throwBrowser) {
                facebookIntent = new Intent("android.intent.action.VIEW", Uri.parse(Constants.FACEBOOK_SCHEME_WEB_ACCES_ID + facebookId));
                facebookIntent.setFlags(270532608);
            } else {
                Toast.makeText(context, C0089R.string.nofoundapplication, 1).show();
            }
            context.startActivity(facebookIntent);
        }
    }

    public static void seeTwiterProfile(Context context, String twitterUserName, boolean throwBrowser) {
        Intent intent = null;
        try {
            context.getPackageManager().getPackageInfo(Constants.TWITTER_PACKAGE, 0);
            intent = new Intent("android.intent.action.VIEW", Uri.parse(Constants.TWITTER_SCHEME_APP_ACCES_ID + twitterUserName));
        } catch (PackageManager.NameNotFoundException e) {
            if (throwBrowser) {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(Constants.TWITTER_SCHEME_WEB_ACCES_ID + twitterUserName));
            } else {
                Toast.makeText(context, C0089R.string.nofoundapplication, 1).show();
            }
        }
        if (intent != null) {
            intent.setFlags(270532608);
            context.startActivity(intent);
        }
    }

    public static void rateApp(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Constants.FOREX_APP_URL + context.getPackageName())));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, C0089R.string.nofoundapplication, 1).show();
        }
    }

    public static void showSearchResultsActivity(Activity activity, String searchFor) {
        Intent intent = new Intent(activity, SearchResultsActivity.class);
        intent.putExtra("searchQuery", searchFor);
        activity.startActivity(intent);
    }
}
