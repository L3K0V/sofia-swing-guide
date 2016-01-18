package bg.lindyhop.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mmironov on 1/17/16.
 */
public class Competition implements Parcelable {

    private String name;
    private String description;
    private int resDrawable;

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.resDrawable);
    }

    public Competition() {
    }

    protected Competition(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.resDrawable = in.readInt();
    }

    public static final Parcelable.Creator<Competition> CREATOR = new Parcelable.Creator<Competition>() {
        public Competition createFromParcel(Parcel source) {
            return new Competition(source);
        }

        public Competition[] newArray(int size) {
            return new Competition[size];
        }
    };
}
