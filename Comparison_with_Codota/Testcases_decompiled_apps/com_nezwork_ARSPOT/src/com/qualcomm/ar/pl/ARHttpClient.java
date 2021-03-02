package com.qualcomm.ar.pl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;

public class ARHttpClient {
    private static final String MODULENAME = "ARHttpClient";
    ExecutorService executor;
    private Future<?> postDSNTimeoutTask = null;
    /* access modifiers changed from: private */
    public Future<HttpResponse> postTask = null;

    public native void nativeCallback(ARHttpResponse aRHttpResponse, long j);

    private class HttpResponseCallable implements Callable<HttpResponse> {
        private ARHttpParams arParams;
        private ARHttpPost arPost;

        public HttpResponseCallable(ARHttpPost arPost2, ARHttpParams arParams2) {
            this.arPost = arPost2;
            this.arParams = arParams2;
        }

        public HttpResponse call() throws Exception {
            if (this.arParams.delayedStart_ms != 0) {
                Thread.sleep((long) this.arParams.delayedStart_ms);
            }
            return new DefaultHttpClient(ARHttpParams.createHttpParams(this.arParams)).execute(ARHttpPost.createHttpPost(this.arPost));
        }
    }

    private class HttpResponseWatcher implements Runnable {
        private ARHttpParams arParams;
        private ARHttpPost arPost;

        public HttpResponseWatcher(ARHttpPost arPost2, ARHttpParams arParams2) {
            this.arParams = arParams2;
            this.arPost = arPost2;
        }

        public void run() {
            ARHttpResponse arResponse = null;
            try {
                arResponse = ARHttpResponse.createARResponse((HttpResponse) ARHttpClient.this.postTask.get((long) (this.arParams.delayedStart_ms + this.arParams.requestTimeout_ms), TimeUnit.MILLISECONDS));
                if (arResponse.statusCode != 200) {
                }
            } catch (Exception e) {
                if (ARHttpClient.this.postTask != null) {
                    if (!ARHttpClient.this.postTask.isCancelled()) {
                        ARHttpClient.this.postTask.cancel(true);
                    } else {
                        return;
                    }
                }
            }
            ARHttpClient.this.nativeCallback(arResponse, this.arPost.nativeRequestPtr);
        }
    }

    public boolean execute(ARHttpPost arPost, ARHttpParams arParams) {
        if (arPost == null) {
            return false;
        }
        try {
            this.executor = Executors.newFixedThreadPool(2);
            this.postTask = this.executor.submit(new HttpResponseCallable(arPost, arParams));
            this.postDSNTimeoutTask = this.executor.submit(new HttpResponseWatcher(arPost, arParams));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean cancel() {
        if (this.postTask == null) {
            return false;
        }
        this.postTask.cancel(true);
        return this.postTask.isDone();
    }
}
