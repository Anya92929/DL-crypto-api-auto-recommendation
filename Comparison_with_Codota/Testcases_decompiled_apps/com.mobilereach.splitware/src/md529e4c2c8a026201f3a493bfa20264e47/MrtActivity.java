package md529e4c2c8a026201f3a493bfa20264e47;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MrtActivity extends Activity implements IGCUserPeer {
    public static final String __md_methods = "n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\nn_onResume:()V:GetOnResumeHandler\nn_onPause:()V:GetOnPauseHandler\nn_onNewIntent:(Landroid/content/Intent;)V:GetOnNewIntent_Landroid_content_Intent_Handler\nn_onStart:()V:GetOnStartHandler\nn_onStop:()V:GetOnStopHandler\nn_onDestroy:()V:GetOnDestroyHandler\nn_finish:()V:GetFinishHandler\nn_onBackPressed:()V:GetOnBackPressedHandler\nn_onActivityResult:(IILandroid/content/Intent;)V:GetOnActivityResult_IILandroid_content_Intent_Handler\nn_onCreateOptionsMenu:(Landroid/view/Menu;)Z:GetOnCreateOptionsMenu_Landroid_view_Menu_Handler\nn_onOptionsItemSelected:(Landroid/view/MenuItem;)Z:GetOnOptionsItemSelected_Landroid_view_MenuItem_Handler\nn_dispatchKeyEvent:(Landroid/view/KeyEvent;)Z:GetDispatchKeyEvent_Landroid_view_KeyEvent_Handler\nn_dispatchTouchEvent:(Landroid/view/MotionEvent;)Z:GetDispatchTouchEvent_Landroid_view_MotionEvent_Handler\n";
    private ArrayList refList;

    private native boolean n_dispatchKeyEvent(KeyEvent keyEvent);

    private native boolean n_dispatchTouchEvent(MotionEvent motionEvent);

    private native void n_finish();

    private native void n_onActivityResult(int i, int i2, Intent intent);

    private native void n_onBackPressed();

    private native void n_onCreate(Bundle bundle);

    private native boolean n_onCreateOptionsMenu(Menu menu);

    private native void n_onDestroy();

    private native void n_onNewIntent(Intent intent);

    private native boolean n_onOptionsItemSelected(MenuItem menuItem);

    private native void n_onPause();

    private native void n_onResume();

    private native void n_onStart();

    private native void n_onStop();

    static {
        Runtime.register("UI.MrtActivity, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", MrtActivity.class, __md_methods);
    }

    public MrtActivity() throws Throwable {
        if (getClass() == MrtActivity.class) {
            TypeManager.Activate("UI.MrtActivity, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        n_onCreate(bundle);
    }

    public void onResume() {
        n_onResume();
    }

    public void onPause() {
        n_onPause();
    }

    public void onNewIntent(Intent intent) {
        n_onNewIntent(intent);
    }

    public void onStart() {
        n_onStart();
    }

    public void onStop() {
        n_onStop();
    }

    public void onDestroy() {
        n_onDestroy();
    }

    public void finish() {
        n_finish();
    }

    public void onBackPressed() {
        n_onBackPressed();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        n_onActivityResult(i, i2, intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return n_onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return n_onOptionsItemSelected(menuItem);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return n_dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return n_dispatchTouchEvent(motionEvent);
    }

    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    public void monodroidClearReferences() {
        if (this.refList != null) {
            this.refList.clear();
        }
    }
}
