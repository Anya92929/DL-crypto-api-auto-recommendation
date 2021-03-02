package com.vertifi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.p000v4.view.InputDeviceCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.appcompat.C0137R;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

class CameraOverlay extends View implements View.OnTouchListener {
    private String mActionText;
    private Bitmap mBitmapCamera;
    private int mBottom;
    private CameraActivity mCameraActivity;
    private int mColorLetterbox;
    private float mCornerLength;
    private Rect mCropBounds;
    private int mHeight;
    private String mHintText;
    private int mLeft;
    private int mMinCornersForAction;
    private Paint mPaint;
    private Path mPathGrid;
    public Point mPointBL;
    public Point mPointBR;
    private Point mPointStartTouch;
    public Point mPointTL;
    public Point mPointTR;
    private Rect mRectLetterboxBottom;
    private Rect mRectLetterboxLeft;
    private Rect mRectLetterboxRight;
    private Rect mRectLetterboxTop;
    private int mRight;
    private float mStrokeWidth;
    private int mTextSizeLarge;
    private int mTextSizeMedium;
    private String mTitle;
    private int mTop;
    private boolean mTouchEnabled;
    private Typeface mTypeFaceHelvetica;
    private int mWidth;

    public CameraOverlay(Context context) {
        super(context);
        init(context);
    }

    public CameraOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CameraOverlay(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mCameraActivity = (CameraActivity) context;
        setOnTouchListener(this);
        this.mTitle = "CHECK IMAGE";
        this.mHintText = context.getResources().getString(C0137R.string.deposit_camera_info);
        this.mActionText = context.getResources().getString(C0137R.string.tap_for_photo);
        this.mMinCornersForAction = 3;
        this.mBitmapCamera = BitmapFactory.decodeResource(context.getResources(), C0137R.C0138drawable.camera);
        this.mPointStartTouch = new Point(0, 0);
        this.mTouchEnabled = true;
        this.mTextSizeLarge = (int) context.getResources().getDimension(C0137R.dimen.fontLarge);
        this.mTextSizeMedium = (int) context.getResources().getDimension(C0137R.dimen.fontMedium);
        this.mStrokeWidth = 3.0f * RDCGlobal.mScreenDensity;
        this.mCornerLength = ((float) RDCGlobal.mWindowWidth) * 0.04f;
        this.mWidth = RDCGlobal.mSizePreview.width;
        this.mHeight = RDCGlobal.mSizePreview.height;
        this.mPointTL = new Point();
        this.mPointTR = new Point();
        this.mPointBL = new Point();
        this.mPointBR = new Point();
        this.mColorLetterbox = context.getResources().getColor(C0137R.color.letterbox);
    }

    private void onDrawArrow(Canvas canvas, float f, float f2) {
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(-1);
        this.mPathGrid.reset();
        this.mPathGrid.moveTo(f, f2);
        this.mPathGrid.lineTo(f - (RDCGlobal.mScreenDensity * 4.0f), f2);
        this.mPathGrid.lineTo(f - (RDCGlobal.mScreenDensity * 4.0f), (RDCGlobal.mScreenDensity * 16.0f) + f2);
        this.mPathGrid.lineTo(f - (RDCGlobal.mScreenDensity * 12.0f), (RDCGlobal.mScreenDensity * 16.0f) + f2);
        this.mPathGrid.lineTo(f, (24.0f * RDCGlobal.mScreenDensity) + f2);
        this.mPathGrid.lineTo((RDCGlobal.mScreenDensity * 12.0f) + f, (RDCGlobal.mScreenDensity * 16.0f) + f2);
        this.mPathGrid.lineTo((RDCGlobal.mScreenDensity * 4.0f) + f, (RDCGlobal.mScreenDensity * 16.0f) + f2);
        this.mPathGrid.lineTo((RDCGlobal.mScreenDensity * 4.0f) + f, f2);
        this.mPathGrid.close();
        canvas.drawPath(this.mPathGrid, this.mPaint);
    }

    public void disableLiveCorners() {
        this.mMinCornersForAction = -1;
    }

    public boolean isLiveCornersEnabled() {
        return this.mMinCornersForAction >= 0;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = 0;
        if (this.mPaint == null) {
            this.mPaint = new Paint();
            this.mLeft = (int) (((float) this.mWidth) * RDCGlobal.mRectViewportPreview.left);
            this.mRight = (int) (((float) this.mWidth) * RDCGlobal.mRectViewportPreview.right);
            this.mTop = (int) (((float) this.mHeight) * RDCGlobal.mRectViewportPreview.top);
            this.mBottom = (int) (((float) this.mHeight) * RDCGlobal.mRectViewportPreview.bottom);
            this.mCropBounds = new Rect();
            this.mCropBounds.left = this.mLeft + ((int) (((double) (this.mRight - this.mLeft)) * 0.1d));
            this.mCropBounds.top = this.mTop + ((int) (((double) (this.mBottom - this.mTop)) * 0.4d));
            this.mCropBounds.bottom = this.mBottom - ((int) (((double) (this.mBottom - this.mTop)) * 0.4d));
            this.mCropBounds.right = this.mRight - ((int) (((double) (this.mRight - this.mLeft)) * 0.1d));
            this.mPathGrid = new Path();
            this.mTypeFaceHelvetica = Typeface.create("Helvetica", 0);
            if (this.mTop > 0) {
                this.mRectLetterboxTop = new Rect(0, 0, this.mWidth, this.mTop);
            }
            if (this.mBottom < this.mHeight) {
                this.mRectLetterboxBottom = new Rect(0, this.mBottom, this.mWidth, this.mHeight);
            }
            if (this.mLeft > 0) {
                this.mRectLetterboxLeft = new Rect(0, this.mTop, this.mLeft, this.mBottom);
            }
            if (this.mRight < this.mWidth) {
                this.mRectLetterboxRight = new Rect(this.mRight, this.mTop, this.mWidth, this.mBottom);
            }
        }
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mColorLetterbox);
        if (this.mRectLetterboxTop != null) {
            canvas.drawRect(this.mRectLetterboxTop, this.mPaint);
        }
        if (this.mRectLetterboxTop != null) {
            canvas.drawRect(this.mRectLetterboxBottom, this.mPaint);
        }
        if (this.mRectLetterboxLeft != null) {
            canvas.drawRect(this.mRectLetterboxLeft, this.mPaint);
        }
        if (this.mRectLetterboxRight != null) {
            canvas.drawRect(this.mRectLetterboxRight, this.mPaint);
        }
        this.mPaint.setShadowLayer(1.0f, 1.0f, -1.0f, ViewCompat.MEASURED_STATE_MASK);
        int i2 = this.mTop - ((int) ((24.0f * RDCGlobal.mScreenDensity) + (4.0f * RDCGlobal.mScreenDensity)));
        if (i2 < 0) {
            i2 = 0;
        }
        onDrawArrow(canvas, ((float) this.mLeft) + (40.0f * RDCGlobal.mScreenDensity), (float) i2);
        onDrawArrow(canvas, ((float) this.mRight) - (40.0f * RDCGlobal.mScreenDensity), (float) i2);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(-16711936);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        this.mPathGrid.reset();
        this.mPathGrid.moveTo(((float) this.mLeft) + (20.0f * RDCGlobal.mScreenDensity), (float) this.mTop);
        this.mPathGrid.lineTo((float) this.mLeft, (float) this.mTop);
        this.mPathGrid.lineTo((float) this.mLeft, (float) this.mBottom);
        this.mPathGrid.lineTo((float) this.mRight, (float) this.mBottom);
        this.mPathGrid.lineTo((float) this.mRight, (float) this.mTop);
        this.mPathGrid.lineTo(((float) this.mRight) - (20.0f * RDCGlobal.mScreenDensity), (float) this.mTop);
        canvas.drawPath(this.mPathGrid, this.mPaint);
        this.mPaint.setShadowLayer(5.0f * RDCGlobal.mScreenDensity, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(-1);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTypeface(this.mTypeFaceHelvetica);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize((float) this.mTextSizeLarge);
        int i3 = this.mTop - ((int) (10.0f * RDCGlobal.mScreenDensity));
        if (i3 < this.mTextSizeLarge) {
            i3 = this.mTop;
        }
        canvas.drawText(this.mTitle, (float) (this.mWidth / 2), (float) i3, this.mPaint);
        this.mPaint.setTextSize((float) this.mTextSizeMedium);
        int i4 = this.mBottom + this.mTextSizeMedium + ((int) (6.0f * RDCGlobal.mScreenDensity));
        if (i4 > this.mHeight) {
            i4 = this.mHeight;
        }
        canvas.drawText(this.mHintText, (float) (this.mWidth / 2), (float) i4, this.mPaint);
        if (this.mMinCornersForAction == -1) {
            super.onDraw(canvas);
            return;
        }
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(InputDeviceCompat.SOURCE_ANY);
        this.mPaint.setStrokeWidth(this.mStrokeWidth / 2.0f);
        this.mPaint.setShadowLayer(1.0f, 1.0f, -1.0f, ViewCompat.MEASURED_STATE_MASK);
        if (this.mPointTL.x > 0 && this.mPointTL.y > 0 && this.mPointTL.x <= this.mCropBounds.left && this.mPointTL.y <= this.mCropBounds.top) {
            if (((double) (((float) Math.abs(this.mPointTL.x - this.mPointBL.x)) / ((float) RDCGlobal.mSizePreview.width))) > 0.025d || ((double) (((float) Math.abs(this.mPointTL.y - this.mPointTR.y)) / ((float) RDCGlobal.mSizePreview.height))) > 0.025d) {
                this.mPaint.setStrokeWidth(this.mStrokeWidth / 2.0f);
                this.mPaint.setColor(InputDeviceCompat.SOURCE_ANY);
            } else {
                this.mPaint.setStrokeWidth(this.mStrokeWidth);
                this.mPaint.setColor(-16711936);
                i = 1;
            }
            this.mPathGrid.reset();
            this.mPathGrid.moveTo(((float) this.mPointTL.x) + this.mCornerLength, (float) this.mPointTL.y);
            this.mPathGrid.lineTo((float) this.mPointTL.x, (float) this.mPointTL.y);
            this.mPathGrid.lineTo((float) this.mPointTL.x, ((float) this.mPointTL.y) + this.mCornerLength);
            canvas.drawPath(this.mPathGrid, this.mPaint);
        }
        if (this.mPointBL.x > 0 && this.mPointBL.y > 0 && this.mPointBL.x <= this.mCropBounds.left && this.mPointBL.y >= this.mCropBounds.bottom) {
            if (((double) (((float) Math.abs(this.mPointBL.x - this.mPointTL.x)) / ((float) RDCGlobal.mSizePreview.width))) > 0.025d || ((double) (((float) Math.abs(this.mPointBL.y - this.mPointBR.y)) / ((float) RDCGlobal.mSizePreview.height))) > 0.025d) {
                this.mPaint.setStrokeWidth(this.mStrokeWidth / 2.0f);
                this.mPaint.setColor(InputDeviceCompat.SOURCE_ANY);
            } else {
                this.mPaint.setStrokeWidth(this.mStrokeWidth);
                this.mPaint.setColor(-16711936);
                i++;
            }
            this.mPathGrid.reset();
            this.mPathGrid.moveTo(((float) this.mPointBL.x) + this.mCornerLength, (float) this.mPointBL.y);
            this.mPathGrid.lineTo((float) this.mPointBL.x, (float) this.mPointBL.y);
            this.mPathGrid.lineTo((float) this.mPointBL.x, ((float) this.mPointBL.y) - this.mCornerLength);
            canvas.drawPath(this.mPathGrid, this.mPaint);
        }
        if (this.mPointTR.x > 0 && this.mPointTR.y > 0 && this.mPointTR.x >= this.mCropBounds.right && this.mPointTR.y <= this.mCropBounds.top) {
            if (((double) (((float) Math.abs(this.mPointTR.x - this.mPointBR.x)) / ((float) RDCGlobal.mSizePreview.width))) > 0.025d || ((double) (((float) Math.abs(this.mPointTR.y - this.mPointTL.y)) / ((float) RDCGlobal.mSizePreview.height))) > 0.025d) {
                this.mPaint.setStrokeWidth(this.mStrokeWidth / 2.0f);
                this.mPaint.setColor(InputDeviceCompat.SOURCE_ANY);
            } else {
                this.mPaint.setStrokeWidth(this.mStrokeWidth);
                this.mPaint.setColor(-16711936);
                i++;
            }
            this.mPathGrid.reset();
            this.mPathGrid.moveTo(((float) this.mPointTR.x) - this.mCornerLength, (float) this.mPointTR.y);
            this.mPathGrid.lineTo((float) this.mPointTR.x, (float) this.mPointTR.y);
            this.mPathGrid.lineTo((float) this.mPointTR.x, ((float) this.mPointTR.y) + this.mCornerLength);
            canvas.drawPath(this.mPathGrid, this.mPaint);
        }
        if (this.mPointBR.x > 0 && this.mPointBR.y > 0 && this.mPointBR.x >= this.mCropBounds.right && this.mPointBR.y >= this.mCropBounds.bottom) {
            if (((double) (((float) Math.abs(this.mPointBR.x - this.mPointTR.x)) / ((float) RDCGlobal.mSizePreview.width))) > 0.025d || ((double) (((float) Math.abs(this.mPointBR.y - this.mPointBL.y)) / ((float) RDCGlobal.mSizePreview.height))) > 0.025d) {
                this.mPaint.setStrokeWidth(this.mStrokeWidth / 2.0f);
                this.mPaint.setColor(InputDeviceCompat.SOURCE_ANY);
            } else {
                this.mPaint.setStrokeWidth(this.mStrokeWidth);
                this.mPaint.setColor(-16711936);
                i++;
            }
            this.mPathGrid.reset();
            this.mPathGrid.moveTo(((float) this.mPointBR.x) - this.mCornerLength, (float) this.mPointBR.y);
            this.mPathGrid.lineTo((float) this.mPointBR.x, (float) this.mPointBR.y);
            this.mPathGrid.lineTo((float) this.mPointBR.x, ((float) this.mPointBR.y) - this.mCornerLength);
            canvas.drawPath(this.mPathGrid, this.mPaint);
        }
        if (i >= this.mMinCornersForAction && this.mActionText.length() > 0) {
            this.mPaint.setAlpha(224);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(-1);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setTypeface(this.mTypeFaceHelvetica);
            this.mPaint.setTextAlign(Paint.Align.CENTER);
            this.mPaint.setTextSize((float) this.mTextSizeMedium);
            this.mPaint.setShadowLayer(5.0f * RDCGlobal.mScreenDensity, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
            int height = (this.mHeight / 2) + (this.mBitmapCamera.getHeight() / 2) + (this.mTextSizeMedium / 2) + ((int) (4.0d * ((double) RDCGlobal.mScreenDensity)));
            canvas.drawBitmap(this.mBitmapCamera, (float) ((this.mWidth / 2) - (this.mBitmapCamera.getWidth() / 2)), (float) ((this.mHeight / 2) - (this.mBitmapCamera.getHeight() / 2)), this.mPaint);
            canvas.drawText(this.mActionText, (float) (this.mWidth / 2), (float) height, this.mPaint);
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mTouchEnabled) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mPointStartTouch.x = (int) motionEvent.getX();
                    this.mPointStartTouch.y = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.mPointStartTouch.x > this.mLeft && this.mPointStartTouch.x < this.mRight && this.mPointStartTouch.y > this.mTop && this.mPointStartTouch.y < this.mBottom && ((float) Math.abs(this.mPointStartTouch.x - ((int) motionEvent.getX()))) <= RDCGlobal.mScreenDensity * 12.0f && ((float) Math.abs(this.mPointStartTouch.y - ((int) motionEvent.getY()))) <= RDCGlobal.mScreenDensity * 12.0f) {
                        this.mTouchEnabled = false;
                        this.mCameraActivity.onTakePicture(motionEvent);
                        break;
                    }
                case 3:
                    this.mPointStartTouch.x = 0;
                    this.mPointStartTouch.y = 0;
                    break;
            }
        }
        return true;
    }

    public void setAction(String str, int i) {
        this.mActionText = str;
        this.mMinCornersForAction = i;
    }

    public void setEnableTouch() {
        this.mTouchEnabled = true;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }
}
