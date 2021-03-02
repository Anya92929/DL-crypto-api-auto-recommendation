package com.appbrain;

import android.app.Activity;
import android.content.Context;
import cmn.Proguard;
import com.appbrain.p032a.C0884ds;
import com.appbrain.p032a.C0926fg;

public class AppBrainUnity implements Proguard.KeepMembers, KeepClass {
    public static void dontKillWhenDone() {
        C0926fg.m3925a().mo3816a((Activity) null);
    }

    public static C0983ad getSettings() {
        return C1121k.m5209b();
    }

    public static void init(Context context) {
        C1121k.m5208a(context);
    }

    public static void killWhenDone(Activity activity) {
        C0926fg.m3925a().mo3816a(activity);
    }

    public static boolean maybeShowInterstitial(Context context) {
        return C0980aa.m4089a().mo3908a("unity").mo3910b(context);
    }

    public static void offerwallButtonClick(Context context) {
        C0884ds.m3839b(context, "unity");
    }

    public static boolean showInterstitial(Context context) {
        return C0980aa.m4089a().mo3908a("unity").mo3909a(context);
    }

    public static void showOfferWall(Context context) {
        C0884ds.m3836a(context, "unity");
    }

    public static void showOfferwall(Context context) {
        C1121k.m5207a().mo3698c(context);
    }
}
