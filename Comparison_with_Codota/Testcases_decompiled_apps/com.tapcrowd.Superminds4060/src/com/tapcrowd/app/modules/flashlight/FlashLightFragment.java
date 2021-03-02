package com.tapcrowd.app.modules.flashlight;

import android.hardware.Camera;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;

public class FlashLightFragment extends TCFragment {
    public static boolean flashlight;

    public static FlashLightFragment newInstance() {
        return new FlashLightFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2005v == null) {
            this.f2005v = inflater.inflate(C0846R.layout.flashlight, container, false);
        } else {
            ((ViewGroup) this.f2005v.getParent()).removeView(this.f2005v);
            this.retained = true;
        }
        AdHelper.showAds(this, AdHelper.buildPath("38", "detail", (String) null));
        return this.f2005v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView iv = (ImageView) this.f2005v.findViewById(C0846R.C0847id.flashlight);
        if (flashlight) {
            iv.setImageResource(C0846R.drawable.flashlight_on);
        } else {
            iv.setImageResource(C0846R.drawable.flashlight_off);
        }
        if (!this.retained) {
            iv.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    FlashLightFragment.this.flashlight(v);
                }
            });
        }
    }

    public void flashlight(View v) {
        boolean z = false;
        ImageView iv = (ImageView) v;
        if (flashlight) {
            iv.setImageResource(C0846R.drawable.flashlight_off);
            if (App.camera != null) {
                App.camera.stopPreview();
                Camera.Parameters param = App.camera.getParameters();
                param.setFlashMode("off");
                App.camera.setParameters(param);
                App.camera.release();
                App.camera = null;
                if (!flashlight) {
                    z = true;
                }
                flashlight = z;
                return;
            }
            return;
        }
        try {
            if (getActivity().getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
                App.camera = Camera.open();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (App.camera != null) {
            Camera.Parameters param2 = App.camera.getParameters();
            param2.setFlashMode("torch");
            try {
                iv.setImageResource(C0846R.drawable.flashlight_on);
                App.camera.setParameters(param2);
                App.camera.startPreview();
                App.camera.autoFocus(new Camera.AutoFocusCallback() {
                    public void onAutoFocus(boolean success, Camera camera) {
                    }
                });
                if (!flashlight) {
                    z = true;
                }
                flashlight = z;
            } catch (Exception e2) {
                Toast.makeText(App.act, C0846R.string.noflash, 1).show();
                if (App.camera != null) {
                    App.camera.release();
                    App.camera = null;
                }
                ((ImageView) v.findViewById(C0846R.C0847id.flashlight)).setImageResource(C0846R.drawable.flashlight_off);
                e2.printStackTrace();
            }
        }
    }
}
