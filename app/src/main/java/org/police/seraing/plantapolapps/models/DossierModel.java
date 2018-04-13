package org.police.seraing.plantapolapps.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DossierModel implements Parcelable {

    private long id;

    private String nomDossier;

    private String  dateTime;

    private ArrayList listChambres = new ArrayList<ChambreModel>();

    private ArrayList<InstallationModel> listInstallations = new ArrayList<InstallationModel>();

    public DossierModel() {
    }

    public DossierModel(long id, String nomDossier,String dateTime) {
        this.id = id;
        this.nomDossier = nomDossier;
        this.dateTime = dateTime;

    }

    public DossierModel(Parcel in) {
        id = in.readLong();
        nomDossier = in.readString();
        dateTime = in.readString();
        listChambres = in.readArrayList(ClassLoader.getSystemClassLoader());
    }

    public static final Creator<DossierModel> CREATOR = new Creator<DossierModel>() {
        @Override
        public DossierModel createFromParcel(Parcel in) {
            return new DossierModel(in);
        }

        @Override
        public DossierModel[] newArray(int size) {
            return new DossierModel[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomDossier() {
        return nomDossier;
    }

    public void setNomDossier(String nomDossier) {
        this.nomDossier = nomDossier;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public ArrayList<ChambreModel> getListChambres() {
        return listChambres;
    }

    public void setListChambres(ArrayList<ChambreModel> listChambres) {
        this.listChambres = listChambres;
    }

    public ArrayList<InstallationModel> getListInstallations() {
        return listInstallations;
    }

    public void setListInstallations(ArrayList<InstallationModel> listInstallations) {
        this.listInstallations = listInstallations;
    }

    public boolean addChambre(ChambreModel chambreModel){
        return this.listChambres.add(chambreModel);
    }

    public boolean removeChambre(ChambreModel chambreModel){
        return this.listChambres.remove(chambreModel);
    }

    @Override
    public String toString() {
        return getNomDossier() + " " + getDateTime();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nomDossier);
        dest.writeString(dateTime);
        dest.writeList(listChambres);
    }
}
