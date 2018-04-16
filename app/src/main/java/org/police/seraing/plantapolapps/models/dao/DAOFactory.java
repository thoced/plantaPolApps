package org.police.seraing.plantapolapps.models.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DAOFactory {


    private static DAOFactory instance;

    private static Context context;

    private static SQLiteCustom connection;


    private DAOFactory(Context context) {

       connection = new SQLiteCustom(context,"DB_plantation",null);

    }

    public SQLiteDatabase open(){
        return connection.getWritableDatabase();
    }

    public static DAOFactory getInstance(Context context){
        DAOFactory.context = context;

        if(instance == null)
            instance = new DAOFactory(context);

        return instance;
    }

    public DAO createDOSSIERDAO(){
       return new DossierDAO(connection,context);
    }

    public DAO createCHAMBREDAO(){
        return new ChambreDAO(connection,context);
    }

    public DAO createDOSSIERDAOXML() {
        return new org.police.seraing.plantapolapps.models.dao.xml.DossierDAO(connection,context);
    }


}
