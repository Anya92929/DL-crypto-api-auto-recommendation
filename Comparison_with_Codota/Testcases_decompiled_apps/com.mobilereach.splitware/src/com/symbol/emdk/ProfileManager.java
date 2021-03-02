package com.symbol.emdk;

import org.w3c.dom.Document;

public class ProfileManager extends EMDKBase {

    public interface DataListener {
        void onData(ResultData resultData);
    }

    /* renamed from: com.symbol.emdk.ProfileManager$1 */
    class C03771 implements Runnable {
        public void run() {
            throw new RuntimeException("stub");
        }
    }

    /* renamed from: com.symbol.emdk.ProfileManager$2 */
    class C03782 implements Runnable {
        public void run() {
            throw new RuntimeException("stub");
        }
    }

    /* renamed from: com.symbol.emdk.ProfileManager$3 */
    class C03793 implements Runnable {
        public void run() {
            throw new RuntimeException("stub");
        }
    }

    /* 'enum' modifier removed */
    /* JADX WARNING: Enum class init method not found */
    public static final class PROFILE_FLAG extends Enum<PROFILE_FLAG> {
        public static final PROFILE_FLAG CHECK_COMPATIBILITY = null;
        public static final PROFILE_FLAG GET = null;
        public static final PROFILE_FLAG RESET = null;
        public static final PROFILE_FLAG SET = null;

        public static PROFILE_FLAG valueOf(String str) {
            throw new RuntimeException("stub");
        }

        public static PROFILE_FLAG[] values() {
            throw new RuntimeException("stub");
        }
    }

    public class ResultData {
        public ProfileConfig getProfileConfig() {
            throw new RuntimeException("stub");
        }

        public Document getProfileDocument() {
            throw new RuntimeException("stub");
        }

        public PROFILE_FLAG getProfileFlag() {
            throw new RuntimeException("stub");
        }

        public String getProfileName() {
            throw new RuntimeException("stub");
        }

        public String getProfileString() {
            throw new RuntimeException("stub");
        }

        public EMDKResults getResult() {
            throw new RuntimeException("stub");
        }
    }

    public static String CreateNameValuePair(String str, String str2, String str3) {
        throw new RuntimeException("stub");
    }

    public void addDataListener(DataListener dataListener) {
        throw new RuntimeException("stub");
    }

    public boolean isPreviousRequestPending() {
        throw new RuntimeException("stub");
    }

    public EMDKResults processProfile(String str, PROFILE_FLAG profile_flag, ProfileConfig profileConfig) {
        throw new RuntimeException("stub");
    }

    public EMDKResults processProfile(String str, PROFILE_FLAG profile_flag, Document document) {
        throw new RuntimeException("stub");
    }

    public EMDKResults processProfile(String str, PROFILE_FLAG profile_flag, String[] strArr) {
        throw new RuntimeException("stub");
    }

    public EMDKResults processProfileAsync(String str, PROFILE_FLAG profile_flag, ProfileConfig profileConfig) {
        throw new RuntimeException("stub");
    }

    public EMDKResults processProfileAsync(String str, PROFILE_FLAG profile_flag, Document document) {
        throw new RuntimeException("stub");
    }

    public EMDKResults processProfileAsync(String str, PROFILE_FLAG profile_flag, String[] strArr) {
        throw new RuntimeException("stub");
    }

    public void removeDataListener(DataListener dataListener) {
        throw new RuntimeException("stub");
    }
}
