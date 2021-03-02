package com.tapcrowd.app.utils.twitter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.tapcrowd.Superminds4060.C0846R;
import twitter4j.Twitter;

public class TwitterPostDialog extends Dialog {
    View.OnClickListener cancel = new View.OnClickListener() {
        public void onClick(View arg0) {
            TwitterPostDialog.this.dismiss();
        }
    };
    Context context;
    String link;
    EditText message;
    TextWatcher messagewatch = new TextWatcher() {
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            TwitterPostDialog.this.numchars.setText(String.valueOf(((140 - TwitterPostDialog.this.message.length()) - TwitterPostDialog.this.link.length()) - (TwitterPostDialog.this.link.length() > 0 ? 1 : 0)));
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void afterTextChanged(Editable s) {
        }
    };
    TextView numchars;
    String text;
    View.OnClickListener tweet = new View.OnClickListener() {
        public void onClick(View arg0) {
            if (TwitterPostDialog.this.message.length() > 0) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            TwitterPostDialog.this.twitter.updateStatus(String.valueOf(TwitterPostDialog.this.message.getText().toString()) + (TwitterPostDialog.this.link.length() > 0 ? MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + TwitterPostDialog.this.link : ""));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                TwitterPostDialog.this.dismiss();
            }
        }
    };
    Twitter twitter;

    public TwitterPostDialog(Context context2, Twitter twitter2, String text2, String link2) {
        super(context2, C0846R.style.transparentDialogTheme);
        this.context = context2;
        this.twitter = twitter2;
        this.text = text2;
        this.link = link2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        int i;
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        View v = getLayoutInflater().inflate(C0846R.layout.twitter_post, (ViewGroup) null);
        this.message = (EditText) v.findViewById(C0846R.C0847id.message);
        this.numchars = (TextView) v.findViewById(C0846R.C0847id.numchars);
        this.message.addTextChangedListener(this.messagewatch);
        int length = 140 - this.link.length();
        if (this.link.length() > 0) {
            i = 1;
        } else {
            i = 0;
        }
        int maxlength = length - i;
        this.numchars.setText(new StringBuilder(String.valueOf(maxlength)).toString());
        this.message.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxlength)});
        if (this.text != null) {
            if (!this.text.startsWith("@") && !this.text.startsWith("\"") && !this.text.startsWith("http")) {
                this.text = "@" + this.text;
            }
            this.message.setText(this.text);
        }
        v.findViewById(C0846R.C0847id.cancel).setOnClickListener(this.cancel);
        v.findViewById(C0846R.C0847id.tweet).setOnClickListener(this.tweet);
        addContentView(v, new ViewGroup.LayoutParams(-1, -1));
    }
}
