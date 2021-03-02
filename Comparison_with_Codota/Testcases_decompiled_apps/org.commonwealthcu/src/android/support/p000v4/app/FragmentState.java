package android.support.p000v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* renamed from: android.support.v4.app.FragmentState */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public final FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        public final FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    };
    final Bundle mArguments;
    final String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final int mIndex;
    Fragment mInstance;
    final boolean mRetainInstance;
    Bundle mSavedFragmentState;
    final String mTag;

    public FragmentState(Parcel parcel) {
        boolean z = true;
        this.mClassName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mFromLayout = parcel.readInt() != 0;
        this.mFragmentId = parcel.readInt();
        this.mContainerId = parcel.readInt();
        this.mTag = parcel.readString();
        this.mRetainInstance = parcel.readInt() != 0;
        this.mDetached = parcel.readInt() == 0 ? false : z;
        this.mArguments = parcel.readBundle();
        this.mSavedFragmentState = parcel.readBundle();
    }

    public FragmentState(Fragment fragment) {
        this.mClassName = fragment.getClass().getName();
        this.mIndex = fragment.mIndex;
        this.mFromLayout = fragment.mFromLayout;
        this.mFragmentId = fragment.mFragmentId;
        this.mContainerId = fragment.mContainerId;
        this.mTag = fragment.mTag;
        this.mRetainInstance = fragment.mRetainInstance;
        this.mDetached = fragment.mDetached;
        this.mArguments = fragment.mArguments;
    }

    public final int describeContents() {
        return 0;
    }

    public final Fragment instantiate(FragmentActivity fragmentActivity, Fragment fragment) {
        if (this.mInstance != null) {
            return this.mInstance;
        }
        if (this.mArguments != null) {
            this.mArguments.setClassLoader(fragmentActivity.getClassLoader());
        }
        this.mInstance = Fragment.instantiate(fragmentActivity, this.mClassName, this.mArguments);
        if (this.mSavedFragmentState != null) {
            this.mSavedFragmentState.setClassLoader(fragmentActivity.getClassLoader());
            this.mInstance.mSavedFragmentState = this.mSavedFragmentState;
        }
        this.mInstance.setIndex(this.mIndex, fragment);
        this.mInstance.mFromLayout = this.mFromLayout;
        this.mInstance.mRestored = true;
        this.mInstance.mFragmentId = this.mFragmentId;
        this.mInstance.mContainerId = this.mContainerId;
        this.mInstance.mTag = this.mTag;
        this.mInstance.mRetainInstance = this.mRetainInstance;
        this.mInstance.mDetached = this.mDetached;
        this.mInstance.mFragmentManager = fragmentActivity.mFragments;
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Instantiated fragment " + this.mInstance);
        }
        return this.mInstance;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.mClassName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mFromLayout ? 1 : 0);
        parcel.writeInt(this.mFragmentId);
        parcel.writeInt(this.mContainerId);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.mRetainInstance ? 1 : 0);
        if (!this.mDetached) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.mArguments);
        parcel.writeBundle(this.mSavedFragmentState);
    }
}
