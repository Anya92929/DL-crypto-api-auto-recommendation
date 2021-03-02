package org.apache.cordova;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary.Base64;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.LOG;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class CameraLauncher extends CordovaPlugin implements MediaScannerConnection.MediaScannerConnectionClient {
    private static final int ALLMEDIA = 2;
    private static final int CAMERA = 1;
    private static final int DATA_URL = 0;
    private static final int FILE_URI = 1;
    private static final String GET_All = "Get All";
    private static final String GET_PICTURE = "Get Picture";
    private static final String GET_VIDEO = "Get Video";
    private static final int JPEG = 0;
    private static final String LOG_TAG = "CameraLauncher";
    private static final int PHOTOLIBRARY = 0;
    private static final int PICTURE = 0;
    private static final int PNG = 1;
    private static final int SAVEDPHOTOALBUM = 2;
    private static final int VIDEO = 1;
    public CallbackContext callbackContext;
    private MediaScannerConnection conn;
    private boolean correctOrientation;
    private int encodingType;
    private Uri imageUri;
    private int mQuality;
    private int mediaType;
    private int numPics;
    private boolean saveToPhotoAlbum;
    private Uri scanMe;
    private int targetHeight;
    private int targetWidth;

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext2) throws JSONException {
        this.callbackContext = callbackContext2;
        if (!action.equals("takePicture")) {
            return false;
        }
        this.saveToPhotoAlbum = false;
        this.targetHeight = 0;
        this.targetWidth = 0;
        this.encodingType = 0;
        this.mediaType = 0;
        this.mQuality = 80;
        this.mQuality = args.getInt(0);
        int destType = args.getInt(1);
        int srcType = args.getInt(2);
        this.targetWidth = args.getInt(3);
        this.targetHeight = args.getInt(4);
        this.encodingType = args.getInt(5);
        this.mediaType = args.getInt(6);
        this.correctOrientation = args.getBoolean(8);
        this.saveToPhotoAlbum = args.getBoolean(9);
        if (this.targetWidth < 1) {
            this.targetWidth = -1;
        }
        if (this.targetHeight < 1) {
            this.targetHeight = -1;
        }
        if (srcType == 1) {
            takePicture(destType, this.encodingType);
        } else if (srcType == 0 || srcType == 2) {
            getImage(srcType, destType);
        }
        PluginResult r = new PluginResult(PluginResult.Status.NO_RESULT);
        r.setKeepCallback(true);
        callbackContext2.sendPluginResult(r);
        return true;
    }

    public void takePicture(int returnType, int encodingType2) {
        this.numPics = queryImgDB(whichContentStore()).getCount();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File photo = createCaptureFile(encodingType2);
        intent.putExtra("output", Uri.fromFile(photo));
        this.imageUri = Uri.fromFile(photo);
        if (this.cordova != null) {
            this.cordova.startActivityForResult(this, intent, returnType + 32 + 1);
        }
    }

    private File createCaptureFile(int encodingType2) {
        if (encodingType2 == 0) {
            return new File(DirectoryManager.getTempDirectoryPath(this.cordova.getActivity()), ".Pic.jpg");
        }
        if (encodingType2 == 1) {
            return new File(DirectoryManager.getTempDirectoryPath(this.cordova.getActivity()), ".Pic.png");
        }
        throw new IllegalArgumentException("Invalid Encoding Type: " + encodingType2);
    }

    public void getImage(int srcType, int returnType) {
        Intent intent = new Intent();
        String title = GET_PICTURE;
        if (this.mediaType == 0) {
            intent.setType("image/*");
        } else if (this.mediaType == 1) {
            intent.setType("video/*");
            title = GET_VIDEO;
        } else if (this.mediaType == 2) {
            intent.setType("*/*");
            title = GET_All;
        }
        intent.setAction("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (this.cordova != null) {
            this.cordova.startActivityForResult(this, Intent.createChooser(intent, new String(title)), ((srcType + 1) * 16) + returnType + 1);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        String exifPath;
        int srcType = (requestCode / 16) - 1;
        int destType = (requestCode % 16) - 1;
        int rotate = 0;
        if (srcType == 1) {
            if (resultCode == -1) {
                try {
                    ExifHelper exif = new ExifHelper();
                    try {
                        if (this.encodingType == 0) {
                            exif.createInFile(DirectoryManager.getTempDirectoryPath(this.cordova.getActivity()) + "/.Pic.jpg");
                            exif.readExifData();
                            rotate = exif.getOrientation();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Bitmap bitmap = null;
                    Uri uri = null;
                    if (destType == 0) {
                        bitmap = getScaledBitmap(FileUtils.stripFileProtocol(this.imageUri.toString()));
                        if (rotate != 0 && this.correctOrientation) {
                            bitmap = getRotatedBitmap(rotate, bitmap, exif);
                        }
                        processPicture(bitmap);
                        checkForDuplicateImage(0);
                    } else if (destType == 1) {
                        if (!this.saveToPhotoAlbum) {
                            uri = Uri.fromFile(new File(DirectoryManager.getTempDirectoryPath(this.cordova.getActivity()), System.currentTimeMillis() + ".jpg"));
                        } else {
                            uri = getUriFromMediaStore();
                        }
                        if (uri == null) {
                            failPicture("Error capturing image - no media storage found.");
                        }
                        if (this.targetHeight == -1 && this.targetWidth == -1 && this.mQuality == 100 && rotate == 0) {
                            writeUncompressedImage(uri);
                            this.callbackContext.success(uri.toString());
                        } else {
                            Bitmap bitmap2 = getScaledBitmap(FileUtils.stripFileProtocol(this.imageUri.toString()));
                            if (rotate != 0 && this.correctOrientation) {
                                bitmap2 = getRotatedBitmap(rotate, bitmap2, exif);
                            }
                            OutputStream os = this.cordova.getActivity().getContentResolver().openOutputStream(uri);
                            bitmap.compress(Bitmap.CompressFormat.JPEG, this.mQuality, os);
                            os.close();
                            if (this.encodingType == 0) {
                                if (this.saveToPhotoAlbum) {
                                    exifPath = FileUtils.getRealPathFromURI(uri, this.cordova);
                                } else {
                                    exifPath = uri.getPath();
                                }
                                exif.createOutFile(exifPath);
                                exif.writeExifData();
                            }
                        }
                        this.callbackContext.success(uri.toString());
                    }
                    cleanup(1, this.imageUri, uri, bitmap);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    failPicture("Error capturing image.");
                }
            } else if (resultCode == 0) {
                failPicture("Camera cancelled.");
            } else {
                failPicture("Did not complete!");
            }
        } else if (srcType != 0 && srcType != 2) {
        } else {
            if (resultCode == -1) {
                Uri uri2 = intent.getData();
                if (this.mediaType != 0) {
                    this.callbackContext.success(uri2.toString());
                } else if (this.targetHeight == -1 && this.targetWidth == -1 && this.mQuality == 100 && destType == 1 && !this.correctOrientation) {
                    this.callbackContext.success(uri2.toString());
                } else {
                    String imagePath = FileUtils.getRealPathFromURI(uri2, this.cordova);
                    String mimeType = FileUtils.getMimeType(imagePath);
                    if (imagePath == null || mimeType == null || (!mimeType.equalsIgnoreCase("image/jpeg") && !mimeType.equalsIgnoreCase("image/png"))) {
                        Log.d(LOG_TAG, "I either have a null image path or bitmap");
                        failPicture("Unable to retrieve path to picture!");
                        return;
                    }
                    Bitmap bitmap3 = getScaledBitmap(imagePath);
                    if (bitmap3 == null) {
                        Log.d(LOG_TAG, "I either have a null image path or bitmap");
                        failPicture("Unable to create bitmap!");
                        return;
                    }
                    if (this.correctOrientation) {
                        Cursor cursor = this.cordova.getActivity().getContentResolver().query(intent.getData(), new String[]{"orientation"}, (String) null, (String[]) null, (String) null);
                        if (cursor != null) {
                            cursor.moveToPosition(0);
                            rotate = cursor.getInt(0);
                            cursor.close();
                        }
                        if (rotate != 0) {
                            Matrix matrix = new Matrix();
                            matrix.setRotate((float) rotate);
                            bitmap3 = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), bitmap3.getHeight(), matrix, true);
                        }
                    }
                    if (destType == 0) {
                        processPicture(bitmap3);
                    } else if (destType == 1) {
                        if (this.targetHeight <= 0 || this.targetWidth <= 0) {
                            this.callbackContext.success(uri2.toString());
                        } else {
                            try {
                                String resizePath = DirectoryManager.getTempDirectoryPath(this.cordova.getActivity()) + "/resize.jpg";
                                ExifHelper exif2 = new ExifHelper();
                                try {
                                    if (this.encodingType == 0) {
                                        exif2.createInFile(resizePath);
                                        exif2.readExifData();
                                        int rotate2 = exif2.getOrientation();
                                    }
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                                FileOutputStream fileOutputStream = new FileOutputStream(resizePath);
                                bitmap3.compress(Bitmap.CompressFormat.JPEG, this.mQuality, fileOutputStream);
                                fileOutputStream.close();
                                if (this.encodingType == 0) {
                                    exif2.createOutFile(FileUtils.getRealPathFromURI(uri2, this.cordova));
                                    exif2.writeExifData();
                                }
                                this.callbackContext.success("file://" + resizePath + "?" + System.currentTimeMillis());
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                failPicture("Error retrieving image.");
                            }
                        }
                    }
                    if (bitmap3 != null) {
                        bitmap3.recycle();
                    }
                    System.gc();
                }
            } else if (resultCode == 0) {
                failPicture("Selection cancelled.");
            } else {
                failPicture("Selection did not complete!");
            }
        }
    }

    private Bitmap getRotatedBitmap(int rotate, Bitmap bitmap, ExifHelper exif) {
        Matrix matrix = new Matrix();
        if (rotate == 180) {
            matrix.setRotate((float) rotate);
        } else {
            matrix.setRotate((float) rotate, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        }
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        exif.resetOrientation();
        return bitmap2;
    }

    private void writeUncompressedImage(Uri uri) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(FileUtils.stripFileProtocol(this.imageUri.toString()));
        OutputStream os = this.cordova.getActivity().getContentResolver().openOutputStream(uri);
        byte[] buffer = new byte[4096];
        while (true) {
            int len = fis.read(buffer);
            if (len != -1) {
                os.write(buffer, 0, len);
            } else {
                os.flush();
                os.close();
                fis.close();
                return;
            }
        }
    }

    private Uri getUriFromMediaStore() {
        ContentValues values = new ContentValues();
        values.put("mime_type", "image/jpeg");
        try {
            return this.cordova.getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        } catch (UnsupportedOperationException e) {
            LOG.m2215d(LOG_TAG, "Can't write to external media storage.");
            try {
                return this.cordova.getActivity().getContentResolver().insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, values);
            } catch (UnsupportedOperationException e2) {
                LOG.m2215d(LOG_TAG, "Can't write to internal media storage.");
                return null;
            }
        }
    }

    private Bitmap getScaledBitmap(String imagePath) {
        if (this.targetWidth <= 0 && this.targetHeight <= 0) {
            return BitmapFactory.decodeFile(imagePath);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagePath, options);
        int[] widthHeight = calculateAspectRatio(options.outWidth, options.outHeight);
        options.inJustDecodeBounds = false;
        options.inSampleSize = calculateSampleSize(options.outWidth, options.outHeight, this.targetWidth, this.targetHeight);
        return Bitmap.createScaledBitmap(BitmapFactory.decodeFile(imagePath, options), widthHeight[0], widthHeight[1], true);
    }

    public int[] calculateAspectRatio(int origWidth, int origHeight) {
        int newWidth = this.targetWidth;
        int newHeight = this.targetHeight;
        if (newWidth <= 0 && newHeight <= 0) {
            newWidth = origWidth;
            newHeight = origHeight;
        } else if (newWidth > 0 && newHeight <= 0) {
            newHeight = (newWidth * origHeight) / origWidth;
        } else if (newWidth > 0 || newHeight <= 0) {
            double newRatio = ((double) newWidth) / ((double) newHeight);
            double origRatio = ((double) origWidth) / ((double) origHeight);
            if (origRatio > newRatio) {
                newHeight = (newWidth * origHeight) / origWidth;
            } else if (origRatio < newRatio) {
                newWidth = (newHeight * origWidth) / origHeight;
            }
        } else {
            newWidth = (newHeight * origWidth) / origHeight;
        }
        return new int[]{newWidth, newHeight};
    }

    public static int calculateSampleSize(int srcWidth, int srcHeight, int dstWidth, int dstHeight) {
        if (((float) srcWidth) / ((float) srcHeight) > ((float) dstWidth) / ((float) dstHeight)) {
            return srcWidth / dstWidth;
        }
        return srcHeight / dstHeight;
    }

    private Cursor queryImgDB(Uri contentStore) {
        return this.cordova.getActivity().getContentResolver().query(contentStore, new String[]{DBFavorites.KEY_ID}, (String) null, (String[]) null, (String) null);
    }

    private void cleanup(int imageType, Uri oldImage, Uri newImage, Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.recycle();
        }
        new File(FileUtils.stripFileProtocol(oldImage.toString())).delete();
        checkForDuplicateImage(imageType);
        if (this.saveToPhotoAlbum && newImage != null) {
            scanForGallery(newImage);
        }
        System.gc();
    }

    private void checkForDuplicateImage(int type) {
        int diff = 1;
        Uri contentStore = whichContentStore();
        Cursor cursor = queryImgDB(contentStore);
        int currentNumOfImages = cursor.getCount();
        if (type == 1 && this.saveToPhotoAlbum) {
            diff = 2;
        }
        if (currentNumOfImages - this.numPics == diff) {
            cursor.moveToLast();
            int id = Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBFavorites.KEY_ID))).intValue();
            if (diff == 2) {
                id--;
            }
            this.cordova.getActivity().getContentResolver().delete(Uri.parse(contentStore + "/" + id), (String) null, (String[]) null);
        }
    }

    private Uri whichContentStore() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        return MediaStore.Images.Media.INTERNAL_CONTENT_URI;
    }

    public void processPicture(Bitmap bitmap) {
        ByteArrayOutputStream jpeg_data = new ByteArrayOutputStream();
        try {
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, this.mQuality, jpeg_data)) {
                this.callbackContext.success(new String(Base64.encodeBase64(jpeg_data.toByteArray())));
            }
        } catch (Exception e) {
            failPicture("Error compressing image.");
        }
    }

    public void failPicture(String err) {
        this.callbackContext.error(err);
    }

    private void scanForGallery(Uri newImage) {
        this.scanMe = newImage;
        if (this.conn != null) {
            this.conn.disconnect();
        }
        this.conn = new MediaScannerConnection(this.cordova.getActivity().getApplicationContext(), this);
        this.conn.connect();
    }

    public void onMediaScannerConnected() {
        try {
            this.conn.scanFile(this.scanMe.toString(), "image/*");
        } catch (IllegalStateException e) {
            LOG.m2218e(LOG_TAG, "Can't scan file in MediaScanner after taking picture");
        }
    }

    public void onScanCompleted(String path, Uri uri) {
        this.conn.disconnect();
    }
}
