package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

public abstract class AbsSavedState implements Parcelable {
    public static final Creator<AbsSavedState> CREATOR = ParcelableCompat.newCreator(new C01832());
    public static final AbsSavedState EMPTY_STATE = new C01821();
    private final Parcelable mSuperState;

    /* renamed from: android.support.v4.view.AbsSavedState$1 */
    static class C01821 extends AbsSavedState {
        C01821() {
            super();
        }
    }

    /* renamed from: android.support.v4.view.AbsSavedState$2 */
    static class C01832 implements ParcelableCompatCreatorCallbacks<AbsSavedState> {
        C01832() {
        }

        public AbsSavedState createFromParcel(Parcel in, ClassLoader loader) {
            if (in.readParcelable(loader) == null) {
                return AbsSavedState.EMPTY_STATE;
            }
            throw new IllegalStateException("superState must be null");
        }

        public AbsSavedState[] newArray(int size) {
            return new AbsSavedState[size];
        }
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    protected AbsSavedState(Parcelable superState) {
        if (superState == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (superState == EMPTY_STATE) {
            superState = null;
        }
        this.mSuperState = superState;
    }

    protected AbsSavedState(Parcel source) {
        this(source, null);
    }

    protected AbsSavedState(Parcel source, ClassLoader loader) {
        Parcelable superState = source.readParcelable(loader);
        if (superState == null) {
            superState = EMPTY_STATE;
        }
        this.mSuperState = superState;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mSuperState, flags);
    }
}
