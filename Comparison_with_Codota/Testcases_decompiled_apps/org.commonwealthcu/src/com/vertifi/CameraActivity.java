package com.vertifi;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.p003v7.appcompat.C0137R;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;
import com.vertifi.imageproc.ImageProcessing;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public class CameraActivity extends Activity {
    public static final int VMB_MIN_CORNERS_FOR_OVERLAY = 3;
    private View.OnClickListener mAcceptListener = new View.OnClickListener() {
        public void onClick(View view) {
            boolean z = true;
            try {
                if (CameraActivity.this.mVIP != null) {
                    CameraActivity.this.mVIP.onProcessImageDestroy();
                }
                ImageProcessing unused = CameraActivity.this.mVIP = null;
                Intent intent = new Intent("com.Vertifi.ImageProcessing.Results");
                intent.putExtra("com.Vertifi.ImageProcessing.ImageColor", CameraActivity.this.mBytesColor);
                intent.putExtra("com.Vertifi.ImageProcessing.ImageBW", CameraActivity.this.mBytesBW);
                if (!CameraActivity.this.mIsFront) {
                    z = false;
                }
                intent.putExtra("com.Vertifi.ImageProcessing.FrontImage", z);
                CameraActivity.this.setResult(1, intent);
                CameraActivity.this.finish();
            } catch (Exception e) {
                Log.d("VIPSample", e.getMessage());
            }
        }
    };
    /* access modifiers changed from: private */
    public ImageButton mButtonAccept;
    /* access modifiers changed from: private */
    public ImageButton mButtonReject;
    /* access modifiers changed from: private */
    public byte[] mBytesBW;
    /* access modifiers changed from: private */
    public byte[] mBytesColor;
    /* access modifiers changed from: private */
    public CameraPreview mCameraPreview;
    /* access modifiers changed from: private */
    public StringBuilder mErrorMessage;
    /* access modifiers changed from: private */
    public FocusRectView mFocusRectView;
    /* access modifiers changed from: private */
    public boolean mIsFront;
    private boolean mIsPaused = false;
    /* access modifiers changed from: private */
    public RelativeLayout mLayoutView;
    public CameraOverlay mOverlay;
    /* access modifiers changed from: private */
    public View.OnClickListener mRejectListener = new View.OnClickListener() {
        public void onClick(View view) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(400);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    CameraActivity.this.mZoomView.setVisibility(4);
                    CameraActivity.this.mToolbarPreview.setVisibility(4);
                    CameraActivity.this.onShowFocusRect(new Point(CameraActivity.this.mCameraPreview.getWidth() / 2, CameraActivity.this.mCameraPreview.getHeight() / 2), false);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            CameraActivity.this.mZoomView.startAnimation(alphaAnimation);
            CameraActivity.this.mToolbarPreview.startAnimation(alphaAnimation);
            CameraActivity.this.mOverlay.setVisibility(0);
            CameraActivity.this.mOverlay.setEnableTouch();
            CameraActivity.this.mOverlay.bringToFront();
            CameraActivity.this.mCameraPreview.onStartPreview(true);
        }
    };
    private SeekBar.OnSeekBarChangeListener mSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            new AsyncTask() {
                Bitmap bmpBWThumb = null;

                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    try {
                        RDCGlobal.mListErrors.clear();
                        Bitmap onProcessImageBWDrawImage = CameraActivity.this.mVIP.onProcessImageBWDrawImage(CameraActivity.this.mSliderBrightness.getProgress(), RDCGlobal.mListErrors);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        onProcessImageBWDrawImage.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        byte[] unused = CameraActivity.this.mBytesBW = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        int width = onProcessImageBWDrawImage.getWidth();
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = false;
                        options.inPreferredConfig = Bitmap.Config.RGB_565;
                        int round = Math.round(((float) width) / (((float) RDCGlobal.mWindowWidth) * RDCGlobal.mScreenDensity));
                        if (round <= 0) {
                            round = 1;
                        }
                        options.inSampleSize = round;
                        this.bmpBWThumb = BitmapFactory.decodeByteArray(CameraActivity.this.mBytesBW, 0, CameraActivity.this.mBytesBW.length, options);
                        return null;
                    } catch (Exception e) {
                        Log.e("VIPSample", e.getMessage());
                        return null;
                    }
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Void voidR) {
                    if (this.bmpBWThumb != null) {
                        CameraActivity.this.mZoomView.setImageBitmap(this.bmpBWThumb);
                    }
                    CameraActivity.this.mSliderBrightness.setEnabled(true);
                    CameraActivity.this.mButtonReject.setEnabled(true);
                    CameraActivity.this.mButtonReject.setAlpha(255);
                    CameraActivity.this.mButtonAccept.setEnabled(true);
                    CameraActivity.this.mButtonAccept.setAlpha(255);
                    CameraActivity.this.mSpinner.setVisibility(4);
                }

                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    CameraActivity.this.mSliderBrightness.setEnabled(false);
                    CameraActivity.this.mButtonReject.setEnabled(false);
                    CameraActivity.this.mButtonReject.setAlpha(128);
                    CameraActivity.this.mButtonAccept.setEnabled(false);
                    CameraActivity.this.mButtonAccept.setAlpha(128);
                    CameraActivity.this.mSpinner.setVisibility(0);
                }
            }.execute(new Void[0]);
        }
    };
    /* access modifiers changed from: private */
    public SeekBar mSliderBrightness;
    /* access modifiers changed from: private */
    public ProgressBar mSpinner;
    /* access modifiers changed from: private */
    public RelativeLayout mToolbarPreview;
    /* access modifiers changed from: private */
    public ImageProcessing mVIP;
    /* access modifiers changed from: private */
    public ImageView mZoomView;

    class CreateOverlayTask extends AsyncTask {
        private CreateOverlayTask() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            while (RDCGlobal.mSizePreview == null) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            CameraActivity.this.mOverlay = new CameraOverlay(CameraActivity.this);
            CameraActivity.this.mOverlay.setLayoutParams(CameraActivity.this.mCameraPreview.getLayoutParams());
            CameraActivity.this.mLayoutView.addView(CameraActivity.this.mOverlay);
            Bundle extras = CameraActivity.this.getIntent().getExtras();
            if (extras != null) {
                CameraActivity.this.mOverlay.setTitle(extras.getString("com.Vertifi.ImageProcessing.CameraOverlayTitle"));
            }
            CameraActivity.this.onShowFocusRect(new Point(CameraActivity.this.mCameraPreview.getWidth() / 2, CameraActivity.this.mCameraPreview.getHeight() / 2), false);
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }
    }

    class ProcessPhotoTask extends AsyncTask {
        ProgressDialog mWorkingDialog;

        private ProcessPhotoTask() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            Bitmap bitmap;
            try {
                if (RDCGlobal.mRawImage != null) {
                    RDCGlobal.mListErrors.clear();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(RDCGlobal.mRawImage, 0, RDCGlobal.mRawImage.length, options);
                    RDCGlobal.mRawImage = null;
                    RDCGlobal.onGC();
                    Point[] pointArr = new Point[4];
                    Bitmap onProcessImageCropLocate = CameraActivity.this.mVIP.onProcessImageCropLocate(decodeByteArray, pointArr, RDCGlobal.mListErrors, CameraActivity.this.mIsFront ? null : RDCGlobal.mRectFront, RDCGlobal.mRectViewportPhoto, RDCGlobal.mSizeRawImage);
                    decodeByteArray.recycle();
                    RDCGlobal.onGC();
                    if (onProcessImageCropLocate != null) {
                        bitmap = CameraActivity.this.mVIP.onProcessImageCropTransform(onProcessImageCropLocate, pointArr, RDCGlobal.mListErrors, CameraActivity.this.mIsFront ? null : RDCGlobal.mRectFront);
                    } else {
                        bitmap = onProcessImageCropLocate;
                    }
                    if (bitmap != null) {
                        if (RDCGlobal.mListErrors.size() == 0) {
                            CameraActivity.this.mVIP.onProcessImageBWBindImage(bitmap);
                        }
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
                        byte[] unused = CameraActivity.this.mBytesColor = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (((ActivityManager) CameraActivity.this.getSystemService("activity")).getMemoryClass() > 32) {
                            float width = (((float) RDCGlobal.mWindowWidth) * RDCGlobal.mScreenDensity) / ((float) bitmap.getWidth());
                            if (width > 1.0f) {
                                width = 1.0f;
                            }
                            final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * width), (int) (width * ((float) bitmap.getHeight())), false);
                            CameraActivity.this.mZoomView.post(new Runnable() {
                                public void run() {
                                    CameraActivity.this.mZoomView.setImageBitmap(createScaledBitmap);
                                }
                            });
                        }
                        bitmap.recycle();
                        System.gc();
                        if (RDCGlobal.mListErrors.size() == 0) {
                            Bitmap onProcessImageBWDrawImageAuto = CameraActivity.this.mVIP.onProcessImageBWDrawImageAuto(RDCGlobal.mListErrors);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            onProcessImageBWDrawImageAuto.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                            byte[] unused2 = CameraActivity.this.mBytesBW = byteArrayOutputStream2.toByteArray();
                            byteArrayOutputStream2.close();
                            int width2 = onProcessImageBWDrawImageAuto.getWidth();
                            BitmapFactory.Options options2 = new BitmapFactory.Options();
                            options2.inJustDecodeBounds = false;
                            options2.inPreferredConfig = Bitmap.Config.RGB_565;
                            int round = Math.round(((float) width2) / (((float) RDCGlobal.mWindowWidth) * RDCGlobal.mScreenDensity));
                            if (round <= 0) {
                                round = 1;
                            }
                            options2.inSampleSize = round;
                            final Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(CameraActivity.this.mBytesBW, 0, CameraActivity.this.mBytesBW.length, options2);
                            CameraActivity.this.mZoomView.post(new Runnable() {
                                public void run() {
                                    CameraActivity.this.mZoomView.setImageBitmap(decodeByteArray2);
                                    CameraActivity.this.mSliderBrightness.setProgress(CameraActivity.this.mVIP.getBrightness());
                                }
                            });
                        }
                    }
                }
            } catch (Exception e) {
                Log.e("VIPSample", e.getMessage() == null ? "" : e.getMessage());
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            if (this.mWorkingDialog != null) {
                this.mWorkingDialog.dismiss();
            }
            this.mWorkingDialog = null;
            CameraActivity.this.mButtonReject.setEnabled(true);
            CameraActivity.this.mButtonReject.setAlpha(255);
            CameraActivity.this.mSliderBrightness.setEnabled(true);
            if (RDCGlobal.mListErrors.size() > 0) {
                CameraActivity.this.mErrorMessage.setLength(0);
                Iterator it = RDCGlobal.mListErrors.iterator();
                while (it.hasNext()) {
                    CameraActivity.this.mErrorMessage.append(String.format("* %s\n", new Object[]{(String) it.next()}));
                }
                CameraActivity.this.mErrorMessage.append("\nPlease take a new photo.");
            }
            if (CameraActivity.this.mErrorMessage.length() > 0) {
                CameraActivity.this.mButtonAccept.setEnabled(false);
                CameraActivity.this.mButtonAccept.setAlpha(128);
                CameraActivity.this.onCreateDialog(RDCGlobal.DIALOG_SHOW_ERRORS).show();
                return;
            }
            CameraActivity.this.mButtonAccept.setEnabled(true);
            CameraActivity.this.mButtonAccept.setAlpha(255);
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            StringBuilder unused = CameraActivity.this.mErrorMessage = new StringBuilder();
            this.mWorkingDialog = new ProgressDialog(CameraActivity.this);
            this.mWorkingDialog.setMessage("Processing photo...");
            this.mWorkingDialog.setIndeterminate(true);
            this.mWorkingDialog.setCancelable(false);
            this.mWorkingDialog.getWindow().clearFlags(2);
            this.mWorkingDialog.show();
        }
    }

    private Rect calculateFocusArea(int i, int i2) {
        int intValue = Float.valueOf(((((float) i) / ((float) this.mCameraPreview.getWidth())) * 2000.0f) - 1000.0f).intValue();
        int intValue2 = Float.valueOf(((((float) i2) / ((float) this.mCameraPreview.getHeight())) * 2000.0f) - 1000.0f).intValue();
        int min = Math.min(Math.max(intValue, -1000), 856);
        int min2 = Math.min(Math.max(intValue2, -1000), 856);
        return new Rect(min, min2, min + 144, min2 + 144);
    }

    public void onCreate(Bundle bundle) {
        try {
            requestWindowFeature(1);
            super.onCreate(bundle);
            setContentView(C0137R.layout.camera);
            getWindow().setFlags(1024, 1024);
            this.mIsFront = getIntent().getExtras().getBoolean("com.Vertifi.ImageProcessing.FrontImage", true);
            this.mVIP = new ImageProcessing((WeakReference) null, this.mIsFront);
            this.mLayoutView = (RelativeLayout) findViewById(C0137R.C0139id.layoutView);
            this.mToolbarPreview = (RelativeLayout) findViewById(C0137R.C0139id.layoutToolbarPreview);
            this.mSliderBrightness = (SeekBar) findViewById(C0137R.C0139id.sliderBrightness);
            this.mCameraPreview = (CameraPreview) findViewById(C0137R.C0139id.cameraPreview);
            this.mZoomView = (ImageView) findViewById(C0137R.C0139id.imageZoom);
            this.mSpinner = (ProgressBar) findViewById(C0137R.C0139id.progressBar);
            this.mButtonReject = (ImageButton) findViewById(C0137R.C0139id.buttonReject);
            this.mButtonAccept = (ImageButton) findViewById(C0137R.C0139id.buttonAccept);
            this.mButtonReject.setEnabled(false);
            this.mButtonReject.setAlpha(128);
            this.mButtonAccept.setEnabled(false);
            this.mButtonAccept.setAlpha(128);
            this.mSliderBrightness.setProgress(50);
            this.mSliderBrightness.setMax(100);
            this.mSliderBrightness.setKeyProgressIncrement(10);
            this.mSliderBrightness.setEnabled(false);
            this.mFocusRectView = new FocusRectView(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(48, 48);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 0;
            this.mFocusRectView.setLayoutParams(layoutParams);
            this.mFocusRectView.setVisibility(4);
            this.mLayoutView.addView(this.mFocusRectView);
            this.mButtonReject.setOnClickListener(this.mRejectListener);
            this.mButtonAccept.setOnClickListener(this.mAcceptListener);
            this.mSliderBrightness.setOnSeekBarChangeListener(this.mSeekBarChangeListener);
            new CreateOverlayTask().execute(new Void[0]);
        } catch (Exception e) {
            Toast.makeText(this, "Error Loading Camera Window: " + e.getMessage(), 0).show();
        }
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int i) {
        switch (i) {
            case RDCGlobal.DIALOG_SHOW_ERRORS:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Oops").setMessage(this.mErrorMessage.toString()).setIcon(17301543).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        CameraActivity.this.mRejectListener.onClick(CameraActivity.this.mButtonReject);
                    }
                });
                return builder.create();
            default:
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.mVIP != null) {
            this.mVIP.onProcessImagePause();
        }
        this.mCameraPreview.onStopPreview();
        this.mIsPaused = true;
    }

    public void onPictureFailed() {
        this.mOverlay.setAction(getResources().getString(C0137R.string.photo_failed), 0);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                CameraActivity.this.mOverlay.setEnableTouch();
                CameraActivity.this.mOverlay.setAction(CameraActivity.this.getResources().getString(C0137R.string.tap_for_photo), 3);
            }
        }, 2000);
    }

    public void onPictureTaken() {
        try {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(400);
            alphaAnimation2.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    CameraActivity.this.mOverlay.setVisibility(4);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            this.mCameraPreview.onStopPreview();
            this.mZoomView.setImageBitmap((Bitmap) null);
            this.mZoomView.startAnimation(alphaAnimation);
            this.mOverlay.disableLiveCorners();
            this.mOverlay.startAnimation(alphaAnimation2);
            this.mToolbarPreview.setVisibility(0);
            this.mToolbarPreview.bringToFront();
            this.mZoomView.setVisibility(0);
            new ProcessPhotoTask().execute(new Void[0]);
        } catch (Exception e) {
            Log.d("VIPSample", e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.mVIP != null) {
            this.mVIP.onProcessImageResume();
        }
        if (this.mIsPaused) {
            this.mCameraPreview.onStartPreview(true);
        }
    }

    public void onShowFocusRect(Point point, final boolean z) {
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mFocusRectView.getLayoutParams();
            layoutParams.leftMargin = (this.mCameraPreview.getLeft() + point.x) - (this.mFocusRectView.getWidth() / 2);
            layoutParams.topMargin = (this.mCameraPreview.getTop() + point.y) - (this.mFocusRectView.getHeight() / 2);
            this.mFocusRectView.setLayoutParams(layoutParams);
            this.mFocusRectView.bringToFront();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(1000);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(400);
                    alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            CameraActivity.this.mFocusRectView.setVisibility(4);
                            CameraActivity.this.mOverlay.setAction(z ? "" : CameraActivity.this.getResources().getString(C0137R.string.tap_for_photo), z ? -1 : 3);
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    CameraActivity.this.mFocusRectView.startAnimation(alphaAnimation);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    CameraActivity.this.mOverlay.setAction("", z ? 3 : -1);
                    CameraActivity.this.mFocusRectView.setVisibility(0);
                }
            });
            this.mFocusRectView.startAnimation(alphaAnimation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    public void onTakePicture(MotionEvent motionEvent) {
        Point point = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        Rect calculateFocusArea = calculateFocusArea(point.x, point.y);
        onShowFocusRect(point, true);
        this.mCameraPreview.onTakePicture(calculateFocusArea);
    }

    public void setCorners(Point point, Point point2, Point point3, Point point4) {
        try {
            if (this.mOverlay.mPointTL.x != point.x || this.mOverlay.mPointTL.y != point.y || this.mOverlay.mPointBL.x != point3.x || this.mOverlay.mPointBL.y != point3.y || this.mOverlay.mPointTR.x != point2.x || this.mOverlay.mPointTR.y != point2.y || this.mOverlay.mPointBR.x != point4.x || this.mOverlay.mPointBR.y != point4.y) {
                this.mOverlay.mPointTL.x = point.x;
                this.mOverlay.mPointTL.y = point.y;
                this.mOverlay.mPointTR.x = point2.x;
                this.mOverlay.mPointTR.y = point2.y;
                this.mOverlay.mPointBL.x = point3.x;
                this.mOverlay.mPointBL.y = point3.y;
                this.mOverlay.mPointBR.x = point4.x;
                this.mOverlay.mPointBR.y = point4.y;
                this.mOverlay.invalidate();
            }
        } catch (Exception e) {
        }
    }
}
