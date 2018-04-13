package org.police.seraing.plantapolapps.models;

import android.os.Parcel;
import android.os.Parcelable;

public class InstallationModel implements Parcelable {

    private String nom;

    public InstallationModel() {
    }

    protected InstallationModel(Parcel in) {
        nom = in.readString();
    }

    public static final Creator<InstallationModel> CREATOR = new Creator<InstallationModel>() {
        @Override
        public InstallationModel createFromParcel(Parcel in) {
            return new InstallationModel(in);
        }

        @Override
        public InstallationModel[] newArray(int size) {
            return new InstallationModel[size];
        }
    };

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
    }
}
