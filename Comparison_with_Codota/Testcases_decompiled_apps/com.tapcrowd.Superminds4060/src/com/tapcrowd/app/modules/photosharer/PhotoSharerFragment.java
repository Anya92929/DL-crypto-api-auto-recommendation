package com.tapcrowd.app.modules.photosharer;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.FBFragment;
import com.tapcrowd.app.modules.Gallery;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1204FB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.ProgressMultipartEntity;
import com.tapcrowd.app.utils.User;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class PhotoSharerFragment extends FBFragment implements MenuFragment.MenuItemListener {
    private final int CAMERA = 12;
    private final int LIBRARY_OPENED = 2;
    private final int PICTURE_TAKEN = 1;
    String filename;
    String imageurl;
    MenuFragment menu;
    String message = "";
    String response;
    boolean shareable = true;
    /* access modifiers changed from: private */
    public String type;
    /* access modifiers changed from: private */
    public String typeid;

    public static PhotoSharerFragment newInstance(String type2, String typeid2) {
        PhotoSharerFragment fr = new PhotoSharerFragment();
        fr.type = type2;
        fr.typeid = typeid2;
        return fr;
    }

    public void onResume() {
        super.onResume();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.fb_picture, container, false);
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_camera, C1216LO.getLo(C1216LO.navigationColor)), 12));
        this.menu = MenuFragment.newInstance(menuitems, this);
        Fragments.addMenu(this, this.menu);
        return v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AdHelper.showAds(this, AdHelper.buildPath("39", "list", (String) null));
        new ParseWallPhotosTask(this, (ParseWallPhotosTask) null).execute(new Void[0]);
    }

    private class ParseWallPhotosTask extends AsyncTask<Void, FBImage, List<FBImage>> {
        List<FBImage> imageList;

        private ParseWallPhotosTask() {
            this.imageList = new ArrayList();
        }

        /* synthetic */ ParseWallPhotosTask(PhotoSharerFragment photoSharerFragment, ParseWallPhotosTask parseWallPhotosTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            PhotoSharerFragment.this.menu.startLoader();
        }

        /* access modifiers changed from: protected */
        public List<FBImage> doInBackground(Void... params) {
            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet get = new HttpGet(String.format("http://stream.tap.cr/thumb/app_%1$s/%2$s_%3$s/postpicture", new Object[]{App.f2123id, PhotoSharerFragment.this.type, PhotoSharerFragment.this.typeid}));
                get.setHeader("Accept", "application/json");
                BufferedReader r = new BufferedReader(new InputStreamReader(client.execute(get).getEntity().getContent()));
                String json = "";
                while (true) {
                    String line = r.readLine();
                    if (line == null) {
                        break;
                    }
                    json = String.valueOf(json) + line;
                }
                JSONArray data = new JSONArray(json);
                int len = data.length();
                for (int i = 0; i < len; i++) {
                    FBImage fbi = new FBImage();
                    JSONObject o = data.getJSONObject(i);
                    fbi.img = o.getString("imageurl");
                    fbi.message = o.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
                    this.imageList.add(fbi);
                }
                return this.imageList;
            } catch (Exception e) {
                e.printStackTrace();
                return new ArrayList();
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(List<FBImage> result) {
            super.onPostExecute(result);
            PhotoSharerFragment.this.menu.stopLoader();
            if (PhotoSharerFragment.this.isAdded()) {
                GridView gridview = (GridView) PhotoSharerFragment.this.getView().findViewById(C0846R.C0847id.gridview);
                if (App.tablet) {
                    gridview.setNumColumns(5);
                }
                gridview.setAdapter(new ThumbsAdapter(result));
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
                    }
                });
            }
        }
    }

    private class ThumbsAdapter extends BaseAdapter {
        FastImageLoader fil = new FastImageLoader();
        List<FBImage> list;
        int width;

        public ThumbsAdapter(List<FBImage> list2) {
            DisplayMetrics metrics = new DisplayMetrics();
            PhotoSharerFragment.this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
            if (!App.tablet) {
                this.width = metrics.widthPixels / 3;
            } else if (PhotoSharerFragment.this.getResources().getConfiguration().orientation == 2) {
                this.width = (metrics.widthPixels - ((int) Converter.convertDpToPixel(250.0f, PhotoSharerFragment.this.getActivity()))) / 5;
            } else {
                this.width = (metrics.widthPixels - ((int) Converter.convertDpToPixel(80.0f, PhotoSharerFragment.this.getActivity()))) / 5;
            }
            this.list = list2;
        }

        public int getCount() {
            return this.list.size();
        }

        public Object getItem(int arg0) {
            return this.list.get(arg0);
        }

        public boolean isEnabled(int position) {
            return true;
        }

        public long getItemId(int arg0) {
            return 0;
        }

        public View getView(final int position, View convertView, ViewGroup parent) {
            RelativeLayout rl;
            final ImageView view;
            final ProgressBar progress;
            if (convertView == null) {
                rl = new RelativeLayout(PhotoSharerFragment.this.getActivity());
                rl.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
                rl.setPadding(3, 3, 3, 3);
                view = new ImageView(PhotoSharerFragment.this.getActivity());
                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                view.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.width - 6));
                progress = new ProgressBar(PhotoSharerFragment.this.getActivity());
                RelativeLayout.LayoutParams rlpprog = new RelativeLayout.LayoutParams(this.width / 2, this.width / 2);
                rlpprog.addRule(13);
                progress.setLayoutParams(rlpprog);
                rl.addView(progress);
                rl.addView(view);
            } else {
                rl = (RelativeLayout) convertView;
                view = (ImageView) rl.getChildAt(1);
                progress = (ProgressBar) rl.getChildAt(0);
                progress.setVisibility(0);
            }
            rl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(PhotoSharerFragment.this.getActivity(), Gallery.class);
                    Bundle b = new Bundle();
                    String urls = "";
                    String messages = "";
                    for (FBImage fb : ThumbsAdapter.this.list) {
                        urls = String.valueOf(urls) + fb.img + ",";
                        messages = String.valueOf(messages) + fb.message + ";;";
                    }
                    b.putString("urls", urls.replace("/thumb/", "/original/"));
                    b.putString("messages", messages);
                    b.putInt("index", position);
                    b.putBoolean("share", true);
                    intent.putExtras(b);
                    PhotoSharerFragment.this.startActivity(intent);
                }
            });
            this.fil.getBitmap(this.list.get(position).img, new FastImageLoader.LoadBitmapListener() {
                public void bitmapLoaded(Bitmap bitmap) {
                    view.setImageBitmap(bitmap);
                    progress.setVisibility(8);
                }
            });
            return rl;
        }
    }

    public class FBImage {
        public String img;
        public String message;
        public String thumb;

        public FBImage() {
        }

        public FBImage(String img2, String thumb2) {
            this.img = img2;
            this.thumb = thumb2;
        }
    }

    public void onAuthorize() {
        new Thread(new Runnable() {
            public void run() {
                C1204FB.createPost(PhotoSharerFragment.this.facebook, PhotoSharerFragment.this.message, PhotoSharerFragment.this.response, "me");
            }
        }).start();
    }

    public void click(MenuItem item) {
        if (item.getItemId() == 12) {
            this.filename = Environment.getExternalStorageDirectory() + "/TapCrowd/" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()).toString() + ".png";
            if (getActivity().getPackageManager().hasSystemFeature("android.hardware.camera")) {
                registerForContextMenu(getView());
                getActivity().openContextMenu(getView());
                unregisterForContextMenu(getView());
                return;
            }
            openLibrary();
        }
    }

    public void onCreateContextMenu(ContextMenu menu2, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu2.addSubMenu(0, 1, 0, getResourceString(C0846R.string.takepic));
        menu2.addSubMenu(0, 2, 0, getResourceString(C0846R.string.opengallery));
        super.onCreateContextMenu(menu2, v, menuInfo);
    }

    public void openLibrary() {
        startActivityForResult(Intent.createChooser(new Intent("android.intent.action.PICK", MediaStore.Images.Media.INTERNAL_CONTENT_URI), "Select Picture"), 2);
    }

    public boolean onContextItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                takepicture();
                break;
            case 2:
                openLibrary();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void takepicture() {
        if (getActivity().getPackageManager().hasSystemFeature("android.hardware.camera")) {
            if (App.camera != null) {
                App.camera.stopPreview();
                Camera.Parameters param = App.camera.getParameters();
                param.setFlashMode("off");
                App.camera.setParameters(param);
                App.camera.release();
                App.camera = null;
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("android.intent.extra.videoQuality", 1);
            this.filename = Environment.getExternalStorageDirectory() + "/TapCrowd/" + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()).toString() + ".png";
            setFile(this.filename);
            intent.putExtra("output", Uri.fromFile(new File(getFile())));
            startActivityForResult(intent, 1);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap input = null;
        if (resultCode == -1) {
            switch (requestCode) {
                case 1:
                    try {
                        input = getBitmap(getFile());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (input == null && data != null && data.hasExtra("data")) {
                        input = (Bitmap) data.getExtras().get("data");
                        break;
                    }
                case 2:
                    String[] filePathColumn = {"_data"};
                    Cursor cursor = getActivity().getContentResolver().query(data.getData(), filePathColumn, (String) null, (String[]) null, (String) null);
                    cursor.moveToFirst();
                    setFile(cursor.getString(cursor.getColumnIndex(filePathColumn[0])));
                    cursor.close();
                    input = getBitmap(getFile());
                    break;
                default:
                    super.onActivityResult(requestCode, resultCode, data);
                    break;
            }
        }
        addWatermark(input);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00ae, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00af, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addWatermark(android.graphics.Bitmap r17) {
        /*
            r16 = this;
            if (r17 == 0) goto L_0x00a7
            android.graphics.Bitmap r17 = r16.rotateBitmap(r17)     // Catch:{ Exception -> 0x00b3 }
            r16.saveBitmap(r17)     // Catch:{ Exception -> 0x00b3 }
            int r13 = r17.getHeight()     // Catch:{ Exception -> 0x00b3 }
            int r14 = r17.getWidth()     // Catch:{ Exception -> 0x00b3 }
            if (r13 <= r14) goto L_0x00a8
            int r11 = r17.getWidth()     // Catch:{ Exception -> 0x00b3 }
        L_0x0017:
            int r13 = r17.getWidth()     // Catch:{ Exception -> 0x00b3 }
            int r13 = r13 - r11
            int r13 = r13 / 2
            int r14 = r17.getHeight()     // Catch:{ Exception -> 0x00b3 }
            int r14 = r14 - r11
            int r14 = r14 / 2
            r0 = r17
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r0, r13, r14, r11, r11)     // Catch:{ Exception -> 0x00b3 }
            r17.recycle()     // Catch:{ Exception -> 0x00b3 }
            int r13 = r2.getWidth()     // Catch:{ Exception -> 0x00b3 }
            int r14 = r2.getHeight()     // Catch:{ Exception -> 0x00b3 }
            android.graphics.Bitmap$Config r15 = r2.getConfig()     // Catch:{ Exception -> 0x00b3 }
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r13, r14, r15)     // Catch:{ Exception -> 0x00b3 }
            android.graphics.Canvas r1 = new android.graphics.Canvas     // Catch:{ Exception -> 0x00b3 }
            r1.<init>(r9)     // Catch:{ Exception -> 0x00b3 }
            android.graphics.Matrix r13 = new android.graphics.Matrix     // Catch:{ Exception -> 0x00b3 }
            r13.<init>()     // Catch:{ Exception -> 0x00b3 }
            r14 = 0
            r1.drawBitmap(r2, r13, r14)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r13 = "watermarkFestivals"
            android.graphics.drawable.Drawable r13 = com.tapcrowd.app.utils.C1216LO.getLoDrawable(r13)     // Catch:{ Exception -> 0x00b3 }
            if (r13 == 0) goto L_0x0089
            java.lang.String r13 = "watermarkFestivals"
            android.graphics.drawable.Drawable r13 = com.tapcrowd.app.utils.C1216LO.getLoDrawable(r13)     // Catch:{ Exception -> 0x00b3 }
            android.graphics.drawable.BitmapDrawable r13 = (android.graphics.drawable.BitmapDrawable) r13     // Catch:{ Exception -> 0x00b3 }
            android.graphics.Bitmap r12 = r13.getBitmap()     // Catch:{ Exception -> 0x00b3 }
            int r13 = r2.getHeight()     // Catch:{ Exception -> 0x00b3 }
            double r4 = (double) r13     // Catch:{ Exception -> 0x00b3 }
            int r13 = r2.getWidth()     // Catch:{ Exception -> 0x00b3 }
            double r6 = (double) r13     // Catch:{ Exception -> 0x00b3 }
            int r13 = (int) r6     // Catch:{ Exception -> 0x00b3 }
            int r14 = (int) r4     // Catch:{ Exception -> 0x00b3 }
            r15 = 1
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createScaledBitmap(r12, r13, r14, r15)     // Catch:{ Exception -> 0x00b3 }
            int r13 = r2.getWidth()     // Catch:{ Exception -> 0x00b3 }
            int r14 = r10.getWidth()     // Catch:{ Exception -> 0x00b3 }
            int r13 = r13 - r14
            float r13 = (float) r13     // Catch:{ Exception -> 0x00b3 }
            int r14 = r2.getHeight()     // Catch:{ Exception -> 0x00b3 }
            int r15 = r10.getHeight()     // Catch:{ Exception -> 0x00b3 }
            int r14 = r14 - r15
            float r14 = (float) r14     // Catch:{ Exception -> 0x00b3 }
            r15 = 0
            r1.drawBitmap(r10, r13, r14, r15)     // Catch:{ Exception -> 0x00b3 }
        L_0x0089:
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00ae }
            r0 = r16
            java.lang.String r13 = r0.filename     // Catch:{ Exception -> 0x00ae }
            r8.<init>(r13)     // Catch:{ Exception -> 0x00ae }
            android.graphics.Bitmap$CompressFormat r13 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x00ae }
            r14 = 90
            r9.compress(r13, r14, r8)     // Catch:{ Exception -> 0x00ae }
        L_0x0099:
            android.support.v4.app.FragmentActivity r13 = r16.getActivity()     // Catch:{ Exception -> 0x00b3 }
            com.tapcrowd.app.modules.photosharer.PhotoSharerFragment$2 r14 = new com.tapcrowd.app.modules.photosharer.PhotoSharerFragment$2     // Catch:{ Exception -> 0x00b3 }
            r0 = r16
            r14.<init>()     // Catch:{ Exception -> 0x00b3 }
            com.tapcrowd.app.utils.C1204FB.makePost(r13, r9, r14)     // Catch:{ Exception -> 0x00b3 }
        L_0x00a7:
            return
        L_0x00a8:
            int r11 = r17.getHeight()     // Catch:{ Exception -> 0x00b3 }
            goto L_0x0017
        L_0x00ae:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ Exception -> 0x00b3 }
            goto L_0x0099
        L_0x00b3:
            r13 = move-exception
            goto L_0x00a7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapcrowd.app.modules.photosharer.PhotoSharerFragment.addWatermark(android.graphics.Bitmap):void");
    }

    private Bitmap getBitmap(String path) {
        Bitmap b;
        Uri uri = Uri.fromFile(new File(path));
        try {
            InputStream in = getActivity().getContentResolver().openInputStream(uri);
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(in, (Rect) null, o);
            in.close();
            int scale = 1;
            while (((double) (o.outWidth * o.outHeight)) * (1.0d / Math.pow((double) scale, 2.0d)) > 350000.0d) {
                scale++;
            }
            InputStream in2 = getActivity().getContentResolver().openInputStream(uri);
            if (scale > 1) {
                BitmapFactory.Options o2 = new BitmapFactory.Options();
                o2.inSampleSize = scale - 1;
                Bitmap b2 = BitmapFactory.decodeStream(in2, (Rect) null, o2);
                int height = b2.getHeight();
                int width = b2.getWidth();
                double y = Math.sqrt(350000.0d / (((double) width) / ((double) height)));
                Bitmap scaledBitmap = Bitmap.createScaledBitmap(b2, (int) ((y / ((double) height)) * ((double) width)), (int) y, true);
                b2.recycle();
                b = scaledBitmap;
                System.gc();
            } else {
                b = BitmapFactory.decodeStream(in2);
            }
            in2.close();
            return b;
        } catch (IOException e) {
            return null;
        }
    }

    public Bitmap rotateBitmap(Bitmap input) {
        try {
            int orientation = new ExifInterface(getFile()).getAttributeInt("Orientation", 1);
            Matrix m = new Matrix();
            if (orientation == 3) {
                m.postRotate(180.0f);
                return Bitmap.createBitmap(input, 0, 0, input.getWidth(), input.getHeight(), m, true);
            } else if (orientation == 6) {
                m.postRotate(90.0f);
                return Bitmap.createBitmap(input, 0, 0, input.getWidth(), input.getHeight(), m, true);
            } else if (orientation != 8) {
                return input;
            } else {
                m.postRotate(270.0f);
                return Bitmap.createBitmap(input, 0, 0, input.getWidth(), input.getHeight(), m, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return input;
        }
    }

    public void saveBitmap(Bitmap input) {
        try {
            FileOutputStream out = new FileOutputStream(getFile());
            input.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class HttpMultipartPost extends AsyncTask<Void, Integer, String> {

        /* renamed from: pd */
        ProgressDialog f2101pd;
        long totalSize;

        private HttpMultipartPost() {
        }

        /* synthetic */ HttpMultipartPost(PhotoSharerFragment photoSharerFragment, HttpMultipartPost httpMultipartPost) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.f2101pd = new ProgressDialog(App.act);
            this.f2101pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                }
            });
            this.f2101pd.setProgressStyle(1);
            this.f2101pd.setMessage(PhotoSharerFragment.this.getResourceString(C0846R.string.uploading));
            this.f2101pd.setCancelable(false);
            this.f2101pd.show();
        }

        /* access modifiers changed from: protected */
        public String doInBackground(Void... arg0) {
            String fbid = null;
            try {
                fbid = new JSONObject(PhotoSharerFragment.this.facebook.request("me")).getString(DBFavorites.KEY_EVENT_ID);
            } catch (Exception e) {
            }
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext httpContext = new BasicHttpContext();
            HttpPost httpPost = new HttpPost(String.format("http://stream.tap.cr/app_%1$s/%2$s_%3$s/postpicture", new Object[]{App.f2123id, PhotoSharerFragment.this.type, PhotoSharerFragment.this.typeid}));
            httpPost.setHeader("Accept", "application/json");
            try {
                ProgressMultipartEntity multipartContent = new ProgressMultipartEntity(new ProgressMultipartEntity.ProgressListener() {
                    public void transferred(long num) {
                        HttpMultipartPost.this.publishProgress(new Integer[]{Integer.valueOf((int) ((((float) num) / ((float) HttpMultipartPost.this.totalSize)) * 100.0f))});
                    }
                });
                multipartContent.addPart("photo.jpg", new FileBody(new File(PhotoSharerFragment.this.getFile())));
                this.totalSize = multipartContent.getContentLength();
                multipartContent.addPart("appid", new StringBody(App.f2123id));
                if (fbid != null) {
                    multipartContent.addPart("fbid", new StringBody(fbid));
                }
                multipartContent.addPart("deviceid", new StringBody(User.getDeviceId()));
                multipartContent.addPart(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, new StringBody(PhotoSharerFragment.this.message));
                httpPost.setEntity(multipartContent);
                return EntityUtils.toString(httpClient.execute(httpPost, httpContext).getEntity(), "UTF-8");
            } catch (Exception e2) {
                System.out.println(e2);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(Integer... progress) {
            this.f2101pd.setProgress(progress[0].intValue());
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String ui) {
            File file = new File(PhotoSharerFragment.this.filename);
            PhotoSharerFragment.this.response = String.valueOf(String.format("http://stream.tap.cr/original/app_%1$s/%2$s_%3$s/postpicture", new Object[]{App.f2123id, PhotoSharerFragment.this.type, PhotoSharerFragment.this.typeid})) + "/" + file.getName();
            file.delete();
            this.f2101pd.dismiss();
            AlertDialog.Builder alertbox = new AlertDialog.Builder(PhotoSharerFragment.this.getActivity());
            alertbox.setMessage(PhotoSharerFragment.this.getResourceString(C0846R.string.share_picture));
            alertbox.setPositiveButton(C0846R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    PhotoSharerFragment.this.authorize();
                }
            });
            alertbox.setNegativeButton(PhotoSharerFragment.this.getResourceString(C0846R.string.f2002no), (DialogInterface.OnClickListener) null);
            alertbox.show();
            new ParseWallPhotosTask(PhotoSharerFragment.this, (ParseWallPhotosTask) null).execute(new Void[0]);
        }
    }

    public void setFile(String file) {
        SharedPreferences.Editor edit = getActivity().getSharedPreferences("photosharer", 0).edit();
        edit.putString("filename", file);
        edit.commit();
    }

    public String getFile() {
        return getActivity().getSharedPreferences("photosharer", 0).getString("filename", this.filename);
    }
}
