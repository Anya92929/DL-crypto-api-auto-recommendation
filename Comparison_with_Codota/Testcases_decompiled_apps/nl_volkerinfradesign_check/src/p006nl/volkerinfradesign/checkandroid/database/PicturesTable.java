package p006nl.volkerinfradesign.checkandroid.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.location.Location;
import android.support.p001v4.util.LongSparseArray;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.LocationsTable;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ColumnEditor;
import p006nl.volkerinfradesign.checkandroid.tables.DbUtil;
import p006nl.volkerinfradesign.checkandroid.tables.Table;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursorFactory;
import p006nl.volkerinfradesign.checkandroid.util.UtilFiles;

/* renamed from: nl.volkerinfradesign.checkandroid.database.PicturesTable */
public class PicturesTable extends Table {
    public static final String FILE_PATH = "absolute_file_path";
    public static final String NAME = "picture_references";
    public static final String UPLOADED = "uploaded";
    public static final String UPLOAD_DATE = "upload_date";

    /* renamed from: a */
    private final File f4847a = AppState.getInstance().getPicturesDir();

    /* renamed from: nl.volkerinfradesign.checkandroid.database.PicturesTable$PicturesCursor */
    public interface PicturesCursor extends ViTaCursor {
        boolean delete();

        long getCreationDate();

        byte[] getFullSize();

        String getGuid();

        long getInspectionItemId();

        LocationsTable.LocationsCursor getLocation();

        byte[] getMediumSize();

        byte[] getThumb();

        boolean hasFull();

        boolean hasMedium();

        boolean hasThumb();

        boolean isUploaded();

        void setLocation(Location location);
    }

    public static boolean isFileValid(File file) {
        return file != null && file.exists() && !file.isDirectory() && file.length() > 0;
    }

    public PicturesTable(App app) {
        super(NAME);
        this.f4847a.mkdirs();
        putColumn(UPLOADED, Column.DataType.INTEGER).defaultValue((Number) 0);
        putColumn(FILE_PATH, Column.DataType.TEXT);
        putColumn("desc_url", Column.DataType.TEXT);
        putColumn("inspection_item_id", Column.DataType.INTEGER);
        putColumn("location_id", Column.DataType.INTEGER);
        putColumn(UPLOAD_DATE, Column.DataType.INTEGER).defaultValue(ColumnEditor.LiteralValue.CURRENT_TIMESTAMP);
        putColumn("creation_date", Column.DataType.INTEGER).notNull().defaultValue((Number) 0);
        putColumn("external", Column.DataType.INTEGER).notNull().defaultValue((Boolean) false);
        putColumn("root_inspection_id", Column.DataType.INTEGER);
        putColumn("thumb_picture", Column.DataType.BLOB);
        putColumn(InspectionConstants.GUID, Column.DataType.TEXT);
    }

    public PicturesCursor get(long[] jArr) {
        DbUtil.Argumenter argumenter = DbUtil.getArgumenter(jArr);
        return (PicturesCursor) query("_id in " + argumenter.getSelection(true), argumenter.getSelectionArgs(), new String[0]);
    }

    public PicturesCursor get(InspectionsTable.DataCursor dataCursor) {
        DbUtil.Argumenter argumenter = DbUtil.getArgumenter(dataCursor.getItemIds());
        return (PicturesCursor) query("inspection_item_id IN " + argumenter.getSelection(true), argumenter.getSelectionArgs(), new String[0]);
    }

    public PicturesCursor get(PictureKey pictureKey) {
        return (PicturesCursor) query("_id = ?", new String[]{Long.toString(pictureKey.f4846f)}, new String[0]);
    }

    public PictureKey get(C1225hy hyVar, File file) {
        PictureKey pictureKey;
        PicturesCursor picturesCursor = (PicturesCursor) query("absolute_file_path = ?", new String[]{file.getAbsolutePath()}, new String[0]);
        try {
            if (picturesCursor.moveToFirst()) {
                pictureKey = new PictureKey(hyVar, picturesCursor.getId(), file, false);
            } else {
                pictureKey = null;
            }
            return pictureKey;
        } finally {
            picturesCursor.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PicturesCursor mo9402a(InspectionsTable.DataCursor dataCursor) {
        return m5971a(dataCursor.getRootInspectionId());
    }

    /* access modifiers changed from: protected */
    public ViTaCursorFactory onCreateDefaultFactory() {
        return new ViTaCursorFactory() {
            public ViTaCursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return new C1471a(sQLiteCursorDriver, str, sQLiteQuery);
            }
        };
    }

    /* renamed from: a */
    public PictureKey[] mo9404a(InspectionItemConstants.ItemCursor itemCursor) {
        ViTaCursor query = query(new String[]{"_id", FILE_PATH, "external"}, "inspection_item_id = ?", new String[]{Long.toString(itemCursor.getId())}, (String) null, (String) null, "creation_date");
        PictureKey[] pictureKeyArr = new PictureKey[query.getCount()];
        int i = 0;
        while (query.moveToPosition(i)) {
            try {
                pictureKeyArr[i] = new PictureKey(itemCursor, query.getLong(0), (File) null, false);
                i++;
            } finally {
                query.close();
            }
        }
        return pictureKeyArr;
    }

    /* renamed from: b */
    public boolean mo9406b(InspectionItemConstants.ItemCursor itemCursor) {
        ViTaCursor query = query("inspection_item_id = ?", new String[]{Long.toString(itemCursor.getId())}, new String[0]);
        try {
            return query.moveToFirst();
        } finally {
            query.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo9407b(InspectionsTable.DataCursor dataCursor) {
        DbUtil.Argumenter argumenter = DbUtil.getArgumenter(dataCursor.getItemIds());
        ViTaCursor query = query(new String[]{"_id"}, "inspection_item_id IN " + argumenter.getSelection(true) + " AND (" + UPLOADED + " IS NULL OR " + UPLOADED + " = ?)", (String[]) ArrayUtils.add((T[]) argumenter.getSelectionArgs(), ""), (String) null, (String) null, (String) null, "1");
        try {
            return query.moveToFirst();
        } finally {
            query.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9403a(long[] jArr) {
        if (jArr == null || jArr.length == 0) {
            return false;
        }
        ContentValues contentValues = new ContentValues(1);
        DbUtil.Argumenter argumenter = DbUtil.getArgumenter(jArr);
        contentValues.put(UPLOADED, true);
        if (update(contentValues, "_id in " + argumenter.getSelection(true), argumenter.getSelectionArgs()) <= 0) {
            return false;
        }
        return true;
    }

    public PictureKey add(long j, long j2, long j3, Calendar calendar, Location location, File file) {
        ContentValues contentValues = new ContentValues(5);
        String uuid = UUID.randomUUID().toString();
        try {
            m5972a(file, uuid);
            contentValues.put(UPLOADED, false);
            contentValues.put("inspection_item_id", Long.valueOf(j));
            contentValues.put("creation_date", Long.valueOf(calendar.getTimeInMillis()));
            contentValues.put("root_inspection_id", Long.valueOf(j3));
            contentValues.put(InspectionConstants.GUID, uuid);
            if (location != null) {
                contentValues.put("location_id", Long.valueOf(Schema.m5982b().add(location)));
            }
            return new PictureKey(j, j2, j3, insertOrThrow(contentValues), (File) null, false);
        } catch (Exception e) {
            e.printStackTrace();
            AppState.getInstance().getModel().getLogger().logError("Could not generate picture.", e);
            return null;
        }
    }

    /* renamed from: a */
    private void m5972a(final File file, final String str) throws Exception {
        File file2 = new File(App.getInternalFilesDir() + "/inspectionItems", str + "Smaller.jpg");
        File file3 = new File(App.getInternalFilesDir() + "/inspectionItems", str + "_thumbEncrypted.jpg");
        UtilFiles.downSizeImage(file, file2, 256.0f, BitmapDescriptorFactory.HUE_RED);
        App.getAesEncrypter().encryptFile(file2, file3);
        file2.delete();
        new Thread() {
            public void run() {
                try {
                    File file = new File(App.getInternalFilesDir() + "/inspectionItems", str + "Smaller.jpg");
                    File file2 = new File(App.getInternalFilesDir() + "/inspectionItems", str + "Encrypted.jpg");
                    UtilFiles.downSizeImage(file, file, BitmapDescriptorFactory.HUE_RED, 5000000.0f);
                    App.getAesEncrypter().encryptFile(file, file2);
                    file.delete();
                    File file3 = new File(App.getInternalFilesDir() + "/inspectionItems", str + "Smaller.jpg");
                    File file4 = new File(App.getInternalFilesDir() + "/inspectionItems", str + "_mediumEncrypted.jpg");
                    UtilFiles.downSizeImage(file, file3, 2048.0f, BitmapDescriptorFactory.HUE_RED);
                    App.getAesEncrypter().encryptFile(file3, file4);
                    file3.delete();
                } catch (Exception e) {
                } finally {
                    file.delete();
                }
            }
        }.start();
    }

    /* renamed from: a */
    private PicturesCursor m5971a(long j) {
        return (PicturesCursor) query("root_inspection_id = ?", new String[]{Long.toString(j)}, new String[0]);
    }

    public PicturesCursor ensure(String str) {
        String[] strArr = {str};
        PicturesCursor picturesCursor = (PicturesCursor) query("desc_url = ?", strArr, new String[0]);
        if (picturesCursor.moveToFirst() && picturesCursor.hasThumb()) {
            return picturesCursor;
        }
        String uuid = UUID.randomUUID().toString();
        File file = new File(App.getInternalFilesDir() + "/inspectionItems", uuid + "temp.jpg");
        int i = 0;
        while (i < 3) {
            try {
                InputStream openStream = new URL(str).openStream();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                IOUtils.copy(openStream, (OutputStream) fileOutputStream);
                fileOutputStream.flush();
                openStream.close();
                fileOutputStream.close();
                if (file.exists()) {
                    break;
                }
                i++;
            } catch (Exception e) {
                AppState.getInstance().getModel().getLogger().logError("Could not download descriptive image", e);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e2) {
                }
            }
        }
        if (file.exists()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("desc_url", str);
            contentValues.put("creation_date", Long.valueOf(System.currentTimeMillis()));
            contentValues.put(InspectionConstants.GUID, uuid);
            insertOrThrow(contentValues);
            try {
                m5972a(file, uuid);
            } catch (Exception e3) {
                AppState.getInstance().getModel().getLogger().logError("Could not store picture.", e3);
            }
        }
        return (PicturesCursor) query("desc_url = ?", strArr, new String[0]);
    }

    public PictureKey getDescriptivePicture(InspectionItemConstants.ItemCursor itemCursor) {
        PictureKey pictureKey;
        PicturesCursor picturesCursor = (PicturesCursor) query("desc_url = ?", new String[]{itemCursor.getDescriptiveImageUrl()}, new String[0]);
        try {
            if (picturesCursor.moveToFirst()) {
                pictureKey = new PictureKey(itemCursor, picturesCursor.getId(), (File) null, false);
            } else {
                pictureKey = null;
            }
            return pictureKey;
        } finally {
            picturesCursor.close();
        }
    }

    public List<PictureKey> getPictureKeyFromRoot(InspectionKey inspectionKey) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {Long.toString(inspectionKey.f4799b)};
        ViTaCursor query = query("root_inspection_id = ?", strArr, "_id", "inspection_item_id");
        try {
            long j = inspectionKey.f4798a;
            long j2 = inspectionKey.f4799b;
            while (query.moveToNext()) {
                arrayList.add(new PictureKey(query.getLong("inspection_item_id"), j, j2, query.getLong("_id"), (File) null, false));
            }
            return arrayList;
        } finally {
            query.close();
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.PicturesTable$a */
    class C1471a extends ViTaCursor.Instance implements PicturesCursor {

        /* renamed from: b */
        private final LongSparseArray<File> f4853b = new LongSparseArray<>();

        public C1471a(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            super(sQLiteCursorDriver, str, sQLiteQuery);
        }

        public long getInspectionItemId() {
            return getLong("inspection_item_id");
        }

        public LocationsTable.LocationsCursor getLocation() {
            if (isNull("location_id")) {
                return null;
            }
            return Schema.m5982b().get(getLong("location_id"));
        }

        public void setLocation(Location location) {
            long j;
            if (isNull("location_id")) {
                ContentValues contentValues = new ContentValues(1);
                j = Schema.m5982b().add(location);
                contentValues.put("location_id", Long.valueOf(j));
                PicturesTable.this.update(contentValues, "_id= ?", getIdAsStringArray());
            } else {
                j = getLong("location_id");
                Schema.m5982b().update(j, location);
            }
            getWindow().putLong(j, getPosition(), getColumnIndex("location_id"));
        }

        public byte[] getThumb() {
            File file;
            FileInputStream fileInputStream;
            byte[] blob = !isNull("thumb_picture") ? getBlob("thumb_picture") : null;
            if (blob != null) {
                return blob;
            }
            try {
                File file2 = new File(App.getInternalFilesDir() + "/inspectionItems", getGuid() + "_thumbEncrypted.jpg");
                if (!file2.exists()) {
                    file = new File(App.getInternalFilesDir() + "/inspectionItems", getGuid() + "_thumb.jpg");
                } else {
                    file = file2;
                }
                if (!file.exists()) {
                    return getThumb();
                }
                fileInputStream = new FileInputStream(file);
                byte[] byteArray = IOUtils.toByteArray((InputStream) new FileInputStream(file));
                if (file.getName().endsWith("Encrypted.jpg")) {
                    try {
                        byte[] decrypt = App.getAesEncrypter().decrypt(byteArray);
                        fileInputStream.close();
                        return decrypt;
                    } catch (Exception e) {
                        fileInputStream.close();
                        return null;
                    }
                } else {
                    fileInputStream.close();
                    return byteArray;
                }
            } catch (Exception e2) {
                Log.e("Decrypt err", e2.getMessage());
                return null;
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        }

        public String getGuid() {
            if (!isNull(InspectionConstants.GUID)) {
                return getString(InspectionConstants.GUID);
            }
            return null;
        }

        public boolean hasThumb() {
            return !isNull("thumb_picture") || new File(new StringBuilder().append(App.getInternalFilesDir()).append("/inspectionItems").toString(), new StringBuilder().append(getGuid()).append("_thumb.jpg").toString()).exists() || new File(new StringBuilder().append(App.getInternalFilesDir()).append("/inspectionItems").toString(), new StringBuilder().append(getGuid()).append("_thumbEncrypted.jpg").toString()).exists();
        }

        public boolean hasMedium() {
            return !isNull("thumb_picture") || new File(new StringBuilder().append(App.getInternalFilesDir()).append("/inspectionItems").toString(), new StringBuilder().append(getGuid()).append("_medium.jpg").toString()).exists() || new File(new StringBuilder().append(App.getInternalFilesDir()).append("/inspectionItems").toString(), new StringBuilder().append(getGuid()).append("_mediumEncrypted.jpg").toString()).exists();
        }

        public boolean hasFull() {
            return !isNull("thumb_picture") || new File(new StringBuilder().append(App.getInternalFilesDir()).append("/inspectionItems").toString(), new StringBuilder().append(getGuid()).append(".jpg").toString()).exists() || new File(new StringBuilder().append(App.getInternalFilesDir()).append("/inspectionItems").toString(), new StringBuilder().append(getGuid()).append("Encrypted.jpg").toString()).exists();
        }

        public boolean isUploaded() {
            return !isNull(PicturesTable.UPLOADED) && getBoolean(PicturesTable.UPLOADED);
        }

        public long getCreationDate() {
            return getLong("creation_date");
        }

        public boolean delete() {
            return Schema.m5981a().f4866j.m5973a(this);
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public byte[] getMediumSize() {
            /*
                r4 = this;
                java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x009f }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
                r1.<init>()     // Catch:{ Exception -> 0x009f }
                java.io.File r2 = p006nl.volkerinfradesign.checkandroid.App.getInternalFilesDir()     // Catch:{ Exception -> 0x009f }
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x009f }
                java.lang.String r2 = "/inspectionItems"
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x009f }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x009f }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
                r2.<init>()     // Catch:{ Exception -> 0x009f }
                java.lang.String r3 = r4.getGuid()     // Catch:{ Exception -> 0x009f }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x009f }
                java.lang.String r3 = "_mediumEncrypted.jpg"
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x009f }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x009f }
                r0.<init>(r1, r2)     // Catch:{ Exception -> 0x009f }
                boolean r1 = r0.exists()     // Catch:{ Exception -> 0x009f }
                if (r1 != 0) goto L_0x00b3
                java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x009f }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
                r1.<init>()     // Catch:{ Exception -> 0x009f }
                java.io.File r2 = p006nl.volkerinfradesign.checkandroid.App.getInternalFilesDir()     // Catch:{ Exception -> 0x009f }
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x009f }
                java.lang.String r2 = "/inspectionItems"
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x009f }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x009f }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
                r2.<init>()     // Catch:{ Exception -> 0x009f }
                java.lang.String r3 = r4.getGuid()     // Catch:{ Exception -> 0x009f }
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x009f }
                java.lang.String r3 = "_medium.jpg"
                java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x009f }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x009f }
                r0.<init>(r1, r2)     // Catch:{ Exception -> 0x009f }
                r1 = r0
            L_0x006d:
                boolean r0 = r1.exists()     // Catch:{ Exception -> 0x009f }
                if (r0 == 0) goto L_0x00ae
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x009f }
                r2.<init>(r1)     // Catch:{ Exception -> 0x009f }
                java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ all -> 0x00a9 }
                r0.<init>(r1)     // Catch:{ all -> 0x00a9 }
                byte[] r0 = org.apache.commons.p009io.IOUtils.toByteArray((java.io.InputStream) r0)     // Catch:{ all -> 0x00a9 }
                java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x00a9 }
                java.lang.String r3 = "Encrypted.jpg"
                boolean r1 = r1.endsWith(r3)     // Catch:{ all -> 0x00a9 }
                if (r1 == 0) goto L_0x00a5
                nl.volkerinfradesign.checkandroid.util.AESEncrypter r1 = p006nl.volkerinfradesign.checkandroid.App.getAesEncrypter()     // Catch:{ Exception -> 0x0099 }
                byte[] r0 = r1.decrypt(r0)     // Catch:{ Exception -> 0x0099 }
                r2.close()     // Catch:{ Exception -> 0x009f }
            L_0x0098:
                return r0
            L_0x0099:
                r0 = move-exception
                r0 = 0
                r2.close()     // Catch:{ Exception -> 0x009f }
                goto L_0x0098
            L_0x009f:
                r0 = move-exception
                byte[] r0 = r4.getThumb()
                goto L_0x0098
            L_0x00a5:
                r2.close()     // Catch:{ Exception -> 0x009f }
                goto L_0x0098
            L_0x00a9:
                r0 = move-exception
                r2.close()     // Catch:{ Exception -> 0x009f }
                throw r0     // Catch:{ Exception -> 0x009f }
            L_0x00ae:
                byte[] r0 = r4.getThumb()     // Catch:{ Exception -> 0x009f }
                goto L_0x0098
            L_0x00b3:
                r1 = r0
                goto L_0x006d
            */
            throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.database.PicturesTable.C1471a.getMediumSize():byte[]");
        }

        public byte[] getFullSize() {
            File file;
            try {
                File file2 = new File(App.getInternalFilesDir() + "/inspectionItems", getGuid() + "Encrypted.jpg");
                if (!file2.exists()) {
                    file2 = new File(App.getInternalFilesDir() + "/inspectionItems", getGuid() + ".jpg");
                }
                if (!file2.exists()) {
                    file = new File(App.getInternalFilesDir() + "/inspectionItems", getGuid() + ".png");
                } else {
                    file = file2;
                }
                if (!file.exists()) {
                    return getMediumSize();
                }
                byte[] byteArray = IOUtils.toByteArray((InputStream) new FileInputStream(file));
                if (!file.getName().endsWith("Encrypted.jpg")) {
                    return byteArray;
                }
                try {
                    return App.getAesEncrypter().decrypt(byteArray);
                } catch (Exception e) {
                    return null;
                }
            } catch (IOException e2) {
                return getMediumSize();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m5973a(C1471a aVar) {
        return delete(aVar.getId());
    }

    public boolean delete(PictureKey pictureKey) {
        return delete(pictureKey.f4846f);
    }

    public boolean delete(long j) {
        return delete("_id=?", new String[]{Long.toString(j)}) > 0;
    }
}
