package com.google.android.gms.vision.face;

import android.graphics.PointF;
import java.util.Arrays;
import java.util.List;

public class Face {
    public static final float UNCOMPUTED_PROBABILITY = -1.0f;
    private int mId;
    private float zzaTm;
    private float zzaTn;
    private float zzbnA;
    private float zzbnB;
    private List<Landmark> zzbnC;
    private float zzbnD;
    private float zzbnE;
    private float zzbnF;
    private PointF zzbnz;

    public Face(int id, PointF position, float width, float height, float yawDegrees, float rollDegrees, Landmark[] landmarks, float isLeftEyeOpenScore, float isRightEyeOpenScore, float isSmilingScore) {
        this.mId = id;
        this.zzbnz = position;
        this.zzaTm = width;
        this.zzaTn = height;
        this.zzbnA = yawDegrees;
        this.zzbnB = rollDegrees;
        this.zzbnC = Arrays.asList(landmarks);
        if (isLeftEyeOpenScore < 0.0f || isLeftEyeOpenScore > 1.0f) {
            this.zzbnD = -1.0f;
        } else {
            this.zzbnD = isLeftEyeOpenScore;
        }
        if (isRightEyeOpenScore < 0.0f || isRightEyeOpenScore > 1.0f) {
            this.zzbnE = -1.0f;
        } else {
            this.zzbnE = isRightEyeOpenScore;
        }
        if (this.zzbnF < 0.0f || this.zzbnF > 1.0f) {
            this.zzbnF = -1.0f;
        } else {
            this.zzbnF = isSmilingScore;
        }
    }

    public float getEulerY() {
        return this.zzbnA;
    }

    public float getEulerZ() {
        return this.zzbnB;
    }

    public float getHeight() {
        return this.zzaTn;
    }

    public int getId() {
        return this.mId;
    }

    public float getIsLeftEyeOpenProbability() {
        return this.zzbnD;
    }

    public float getIsRightEyeOpenProbability() {
        return this.zzbnE;
    }

    public float getIsSmilingProbability() {
        return this.zzbnF;
    }

    public List<Landmark> getLandmarks() {
        return this.zzbnC;
    }

    public PointF getPosition() {
        return new PointF(this.zzbnz.x - (this.zzaTm / 2.0f), this.zzbnz.y - (this.zzaTn / 2.0f));
    }

    public float getWidth() {
        return this.zzaTm;
    }
}
