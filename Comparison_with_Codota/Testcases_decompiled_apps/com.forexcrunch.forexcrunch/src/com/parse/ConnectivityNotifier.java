package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ReceiverCallNotAllowedException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ConnectivityNotifier extends BroadcastReceiver {
    static final String TAG = "com.parse.ConnectivityNotifier";
    private static final ConnectivityNotifier singleton = new ConnectivityNotifier();
    private boolean hasRegisteredReceiver = false;
    private Set<ConnectivityListener> listeners = new HashSet();
    private final Object lock = new Object();

    protected interface ConnectivityListener {
        void networkConnectivityStatusChanged(Intent intent);
    }

    ConnectivityNotifier() {
    }

    static ConnectivityNotifier getNotifier() {
        return singleton;
    }

    public void addListener(ConnectivityListener delegate, Context context) {
        synchronized (this.lock) {
            this.listeners.add(delegate);
            tryToRegisterForNetworkStatusNotifications();
        }
    }

    public void removeListener(ConnectivityListener delegate) {
        synchronized (this.lock) {
            this.listeners.remove(delegate);
            tryToRegisterForNetworkStatusNotifications();
        }
    }

    public boolean tryToRegisterForNetworkStatusNotifications() {
        synchronized (this.lock) {
            if (this.hasRegisteredReceiver) {
                return true;
            }
            try {
                if (Parse.applicationContext == null) {
                    return false;
                }
                Parse.applicationContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.hasRegisteredReceiver = true;
                return true;
            } catch (ReceiverCallNotAllowedException e) {
                Parse.logV(TAG, "Cannot register a broadcast receiver because the executing thread is currently in a broadcast receiver. Will try again later.");
                return false;
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        List<ConnectivityListener> listenersCopy;
        synchronized (this.lock) {
            listenersCopy = new ArrayList<>(this.listeners);
        }
        for (ConnectivityListener delegate : listenersCopy) {
            delegate.networkConnectivityStatusChanged(intent);
        }
    }

    public boolean isConnected() {
        NetworkInfo network;
        if (Parse.applicationContext == null) {
            Parse.logW(TAG, "Trying to check network connectivity without a known context. Has Parse.initialize been called from Application.onCreate? (Not Activity.onCreate)");
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) Parse.applicationContext.getSystemService("connectivity");
        if (connectivityManager == null || (network = connectivityManager.getActiveNetworkInfo()) == null || network.isConnected()) {
            return true;
        }
        return false;
    }
}
