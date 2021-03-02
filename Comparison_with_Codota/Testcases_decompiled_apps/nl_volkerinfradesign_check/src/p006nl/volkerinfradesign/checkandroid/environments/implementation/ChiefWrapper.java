package p006nl.volkerinfradesign.checkandroid.environments.implementation;

import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.environments.Account;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.ChiefWrapper */
public class ChiefWrapper implements Account.Chief {

    /* renamed from: a */
    private final JsonObject f4903a;

    public ChiefWrapper(JsonObject jsonObject) {
        this.f4903a = jsonObject;
    }

    public String getName() {
        String str = "";
        if (m6001a("firstName")) {
            str = str + this.f4903a.get("firstName").getAsString();
        }
        if (m6001a("middleName")) {
            str = str + " " + this.f4903a.get("middleName").getAsString();
        }
        if (m6001a("lastName")) {
            return str + " " + this.f4903a.get("lastName").getAsString();
        }
        return str;
    }

    public JsonObject toJson() {
        return this.f4903a;
    }

    public String getEmail() {
        return this.f4903a.get("email").getAsString();
    }

    /* renamed from: a */
    private boolean m6001a(String str) {
        if (!this.f4903a.has(str) || this.f4903a.isJsonNull()) {
            return false;
        }
        if (this.f4903a.isJsonPrimitive()) {
            return StringUtils.isNotBlank(this.f4903a.get(str).getAsString());
        }
        return true;
    }

    public long getId() {
        return this.f4903a.get("id").getAsLong();
    }
}
