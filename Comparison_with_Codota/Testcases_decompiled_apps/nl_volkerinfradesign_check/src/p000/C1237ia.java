package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Pair;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p009io.FileUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.environments.Account;
import p006nl.volkerinfradesign.checkandroid.environments.Theme;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.CheckEnvironment;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.ChiefWrapper;

/* renamed from: ia */
public final class C1237ia implements Account {

    /* renamed from: a */
    private final CheckEnvironment f4357a;

    /* renamed from: b */
    private final JsonObject f4358b;

    public C1237ia(CheckEnvironment checkEnvironment, JsonObject jsonObject) {
        this.f4357a = checkEnvironment;
        this.f4358b = jsonObject;
    }

    public String getEmail() {
        return m5505b(this.f4358b, "email");
    }

    public void setFirstName(String str) {
        this.f4358b.addProperty("firstName", str);
        this.f4357a.mo9622a(this.f4358b);
    }

    public void setMiddleName(String str) {
        this.f4358b.addProperty("middleName", str);
        this.f4357a.mo9622a(this.f4358b);
    }

    public void setLastName(String str) {
        this.f4358b.addProperty("lastName", str);
        this.f4357a.mo9622a(this.f4358b);
    }

    public void setVcaNumber(String str) {
        this.f4358b.addProperty("vcaNumber", str);
        this.f4357a.mo9622a(this.f4358b);
    }

    public void setPhoneMobile(String str) {
        this.f4358b.addProperty("phoneMobile", str);
        this.f4357a.mo9622a(this.f4358b);
    }

    public void setChief(Account.Chief chief) {
        if (chief != null) {
            this.f4358b.add("chief", chief.toJson());
        } else {
            this.f4358b.remove("chief");
        }
        this.f4357a.mo9622a(this.f4358b);
    }

    public Account.Chief getChief() {
        return new ChiefWrapper(this.f4358b.get("chief").getAsJsonObject());
    }

    public boolean hasChief() {
        return m5504a("chief");
    }

    public void setBirthDay(Calendar calendar) {
        this.f4358b.addProperty("birthDate", (Number) Long.valueOf(calendar.getTimeInMillis()));
        this.f4357a.mo9622a(this.f4358b);
    }

    public Calendar getBirthDay() {
        long asLong = this.f4358b.get("birthDate").getAsLong();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(asLong);
        return instance;
    }

    public boolean hasBirthDay() {
        return m5504a("birthDate");
    }

    public boolean hasFirstName() {
        return m5504a("firstName");
    }

    /* renamed from: a */
    private boolean m5504a(String str) {
        return m5503a(this.f4358b, str);
    }

    public String getFirstName() {
        return m5505b(this.f4358b, "firstName");
    }

    public boolean hasMiddleName() {
        return m5504a("middleName");
    }

    public String getMiddleName() {
        return m5505b(this.f4358b, "middleName");
    }

    public boolean hasLastName() {
        return m5504a("lastName");
    }

    public String getLastName() {
        return m5505b(this.f4358b, "lastName");
    }

    public boolean hasVcaNumber() {
        return m5504a("vcaNumber");
    }

    public String getVcaNumber() {
        return m5505b(this.f4358b, "vcaNumber");
    }

    public boolean hasPhoneMobile() {
        return m5504a("phoneMobile");
    }

    public String getPhoneMobile() {
        return m5505b(this.f4358b, "phoneMobile");
    }

    public Account copy() {
        return new C1237ia(this.f4357a, this.f4358b);
    }

    public String getCompanyPictureUrl() {
        if (m5504a("theme")) {
            JsonObject asJsonObject = this.f4358b.get("theme").getAsJsonObject();
            if (m5503a(asJsonObject, "companyPictureUrl")) {
                return asJsonObject.get("companyPictureUrl").getAsString();
            }
        }
        return null;
    }

    public JsonObject toJson() {
        return this.f4358b;
    }

    public void setCompanyPicture(File file) {
        this.f4358b.addProperty(Account.COMPANY_PICTURE_PATH, file != null ? file.getPath() : null);
        this.f4357a.mo9622a(this.f4358b);
    }

    public long getModified() {
        return m5504a(Account.MODIFIED) ? this.f4358b.get(Account.MODIFIED).getAsLong() : Calendar.getInstance().getTimeInMillis();
    }

    public void apply(JsonObject jsonObject) {
        for (Map.Entry next : jsonObject.entrySet()) {
            jsonObject.add((String) next.getKey(), (JsonElement) next.getValue());
        }
        this.f4357a.mo9622a(jsonObject);
    }

    public long getServerId() {
        return this.f4358b.get("id").getAsLong();
    }

    public String getHelpNumber() {
        if (m5503a(this.f4358b, "helpdesk")) {
            JsonObject asJsonObject = this.f4358b.get("helpdesk").getAsJsonObject();
            if (m5503a(asJsonObject, "phone")) {
                return m5505b(asJsonObject, "phone");
            }
        }
        return null;
    }

    public Theme getTheme() {
        if (m5503a(this.f4358b, "theme")) {
            JsonObject asJsonObject = this.f4358b.get("theme").getAsJsonObject();
            if (m5503a(asJsonObject, "color")) {
                try {
                    return Theme.valueOf(asJsonObject.get("color").getAsString());
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }
        return Theme.DEFAULT;
    }

    public void getCompanyLogo(Account.LogoCallback logoCallback) {
        if (m5503a(this.f4358b, "theme")) {
            JsonObject asJsonObject = this.f4358b.get("theme").getAsJsonObject();
            if (m5503a(asJsonObject, "companyPictureUrl")) {
                String asString = asJsonObject.get("companyPictureUrl").getAsString();
                Base64.encodeToString(asString.getBytes(), 0);
                Pair pair = new Pair(new File(new File(App.getInternalFilesDir() + "/logos"), "companylogo.png"), asString);
                new C1238a(logoCallback).executeOnExecutor(C1238a.SERIAL_EXECUTOR, new Pair[]{pair});
            }
        }
    }

    /* renamed from: ia$a */
    final class C1238a extends AsyncTask<Pair<File, String>, Void, Pair<File, Bitmap>> {

        /* renamed from: b */
        private final Account.LogoCallback f4360b;

        public C1238a(Account.LogoCallback logoCallback) {
            this.f4360b = logoCallback;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            if (this.f4360b != null) {
                this.f4360b.onStart();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Pair<File, Bitmap> doInBackground(Pair<File, String>... pairArr) {
            try {
                Pair<File, String> pair = pairArr[0];
                File file = (File) pair.first;
                if (BitmapFactory.decodeFile(file.getPath()) == null) {
                    FileUtils.copyURLToFile(new URL((String) pair.second), file, 5000, 5000);
                }
                return new Pair<>(file, BitmapFactory.decodeFile(file.getPath()));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(Pair<File, Bitmap> pair) {
            super.onCancelled(pair);
            if (this.f4360b != null) {
                this.f4360b.onFinish();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Pair<File, Bitmap> pair) {
            super.onPostExecute(pair);
            if (pair != null && this.f4360b != null) {
                this.f4360b.onSuccess((Bitmap) pair.second);
                this.f4360b.onFinish();
            }
        }
    }

    /* renamed from: a */
    private boolean m5503a(JsonObject jsonObject, String str) {
        if (!jsonObject.has(str) || jsonObject.isJsonNull()) {
            return false;
        }
        if (jsonObject.isJsonPrimitive()) {
            return StringUtils.isNotBlank(jsonObject.get(str).getAsString());
        }
        return true;
    }

    /* renamed from: b */
    private String m5505b(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            return jsonElement.getAsString();
        }
        return null;
    }
}
