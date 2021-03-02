package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.internal.C1639ny;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.List;

public final class PlusShare {
    public static final String EXTRA_CALL_TO_ACTION = "com.google.android.apps.plus.CALL_TO_ACTION";
    public static final String EXTRA_CONTENT_DEEP_LINK_ID = "com.google.android.apps.plus.CONTENT_DEEP_LINK_ID";
    public static final String EXTRA_CONTENT_DEEP_LINK_METADATA = "com.google.android.apps.plus.CONTENT_DEEP_LINK_METADATA";
    public static final String EXTRA_CONTENT_URL = "com.google.android.apps.plus.CONTENT_URL";
    public static final String EXTRA_IS_INTERACTIVE_POST = "com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST";
    public static final String EXTRA_SENDER_ID = "com.google.android.apps.plus.SENDER_ID";
    public static final String KEY_CALL_TO_ACTION_DEEP_LINK_ID = "deepLinkId";
    public static final String KEY_CALL_TO_ACTION_LABEL = "label";
    public static final String KEY_CALL_TO_ACTION_URL = "url";
    public static final String KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION = "description";
    public static final String KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL = "thumbnailUrl";
    public static final String KEY_CONTENT_DEEP_LINK_METADATA_TITLE = "title";
    public static final String PARAM_CONTENT_DEEP_LINK_ID = "deep_link_id";

    public static class Builder {
        private boolean alg;
        private ArrayList<Uri> alh;
        private final Context mContext;
        private final Intent mIntent;

        public Builder(Activity launchingActivity) {
            this.mContext = launchingActivity;
            this.mIntent = new Intent().setAction("android.intent.action.SEND");
            this.mIntent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
            if (launchingActivity != null && launchingActivity.getComponentName() != null) {
                this.alg = true;
            }
        }

        @Deprecated
        public Builder(Activity launchingActivity, PlusClient plusClient) {
            this(launchingActivity);
            C0348n.m852a(plusClient != null, "PlusClient must not be null.");
            C0348n.m852a(plusClient.isConnected(), "PlusClient must be connected to create an interactive post.");
            C0348n.m852a(plusClient.mo11263mX().mo11358cd(Scopes.PLUS_LOGIN), "Must request PLUS_LOGIN scope in PlusClient to create an interactive post.");
            Person currentPerson = plusClient.getCurrentPerson();
            this.mIntent.putExtra(PlusShare.EXTRA_SENDER_ID, currentPerson != null ? currentPerson.getId() : "0");
        }

        public Builder(Context context) {
            this.mContext = context;
            this.mIntent = new Intent().setAction("android.intent.action.SEND");
        }

        public Builder addCallToAction(String label, Uri uri, String deepLinkId) {
            C0348n.m852a(this.alg, "Must include the launching activity with PlusShare.Builder constructor before setting call-to-action");
            C0348n.m859b(uri != null && !TextUtils.isEmpty(uri.toString()), (Object) "Must provide a call to action URL");
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(label)) {
                bundle.putString(PlusShare.KEY_CALL_TO_ACTION_LABEL, label);
            }
            bundle.putString(PlusShare.KEY_CALL_TO_ACTION_URL, uri.toString());
            if (!TextUtils.isEmpty(deepLinkId)) {
                C0348n.m852a(PlusShare.m6540ca(deepLinkId), "The specified deep-link ID was malformed.");
                bundle.putString(PlusShare.KEY_CALL_TO_ACTION_DEEP_LINK_ID, deepLinkId);
            }
            this.mIntent.putExtra(PlusShare.EXTRA_CALL_TO_ACTION, bundle);
            this.mIntent.putExtra(PlusShare.EXTRA_IS_INTERACTIVE_POST, true);
            this.mIntent.setType("text/plain");
            return this;
        }

        /* Debug info: failed to restart local var, previous not found, register: 2 */
        public Builder addStream(Uri streamUri) {
            Uri uri = (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            if (uri == null) {
                return setStream(streamUri);
            }
            if (this.alh == null) {
                this.alh = new ArrayList<>();
            }
            this.alh.add(uri);
            this.alh.add(streamUri);
            return this;
        }

        public Intent getIntent() {
            boolean z = true;
            boolean z2 = this.alh != null && this.alh.size() > 1;
            boolean equals = "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
            boolean booleanExtra = this.mIntent.getBooleanExtra(PlusShare.EXTRA_IS_INTERACTIVE_POST, false);
            C0348n.m852a(!z2 || !booleanExtra, "Call-to-action buttons are only available for URLs.");
            C0348n.m852a(!booleanExtra || this.mIntent.hasExtra(PlusShare.EXTRA_CONTENT_URL), "The content URL is required for interactive posts.");
            if (booleanExtra && !this.mIntent.hasExtra(PlusShare.EXTRA_CONTENT_URL) && !this.mIntent.hasExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID)) {
                z = false;
            }
            C0348n.m852a(z, "Must set content URL or content deep-link ID to use a call-to-action button.");
            if (this.mIntent.hasExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID)) {
                C0348n.m852a(PlusShare.m6540ca(this.mIntent.getStringExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID)), "The specified deep-link ID was malformed.");
            }
            if (!z2 && equals) {
                this.mIntent.setAction("android.intent.action.SEND");
                if (this.alh == null || this.alh.isEmpty()) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.mIntent.putExtra("android.intent.extra.STREAM", this.alh.get(0));
                }
                this.alh = null;
            }
            if (z2 && !equals) {
                this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
                if (this.alh == null || this.alh.isEmpty()) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.alh);
                }
            }
            if ("com.google.android.gms.plus.action.SHARE_INTERNAL_GOOGLE".equals(this.mIntent.getAction())) {
                this.mIntent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                return this.mIntent;
            } else if (!this.mIntent.hasExtra("android.intent.extra.STREAM")) {
                this.mIntent.setAction("com.google.android.gms.plus.action.SHARE_GOOGLE");
                this.mIntent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                return this.mIntent;
            } else {
                this.mIntent.setPackage("com.google.android.apps.plus");
                return this.mIntent;
            }
        }

        public Builder setContentDeepLinkId(String deepLinkId) {
            return setContentDeepLinkId(deepLinkId, (String) null, (String) null, (Uri) null);
        }

        public Builder setContentDeepLinkId(String deepLinkId, String title, String description, Uri thumbnailUri) {
            C0348n.m859b(this.alg, (Object) "Must include the launching activity with PlusShare.Builder constructor before setting deep links");
            C0348n.m859b(!TextUtils.isEmpty(deepLinkId), (Object) "The deepLinkId parameter is required.");
            Bundle a = PlusShare.m6539a(title, description, thumbnailUri);
            this.mIntent.putExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID, deepLinkId);
            this.mIntent.putExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_METADATA, a);
            this.mIntent.setType("text/plain");
            return this;
        }

        public Builder setContentUrl(Uri uri) {
            String str = null;
            if (uri != null) {
                str = uri.toString();
            }
            if (TextUtils.isEmpty(str)) {
                this.mIntent.removeExtra(PlusShare.EXTRA_CONTENT_URL);
            } else {
                this.mIntent.putExtra(PlusShare.EXTRA_CONTENT_URL, str);
            }
            return this;
        }

        public Builder setRecipients(Person user, List<Person> recipientList) {
            this.mIntent.putExtra(PlusShare.EXTRA_SENDER_ID, user != null ? user.getId() : "0");
            return setRecipients(recipientList);
        }

        @Deprecated
        public Builder setRecipients(List<Person> recipientList) {
            int size = recipientList != null ? recipientList.size() : 0;
            if (size == 0) {
                this.mIntent.removeExtra("com.google.android.apps.plus.RECIPIENT_IDS");
                this.mIntent.removeExtra("com.google.android.apps.plus.RECIPIENT_DISPLAY_NAMES");
            } else {
                ArrayList arrayList = new ArrayList(size);
                ArrayList arrayList2 = new ArrayList(size);
                for (Person next : recipientList) {
                    arrayList.add(next.getId());
                    arrayList2.add(next.getDisplayName());
                }
                this.mIntent.putStringArrayListExtra("com.google.android.apps.plus.RECIPIENT_IDS", arrayList);
                this.mIntent.putStringArrayListExtra("com.google.android.apps.plus.RECIPIENT_DISPLAY_NAMES", arrayList2);
            }
            return this;
        }

        public Builder setStream(Uri streamUri) {
            this.alh = null;
            this.mIntent.putExtra("android.intent.extra.STREAM", streamUri);
            return this;
        }

        public Builder setText(CharSequence text) {
            this.mIntent.putExtra("android.intent.extra.TEXT", text);
            return this;
        }

        public Builder setType(String mimeType) {
            this.mIntent.setType(mimeType);
            return this;
        }
    }

    @Deprecated
    protected PlusShare() {
        throw new AssertionError();
    }

    /* renamed from: a */
    public static Bundle m6539a(String str, String str2, Uri uri) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_CONTENT_DEEP_LINK_METADATA_TITLE, str);
        bundle.putString(KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, str2);
        if (uri != null) {
            bundle.putString(KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, uri.toString());
        }
        return bundle;
    }

    /* renamed from: ca */
    protected static boolean m6540ca(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("GooglePlusPlatform", "The provided deep-link ID is empty.");
            return false;
        } else if (!str.contains(" ")) {
            return true;
        } else {
            Log.e("GooglePlusPlatform", "Spaces are not allowed in deep-link IDs.");
            return false;
        }
    }

    public static Person createPerson(String id, String displayName) {
        if (TextUtils.isEmpty(id)) {
            throw new IllegalArgumentException("MinimalPerson ID must not be empty.");
        } else if (!TextUtils.isEmpty(displayName)) {
            return new C1639ny(displayName, id, (C1639ny.C1644c) null, 0, (String) null);
        } else {
            throw new IllegalArgumentException("Display name must not be empty.");
        }
    }

    public static String getDeepLinkId(Intent intent) {
        if (intent == null || intent.getData() == null) {
            return null;
        }
        return intent.getData().getQueryParameter(PARAM_CONTENT_DEEP_LINK_ID);
    }
}
