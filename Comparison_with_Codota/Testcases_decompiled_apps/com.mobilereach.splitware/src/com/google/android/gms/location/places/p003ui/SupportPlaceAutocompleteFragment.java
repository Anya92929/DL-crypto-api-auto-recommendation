package com.google.android.gms.location.places.p003ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.gms.C0171R;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.p003ui.PlaceAutocomplete;
import com.google.android.gms.maps.model.LatLngBounds;

/* renamed from: com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment */
public class SupportPlaceAutocompleteFragment extends Fragment {
    private View zzaRh;
    private View zzaRi;
    private EditText zzaRj;
    @Nullable
    private LatLngBounds zzaRk;
    @Nullable
    private AutocompleteFilter zzaRl;
    @Nullable
    private PlaceSelectionListener zzaRm;

    private void zzzF() {
        int i = 0;
        boolean z = !this.zzaRj.getText().toString().isEmpty();
        View view = this.zzaRi;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    /* access modifiers changed from: private */
    public void zzzG() {
        int i;
        try {
            startActivityForResult(new PlaceAutocomplete.IntentBuilder(2).setBoundsBias(this.zzaRk).setFilter(this.zzaRl).zzeq(this.zzaRj.getText().toString()).zzig(1).build(getActivity()), 1);
            i = -1;
        } catch (GooglePlayServicesRepairableException e) {
            int connectionStatusCode = e.getConnectionStatusCode();
            Log.e("Places", "Could not open autocomplete activity", e);
            i = connectionStatusCode;
        } catch (GooglePlayServicesNotAvailableException e2) {
            int i2 = e2.errorCode;
            Log.e("Places", "Could not open autocomplete activity", e2);
            i = i2;
        }
        if (i != -1) {
            GoogleApiAvailability.getInstance().showErrorDialogFragment(getActivity(), i, 2);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == -1) {
                Place place = PlaceAutocomplete.getPlace(getActivity(), data);
                if (this.zzaRm != null) {
                    this.zzaRm.onPlaceSelected(place);
                }
                setText(place.getName().toString());
            } else if (resultCode == 2) {
                Status status = PlaceAutocomplete.getStatus(getActivity(), data);
                if (this.zzaRm != null) {
                    this.zzaRm.onError(status);
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(C0171R.layout.place_autocomplete_fragment, container, false);
        this.zzaRh = inflate.findViewById(C0171R.C0173id.place_autocomplete_search_button);
        this.zzaRi = inflate.findViewById(C0171R.C0173id.place_autocomplete_clear_button);
        this.zzaRj = (EditText) inflate.findViewById(C0171R.C0173id.place_autocomplete_search_input);
        C02801 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                SupportPlaceAutocompleteFragment.this.zzzG();
            }
        };
        this.zzaRh.setOnClickListener(r0);
        this.zzaRj.setOnClickListener(r0);
        this.zzaRi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SupportPlaceAutocompleteFragment.this.setText("");
            }
        });
        zzzF();
        return inflate;
    }

    public void onDestroyView() {
        this.zzaRh = null;
        this.zzaRi = null;
        this.zzaRj = null;
        super.onDestroyView();
    }

    public void setBoundsBias(@Nullable LatLngBounds bounds) {
        this.zzaRk = bounds;
    }

    public void setFilter(@Nullable AutocompleteFilter filter) {
        this.zzaRl = filter;
    }

    public void setHint(CharSequence hint) {
        this.zzaRj.setHint(hint);
        this.zzaRh.setContentDescription(hint);
    }

    public void setOnPlaceSelectedListener(PlaceSelectionListener listener) {
        this.zzaRm = listener;
    }

    public void setText(CharSequence text) {
        this.zzaRj.setText(text);
        zzzF();
    }
}
