package org.apache.cordova;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Vibrator;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class Notification extends CordovaPlugin {
    public int confirmResult = -1;
    public ProgressDialog progressDialog = null;
    public ProgressDialog spinnerDialog = null;

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("beep")) {
            beep(args.getLong(0));
        } else if (action.equals("vibrate")) {
            vibrate(args.getLong(0));
        } else if (action.equals("alert")) {
            alert(args.getString(0), args.getString(1), args.getString(2), callbackContext);
            return true;
        } else if (action.equals("confirm")) {
            confirm(args.getString(0), args.getString(1), args.getString(2), callbackContext);
            return true;
        } else if (action.equals("activityStart")) {
            activityStart(args.getString(0), args.getString(1));
        } else if (action.equals("activityStop")) {
            activityStop();
        } else if (action.equals("progressStart")) {
            progressStart(args.getString(0), args.getString(1));
        } else if (action.equals("progressValue")) {
            progressValue(args.getInt(0));
        } else if (!action.equals("progressStop")) {
            return false;
        } else {
            progressStop();
        }
        callbackContext.success();
        return true;
    }

    public void beep(long count) {
        Ringtone notification = RingtoneManager.getRingtone(this.cordova.getActivity().getBaseContext(), RingtoneManager.getDefaultUri(2));
        if (notification != null) {
            for (long i = 0; i < count; i++) {
                notification.play();
                long timeout = 5000;
                while (notification.isPlaying() && timeout > 0) {
                    timeout -= 100;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void vibrate(long time) {
        if (time == 0) {
            time = 500;
        }
        ((Vibrator) this.cordova.getActivity().getSystemService("vibrator")).vibrate(time);
    }

    public synchronized void alert(String message, String title, String buttonLabel, CallbackContext callbackContext) {
        final CordovaInterface cordova = this.cordova;
        final String str = message;
        final String str2 = title;
        final String str3 = buttonLabel;
        final CallbackContext callbackContext2 = callbackContext;
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder dlg = new AlertDialog.Builder(cordova.getActivity());
                dlg.setMessage(str);
                dlg.setTitle(str2);
                dlg.setCancelable(true);
                dlg.setPositiveButton(str3, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        callbackContext2.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
                    }
                });
                dlg.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        dialog.dismiss();
                        callbackContext2.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
                    }
                });
                dlg.create();
                dlg.show();
            }
        });
    }

    public synchronized void confirm(String message, String title, String buttonLabels, CallbackContext callbackContext) {
        final CordovaInterface cordova = this.cordova;
        final String[] fButtons = buttonLabels.split(",");
        final String str = message;
        final String str2 = title;
        final CallbackContext callbackContext2 = callbackContext;
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder dlg = new AlertDialog.Builder(cordova.getActivity());
                dlg.setMessage(str);
                dlg.setTitle(str2);
                dlg.setCancelable(true);
                if (fButtons.length > 0) {
                    dlg.setNegativeButton(fButtons[0], new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            callbackContext2.sendPluginResult(new PluginResult(PluginResult.Status.OK, 1));
                        }
                    });
                }
                if (fButtons.length > 1) {
                    dlg.setNeutralButton(fButtons[1], new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            callbackContext2.sendPluginResult(new PluginResult(PluginResult.Status.OK, 2));
                        }
                    });
                }
                if (fButtons.length > 2) {
                    dlg.setPositiveButton(fButtons[2], new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            callbackContext2.sendPluginResult(new PluginResult(PluginResult.Status.OK, 3));
                        }
                    });
                }
                dlg.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        dialog.dismiss();
                        callbackContext2.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
                    }
                });
                dlg.create();
                dlg.show();
            }
        });
    }

    public synchronized void activityStart(final String title, final String message) {
        if (this.spinnerDialog != null) {
            this.spinnerDialog.dismiss();
            this.spinnerDialog = null;
        }
        final CordovaInterface cordova = this.cordova;
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Notification.this.spinnerDialog = ProgressDialog.show(cordova.getActivity(), title, message, true, true, new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        Notification.this.spinnerDialog = null;
                    }
                });
            }
        });
    }

    public synchronized void activityStop() {
        if (this.spinnerDialog != null) {
            this.spinnerDialog.dismiss();
            this.spinnerDialog = null;
        }
    }

    public synchronized void progressStart(String title, String message) {
        if (this.progressDialog != null) {
            this.progressDialog.dismiss();
            this.progressDialog = null;
        }
        final CordovaInterface cordova = this.cordova;
        final String str = title;
        final String str2 = message;
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                this.progressDialog = new ProgressDialog(cordova.getActivity());
                this.progressDialog.setProgressStyle(1);
                this.progressDialog.setTitle(str);
                this.progressDialog.setMessage(str2);
                this.progressDialog.setCancelable(true);
                this.progressDialog.setMax(100);
                this.progressDialog.setProgress(0);
                this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        this.progressDialog = null;
                    }
                });
                this.progressDialog.show();
            }
        });
    }

    public synchronized void progressValue(int value) {
        if (this.progressDialog != null) {
            this.progressDialog.setProgress(value);
        }
    }

    public synchronized void progressStop() {
        if (this.progressDialog != null) {
            this.progressDialog.dismiss();
            this.progressDialog = null;
        }
    }
}
