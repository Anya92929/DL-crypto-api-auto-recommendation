package com.actionbarsherlock.internal.nineoldandroids.animation;

public final class ObjectAnimator extends ValueAnimator {
    private static final boolean DBG = false;
    private String mPropertyName;
    private Object mTarget;

    public void setPropertyName(String propertyName) {
        if (this.mValues != null) {
            PropertyValuesHolder valuesHolder = this.mValues[0];
            String oldName = valuesHolder.getPropertyName();
            valuesHolder.setPropertyName(propertyName);
            this.mValuesMap.remove(oldName);
            this.mValuesMap.put(propertyName, valuesHolder);
        }
        this.mPropertyName = propertyName;
        this.mInitialized = false;
    }

    public String getPropertyName() {
        return this.mPropertyName;
    }

    public ObjectAnimator() {
    }

    private ObjectAnimator(Object target, String propertyName) {
        this.mTarget = target;
        setPropertyName(propertyName);
    }

    public static ObjectAnimator ofInt(Object target, String propertyName, int... values) {
        ObjectAnimator anim = new ObjectAnimator(target, propertyName);
        anim.setIntValues(values);
        return anim;
    }

    public static ObjectAnimator ofFloat(Object target, String propertyName, float... values) {
        ObjectAnimator anim = new ObjectAnimator(target, propertyName);
        anim.setFloatValues(values);
        return anim;
    }

    public static ObjectAnimator ofObject(Object target, String propertyName, TypeEvaluator evaluator, Object... values) {
        ObjectAnimator anim = new ObjectAnimator(target, propertyName);
        anim.setObjectValues(values);
        anim.setEvaluator(evaluator);
        return anim;
    }

    public static ObjectAnimator ofPropertyValuesHolder(Object target, PropertyValuesHolder... values) {
        ObjectAnimator anim = new ObjectAnimator();
        anim.mTarget = target;
        anim.setValues(values);
        return anim;
    }

    public void setIntValues(int... values) {
        if (this.mValues == null || this.mValues.length == 0) {
            setValues(PropertyValuesHolder.ofInt(this.mPropertyName, values));
            return;
        }
        super.setIntValues(values);
    }

    public void setFloatValues(float... values) {
        if (this.mValues == null || this.mValues.length == 0) {
            setValues(PropertyValuesHolder.ofFloat(this.mPropertyName, values));
            return;
        }
        super.setFloatValues(values);
    }

    public void setObjectValues(Object... values) {
        if (this.mValues == null || this.mValues.length == 0) {
            setValues(PropertyValuesHolder.ofObject(this.mPropertyName, (TypeEvaluator) null, values));
            return;
        }
        super.setObjectValues(values);
    }

    public void start() {
        super.start();
    }

    /* access modifiers changed from: package-private */
    public void initAnimation() {
        if (!this.mInitialized) {
            for (PropertyValuesHolder propertyValuesHolder : this.mValues) {
                propertyValuesHolder.setupSetterAndGetter(this.mTarget);
            }
            super.initAnimation();
        }
    }

    public ObjectAnimator setDuration(long duration) {
        super.setDuration(duration);
        return this;
    }

    public Object getTarget() {
        return this.mTarget;
    }

    public void setTarget(Object target) {
        if (this.mTarget != target) {
            Object oldTarget = this.mTarget;
            this.mTarget = target;
            if (oldTarget == null || target == null || oldTarget.getClass() != target.getClass()) {
                this.mInitialized = false;
            }
        }
    }

    public void setupStartValues() {
        initAnimation();
        for (PropertyValuesHolder propertyValuesHolder : this.mValues) {
            propertyValuesHolder.setupStartValue(this.mTarget);
        }
    }

    public void setupEndValues() {
        initAnimation();
        for (PropertyValuesHolder propertyValuesHolder : this.mValues) {
            propertyValuesHolder.setupEndValue(this.mTarget);
        }
    }

    /* access modifiers changed from: package-private */
    public void animateValue(float fraction) {
        super.animateValue(fraction);
        for (PropertyValuesHolder animatedValue : this.mValues) {
            animatedValue.setAnimatedValue(this.mTarget);
        }
    }

    public ObjectAnimator clone() {
        return (ObjectAnimator) super.clone();
    }

    public String toString() {
        String returnVal = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.mTarget;
        if (this.mValues != null) {
            for (int i = 0; i < this.mValues.length; i++) {
                returnVal = String.valueOf(returnVal) + "\n    " + this.mValues[i].toString();
            }
        }
        return returnVal;
    }
}
