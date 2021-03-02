package p006nl.volkerinfradesign.checkandroid.environments.implementation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.environments.Accounts;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.PersonImp */
public final class PersonImp implements Accounts.Profile.Person {
    public static final Parcelable.Creator<PersonImp> CREATOR = new Parcelable.Creator<PersonImp>() {
        /* renamed from: a */
        public PersonImp[] newArray(int i) {
            return new PersonImp[i];
        }

        /* renamed from: a */
        public PersonImp createFromParcel(Parcel parcel) {
            return new PersonImp(parcel);
        }
    };
    public static final JsonDeserializer<PersonImp> DESERIALIZER = new JsonDeserializer<PersonImp>() {
        /* renamed from: a */
        public PersonImp deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            long asLong = asJsonObject.get("userID").getAsLong();
            String trim = asJsonObject.get("email").getAsString().trim();
            String str = "";
            if (asJsonObject.has("firstName")) {
                String trim2 = asJsonObject.get("firstName").getAsString().trim();
                if (StringUtils.isNotBlank(trim2)) {
                    str = str + trim2 + " ";
                }
            }
            if (asJsonObject.has("middleName")) {
                String trim3 = asJsonObject.get("middleName").getAsString().trim();
                if (StringUtils.isNotBlank(trim3)) {
                    str = str + trim3 + " ";
                }
            }
            if (asJsonObject.has("lastName")) {
                String trim4 = asJsonObject.get("lastName").getAsString().trim();
                if (StringUtils.isNotBlank(trim4)) {
                    str = str + trim4 + " ";
                }
            }
            return new PersonImp(asLong, trim, str.trim());
        }
    };
    public final String email;

    /* renamed from: id */
    public final long f4912id;
    public final String name;

    public PersonImp(long j, String str, String str2) {
        this.f4912id = j;
        this.email = str;
        this.name = str2;
    }

    private PersonImp(Parcel parcel) {
        this.f4912id = parcel.readLong();
        this.email = parcel.readString();
        this.name = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4912id);
        parcel.writeString(this.name);
        parcel.writeString(this.email);
    }

    public long getServerId() {
        return this.f4912id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
}
