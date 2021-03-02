package com.tapcrowd.app.modules.notes;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.ListFragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.ImageDB;
import com.tapcrowd.app.utils.SwipeDismissListViewTouchListenerDerp;
import com.tapcrowd.app.utils.TCCheckboxAdapter;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.views.SearchBar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.apache.cordova.Globalization;

public class NotesFragment extends TCListFragment implements MenuFragment.MenuItemListener {
    /* access modifiers changed from: private */
    public static final String eventid = App.curEventId;
    private final int NEW_NOTE = 325;
    private final int REMOVE_NOTE = 327;
    private final int SELECT_ALL = 375;
    private final int SEND_MAIL = 347;
    /* access modifiers changed from: private */
    public TCCheckboxAdapter adapter;
    private CallbackHelper callback;
    /* access modifiers changed from: private */
    public boolean hasCAB = false;
    /* access modifiers changed from: private */
    public List<Object> listNotes;
    /* access modifiers changed from: private */
    public List<Object> listToDelete = new ArrayList();
    private MenuFragment menu;
    private boolean retain;
    /* access modifiers changed from: private */
    public SearchBar searchbar;
    /* access modifiers changed from: private */
    public List<String> selectedIds = new ArrayList();
    /* access modifiers changed from: private */
    public SwipeDismissListViewTouchListenerDerp touchListener;
    /* access modifiers changed from: private */
    public String type;
    /* access modifiers changed from: private */
    public String typeid;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public View f2094v;

    public static NotesFragment newInstance() {
        return newInstance((String) null, (String) null);
    }

    public static NotesFragment newInstance(String type2, String typeid2) {
        NotesFragment fragment = new NotesFragment();
        fragment.type = type2;
        fragment.typeid = typeid2;
        return fragment;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showList();
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes_nav, C1216LO.getLo(C1216LO.navigationColor)), 325));
        this.menu = MenuFragment.newInstance(menuitems, this);
        Fragments.addMenu(this, this.menu);
        AdHelper.showAds(this, AdHelper.buildPath("35", "list", (String) null));
        if (!this.retain) {
            setupLayout();
        }
    }

    private void setupLayout() {
        if (this.type != null && !this.type.equals("eventid")) {
            GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{C1216LO.getLo(C1216LO.buttonBackgroundColor), C1216LO.getLo(C1216LO.buttonBackgroundColor)});
            drawable.setCornerRadius(15.0f);
            drawable.setStroke(4, C1216LO.getLo(C1216LO.bordercolorButtons));
            new LinearLayout.LayoutParams(-2, -2).setMargins(8, 8, 8, 8);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2094v == null) {
            this.f2094v = inflater.inflate(C0846R.layout.listview, container, false);
        } else {
            ((ViewGroup) this.f2094v.getParent()).removeView(this.f2094v);
            this.retain = true;
        }
        return this.f2094v;
    }

    /* access modifiers changed from: private */
    public void refreshList() {
        ((TCCheckboxAdapter) getListAdapter()).notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public void showList() {
        new LoadListTask(this, (LoadListTask) null).execute(new Void[0]);
    }

    private class LoadListTask extends AsyncTask<Void, Void, Void> {
        private LoadListTask() {
        }

        /* synthetic */ LoadListTask(NotesFragment notesFragment, LoadListTask loadListTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            String s;
            if (NotesFragment.this.type == null || NotesFragment.this.type.equals("eventid")) {
                NotesFragment.this.listNotes = new ArrayList();
                for (TCObject note : C1199DB.getListFromDb("note", "eventid", NotesFragment.eventid, "id+0 DESC")) {
                    if (note.has(Globalization.TYPE)) {
                        TCObject tco = C1199DB.getFirstObject(note.get(Globalization.TYPE), DBFavorites.KEY_EVENT_ID, note.get("typeid"));
                        s = tco.get(DBFavorites.KEY_NAME, tco.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, ""));
                    } else {
                        s = "Note";
                    }
                    NotesFragment.this.listNotes.add(new TCListObject(note.get(DBFavorites.KEY_EVENT_ID), note.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), s, (String) null, (String) null));
                }
            } else {
                NotesFragment.this.listNotes = new ArrayList();
                for (TCObject note2 : C1199DB.getListFromDb("note", "typeid ='" + NotesFragment.this.typeid + "' AND type ='" + NotesFragment.this.type + "' AND eventid", NotesFragment.eventid, "id+0 DESC")) {
                    NotesFragment.this.listNotes.add(new TCListObject(note2.get(DBFavorites.KEY_EVENT_ID), note2.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), (String) null, (String) null, (String) null));
                }
            }
            if (NotesFragment.this.listToDelete.size() != 0) {
                NotesFragment.this.listNotes.removeAll(NotesFragment.this.listToDelete);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (NotesFragment.this.isAdded()) {
                NotesFragment.this.getListView().setChoiceMode(2);
                if (NotesFragment.this.searchbar == null) {
                    NotesFragment.this.searchbar = new SearchBar((Context) NotesFragment.this.getActivity(), (ListFragment) NotesFragment.this);
                    NotesFragment.this.getListView().addHeaderView(NotesFragment.this.searchbar);
                }
                NotesFragment.this.adapter = new TCCheckboxAdapter(NotesFragment.this.listNotes, new TCCheckboxAdapter.onCheckboxClickListener() {
                    public void onCheckboxClicked(List<String> ids) {
                        NotesFragment.this.selectedIds.clear();
                        NotesFragment.this.selectedIds.addAll(new LinkedHashSet(ids));
                        NotesFragment.this.checkSelectedIds();
                    }
                });
                NotesFragment.this.setListAdapter(NotesFragment.this.adapter);
                if (NotesFragment.this.listNotes.size() == 0) {
                    NotesFragment.this.f2094v.findViewById(C0846R.C0847id.emptycontainer).setVisibility(0);
                    ((ImageView) NotesFragment.this.f2094v.findViewById(C0846R.C0847id.emptyimg)).setImageResource(C0846R.drawable.no_notes);
                    return;
                }
                NotesFragment.this.f2094v.findViewById(C0846R.C0847id.emptycontainer).setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void checkSelectedIds() {
        if (this.selectedIds.isEmpty()) {
            if (this.hasCAB) {
                this.callback.close();
            }
        } else if (this.selectedIds.size() >= 1 && !this.hasCAB) {
            this.callback = new CallbackHelper(this, (CallbackHelper) null);
            this.callback.setMenu(375, 347, 327);
            getSherlockActivity().startActionMode(this.callback);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: com.tapcrowd.app.utils.TCListObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.tapcrowd.app.utils.TCListObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onListItemClick(android.widget.ListView r11, android.view.View r12, int r13, long r14) {
        /*
            r10 = this;
            r7 = 0
            java.lang.Object r5 = r11.getItemAtPosition(r13)
            java.lang.Class r6 = r5.getClass()
            java.lang.Class<com.tapcrowd.app.utils.TCListObject> r8 = com.tapcrowd.app.utils.TCListObject.class
            if (r6 != r8) goto L_0x0037
            r4 = r5
            com.tapcrowd.app.utils.TCListObject r4 = (com.tapcrowd.app.utils.TCListObject) r4
            com.tapcrowd.app.utils.TCListObject r2 = new com.tapcrowd.app.utils.TCListObject
            r2.<init>()
            r1 = 0
            java.util.List<java.lang.Object> r6 = r10.listToDelete
            java.util.Iterator r8 = r6.iterator()
        L_0x001c:
            boolean r6 = r8.hasNext()
            if (r6 != 0) goto L_0x0038
            if (r1 == 0) goto L_0x004e
            r4.setRemove(r7)
            java.util.List<java.lang.Object> r6 = r10.listToDelete
            r6.remove(r2)
            com.tapcrowd.app.utils.SwipeDismissListViewTouchListenerDerp r6 = r10.touchListener
            r6.setFirst()
            r10.refreshList()
            r10.checkSelectedIds()
        L_0x0037:
            return
        L_0x0038:
            java.lang.Object r3 = r8.next()
            r6 = r3
            com.tapcrowd.app.utils.TCListObject r6 = (com.tapcrowd.app.utils.TCListObject) r6
            java.lang.String r6 = r6.getId()
            java.lang.String r9 = r4.getId()
            if (r6 != r9) goto L_0x001c
            r1 = 1
            r2 = r3
            com.tapcrowd.app.utils.TCListObject r2 = (com.tapcrowd.app.utils.TCListObject) r2
            goto L_0x001c
        L_0x004e:
            java.util.List<java.lang.String> r6 = r10.selectedIds
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x006c
            r6 = 2131361960(0x7f0a00a8, float:1.8343687E38)
            android.view.View r0 = r12.findViewById(r6)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            boolean r6 = r0.isChecked()
            if (r6 == 0) goto L_0x006a
            r6 = r7
        L_0x0066:
            r0.setChecked(r6)
            goto L_0x0037
        L_0x006a:
            r6 = 1
            goto L_0x0066
        L_0x006c:
            boolean r6 = r10.hasCAB
            if (r6 == 0) goto L_0x0075
            com.tapcrowd.app.modules.notes.NotesFragment$CallbackHelper r6 = r10.callback
            r6.close()
        L_0x0075:
            java.lang.String r6 = r4.getId()
            com.tapcrowd.app.modules.notes.NoteDetailFragment r6 = com.tapcrowd.app.modules.notes.NoteDetailFragment.newInstance(r6)
            java.lang.String r7 = r4.getText()
            com.tapcrowd.app.utils.Fragments.add(r10, r6, r7)
            goto L_0x0037
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapcrowd.app.modules.notes.NotesFragment.onListItemClick(android.widget.ListView, android.view.View, int, long):void");
    }

    public void onPause() {
        Iterator i = this.listToDelete.iterator();
        while (i.hasNext()) {
            removeListNote((TCListObject) i.next(), i);
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        ListView listView = getListView();
        this.touchListener = new SwipeDismissListViewTouchListenerDerp(listView, new SwipeDismissListViewTouchListenerDerp.DismissCallbacks() {
            public boolean canDismiss(int position) {
                Object o = NotesFragment.this.getListView().getItemAtPosition(position);
                if (o.getClass() != TCListObject.class || ((TCListObject) o).getRemove()) {
                    return true;
                }
                NotesFragment.this.touchListener.setFirst();
                return true;
            }

            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                for (int position : reverseSortedPositions) {
                    NotesFragment.this.selectedIds.clear();
                    Object o = listView.getItemAtPosition(position);
                    if (o.getClass() == TCListObject.class) {
                        TCListObject tlo = (TCListObject) o;
                        if (tlo.getRemove()) {
                            NotesFragment.this.removeListNote(tlo);
                        } else {
                            NotesFragment.this.listToDelete.add(o);
                            tlo.setRemove(true);
                        }
                    }
                }
                NotesFragment.this.refreshList();
                NotesFragment.this.checkSelectedIds();
            }
        });
        listView.setOnTouchListener(this.touchListener);
        listView.setOnScrollListener(this.touchListener.makeScrollListener());
    }

    /* access modifiers changed from: private */
    public void removeListNote(TCListObject tlo) {
        C1199DB.remove("note", DBFavorites.KEY_EVENT_ID, tlo.getId());
        deleteImage(tlo.getId());
        Iterator<Object> i = this.listToDelete.iterator();
        while (i.hasNext()) {
            if (((TCListObject) i.next()).getId() == tlo.getId()) {
                i.remove();
            }
        }
        this.listNotes.remove(tlo);
        this.adapter.remove(tlo);
        this.adapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public void removeListNote(TCListObject tlo, Iterator<Object> iterator) {
        C1199DB.remove("note", DBFavorites.KEY_EVENT_ID, tlo.getId());
        deleteImage(tlo.getId());
        iterator.remove();
        for (Object o : this.listToDelete) {
            if (((TCListObject) o).getId() == tlo.getId()) {
                this.listToDelete.remove((TCListObject) o);
            }
        }
    }

    private void deleteImage(String id) {
        try {
            ImageDB.getImage("note", id).get(0).delete();
            ImageDB.removeImage("note", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void sendMail() {
        String html = "";
        String value = "2' ";
        for (String id : this.selectedIds) {
            value = String.valueOf(value) + " or id = '" + id + "'";
        }
        String value2 = value.substring(0, value.length() - 1);
        new ArrayList();
        List<TCObject> notes = C1199DB.getListFromDb("note", "1", value2);
        ArrayList<Uri> uris = new ArrayList<>();
        if (!notes.isEmpty()) {
            for (TCObject note : notes) {
                TCObject item = new TCObject();
                if (note.has(Globalization.TYPE)) {
                    item = C1199DB.getFirstObject(note.get(Globalization.TYPE), DBFavorites.KEY_EVENT_ID, note.get("typeid"));
                }
                String html2 = String.valueOf(String.valueOf(html) + "<p>") + "<span style=\"font-size:120%;\"><b>" + note.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE) + "</b></span><br/>";
                if (item.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE) || item.has(DBFavorites.KEY_NAME)) {
                    html2 = String.valueOf(html2) + "<span style=\"font-size:80%;\">" + item.get(DBFavorites.KEY_NAME, item.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) + "</span><br/>";
                }
                html = String.valueOf(String.valueOf(html2) + note.get("text") + "<br/>") + "</p>";
                List<File> listImages = ImageDB.getImage("note", note.get(DBFavorites.KEY_EVENT_ID));
                if (!listImages.isEmpty() && !new File(ImageDB.getPath() + "/delete").exists()) {
                    new File(ImageDB.getPath() + "/delete").mkdir();
                }
                for (File image : listImages) {
                    try {
                        File img = File.createTempFile("IMG_" + note.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE) + "_", ".png", new File(String.valueOf(image.getParent()) + "/delete"));
                        img.deleteOnExit();
                        copyFile(image, img);
                        uris.add(Uri.fromFile(img));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        ArrayList<String> contentlist = new ArrayList<>();
        contentlist.add(Html.fromHtml(html).toString());
        Actions.doMail(this, "", contentlist, uris);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 777) {
            File dir = new File(ImageDB.getPath() + "/delete");
            if (dir.exists()) {
                String[] children = dir.list();
                for (String file : children) {
                    new File(dir, file).delete();
                }
                dir.delete();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void copyFile(File src, File dst) throws IOException {
        FileChannel inChannel = new FileInputStream(src).getChannel();
        FileChannel outChannel = new FileOutputStream(dst).getChannel();
        try {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } finally {
            if (inChannel != null) {
                inChannel.close();
            }
            if (outChannel != null) {
                outChannel.close();
            }
        }
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 325:
                if (this.type == null || this.typeid == null) {
                    Fragments.add(this, AddNoteFragment.newInstance("note", (String) null), "");
                    return;
                } else {
                    Fragments.add(this, AddNoteFragment.newInstance(this.type, this.typeid), "");
                    return;
                }
            default:
                return;
        }
    }

    private class CallbackHelper implements ActionMode.Callback {

        /* renamed from: id */
        private int[] f2095id;

        private CallbackHelper() {
        }

        /* synthetic */ CallbackHelper(NotesFragment notesFragment, CallbackHelper callbackHelper) {
            this();
        }

        public void setMenu(int... id) {
            this.f2095id = id;
        }

        public void close() {
            Fragments.mode.finish();
        }

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            NotesFragment.this.hasCAB = true;
            for (int i : this.f2095id) {
                if (i == 375) {
                    menu.add(0, 375, 0, (CharSequence) "Select all").setIcon(C1232UI.getColorOverlay((int) C0846R.drawable.icon_vinkje, C1216LO.getLo(C1216LO.navigationColor)));
                }
                if (i == 325) {
                    menu.add(0, 325, 0, (CharSequence) "New note").setIcon(C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes_nav, C1216LO.getLo(C1216LO.navigationColor)));
                }
                if (i == 347) {
                    menu.add(0, 347, 0, (CharSequence) "Mail").setIcon(C1232UI.getColorOverlay((int) C0846R.drawable.icon_email, C1216LO.getLo(C1216LO.navigationColor)));
                }
                if (i == 327) {
                    menu.add(0, 327, 0, (CharSequence) "Remove").setIcon(C1232UI.getColorOverlay((int) C0846R.drawable.delete, C1216LO.getLo(C1216LO.navigationColor)));
                }
            }
            Fragments.mode = mode;
            return true;
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case 325:
                    if (NotesFragment.this.type == null || NotesFragment.this.typeid == null) {
                        Fragments.add(NotesFragment.this, AddNoteFragment.newInstance("note", (String) null), "");
                    } else {
                        Fragments.add(NotesFragment.this, AddNoteFragment.newInstance(NotesFragment.this.type, NotesFragment.this.typeid), "");
                    }
                    mode.finish();
                    return false;
                case 327:
                    Iterator<String> itid = NotesFragment.this.selectedIds.iterator();
                    while (itid.hasNext()) {
                        String id = itid.next();
                        Iterator i = NotesFragment.this.listNotes.iterator();
                        while (i.hasNext()) {
                            Object o = i.next();
                            if (((TCListObject) o).getId() == id) {
                                NotesFragment.this.removeListNote((TCListObject) o, i);
                                itid.remove();
                            }
                        }
                    }
                    NotesFragment.this.showList();
                    NotesFragment.this.checkSelectedIds();
                    mode.finish();
                    return false;
                case 347:
                    NotesFragment.this.sendMail();
                    mode.finish();
                    return false;
                case 375:
                    if (NotesFragment.this.selectedIds.size() == NotesFragment.this.getListAdapter().getCount()) {
                        close();
                        return false;
                    }
                    NotesFragment.this.selectedIds = new ArrayList();
                    ListView list = NotesFragment.this.getListView();
                    for (int i2 = 0; i2 < NotesFragment.this.getListAdapter().getCount(); i2++) {
                        try {
                            ((CheckBox) ((ViewGroup) list.getChildAt(i2)).findViewById(C0846R.C0847id.checkbox)).setChecked(true);
                            NotesFragment.this.selectedIds.add(((TCObject) NotesFragment.this.listNotes.get(i2)).get(DBFavorites.KEY_EVENT_ID));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return false;
                default:
                    mode.finish();
                    return false;
            }
        }

        public void onDestroyActionMode(ActionMode mode) {
            NotesFragment.this.setAllCheckboxes(false);
            NotesFragment.this.hasCAB = false;
        }
    }

    /* access modifiers changed from: private */
    public void setAllCheckboxes(boolean setThemTo) {
        try {
            ListView list = getListView();
            for (int i = 0; i < getListAdapter().getCount(); i++) {
                try {
                    ((CheckBox) ((ViewGroup) list.getChildAt(i)).findViewById(C0846R.C0847id.checkbox)).setChecked(setThemTo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
        }
    }
}
