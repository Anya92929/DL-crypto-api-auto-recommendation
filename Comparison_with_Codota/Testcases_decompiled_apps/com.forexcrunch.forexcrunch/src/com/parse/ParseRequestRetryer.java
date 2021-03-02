package com.parse;

import com.parse.Task;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

class ParseRequestRetryer {
    public static HttpClient testClient = null;
    /* access modifiers changed from: private */
    public int attemptsMade = 0;
    /* access modifiers changed from: private */
    public HttpClient client;
    /* access modifiers changed from: private */
    public long delay;
    /* access modifiers changed from: private */
    public int maxAttempts;
    /* access modifiers changed from: private */
    public HttpUriRequest request;

    public ParseRequestRetryer(HttpUriRequest newRequest, long initialDelay, int newMaxAttempts) {
        if (testClient != null) {
            this.client = testClient;
            initialDelay = 1;
        } else {
            this.client = new DefaultHttpClient();
            this.client.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        }
        this.request = newRequest;
        this.maxAttempts = newMaxAttempts;
        this.delay = ((long) (((double) initialDelay) * Math.random())) + initialDelay;
    }

    private Task<byte[]> sendOneRequestAsync(final ProgressCallback progressCallback) {
        return Task.call(new Callable<byte[]>() {
            public byte[] call() throws Exception {
                try {
                    HttpResponse response = ParseRequestRetryer.this.client.execute(ParseRequestRetryer.this.request);
                    if (ParseRequestRetryer.this.request.getMethod().equals("GET")) {
                        int totalSize = -1;
                        Header[] contentLengthHeader = response.getHeaders("Content-Length");
                        if (contentLengthHeader.length > 0) {
                            totalSize = Integer.parseInt(contentLengthHeader[0].getValue());
                        }
                        int downloadedSize = 0;
                        InputStream responseStream = response.getEntity().getContent();
                        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                        byte[] data = new byte[32768];
                        while (true) {
                            int nRead = responseStream.read(data, 0, data.length);
                            if (nRead == -1) {
                                buffer.flush();
                                return buffer.toByteArray();
                            }
                            buffer.write(data, 0, nRead);
                            downloadedSize += nRead;
                            if (!(progressCallback == null || totalSize == -1)) {
                                Parse.callbackOnMainThreadAsync(Task.forResult(Integer.valueOf(Math.round((((float) downloadedSize) / ((float) totalSize)) * 100.0f))), progressCallback);
                            }
                        }
                    } else if (response.getStatusLine().getStatusCode() / 100 == 2) {
                        return null;
                    } else {
                        throw new ParseException(100, String.format("Upload to S3 failed. %s", new Object[]{response.getStatusLine().getReasonPhrase()}));
                    }
                } catch (ClientProtocolException e) {
                    ParseRequestRetryer.this.client.getConnectionManager().shutdown();
                    throw ParseRequestRetryer.this.connectionFailed("bad protocol", e);
                } catch (IOException e2) {
                    ParseRequestRetryer.this.client.getConnectionManager().shutdown();
                    throw ParseRequestRetryer.this.connectionFailed("i/o failure", e2);
                }
            }
        }, ParseCommand.networkThreadPool);
    }

    public Task<byte[]> goAsync(final ProgressCallback progressCallback) {
        return sendOneRequestAsync(progressCallback).continueWithTask(new Continuation<byte[], Task<byte[]>>() {
            public Task<byte[]> then(Task<byte[]> task) throws Exception {
                if (!task.isFaulted() || !(task.getError() instanceof ParseException)) {
                    return task;
                }
                ParseRequestRetryer parseRequestRetryer = ParseRequestRetryer.this;
                parseRequestRetryer.attemptsMade = parseRequestRetryer.attemptsMade + 1;
                if (ParseRequestRetryer.this.attemptsMade < ParseRequestRetryer.this.maxAttempts) {
                    Parse.logI("com.parse.ParseRequestRetryer", "Request failed. Waiting " + ParseRequestRetryer.this.delay + " milliseconds before attempt #" + (ParseRequestRetryer.this.attemptsMade + 1));
                    final Task<TResult>.TaskCompletionSource create = Task.create();
                    ScheduledExecutorService scheduledExecutorService = ParseCommand.networkThreadPool;
                    final ProgressCallback progressCallback = progressCallback;
                    scheduledExecutorService.schedule(new Runnable() {
                        public void run() {
                            ParseRequestRetryer access$1 = ParseRequestRetryer.this;
                            access$1.delay = access$1.delay * 2;
                            Task<byte[]> goAsync = ParseRequestRetryer.this.goAsync(progressCallback);
                            final Task.TaskCompletionSource taskCompletionSource = create;
                            goAsync.continueWithTask(new Continuation<byte[], Task<Void>>() {
                                public Task<Void> then(Task<byte[]> task) throws Exception {
                                    if (task.isCancelled()) {
                                        taskCompletionSource.setCancelled();
                                        return null;
                                    } else if (task.isFaulted()) {
                                        taskCompletionSource.setError(task.getError());
                                        return null;
                                    } else {
                                        taskCompletionSource.setResult(task.getResult());
                                        return null;
                                    }
                                }
                            });
                        }
                    }, ParseRequestRetryer.this.delay, TimeUnit.MILLISECONDS);
                    return create.getTask();
                } else if (ParseRequestRetryer.this.request.isAborted()) {
                    return task;
                } else {
                    Parse.logI("com.parse.ParseRequestRetryer", "Request failed. Giving up.");
                    return task;
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public ParseException connectionFailed(String message, Exception e) {
        return new ParseException(100, String.valueOf(message) + ": " + e.getClass().getName() + ": " + e.getMessage());
    }
}
