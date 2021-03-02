package mono.android.view.textservice;

import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SpellCheckerSession_SpellCheckerSessionListenerImplementor implements IGCUserPeer, SpellCheckerSession.SpellCheckerSessionListener {
    public static final String __md_methods = "n_onGetSentenceSuggestions:([Landroid/view/textservice/SentenceSuggestionsInfo;)V:GetOnGetSentenceSuggestions_arrayLandroid_view_textservice_SentenceSuggestionsInfo_Handler:Android.Views.TextService.SpellCheckerSession/ISpellCheckerSessionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onGetSuggestions:([Landroid/view/textservice/SuggestionsInfo;)V:GetOnGetSuggestions_arrayLandroid_view_textservice_SuggestionsInfo_Handler:Android.Views.TextService.SpellCheckerSession/ISpellCheckerSessionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr);

    private native void n_onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr);

    static {
        Runtime.register("Android.Views.TextService.SpellCheckerSession+ISpellCheckerSessionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", SpellCheckerSession_SpellCheckerSessionListenerImplementor.class, __md_methods);
    }

    public SpellCheckerSession_SpellCheckerSessionListenerImplementor() throws Throwable {
        if (getClass() == SpellCheckerSession_SpellCheckerSessionListenerImplementor.class) {
            TypeManager.Activate("Android.Views.TextService.SpellCheckerSession+ISpellCheckerSessionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        n_onGetSentenceSuggestions(sentenceSuggestionsInfoArr);
    }

    public void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
        n_onGetSuggestions(suggestionsInfoArr);
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
