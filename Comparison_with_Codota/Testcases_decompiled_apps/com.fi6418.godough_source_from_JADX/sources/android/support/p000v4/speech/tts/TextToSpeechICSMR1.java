package android.support.p000v4.speech.tts;

import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;

/* renamed from: android.support.v4.speech.tts.TextToSpeechICSMR1 */
class TextToSpeechICSMR1 {
    public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
    public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";

    /* renamed from: android.support.v4.speech.tts.TextToSpeechICSMR1$1 */
    final class C01581 extends UtteranceProgressListener {

        /* renamed from: a */
        final /* synthetic */ UtteranceProgressListenerICSMR1 f1053a;

        public void onDone(String str) {
            this.f1053a.onDone(str);
        }

        public void onError(String str) {
            this.f1053a.onError(str);
        }

        public void onStart(String str) {
            this.f1053a.onStart(str);
        }
    }

    /* renamed from: android.support.v4.speech.tts.TextToSpeechICSMR1$2 */
    final class C01592 implements TextToSpeech.OnUtteranceCompletedListener {

        /* renamed from: a */
        final /* synthetic */ UtteranceProgressListenerICSMR1 f1054a;

        public void onUtteranceCompleted(String str) {
            this.f1054a.onStart(str);
            this.f1054a.onDone(str);
        }
    }

    /* renamed from: android.support.v4.speech.tts.TextToSpeechICSMR1$UtteranceProgressListenerICSMR1 */
    interface UtteranceProgressListenerICSMR1 {
        void onDone(String str);

        void onError(String str);

        void onStart(String str);
    }

    TextToSpeechICSMR1() {
    }
}
