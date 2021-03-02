package com.myip.vpnroot.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.util.Base64;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class UnObscuredSharedPreferences implements SharedPreferences {
    private static final char[] SEKRIT = {'X', '1', 'C', '#', '&'};
    protected static final String UTF8 = "utf-8";
    protected Context context;
    protected SharedPreferences delegate;

    public UnObscuredSharedPreferences(Context context2, SharedPreferences delegate2) {
        this.delegate = delegate2;
        this.context = context2;
    }

    public class Editor implements SharedPreferences.Editor {
        protected SharedPreferences.Editor delegate;

        public Editor() {
            this.delegate = UnObscuredSharedPreferences.this.delegate.edit();
        }

        public Editor putBoolean(String key, boolean value) {
            this.delegate.putString(key, UnObscuredSharedPreferences.this.encrypt(Boolean.toString(value)));
            return this;
        }

        public Editor putFloat(String key, float value) {
            this.delegate.putString(key, UnObscuredSharedPreferences.this.encrypt(Float.toString(value)));
            return this;
        }

        public Editor putInt(String key, int value) {
            this.delegate.putString(key, UnObscuredSharedPreferences.this.encrypt(Integer.toString(value)));
            return this;
        }

        public Editor putLong(String key, long value) {
            this.delegate.putString(key, UnObscuredSharedPreferences.this.encrypt(Long.toString(value)));
            return this;
        }

        public Editor putString(String key, String value) {
            this.delegate.putString(key.toString(), value.toString());
            return this;
        }

        public Editor clear() {
            this.delegate.clear();
            return this;
        }

        public boolean commit() {
            return this.delegate.commit();
        }

        public Editor remove(String s) {
            this.delegate.remove(s);
            return this;
        }

        public void apply() {
        }

        public SharedPreferences.Editor putStringSet(String arg0, Set<String> set) {
            return null;
        }
    }

    public Editor edit() {
        return new Editor();
    }

    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException();
    }

    public boolean getBoolean(String key, boolean defValue) {
        String v = this.delegate.getString(key, (String) null);
        return v != null ? Boolean.parseBoolean(decrypt(v)) : defValue;
    }

    public float getFloat(String key, float defValue) {
        String v = this.delegate.getString(key, (String) null);
        return v != null ? Float.parseFloat(decrypt(v)) : defValue;
    }

    public int getInt(String key, int defValue) {
        String v = this.delegate.getString(key, (String) null);
        return v != null ? Integer.parseInt(decrypt(v)) : defValue;
    }

    public long getLong(String key, long defValue) {
        String v = this.delegate.getString(key, (String) null);
        return v != null ? Long.parseLong(decrypt(v)) : defValue;
    }

    public String getString(String key, String defValue) {
        String v = this.delegate.getString(key, (String) null);
        return v != null ? v : defValue;
    }

    public boolean contains(String s) {
        return this.delegate.contains(s);
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.delegate.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.delegate.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* access modifiers changed from: protected */
    public String encrypt(String value) {
        byte[] bytes;
        if (value != null) {
            try {
                bytes = value.getBytes(UTF8);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            bytes = new byte[0];
        }
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(new PBEKeySpec(SEKRIT)); //  CRYPTOGRAPHIC API CALLSITE 31, CRYPTOGRAPHIC API CALLSITE 32
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES"); // CRYPTOGRAPHIC API CALLSITE 34
        //PBEParameterSpec spec = new PBEParameterSpec(salt, iterationCount);
        pbeCipher.init(1, key, new PBEParameterSpec(Settings.Secure.getString(this.context.getContentResolver(), "android_id").getBytes(UTF8), 20)); // CRYPTOGRAPHIC API CALLSITE 23, CRYPTOGRAPHIC API CALLSITE 35
        return new String(Base64.encode(pbeCipher.doFinal(bytes), 2), UTF8); // CRYPTOGRAPHIC API CALLSITE 24
    }

    /* access modifiers changed from: protected */
    public String decrypt(String value) {
        byte[] bytes;
        if (value != null) {
            try {
                bytes = Base64.decode(value, 0);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            bytes = new byte[0];
        }
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(new PBEKeySpec(SEKRIT)); // CRYPTOGRAPHIC API CALLSITE 26, CRYPTOGRAPHIC API CALLSITE 27
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES"); // CRYPTOGRAPHIC API CALLSITE 29
        //PBEParameterSpec spec = new PBEParameterSpec(salt, iterationCount);
        pbeCipher.init(2, key, new PBEParameterSpec(Settings.Secure.getString(this.context.getContentResolver(), "android_id").getBytes(UTF8), 20)); // CRYPTOGRAPHIC API CALLSITE 20, CRYPTOGRAPHIC API CALLSITE 28
        return new String(pbeCipher.doFinal(bytes), UTF8); // CRYPTOGRAPHIC API CALLSITE 19
    }

    public Set<String> getStringSet(String arg0, Set<String> set) {
        return null;
    }
}
