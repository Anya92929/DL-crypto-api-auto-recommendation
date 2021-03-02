package com.tapcrowd.app.modules.notes;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.launcher.TCLauncher;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.DetailImageViewpagerAdapter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.ImageDB;
import com.tapcrowd.app.utils.TCObject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.cordova.Globalization;

public class NoteDetailFragment extends TCFragment implements MenuFragment.MenuItemListener, TCLauncher.BackPressedListener {
    private final int EDIT_NOTE = 987;

    /* renamed from: id */
    private String f2092id;

    /* renamed from: v */
    private View f2093v;

    public static NoteDetailFragment newInstance() {
        return new NoteDetailFragment();
    }

    public static NoteDetailFragment newInstance(String id) {
        NoteDetailFragment fragment = new NoteDetailFragment();
        fragment.f2092id = id;
        return fragment;
    }

    public void onResume() {
        super.onResume();
        setupLayout();
        getData();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f2093v = inflater.inflate(C0846R.layout.note_detail, container, false);
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes_nav, C1216LO.getLo(C1216LO.navigationColor)), 987));
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
        ((TCLauncher) getActivity()).setBackPressedListener(this);
        AdHelper.showAds(this, (String) null);
        return this.f2093v;
    }

    private void setupLayout() {
        ((TextView) this.f2093v.findViewById(C0846R.C0847id.tvTitle)).setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        ((TextView) this.f2093v.findViewById(C0846R.C0847id.tvSub)).setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
        ((TextView) this.f2093v.findViewById(C0846R.C0847id.tvText)).setTextColor(C1216LO.getLo(C1216LO.textcolor));
    }

    private void getData() {
        TCObject note = C1199DB.getFirstObject("note", DBFavorites.KEY_EVENT_ID, this.f2092id);
        setAbTitle(note.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
        TextView tvTitle = (TextView) this.f2093v.findViewById(C0846R.C0847id.tvTitle);
        tvTitle.setText(note.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
        tvTitle.setTextColor(C1216LO.getLo(C1216LO.textcolor));
        TextView tvText = (TextView) this.f2093v.findViewById(C0846R.C0847id.tvText);
        tvText.setText(note.get("text"));
        tvText.setTextColor(C1216LO.getLo(C1216LO.textcolor));
        if (note.has(Globalization.TYPE)) {
            TextView tvSub = (TextView) this.f2093v.findViewById(C0846R.C0847id.tvSub);
            tvSub.setTextColor(C1216LO.getLo(C1216LO.textcolor));
            TCObject tco = C1199DB.getObject(note.get(Globalization.TYPE), DBFavorites.KEY_EVENT_ID, note.get("typeid"));
            tvSub.setText(tco.get(DBFavorites.KEY_NAME, tco.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "")));
        }
        loadImage(note);
    }

    public void editNote() {
        if (this.f2092id != null) {
            TCObject note = C1199DB.getFirstObject("note", DBFavorites.KEY_EVENT_ID, this.f2092id);
            if (!note.has("typeid") || !note.has(Globalization.TYPE) || note.get(Globalization.TYPE).equals("eventid")) {
                Fragments.add(this, AddNoteFragment.newInstance(this.f2092id, (String) null, (String) null), "");
            } else {
                Fragments.add(this, AddNoteFragment.newInstance(this.f2092id, note.get(Globalization.TYPE), note.get("typeid")), "");
            }
        } else {
            Fragments.add(this, AddNoteFragment.newInstance((String) null, (String) null), "");
        }
    }

    private void loadImage(TCObject note) {
        if (note.has(DBFavorites.KEY_EVENT_ID)) {
            List<File> listImages = ImageDB.getImage("note", note.get(DBFavorites.KEY_EVENT_ID));
            List<String> images = new ArrayList<>();
            if (listImages.size() != 0) {
                for (File image : listImages) {
                    images.add(image.getAbsolutePath());
                }
                ViewPager vp = (ViewPager) this.f2093v.findViewById(C0846R.C0847id.viewerpager);
                vp.setAdapter(new DetailImageViewpagerAdapter((Context) getActivity(), images, (LinearLayout) this.f2093v.findViewById(C0846R.C0847id.pager), true));
                vp.setVisibility(0);
                return;
            }
            ((ViewPager) this.f2093v.findViewById(C0846R.C0847id.viewerpager)).setVisibility(8);
        }
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 987:
                editNote();
                return;
            default:
                return;
        }
    }

    public boolean onBackPressed() {
        return true;
    }
}
