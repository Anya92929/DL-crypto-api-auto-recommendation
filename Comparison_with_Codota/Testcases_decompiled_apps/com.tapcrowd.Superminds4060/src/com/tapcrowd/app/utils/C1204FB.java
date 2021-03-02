package com.tapcrowd.app.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.facebook.DialogError;
import com.tapcrowd.app.utils.facebook.Facebook;
import com.tapcrowd.app.utils.facebook.FacebookError;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.io.ByteArrayOutputStream;
import org.json.JSONObject;

/* renamed from: com.tapcrowd.app.utils.FB */
public class C1204FB {
    public static void share(Facebook facebook, String message, String picture, String link) {
        share(facebook, message, picture, link, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null);
    }

    public static void share(Facebook facebook, String message, String picture, String link, String name, String caption, String description, String source, String place, String tags) {
        Bundle params = new Bundle();
        if (message != null) {
            params.putString("message", message);
        }
        if (picture != null) {
            params.putString("picture", picture);
        }
        if (link != null) {
            params.putString("message", link);
        }
        if (name != null) {
            params.putString("message", name);
        }
        if (caption != null) {
            params.putString("message", caption);
        }
        if (description != null) {
            params.putString("message", description);
        }
        if (source != null) {
            params.putString("source", source);
        }
        if (place != null) {
            params.putString("message", place);
        }
        if (tags != null) {
            params.putString("message", tags);
        }
        params.putString("access_token", facebook.getAccessToken());
        try {
            facebook.request("feed", params, "POST");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getAlbum(Facebook facebook, String albumid) {
        try {
            return new JSONObject(facebook.request(albumid));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void shareDialog(Facebook facebook, String picture) {
        shareDialog(facebook, picture, (String) null, (Facebook.DialogListener) null);
    }

    public static void shareDialog(Facebook facebook, String picture, String to) {
        shareDialog(facebook, picture, to, (Facebook.DialogListener) null);
    }

    public static void shareDialog(Facebook facebook, String picture, Facebook.DialogListener listener) {
        shareDialog(facebook, picture, (String) null, listener);
    }

    public static void shareDialog(Facebook facebook, String picture, String to, Facebook.DialogListener listener) {
        Bundle parameters = new Bundle();
        if (picture != null) {
            parameters.putString("link", picture);
        }
        if (to != null) {
            parameters.putString("to", to);
        }
        if (listener == null) {
            listener = new Facebook.DialogListener() {
                public void onFacebookError(FacebookError e) {
                }

                public void onError(DialogError e) {
                }

                public void onComplete(Bundle values) {
                }

                public void onCancel() {
                }
            };
        }
        facebook.dialog(App.act, "feed", parameters, listener);
    }

    public static void copyPost(Facebook facebook, String postid, String pageid) {
        try {
            JSONObject post = new JSONObject(facebook.request(postid));
            Bundle parameters = new Bundle();
            parameters.putString("message", post.getString("message"));
            parameters.putString("link", post.getString("link"));
            parameters.putString("picture", post.getString("picture"));
            parameters.putString(DBFavorites.KEY_NAME, post.getString(DBFavorites.KEY_NAME));
            parameters.putString("caption", post.getString("caption"));
            parameters.putString(C1216LO.icon, post.getString(C1216LO.icon));
            facebook.request(String.valueOf(pageid) + "/feed", parameters, "POST");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createPost(final Facebook facebook, final String message, String link, final String page) {
        new FastImageLoader().getBitmap(link, new FastImageLoader.LoadBitmapListener() {
            public void bitmapLoaded(Bitmap bitmap) {
                final String str = message;
                final Facebook facebook = facebook;
                final String str2 = page;
                final Bitmap bitmap2 = bitmap;
                new Thread(new Runnable() {
                    public void run() {
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                        byte[] data = baos.toByteArray();
                        Bundle parameters = new Bundle();
                        parameters.putString("message", str);
                        parameters.putByteArray("photo", data);
                        try {
                            facebook.request(String.valueOf(str2) + "/photos", parameters, "POST");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    public static void makePost(Context context, Bitmap bmp, Facebook.DialogListener listener) {
        new FBPostDialog(context, bmp, listener).show();
    }

    /* renamed from: com.tapcrowd.app.utils.FB$FBPostDialog */
    private static class FBPostDialog extends Dialog {
        Bitmap bmp;
        View.OnClickListener cancel = new View.OnClickListener() {
            public void onClick(View v) {
                FBPostDialog.this.dismiss();
            }
        };
        View layout;
        Facebook.DialogListener listener;
        EditText message;
        View.OnClickListener send = new View.OnClickListener() {
            public void onClick(View v) {
                Bundle parameters = new Bundle();
                parameters.putString("message", FBPostDialog.this.message.getText().toString());
                FBPostDialog.this.listener.onComplete(parameters);
                FBPostDialog.this.dismiss();
            }
        };

        public FBPostDialog(Context context, Bitmap bmp2, Facebook.DialogListener listener2) {
            super(context, C0846R.style.transparentDialogTheme);
            this.bmp = bmp2;
            this.listener = listener2;
        }

        /* access modifiers changed from: protected */
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.layout = getLayoutInflater().inflate(C0846R.layout.fb_post_dialog, (ViewGroup) null);
            this.message = (EditText) this.layout.findViewById(C0846R.C0847id.message);
            ((TextView) this.layout.findViewById(C0846R.C0847id.cancel)).setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
            ((TextView) this.layout.findViewById(C0846R.C0847id.send)).setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
            this.layout.findViewById(C0846R.C0847id.cancel).setOnClickListener(this.cancel);
            this.layout.findViewById(C0846R.C0847id.send).setOnClickListener(this.send);
            ((ImageView) this.layout.findViewById(C0846R.C0847id.icon)).setImageBitmap(this.bmp);
            setBackgrounds();
            addContentView(this.layout, new ViewGroup.LayoutParams(-1, -2));
        }

        public void setBackgrounds() {
            View top = this.layout.findViewById(C0846R.C0847id.top);
            GradientDrawable topbg = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{C1216LO.getLo(C1216LO.seperatorBackgroundColor), C1216LO.getLo(C1216LO.seperatorBackgroundColor)});
            topbg.setCornerRadii(new float[]{15.0f, 15.0f, 15.0f, 15.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED});
            top.setBackgroundDrawable(topbg);
            View bottom = this.layout.findViewById(C0846R.C0847id.bottom);
            GradientDrawable bottombg = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{Color.parseColor("#ffffff"), Color.parseColor("#ffffff")});
            bottombg.setCornerRadii(new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 15.0f, 15.0f, 15.0f, 15.0f});
            bottom.setBackgroundDrawable(bottombg);
        }
    }
}
