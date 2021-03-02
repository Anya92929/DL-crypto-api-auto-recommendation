package org.apache.cordova;

import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.google.android.gms.location.LocationStatusCodes;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.channels.FileChannel;
import org.apache.commons.codec.binary.Base64;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.file.EncodingException;
import org.apache.cordova.file.FileExistsException;
import org.apache.cordova.file.InvalidModificationException;
import org.apache.cordova.file.NoModificationAllowedException;
import org.apache.cordova.file.TypeMismatchException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FileUtils extends CordovaPlugin {
    public static int ABORT_ERR = 3;
    public static int APPLICATION = 3;
    public static int ENCODING_ERR = 5;
    public static int INVALID_MODIFICATION_ERR = 9;
    public static int INVALID_STATE_ERR = 7;
    private static final String LOG_TAG = "FileUtils";
    public static int NOT_FOUND_ERR = 1;
    public static int NOT_READABLE_ERR = 4;
    public static int NO_MODIFICATION_ALLOWED_ERR = 6;
    public static int PATH_EXISTS_ERR = 12;
    public static int PERSISTENT = 1;
    public static int QUOTA_EXCEEDED_ERR = 10;
    public static int RESOURCE = 2;
    public static int SECURITY_ERR = 2;
    public static int SYNTAX_ERR = 8;
    public static int TEMPORARY = 0;
    public static int TYPE_MISMATCH_ERR = 11;
    private static final String _DATA = "_data";
    FileReader f_in;
    FileWriter f_out;

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (action.equals("testSaveLocationExists")) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, DirectoryManager.testSaveLocationExists()));
            } else if (action.equals("getFreeDiskSpace")) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (float) DirectoryManager.getFreeDiskSpace(false)));
            } else if (action.equals("testFileExists")) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, DirectoryManager.testFileExists(args.getString(0))));
            } else if (action.equals("testDirectoryExists")) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, DirectoryManager.testFileExists(args.getString(0))));
            } else if (action.equals("readAsText")) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, readAsText(args.getString(0), args.getString(1))));
            } else if (action.equals("readAsDataURL")) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, readAsDataURL(args.getString(0))));
            } else if (action.equals("write")) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (float) write(args.getString(0), args.getString(1), args.getInt(2))));
            } else if (action.equals("truncate")) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (float) truncateFile(args.getString(0), args.getLong(1))));
            } else if (action.equals("requestFileSystem")) {
                long size = args.optLong(1);
                if (size == 0 || size <= DirectoryManager.getFreeDiskSpace(true) * 1024) {
                    callbackContext.success(requestFileSystem(args.getInt(0)));
                } else {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, QUOTA_EXCEEDED_ERR));
                }
            } else if (action.equals("resolveLocalFileSystemURI")) {
                callbackContext.success(resolveLocalFileSystemURI(args.getString(0)));
            } else if (action.equals("getMetadata")) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (float) getMetadata(args.getString(0))));
            } else if (action.equals("getFileMetadata")) {
                callbackContext.success(getFileMetadata(args.getString(0)));
            } else if (action.equals("getParent")) {
                callbackContext.success(getParent(args.getString(0)));
            } else if (action.equals("getDirectory")) {
                callbackContext.success(getFile(args.getString(0), args.getString(1), args.optJSONObject(2), true));
            } else if (action.equals("getFile")) {
                callbackContext.success(getFile(args.getString(0), args.getString(1), args.optJSONObject(2), false));
            } else if (action.equals("remove")) {
                if (remove(args.getString(0))) {
                    notifyDelete(args.getString(0));
                    callbackContext.success();
                } else {
                    callbackContext.error(NO_MODIFICATION_ALLOWED_ERR);
                }
            } else if (action.equals("removeRecursively")) {
                if (removeRecursively(args.getString(0))) {
                    callbackContext.success();
                } else {
                    callbackContext.error(NO_MODIFICATION_ALLOWED_ERR);
                }
            } else if (action.equals("moveTo")) {
                callbackContext.success(transferTo(args.getString(0), args.getString(1), args.getString(2), true));
            } else if (action.equals("copyTo")) {
                callbackContext.success(transferTo(args.getString(0), args.getString(1), args.getString(2), false));
            } else if (!action.equals("readEntries")) {
                return false;
            } else {
                callbackContext.success(readEntries(args.getString(0)));
            }
        } catch (FileNotFoundException e) {
            callbackContext.error(NOT_FOUND_ERR);
        } catch (FileExistsException e2) {
            callbackContext.error(PATH_EXISTS_ERR);
        } catch (NoModificationAllowedException e3) {
            callbackContext.error(NO_MODIFICATION_ALLOWED_ERR);
        } catch (InvalidModificationException e4) {
            callbackContext.error(INVALID_MODIFICATION_ERR);
        } catch (MalformedURLException e5) {
            callbackContext.error(ENCODING_ERR);
        } catch (IOException e6) {
            callbackContext.error(INVALID_MODIFICATION_ERR);
        } catch (EncodingException e7) {
            callbackContext.error(ENCODING_ERR);
        } catch (TypeMismatchException e8) {
            callbackContext.error(TYPE_MISMATCH_ERR);
        }
        return true;
    }

    private void notifyDelete(String filePath) {
        String newFilePath = stripFileProtocol(filePath);
        this.cordova.getActivity().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data = ?", new String[]{newFilePath});
    }

    private JSONObject resolveLocalFileSystemURI(String url) throws IOException, JSONException {
        File fp;
        String decoded = URLDecoder.decode(url, "UTF-8");
        if (decoded.startsWith("content:")) {
            Cursor cursor = this.cordova.getActivity().managedQuery(Uri.parse(decoded), new String[]{_DATA}, (String) null, (String[]) null, (String) null);
            int column_index = cursor.getColumnIndexOrThrow(_DATA);
            cursor.moveToFirst();
            fp = new File(cursor.getString(column_index));
        } else {
            new URL(decoded);
            if (decoded.startsWith("file://")) {
                int questionMark = decoded.indexOf("?");
                if (questionMark < 0) {
                    fp = new File(decoded.substring(7, decoded.length()));
                } else {
                    fp = new File(decoded.substring(7, questionMark));
                }
            } else {
                fp = new File(decoded);
            }
        }
        if (!fp.exists()) {
            throw new FileNotFoundException();
        } else if (fp.canRead()) {
            return getEntry(fp);
        } else {
            throw new IOException();
        }
    }

    private JSONArray readEntries(String fileName) throws FileNotFoundException, JSONException {
        File fp = createFileObject(fileName);
        if (!fp.exists()) {
            throw new FileNotFoundException();
        }
        JSONArray entries = new JSONArray();
        if (fp.isDirectory()) {
            File[] files = fp.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].canRead()) {
                    entries.put(getEntry(files[i]));
                }
            }
        }
        return entries;
    }

    private JSONObject transferTo(String fileName, String newParent, String newName, boolean move) throws JSONException, NoModificationAllowedException, IOException, InvalidModificationException, EncodingException {
        String fileName2 = stripFileProtocol(fileName);
        String newParent2 = stripFileProtocol(newParent);
        if (newName == null || !newName.contains(":")) {
            File source = new File(fileName2);
            if (!source.exists()) {
                throw new FileNotFoundException("The source does not exist");
            }
            File destinationDir = new File(newParent2);
            if (!destinationDir.exists()) {
                throw new FileNotFoundException("The source does not exist");
            }
            File destination = createDestination(newName, source, destinationDir);
            if (source.getAbsolutePath().equals(destination.getAbsolutePath())) {
                throw new InvalidModificationException("Can't copy a file onto itself");
            } else if (source.isDirectory()) {
                if (move) {
                    return moveDirectory(source, destination);
                }
                return copyDirectory(source, destination);
            } else if (move) {
                return moveFile(source, destination);
            } else {
                return copyFile(source, destination);
            }
        } else {
            throw new EncodingException("Bad file name");
        }
    }

    private File createDestination(String newName, File fp, File destination) {
        if ("null".equals(newName) || "".equals(newName)) {
            newName = null;
        }
        if (newName != null) {
            return new File(destination.getAbsolutePath() + File.separator + newName);
        }
        return new File(destination.getAbsolutePath() + File.separator + fp.getName());
    }

    /* JADX INFO: finally extract failed */
    private JSONObject copyFile(File srcFile, File destFile) throws IOException, InvalidModificationException, JSONException {
        if (!destFile.exists() || !destFile.isDirectory()) {
            FileInputStream istream = new FileInputStream(srcFile);
            FileOutputStream ostream = new FileOutputStream(destFile);
            FileChannel input = istream.getChannel();
            FileChannel output = ostream.getChannel();
            try {
                input.transferTo(0, input.size(), output);
                istream.close();
                ostream.close();
                input.close();
                output.close();
                return getEntry(destFile);
            } catch (Throwable th) {
                istream.close();
                ostream.close();
                input.close();
                output.close();
                throw th;
            }
        } else {
            throw new InvalidModificationException("Can't rename a file to a directory");
        }
    }

    private JSONObject copyDirectory(File srcDir, File destinationDir) throws JSONException, IOException, NoModificationAllowedException, InvalidModificationException {
        if (destinationDir.exists() && destinationDir.isFile()) {
            throw new InvalidModificationException("Can't rename a file to a directory");
        } else if (isCopyOnItself(srcDir.getAbsolutePath(), destinationDir.getAbsolutePath())) {
            throw new InvalidModificationException("Can't copy itself into itself");
        } else if (destinationDir.exists() || destinationDir.mkdir()) {
            for (File file : srcDir.listFiles()) {
                if (file.isDirectory()) {
                    copyDirectory(file, destinationDir);
                } else {
                    copyFile(file, new File(destinationDir.getAbsoluteFile() + File.separator + file.getName()));
                }
            }
            return getEntry(destinationDir);
        } else {
            throw new NoModificationAllowedException("Couldn't create the destination direcotry");
        }
    }

    private boolean isCopyOnItself(String src, String dest) {
        if (!dest.startsWith(src) || dest.indexOf(File.separator, src.length() - 1) == -1) {
            return false;
        }
        return true;
    }

    private JSONObject moveFile(File srcFile, File destFile) throws JSONException, InvalidModificationException {
        if (!destFile.exists() || !destFile.isDirectory()) {
            if (!srcFile.renameTo(destFile)) {
            }
            return getEntry(destFile);
        }
        throw new InvalidModificationException("Can't rename a file to a directory");
    }

    private JSONObject moveDirectory(File srcDir, File destinationDir) throws JSONException, InvalidModificationException {
        if (destinationDir.exists() && destinationDir.isFile()) {
            throw new InvalidModificationException("Can't rename a file to a directory");
        } else if (isCopyOnItself(srcDir.getAbsolutePath(), destinationDir.getAbsolutePath())) {
            throw new InvalidModificationException("Can't move itself into itself");
        } else if (!destinationDir.exists() || destinationDir.list().length <= 0) {
            if (!srcDir.renameTo(destinationDir)) {
            }
            return getEntry(destinationDir);
        } else {
            throw new InvalidModificationException("directory is not empty");
        }
    }

    private boolean removeRecursively(String filePath) throws FileExistsException {
        File fp = createFileObject(filePath);
        if (atRootDirectory(filePath)) {
            return false;
        }
        return removeDirRecursively(fp);
    }

    private boolean removeDirRecursively(File directory) throws FileExistsException {
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                removeDirRecursively(file);
            }
        }
        if (directory.delete()) {
            return true;
        }
        throw new FileExistsException("could not delete: " + directory.getName());
    }

    private boolean remove(String filePath) throws NoModificationAllowedException, InvalidModificationException {
        File fp = createFileObject(filePath);
        if (atRootDirectory(filePath)) {
            throw new NoModificationAllowedException("You can't delete the root directory");
        } else if (!fp.isDirectory() || fp.list().length <= 0) {
            return fp.delete();
        } else {
            throw new InvalidModificationException("You can't delete a directory that is not empty.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r8.optBoolean("create");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject getFile(java.lang.String r6, java.lang.String r7, org.json.JSONObject r8, boolean r9) throws org.apache.cordova.file.FileExistsException, java.io.IOException, org.apache.cordova.file.TypeMismatchException, org.apache.cordova.file.EncodingException, org.json.JSONException {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            if (r8 == 0) goto L_0x0012
            java.lang.String r3 = "create"
            boolean r0 = r8.optBoolean(r3)
            if (r0 == 0) goto L_0x0012
            java.lang.String r3 = "exclusive"
            boolean r1 = r8.optBoolean(r3)
        L_0x0012:
            java.lang.String r3 = ":"
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L_0x0022
            org.apache.cordova.file.EncodingException r3 = new org.apache.cordova.file.EncodingException
            java.lang.String r4 = "This file has a : in it's name"
            r3.<init>(r4)
            throw r3
        L_0x0022:
            java.io.File r2 = r5.createFileObject(r6, r7)
            if (r0 == 0) goto L_0x004f
            if (r1 == 0) goto L_0x0038
            boolean r3 = r2.exists()
            if (r3 == 0) goto L_0x0038
            org.apache.cordova.file.FileExistsException r3 = new org.apache.cordova.file.FileExistsException
            java.lang.String r4 = "create/exclusive fails"
            r3.<init>(r4)
            throw r3
        L_0x0038:
            if (r9 == 0) goto L_0x004b
            r2.mkdir()
        L_0x003d:
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x007b
            org.apache.cordova.file.FileExistsException r3 = new org.apache.cordova.file.FileExistsException
            java.lang.String r4 = "create fails"
            r3.<init>(r4)
            throw r3
        L_0x004b:
            r2.createNewFile()
            goto L_0x003d
        L_0x004f:
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x005d
            java.io.FileNotFoundException r3 = new java.io.FileNotFoundException
            java.lang.String r4 = "path does not exist"
            r3.<init>(r4)
            throw r3
        L_0x005d:
            if (r9 == 0) goto L_0x006d
            boolean r3 = r2.isFile()
            if (r3 == 0) goto L_0x007b
            org.apache.cordova.file.TypeMismatchException r3 = new org.apache.cordova.file.TypeMismatchException
            java.lang.String r4 = "path doesn't exist or is file"
            r3.<init>(r4)
            throw r3
        L_0x006d:
            boolean r3 = r2.isDirectory()
            if (r3 == 0) goto L_0x007b
            org.apache.cordova.file.TypeMismatchException r3 = new org.apache.cordova.file.TypeMismatchException
            java.lang.String r4 = "path doesn't exist or is directory"
            r3.<init>(r4)
            throw r3
        L_0x007b:
            org.json.JSONObject r3 = r5.getEntry((java.io.File) r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.cordova.FileUtils.getFile(java.lang.String, java.lang.String, org.json.JSONObject, boolean):org.json.JSONObject");
    }

    private File createFileObject(String dirPath, String fileName) {
        if (fileName.startsWith("/")) {
            return new File(fileName);
        }
        return new File(stripFileProtocol(dirPath) + File.separator + fileName);
    }

    private JSONObject getParent(String filePath) throws JSONException {
        String filePath2 = stripFileProtocol(filePath);
        if (atRootDirectory(filePath2)) {
            return getEntry(filePath2);
        }
        return getEntry(new File(filePath2).getParent());
    }

    private boolean atRootDirectory(String filePath) {
        String filePath2 = stripFileProtocol(filePath);
        if (filePath2.equals(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + this.cordova.getActivity().getPackageName() + "/cache") || filePath2.equals(Environment.getExternalStorageDirectory().getAbsolutePath()) || filePath2.equals("/data/data/" + this.cordova.getActivity().getPackageName())) {
            return true;
        }
        return false;
    }

    public static String stripFileProtocol(String filePath) {
        if (filePath.startsWith("file://")) {
            return filePath.substring(7);
        }
        return filePath;
    }

    private File createFileObject(String filePath) {
        return new File(stripFileProtocol(filePath));
    }

    private long getMetadata(String filePath) throws FileNotFoundException {
        File file = createFileObject(filePath);
        if (file.exists()) {
            return file.lastModified();
        }
        throw new FileNotFoundException("Failed to find file in getMetadata");
    }

    private JSONObject getFileMetadata(String filePath) throws FileNotFoundException, JSONException {
        File file = createFileObject(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File: " + filePath + " does not exist.");
        }
        JSONObject metadata = new JSONObject();
        metadata.put("size", file.length());
        metadata.put(Globalization.TYPE, getMimeType(filePath));
        metadata.put(DBFavorites.KEY_NAME, file.getName());
        metadata.put("fullPath", file.getAbsolutePath());
        metadata.put("lastModifiedDate", file.lastModified());
        return metadata;
    }

    private JSONObject requestFileSystem(int type) throws IOException, JSONException {
        JSONObject fs = new JSONObject();
        if (type == TEMPORARY) {
            fs.put(DBFavorites.KEY_NAME, "temporary");
            if (Environment.getExternalStorageState().equals("mounted")) {
                new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + this.cordova.getActivity().getPackageName() + "/cache/").mkdirs();
                fs.put("root", getEntry(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + this.cordova.getActivity().getPackageName() + "/cache/"));
            } else {
                new File("/data/data/" + this.cordova.getActivity().getPackageName() + "/cache/").mkdirs();
                fs.put("root", getEntry("/data/data/" + this.cordova.getActivity().getPackageName() + "/cache/"));
            }
        } else if (type == PERSISTENT) {
            fs.put(DBFavorites.KEY_NAME, "persistent");
            if (Environment.getExternalStorageState().equals("mounted")) {
                fs.put("root", getEntry(Environment.getExternalStorageDirectory()));
            } else {
                fs.put("root", getEntry("/data/data/" + this.cordova.getActivity().getPackageName()));
            }
        } else {
            throw new IOException("No filesystem of type requested");
        }
        return fs;
    }

    public JSONObject getEntry(File file) throws JSONException {
        JSONObject entry = new JSONObject();
        entry.put("isFile", file.isFile());
        entry.put("isDirectory", file.isDirectory());
        entry.put(DBFavorites.KEY_NAME, file.getName());
        entry.put("fullPath", "file://" + file.getAbsolutePath());
        return entry;
    }

    private JSONObject getEntry(String path) throws JSONException {
        return getEntry(new File(path));
    }

    public boolean isSynch(String action) {
        if (!action.equals("testSaveLocationExists") && !action.equals("getFreeDiskSpace") && !action.equals("testFileExists") && !action.equals("testDirectoryExists")) {
            return false;
        }
        return true;
    }

    public String readAsText(String filename, String encoding) throws FileNotFoundException, IOException {
        byte[] bytes = new byte[LocationStatusCodes.GEOFENCE_NOT_AVAILABLE];
        BufferedInputStream bis = new BufferedInputStream(getPathFromUri(filename), 1024);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while (true) {
            int numRead = bis.read(bytes, 0, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE);
            if (numRead < 0) {
                return new String(bos.toByteArray(), encoding);
            }
            bos.write(bytes, 0, numRead);
        }
    }

    public String readAsDataURL(String filename) throws FileNotFoundException, IOException {
        String contentType;
        byte[] bytes = new byte[LocationStatusCodes.GEOFENCE_NOT_AVAILABLE];
        BufferedInputStream bis = new BufferedInputStream(getPathFromUri(filename), 1024);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while (true) {
            int numRead = bis.read(bytes, 0, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE);
            if (numRead < 0) {
                break;
            }
            bos.write(bytes, 0, numRead);
        }
        if (filename.startsWith("content:")) {
            contentType = this.cordova.getActivity().getContentResolver().getType(Uri.parse(filename));
        } else {
            contentType = getMimeType(filename);
        }
        return "data:" + contentType + ";base64," + new String(Base64.encodeBase64(bos.toByteArray()));
    }

    public static String getMimeType(String filename) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(filename));
    }

    public long write(String filename, String data, int offset) throws FileNotFoundException, IOException {
        String filename2 = stripFileProtocol(filename);
        boolean append = false;
        if (offset > 0) {
            truncateFile(filename2, (long) offset);
            append = true;
        }
        byte[] rawData = data.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(rawData);
        FileOutputStream out = new FileOutputStream(filename2, append);
        byte[] buff = new byte[rawData.length];
        in.read(buff, 0, buff.length);
        out.write(buff, 0, rawData.length);
        out.flush();
        out.close();
        return (long) rawData.length;
    }

    private long truncateFile(String filename, long size) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(stripFileProtocol(filename), "rw");
        try {
            if (raf.length() >= size) {
                raf.getChannel().truncate(size);
            } else {
                size = raf.length();
                raf.close();
            }
            return size;
        } finally {
            raf.close();
        }
    }

    private InputStream getPathFromUri(String path) throws FileNotFoundException {
        if (!path.startsWith("content")) {
            return new FileInputStream(stripFileProtocol(path));
        }
        return this.cordova.getActivity().getContentResolver().openInputStream(Uri.parse(path));
    }

    protected static String getRealPathFromURI(Uri contentUri, CordovaInterface cordova) {
        String uri = contentUri.toString();
        if (!uri.startsWith("content:")) {
            return uri;
        }
        Cursor cursor = cordova.getActivity().managedQuery(contentUri, new String[]{_DATA}, (String) null, (String[]) null, (String) null);
        int column_index = cursor.getColumnIndexOrThrow(_DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}
