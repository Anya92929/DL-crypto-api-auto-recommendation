package mono.android.speech;

import android.os.Bundle;
import android.speech.RecognitionListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class RecognitionListenerImplementor implements IGCUserPeer, RecognitionListener {
    public static final String __md_methods = "n_onBeginningOfSpeech:()V:GetOnBeginningOfSpeechHandler:Android.Speech.IRecognitionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onBufferReceived:([B)V:GetOnBufferReceived_arrayBHandler:Android.Speech.IRecognitionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onEndOfSpeech:()V:GetOnEndOfSpeechHandler:Android.Speech.IRecognitionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onError:(I)V:GetOnError_IHandler:Android.Speech.IRecognitionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onEvent:(ILandroid/os/Bundle;)V:GetOnEvent_ILandroid_os_Bundle_Handler:Android.Speech.IRecognitionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onPartialResults:(Landroid/os/Bundle;)V:GetOnPartialResults_Landroid_os_Bundle_Handler:Android.Speech.IRecognitionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onReadyForSpeech:(Landroid/os/Bundle;)V:GetOnReadyForSpeech_Landroid_os_Bundle_Handler:Android.Speech.IRecognitionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onResults:(Landroid/os/Bundle;)V:GetOnResults_Landroid_os_Bundle_Handler:Android.Speech.IRecognitionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onRmsChanged:(F)V:GetOnRmsChanged_FHandler:Android.Speech.IRecognitionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onBeginningOfSpeech();

    private native void n_onBufferReceived(byte[] bArr);

    private native void n_onEndOfSpeech();

    private native void n_onError(int i);

    private native void n_onEvent(int i, Bundle bundle);

    private native void n_onPartialResults(Bundle bundle);

    private native void n_onReadyForSpeech(Bundle bundle);

    private native void n_onResults(Bundle bundle);

    private native void n_onRmsChanged(float f);

    static {
        Runtime.register("Android.Speech.IRecognitionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", RecognitionListenerImplementor.class, __md_methods);
    }

    public RecognitionListenerImplementor() throws Throwable {
        if (getClass() == RecognitionListenerImplementor.class) {
            TypeManager.Activate("Android.Speech.IRecognitionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onBeginningOfSpeech() {
        n_onBeginningOfSpeech();
    }

    public void onBufferReceived(byte[] bArr) {
        n_onBufferReceived(bArr);
    }

    public void onEndOfSpeech() {
        n_onEndOfSpeech();
    }

    public void onError(int i) {
        n_onError(i);
    }

    public void onEvent(int i, Bundle bundle) {
        n_onEvent(i, bundle);
    }

    public void onPartialResults(Bundle bundle) {
        n_onPartialResults(bundle);
    }

    public void onReadyForSpeech(Bundle bundle) {
        n_onReadyForSpeech(bundle);
    }

    public void onResults(Bundle bundle) {
        n_onResults(bundle);
    }

    public void onRmsChanged(float f) {
        n_onRmsChanged(f);
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
