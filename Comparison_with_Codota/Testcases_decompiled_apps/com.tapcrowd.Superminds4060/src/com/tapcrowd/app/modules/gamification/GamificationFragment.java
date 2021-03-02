package com.tapcrowd.app.modules.gamification;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.IntentIntegrator;
import com.tapcrowd.app.utils.IntentResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GamificationFragment extends TCFragment implements MenuFragment.MenuItemListener {
    private final int SCAN_QR = 342;
    /* access modifiers changed from: private */
    public int iCounter = 0;
    /* access modifiers changed from: private */
    public ImageView ivOverlay;
    /* access modifiers changed from: private */

    /* renamed from: ll */
    public LinearLayout f2041ll;
    /* access modifiers changed from: private */
    public int maxProgress = 10;
    /* access modifiers changed from: private */
    public View overlayview;
    /* access modifiers changed from: private */
    public View progress;
    public HashMap<String, String> qrRaw = new HashMap<String, String>() {
        {
            put("0fc0cfbea5c1a299e8ef26f69cc37fcea4ecd941", "0030");
            put("130a302f8388a1cff16cab38179b3a408dcad76d", "0011");
            put("250b467c21070b95815d92224f75aba3d6d6512a", "0015");
            put("2bd9e168fe2220ff1a986d5e09bc29d2adc22154", "0029");
            put("2ed6e93346b54d56a1887a5dc5ff14753f9c9e34", "0001");
            put("30160721407d81874565cb09fe1f52903e38dfe3", "0014");
            put("3264bc29e1268415ace4699e2958a7527ac520e2", "0023");
            put("402a81a41408ef5332285d60a7624c5a86373c3d", "0006");
            put("4743e0d372c220ae9cda729b2f7b29ea30ee19fe", "0019");
            put("5f7edde0fd0186616c6e71e55c89fd5ec95b0cf8", "0007");
            put("604d277a60cbd3ce3bd776e62a3d138f958bdffd", "0004");
            put("6dfaef18e9293e6adb39d95cf3e5098c446df9a3", "0002");
            put("7344ef900b3dc50428839de36e75b30c99317df9", "0020");
            put("792fc02fc31e5fa3a590ef616b9450251240f3db", "0022");
            put("91e72435c47a218f1b9605e9a69c107102305e11", "0025");
            put("a878dcdb62265a535d3f88dba3c0a973c10241ea", "0026");
            put("ab9c551c83ccb1fbc0dd655d94de0b5be1ffdabf", "0027");
            put("b18942cb2acdd031cd1da373cd3235359e301b50", "0018");
            put("b2853162de738360383478bf4d2d58e6f4f518e0", "0010");
            put("b2e0b8f9ffc12f568aa0f411200270addd8be7f1", "0016");
            put("b552a18aa002c631be3813c340cc460a9322b30d", "0005");
            put("ba068a431fa1e0dbe2492c0f9c0c96e8eb9030f7", "0009");
            put("c3b0b9d707ac20266de5b4c62b868d9c29b243e3", "0013");
            put("c56df0c7dd70beeb6a10c94701dd589d162d5491", "0024");
            put("ce5c3a8c3d3fefa68a2841890cbc82b2e3b677d4", "0008");
            put("d63fbc6aee370954631e05be55666e242e1d64ae", "0017");
            put("ece8069a3438dd618e5e3f3d25b822424da3d92a", "0003");
            put("f190f163e15a230c99e8a7f16fcfccd657525c4b", "0012");
            put("f83feb5c1106f77e6eb236f2a13bc8bb83590f6c", "0028");
            put("fc707e2be138ea91c5420a8698c4cd8deb8ece67", "0021");
        }
    };
    private boolean retained;
    private ArrayList<String> scannedQr = new ArrayList<>();
    private TextView tvInfo;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public View f2042v;

    public static GamificationFragment newInstance() {
        return new GamificationFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f2042v = inflater.inflate(C0846R.layout.gamification, container, false);
        return this.f2042v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences pref = getActivity().getSharedPreferences("gamification", 0);
        if (!this.retained && !pref.getBoolean("done", false)) {
            checkPreferences();
            setupMenu();
            setupLayout();
            setupProgressBar();
        }
    }

    public void onResume() {
        super.onResume();
        if (getActivity().getSharedPreferences("gamification", 0).getBoolean("done", false)) {
            this.f2042v.findViewById(C0846R.C0847id.btnContinue).setVisibility(8);
            this.f2042v.findViewById(C0846R.C0847id.progressBar).setVisibility(8);
            this.tvInfo = (TextView) this.f2042v.findViewById(C0846R.C0847id.tvInfo);
            this.tvInfo.setText("Congratulations, you've finished this game! You will be contacted by KMO if you are one of the winners!");
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private void checkPreferences() {
        this.scannedQr = new ArrayList<>(Arrays.asList(getActivity().getSharedPreferences("gamification", 0).getString("qrCodes", "").split(",")));
        this.scannedQr.remove("");
        this.iCounter = this.scannedQr.size();
    }

    private void setupMenu() {
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_qr, C1216LO.getLo(C1216LO.navigationColor)), 342));
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
    }

    private void setupLayout() {
        this.tvInfo = (TextView) this.f2042v.findViewById(C0846R.C0847id.tvInfo);
        this.tvInfo.setBackgroundColor(C1216LO.getLo(C1216LO.backgroundColor));
        this.tvInfo.setTextColor(C1216LO.getLo(C1216LO.textcolor));
        int remaining = this.maxProgress - this.iCounter;
        this.tvInfo.setText(getString(C0846R.string.gamification_remaining, new StringBuilder(String.valueOf(remaining)).toString()));
        RelativeLayout rl = (RelativeLayout) this.f2042v.findViewById(C0846R.C0847id.f1993rl);
        rl.setBackgroundColor(C1216LO.getLo(C1216LO.backgroundColor));
        rl.post(new Runnable() {
            public void run() {
                GamificationFragment.this.ivOverlay = (ImageView) GamificationFragment.this.f2042v.findViewById(C0846R.C0847id.ivOverlay);
                int remaining = GamificationFragment.this.maxProgress - GamificationFragment.this.iCounter;
                if (remaining != 0) {
                    GamificationFragment.this.ivOverlay.setVisibility(0);
                    GamificationFragment.this.f2041ll.setVisibility(0);
                    GamificationFragment.this.progress.setVisibility(0);
                    GamificationFragment.this.progress.setLayoutParams(new LinearLayout.LayoutParams(0, GamificationFragment.this.f2041ll.getHeight(), (float) GamificationFragment.this.iCounter));
                }
                GamificationFragment.this.ivOverlay.setBackgroundResource(C0846R.drawable.schuine_rand1);
                GamificationFragment.this.overlayview = GamificationFragment.this.f2042v.findViewById(C0846R.C0847id.vOverlay);
                RelativeLayout rl = (RelativeLayout) GamificationFragment.this.f2042v.findViewById(C0846R.C0847id.f1993rl);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) GamificationFragment.this.overlayview.getLayoutParams();
                params.height = ((rl.getHeight() * (remaining - 1)) * 1) / 9;
                GamificationFragment.this.overlayview.setLayoutParams(params);
                RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) GamificationFragment.this.ivOverlay.getLayoutParams();
                params2.height = (rl.getHeight() * 1) / 9;
                GamificationFragment.this.ivOverlay.setLayoutParams(params2);
                if (remaining == 0 && !GamificationFragment.this.getActivity().getSharedPreferences("gamification", 0).getBoolean("done", false)) {
                    GamificationFragment.this.gotToTen();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void gotToTen() {
        this.tvInfo.setText(getString(C0846R.string.gamification_continue));
        this.f2041ll.setVisibility(4);
        this.ivOverlay.setVisibility(8);
        Button btnContinue = (Button) this.f2042v.findViewById(C0846R.C0847id.btnContinue);
        btnContinue.setVisibility(0);
        btnContinue.setTextColor(C1216LO.getLo(C1216LO.textcolorButtons));
        btnContinue.setBackgroundColor(C1216LO.getLo(C1216LO.buttonBackgroundColor));
        btnContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GamificationFragment.this.continueclick();
            }
        });
    }

    private void setupProgressBar() {
        this.f2041ll = (LinearLayout) this.f2042v.findViewById(C0846R.C0847id.progressBar);
        this.f2041ll.setWeightSum((float) this.maxProgress);
        this.progress = this.f2042v.findViewById(C0846R.C0847id.progress);
        this.progress.setBackgroundColor(C1216LO.getLo(C1216LO.navigationColor));
    }

    /* access modifiers changed from: private */
    public void continueclick() {
        Fragments.add(this, GamificationPrizeFragment.newInstance(), (String) null);
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 342:
                IntentIntegrator.initiateScan(this, getActivity());
                return;
            default:
                return;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanResult.getContents() != null) {
            if (!(!this.scannedQr.contains(this.qrRaw.get(scanResult.getContents())))) {
                AlertDialog.Builder alertbox = new AlertDialog.Builder(getActivity());
                alertbox.setMessage(C0846R.string.qrcodealert);
                alertbox.setTitle(C0846R.string.qrcodealerttitle);
                alertbox.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
                alertbox.show();
            } else if (this.qrRaw.containsKey(scanResult.getContents())) {
                CounterUp(this.qrRaw.get(scanResult.getContents()));
            }
        }
    }

    private void CounterUp(String newScanString) {
        this.iCounter++;
        this.progress.setLayoutParams(new LinearLayout.LayoutParams(0, this.f2041ll.getHeight(), (float) this.iCounter));
        this.tvInfo.setText(getString(C0846R.string.gamification_remaining, new StringBuilder(String.valueOf(this.maxProgress - this.iCounter)).toString()));
        this.scannedQr.add(newScanString);
        addScan(newScanString);
        this.ivOverlay.setBackgroundResource(C0846R.drawable.schuine_rand1);
        if (this.iCounter % 2 == 1) {
            this.ivOverlay.setBackgroundResource(C0846R.drawable.schuine_rand2);
        }
        RelativeLayout rl = (RelativeLayout) this.f2042v.findViewById(C0846R.C0847id.f1993rl);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.overlayview.getLayoutParams();
        params.height = ((rl.getHeight() * ((this.maxProgress - this.iCounter) - 1)) * 1) / 9;
        this.overlayview.setLayoutParams(params);
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) this.ivOverlay.getLayoutParams();
        params2.height = (rl.getHeight() * 1) / 9;
        this.ivOverlay.setLayoutParams(params2);
        if (this.iCounter == 10) {
            gotToTen();
        }
    }

    private void addScan(String newScan) {
        SharedPreferences pref = getActivity().getSharedPreferences("gamification", 0);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString("qrCodes", String.valueOf(pref.getString("qrCodes", "")) + newScan + ",");
        edit.commit();
    }
}
