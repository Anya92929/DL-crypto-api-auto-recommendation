package com.SocketMobile.ScanAPI;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.SocketMobile.Bluetooth.BluetoothHelper;

public class SktScanApiOwnership {
    /* access modifiers changed from: private */
    public final String ASK_SCANAPI_OWNERSHIP = (SktScanApiOwnership.class.getName() + ".AskOwnership");
    /* access modifiers changed from: private */
    public final String CLAIM_SCANAPI_OWNERSHIP = (SktScanApiOwnership.class.getName() + ".ClaimOwnership");
    /* access modifiers changed from: private */
    public final String EXTRA_PREFERED_APP = (SktScanApiOwnership.class.getName() + ".PreferedApp");
    /* access modifiers changed from: private */
    public final String EXTRA_SENDER_ID = (SktScanApiOwnership.class.getName() + ".SenderId");
    private final int MESSAGE_ASK_FOR_OWNERSHIP = 1;
    private final int MESSAGE_CHECK_FOR_OWNERSHIP = 2;
    /* access modifiers changed from: private */
    public final String RELEASE_SCANAPI_OWNERSHIP = (SktScanApiOwnership.class.getName() + ".ReleaseOwnership");
    /* access modifiers changed from: private */
    public final String WAIT_SCANAPI_OWNERSHIP = (SktScanApiOwnership.class.getName() + ".WaitOwnership");
    /* access modifiers changed from: private */
    public String _applicationName;
    /* access modifiers changed from: private */
    public Context _context;
    /* access modifiers changed from: private */
    public Handler _handler;
    protected String _lastApplicationNameRequestingOwnership;
    private Handler.Callback _messageHandler = new Handler.Callback() {
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (SktScanApiOwnership.this._ownershipState == -1) {
                        Debug.Msg(1, SktScanApiOwnership.this._applicationName + " is claiming ScanAPI ownership after waiting for a bit");
                        int unused = SktScanApiOwnership.this._ownershipState = -2;
                        if (SktScanApiOwnership.this._notification != null) {
                            SktScanApiOwnership.this._notification.onScanApiOwnershipChange(SktScanApiOwnership.this._context, false);
                            break;
                        }
                    }
                    break;
                case 2:
                    if (SktScanApiOwnership.this._ownershipState == -3) {
                        Debug.Msg(1, SktScanApiOwnership.this._applicationName + " is claiming ScanAPI ownership after " + SktScanApiOwnership.this._lastApplicationNameRequestingOwnership + " is NOT claiming it");
                        int unused2 = SktScanApiOwnership.this._ownershipState = -2;
                        if (SktScanApiOwnership.this._notification != null) {
                            SktScanApiOwnership.this._notification.onScanApiOwnershipChange(SktScanApiOwnership.this._context, false);
                            break;
                        }
                    }
                    break;
            }
            return false;
        }
    };
    /* access modifiers changed from: private */
    public Notification _notification;
    /* access modifiers changed from: private */
    public int _ownershipFirstRequestTimeout = BluetoothHelper.kDefaultReadTotalTimeout;
    /* access modifiers changed from: private */
    public int _ownershipState = 0;
    private BroadcastReceiver _receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String senderId = intent.getStringExtra(SktScanApiOwnership.this.EXTRA_SENDER_ID);
            if (senderId.equalsIgnoreCase(SktScanApiOwnership.this._applicationName)) {
                return;
            }
            if (intent.getAction().equalsIgnoreCase(SktScanApiOwnership.this.ASK_SCANAPI_OWNERSHIP)) {
                if (SktScanApiOwnership.this._ownershipState == 1) {
                    Debug.Msg(1, senderId + " is asking for ScanAPI ownership");
                    if (SktScanApiOwnership.this._notification != null) {
                        SktScanApiOwnership.this._notification.onScanApiOwnershipChange(context, true);
                    }
                    SktScanApiOwnership.this._lastApplicationNameRequestingOwnership = senderId;
                    Intent newIntent = new Intent(SktScanApiOwnership.this.WAIT_SCANAPI_OWNERSHIP);
                    newIntent.putExtra(SktScanApiOwnership.this.EXTRA_SENDER_ID, SktScanApiOwnership.this._applicationName);
                    context.sendBroadcast(newIntent);
                }
            } else if (intent.getAction().equalsIgnoreCase(SktScanApiOwnership.this.CLAIM_SCANAPI_OWNERSHIP)) {
                if (SktScanApiOwnership.this._ownershipState == 1) {
                    Debug.Msg(1, senderId + " is claiming ScanAPI ownership");
                    if (SktScanApiOwnership.this._notification != null) {
                        SktScanApiOwnership.this._notification.onScanApiOwnershipChange(context, true);
                    }
                } else if (SktScanApiOwnership.this._ownershipState == -3) {
                    int unused = SktScanApiOwnership.this._ownershipState = 0;
                }
            } else if (intent.getAction().equalsIgnoreCase(SktScanApiOwnership.this.RELEASE_SCANAPI_OWNERSHIP)) {
                String preferredApp = intent.getStringExtra(SktScanApiOwnership.this.EXTRA_PREFERED_APP);
                if (preferredApp == null) {
                    preferredApp = "";
                }
                if (preferredApp.length() <= 0 || !preferredApp.equalsIgnoreCase(SktScanApiOwnership.this._applicationName)) {
                    if (preferredApp.length() == 0) {
                        int unused2 = SktScanApiOwnership.this._ownershipState = 0;
                        SktScanApiOwnership.this.askForOwnership();
                        return;
                    }
                    int unused3 = SktScanApiOwnership.this._ownershipState = -3;
                    SktScanApiOwnership.this._handler.sendEmptyMessageDelayed(2, (long) SktScanApiOwnership.this._ownershipFirstRequestTimeout);
                    if (SktScanApiOwnership.this._notification != null) {
                        SktScanApiOwnership.this._notification.onScanApiOwnershipFailed(context, preferredApp);
                    }
                } else if (SktScanApiOwnership.this._ownershipState == -2) {
                    Debug.Msg(1, senderId + " is releasing ScanAPI ownership for this application:" + SktScanApiOwnership.this._applicationName);
                    if (SktScanApiOwnership.this._notification != null) {
                        SktScanApiOwnership.this._notification.onScanApiOwnershipChange(context, false);
                    }
                } else if (SktScanApiOwnership.this._ownershipState == 0) {
                    int unused4 = SktScanApiOwnership.this._ownershipState = -2;
                    if (SktScanApiOwnership.this._notification != null) {
                        SktScanApiOwnership.this._notification.onScanApiOwnershipChange(context, false);
                    }
                }
            } else if (intent.getAction().equalsIgnoreCase(SktScanApiOwnership.this.WAIT_SCANAPI_OWNERSHIP)) {
                Debug.Msg(1, senderId + " asks to wait for taking ScanAPI ownership");
                if (SktScanApiOwnership.this._ownershipState == -1) {
                    int unused5 = SktScanApiOwnership.this._ownershipState = -2;
                }
                SktScanApiOwnership.this._lastApplicationNameRequestingOwnership = senderId;
            }
        }
    };
    private boolean _registered;
    private final int kNoOwnership = 0;
    private final int kOwnership = 1;
    private final int kaskPending = -1;
    private final int kunclaimedOwnership = -3;
    private final int kwaiting = -2;

    public interface Notification {
        void onScanApiOwnershipChange(Context context, boolean z);

        void onScanApiOwnershipFailed(Context context, String str);
    }

    public static class Error {
        public static final int kAlreadyDone = 1;
        public static final int kInvalidContext = -3;
        public static final int kInvalidNotification = -2;
        public static final int kNoError = 0;
        public static final int kNotRegistered = -1;

        public static boolean isSuccessful(int result) {
            return result >= 0;
        }
    }

    public static class Debug {
        public static final int kError = 3;
        private static final String kTag = "SktScanApiOwnership";
        public static final int kTrace = 1;
        public static final int kWarning = 2;

        public static void Msg(int level, String text) {
            if (level == 1) {
                Log.d(kTag, text);
            } else if (level == 2) {
                Log.w(kTag, text);
            } else if (level == 3) {
                Log.e(kTag, text);
            } else {
                Log.v(kTag, text);
            }
        }
    }

    public SktScanApiOwnership(Notification notification, String applicationName) {
        this._notification = notification;
        this._registered = false;
        this._applicationName = applicationName;
        this._handler = new Handler(this._messageHandler);
    }

    public boolean hasOwnership() {
        return this._ownershipState == 1;
    }

    public int register(Context context) {
        int result = 0;
        this._context = context;
        if (this._context == null) {
            result = -3;
        }
        if (!Error.isSuccessful(result)) {
            return result;
        }
        if (this._registered) {
            return 1;
        }
        Debug.Msg(1, "About to register ScanAPI ownership for " + this._applicationName);
        context.registerReceiver(this._receiver, new IntentFilter(this.ASK_SCANAPI_OWNERSHIP));
        context.registerReceiver(this._receiver, new IntentFilter(this.CLAIM_SCANAPI_OWNERSHIP));
        context.registerReceiver(this._receiver, new IntentFilter(this.RELEASE_SCANAPI_OWNERSHIP));
        context.registerReceiver(this._receiver, new IntentFilter(this.WAIT_SCANAPI_OWNERSHIP));
        this._registered = true;
        this._ownershipState = 0;
        return result;
    }

    public void unregister() {
        if (this._context != null) {
            if (this._registered) {
                releaseOwnership();
                Debug.Msg(1, "About to unregister ScanAPI ownership for " + this._applicationName);
                try {
                    this._context.unregisterReceiver(this._receiver);
                } catch (IllegalArgumentException e) {
                    Debug.Msg(2, "Trying to unregister causes an exception: " + e.getMessage());
                }
            } else {
                Debug.Msg(2, "Trying to unregister when no registration has been made");
            }
        }
        this._registered = false;
    }

    public int askForOwnership() {
        if (this._ownershipState != 0 && this._ownershipState != -3) {
            return 0;
        }
        if (this._context == null) {
            return -1;
        }
        Debug.Msg(1, "About to ask for ScanAPI ownership for " + this._applicationName);
        Intent intent = new Intent(this.ASK_SCANAPI_OWNERSHIP);
        intent.putExtra(this.EXTRA_SENDER_ID, this._applicationName);
        this._context.sendBroadcast(intent);
        this._ownershipState = -1;
        this._handler.sendEmptyMessageDelayed(1, (long) this._ownershipFirstRequestTimeout);
        return 0;
    }

    public int claimOwnership() {
        if (this._ownershipState != -2) {
            return 0;
        }
        if (this._context == null) {
            return -1;
        }
        Debug.Msg(1, "About to claim ScanAPI ownership for " + this._applicationName);
        Intent intent = new Intent(this.CLAIM_SCANAPI_OWNERSHIP);
        intent.putExtra(this.EXTRA_SENDER_ID, this._applicationName);
        this._context.sendBroadcast(intent);
        this._ownershipState = 1;
        return 0;
    }

    public int releaseOwnership() {
        if (this._ownershipState == 0) {
            return 0;
        }
        if (this._context == null) {
            return -1;
        }
        Debug.Msg(1, "About to release ScanAPI ownership from " + this._applicationName + " for this app:" + this._lastApplicationNameRequestingOwnership);
        Intent intent = new Intent(this.RELEASE_SCANAPI_OWNERSHIP);
        intent.putExtra(this.EXTRA_SENDER_ID, this._applicationName);
        intent.putExtra(this.EXTRA_PREFERED_APP, this._lastApplicationNameRequestingOwnership);
        this._context.sendBroadcast(intent);
        this._ownershipState = 0;
        return 0;
    }

    public void setFirstOwnershipRequestTimeout(int timeout) {
        this._ownershipFirstRequestTimeout = timeout;
    }

    public int getFirstOwnershipRequestTimeout() {
        return this._ownershipFirstRequestTimeout;
    }
}
