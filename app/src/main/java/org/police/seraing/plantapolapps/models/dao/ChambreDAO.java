package org.police.seraing.plantapolapps.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.TextView;

import org.police.seraing.plantapolapps.models.ChambreModel;

import java.util.ArrayList;
import java.util.List;

public class ChambreDAO extends DAO<ChambreModel> {

    public static final String TABLE_NAME = "t_chambres";

    public ChambreDAO(SQLiteCustom connection, Context context) {
        super(connection, context);
    }

    @Override
    public ChambreModel insert(ChambreModel model) {

        ContentValues value = new ContentValues();
        value.put("nom",model.getNom());
        value.put("longueur",model.getLongueur());
        value.put("largeur",model.getLargeur());
        value.put("nbPlants",model.getNbPlants());
        value.put("nbPlantsM2",model.getNbPlantsM2());
        value.put("hauteurPlants",model.getHauteurPlants());
        value.put("taillePots",model.getHauteurPlants());
        value.put("nbLampes",model.getHauteurPlants());
        value.put("puissanceLampes",model.getHauteurPlants());
        value.put("marqueLampes",model.getHauteurPlants());
        value.put("modifLampes",model.getHauteurPlants());
        value.put("nbExtracteurs",model.getHauteurPlants());
        value.put("marqueExtracteurs",model.getHauteurPlants());
        value.put("nbFiltres",model.getHauteurPlants());
        value.put("nbVentilateurs",model.getHauteurPlants());
        value.put("marqueVentilateurs",model.getHauteurPlants());
        value.put("puissanceVentilateurs",model.getHauteurPlants());
        value.put("nbChauffages",model.getHauteurPlants());
        value.put("marqueChauffages",model.getHauteurPlants());
        value.put("puissanceChauffages",model.getHauteurPlants());
        value.put("ref_dossier",model.getRef_dossier());

        long rowid = DAOFactory.getInstance(getContext()).open().insert(TABLE_NAME,null,value);
        model.setId(rowid);
        return model;

    }

    @Override
    public ChambreModel update(ChambreModel model) {

        ContentValues value = new ContentValues();
        value.put("nom", model.getNom());
        value.put("longueur", model.getLongueur());
        value.put("largeur", model.getLargeur());
        value.put("nbPlants", model.getNbPlants());
        value.put("nbPlantsM2", model.getNbPlantsM2());
        value.put("hauteurPlants", model.getHauteurPlants());
        value.put("taillePots", model.getTaillePots());
        value.put("nbLampes", model.getNbLampes());
        value.put("puissanceLampes", model.getPuissanceLampes());
        value.put("marqueLampes", model.getMarqueLampes());
        value.put("modifLampes", model.getModifLampes());
        value.put("nbExtracteurs", model.getNbExtracteurs());
        value.put("marqueExtracteurs", model.getMarqueExtracteurs());
        value.put("nbFiltres", model.getNbFiltres());
        value.put("nbVentilateurs", model.getNbVentilateurs());
        value.put("marqueVentilateurs", model.getMarqueVentilateurs());
        value.put("puissanceVentilateurs", model.getPuissanceVentilateurs());
        value.put("nbChauffages", model.getNbChauffages());
        value.put("marqueChauffages", model.getMarqueChauffages());
        value.put("puissanceChauffages", model.getPuissanceChauffages());
        value.put("ref_dossier", model.getRef_dossier());

        DAOFactory.getInstance(getContext()).open().update(TABLE_NAME, value, "id = ?", new String[]{String.valueOf(model.getId())});
        return model;
    }

    @Override
    public ChambreModel delete(ChambreModel model) {
        DAOFactory.getInstance(getContext()).open().delete(TABLE_NAME,"id = ?",new String[]{String.valueOf(model.getId())});
        return model;
    }

    @Override
    public ChambreModel find(long id) {
        ChambreModel chambreModel = new ChambreModel();

        Cursor cursor = DAOFactory.getInstance(getContext()).open().rawQuery("select * from " + TABLE_NAME + " where id = ?",new String[]{String.valueOf(id)});
        if(cursor.moveToNext()){
            chambreModel.setId(cursor.getLong(cursor.getColumnIndex("id")));
            chambreModel.setNom(cursor.getString(cursor.getColumnIndex("nom")));
            chambreModel.setLongueur(cursor.getString(cursor.getColumnIndex("longueur")));
            chambreModel.setLargeur(cursor.getString(cursor.getColumnIndex("largeur")));
            chambreModel.setNbPlants(cursor.getString(cursor.getColumnIndex("nbPlants")));
            chambreModel.setNbPlantsM2(cursor.getString(cursor.getColumnIndex("nbPlantsM2")));

            chambreModel.setHauteurPlants(cursor.getString(cursor.getColumnIndex("hauteurPlants")));
            chambreModel.setTaillePots(cursor.getString(cursor.getColumnIndex("taillePots")));
            chambreModel.setNbLampes(cursor.getString(cursor.getColumnIndex("nbLampes")));
            chambreModel.setPuissanceLampes(cursor.getString(cursor.getColumnIndex("puissanceLampes")));
            chambreModel.setMarqueLampes(cursor.getString(cursor.getColumnIndex("marqueLampes")));

            chambreModel.setModifLampes(cursor.getString(cursor.getColumnIndex("modifLampes")));
            chambreModel.setNbExtracteurs(cursor.getString(cursor.getColumnIndex("nbExtracteurs")));
            chambreModel.setMarqueExtracteurs(cursor.getString(cursor.getColumnIndex("marqueExtracteurs")));
            chambreModel.setNbFiltres(cursor.getString(cursor.getColumnIndex("nbFiltres")));
            chambreModel.setNbVentilateurs(cursor.getString(cursor.getColumnIndex("nbVentilateurs")));
            chambreModel.setMarqueVentilateurs(cursor.getString(cursor.getColumnIndex("marqueVentilateurs")));

            chambreModel.setPuissanceVentilateurs(cursor.getString(cursor.getColumnIndex("puissanceVentilateurs")));
            chambreModel.setNbChauffages(cursor.getString(cursor.getColumnIndex("nbChauffages")));
            chambreModel.setMarqueChauffages(cursor.getString(cursor.getColumnIndex("marqueChauffages")));
            chambreModel.setPuissanceChauffages(cursor.getString(cursor.getColumnIndex("puissanceChauffages")));
            chambreModel.setRef_dossier(cursor.getLong(cursor.getColumnIndex("ref_dossier")));

        }
        cursor.close();

        return chambreModel;
    }

    @Override
    public List<ChambreModel> selectAll() {
        List<ChambreModel> list = new ArrayList<>();

        Cursor cursor = DAOFactory.getInstance(getContext()).open().rawQuery("select * from " + TABLE_NAME,null);
        while(cursor.moveToNext()){
            ChambreModel chambreModel = new ChambreModel();
            chambreModel.setId(cursor.getLong(cursor.getColumnIndex("id")));
            chambreModel.setNom(cursor.getString(cursor.getColumnIndex("nom")));
            chambreModel.setLongueur(cursor.getString(cursor.getColumnIndex("longueur")));
            chambreModel.setLargeur(cursor.getString(cursor.getColumnIndex("largeur")));
            chambreModel.setNbPlants(cursor.getString(cursor.getColumnIndex("nbPlants")));
            chambreModel.setNbPlantsM2(cursor.getString(cursor.getColumnIndex("nbPlantsM2")));

            chambreModel.setHauteurPlants(cursor.getString(cursor.getColumnIndex("hauteurPlants")));
            chambreModel.setTaillePots(cursor.getString(cursor.getColumnIndex("taillePots")));
            chambreModel.setNbLampes(cursor.getString(cursor.getColumnIndex("nbLampes")));
            chambreModel.setPuissanceLampes(cursor.getString(cursor.getColumnIndex("puissanceLampes")));
            chambreModel.setMarqueLampes(cursor.getString(cursor.getColumnIndex("marqueLampes")));

            chambreModel.setModifLampes(cursor.getString(cursor.getColumnIndex("modifLampes")));
            chambreModel.setNbExtracteurs(cursor.getString(cursor.getColumnIndex("nbExtracteurs")));
            chambreModel.setMarqueExtracteurs(cursor.getString(cursor.getColumnIndex("marqueExtracteurs")));
            chambreModel.setNbFiltres(cursor.getString(cursor.getColumnIndex("nbFiltres")));
            chambreModel.setNbVentilateurs(cursor.getString(cursor.getColumnIndex("nbVentilateurs")));
            chambreModel.setMarqueVentilateurs(cursor.getString(cursor.getColumnIndex("marqueVentilateurs")));

            chambreModel.setPuissanceVentilateurs(cursor.getString(cursor.getColumnIndex("puissanceVentilateurs")));
            chambreModel.setNbChauffages(cursor.getString(cursor.getColumnIndex("nbChauffages")));
            chambreModel.setMarqueChauffages(cursor.getString(cursor.getColumnIndex("marqueChauffages")));
            chambreModel.setPuissanceChauffages(cursor.getString(cursor.getColumnIndex("puissanceChauffages")));
            chambreModel.setRef_dossier(cursor.getLong(cursor.getColumnIndex("ref_dossier")));

            list.add(chambreModel);
        }
        cursor.close();

        return list;
    }

    @Override
    public List<ChambreModel> selectFromForeignKey(long foreignKey) {
        List<ChambreModel> list = new ArrayList<>();

        Cursor cursor = DAOFactory.getInstance(getContext()).open().rawQuery("select * from " + TABLE_NAME + " where ref_dossier = ?",new String[]{String.valueOf(foreignKey)});
        while(cursor.moveToNext()){
            ChambreModel chambreModel = new ChambreModel();
            chambreModel.setId(cursor.getLong(cursor.getColumnIndex("id")));
            chambreModel.setNom(cursor.getString(cursor.getColumnIndex("nom")));
            chambreModel.setLongueur(cursor.getString(cursor.getColumnIndex("longueur")));
            chambreModel.setLargeur(cursor.getString(cursor.getColumnIndex("largeur")));
            chambreModel.setNbPlants(cursor.getString(cursor.getColumnIndex("nbPlants")));
            chambreModel.setNbPlantsM2(cursor.getString(cursor.getColumnIndex("nbPlantsM2")));

            chambreModel.setHauteurPlants(cursor.getString(cursor.getColumnIndex("hauteurPlants")));
            chambreModel.setTaillePots(cursor.getString(cursor.getColumnIndex("taillePots")));
            chambreModel.setNbLampes(cursor.getString(cursor.getColumnIndex("nbLampes")));
            chambreModel.setPuissanceLampes(cursor.getString(cursor.getColumnIndex("puissanceLampes")));
            chambreModel.setMarqueLampes(cursor.getString(cursor.getColumnIndex("marqueLampes")));

            chambreModel.setModifLampes(cursor.getString(cursor.getColumnIndex("modifLampes")));
            chambreModel.setNbExtracteurs(cursor.getString(cursor.getColumnIndex("nbExtracteurs")));
            chambreModel.setMarqueExtracteurs(cursor.getString(cursor.getColumnIndex("marqueExtracteurs")));
            chambreModel.setNbFiltres(cursor.getString(cursor.getColumnIndex("nbFiltres")));
            chambreModel.setNbVentilateurs(cursor.getString(cursor.getColumnIndex("nbVentilateurs")));
            chambreModel.setMarqueVentilateurs(cursor.getString(cursor.getColumnIndex("marqueVentilateurs")));

            chambreModel.setPuissanceVentilateurs(cursor.getString(cursor.getColumnIndex("puissanceVentilateurs")));
            chambreModel.setNbChauffages(cursor.getString(cursor.getColumnIndex("nbChauffages")));
            chambreModel.setMarqueChauffages(cursor.getString(cursor.getColumnIndex("marqueChauffages")));
            chambreModel.setPuissanceChauffages(cursor.getString(cursor.getColumnIndex("puissanceChauffages")));
            chambreModel.setRef_dossier(cursor.getLong(cursor.getColumnIndex("ref_dossier")));

            list.add(chambreModel);
        }
        cursor.close();

        return list;
    }

    @Override
    public void deleteFromForeignKey(long foreignKey) {
        DAOFactory.getInstance(getContext()).open().delete(TABLE_NAME,"ref_dossier = ?",new String[]{String.valueOf(foreignKey)});
    }


}
