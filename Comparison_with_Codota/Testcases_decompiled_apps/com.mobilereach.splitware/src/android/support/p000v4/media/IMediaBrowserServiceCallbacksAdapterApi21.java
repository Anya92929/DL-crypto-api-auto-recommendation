package android.support.p000v4.media;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21 */
class IMediaBrowserServiceCallbacksAdapterApi21 {
    private Method mAsBinderMethod;
    Object mCallbackObject;
    private Method mOnConnectFailedMethod;
    private Method mOnConnectMethod;
    private Method mOnLoadChildrenMethod;

    IMediaBrowserServiceCallbacksAdapterApi21(Object callbackObject) {
        this.mCallbackObject = callbackObject;
        try {
            Class theClass = Class.forName("android.service.media.IMediaBrowserServiceCallbacks");
            Class parceledListSliceClass = Class.forName("android.content.pm.ParceledListSlice");
            this.mAsBinderMethod = theClass.getMethod("asBinder", new Class[0]);
            this.mOnConnectMethod = theClass.getMethod("onConnect", new Class[]{String.class, MediaSession.Token.class, Bundle.class});
            this.mOnConnectFailedMethod = theClass.getMethod("onConnectFailed", new Class[0]);
            this.mOnLoadChildrenMethod = theClass.getMethod("onLoadChildren", new Class[]{String.class, parceledListSliceClass});
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public IBinder asBinder() {
        try {
            return (IBinder) this.mAsBinderMethod.invoke(this.mCallbackObject, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void onConnect(String root, Object session, Bundle extras) throws RemoteException {
        try {
            this.mOnConnectMethod.invoke(this.mCallbackObject, new Object[]{root, session, extras});
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void onConnectFailed() throws RemoteException {
        try {
            this.mOnConnectFailedMethod.invoke(this.mCallbackObject, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void onLoadChildren(String mediaId, Object parceledListSliceObj) throws RemoteException {
        try {
            this.mOnLoadChildrenMethod.invoke(this.mCallbackObject, new Object[]{mediaId, parceledListSliceObj});
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21$Stub */
    static class Stub {
        static Method sAsInterfaceMethod;

        Stub() {
        }

        static {
            try {
                sAsInterfaceMethod = Class.forName("android.service.media.IMediaBrowserServiceCallbacks$Stub").getMethod("asInterface", new Class[]{IBinder.class});
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        static Object asInterface(IBinder binder) {
            try {
                return sAsInterfaceMethod.invoke((Object) null, new Object[]{binder});
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
