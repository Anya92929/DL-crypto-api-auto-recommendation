package com.squareup.okhttp;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RetryableSink;
import com.squareup.okhttp.internal.http.RouteSelector;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import okio.Sink;

public class Call {
    volatile boolean canceled;
    /* access modifiers changed from: private */
    public final OkHttpClient client;
    HttpEngine engine;
    private boolean executed;
    Request originalRequest;

    protected Call(OkHttpClient client2, Request originalRequest2) {
        this.client = client2.copyWithDefaults();
        this.originalRequest = originalRequest2;
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        try {
            this.client.getDispatcher().executed(this);
            Response result = getResponseWithInterceptorChain(false);
            if (result != null) {
                return result;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.getDispatcher().finished(this);
        }
    }

    /* access modifiers changed from: package-private */
    public Object tag() {
        return this.originalRequest.tag();
    }

    public void enqueue(Callback responseCallback) {
        enqueue(responseCallback, false);
    }

    /* access modifiers changed from: package-private */
    public void enqueue(Callback responseCallback, boolean forWebSocket) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.client.getDispatcher().enqueue(new AsyncCall(responseCallback, forWebSocket));
    }

    public void cancel() {
        this.canceled = true;
        if (this.engine != null) {
            this.engine.disconnect();
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    final class AsyncCall extends NamedRunnable {
        private final boolean forWebSocket;
        private final Callback responseCallback;

        private AsyncCall(Callback responseCallback2, boolean forWebSocket2) {
            super("OkHttp %s", Call.this.originalRequest.urlString());
            this.responseCallback = responseCallback2;
            this.forWebSocket = forWebSocket2;
        }

        /* access modifiers changed from: package-private */
        public String host() {
            return Call.this.originalRequest.url().getHost();
        }

        /* access modifiers changed from: package-private */
        public Request request() {
            return Call.this.originalRequest;
        }

        /* access modifiers changed from: package-private */
        public Object tag() {
            return Call.this.originalRequest.tag();
        }

        /* access modifiers changed from: package-private */
        public void cancel() {
            Call.this.cancel();
        }

        /* access modifiers changed from: package-private */
        public Call get() {
            return Call.this;
        }

        /* access modifiers changed from: protected */
        public void execute() {
            boolean signalledCallback = false;
            try {
                Response response = Call.this.getResponseWithInterceptorChain(this.forWebSocket);
                if (Call.this.canceled) {
                    this.responseCallback.onFailure(Call.this.originalRequest, new IOException("Canceled"));
                } else {
                    signalledCallback = true;
                    this.responseCallback.onResponse(response);
                }
            } catch (IOException e) {
                if (signalledCallback) {
                    Internal.logger.log(Level.INFO, "Callback failure for " + Call.this.toLoggableString(), e);
                } else {
                    this.responseCallback.onFailure(Call.this.engine.getRequest(), e);
                }
            } finally {
                Call.this.client.getDispatcher().finished(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public String toLoggableString() {
        String string = this.canceled ? "canceled call" : "call";
        try {
            return string + " to " + new URL(this.originalRequest.url(), "/...").toString();
        } catch (MalformedURLException e) {
            return string;
        }
    }

    /* access modifiers changed from: private */
    public Response getResponseWithInterceptorChain(boolean forWebSocket) throws IOException {
        return new ApplicationInterceptorChain(0, this.originalRequest, forWebSocket).proceed(this.originalRequest);
    }

    class ApplicationInterceptorChain implements Interceptor.Chain {
        private final boolean forWebSocket;
        private final int index;
        private final Request request;

        ApplicationInterceptorChain(int index2, Request request2, boolean forWebSocket2) {
            this.index = index2;
            this.request = request2;
            this.forWebSocket = forWebSocket2;
        }

        public Connection connection() {
            return null;
        }

        public Request request() {
            return this.request;
        }

        public Response proceed(Request request2) throws IOException {
            if (this.index >= Call.this.client.interceptors().size()) {
                return Call.this.getResponse(request2, this.forWebSocket);
            }
            return Call.this.client.interceptors().get(this.index).intercept(new ApplicationInterceptorChain(this.index + 1, request2, this.forWebSocket));
        }
    }

    /* access modifiers changed from: package-private */
    public Response getResponse(Request request, boolean forWebSocket) throws IOException {
        RequestBody body = request.body();
        if (body != null) {
            Request.Builder requestBuilder = request.newBuilder();
            MediaType contentType = body.contentType();
            if (contentType != null) {
                requestBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                requestBuilder.header("Content-Length", Long.toString(contentLength));
                requestBuilder.removeHeader("Transfer-Encoding");
            } else {
                requestBuilder.header("Transfer-Encoding", "chunked");
                requestBuilder.removeHeader("Content-Length");
            }
            request = requestBuilder.build();
        }
        this.engine = new HttpEngine(this.client, request, false, false, forWebSocket, (Connection) null, (RouteSelector) null, (RetryableSink) null, (Response) null);
        int followUpCount = 0;
        while (!this.canceled) {
            try {
                this.engine.sendRequest();
                this.engine.readResponse();
                Response response = this.engine.getResponse();
                Request followUp = this.engine.followUpRequest();
                if (followUp != null) {
                    followUpCount++;
                    if (followUpCount > 20) {
                        throw new ProtocolException("Too many follow-up requests: " + followUpCount);
                    }
                    if (!this.engine.sameConnection(followUp.url())) {
                        this.engine.releaseConnection();
                    }
                    this.engine = new HttpEngine(this.client, followUp, false, false, forWebSocket, this.engine.close(), (RouteSelector) null, (RetryableSink) null, response);
                } else if (forWebSocket) {
                    return response;
                } else {
                    this.engine.releaseConnection();
                    return response;
                }
            } catch (IOException e) {
                HttpEngine retryEngine = this.engine.recover(e, (Sink) null);
                if (retryEngine != null) {
                    this.engine = retryEngine;
                } else {
                    throw e;
                }
            }
        }
        this.engine.releaseConnection();
        return null;
    }
}
