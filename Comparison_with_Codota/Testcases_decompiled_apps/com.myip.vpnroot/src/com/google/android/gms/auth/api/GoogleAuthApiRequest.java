package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleAuthApiRequest implements SafeParcelable {
    public static final GoogleAuthApiRequestCreator CREATOR = new GoogleAuthApiRequestCreator();
    public static final String DEFAULT_SCOPE_PREFIX = "oauth2:";
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int VERSION_CODE = 1;

    /* renamed from: DA */
    byte[] f376DA;

    /* renamed from: DB */
    long f377DB;

    /* renamed from: Dt */
    String f378Dt;

    /* renamed from: Du */
    Bundle f379Du;

    /* renamed from: Dv */
    String f380Dv;

    /* renamed from: Dw */
    List<String> f381Dw;

    /* renamed from: Dx */
    String f382Dx;

    /* renamed from: Dy */
    int f383Dy;

    /* renamed from: Dz */
    Bundle f384Dz;
    String name;
    String version;
    final int versionCode;

    /* renamed from: yR */
    String f385yR;

    GoogleAuthApiRequest(int versionCode2, String name2, String version2, String apiId, String path, Bundle parameters, String accountName, List<String> scopes, String scopePrefix, int httpMethod, Bundle headers, byte[] body, long timeout) {
        this.versionCode = versionCode2;
        this.name = name2;
        this.version = version2;
        this.f378Dt = apiId;
        this.f385yR = path;
        this.f379Du = parameters;
        this.f380Dv = accountName;
        this.f381Dw = scopes;
        this.f382Dx = scopePrefix;
        this.f383Dy = httpMethod;
        this.f384Dz = headers;
        this.f376DA = body;
        this.f377DB = timeout;
    }

    public GoogleAuthApiRequest(String name2, String version2, String apiId) {
        this.versionCode = 1;
        this.name = name2;
        m355ay(version2);
        this.f378Dt = apiId;
        this.f379Du = new Bundle();
        this.f381Dw = new ArrayList();
        this.f382Dx = DEFAULT_SCOPE_PREFIX;
        this.f384Dz = new Bundle();
        this.f376DA = new byte[0];
    }

    public GoogleAuthApiRequest(String name2, String version2, String path, int httpMethod) {
        this.versionCode = 1;
        this.name = name2;
        m355ay(version2);
        setPath(path);
        m354T(httpMethod);
        this.f379Du = new Bundle();
        this.f381Dw = new ArrayList();
        this.f382Dx = DEFAULT_SCOPE_PREFIX;
        this.f384Dz = new Bundle();
        this.f376DA = new byte[0];
    }

    /* renamed from: T */
    private void m354T(int i) {
        if (i < 0 || i > 7) {
            throw new IllegalArgumentException("Invalid HTTP method.");
        }
        this.f383Dy = i;
    }

    /* renamed from: ay */
    private void m355ay(String str) {
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            str = "v" + str;
        }
        this.version = str;
    }

    private void setPath(String path) {
        if (path.charAt(0) == '/') {
            path = path.substring(1);
        }
        if (path.charAt(path.length() - 1) == '/') {
            path = path.substring(0, path.length() - 1);
        }
        this.f385yR = path;
    }

    public void addParameter(String key, String value) {
        if (!this.f379Du.containsKey(key)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(value);
            this.f379Du.putStringArrayList(key, arrayList);
            return;
        }
        this.f379Du.getStringArrayList(key).add(value);
    }

    public void addScope(String scope) {
        this.f381Dw.add(scope);
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.f380Dv;
    }

    public String getApiId() {
        return this.f378Dt;
    }

    public String getFullScope() {
        String scope = getScope();
        if (scope == null) {
            return null;
        }
        return this.f382Dx + scope;
    }

    public String getHeader(String key) {
        return this.f384Dz.getString(key);
    }

    public Bundle getHeaders() {
        return this.f384Dz;
    }

    public Map<String, String> getHeadersAsMap() {
        HashMap hashMap = new HashMap();
        for (String str : this.f384Dz.keySet()) {
            hashMap.put(str, this.f384Dz.getString(str));
        }
        return hashMap;
    }

    public byte[] getHttpBody() {
        return this.f376DA;
    }

    public JSONObject getHttpBodyAsJson() throws JSONException {
        try {
            return new JSONObject(new String(this.f376DA, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            Log.e("GoogleAuthApiRequest", "Unsupported encoding error.");
            return null;
        }
    }

    public int getHttpMethod() {
        return this.f383Dy;
    }

    public String getName() {
        return this.name;
    }

    public Bundle getParameters() {
        return this.f379Du;
    }

    public Map<String, List<String>> getParametersAsMap() {
        HashMap hashMap = new HashMap();
        for (String str : this.f379Du.keySet()) {
            hashMap.put(str, this.f379Du.getStringArrayList(str));
        }
        return hashMap;
    }

    public String getPath() {
        return this.f385yR;
    }

    public String getScope() {
        if (this.f381Dw.size() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f381Dw.size()) {
                return stringBuffer.toString();
            }
            stringBuffer.append(this.f381Dw.get(i2));
            if (i2 != this.f381Dw.size() - 1) {
                stringBuffer.append(" ");
            }
            i = i2 + 1;
        }
    }

    public long getTimeout() {
        return this.f377DB;
    }

    public String getVersion() {
        return this.version;
    }

    public void putHeader(String key, String value) {
        this.f384Dz.putString(key, value);
    }

    public void setAccountName(String accountName) {
        this.f380Dv = accountName;
    }

    public void setHttpBody(String string) {
        try {
            this.f376DA = string.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e("GoogleAuthApiRequest", "Unsupported encoding error.");
        }
    }

    public void setTimeout(long timeout) {
        this.f377DB = timeout;
    }

    public String toString() {
        return "{ API: " + this.name + "/" + this.version + ", Scope: " + getFullScope() + ", Account: " + getAccountName() + " }";
    }

    public void writeToParcel(Parcel parcel, int flags) {
        GoogleAuthApiRequestCreator.m356a(this, parcel, flags);
    }
}
