package p006nl.volkerinfradesign.checkandroid.background;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.app.NotificationCompat;
import android.support.p001v4.util.LongSparseArray;
import android.widget.Toast;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.gson.JsonElement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.ArrayUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.background.InspectionUploader;
import p006nl.volkerinfradesign.checkandroid.background.PicturesUploader;
import p006nl.volkerinfradesign.checkandroid.background.StatusUploader;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.LogTable;
import p006nl.volkerinfradesign.checkandroid.database.PictureKey;
import p006nl.volkerinfradesign.checkandroid.database.PicturesTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;

/* renamed from: nl.volkerinfradesign.checkandroid.background.AllInService */
public final class AllInService extends IntentService {
    public static final int RETRY_TIME = (AppState.getInstance().isDebugable() ? 10 : 60);

    /* renamed from: a */
    private static final SimpleDateFormat f4654a = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());

    /* renamed from: b */
    private final InspectionUploader f4655b = new InspectionUploader();

    /* renamed from: c */
    private final PicturesUploader f4656c = new PicturesUploader();

    /* renamed from: d */
    private final StatusUploader f4657d = new StatusUploader();

    /* renamed from: e */
    private Handler f4658e;

    /* renamed from: f */
    private boolean f4659f;

    /* renamed from: nl.volkerinfradesign.checkandroid.background.AllInService$VersionInfo */
    public interface VersionInfo {
        int getCode();

        String getName();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.background.AllInService$a */
    enum C1359a {
        INSPECTION,
        PICTURE,
        STATUS,
        ERROR,
        NO_USER
    }

    public static final void start(Context context) {
        Intent intent = new Intent(context, AllInService.class);
        intent.setAction("nl.volkerinfradesign.check.start_all_in_service");
        context.startService(intent);
    }

    /* renamed from: a */
    private static void m5780a(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(context, AllInService.class);
        long currentTimeMillis = System.currentTimeMillis() + ((long) (RETRY_TIME * LogTable.MAX_SIZE));
        intent.setAction("nl.volkerinfradesign.check.start_all_in_service");
        if (AppState.getInstance().isDebugable()) {
            AppState.getInstance().log().mo8931i("Restarting the AllInService at: " + f4654a.format(new Date(currentTimeMillis)));
        }
        alarmManager.set(1, currentTimeMillis, PendingIntent.getService(context, 0, intent, 134217728));
    }

    public AllInService() {
        super(AllInService.class.getSimpleName());
    }

    public void onCreate() {
        super.onCreate();
        this.f4659f = m5778a().getState().isDebugable();
        this.f4658e = new Handler(getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                C1359a aVar = C1359a.values()[message.what];
                switch (C13572.f4661a[aVar.ordinal()]) {
                    case 1:
                        AppState.getInstance().invalidateLogin();
                        break;
                    case 2:
                        break;
                    case 3:
                    case 4:
                    case 5:
                        if (Schema.getInspectionData().setUploadResult((UploadWrapper) message.getData().getParcelable(aVar.name()))) {
                            AllInService.this.m5778a().notifyDataSetChanged();
                            return;
                        }
                        return;
                    default:
                        throw new IllegalStateException("Message " + message.what + " unknown");
                }
                Toast.makeText(AllInService.this.getApplicationContext(), message.getData().getString("error"), 0);
            }
        };
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.background.AllInService$2 */
    static /* synthetic */ class C13572 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4661a = new int[C1359a.values().length];

        static {
            try {
                f4661a[C1359a.NO_USER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4661a[C1359a.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4661a[C1359a.STATUS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4661a[C1359a.PICTURE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4661a[C1359a.INSPECTION.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        UploadWrapper uploadWrapper;
        int i = 0;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        if (this.f4659f) {
            AppState.getInstance().log().mo8931i("Started AllInService at: " + f4654a.format(new Date(System.currentTimeMillis())));
        }
        if (intent.getAction() == null || !intent.getAction().equals("nl.volkerinfradesign.check.start_all_in_service")) {
            m5781a(C1359a.ERROR, "Use the static initializer AllInService.start()");
            return;
        }
        InspectionsTable.DataCursor pending = Schema.getInspectionData().getPending(false);
        while (true) {
            try {
                if (!pending.moveToPosition(i)) {
                    break;
                }
                uploadWrapper = new UploadWrapper(pending);
                if (!m5783b(uploadWrapper) || !m5782a(uploadWrapper)) {
                    m5780a((Context) m5778a());
                } else {
                    uploadWrapper.closeQuietly();
                    i++;
                }
            } catch (Throwable th) {
                pending.close();
                throw th;
            }
        }
        m5780a((Context) m5778a());
        uploadWrapper.closeQuietly();
        if (this.f4659f && pending.moveToFirst()) {
            AppState.getInstance().log().mo8931i("But there are no inspections to upload...");
        }
        pending.close();
    }

    /* renamed from: a */
    private boolean m5782a(UploadWrapper uploadWrapper) {
        AppState.getInstance().log().mo8931i("Uploading final status... (id=" + uploadWrapper.inspectionId + "&progress=" + uploadWrapper.mo8939a(true) + "&finished=" + uploadWrapper.mo8943b(true) + ")");
        StatusUploader.StatusResult upload = this.f4657d.upload(uploadWrapper);
        if (upload.uploaded) {
            AppState.getInstance().log().mo8931i("Uploading final status with succes!");
            Message message = new Message();
            Bundle bundle = new Bundle(1);
            StatusUploader.StatusResult unused = uploadWrapper.f4664c = upload;
            message.what = C1359a.STATUS.ordinal();
            bundle.putParcelable(C1359a.STATUS.name(), uploadWrapper);
            message.setData(bundle);
            this.f4658e.sendMessage(message);
            return true;
        }
        if (upload.error != null && this.f4659f) {
            AppState.getInstance().log().mo8930e("Error in uploading inspection", upload.error);
        }
        return false;
    }

    /* renamed from: b */
    private boolean m5783b(UploadWrapper uploadWrapper) {
        if (uploadWrapper.mo8942b()) {
            return m5784c(uploadWrapper);
        }
        if (this.f4659f) {
            AppState.getInstance().log().mo8931i("Uploading inspection... (id=" + uploadWrapper.inspectionId + ")");
        }
        InspectionUploader.InspectionResult a = this.f4655b.mo8991a(uploadWrapper);
        if (a.uploaded) {
            AppState.getInstance().log().mo8931i("Uploaded inspection with success!");
            Message message = new Message();
            Bundle bundle = new Bundle(1);
            InspectionUploader.InspectionResult unused = uploadWrapper.f4663b = a;
            uploadWrapper.closeQuietly();
            bundle.putParcelable(C1359a.INSPECTION.name(), uploadWrapper);
            message.setData(bundle);
            message.what = C1359a.INSPECTION.ordinal();
            this.f4658e.sendMessage(message);
            return m5784c(uploadWrapper);
        }
        if (a.error != null && this.f4659f) {
            AppState.getInstance().log().mo8930e("Error in uploading inspection", a.error);
        }
        return false;
    }

    /* renamed from: c */
    private boolean m5784c(UploadWrapper uploadWrapper) {
        PicturesTable.PicturesCursor a = uploadWrapper.mo8941a();
        if (this.f4659f) {
            AppState.getInstance().log().mo8931i("Found " + a.getCount() + " pictures from the root inspection.");
        }
        try {
            if (a.moveToFirst()) {
                do {
                    if (!uploadWrapper.isPictureUploaded(a)) {
                        AppState.getInstance().log().mo8931i("Uploading picture .. (id=" + a.getId() + ")");
                        PicturesUploader.PictureResult a2 = this.f4656c.mo9052a(uploadWrapper, a);
                        if (a2.uploaded) {
                            if (this.f4659f) {
                                AppState.getInstance().log().mo8931i("Successfully uploaded picture!");
                            }
                            Message message = new Message();
                            Bundle bundle = new Bundle(1);
                            uploadWrapper.f4665d.put(Long.valueOf(a.getId()), true);
                            uploadWrapper.closeQuietly();
                            bundle.putParcelable(C1359a.PICTURE.name(), uploadWrapper);
                            message.what = C1359a.PICTURE.ordinal();
                            message.setData(bundle);
                            this.f4658e.sendMessage(message);
                        } else if (a2.error != null) {
                            AppState.getInstance().log().mo8930e("Error in uploading picture", a2.error);
                            a.close();
                            return false;
                        }
                    } else {
                        AppState.getInstance().log().mo8931i("Picture already uploaded, so skipping to the next.");
                    }
                } while (a.moveToNext());
            }
            return true;
        } finally {
            a.close();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public App m5778a() {
        return (App) getApplication();
    }

    /* renamed from: a */
    private void m5781a(C1359a aVar, String str) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        message.what = aVar.ordinal();
        message.setData(bundle);
        bundle.putString("error", str);
        this.f4658e.sendMessage(message);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.background.AllInService$UploadWrapper */
    public static class UploadWrapper implements Parcelable {
        public static final Parcelable.Creator<UploadWrapper> CREATOR = new Parcelable.Creator<UploadWrapper>() {
            /* renamed from: a */
            public UploadWrapper[] newArray(int i) {
                return new UploadWrapper[i];
            }

            /* renamed from: a */
            public UploadWrapper createFromParcel(Parcel parcel) {
                return new UploadWrapper(parcel);
            }
        };

        /* renamed from: a */
        private InspectionsTable.DataCursor f4662a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public InspectionUploader.InspectionResult f4663b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public StatusUploader.StatusResult f4664c;
        public final long companyServerId;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final Hashtable<Long, Boolean> f4665d;
        public final long inspectionId;
        public final InspectionKey key;
        public final Long projectServerId;
        public final boolean savingAllowed;
        public final String title;

        UploadWrapper(InspectionsTable.DataCursor dataCursor) {
            boolean delete;
            this.key = dataCursor.getKey();
            this.title = dataCursor.getTitle();
            this.companyServerId = dataCursor.getCompanyServerId();
            this.projectServerId = dataCursor.getProjectServerId();
            this.savingAllowed = dataCursor.isSavingAllowed();
            this.inspectionId = dataCursor.getId();
            this.f4665d = new Hashtable<>();
            for (PictureKey next : this.key.getPictureKeysFromRoot()) {
                PicturesTable.PicturesCursor picturesCursor = next.get();
                try {
                    picturesCursor.getCount();
                    picturesCursor.moveToFirst();
                    delete = false;
                } catch (Exception e) {
                    delete = next.delete();
                } catch (Throwable th) {
                    picturesCursor.close();
                    throw th;
                }
                if (!delete) {
                    if (picturesCursor.moveToFirst()) {
                        do {
                            this.f4665d.put(Long.valueOf(picturesCursor.getId()), Boolean.valueOf(picturesCursor.isUploaded()));
                        } while (picturesCursor.moveToNext());
                    }
                }
                picturesCursor.close();
            }
        }

        private UploadWrapper(Parcel parcel) {
            String str;
            Long l = null;
            ClassLoader classLoader = getClass().getClassLoader();
            this.f4663b = (InspectionUploader.InspectionResult) (parcel.readInt() == 1 ? parcel.readParcelable(classLoader) : null);
            this.f4665d = new Hashtable<>((Map) parcel.readSerializable());
            if (parcel.readInt() == 1) {
                str = parcel.readString();
            } else {
                str = null;
            }
            this.title = str;
            this.companyServerId = parcel.readLong();
            this.projectServerId = parcel.readInt() == 1 ? Long.valueOf(parcel.readLong()) : l;
            this.key = (InspectionKey) parcel.readParcelable(classLoader);
            this.savingAllowed = parcel.readInt() == 1;
            this.inspectionId = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            if (this.f4663b != null) {
                parcel.writeInt(1);
                parcel.writeParcelable(this.f4663b, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeSerializable(this.f4665d);
            if (this.title != null) {
                parcel.writeInt(1);
                parcel.writeString(this.title);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeLong(this.companyServerId);
            if (this.projectServerId != null) {
                parcel.writeInt(1);
                parcel.writeLong(this.projectServerId.longValue());
            } else {
                parcel.writeInt(0);
            }
            parcel.writeParcelable(this.key, 0);
            if (!this.savingAllowed) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeLong(this.inspectionId);
            closeQuietly();
        }

        public boolean isPictureUploaded(PicturesTable.PicturesCursor picturesCursor) {
            Boolean bool = this.f4665d.get(Long.valueOf(picturesCursor.getId()));
            return (bool != null && bool.booleanValue()) || picturesCursor.isUploaded();
        }

        public void closeQuietly() {
            if (this.f4662a != null && !this.f4662a.isClosed()) {
                this.f4662a.close();
            }
        }

        public int describeContents() {
            return 0;
        }

        public long getInspectionServerId() {
            return (this.f4663b == null || this.f4663b.serverId == null) ? m5788e().getServerId() : this.f4663b.serverId.longValue();
        }

        public long[] getUploadedPictureIds() {
            HashSet hashSet = new HashSet();
            for (Map.Entry next : this.f4665d.entrySet()) {
                if (next.getValue() != null && ((Boolean) next.getValue()).booleanValue()) {
                    hashSet.add(next.getKey());
                }
            }
            return ArrayUtils.toPrimitive((Long[]) hashSet.toArray(new Long[hashSet.size()]));
        }

        public boolean isInspectionUploadedDuringTask() {
            return this.f4663b != null;
        }

        public LongSparseArray<Long> getInspectionItemServerIds() {
            return this.f4663b.itemIds;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public float mo8939a(boolean z) {
            float f;
            float f2;
            float size = (float) (this.f4665d.size() + 2);
            if ((this.f4663b == null || !this.f4663b.uploaded) && !m5788e().hasServerId()) {
                f = 0.0f;
            } else {
                f = BitmapDescriptorFactory.HUE_RED + 1.0f;
            }
            if (z || (this.f4664c != null && this.f4664c.uploaded)) {
                f += 1.0f;
            }
            Iterator<Boolean> it = this.f4665d.values().iterator();
            while (true) {
                f2 = f;
                if (!it.hasNext()) {
                    break;
                }
                Boolean next = it.next();
                if (next != null && next.booleanValue()) {
                    f2 += 1.0f;
                }
                f = f2;
            }
            return f2 == BitmapDescriptorFactory.HUE_RED ? BitmapDescriptorFactory.HUE_RED : f2 / size;
        }

        public float getVirtualProgress() {
            return mo8939a(false);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo8943b(boolean z) {
            return mo8939a(z) == 1.0f;
        }

        public boolean isFinished() {
            return mo8943b(false);
        }

        public boolean isSavingAllowed() {
            return this.savingAllowed;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public PicturesTable.PicturesCursor mo8941a() {
            return m5788e().getPicturesFromRoot();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo8942b() {
            return (this.f4663b != null && this.f4663b.uploaded) || m5788e().hasServerId();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public InspectionKey mo8944c() {
            return this.key;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public long mo8940a(PicturesTable.PicturesCursor picturesCursor) {
            return (this.f4663b == null || !this.f4663b.uploaded) ? Schema.getInspectionItems().getServerId(picturesCursor) : this.f4663b.mo8992a(picturesCursor);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public JsonElement mo8946d() {
            return m5788e().toJson();
        }

        public int getpictureCount() {
            return this.f4665d.size();
        }

        /* renamed from: e */
        private InspectionsTable.DataCursor m5788e() {
            if (this.f4662a == null || this.f4662a.isClosed()) {
                this.f4662a = this.key.get();
            }
            if (this.f4662a.moveToFirst()) {
                return this.f4662a;
            }
            throw new IllegalStateException();
        }
    }
}
