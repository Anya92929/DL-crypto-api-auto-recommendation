package org.apache.cordova;

import android.os.Bundle;

public class StandAlone extends DroidGap {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
    }
}
