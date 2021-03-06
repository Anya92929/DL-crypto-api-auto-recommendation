package com.google.zxing.client.android.history;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.zxing.Result;
import com.google.zxing.client.android.C0776R;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.Intents;
import java.util.List;

public final class HistoryActivity extends ListActivity {
    private static final String TAG = HistoryActivity.class.getSimpleName();
    private HistoryItemAdapter adapter;
    /* access modifiers changed from: private */
    public HistoryManager historyManager;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.historyManager = new HistoryManager(this);
        this.adapter = new HistoryItemAdapter(this);
        setListAdapter(this.adapter);
        registerForContextMenu(getListView());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        reloadHistoryItems();
    }

    private void reloadHistoryItems() {
        List<HistoryItem> items = this.historyManager.buildHistoryItems();
        this.adapter.clear();
        for (HistoryItem item : items) {
            this.adapter.add(item);
        }
        if (this.adapter.isEmpty()) {
            this.adapter.add(new HistoryItem((Result) null, (String) null, (String) null));
        }
    }

    /* access modifiers changed from: protected */
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (((HistoryItem) this.adapter.getItem(position)).getResult() != null) {
            Intent intent = new Intent(this, CaptureActivity.class);
            intent.putExtra(Intents.History.ITEM_NUMBER, position);
            setResult(-1, intent);
            finish();
        }
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        int position = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;
        if (position >= this.adapter.getCount() || ((HistoryItem) this.adapter.getItem(position)).getResult() != null) {
            menu.add(0, position, position, C0776R.string.history_clear_one_history_text);
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        this.historyManager.deleteHistoryItem(item.getItemId());
        reloadHistoryItems();
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.historyManager.hasHistoryItems()) {
            getMenuInflater().inflate(C0776R.C0778menu.history, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == C0776R.C0777id.menu_history_send) {
            Uri historyFile = HistoryManager.saveHistory(this.historyManager.buildHistory().toString());
            if (historyFile == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(C0776R.string.msg_unmount_usb);
                builder.setPositiveButton(C0776R.string.button_ok, (DialogInterface.OnClickListener) null);
                builder.show();
                return true;
            }
            Intent intent = new Intent("android.intent.action.SEND", Uri.parse("mailto:"));
            intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
            String subject = getResources().getString(C0776R.string.history_email_title);
            intent.putExtra("android.intent.extra.SUBJECT", subject);
            intent.putExtra("android.intent.extra.TEXT", subject);
            intent.putExtra("android.intent.extra.STREAM", historyFile);
            intent.setType("text/csv");
            try {
                startActivity(intent);
                return true;
            } catch (ActivityNotFoundException anfe) {
                Log.w(TAG, anfe.toString());
                return true;
            }
        } else if (itemId != C0776R.C0777id.menu_history_clear_text) {
            return super.onOptionsItemSelected(item);
        } else {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setMessage(C0776R.string.msg_sure);
            builder2.setCancelable(true);
            builder2.setPositiveButton(C0776R.string.button_ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int i2) {
                    HistoryActivity.this.historyManager.clearHistory();
                    dialog.dismiss();
                    HistoryActivity.this.finish();
                }
            });
            builder2.setNegativeButton(C0776R.string.button_cancel, (DialogInterface.OnClickListener) null);
            builder2.show();
            return true;
        }
    }
}
