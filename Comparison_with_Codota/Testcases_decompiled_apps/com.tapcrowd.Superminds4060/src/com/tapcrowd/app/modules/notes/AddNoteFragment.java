package com.tapcrowd.app.modules.notes;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.launcher.TCLauncher;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.DetailImageViewpagerAdapter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.ImageDB;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.TCObject;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.cordova.Globalization;

public class AddNoteFragment extends TCFragment implements TCLauncher.BackPressedListener, MenuFragment.MenuItemListener {
    private final int SAVE_NOTE = 111;
    private final int TAKE_PICTURE = 231;
    /* access modifiers changed from: private */
    public EditText etText;
    /* access modifiers changed from: private */
    public EditText etTitle;
    private String eventid = App.curEventId;
    private boolean hasBeenSaved = false;
    /* access modifiers changed from: private */

    /* renamed from: id */
    public String f2089id;
    private String imagename;
    private String initText;
    private String initTitle;
    private ImageView ivDeleteImage;
    private boolean retain;
    private String type;
    private String typeid;

    /* renamed from: v */
    private View f2090v;
    /* access modifiers changed from: private */

    /* renamed from: vp */
    public ViewPager f2091vp;

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupLayout();
        AdHelper.showAds(this, (String) null);
        if (!this.retain) {
            setupItem();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2090v == null) {
            this.f2090v = inflater.inflate(C0846R.layout.addnote, container, false);
        } else {
            ((ViewGroup) this.f2090v.getParent()).removeView(this.f2090v);
            this.retain = true;
        }
        return this.f2090v;
    }

    private void setupLayout() {
        ((TCLauncher) getActivity()).setBackPressedListener(this);
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.photo, C1216LO.getLo(C1216LO.navigationColor)), 231));
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.save, C1216LO.getLo(C1216LO.navigationColor)), 111));
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
        this.f2091vp = (ViewPager) this.f2090v.findViewById(C0846R.C0847id.viewerpager);
        this.ivDeleteImage = (ImageView) findViewById(C0846R.C0847id.ivDeleteImage);
        this.etTitle = (EditText) findViewById(C0846R.C0847id.etTitle);
        this.etText = (EditText) findViewById(C0846R.C0847id.etText);
    }

    private void setupItem() {
        if (this.f2089id != null) {
            TCObject note = C1199DB.getFirstObject("note", DBFavorites.KEY_EVENT_ID, this.f2089id);
            this.initTitle = note.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            this.initText = note.get("text");
            this.etTitle.setText(note.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
            this.etText.setText(note.get("text"));
            this.typeid = note.get("typeid");
            try {
                if (ImageDB.getImage("note", this.f2089id).get(0).isFile()) {
                    this.ivDeleteImage.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            AddNoteFragment.this.deleteImage();
                        }
                    });
                    loadImage();
                }
            } catch (Exception e) {
            }
        } else {
            this.etTitle.post(new Runnable() {
                public void run() {
                    AddNoteFragment.this.etTitle.setText("");
                }
            });
            this.etText.post(new Runnable() {
                public void run() {
                    AddNoteFragment.this.etText.setText("");
                }
            });
            if (C1199DB.getSize("note") == 0) {
                this.f2089id = "1";
            } else {
                this.f2089id = String.valueOf(Integer.valueOf(C1199DB.getFirstObject("note", "id +0 DESC").get(DBFavorites.KEY_EVENT_ID)).intValue() + 1);
            }
        }
    }

    private View findViewById(int id) {
        return this.f2090v.findViewById(id);
    }

    public static AddNoteFragment newInstance(String type2, String typeid2) {
        return newInstance((String) null, type2, typeid2);
    }

    public static AddNoteFragment newInstance(String id, String type2, String typeid2) {
        AddNoteFragment note = new AddNoteFragment();
        note.type = type2;
        note.typeid = typeid2;
        note.f2089id = id;
        return note;
    }

    private void save() {
        if (!this.etTitle.getText().toString().isEmpty() && !this.etText.getText().toString().isEmpty()) {
            ContentValues cv = new ContentValues();
            if (!(this.type == null || this.typeid == null || this.type.equals("eventid"))) {
                cv.put(Globalization.TYPE, this.type);
                cv.put("typeid", this.typeid);
            }
            if (this.eventid != null) {
                cv.put("eventid", this.eventid);
            }
            cv.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.etTitle.getText().toString());
            cv.put("text", this.etText.getText().toString());
            String moduletypeid = "0";
            if (this.type != null) {
                if (this.type.equals(DBFavorites.TABLE_EXHIBITORS)) {
                    moduletypeid = "2";
                } else if (this.type.equals("sessions")) {
                    moduletypeid = "10";
                } else if (this.type.equals("sponsors")) {
                    moduletypeid = "19";
                } else if (this.type.equals("speakers")) {
                    moduletypeid = "40";
                } else if (this.type.equals(LinkedObjects.TABLE_ATT)) {
                    moduletypeid = "14";
                }
            }
            cv.put("moduletypeid", moduletypeid);
            if (C1199DB.getSize("note", DBFavorites.KEY_EVENT_ID, this.f2089id) != 0) {
                C1199DB.update("note", cv, "id='" + this.f2089id + "'");
            } else {
                cv.put(DBFavorites.KEY_EVENT_ID, this.f2089id);
                C1199DB.write("note", cv);
            }
        }
        if (this.initText == null && this.initTitle == null && this.etTitle.getText().toString().isEmpty() && this.etText.getText().toString().isEmpty()) {
            try {
                ImageDB.getImage("note", this.f2089id).get(0).delete();
                ImageDB.removeImage(this.imagename);
            } catch (Exception e) {
            }
        }
        this.hasBeenSaved = true;
        Fragments.back();
    }

    private void saveImage() {
        ImageDB.addImage(this.imagename, "note", this.f2089id);
    }

    private void takePicture() {
        Intent takePictureIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (!ImageDB.getPath().exists()) {
            ImageDB.getPath().mkdir();
            try {
                new File(ImageDB.getPath(), ".nomedia").createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.imagename = ImageDB.newImageName();
        takePictureIntent.putExtra("output", Uri.fromFile(new File(ImageDB.getPath(), this.imagename)));
        startActivityForResult(takePictureIntent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == -1) {
            saveImage();
            loadImage();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void loadImage() {
        if (this.f2089id != null) {
            List<File> listImages = ImageDB.getImage("note", this.f2089id);
            List<String> images = new ArrayList<>();
            if (listImages.size() != 0) {
                for (File image : listImages) {
                    images.add(image.getAbsolutePath());
                }
                this.f2091vp.setAdapter(new DetailImageViewpagerAdapter((Context) getActivity(), images, (LinearLayout) this.f2090v.findViewById(C0846R.C0847id.pager), true));
                this.f2091vp.setVisibility(0);
                this.ivDeleteImage.setVisibility(0);
                return;
            }
            this.f2091vp.setVisibility(8);
            this.ivDeleteImage.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void deleteImage() {
        AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
        ad.setMessage(C0846R.string.removepicture);
        ad.setPositiveButton(17039379, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                File image = ImageDB.getImage("note", AddNoteFragment.this.f2089id).get(AddNoteFragment.this.f2091vp.getCurrentItem());
                ImageDB.removeImage(image.getName());
                image.delete();
                AddNoteFragment.this.onActivityCreated((Bundle) null);
            }
        });
        ad.setNegativeButton(17039369, (DialogInterface.OnClickListener) null);
        ad.show();
    }

    public boolean onBackPressed() {
        if (this.hasBeenSaved || this.etTitle.getText().toString().isEmpty() || this.etText.getText().toString().isEmpty() || this.etTitle.getText().toString().equals(this.initTitle) || this.etText.getText().toString().equals(this.initText)) {
            return true;
        }
        save();
        return false;
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 111:
                save();
                return;
            case 231:
                takePicture();
                return;
            default:
                return;
        }
    }
}
