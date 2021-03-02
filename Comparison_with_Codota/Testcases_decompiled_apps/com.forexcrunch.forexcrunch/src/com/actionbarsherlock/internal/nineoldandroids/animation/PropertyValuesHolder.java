package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PropertyValuesHolder implements Cloneable {
    private static Class[] DOUBLE_VARIANTS = {Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};
    private static Class[] FLOAT_VARIANTS = {Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};
    private static Class[] INTEGER_VARIANTS = {Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};
    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    private static final HashMap<Class, HashMap<String, Method>> sGetterPropertyMap = new HashMap<>();
    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    private static final HashMap<Class, HashMap<String, Method>> sSetterPropertyMap = new HashMap<>();
    private Object mAnimatedValue;
    private TypeEvaluator mEvaluator;
    private Method mGetter;
    KeyframeSet mKeyframeSet;
    final ReentrantReadWriteLock mPropertyMapLock;
    String mPropertyName;
    Method mSetter;
    final Object[] mTmpValueArray;
    Class mValueType;

    private PropertyValuesHolder(String propertyName) {
        this.mSetter = null;
        this.mGetter = null;
        this.mKeyframeSet = null;
        this.mPropertyMapLock = new ReentrantReadWriteLock();
        this.mTmpValueArray = new Object[1];
        this.mPropertyName = propertyName;
    }

    /* synthetic */ PropertyValuesHolder(String str, PropertyValuesHolder propertyValuesHolder) {
        this(str);
    }

    public static PropertyValuesHolder ofInt(String propertyName, int... values) {
        return new IntPropertyValuesHolder(propertyName, values);
    }

    public static PropertyValuesHolder ofFloat(String propertyName, float... values) {
        return new FloatPropertyValuesHolder(propertyName, values);
    }

    public static PropertyValuesHolder ofObject(String propertyName, TypeEvaluator evaluator, Object... values) {
        PropertyValuesHolder pvh = new PropertyValuesHolder(propertyName);
        pvh.setObjectValues(values);
        pvh.setEvaluator(evaluator);
        return pvh;
    }

    public static PropertyValuesHolder ofKeyframe(String propertyName, Keyframe... values) {
        KeyframeSet keyframeSet = KeyframeSet.ofKeyframe(values);
        if (keyframeSet instanceof IntKeyframeSet) {
            return new IntPropertyValuesHolder(propertyName, (IntKeyframeSet) keyframeSet);
        }
        if (keyframeSet instanceof FloatKeyframeSet) {
            return new FloatPropertyValuesHolder(propertyName, (FloatKeyframeSet) keyframeSet);
        }
        PropertyValuesHolder pvh = new PropertyValuesHolder(propertyName);
        pvh.mKeyframeSet = keyframeSet;
        pvh.mValueType = values[0].getType();
        return pvh;
    }

    public void setIntValues(int... values) {
        this.mValueType = Integer.TYPE;
        this.mKeyframeSet = KeyframeSet.ofInt(values);
    }

    public void setFloatValues(float... values) {
        this.mValueType = Float.TYPE;
        this.mKeyframeSet = KeyframeSet.ofFloat(values);
    }

    public void setKeyframes(Keyframe... values) {
        int numKeyframes = values.length;
        Keyframe[] keyframes = new Keyframe[Math.max(numKeyframes, 2)];
        this.mValueType = values[0].getType();
        for (int i = 0; i < numKeyframes; i++) {
            keyframes[i] = values[i];
        }
        this.mKeyframeSet = new KeyframeSet(keyframes);
    }

    public void setObjectValues(Object... values) {
        this.mValueType = values[0].getClass();
        this.mKeyframeSet = KeyframeSet.ofObject(values);
    }

    private Method getPropertyFunction(Class targetClass, String prefix, Class valueType) {
        Class[] typeVariants;
        Method returnVal = null;
        String methodName = getMethodName(prefix, this.mPropertyName);
        if (valueType == null) {
            try {
                returnVal = targetClass.getMethod(methodName, (Class[]) null);
            } catch (NoSuchMethodException e) {
                Log.e("PropertyValuesHolder", String.valueOf(targetClass.getSimpleName()) + " - " + "Couldn't find no-arg method for property " + this.mPropertyName + ": " + e);
            }
        } else {
            Class[] args = new Class[1];
            if (this.mValueType.equals(Float.class)) {
                typeVariants = FLOAT_VARIANTS;
            } else if (this.mValueType.equals(Integer.class)) {
                typeVariants = INTEGER_VARIANTS;
            } else {
                typeVariants = this.mValueType.equals(Double.class) ? DOUBLE_VARIANTS : new Class[]{this.mValueType};
            }
            int length = typeVariants.length;
            int i = 0;
            while (i < length) {
                Class typeVariant = typeVariants[i];
                args[0] = typeVariant;
                try {
                    returnVal = targetClass.getMethod(methodName, args);
                    this.mValueType = typeVariant;
                    return returnVal;
                } catch (NoSuchMethodException e2) {
                    i++;
                }
            }
            Log.e("PropertyValuesHolder", "Couldn't find " + prefix + "ter property " + this.mPropertyName + " for " + targetClass.getSimpleName() + " with value type " + this.mValueType);
        }
        return returnVal;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.reflect.Method} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.reflect.Method setupSetterOrGetter(java.lang.Class r6, java.util.HashMap<java.lang.Class, java.util.HashMap<java.lang.String, java.lang.reflect.Method>> r7, java.lang.String r8, java.lang.Class r9) {
        /*
            r5 = this;
            r2 = 0
            java.util.concurrent.locks.ReentrantReadWriteLock r3 = r5.mPropertyMapLock     // Catch:{ all -> 0x003b }
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r3 = r3.writeLock()     // Catch:{ all -> 0x003b }
            r3.lock()     // Catch:{ all -> 0x003b }
            java.lang.Object r1 = r7.get(r6)     // Catch:{ all -> 0x003b }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x001c
            java.lang.String r3 = r5.mPropertyName     // Catch:{ all -> 0x003b }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x003b }
            r0 = r3
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch:{ all -> 0x003b }
            r2 = r0
        L_0x001c:
            if (r2 != 0) goto L_0x0031
            java.lang.reflect.Method r2 = r5.getPropertyFunction(r6, r8, r9)     // Catch:{ all -> 0x003b }
            if (r1 != 0) goto L_0x002c
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x003b }
            r1.<init>()     // Catch:{ all -> 0x003b }
            r7.put(r6, r1)     // Catch:{ all -> 0x003b }
        L_0x002c:
            java.lang.String r3 = r5.mPropertyName     // Catch:{ all -> 0x003b }
            r1.put(r3, r2)     // Catch:{ all -> 0x003b }
        L_0x0031:
            java.util.concurrent.locks.ReentrantReadWriteLock r3 = r5.mPropertyMapLock
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r3 = r3.writeLock()
            r3.unlock()
            return r2
        L_0x003b:
            r3 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r4 = r5.mPropertyMapLock
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r4 = r4.writeLock()
            r4.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.actionbarsherlock.internal.nineoldandroids.animation.PropertyValuesHolder.setupSetterOrGetter(java.lang.Class, java.util.HashMap, java.lang.String, java.lang.Class):java.lang.reflect.Method");
    }

    /* access modifiers changed from: package-private */
    public void setupSetter(Class targetClass) {
        this.mSetter = setupSetterOrGetter(targetClass, sSetterPropertyMap, "set", this.mValueType);
    }

    private void setupGetter(Class targetClass) {
        this.mGetter = setupSetterOrGetter(targetClass, sGetterPropertyMap, "get", (Class) null);
    }

    /* access modifiers changed from: package-private */
    public void setupSetterAndGetter(Object target) {
        Class targetClass = target.getClass();
        if (this.mSetter == null) {
            setupSetter(targetClass);
        }
        Iterator<Keyframe> it = this.mKeyframeSet.mKeyframes.iterator();
        while (it.hasNext()) {
            Keyframe kf = it.next();
            if (!kf.hasValue()) {
                if (this.mGetter == null) {
                    setupGetter(targetClass);
                }
                try {
                    kf.setValue(this.mGetter.invoke(target, new Object[0]));
                } catch (InvocationTargetException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (IllegalAccessException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }
    }

    private void setupValue(Object target, Keyframe kf) {
        try {
            if (this.mGetter == null) {
                setupGetter(target.getClass());
            }
            kf.setValue(this.mGetter.invoke(target, new Object[0]));
        } catch (InvocationTargetException e) {
            Log.e("PropertyValuesHolder", e.toString());
        } catch (IllegalAccessException e2) {
            Log.e("PropertyValuesHolder", e2.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public void setupStartValue(Object target) {
        setupValue(target, this.mKeyframeSet.mKeyframes.get(0));
    }

    /* access modifiers changed from: package-private */
    public void setupEndValue(Object target) {
        setupValue(target, this.mKeyframeSet.mKeyframes.get(this.mKeyframeSet.mKeyframes.size() - 1));
    }

    public PropertyValuesHolder clone() {
        try {
            PropertyValuesHolder newPVH = (PropertyValuesHolder) super.clone();
            newPVH.mPropertyName = this.mPropertyName;
            newPVH.mKeyframeSet = this.mKeyframeSet.clone();
            newPVH.mEvaluator = this.mEvaluator;
            return newPVH;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void setAnimatedValue(Object target) {
        if (this.mSetter != null) {
            try {
                this.mTmpValueArray[0] = getAnimatedValue();
                this.mSetter.invoke(target, this.mTmpValueArray);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void init() {
        TypeEvaluator typeEvaluator;
        if (this.mEvaluator == null) {
            if (this.mValueType == Integer.class) {
                typeEvaluator = sIntEvaluator;
            } else if (this.mValueType == Float.class) {
                typeEvaluator = sFloatEvaluator;
            } else {
                typeEvaluator = null;
            }
            this.mEvaluator = typeEvaluator;
        }
        if (this.mEvaluator != null) {
            this.mKeyframeSet.setEvaluator(this.mEvaluator);
        }
    }

    public void setEvaluator(TypeEvaluator evaluator) {
        this.mEvaluator = evaluator;
        this.mKeyframeSet.setEvaluator(evaluator);
    }

    /* access modifiers changed from: package-private */
    public void calculateValue(float fraction) {
        this.mAnimatedValue = this.mKeyframeSet.getValue(fraction);
    }

    public void setPropertyName(String propertyName) {
        this.mPropertyName = propertyName;
    }

    public String getPropertyName() {
        return this.mPropertyName;
    }

    /* access modifiers changed from: package-private */
    public Object getAnimatedValue() {
        return this.mAnimatedValue;
    }

    public String toString() {
        return String.valueOf(this.mPropertyName) + ": " + this.mKeyframeSet.toString();
    }

    static String getMethodName(String prefix, String propertyName) {
        if (propertyName == null || propertyName.length() == 0) {
            return prefix;
        }
        char firstLetter = Character.toUpperCase(propertyName.charAt(0));
        return String.valueOf(prefix) + firstLetter + propertyName.substring(1);
    }

    static class IntPropertyValuesHolder extends PropertyValuesHolder {
        int mIntAnimatedValue;
        IntKeyframeSet mIntKeyframeSet;

        public IntPropertyValuesHolder(String propertyName, IntKeyframeSet keyframeSet) {
            super(propertyName, (PropertyValuesHolder) null);
            this.mValueType = Integer.TYPE;
            this.mKeyframeSet = keyframeSet;
            this.mIntKeyframeSet = (IntKeyframeSet) this.mKeyframeSet;
        }

        public IntPropertyValuesHolder(String propertyName, int... values) {
            super(propertyName, (PropertyValuesHolder) null);
            setIntValues(values);
        }

        public void setIntValues(int... values) {
            PropertyValuesHolder.super.setIntValues(values);
            this.mIntKeyframeSet = (IntKeyframeSet) this.mKeyframeSet;
        }

        /* access modifiers changed from: package-private */
        public void calculateValue(float fraction) {
            this.mIntAnimatedValue = this.mIntKeyframeSet.getIntValue(fraction);
        }

        /* access modifiers changed from: package-private */
        public Object getAnimatedValue() {
            return Integer.valueOf(this.mIntAnimatedValue);
        }

        public IntPropertyValuesHolder clone() {
            IntPropertyValuesHolder newPVH = (IntPropertyValuesHolder) PropertyValuesHolder.super.clone();
            newPVH.mIntKeyframeSet = (IntKeyframeSet) newPVH.mKeyframeSet;
            return newPVH;
        }

        /* access modifiers changed from: package-private */
        public void setAnimatedValue(Object target) {
            if (this.mSetter != null) {
                try {
                    this.mTmpValueArray[0] = Integer.valueOf(this.mIntAnimatedValue);
                    this.mSetter.invoke(target, this.mTmpValueArray);
                } catch (InvocationTargetException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (IllegalAccessException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setupSetter(Class targetClass) {
            PropertyValuesHolder.super.setupSetter(targetClass);
        }
    }

    static class FloatPropertyValuesHolder extends PropertyValuesHolder {
        float mFloatAnimatedValue;
        FloatKeyframeSet mFloatKeyframeSet;

        public FloatPropertyValuesHolder(String propertyName, FloatKeyframeSet keyframeSet) {
            super(propertyName, (PropertyValuesHolder) null);
            this.mValueType = Float.TYPE;
            this.mKeyframeSet = keyframeSet;
            this.mFloatKeyframeSet = (FloatKeyframeSet) this.mKeyframeSet;
        }

        public FloatPropertyValuesHolder(String propertyName, float... values) {
            super(propertyName, (PropertyValuesHolder) null);
            setFloatValues(values);
        }

        public void setFloatValues(float... values) {
            PropertyValuesHolder.super.setFloatValues(values);
            this.mFloatKeyframeSet = (FloatKeyframeSet) this.mKeyframeSet;
        }

        /* access modifiers changed from: package-private */
        public void calculateValue(float fraction) {
            this.mFloatAnimatedValue = this.mFloatKeyframeSet.getFloatValue(fraction);
        }

        /* access modifiers changed from: package-private */
        public Object getAnimatedValue() {
            return Float.valueOf(this.mFloatAnimatedValue);
        }

        public FloatPropertyValuesHolder clone() {
            FloatPropertyValuesHolder newPVH = (FloatPropertyValuesHolder) PropertyValuesHolder.super.clone();
            newPVH.mFloatKeyframeSet = (FloatKeyframeSet) newPVH.mKeyframeSet;
            return newPVH;
        }

        /* access modifiers changed from: package-private */
        public void setAnimatedValue(Object target) {
            if (this.mSetter != null) {
                try {
                    this.mTmpValueArray[0] = Float.valueOf(this.mFloatAnimatedValue);
                    this.mSetter.invoke(target, this.mTmpValueArray);
                } catch (InvocationTargetException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (IllegalAccessException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setupSetter(Class targetClass) {
            PropertyValuesHolder.super.setupSetter(targetClass);
        }
    }
}
