package p000;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.PictureKey;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.InspectionFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.controllers.PageFragment;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.view.ItemViewObserver;
import p006nl.volkerinfradesign.checkandroid.util.LongSparseBooleanArray;

/* renamed from: ij */
public final class C1256ij {

    /* renamed from: a */
    public final InspectionFragment f4406a;

    /* renamed from: b */
    final PageFragment f4407b;

    /* renamed from: c */
    public final InspectionKey f4408c;

    /* renamed from: d */
    public final String f4409d;

    /* renamed from: e */
    public final int f4410e;

    /* renamed from: f */
    final LongSparseBooleanArray f4411f;

    /* renamed from: g */
    public View f4412g;

    /* renamed from: h */
    public final ItemViewObserver f4413h = new ItemViewObserver() {
        public void onCustomLocationClicked(long j) {
            C1256ij.this.f4406a.showCustomLocationFragment(C1256ij.this.f4407b, C1256ij.this.f4407b.getItem(j));
        }

        public InspectionItemConstants.ItemCursor onInapplicableChanged(long j, boolean z) {
            InspectionItemConstants.ItemCursor item = C1256ij.this.f4407b.getItem(j);
            C1256ij.this.f4406a.setInapplicable(C1256ij.this.f4407b, item, z);
            return item;
        }

        public void onPictureClicked(long j, PictureKey pictureKey, int i) {
            C1256ij.this.f4406a.showPicture(C1256ij.this.f4407b, C1256ij.this.f4407b.getItem(j), pictureKey, i);
        }

        public void onPictureDeleteClicked(long j, PictureKey pictureKey) {
            C1256ij.this.f4406a.deletePicture(C1256ij.this.f4407b, C1256ij.this.f4407b.getItem(j), pictureKey);
        }

        public void onPicturePickerClicked(long j) {
            C1256ij.this.f4406a.pickPicture(C1256ij.this.f4407b, C1256ij.this.f4407b.getItem(j));
        }

        public InspectionItemConstants.ItemCursor onProjectSelected(long j, long j2) {
            InspectionItemConstants.ItemCursor item = C1256ij.this.f4407b.getItem(j);
            C1256ij.this.f4406a.setProjectSelected(C1256ij.this.f4407b, item, j2);
            return item;
        }

        public void onSubFormButtonClicked(long j) {
            InspectionItemConstants.ItemCursor item = C1256ij.this.f4407b.getItem(j);
            if (item.isTable()) {
                C1256ij.this.f4406a.showSubInspectionsList(C1256ij.this.f4407b, item);
            } else {
                C1256ij.this.f4406a.showSubInspection(C1256ij.this.f4407b, item);
            }
        }

        public void onTakePictureClicked(long j) {
            C1256ij.this.f4406a.takePicture(C1256ij.this.f4407b.getItem(j));
        }

        public void onTakeDrawingClicked(long j) {
            C1256ij.this.f4406a.takeDrawing(C1256ij.this.f4407b.getItem(j));
        }

        public void onMoreProjectsClicked(long j) {
            C1256ij.this.f4406a.showProjectDetails(C1256ij.this.f4407b, C1256ij.this.f4407b.getItem(j));
        }

        public void onRemarkClicked(long j) {
            C1256ij.this.f4406a.changeRemark(C1256ij.this.f4407b, C1256ij.this.f4407b.getItem(j));
        }

        public void onInputButtonClicked(long j) {
            C1256ij.this.f4406a.showInputDialog(C1256ij.this.f4407b, C1256ij.this.f4407b.getItem(j));
        }

        public void onDescriptiveImageClicked(long j) {
            C1256ij.this.f4406a.showDescriptiveImage(C1256ij.this.f4407b, C1256ij.this.f4407b.getItem(j));
        }

        public InspectionItemConstants.ItemCursor onValueChanged(Object obj, long j) {
            InspectionItemConstants.ItemCursor item = C1256ij.this.f4407b.getItem(j);
            C1256ij.this.f4406a.setValue(C1256ij.this.f4407b, item, obj);
            return item;
        }

        public void onMoreOptionsClicked(long j, boolean z) {
            C1256ij.this.f4411f.put(j, Boolean.valueOf(z));
        }

        public void onTakeSignatureClicked(long j) {
            C1256ij.this.f4406a.onTakeSignatureClicked(C1256ij.this.f4407b.getItem(j));
        }
    };

    /* renamed from: a */
    public boolean mo8572a(InspectionItemConstants.ItemCursor itemCursor) {
        return ((Boolean) this.f4411f.get(itemCursor.getId(), false)).booleanValue();
    }

    /* renamed from: a */
    public static Bundle m5555a(InspectionKey inspectionKey, String str, int i) {
        Bundle bundle = new Bundle(3);
        bundle.putParcelable("inspection_3_params:inspection_key", inspectionKey);
        bundle.putString("inspection_3_params:title", str);
        bundle.putInt("inspection_3_params:position", i);
        return bundle;
    }

    public C1256ij(InspectionFragment inspectionFragment, PageFragment pageFragment, Bundle bundle, Bundle bundle2) {
        this.f4406a = inspectionFragment;
        this.f4407b = pageFragment;
        this.f4408c = (InspectionKey) bundle.getParcelable("inspection_3_params:inspection_key");
        this.f4409d = bundle.getString("inspection_3_params:title");
        this.f4410e = bundle.getInt("inspection_3_params:position");
        if (bundle2 != null) {
            this.f4411f = (LongSparseBooleanArray) bundle2.getParcelable("inspection_3_params:expanded_options");
        } else {
            this.f4411f = new LongSparseBooleanArray();
        }
    }

    /* renamed from: a */
    public boolean mo8571a() {
        return this.f4406a.isPreview();
    }

    /* renamed from: b */
    public boolean mo8574b() {
        return this.f4406a.markInvalidItems();
    }

    /* renamed from: c */
    public void mo8575c() {
        boolean z;
        int i;
        int i2;
        int i3 = 0;
        if (this.f4412g != null) {
            boolean z2 = this.f4410e > 0;
            float f = this.f4408c.getprogress();
            if (f >= 1.0f) {
                z = true;
            } else {
                z = false;
            }
            Button button = (Button) this.f4412g.findViewById(C1352R.C1354id.sendButton);
            Button button2 = (Button) this.f4412g.findViewById(C1352R.C1354id.backButton);
            ProgressBar progressBar = (ProgressBar) this.f4412g.findViewById(C1352R.C1354id.progress);
            View findViewById = this.f4412g.findViewById(C1352R.C1354id.descContainer);
            if (mo8571a()) {
                findViewById.setVisibility(8);
                button.setVisibility(8);
                button2.setVisibility(8);
                progressBar.setVisibility(8);
                return;
            }
            View findViewById2 = findViewById.findViewById(C1352R.C1354id.itemsValid);
            View findViewById3 = findViewById.findViewById(C1352R.C1354id.itemsInvalid);
            View findViewById4 = findViewById.findViewById(C1352R.C1354id.subItemsValid);
            findViewById.setVisibility(0);
            progressBar.setVisibility(0);
            progressBar.setProgress((int) (f * ((float) progressBar.getMax())));
            if (z2) {
                button.setVisibility(8);
                button2.setVisibility(0);
                button2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        C1256ij.this.f4406a.popSubForm(C1256ij.this.f4407b, C1256ij.this.f4410e);
                    }
                });
                findViewById2.setVisibility(4);
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 4;
                }
                findViewById4.setVisibility(i2);
                if (z) {
                    i3 = 4;
                }
                findViewById3.setVisibility(i3);
                return;
            }
            button.setVisibility(0);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    C1256ij.this.f4406a.getParent().onSendInspectionClicked(C1256ij.this.f4406a, C1256ij.this.f4408c, C1256ij.this.f4406a.getLocation());
                }
            });
            button2.setVisibility(8);
            findViewById4.setVisibility(4);
            if (z) {
                i = 0;
            } else {
                i = 4;
            }
            findViewById2.setVisibility(i);
            if (z) {
                i3 = 4;
            }
            findViewById3.setVisibility(i3);
        }
    }

    /* renamed from: a */
    public void mo8570a(ListView listView) {
        listView.setDividerHeight(0);
        listView.setFooterDividersEnabled(false);
        listView.setHeaderDividersEnabled(false);
    }

    /* renamed from: a */
    public String mo8566a(String str) {
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = this.f4409d != null ? this.f4409d : "<no title>";
        objArr[2] = Integer.valueOf(this.f4410e);
        return String.format("%s, title=%s, position=%d", objArr);
    }

    /* renamed from: a */
    public void mo8569a(Menu menu, MenuInflater menuInflater) {
        if (!mo8571a() && !this.f4408c.isSubInspection()) {
            menuInflater.inflate(C1352R.C1355menu.inspection_options, menu);
        }
    }

    /* renamed from: a */
    public void mo8568a(Menu menu) {
        boolean z;
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (mo8571a() || this.f4408c.isSubInspection()) {
                z = false;
            } else {
                z = true;
            }
            item.setVisible(z);
        }
    }

    /* renamed from: a */
    public boolean mo8573a(PageFragment pageFragment, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            this.f4406a.getActivity().onBackPressed();
            return true;
        } else if (itemId == C1352R.C1354id.send) {
            this.f4406a.onSendInspectionClicked(pageFragment);
            return true;
        } else if (itemId != C1352R.C1354id.delete) {
            return false;
        } else {
            this.f4406a.onDeleteInspectionClicked(this.f4407b);
            return true;
        }
    }

    /* renamed from: a */
    public void mo8567a(Bundle bundle) {
        bundle.putParcelable("inspection_3_params:expanded_options", this.f4411f);
    }
}
