package p006nl.volkerinfradesign.checkandroid.environments;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import java.util.Calendar;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.AccountInfoStep;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

@Deprecated
/* renamed from: nl.volkerinfradesign.checkandroid.environments.Accounts */
public interface Accounts {

    @Deprecated
    /* renamed from: nl.volkerinfradesign.checkandroid.environments.Accounts$AccountCursor */
    public interface AccountCursor extends ViTaCursor {
        AccountInfoStep getAccountInfoStep();

        Calendar getBirthDay();

        long getBirthDayMillis();

        String getCompanyLogoExternalPath();

        String getCompanyLogoLocalPath();

        String getEmail();

        String getFirstName();

        String getFullName();

        String getHelpNumber();

        AccontRecordType getItemType();

        AccountKey getKey();

        String getLastName();

        String getMiddleName();

        Profile.Person getPersonInCharge();

        String getPhoneMobile();

        long getServerId();

        Theme getTheme();

        String getThemeColor();

        String getType();

        String getVcaNumber();

        VerificationStep getVerificationStep();

        boolean hasBirthDay();

        boolean hasServerId();

        boolean isSelected();

        boolean save(String str, String str2, String str3, String str4, Calendar calendar, String str5);

        boolean saveCompanyPicturepath(String str);

        boolean saveTheme(String str, String str2, String str3);

        void setSelected();
    }

    @Deprecated
    /* renamed from: nl.volkerinfradesign.checkandroid.environments.Accounts$AccountKey */
    public interface AccountKey extends Parcelable {
        boolean exists();

        String getEmail();

        long getId();

        Profile getProfile();

        boolean hasServerId();

        AccountCursor query();
    }

    @Deprecated
    /* renamed from: nl.volkerinfradesign.checkandroid.environments.Accounts$Profile */
    public interface Profile extends Parcelable {

        /* renamed from: nl.volkerinfradesign.checkandroid.environments.Accounts$Profile$Person */
        public interface Person extends Parcelable {
            String getEmail();

            String getName();

            long getServerId();
        }

        void apply();

        Calendar getBirthDay();

        String getFirstName();

        String getLastName();

        String getMiddleName();

        Person getPersonInCharge();

        String getPhoneMobile();

        String getVcaNumber();

        boolean hasBirthDay();

        boolean hasFirstName();

        boolean hasLastName();

        boolean hasMiddleName();

        boolean hasPersonInCharge();

        boolean hasPhoneMobile();

        boolean hasVcaNumber();

        boolean isChanged();

        void setBirthDay(Calendar calendar);

        void setFirstName(String str);

        void setLastName(String str);

        void setMiddleName(String str);

        void setPersonInCharge(Person person);

        void setPhoneMobile(String str);

        void setVcaNumber(String str);
    }

    AccountKey addUser(String str);

    UpdateResult downloadAccountInfo();

    boolean exists(String str);

    AccountCursor getAll();

    AccountKey getKey(long j);

    AccountKey getKey(String str);

    AccountCursor getSelected();

    boolean hasPending();

    boolean hasSelected();

    boolean invalidateAccounts();

    boolean isEmpty();

    void registerObserver(DataSetObserver dataSetObserver);

    void removeAccount(AccountCursor accountCursor);

    boolean removeAccounts(long... jArr);

    String requestAccountCode(String str);

    void setSelected(AccountKey accountKey);

    void unregisterObserver(DataSetObserver dataSetObserver);

    UpdateResult updateAccountInfo();

    String verifyAccountCode(String str, int i);

    /* renamed from: nl.volkerinfradesign.checkandroid.environments.Accounts$AccontRecordType */
    public enum AccontRecordType {
        A_DEVICE_HEADER,
        B_DEVICE_CHILD,
        C_CUSTOM_HEADER,
        D_CUSTOM_CHILD;
        
        public static final int SIZE = 0;

        static {
            SIZE = values().length;
        }

        public String ordinalString() {
            return Integer.toString(ordinal());
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.environments.Accounts$VerificationStep */
    public enum VerificationStep {
        A_PENDING_VERIFICATION {
            public CharSequence getDescription(Context context) {
                return "Bezig met verifieren...";
            }
        },
        B_RED_LISTED {
            public CharSequence getDescription(Context context) {
                return "Account is niet beschikbaar.";
            }
        },
        C_VERIFICATION_FAILED {
            public CharSequence getDescription(Context context) {
                return "Verifieren mislukt. Probeer opnieuw.";
            }
        },
        D_NO_CODE {
            public CharSequence getDescription(Context context) {
                return "In afwachting op verificatiecode.";
            }
        },
        E_CODE_SENT {
            public CharSequence getDescription(Context context) {
                return "Verificatiecode verzonden.";
            }
        },
        F_CODE_WRONG {
            public CharSequence getDescription(Context context) {
                return "Fout tijdens invoer.";
            }
        },
        G_FINISHED {
            public CharSequence getDescription(Context context) {
                return "Account is klaar om te gebruiken";
            }
        };

        public abstract CharSequence getDescription(Context context);

        public String ordinalString() {
            return Integer.toString(ordinal());
        }
    }
}
