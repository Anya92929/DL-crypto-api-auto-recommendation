package com.tapcrowd.app.utils.facebook;

import android.content.Context;
import android.os.Bundle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class AsyncFacebookRunner {

    /* renamed from: fb */
    Facebook f2139fb;

    public interface RequestListener {
        void onComplete(String str, Object obj);

        void onFacebookError(FacebookError facebookError, Object obj);

        void onFileNotFoundException(FileNotFoundException fileNotFoundException, Object obj);

        void onIOException(IOException iOException, Object obj);

        void onMalformedURLException(MalformedURLException malformedURLException, Object obj);
    }

    public AsyncFacebookRunner(Facebook fb) {
        this.f2139fb = fb;
    }

    public void logout(final Context context, final RequestListener listener, final Object state) {
        new Thread() {
            public void run() {
                try {
                    String response = AsyncFacebookRunner.this.f2139fb.logout(context);
                    if (response.length() == 0 || response.equals("false")) {
                        listener.onFacebookError(new FacebookError("auth.expireSession failed"), state);
                    } else {
                        listener.onComplete(response, state);
                    }
                } catch (FileNotFoundException e) {
                    listener.onFileNotFoundException(e, state);
                } catch (MalformedURLException e2) {
                    listener.onMalformedURLException(e2, state);
                } catch (IOException e3) {
                    listener.onIOException(e3, state);
                }
            }
        }.start();
    }

    public void logout(Context context, RequestListener listener) {
        logout(context, listener, (Object) null);
    }

    public void request(Bundle parameters, RequestListener listener, Object state) {
        request((String) null, parameters, "GET", listener, state);
    }

    public void request(Bundle parameters, RequestListener listener) {
        request((String) null, parameters, "GET", listener, (Object) null);
    }

    public void request(String graphPath, RequestListener listener, Object state) {
        request(graphPath, new Bundle(), "GET", listener, state);
    }

    public void request(String graphPath, RequestListener listener) {
        request(graphPath, new Bundle(), "GET", listener, (Object) null);
    }

    public void request(String graphPath, Bundle parameters, RequestListener listener, Object state) {
        request(graphPath, parameters, "GET", listener, state);
    }

    public void request(String graphPath, Bundle parameters, RequestListener listener) {
        request(graphPath, parameters, "GET", listener, (Object) null);
    }

    public void request(String graphPath, Bundle parameters, String httpMethod, RequestListener listener, Object state) {
        final String str = graphPath;
        final Bundle bundle = parameters;
        final String str2 = httpMethod;
        final RequestListener requestListener = listener;
        final Object obj = state;
        new Thread() {
            public void run() {
                try {
                    requestListener.onComplete(AsyncFacebookRunner.this.f2139fb.request(str, bundle, str2), obj);
                } catch (FileNotFoundException e) {
                    requestListener.onFileNotFoundException(e, obj);
                } catch (MalformedURLException e2) {
                    requestListener.onMalformedURLException(e2, obj);
                } catch (IOException e3) {
                    requestListener.onIOException(e3, obj);
                }
            }
        }.start();
    }
}
