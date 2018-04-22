package org.police.seraing.plantapolapps.models.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.widget.Toast;

import org.police.seraing.plantapolapps.models.PhotoModel;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhotoDAO extends DAO<PhotoModel> {

    public PhotoDAO(SQLiteCustom connection, Context context) {
        super(connection, context);
    }

    @Override
    public PhotoModel insert(PhotoModel model) throws android.database.SQLException{

            ContentValues value = new ContentValues();
            value.put("raw", model.getRaw());
            value.put("width",model.getWidth());
            value.put("height",model.getHeight());
            value.put("ref_chambre", model.getRef_chambre());
            long id = DAOFactory.getInstance(getContext()).open().insert(SQLiteCustom.METIER_TABLE_PHOTO, null, value);
            model.setId(id);
            return model;

    }

    @Override
    public PhotoModel update(PhotoModel model) {
        ContentValues value = null;
        try {
            value = new ContentValues();
            value.put("raw",model.getRaw());
            value.put("width",model.getWidth());
            value.put("height",model.getHeight());
            value.put("ref_chambre",model.getRef_chambre());
            DAOFactory.getInstance(getContext()).open().update(SQLiteCustom.METIER_TABLE_PHOTO, value, "id = ?", new String[]{String.valueOf(model.getId())});
        }catch(android.database.SQLException e){
            Toast.makeText(getContext(),"(Exception)- Transaction annulée: PhotoDAO:update", Toast.LENGTH_LONG).show();
        }
        return model;

    }

    @Override
    public PhotoModel delete(PhotoModel model) {
        try {
            DAOFactory.getInstance(getContext()).open().delete(SQLiteCustom.METIER_TABLE_PHOTO, "id = ?", new String[]{String.valueOf(model.getId())});
        }catch (android.database.SQLException e){
            Toast.makeText(getContext(),"(Exception)- Transaction annulée: PhotoDAO:delete", Toast.LENGTH_LONG).show();
            return null;
        }
        finally {
            return model;
        }
    }

    @Override
    public PhotoModel find(long id) {
        Cursor cursor = null;
        PhotoModel photoModel = null;
        try {
             cursor = DAOFactory.getInstance(getContext()).open().rawQuery("select * from " + SQLiteCustom.METIER_TABLE_PHOTO + " where id = ?", new String[]{String.valueOf(id)});
            if (cursor.moveToNext()) {
                photoModel = new PhotoModel(cursor.getBlob(cursor.getColumnIndex("raw")));
                photoModel.setId(cursor.getLong(cursor.getColumnIndex("id")));
                photoModel.setRef_chambre(cursor.getLong(cursor.getColumnIndex("ref_chambre")));
                photoModel.setWidth(cursor.getInt(cursor.getColumnIndex("width")));
                photoModel.setHeight(cursor.getInt(cursor.getColumnIndex("height")));
            }
        }catch(android.database.SQLException e){
            Toast.makeText(getContext(),"(Exception)- Transaction annulée: PhotoDAO:find", Toast.LENGTH_LONG).show();
        }
        finally {
            cursor.close();
            return photoModel;
        }

    }

    @Override
    public List<PhotoModel> selectAll() {
            Cursor cursor = null;
            List<PhotoModel> list = null;

        try {
            list = new ArrayList<PhotoModel>();
            cursor = DAOFactory.getInstance(getContext()).open().rawQuery("select * from " + SQLiteCustom.METIER_TABLE_PHOTO, null);
            while (cursor.moveToNext()) {
                PhotoModel photoModel = new PhotoModel(cursor.getBlob(cursor.getColumnIndex("raw")));
                photoModel.setId(cursor.getLong(cursor.getColumnIndex("id")));
                photoModel.setRef_chambre(cursor.getLong(cursor.getColumnIndex("ref_chambre")));
                photoModel.setWidth(cursor.getInt(cursor.getColumnIndex("width")));
                photoModel.setHeight(cursor.getInt(cursor.getColumnIndex("height")));
                list.add(photoModel);
            }

        }catch(android.database.SQLException e){
            Toast.makeText(getContext(),"(Exception)- Transaction annulée: PhotoDAO:selectAll", Toast.LENGTH_LONG).show();
            list.clear();
            list = null;
        }
        finally {
            cursor.close();
            return list;
        }

    }

    @Override
    public List<PhotoModel> selectFromForeignKey(long foreignKey) {
        Cursor cursor = null;
        List<PhotoModel> list = null;

        try {
            list = new ArrayList<PhotoModel>();
            cursor = DAOFactory.getInstance(getContext()).open().rawQuery("select * from " + SQLiteCustom.METIER_TABLE_PHOTO + " where ref_chambre = ?", new String[]{String.valueOf(foreignKey)});
            while (cursor.moveToNext()) {
                PhotoModel photoModel = new PhotoModel(cursor.getBlob(cursor.getColumnIndex("raw")));
                photoModel.setId(cursor.getLong(cursor.getColumnIndex("id")));
                photoModel.setRef_chambre(cursor.getLong(cursor.getColumnIndex("ref_chambre")));
                photoModel.setWidth(cursor.getInt(cursor.getColumnIndex("width")));
                photoModel.setHeight(cursor.getInt(cursor.getColumnIndex("height")));
                list.add(photoModel);
            }

        }catch(android.database.SQLException e){
            Toast.makeText(getContext(),"(Exception)- Transaction annulée: PhotoDAO:selectFromForeignKey", Toast.LENGTH_LONG).show();
            list.clear();
            list = null;
        }
        finally {
            cursor.close();
            return list;
        }
    }

    @Override
    public void deleteFromForeignKey(long foreignKey) throws android.database.SQLException{
          DAOFactory.getInstance(getContext()).open().delete(SQLiteCustom.METIER_TABLE_PHOTO, "ref_chambre = ?", new String[]{String.valueOf(foreignKey)});
    }
}
