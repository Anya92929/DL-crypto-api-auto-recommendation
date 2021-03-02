package sources.com.myip.vpnroot.util;

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

public class ObscuredSharedPreferences implements SharedPreferences {
    private static final char[] SEKRIT = {'X', '1', 'C', '#', '&'};
    protected static final String UTF8 = "utf-8";
    protected Context context;
    protected SharedPreferences delegate;

    public ObscuredSharedPreferences(Context context2, SharedPreferences delegate2) {
        this.delegate = delegate2;
        this.context = context2;
    }

    public class Editor implements SharedPreferences.Editor {
        protected SharedPreferences.Editor delegate;

        public Editor() {
            this.delegate = ObscuredSharedPreferences.this.delegate.edit();
        }

        public Editor putBoolean(String key, boolean value) {
            this.delegate.putString(key, ObscuredSharedPreferences.this.encrypt(Boolean.toString(value)));
            return this;
        }

        public Editor putFloat(String key, float value) {
            this.delegate.putString(key, ObscuredSharedPreferences.this.encrypt(Float.toString(value)));
            return this;
        }

        public Editor putInt(String key, int value) {
            this.delegate.putString(key, ObscuredSharedPreferences.this.encrypt(Integer.toString(value)));
            return this;
        }

        public Editor putLong(String key, long value) {
            this.delegate.putString(key, ObscuredSharedPreferences.this.encrypt(Long.toString(value)));
            return this;
        }

        public Editor putString(String key, String value) {
            this.delegate.putString(key, ObscuredSharedPreferences.this.encrypt(value));
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
        if (v == null || decrypt(v) == null) {
            return defValue;
        }
        return Boolean.parseBoolean(decrypt(v));
    }

    public float getFloat(String key, float defValue) {
        String v = this.delegate.getString(key, (String) null);
        if (v == null || decrypt(v) == null) {
            return defValue;
        }
        return Float.parseFloat(decrypt(v));
    }

    public int getInt(String key, int defValue) {
        String v = this.delegate.getString(key, (String) null);
        if (v == null || decrypt(v) == null) {
            return defValue;
        }
        return Integer.parseInt(decrypt(v));
    }

    public long getLong(String key, long defValue) {
        String v = this.delegate.getString(key, (String) null);
        if (v == null || decrypt(v) == null) {
            return defValue;
        }
        return Long.parseLong(decrypt(v));
    }

    public String getString(String key, String defValue) {
        String v = this.delegate.getString(key, (String) null);
        if (v == null || decrypt(v) == null) {
            return defValue;
        }
        return decrypt(v);
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
        try {
            byte[] salt = {125, 96, 67, 95, 2, -23, -32, -82};
            byte[] bytes = value != null ? value.getBytes(UTF8) : new byte[0];
            //PBEKeySpec spec = new PBEKeySpec(password);
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(new PBEKeySpec(SEKRIT)); // CRYPTOGRAPHIC API CALLSITE 1, CRYPTOGRAPHIC API CALLSITE 3 
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES"); // CRYPTOGRAPHIC API CALLSITE 6
            pbeCipher.init(1, key, new PBEParameterSpec(salt, 20)); // CRYPTOGRAPHIC API CALLSITE 2, CRYPTOGRAPHIC API CALLSITE 5
            return new String(Base64.encode(pbeCipher.doFinal(bytes), 2), UTF8); //  CRYPTOGRAPHIC API CALLSITE 4
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public String decrypt(String value) {
        try {
            byte[] salt = {125, 96, 67, 95, 2, -23, -32, -82};
            byte[] bytes = value != null ? Base64.decode(value, 2) : new byte[0];
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(new PBEKeySpec(SEKRIT)); // CRYPTOGRAPHIC API CALLSITE 12, CRYPTOGRAPHIC API CALLSITE 14
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES"); // CRYPTOGRAPHIC API CALLSITE 16
            //PBEParameterSpec spec = new PBEParameterSpec(salt, iterationCount);
            pbeCipher.init(2, key, new PBEParameterSpec(salt, 20)); // CRYPTOGRAPHIC API CALLSITE 11, CRYPTOGRAPHIC API CALLSITE 15
            try {
                return new String(pbeCipher.doFinal(bytes), UTF8); 
            } catch (Exception e) {
            	//PBEParameterSpec spec = new PBEParameterSpec(salt, iterationCount);
                pbeCipher.init(2, key, new PBEParameterSpec(Settings.Secure.getString(this.context.getContentResolver(), "android_id").getBytes(UTF8), 20)); // CRYPTOGRAPHIC API CALLSITE 13, CRYPTOGRAPHIC API CALLSITE 17
                try {
                    return new String(pbeCipher.doFinal(bytes), UTF8);
                } catch (Exception e2) {
                    return null;
                }
            }
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }

    public Set<String> getStringSet(String arg0, Set<String> set) {
        return null;
    }
}
