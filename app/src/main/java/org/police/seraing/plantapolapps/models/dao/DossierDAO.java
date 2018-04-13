package org.police.seraing.plantapolapps.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import org.police.seraing.plantapolapps.models.ChambreModel;
import org.police.seraing.plantapolapps.models.DossierModel;

public class DossierDAO extends DAO<DossierModel> {


    public DossierDAO(SQLiteCustom connection, Context context) {
        super(connection, context);
    }

    @Override
    public DossierModel update(DossierModel model) {
        ContentValues value = new ContentValues();
        value.put("nom",model.getNomDossier());
        value.put("datetime",model.getDateTime());
        DAOFactory.getInstance(getContext()).open().update("t_dossiers",value,"id = ?",new String[]{String.valueOf(model.getId())});
        return model;
    }

    @Override
    public DossierModel delete(DossierModel model) {
        // debut de transaction atomique
        DAOFactory.getInstance(getContext()).open().beginTransaction();
        // suppression du dossier
        DAOFactory.getInstance(getContext()).open().delete("t_dossiers","id = ?",new String[]{String.valueOf(model.getId())});
        // suppression des chambres associées
        DAOFactory.getInstance(getContext()).createCHAMBREDAO().deleteFromForeignKey(model.getId());
        // fin de transaction atomique
        DAOFactory.getInstance(getContext()).open().endTransaction();
        return model;
    }

    @Override
    public DossierModel insert(DossierModel model) {
        ContentValues value = new ContentValues();
        value.put("nom", ((DossierModel)model).getNomDossier());
        value.put("datetime",model.getDateTime());
        long id = DAOFactory.getInstance(getContext()).open().insert("t_dossiers",null,value);
        model.setId(id);
        return model;

    }

    @Override
    public DossierModel find(long id) {
        DossierModel dossierModel = new DossierModel();
        DAOFactory.getInstance(getContext()).open().beginTransaction();
        Cursor cursor = DAOFactory.getInstance(getContext()).open().rawQuery("select * from t_dossiers where id = ?",new String[]{String.valueOf(id)});
        if(cursor.moveToNext()){
            dossierModel.setNomDossier(cursor.getString(cursor.getColumnIndex("nom")));
            dossierModel.setId(cursor.getLong(cursor.getColumnIndex("id")));
            dossierModel.setDateTime(cursor.getString(cursor.getColumnIndex("datetime")));
            List<ChambreModel> chambreModelList = DAOFactory.getInstance(getContext()).createCHAMBREDAO().selectFromForeignKey(id);
            dossierModel.getListChambres().addAll(chambreModelList);
        }
        cursor.close();
        DAOFactory.getInstance(getContext()).open().endTransaction();
        return dossierModel;

    }

    @Override
    public List selectAll() {
        List<DossierModel> list = new ArrayList<DossierModel>();

        DAOFactory.getInstance(getContext()).open().beginTransaction();
        Cursor cursor = DAOFactory.getInstance(getContext()).open().rawQuery("select * from t_dossiers",null);

        while(cursor.moveToNext()){
            DossierModel dossierModel = new DossierModel(cursor.getLong(cursor.getColumnIndex("id")),
            cursor.getString(cursor.getColumnIndex("nom")),
            cursor.getString(cursor.getColumnIndex("datetime")));
            List<ChambreModel> chambreModelList = DAOFactory.getInstance(getContext()).createCHAMBREDAO().selectFromForeignKey(dossierModel.getId());
            dossierModel.getListChambres().addAll(chambreModelList);
            list.add(dossierModel);
        }

        cursor.close();
        DAOFactory.getInstance(getContext()).open().endTransaction();

        return list;
    }

    @Override
    public List<DossierModel> selectFromForeignKey(long foreignKey) {
        return null;
    }

    @Override
    public void deleteFromForeignKey(long foreignKey) {

    }
}
