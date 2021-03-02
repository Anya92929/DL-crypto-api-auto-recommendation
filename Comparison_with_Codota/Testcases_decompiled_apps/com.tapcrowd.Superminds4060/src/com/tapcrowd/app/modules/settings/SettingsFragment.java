package com.tapcrowd.app.modules.settings;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.Splash;
import com.tapcrowd.app.TCApplication;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.User;
import com.tapcrowd.app.utils.UserModule;

public class SettingsFragment extends TCFragment implements View.OnClickListener {
    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2005v == null) {
            this.f2005v = inflater.inflate(C0846R.layout.layout_settings, container, false);
        } else {
            ((ViewGroup) this.f2005v.getParent()).removeView(this.f2005v);
            this.retained = true;
        }
        return this.f2005v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        AdHelper.showAds(this, (String) null);
        super.onActivityCreated(savedInstanceState);
        if (!this.retained) {
            setupView();
            setClicks();
        }
    }

    public void setupView() {
        TextView version = (TextView) this.f2005v.findViewById(C0846R.C0847id.version);
        try {
            version.setText(getString(C0846R.string.version, getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.language)).setText(getLang(User.getLanguage(getActivity())));
        if (!UserModule.isLoggedIn(getActivity())) {
            this.f2005v.findViewById(C0846R.C0847id.logout_container).setVisibility(8);
        }
    }

    public void setClicks() {
        this.f2005v.findViewById(C0846R.C0847id.lang).setOnClickListener(this);
        this.f2005v.findViewById(C0846R.C0847id.lang).setBackgroundDrawable(C1232UI.getBackground());
        this.f2005v.findViewById(C0846R.C0847id.logout).setOnClickListener(this);
        this.f2005v.findViewById(C0846R.C0847id.logout).setBackgroundDrawable(C1232UI.getBackground());
    }

    private String getLang(String shortLang) {
        String lang = "";
        if (shortLang.equals("en")) {
            lang = getString(C0846R.string.f1999en);
        }
        if (shortLang.equals("fr")) {
            lang = getString(C0846R.string.f2000fr);
        }
        if (shortLang.equals("nl")) {
            return getString(C0846R.string.f2001nl);
        }
        return lang;
    }

    private String getShortLang(String lang) {
        String shortlang = "";
        if (lang.equals("English")) {
            shortlang = "en";
        }
        if (lang.equals("Français")) {
            shortlang = "fr";
        }
        if (lang.equals("Nederlands")) {
            return "nl";
        }
        return shortlang;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0846R.C0847id.lang:
                lang();
                return;
            case C0846R.C0847id.logout:
                logout();
                return;
            default:
                return;
        }
    }

    public void lang() {
        if (C1199DB.getListFromDb("languages").size() > 1) {
            registerForContextMenu(getView());
            getActivity().openContextMenu(getView());
            unregisterForContextMenu(getView());
        }
    }

    public void logout() {
        UserModule.logout(getActivity());
        C1199DB.clearDB();
        startActivity(new Intent(getActivity(), Splash.class));
        getActivity().finish();
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        for (TCObject lang : C1199DB.getListFromDb("languages")) {
            menu.add(getLang(lang.get("language")));
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        String lang = User.getLanguage(getActivity());
        String clicked = getShortLang(item.getTitle().toString());
        if (!lang.equals(clicked)) {
            getView().post(new LangRunnable(clicked));
        }
        return super.onContextItemSelected(item);
    }

    public class LangRunnable implements Runnable {
        String lang;

        public LangRunnable(String lang2) {
            this.lang = lang2;
        }

        public void run() {
            TCApplication.updatelanguage(SettingsFragment.this.getActivity(), this.lang);
            C1199DB.clearDB();
            SettingsFragment.this.startActivity(new Intent(SettingsFragment.this.getActivity(), Splash.class));
            SettingsFragment.this.getActivity().finish();
        }
    }
}
