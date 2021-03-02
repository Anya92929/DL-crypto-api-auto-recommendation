package p006nl.volkerinfradesign.checkandroid.environments;

import android.graphics.Bitmap;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.Calendar;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.Account */
public interface Account {
    public static final String COMPANY_PICTURE_PATH = "companyPicturePath";
    public static final String MODIFIED = "modified";

    /* renamed from: nl.volkerinfradesign.checkandroid.environments.Account$Chief */
    public interface Chief {
        long getId();

        String getName();

        JsonObject toJson();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.environments.Account$LogoCallback */
    public interface LogoCallback {
        void onFinish();

        void onStart();

        void onSuccess(Bitmap bitmap);
    }

    void apply(JsonObject jsonObject);

    Account copy();

    Calendar getBirthDay();

    Chief getChief();

    void getCompanyLogo(LogoCallback logoCallback);

    String getCompanyPictureUrl();

    String getEmail();

    String getFirstName();

    String getHelpNumber();

    String getLastName();

    String getMiddleName();

    long getModified();

    String getPhoneMobile();

    long getServerId();

    Theme getTheme();

    String getVcaNumber();

    boolean hasBirthDay();

    boolean hasChief();

    boolean hasFirstName();

    boolean hasLastName();

    boolean hasMiddleName();

    boolean hasPhoneMobile();

    boolean hasVcaNumber();

    void setBirthDay(Calendar calendar);

    void setChief(Chief chief);

    void setCompanyPicture(File file);

    void setFirstName(String str);

    void setLastName(String str);

    void setMiddleName(String str);

    void setPhoneMobile(String str);

    void setVcaNumber(String str);

    JsonObject toJson();
}
