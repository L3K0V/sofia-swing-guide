package bg.lindyhop.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mmironov on 1/4/16.
 */
public class Teacher implements Parcelable {

    public static final String KEY_EXTRA = "keyExtra";

    private String name;
    private String description;
    private int resDrawable;

    private boolean isFeatured;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResDrawable() {
        return resDrawable;
    }

    public void setResDrawable(int resDrawable) {
        this.resDrawable = resDrawable;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    public Teacher() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.resDrawable);
        dest.writeByte(isFeatured ? (byte) 1 : (byte) 0);
    }

    protected Teacher(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.resDrawable = in.readInt();
        this.isFeatured = in.readByte() != 0;
    }

    public static final Creator<Teacher> CREATOR = new Creator<Teacher>() {
        public Teacher createFromParcel(Parcel source) {
            return new Teacher(source);
        }

        public Teacher[] newArray(int size) {
            return new Teacher[size];
        }
    };
}
