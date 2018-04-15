package org.police.seraing.plantapolapps.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.TextView;
import android.widget.Toast;

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

        try {
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
            value.put("marqueFiltres", model.getMarqueFiltres());
            value.put("nbVentilateurs", model.getNbVentilateurs());
            value.put("marqueVentilateurs", model.getMarqueVentilateurs());
            value.put("puissanceVentilateurs", model.getPuissanceVentilateurs());
            value.put("nbChauffages", model.getNbChauffages());
            value.put("marqueChauffages", model.getMarqueChauffages());
            value.put("puissanceChauffages", model.getPuissanceChauffages());
            value.put("ref_dossier", model.getRef_dossier());

            long rowid = DAOFactory.getInstance(getContext()).open().insert(TABLE_NAME, null, value);
            model.setId(rowid);
        }catch(android.database.SQLException e){
            Toast.makeText(getContext(),"(Exception)- Transaction annulée: ChambreDAO:insert", Toast.LENGTH_LONG).show();
        }
        finally {
            return model;
        }

    }

    @Override
    public ChambreModel update(ChambreModel model) {

        try {
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
            value.put("marqueFiltres", model.getMarqueFiltres());
            value.put("nbVentilateurs", model.getNbVentilateurs());
            value.put("marqueVentilateurs", model.getMarqueVentilateurs());
            value.put("puissanceVentilateurs", model.getPuissanceVentilateurs());
            value.put("nbChauffages", model.getNbChauffages());
            value.put("marqueChauffages", model.getMarqueChauffages());
            value.put("puissanceChauffages", model.getPuissanceChauffages());
            value.put("ref_dossier", model.getRef_dossier());

            DAOFactory.getInstance(getContext()).open().update(TABLE_NAME, value, "id = ?", new String[]{String.valueOf(model.getId())});
        }catch(android.database.SQLException e){
            Toast.makeText(getContext(),"(Exception)- Transaction annulée: ChambreDAO:update", Toast.LENGTH_LONG).show();
        }finally {
            return model;
        }
    }

    @Override
    public ChambreModel delete(ChambreModel model) {
        try {
            DAOFactory.getInstance(getContext()).open().delete(TABLE_NAME, "id = ?", new String[]{String.valueOf(model.getId())});
        }catch(android.database.SQLException e){
            Toast.makeText(getContext(),"(Exception)- Transaction annulée: ChambreDAO:delete", Toast.LENGTH_LONG).show();
        }
        finally {
            return model;
        }
    }

    @Override
    public ChambreModel find(long id) {
        ChambreModel chambreModel = new ChambreModel();

        try {

            Cursor cursor = DAOFactory.getInstance(getContext()).open().rawQuery("select * from " + TABLE_NAME + " where id = ?", new String[]{String.valueOf(id)});
            if (cursor.moveToNext()) {
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
                chambreModel.setMarqueFiltres(cursor.getString(cursor.getColumnIndex("marqueFiltres")));
                chambreModel.setNbVentilateurs(cursor.getString(cursor.getColumnIndex("nbVentilateurs")));
                chambreModel.setMarqueVentilateurs(cursor.getString(cursor.getColumnIndex("marqueVentilateurs")));

                chambreModel.setPuissanceVentilateurs(cursor.getString(cursor.getColumnIndex("puissanceVentilateurs")));
                chambreModel.setNbChauffages(cursor.getString(cursor.getColumnIndex("nbChauffages")));
                chambreModel.setMarqueChauffages(cursor.getString(cursor.getColumnIndex("marqueChauffages")));
                chambreModel.setPuissanceChauffages(cursor.getString(cursor.getColumnIndex("puissanceChauffages")));
                chambreModel.setRef_dossier(cursor.getLong(cursor.getColumnIndex("ref_dossier")));
                cursor.close();

            }


        }catch(android.database.SQLException e){
            Toast.makeText(getContext(),"(Exception)- Transaction annulée: ChambreDAO:find", Toast.LENGTH_LONG).show();
        }
        finally {

            return chambreModel;
        }
    }

    @Override
    public List<ChambreModel> selectAll() {
        List<ChambreModel> list = new ArrayList<>();

        try {
            Cursor cursor = DAOFactory.getInstance(getContext()).open().rawQuery("select * from " + TABLE_NAME, null);
            while (cursor.moveToNext()) {
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
                chambreModel.setMarqueFiltres(cursor.getString(cursor.getColumnIndex("marqueFiltres")));
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

        }catch(android.database.SQLException e){
            Toast.makeText(getContext(),"(Exception)- Transaction annulée: ChambreDAO:selectAll", Toast.LENGTH_LONG).show();
        }
        finally {
            return list;
        }
    }

    @Override
    public List<ChambreModel> selectFromForeignKey(long foreignKey) {
        List<ChambreModel> list = new ArrayList<>();

        try {
            Cursor cursor = DAOFactory.getInstance(getContext()).open().rawQuery("select * from " + TABLE_NAME + " where ref_dossier = ?", new String[]{String.valueOf(foreignKey)});
            while (cursor.moveToNext()) {
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
                chambreModel.setMarqueFiltres(cursor.getString(cursor.getColumnIndex("marqueFiltres")));
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

        }catch(android.database.SQLException e){
            Toast.makeText(getContext(),"(Exception)- Transaction annulée: ChambreDAO:selectFromForeignKey", Toast.LENGTH_LONG).show();
        }
        finally {
            return list;
        }
    }

    @Override
    public void deleteFromForeignKey(long foreignKey) {
        try {
            DAOFactory.getInstance(getContext()).open().delete(TABLE_NAME, "ref_dossier = ?", new String[]{String.valueOf(foreignKey)});
        }catch(android.database.SQLException e){
            Toast.makeText(getContext(),"(Exception)- Transaction annulée: ChambreDAO:deleteFromForeignKey", Toast.LENGTH_LONG).show();
        }
    }


}
