package org.police.seraing.plantapolapps.models;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class PhotoModel implements Parcelable {

    private long id;

    private byte[] raw;

    private int width;

    private int height;

    private long ref_chambre;




    public PhotoModel( byte[] raw) {
        this.raw = raw;
    }


    protected PhotoModel(Parcel in) {
        id = in.readLong();
        raw = in.createByteArray();
        width = in.readInt();
        height = in.readInt();
        ref_chambre = in.readLong();
    }

    public static final Creator<PhotoModel> CREATOR = new Creator<PhotoModel>() {
        @Override
        public PhotoModel createFromParcel(Parcel in) {
            return new PhotoModel(in);
        }

        @Override
        public PhotoModel[] newArray(int size) {
            return new PhotoModel[size];
        }
    };

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getRaw() {
        return raw;
    }

    public void setRaw(byte[] raw) {
        this.raw = raw;
    }

    public long getRef_chambre() {
        return ref_chambre;
    }

    public void setRef_chambre(long ref_chambre) {
        this.ref_chambre = ref_chambre;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeByteArray(raw);
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeLong(ref_chambre);
    }
}
