package android.support.p000v4.speech.tts;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import java.util.Locale;
import java.util.Set;

/* renamed from: android.support.v4.speech.tts.TextToSpeechICSMR1 */
class TextToSpeechICSMR1 {
    public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
    public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";

    /* renamed from: android.support.v4.speech.tts.TextToSpeechICSMR1$UtteranceProgressListenerICSMR1 */
    interface UtteranceProgressListenerICSMR1 {
        void onDone(String str);

        void onError(String str);

        void onStart(String str);
    }

    TextToSpeechICSMR1() {
    }

    static Set getFeatures(TextToSpeech textToSpeech, Locale locale) {
        if (Build.VERSION.SDK_INT >= 15) {
            return textToSpeech.getFeatures(locale);
        }
        return null;
    }

    static void setUtteranceProgressListener(TextToSpeech textToSpeech, final UtteranceProgressListenerICSMR1 utteranceProgressListenerICSMR1) {
        if (Build.VERSION.SDK_INT >= 15) {
            textToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                public final void onDone(String str) {
                    UtteranceProgressListenerICSMR1.this.onDone(str);
                }

                public final void onError(String str) {
                    UtteranceProgressListenerICSMR1.this.onError(str);
                }

                public final void onStart(String str) {
                    UtteranceProgressListenerICSMR1.this.onStart(str);
                }
            });
        } else {
            textToSpeech.setOnUtteranceCompletedListener(new TextToSpeech.OnUtteranceCompletedListener() {
                public final void onUtteranceCompleted(String str) {
                    UtteranceProgressListenerICSMR1.this.onStart(str);
                    UtteranceProgressListenerICSMR1.this.onDone(str);
                }
            });
        }
    }
}
