package org.police.seraing.plantapolapps.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class ChambreModel implements Parcelable {

    private long   id;
    private String nom;
    private String longueur;
    private String largeur;
    private String nbPlants;
    private String nbPlantsM2;
    private String hauteurPlants;
    private String taillePots;
    private String nbLampes;
    private String puissanceLampes;
    private String marqueLampes;
    private String modifLampes;
    private String nbExtracteurs;
    private String marqueExtracteurs;
    private String nbFiltres;
    private String marqueFiltres;
    private String nbVentilateurs;
    private String marqueVentilateurs;
    private String puissanceVentilateurs;
    private String nbChauffages;
    private String marqueChauffages;
    private String puissanceChauffages;
    private long   ref_dossier;

    private List<PhotoModel> listPhotos = new ArrayList<PhotoModel>();

    public final static String OUI_MODIF = "OUI";
    public final static String NON_MODIF = "NON";

    public ChambreModel() {
    }

    public ChambreModel(long id, String nom, String longueur, String largeur, String nbPlants, String nbPlantsM2, String hauteurPlants, String taillePots, String nbLampes, String puissanceLampes, String marqueLampes, String modifLampes, String nbExtracteurs, String marqueExtracteurs, String nbFiltres, String marqueFiltres, String nbVentilateurs, String marqueVentilateurs, String puissanceVentilateurs, String nbChauffages, String marqueChauffages, String puissanceChauffages, long ref_dossier) {
        this.id = id;
        this.nom = nom;
        this.longueur = longueur;
        this.largeur = largeur;
        this.nbPlants = nbPlants;
        this.nbPlantsM2 = nbPlantsM2;
        this.hauteurPlants = hauteurPlants;
        this.taillePots = taillePots;
        this.nbLampes = nbLampes;
        this.puissanceLampes = puissanceLampes;
        this.marqueLampes = marqueLampes;
        this.modifLampes = modifLampes;
        this.nbExtracteurs = nbExtracteurs;
        this.marqueExtracteurs = marqueExtracteurs;
        this.nbFiltres = nbFiltres;
        this.marqueFiltres = marqueFiltres;
        this.nbVentilateurs = nbVentilateurs;
        this.marqueVentilateurs = marqueVentilateurs;
        this.puissanceVentilateurs = puissanceVentilateurs;
        this.nbChauffages = nbChauffages;
        this.marqueChauffages = marqueChauffages;
        this.puissanceChauffages = puissanceChauffages;
        this.ref_dossier = ref_dossier;
    }


    protected ChambreModel(Parcel in) {
        id = in.readLong();
        nom = in.readString();
        longueur = in.readString();
        largeur = in.readString();
        nbPlants = in.readString();
        nbPlantsM2 = in.readString();
        hauteurPlants = in.readString();
        taillePots = in.readString();
        nbLampes = in.readString();
        puissanceLampes = in.readString();
        marqueLampes = in.readString();
        modifLampes = in.readString();
        nbExtracteurs = in.readString();
        marqueExtracteurs = in.readString();
        nbFiltres = in.readString();
        marqueFiltres = in.readString();
        nbVentilateurs = in.readString();
        marqueVentilateurs = in.readString();
        puissanceVentilateurs = in.readString();
        nbChauffages = in.readString();
        marqueChauffages = in.readString();
        puissanceChauffages = in.readString();
        ref_dossier = in.readLong();
        listPhotos = in.createTypedArrayList(PhotoModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nom);
        dest.writeString(longueur);
        dest.writeString(largeur);
        dest.writeString(nbPlants);
        dest.writeString(nbPlantsM2);
        dest.writeString(hauteurPlants);
        dest.writeString(taillePots);
        dest.writeString(nbLampes);
        dest.writeString(puissanceLampes);
        dest.writeString(marqueLampes);
        dest.writeString(modifLampes);
        dest.writeString(nbExtracteurs);
        dest.writeString(marqueExtracteurs);
        dest.writeString(nbFiltres);
        dest.writeString(marqueFiltres);
        dest.writeString(nbVentilateurs);
        dest.writeString(marqueVentilateurs);
        dest.writeString(puissanceVentilateurs);
        dest.writeString(nbChauffages);
        dest.writeString(marqueChauffages);
        dest.writeString(puissanceChauffages);
        dest.writeLong(ref_dossier);
        dest.writeTypedList(listPhotos);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ChambreModel> CREATOR = new Creator<ChambreModel>() {
        @Override
        public ChambreModel createFromParcel(Parcel in) {
            return new ChambreModel(in);
        }

        @Override
        public ChambreModel[] newArray(int size) {
            return new ChambreModel[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModifLampes() {
        return modifLampes;
    }

    public void setModifLampes(String modifLampes) {
        this.modifLampes = modifLampes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLongueur() {
        return longueur;
    }

    public void setLongueur(String longueur) {
        this.longueur = longueur;
    }

    public String getLargeur() {
        return largeur;
    }

    public void setLargeur(String largeur) {
        this.largeur = largeur;
    }

    public String getNbPlants() {
        return nbPlants;
    }

    public void setNbPlants(String nbPlants) {
        this.nbPlants = nbPlants;
    }

    public String getNbPlantsM2() {
        return nbPlantsM2;
    }

    public void setNbPlantsM2(String nbPlantsM2) {
        this.nbPlantsM2 = nbPlantsM2;
    }

    public String getHauteurPlants() {
        return hauteurPlants;
    }

    public void setHauteurPlants(String hauteurPlants) {
        this.hauteurPlants = hauteurPlants;
    }

    public String getTaillePots() {
        return taillePots;
    }

    public void setTaillePots(String taillePots) {
        this.taillePots = taillePots;
    }

    public String getNbLampes() {
        return nbLampes;
    }

    public void setNbLampes(String nbLampes) {
        this.nbLampes = nbLampes;
    }

    public String getPuissanceLampes() {
        return puissanceLampes;
    }

    public void setPuissanceLampes(String puissanceLampes) {
        this.puissanceLampes = puissanceLampes;
    }

    public String getMarqueLampes() {
        return marqueLampes;
    }

    public void setMarqueLampes(String marqueLampes) {
        this.marqueLampes = marqueLampes;
    }

    public String getNbExtracteurs() {
        return nbExtracteurs;
    }

    public void setNbExtracteurs(String nbExtracteurs) {
        this.nbExtracteurs = nbExtracteurs;
    }

    public String getMarqueExtracteurs() {
        return marqueExtracteurs;
    }

    public void setMarqueExtracteurs(String marqueExtracteurs) {
        this.marqueExtracteurs = marqueExtracteurs;
    }

    public String getNbFiltres() {
        return nbFiltres;
    }

    public void setNbFiltres(String nbFiltres) {
        this.nbFiltres = nbFiltres;
    }


    public String getMarqueFiltres() {
        return marqueFiltres;
    }

    public void setMarqueFiltres(String marqueFiltres) {
        this.marqueFiltres = marqueFiltres;
    }

    public String getNbVentilateurs() {
        return nbVentilateurs;
    }

    public void setNbVentilateurs(String nbVentilateurs) {
        this.nbVentilateurs = nbVentilateurs;
    }

    public String getMarqueVentilateurs() {
        return marqueVentilateurs;
    }

    public void setMarqueVentilateurs(String marqueVentilateurs) {
        this.marqueVentilateurs = marqueVentilateurs;
    }

    public String getPuissanceVentilateurs() {
        return puissanceVentilateurs;
    }

    public void setPuissanceVentilateurs(String puissanceVentilateurs) {
        this.puissanceVentilateurs = puissanceVentilateurs;
    }

    public String getNbChauffages() {
        return nbChauffages;
    }

    public void setNbChauffages(String nbChauffages) {
        this.nbChauffages = nbChauffages;
    }

    public String getMarqueChauffages() {
        return marqueChauffages;
    }

    public void setMarqueChauffages(String marqueChauffages) {
        this.marqueChauffages = marqueChauffages;
    }

    public String getPuissanceChauffages() {
        return puissanceChauffages;
    }

    public void setPuissanceChauffages(String puissanceChauffages) {
        this.puissanceChauffages = puissanceChauffages;
    }

    public long getRef_dossier() {
        return ref_dossier;
    }

    public void setRef_dossier(long ref_dossier) {
        this.ref_dossier = ref_dossier;
    }

    public List<PhotoModel> getListPhotos() {
        return listPhotos;
    }

    public void setListPhotos(List<PhotoModel> listPhotos) {
        this.listPhotos = listPhotos;
    }

    public void addPhoto(PhotoModel photoModel){

        photoModel.setRef_chambre(this.getId());
        this.listPhotos.add(photoModel);
    }

    public void removePhoto(PhotoModel photoModel){
        this.listPhotos.remove(photoModel);
    }

    public static Creator<ChambreModel> getCREATOR() {
        return CREATOR;
    }


    @Override
    public String toString() {
        return getNom();
    }




}
