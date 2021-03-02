package p006nl.volkerinfradesign.checkandroid.background;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p009io.Charsets;
import org.apache.commons.p009io.FileUtils;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.background.AllInService;
import p006nl.volkerinfradesign.checkandroid.database.LocationsTable;
import p006nl.volkerinfradesign.checkandroid.database.PicturesTable;

/* renamed from: nl.volkerinfradesign.checkandroid.background.PicturesUploader */
public class PicturesUploader {
    PicturesUploader() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PictureResult mo9052a(AllInService.UploadWrapper uploadWrapper, PicturesTable.PicturesCursor picturesCursor) {
        boolean z;
        boolean z2 = false;
        try {
            String b = m5823b(uploadWrapper, picturesCursor);
            if (StringUtils.isNotBlank(b)) {
                z2 = m5822a(b, picturesCursor, Long.valueOf(uploadWrapper.mo8940a(picturesCursor)));
                z = z2;
            } else {
                z = false;
            }
            try {
                return new PictureResult(picturesCursor, z, z2, (Exception) null);
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
            return new PictureResult(picturesCursor, z, z2, e);
        }
    }

    /* renamed from: b */
    private String m5823b(AllInService.UploadWrapper uploadWrapper, PicturesTable.PicturesCursor picturesCursor) throws Exception {
        HttpURLConnection httpURLConnection = null;
        Gson create = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("inspectionItemId", (Number) Long.valueOf(uploadWrapper.mo8940a(picturesCursor)));
        jsonObject.add("params", jsonObject2);
        jsonObject.add("session", AppState.getInstance().getSIDJSON());
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) AppState.getInstance().getInspectionItemUploadUrl().openConnection();
            try {
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setRequestProperty("Content-Type", "text/json; charset=utf-8");
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(httpURLConnection2.getOutputStream(), CharEncoding.UTF_8));
                create.toJson((JsonElement) jsonObject, jsonWriter);
                jsonWriter.close();
                String iOUtils = IOUtils.toString(httpURLConnection2.getInputStream());
                IOUtils.close(httpURLConnection2);
                return iOUtils;
            } catch (Exception e) {
                Exception exc = e;
                httpURLConnection = httpURLConnection2;
                e = exc;
                try {
                    AppState.getInstance().invalidateLogin(httpURLConnection);
                    throw new IOException(IOUtils.toString(httpURLConnection.getErrorStream(), Charsets.UTF_8));
                } catch (Exception e2) {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                httpURLConnection = httpURLConnection2;
                th = th3;
                IOUtils.close(httpURLConnection);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            AppState.getInstance().invalidateLogin(httpURLConnection);
            throw new IOException(IOUtils.toString(httpURLConnection.getErrorStream(), Charsets.UTF_8));
        }
    }

    /* renamed from: a */
    private boolean m5822a(String str, PicturesTable.PicturesCursor picturesCursor, Long l) {
        try {
            String string = new OkHttpClient.Builder().connectionSpecs(Collections.singletonList(ConnectionSpec.MODERN_TLS)).readTimeout(1, TimeUnit.MINUTES).connectTimeout(1, TimeUnit.MINUTES).build().newCall(m5824b(str, picturesCursor, l)).execute().body().string();
            if (string != null && string.startsWith("https://")) {
                try {
                    String guid = picturesCursor.getGuid();
                    File file = new File(App.getInternalFilesDir(), "/inspectionItems");
                    FileUtils.deleteQuietly(new File(file, guid + "_mediumEncrypted.jpg"));
                    FileUtils.deleteQuietly(new File(file, guid + ".Encrypted.jpg"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    /* renamed from: b */
    private Request m5824b(String str, PicturesTable.PicturesCursor picturesCursor, Long l) {
        String guid = picturesCursor.getGuid();
        byte[] fullSize = picturesCursor.getFullSize();
        String l2 = l.toString();
        String l3 = Long.toString(picturesCursor.getCreationDate());
        MultipartBody.Builder builder = new MultipartBody.Builder();
        RequestBody create = RequestBody.create(MediaType.parse("image/jpeg"), fullSize);
        builder.addFormDataPart("inspectionItemID", l2);
        builder.addFormDataPart("dateShooted", l3);
        builder.addFormDataPart("pictureGuid", guid);
        m5821a(picturesCursor, builder);
        builder.addFormDataPart("itemImage", guid, create);
        return new Request.Builder().url(str).post(builder.build()).build();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.background.PicturesUploader$PictureResult */
    public static class PictureResult implements Parcelable {
        public static final Parcelable.Creator<PictureResult> CREATOR = new Parcelable.Creator<PictureResult>() {
            /* renamed from: a */
            public PictureResult[] newArray(int i) {
                return new PictureResult[i];
            }

            /* renamed from: a */
            public PictureResult createFromParcel(Parcel parcel) {
                return new PictureResult(parcel);
            }
        };
        public final Exception error;
        public final long pictureId;
        public final boolean uploaded;

        private PictureResult(PicturesTable.PicturesCursor picturesCursor, boolean z, boolean z2, Exception exc) {
            this.pictureId = picturesCursor.getId();
            this.uploaded = z && z2;
            this.error = exc;
        }

        private PictureResult(Parcel parcel) {
            this.pictureId = parcel.readLong();
            this.uploaded = parcel.readInt() == 1;
            this.error = (Exception) (parcel.readInt() == 1 ? parcel.readSerializable() : null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.pictureId);
            parcel.writeInt(this.uploaded ? 1 : 0);
            if (this.error != null) {
                parcel.writeInt(1);
                parcel.writeSerializable(this.error);
                return;
            }
            parcel.writeInt(0);
        }
    }

    /* renamed from: a */
    private void m5821a(PicturesTable.PicturesCursor picturesCursor, MultipartBody.Builder builder) {
        LocationsTable.LocationsCursor location = picturesCursor.getLocation();
        if (location != null) {
            try {
                if (location.moveToFirst()) {
                    builder.addFormDataPart("geoLat", Double.toString(location.getLatitude()));
                    builder.addFormDataPart("geoLon", Double.toString(location.getLongitude()));
                }
            } finally {
                location.close();
            }
        }
    }
}
