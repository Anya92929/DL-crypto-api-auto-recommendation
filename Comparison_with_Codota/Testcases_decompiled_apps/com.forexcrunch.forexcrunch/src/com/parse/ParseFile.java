package com.parse;

import android.webkit.MimeTypeMap;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.parse.Task;
import com.parse.entity.mime.HttpMultipartMode;
import com.parse.entity.mime.MIME;
import com.parse.entity.mime.content.ByteArrayBody;
import com.parse.entity.mime.content.StringBody;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseFile {
    /* access modifiers changed from: private */
    public Set<Task<?>.TaskCompletionSource> currentTasks = Collections.synchronizedSet(new HashSet());
    /* access modifiers changed from: private */
    public byte[] data;
    /* access modifiers changed from: private */
    public boolean dirty = false;
    private HttpPost fileUploadPost = null;
    private String name = null;
    final TaskQueue taskQueue = new TaskQueue();
    /* access modifiers changed from: private */
    public String url = null;

    public ParseFile(byte[] data2) {
        if (data2.length > Parse.maxParseFileSize) {
            throw new IllegalArgumentException(String.format("ParseFile must be less than %i bytes", new Object[]{Integer.valueOf(Parse.maxParseFileSize)}));
        }
        this.dirty = true;
        this.data = data2;
    }

    public ParseFile(String name2, byte[] data2) {
        if (data2.length > Parse.maxParseFileSize) {
            throw new IllegalArgumentException(String.format("ParseFile must be less than %i bytes", new Object[]{Integer.valueOf(Parse.maxParseFileSize)}));
        }
        this.name = name2;
        this.data = data2;
        this.dirty = true;
    }

    ParseFile(String name2, String url2) {
        this.name = name2;
        this.url = url2;
    }

    public String getName() {
        return this.name;
    }

    public boolean isDirty() {
        return this.dirty;
    }

    public boolean isDataAvailable() {
        return this.data != null;
    }

    public String getUrl() {
        return this.url;
    }

    /* access modifiers changed from: private */
    public ParseCommand constructFileUploadCommand(String sessionToken) {
        ParseCommand currentCommand = new ParseCommand("upload_file", sessionToken);
        currentCommand.enableRetrying();
        if (this.name != null) {
            currentCommand.put("name", this.name);
        }
        return currentCommand;
    }

    private void prepareFileUploadPost(JSONObject result, ProgressCallback progressCallback) {
        try {
            this.name = result.getString("name");
            this.url = result.getString("url");
            JSONObject postParams = result.getJSONObject("post_params");
            String mimeType = null;
            CountingMultipartEntity entity = new CountingMultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, progressCallback);
            if (this.name.lastIndexOf(".") != -1) {
                mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(this.name.substring(this.name.lastIndexOf(".") + 1));
            }
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            try {
                entity.addPart(MIME.CONTENT_TYPE, new StringBody(mimeType));
                Iterator<String> keys = postParams.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    try {
                        entity.addPart(key, new StringBody(postParams.getString(key)));
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e.getMessage());
                    } catch (JSONException e2) {
                        throw new RuntimeException(e2.getMessage());
                    }
                }
                entity.addPart(ImageDownloader.SCHEME_FILE, new ByteArrayBody(this.data, mimeType, ImageDownloader.SCHEME_FILE));
                try {
                    this.fileUploadPost = new HttpPost(result.getString("post_url"));
                    this.fileUploadPost.setEntity(entity);
                } catch (JSONException e3) {
                    throw new RuntimeException(e3.getMessage());
                }
            } catch (UnsupportedEncodingException e4) {
                throw new RuntimeException(e4.getMessage());
            }
        } catch (JSONException e5) {
            throw new RuntimeException(e5.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public Task<Void> handleFileUploadResultAsync(JSONObject result, ProgressCallback progressCallback) {
        if (this.fileUploadPost == null) {
            prepareFileUploadPost(result, progressCallback);
        }
        return new ParseRequestRetryer(this.fileUploadPost, 1000, 5).goAsync((ProgressCallback) null).makeVoid();
    }

    public void save() throws ParseException {
        save((ProgressCallback) null);
    }

    private void save(ProgressCallback progressCallback) throws ParseException {
        Parse.waitForTask(saveAsync(progressCallback));
    }

    /* access modifiers changed from: package-private */
    public Task<Void> saveAsync(final ProgressCallback progressCallback, Task<Void> toAwait) {
        if (!isDirty()) {
            return Task.forResult(null);
        }
        final Task<TResult>.TaskCompletionSource create = Task.create();
        this.currentTasks.add(create);
        toAwait.continueWith(new Continuation<Void, Void>() {
            public Void then(Task<Void> task) throws Exception {
                if (!ParseFile.this.isDirty()) {
                    create.trySetResult(null);
                } else {
                    final String sessionToken = ParseUser.getCurrentSessionToken();
                    final Task.TaskCompletionSource taskCompletionSource = create;
                    Task onSuccessTask = Task.call(new Callable<ParseCommand>() {
                        public ParseCommand call() throws Exception {
                            final ParseCommand command = ParseFile.this.constructFileUploadCommand(sessionToken);
                            taskCompletionSource.getTask().continueWith(new Continuation<Void, Void>() {
                                public Void then(Task<Void> task) throws Exception {
                                    if (!task.isCancelled()) {
                                        return null;
                                    }
                                    command.cancel();
                                    return null;
                                }
                            });
                            return command;
                        }
                    }).onSuccessTask(new Continuation<ParseCommand, Task<Object>>() {
                        public Task<Object> then(Task<ParseCommand> task) throws Exception {
                            return task.getResult().performAsync();
                        }
                    });
                    final ProgressCallback progressCallback = progressCallback;
                    Task continueWithTask = onSuccessTask.onSuccessTask(new Continuation<Object, Task<Void>>() {
                        public Task<Void> then(Task<Object> task) throws Exception {
                            return ParseFile.this.handleFileUploadResultAsync((JSONObject) task.getResult(), progressCallback);
                        }
                    }).continueWithTask(new Continuation<Void, Task<Void>>() {
                        public Task<Void> then(Task<Void> task) throws Exception {
                            if (!task.isFaulted()) {
                                ParseFile.this.dirty = false;
                            }
                            return task;
                        }
                    });
                    final Task.TaskCompletionSource taskCompletionSource2 = create;
                    continueWithTask.continueWith(new Continuation<Void, Void>() {
                        public Void then(Task<Void> task) throws Exception {
                            ParseFile.this.currentTasks.remove(taskCompletionSource2);
                            if (task.isCancelled()) {
                                taskCompletionSource2.trySetCancelled();
                                return null;
                            } else if (task.isFaulted()) {
                                taskCompletionSource2.trySetError(task.getError());
                                return null;
                            } else {
                                taskCompletionSource2.trySetResult(task.getResult());
                                return null;
                            }
                        }
                    });
                }
                return null;
            }
        });
        return create.getTask();
    }

    /* access modifiers changed from: package-private */
    public Task<Void> saveAsync(final ProgressCallback progressCallback) {
        return this.taskQueue.enqueue(new Continuation<Void, Task<Void>>() {
            public Task<Void> then(Task<Void> task) throws Exception {
                return ParseFile.this.saveAsync(progressCallback, task);
            }
        });
    }

    public synchronized void saveInBackground(SaveCallback saveCallback, ProgressCallback progressCallback) {
        Parse.callbackOnMainThreadAsync(saveAsync(progressCallback), saveCallback);
    }

    public void saveInBackground(SaveCallback callback) {
        saveInBackground(callback, (ProgressCallback) null);
    }

    public void saveInBackground() {
        saveInBackground((SaveCallback) null);
    }

    public byte[] getData() throws ParseException {
        return (byte[]) Parse.waitForTask(getDataAsync((ProgressCallback) null));
    }

    /* access modifiers changed from: private */
    public Task<byte[]> getDataAsync(final ProgressCallback progressCallback, Task<Void> toAwait) {
        if (isDataAvailable()) {
            return Task.forResult(this.data);
        }
        final Task<TResult>.TaskCompletionSource create = Task.create();
        this.currentTasks.add(create);
        toAwait.continueWith(new Continuation<Void, Void>() {
            public Void then(Task<Void> task) throws Exception {
                Task<byte[]> goAsync = new ParseRequestRetryer(new HttpGet(ParseFile.this.url), 1000, 5).goAsync(progressCallback);
                final Task.TaskCompletionSource taskCompletionSource = create;
                Task<TContinuationResult> continueWithTask = goAsync.continueWithTask(new Continuation<byte[], Task<byte[]>>() {
                    public Task<byte[]> then(Task<byte[]> task) throws Exception {
                        if (task.isFaulted() && (task.getError() instanceof IllegalStateException)) {
                            return Task.forError(new ParseException(100, task.getError().getMessage()));
                        }
                        if (taskCompletionSource.getTask().isCancelled()) {
                            return taskCompletionSource.getTask();
                        }
                        ParseFile.this.data = task.getResult();
                        return task;
                    }
                });
                final Task.TaskCompletionSource taskCompletionSource2 = create;
                continueWithTask.continueWith(new Continuation<byte[], Void>() {
                    public Void then(Task<byte[]> task) throws Exception {
                        ParseFile.this.currentTasks.remove(taskCompletionSource2);
                        if (task.isCancelled()) {
                            taskCompletionSource2.trySetCancelled();
                            return null;
                        } else if (task.isFaulted()) {
                            taskCompletionSource2.trySetError(task.getError());
                            return null;
                        } else {
                            taskCompletionSource2.trySetResult(task.getResult());
                            return null;
                        }
                    }
                });
                return null;
            }
        });
        return create.getTask();
    }

    /* access modifiers changed from: package-private */
    public Task<byte[]> getDataAsync(final ProgressCallback progressCallback) {
        return this.taskQueue.enqueue(new Continuation<Void, Task<byte[]>>() {
            public Task<byte[]> then(Task<Void> task) throws Exception {
                return ParseFile.this.getDataAsync(progressCallback, task);
            }
        });
    }

    public void getDataInBackground(GetDataCallback dataCallback, ProgressCallback progressCallback) {
        Parse.callbackOnMainThreadAsync(getDataAsync(progressCallback), dataCallback);
    }

    public void getDataInBackground(GetDataCallback dataCallback) {
        getDataInBackground(dataCallback, (ProgressCallback) null);
    }

    public void cancel() {
        Set<Task<?>.TaskCompletionSource> tasks = new HashSet<>(this.currentTasks);
        for (Task<?>.TaskCompletionSource tcs : tasks) {
            tcs.trySetCancelled();
        }
        this.currentTasks.removeAll(tasks);
    }
}
