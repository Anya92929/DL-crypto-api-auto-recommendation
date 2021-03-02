package com.tapcrowd.app.modules;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCActivity;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.io.File;

public class Gallery extends TCActivity {
    private final int MAIL = 454;
    /* access modifiers changed from: private */
    public int clicked;
    private ViewPager gal;
    /* access modifiers changed from: private */
    public String[] messages;
    /* access modifiers changed from: private */
    public String[] myRemoteImages;

    public void onCreate(Bundle savedInstanceState) {
        setContentView((int) C0846R.layout.gallery);
        super.onCreate(savedInstanceState);
        findViewById(C0846R.C0847id.title).setVisibility(8);
        getSupportActionBar().hide();
        this.messages = new String[0];
        this.gal = (ViewPager) findViewById(C0846R.C0847id.f1988ga);
        TextView warning = (TextView) findViewById(C0846R.C0847id.warning);
        warning.setVisibility(8);
        C1232UI.setTitle("img");
        if (getIntent().hasExtra("ids")) {
            C1232UI.show(C0846R.C0847id.notes);
        }
        try {
            this.myRemoteImages = getIntent().getStringExtra("urls").split(",");
        } catch (Exception e) {
        }
        int index = getIntent().getIntExtra("index", 0);
        if (getIntent().hasExtra("hide")) {
            C1232UI.hide(C0846R.C0847id.title);
        }
        if (getIntent().hasExtra("messages")) {
            this.messages = getIntent().getStringExtra("messages").split(";;");
        }
        if (this.myRemoteImages != null) {
            if (this.myRemoteImages.length > 0) {
                warning.setVisibility(8);
                this.gal.setAdapter(new GalleryAdapter());
                if (this.myRemoteImages.length <= index) {
                    index = this.myRemoteImages.length - 1;
                }
                this.gal.setCurrentItem(index);
            } else {
                this.gal.setVisibility(8);
            }
        }
        WindowManager winMan = (WindowManager) getSystemService("window");
        if (winMan != null && winMan.getDefaultDisplay().getOrientation() == 1) {
            C1232UI.hide(C0846R.C0847id.title);
            getWindow().addFlags(1024);
        }
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, getString(C0846R.string.save_share));
        if (Build.VERSION.SDK_INT > 10) {
            menu.add(0, 1, 0, getString(C0846R.string.copy));
        }
        menu.add(0, 2, 0, getString(C0846R.string.e_mail));
        Intent twitIntent = new Intent("android.intent.action.SEND");
        twitIntent.setPackage("com.twitter.android");
        twitIntent.setType("text/plain");
        if (Actions.isIntentAvailable(this, twitIntent)) {
            menu.add(0, 3, 0, "Share on twitter");
        }
        Intent facebookIntent = new Intent("android.intent.action.SEND");
        facebookIntent.setPackage("com.facebook.katana");
        facebookIntent.setType("text/plain");
        if (Actions.isIntentAvailable(this, facebookIntent)) {
            menu.add(0, 4, 0, "Share on facebook");
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                save();
                break;
            case 1:
                copy();
                break;
            case 2:
                mail();
                break;
            case 3:
                twitter();
                break;
            case 4:
                facebook();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void save() {
        new FastImageLoader().getBitmap(this.myRemoteImages[this.clicked], new FastImageLoader.LoadBitmapListener() {
            public void bitmapLoaded(Bitmap bitmap) {
                MediaStore.Images.Media.insertImage(Gallery.this.getContentResolver(), bitmap, (String) null, (String) null);
            }
        });
    }

    public void copy() {
        final FastImageLoader fil = new FastImageLoader();
        fil.getBitmap(this.myRemoteImages[this.clicked], new FastImageLoader.LoadBitmapListener() {
            public void bitmapLoaded(Bitmap bitmap) {
                ((ClipboardManager) Gallery.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newUri(Gallery.this.getContentResolver(), "Image", Uri.fromFile(new File(fil.getPath(Gallery.this.myRemoteImages[Gallery.this.clicked])))));
            }
        });
    }

    public void mail() {
        final FastImageLoader fil = new FastImageLoader();
        fil.getBitmap(this.myRemoteImages[this.clicked], new FastImageLoader.LoadBitmapListener() {
            public void bitmapLoaded(Bitmap bitmap) {
                File file = new File(fil.getPath(Gallery.this.myRemoteImages[Gallery.this.clicked]));
                File to = new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator)), String.valueOf(Gallery.this.myRemoteImages[Gallery.this.clicked].substring(Gallery.this.myRemoteImages[Gallery.this.clicked].lastIndexOf(47) + 1)) + ".jpg");
                file.renameTo(to);
                Uri u = Uri.fromFile(to);
                Intent sendIntent = new Intent("android.intent.action.SEND");
                sendIntent.putExtra("android.intent.extra.EMAIL", new String[0]);
                sendIntent.setType("message/rfc822");
                sendIntent.putExtra("android.intent.extra.STREAM", u);
                Gallery.this.startActivityForResult(Intent.createChooser(sendIntent, "Mail:"), 454);
            }
        });
    }

    public void twitter() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setPackage("com.twitter.android");
        String path = new FastImageLoader().getPath(this.myRemoteImages[this.clicked]);
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", getString(C0846R.string.app_name));
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(path)));
        startActivity(intent);
    }

    public void facebook() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setPackage("com.facebook.katana");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", getString(C0846R.string.app_name));
        intent.putExtra("android.intent.extra.TEXT", this.myRemoteImages[this.clicked]);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 454) {
            File file = new File(new FastImageLoader().getPath(this.myRemoteImages[this.clicked]));
            new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator)), String.valueOf(this.myRemoteImages[this.clicked].substring(this.myRemoteImages[this.clicked].lastIndexOf(47) + 1)) + ".jpg").renameTo(file);
        }
    }

    public class GalleryAdapter extends PagerAdapter {
        FastImageLoader fil = new FastImageLoader();

        /* renamed from: li */
        LayoutInflater f2008li;

        public GalleryAdapter() {
            this.f2008li = Gallery.this.getLayoutInflater();
        }

        public Object instantiateItem(ViewGroup container, final int position) {
            final View view = this.f2008li.inflate(C0846R.layout.gallery_cell, (ViewGroup) null);
            view.findViewById(C0846R.C0847id.icon).post(new Runnable() {
                public void run() {
                    ImageView iv = (ImageView) view.findViewById(C0846R.C0847id.icon);
                    if (App.tablet) {
                        if (Gallery.this.getIntent().getBooleanExtra("local", false)) {
                            Bitmap bm = GalleryAdapter.this.decodeSampledBitmapFromFile(Gallery.this.myRemoteImages[position], Gallery.this.getWindowManager().getDefaultDisplay().getWidth() / 2);
                            Bitmap bitmap = bm;
                            try {
                                int orientation = new ExifInterface(Gallery.this.myRemoteImages[position]).getAttributeInt("Orientation", 1);
                                Matrix m = new Matrix();
                                if (orientation == 3) {
                                    m.postRotate(180.0f);
                                    bitmap = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), m, true);
                                } else if (orientation == 6) {
                                    m.postRotate(90.0f);
                                    bitmap = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), m, true);
                                } else if (orientation == 8) {
                                    m.postRotate(270.0f);
                                    bitmap = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), m, true);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            ((ImageView) view.findViewById(C0846R.C0847id.icon)).setImageBitmap(bitmap);
                            return;
                        }
                        FastImageLoader fastImageLoader = GalleryAdapter.this.fil;
                        String str = Gallery.this.myRemoteImages[position];
                        final View view = view;
                        fastImageLoader.getBitmap(str, new FastImageLoader.LoadBitmapListener() {
                            public void bitmapLoaded(Bitmap bitmap) {
                                View spinner = view.findViewById(C0846R.C0847id.spinner);
                                ((ImageView) view.findViewById(C0846R.C0847id.icon)).setImageBitmap(bitmap);
                                spinner.setVisibility(8);
                            }
                        }, Gallery.this.getWindowManager().getDefaultDisplay().getHeight() / 2, Gallery.this.getWindowManager().getDefaultDisplay().getWidth() / 2);
                    } else if (Gallery.this.getIntent().getBooleanExtra("local", false)) {
                        Bitmap bm2 = GalleryAdapter.this.decodeSampledBitmapFromFile(Gallery.this.myRemoteImages[position], Gallery.this.getWindowManager().getDefaultDisplay().getWidth());
                        Bitmap bitmap2 = bm2;
                        try {
                            int orientation2 = new ExifInterface(Gallery.this.myRemoteImages[position]).getAttributeInt("Orientation", 1);
                            Matrix m2 = new Matrix();
                            if (orientation2 == 3) {
                                m2.postRotate(180.0f);
                                bitmap2 = Bitmap.createBitmap(bm2, 0, 0, bm2.getWidth(), bm2.getHeight(), m2, true);
                            } else if (orientation2 == 6) {
                                m2.postRotate(90.0f);
                                bitmap2 = Bitmap.createBitmap(bm2, 0, 0, bm2.getWidth(), bm2.getHeight(), m2, true);
                            } else if (orientation2 == 8) {
                                m2.postRotate(270.0f);
                                bitmap2 = Bitmap.createBitmap(bm2, 0, 0, bm2.getWidth(), bm2.getHeight(), m2, true);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        ((ImageView) view.findViewById(C0846R.C0847id.icon)).setImageBitmap(bitmap2);
                    } else {
                        FastImageLoader fastImageLoader2 = GalleryAdapter.this.fil;
                        String str2 = Gallery.this.myRemoteImages[position];
                        final View view2 = view;
                        fastImageLoader2.getBitmap(str2, new FastImageLoader.LoadBitmapListener() {
                            public void bitmapLoaded(Bitmap bitmap) {
                                View spinner = view2.findViewById(C0846R.C0847id.spinner);
                                ((ImageView) view2.findViewById(C0846R.C0847id.icon)).setImageBitmap(bitmap);
                                spinner.setVisibility(8);
                            }
                        }, iv.getHeight(), iv.getWidth());
                    }
                }
            });
            TextView text = (TextView) view.findViewById(C0846R.C0847id.message);
            C1232UI.setFont(text);
            if (Gallery.this.messages.length > position) {
                text.setText(Gallery.this.messages[position]);
                view.findViewById(C0846R.C0847id.menu).setVisibility(0);
            }
            if (Gallery.this.getIntent().getBooleanExtra("share", false)) {
                view.findViewById(C0846R.C0847id.share).setVisibility(0);
                view.findViewById(C0846R.C0847id.share).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Gallery.this.registerForContextMenu(v);
                        Gallery.this.openContextMenu(v);
                        Gallery.this.unregisterForContextMenu(v);
                        Gallery.this.clicked = position;
                    }
                });
                view.findViewById(C0846R.C0847id.menu).setVisibility(0);
            }
            container.addView(view);
            return view;
        }

        public int getCount() {
            return Gallery.this.myRemoteImages.length;
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isViewFromObject(android.view.View r3, java.lang.Object r4) {
            /*
                r2 = this;
                r0 = r4
                android.view.View r0 = (android.view.View) r0
                if (r3 != r0) goto L_0x0007
                r1 = 1
            L_0x0006:
                return r1
            L_0x0007:
                r1 = 0
                goto L_0x0006
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapcrowd.app.modules.Gallery.GalleryAdapter.isViewFromObject(android.view.View, java.lang.Object):boolean");
        }

        public Bitmap decodeSampledBitmapFromFile(String path, int reqWidth) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);
            int i = options.outHeight;
            int width = options.outWidth;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            int inSampleSize = 1;
            if (width / 1 > reqWidth) {
                inSampleSize = Math.round(((float) width) / ((float) reqWidth));
            }
            options.inSampleSize = inSampleSize;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(path, options);
        }

        public void destroyItem(View collection, int position, Object object) {
            ((ViewPager) collection).removeView((View) object);
        }

        public void finishUpdate(View arg0) {
        }

        public Parcelable saveState() {
            return null;
        }

        public void startUpdate(View arg0) {
        }

        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }
    }
}
