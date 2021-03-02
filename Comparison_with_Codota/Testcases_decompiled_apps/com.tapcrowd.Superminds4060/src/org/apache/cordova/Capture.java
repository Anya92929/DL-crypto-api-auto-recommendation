package org.apache.cordova;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import com.google.android.gms.location.LocationStatusCodes;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.LOG;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.model.OAuthConstants;

public class Capture extends CordovaPlugin {
    private static final String AUDIO_3GPP = "audio/3gpp";
    private static final int CAPTURE_AUDIO = 0;
    private static final int CAPTURE_IMAGE = 1;
    private static final int CAPTURE_INTERNAL_ERR = 0;
    private static final int CAPTURE_NO_MEDIA_FILES = 3;
    private static final int CAPTURE_VIDEO = 2;
    private static final String IMAGE_JPEG = "image/jpeg";
    private static final String LOG_TAG = "Capture";
    private static final String VIDEO_3GPP = "video/3gpp";
    private static final String VIDEO_MP4 = "video/mp4";
    private CallbackContext callbackContext;
    private double duration;
    private long limit;
    private int numPics;
    private JSONArray results;

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext2) throws JSONException {
        this.callbackContext = callbackContext2;
        this.limit = 1;
        this.duration = 0.0d;
        this.results = new JSONArray();
        JSONObject options = args.optJSONObject(0);
        if (options != null) {
            this.limit = options.optLong("limit", 1);
            this.duration = options.optDouble("duration", 0.0d);
        }
        if (action.equals("getFormatData")) {
            callbackContext2.success(getFormatData(args.getString(0), args.getString(1)));
            return true;
        } else if (action.equals("captureAudio")) {
            captureAudio();
            return true;
        } else if (action.equals("captureImage")) {
            captureImage();
            return true;
        } else if (!action.equals("captureVideo")) {
            return false;
        } else {
            captureVideo(this.duration);
            return true;
        }
    }

    private JSONObject getFormatData(String filePath, String mimeType) throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("height", 0);
        obj.put("width", 0);
        obj.put("bitrate", 0);
        obj.put("duration", 0);
        obj.put("codecs", "");
        if (mimeType == null || mimeType.equals("")) {
            mimeType = FileUtils.getMimeType(filePath);
        }
        Log.d(LOG_TAG, "Mime type = " + mimeType);
        if (mimeType.equals(IMAGE_JPEG) || filePath.endsWith(".jpg")) {
            return getImageData(filePath, obj);
        }
        if (mimeType.endsWith(AUDIO_3GPP)) {
            return getAudioVideoData(filePath, obj, false);
        }
        if (mimeType.equals(VIDEO_3GPP) || mimeType.equals(VIDEO_MP4)) {
            return getAudioVideoData(filePath, obj, true);
        }
        return obj;
    }

    private JSONObject getImageData(String filePath, JSONObject obj) throws JSONException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(FileUtils.stripFileProtocol(filePath), options);
        obj.put("height", options.outHeight);
        obj.put("width", options.outWidth);
        return obj;
    }

    private JSONObject getAudioVideoData(String filePath, JSONObject obj, boolean video) throws JSONException {
        MediaPlayer player = new MediaPlayer();
        try {
            player.setDataSource(filePath);
            player.prepare();
            obj.put("duration", player.getDuration() / LocationStatusCodes.GEOFENCE_NOT_AVAILABLE);
            if (video) {
                obj.put("height", player.getVideoHeight());
                obj.put("width", player.getVideoWidth());
            }
        } catch (IOException e) {
            Log.d(LOG_TAG, "Error: loading video file");
        }
        return obj;
    }

    private void captureAudio() {
        this.cordova.startActivityForResult(this, new Intent("android.provider.MediaStore.RECORD_SOUND"), 0);
    }

    private void captureImage() {
        this.numPics = queryImgDB(whichContentStore()).getCount();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", Uri.fromFile(new File(DirectoryManager.getTempDirectoryPath(this.cordova.getActivity()), "Capture.jpg")));
        this.cordova.startActivityForResult(this, intent, 1);
    }

    private void captureVideo(double duration2) {
        this.cordova.startActivityForResult(this, new Intent("android.media.action.VIDEO_CAPTURE"), 2);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Uri uri;
        if (resultCode == -1) {
            if (requestCode == 0) {
                this.results.put(createMediaFile(intent.getData()));
                if (((long) this.results.length()) >= this.limit) {
                    this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, this.results));
                } else {
                    captureAudio();
                }
            } else if (requestCode == 1) {
                try {
                    ContentValues values = new ContentValues();
                    values.put("mime_type", IMAGE_JPEG);
                    try {
                        uri = this.cordova.getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                    } catch (UnsupportedOperationException e) {
                        LOG.m2215d(LOG_TAG, "Can't write to external media storage.");
                        try {
                            uri = this.cordova.getActivity().getContentResolver().insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, values);
                        } catch (UnsupportedOperationException e2) {
                            LOG.m2215d(LOG_TAG, "Can't write to internal media storage.");
                            fail(createErrorObject(0, "Error capturing image - no media storage found."));
                            return;
                        }
                    }
                    FileInputStream fis = new FileInputStream(DirectoryManager.getTempDirectoryPath(this.cordova.getActivity()) + "/Capture.jpg");
                    OutputStream os = this.cordova.getActivity().getContentResolver().openOutputStream(uri);
                    byte[] buffer = new byte[4096];
                    while (true) {
                        int len = fis.read(buffer);
                        if (len == -1) {
                            break;
                        }
                        os.write(buffer, 0, len);
                    }
                    os.flush();
                    os.close();
                    fis.close();
                    this.results.put(createMediaFile(uri));
                    checkForDuplicateImage();
                    if (((long) this.results.length()) >= this.limit) {
                        this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, this.results));
                    } else {
                        captureImage();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    fail(createErrorObject(0, "Error capturing image."));
                }
            } else if (requestCode == 2) {
                this.results.put(createMediaFile(intent.getData()));
                if (((long) this.results.length()) >= this.limit) {
                    this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, this.results));
                } else {
                    captureVideo(this.duration);
                }
            }
        } else if (resultCode == 0) {
            if (this.results.length() > 0) {
                this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, this.results));
            } else {
                fail(createErrorObject(3, "Canceled."));
            }
        } else if (this.results.length() > 0) {
            this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, this.results));
        } else {
            fail(createErrorObject(3, "Did not complete!"));
        }
    }

    private JSONObject createMediaFile(Uri data) {
        File fp = new File(FileUtils.getRealPathFromURI(data, this.cordova));
        JSONObject obj = new JSONObject();
        try {
            obj.put(DBFavorites.KEY_NAME, fp.getName());
            obj.put("fullPath", "file://" + fp.getAbsolutePath());
            if (!fp.getAbsoluteFile().toString().endsWith(".3gp") && !fp.getAbsoluteFile().toString().endsWith(".3gpp")) {
                obj.put(Globalization.TYPE, FileUtils.getMimeType(fp.getAbsolutePath()));
            } else if (data.toString().contains("/audio/")) {
                obj.put(Globalization.TYPE, AUDIO_3GPP);
            } else {
                obj.put(Globalization.TYPE, VIDEO_3GPP);
            }
            obj.put("lastModifiedDate", fp.lastModified());
            obj.put("size", fp.length());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    private JSONObject createErrorObject(int code, String message) {
        JSONObject obj = new JSONObject();
        try {
            obj.put(OAuthConstants.CODE, code);
            obj.put("message", message);
        } catch (JSONException e) {
        }
        return obj;
    }

    public void fail(JSONObject err) {
        this.callbackContext.error(err);
    }

    private Cursor queryImgDB(Uri contentStore) {
        return this.cordova.getActivity().getContentResolver().query(contentStore, new String[]{DBFavorites.KEY_ID}, (String) null, (String[]) null, (String) null);
    }

    private void checkForDuplicateImage() {
        Uri contentStore = whichContentStore();
        Cursor cursor = queryImgDB(contentStore);
        if (cursor.getCount() - this.numPics == 2) {
            cursor.moveToLast();
            this.cordova.getActivity().getContentResolver().delete(Uri.parse(contentStore + "/" + (Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBFavorites.KEY_ID))).intValue() - 1)), (String) null, (String[]) null);
        }
    }

    private Uri whichContentStore() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        return MediaStore.Images.Media.INTERNAL_CONTENT_URI;
    }
}
