package com.tapcrowd.app.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.C1232UI;

public class SectionView extends LinearLayout {
    /* access modifiers changed from: private */
    public boolean open;
    private String text;
    View.OnClickListener toggle = new View.OnClickListener() {
        public void onClick(View v) {
            View arrow = SectionView.this.findViewById(C0846R.C0847id.arrow);
            ViewGroup content = (ViewGroup) SectionView.this.findViewById(C0846R.C0847id.content);
            if (SectionView.this.open) {
                ObjectAnimator.ofFloat((Object) arrow, "rotation", 180.0f, BitmapDescriptorFactory.HUE_RED).start();
                SectionView.this.collapse(content);
            } else {
                ObjectAnimator.ofFloat((Object) arrow, "rotation", BitmapDescriptorFactory.HUE_RED, 180.0f).start();
                SectionView.this.expand(content);
            }
            SectionView.this.open = !SectionView.this.open;
        }
    };

    public enum Type {
        Yes,
        f2142No,
        Optional,
        None
    }

    public SectionView(Context context) {
        super(context);
        construct();
    }

    public SectionView(Context context, String text2) {
        super(context);
        this.text = text2;
        construct();
    }

    public SectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray styledAttributes = context.obtainStyledAttributes(attrs, C0846R.styleable.separator);
        this.text = styledAttributes.getString(0);
        styledAttributes.recycle();
        construct();
    }

    public void construct() {
        LayoutInflater.from(getContext()).inflate(C0846R.layout.view_section, this, true);
        TextView text2 = (TextView) findViewById(C0846R.C0847id.text);
        if (this.text != null) {
            text2.setText(this.text);
        }
        findViewById(C0846R.C0847id.toggle).setOnClickListener(this.toggle);
        C1232UI.setFont((ViewGroup) this);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.open) {
            collapse((ViewGroup) findViewById(C0846R.C0847id.content));
            ObjectAnimator.ofFloat((Object) findViewById(C0846R.C0847id.arrow), "rotation", 180.0f, BitmapDescriptorFactory.HUE_RED).start();
            this.open = false;
        }
    }

    public void addView(String text2) {
        ((ViewGroup) findViewById(C0846R.C0847id.content)).addView(new SectionCell(getContext(), text2));
        C1232UI.setFont((ViewGroup) this);
    }

    public void addView(String text2, Type type) {
        ((ViewGroup) findViewById(C0846R.C0847id.content)).addView(new SectionCell(getContext(), text2, type));
        C1232UI.setFont((ViewGroup) this);
    }

    public void addView(String left, String right) {
        ((ViewGroup) findViewById(C0846R.C0847id.content)).addView(new SectionCell(getContext(), left, right));
        C1232UI.setFont((ViewGroup) this);
    }

    public void addView(String left, Type typeLeft, String right, Type typeRight) {
        ((ViewGroup) findViewById(C0846R.C0847id.content)).addView(new SectionCell(getContext(), left, typeLeft, right, typeRight));
        C1232UI.setFont((ViewGroup) this);
    }

    public void removeView(View view) {
        ((ViewGroup) findViewById(C0846R.C0847id.content)).removeView(view);
    }

    /* access modifiers changed from: private */
    public void expand(View v) {
        v.setVisibility(0);
        v.measure(View.MeasureSpec.makeMeasureSpec(((View) v.getParent()).getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        slideAnimator(v, 0, v.getMeasuredHeight()).start();
    }

    /* access modifiers changed from: private */
    public void collapse(final View v) {
        ValueAnimator mAnimator = slideAnimator(v, v.getHeight(), 0);
        mAnimator.addListener(new Animator.AnimatorListener() {
            public void onAnimationEnd(Animator animator) {
                v.setVisibility(8);
            }

            public void onAnimationCancel(Animator arg0) {
            }

            public void onAnimationRepeat(Animator arg0) {
            }

            public void onAnimationStart(Animator arg0) {
            }
        });
        mAnimator.start();
    }

    private ValueAnimator slideAnimator(final View v, int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                layoutParams.height = value;
                v.setLayoutParams(layoutParams);
            }
        });
        return animator;
    }

    private class SectionCell extends LinearLayout {
        private static /* synthetic */ int[] $SWITCH_TABLE$com$tapcrowd$app$views$SectionView$Type;

        static /* synthetic */ int[] $SWITCH_TABLE$com$tapcrowd$app$views$SectionView$Type() {
            int[] iArr = $SWITCH_TABLE$com$tapcrowd$app$views$SectionView$Type;
            if (iArr == null) {
                iArr = new int[Type.values().length];
                try {
                    iArr[Type.f2142No.ordinal()] = 2;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Type.None.ordinal()] = 4;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[Type.Optional.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[Type.Yes.ordinal()] = 1;
                } catch (NoSuchFieldError e4) {
                }
                $SWITCH_TABLE$com$tapcrowd$app$views$SectionView$Type = iArr;
            }
            return iArr;
        }

        public SectionCell(Context context, String left, String right) {
            super(context);
            LayoutInflater.from(getContext()).inflate(C0846R.layout.view_section_cell, this, true);
            TextView leftTv = (TextView) findViewById(C0846R.C0847id.text_left);
            leftTv.setText(left);
            if (left.equals("/")) {
                leftTv.setGravity(17);
            }
            TextView rightTv = (TextView) findViewById(C0846R.C0847id.text_right);
            rightTv.setText(right);
            if (right.equals("/")) {
                rightTv.setGravity(17);
            }
        }

        public SectionCell(Context context, String text) {
            super(context);
            LayoutInflater.from(getContext()).inflate(C0846R.layout.view_section_cell, this, true);
            TextView leftTv = (TextView) findViewById(C0846R.C0847id.text_left);
            leftTv.setText(text);
            if (text.equals("/")) {
                leftTv.setGravity(17);
            }
            ((TextView) findViewById(C0846R.C0847id.text_right)).setVisibility(8);
        }

        public SectionCell(Context context, String text, Type type) {
            super(context);
            LayoutInflater.from(getContext()).inflate(C0846R.layout.view_section_cell, this, true);
            TextView leftTv = (TextView) findViewById(C0846R.C0847id.text_left);
            leftTv.setText(text);
            if (text.equals("/")) {
                leftTv.setGravity(17);
            }
            TextView compoundLeft = (TextView) findViewById(C0846R.C0847id.compound_left);
            compoundLeft.setVisibility(0);
            switch ($SWITCH_TABLE$com$tapcrowd$app$views$SectionView$Type()[type.ordinal()]) {
                case 1:
                    compoundLeft.setBackgroundResource(C0846R.drawable.green_arrow);
                    break;
                case 2:
                    compoundLeft.setText("-");
                    break;
                case 3:
                    compoundLeft.setText("opt");
                    break;
                default:
                    compoundLeft.setVisibility(8);
                    break;
            }
            findViewById(C0846R.C0847id.right).setVisibility(8);
        }

        public SectionCell(Context context, String left, Type typeLeft, String right, Type typeRight) {
            super(context);
            LayoutInflater.from(getContext()).inflate(C0846R.layout.view_section_cell, this, true);
            TextView leftTv = (TextView) findViewById(C0846R.C0847id.text_left);
            leftTv.setText(left);
            if (left.equals("/")) {
                leftTv.setGravity(17);
            }
            TextView rightTv = (TextView) findViewById(C0846R.C0847id.text_right);
            rightTv.setText(right);
            if (right.equals("/")) {
                rightTv.setGravity(17);
            }
            TextView compoundLeft = (TextView) findViewById(C0846R.C0847id.compound_left);
            compoundLeft.setVisibility(0);
            switch ($SWITCH_TABLE$com$tapcrowd$app$views$SectionView$Type()[typeLeft.ordinal()]) {
                case 1:
                    compoundLeft.setBackgroundResource(C0846R.drawable.green_arrow);
                    break;
                case 2:
                    compoundLeft.setText("-");
                    break;
                case 3:
                    compoundLeft.setText("opt");
                    break;
                default:
                    compoundLeft.setVisibility(8);
                    break;
            }
            TextView compoundRight = (TextView) findViewById(C0846R.C0847id.compound_right);
            compoundRight.setVisibility(0);
            switch ($SWITCH_TABLE$com$tapcrowd$app$views$SectionView$Type()[typeRight.ordinal()]) {
                case 1:
                    compoundRight.setBackgroundResource(C0846R.drawable.green_arrow);
                    return;
                case 2:
                    compoundRight.setText("-");
                    return;
                case 3:
                    compoundRight.setText("opt");
                    return;
                default:
                    compoundRight.setVisibility(8);
                    return;
            }
        }
    }
}
