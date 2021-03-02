package com.google.android.gms.internal;

import com.google.android.gms.common.data.C0138b;
import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.internal.C0563fv;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.gg */
public final class C0586gg extends C0138b implements Person {
    public C0586gg(C0140d dVar, int i) {
        super(dVar, i);
    }

    /* renamed from: dX */
    public ArrayList<Person.Organizations> getOrganizations() {
        return null;
    }

    /* renamed from: dY */
    public ArrayList<Person.PlacesLived> getPlacesLived() {
        return null;
    }

    /* renamed from: dZ */
    public ArrayList<Person.Urls> getUrls() {
        return null;
    }

    /* renamed from: ea */
    public Person freeze() {
        return new C0563fv(getDisplayName(), getId(), (C0563fv.C0568c) getImage(), getObjectType(), getUrl());
    }

    public String getAboutMe() {
        return null;
    }

    public Person.AgeRange getAgeRange() {
        return null;
    }

    public String getBirthday() {
        return null;
    }

    public String getBraggingRights() {
        return null;
    }

    public int getCircledByCount() {
        return 0;
    }

    public Person.Cover getCover() {
        return null;
    }

    public String getCurrentLocation() {
        return null;
    }

    public String getDisplayName() {
        return getString("displayName");
    }

    public int getGender() {
        return 0;
    }

    public String getId() {
        return getString("personId");
    }

    public Person.Image getImage() {
        return new C0563fv.C0568c(getString("image"));
    }

    public String getLanguage() {
        return null;
    }

    public Person.Name getName() {
        return null;
    }

    public String getNickname() {
        return null;
    }

    public int getObjectType() {
        return C0563fv.C0570e.m1774aa(getString("objectType"));
    }

    public int getPlusOneCount() {
        return 0;
    }

    public int getRelationshipStatus() {
        return 0;
    }

    public String getTagline() {
        return null;
    }

    public String getUrl() {
        return getString(PlusShare.KEY_CALL_TO_ACTION_URL);
    }

    public boolean hasAboutMe() {
        return false;
    }

    public boolean hasAgeRange() {
        return false;
    }

    public boolean hasBirthday() {
        return false;
    }

    public boolean hasBraggingRights() {
        return false;
    }

    public boolean hasCircledByCount() {
        return false;
    }

    public boolean hasCover() {
        return false;
    }

    public boolean hasCurrentLocation() {
        return false;
    }

    public boolean hasDisplayName() {
        return true;
    }

    public boolean hasGender() {
        return false;
    }

    public boolean hasId() {
        return true;
    }

    public boolean hasImage() {
        return true;
    }

    public boolean hasIsPlusUser() {
        return false;
    }

    public boolean hasLanguage() {
        return false;
    }

    public boolean hasName() {
        return false;
    }

    public boolean hasNickname() {
        return false;
    }

    public boolean hasObjectType() {
        return true;
    }

    public boolean hasOrganizations() {
        return false;
    }

    public boolean hasPlacesLived() {
        return false;
    }

    public boolean hasPlusOneCount() {
        return false;
    }

    public boolean hasRelationshipStatus() {
        return false;
    }

    public boolean hasTagline() {
        return false;
    }

    public boolean hasUrl() {
        return true;
    }

    public boolean hasUrls() {
        return false;
    }

    public boolean hasVerified() {
        return false;
    }

    public boolean isPlusUser() {
        return false;
    }

    public boolean isVerified() {
        return false;
    }
}
