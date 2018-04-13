package org.police.seraing.plantapolapps.models.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteCustom extends SQLiteOpenHelper {

    public static final String NAME_DB = "db_plantation";
    public static final int    VERSION = 1;

    public static final String METIER_TABLE_DOSSIER = "t_dossiers";
    public static final String METIER_TABLE_CHAMBRE = "t_chambres";
    public static final String METIER_ID_NAME = "id";
    public static final String METIER_NAME_DOSSIER = "nom";
    public static final String METIER_NAME_CHAMBRE = "nom";

    public static final String METIER_DROP_DOSSIERS = "drop table IF EXISTS " + METIER_TABLE_DOSSIER;

    public static final String METIER_DROP_CHAMBRES = "drop table IF EXISTS " + METIER_TABLE_CHAMBRE;

    public static final String CREATE_TABLE_DOSSIERS = "CREATE TABLE " + METIER_TABLE_DOSSIER +
            " (" + METIER_ID_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            METIER_NAME_DOSSIER + " TEXT," +
            "datetime DATETIME);";

    public static final String CREATE_TABLE_CHAMBRES = "CREATE TABLE " + METIER_TABLE_CHAMBRE +
            " (" + METIER_ID_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            METIER_NAME_CHAMBRE + " TEXT," +
            "longueur TEXT," +
            "largeur TEXT," +
            "nbPlants TEXT," +
            "nbPlantsM2 TEXT," +
            "hauteurPlants TEXT," +
            "taillePots TEXT," +
            "nbLampes TEXT," +
            "puissanceLampes TEXT," +
            "marqueLampes TEXT," +
            "modifLampes TEXT," +
            "nbExtracteurs TEXT," +
            "marqueExtracteurs TEXT," +
            "nbFiltres TEXT," +
            "marqueFiltres TEXT," +
            "nbVentilateurs TEXT," +
            "marqueVentilateurs TEXT," +
            "puissanceVentilateurs TEXT," +
            "nbChauffages TEXT," +
            "marqueChauffages TEXT," +
            "puissanceChauffages TEXT," +
            "ref_dossier INTEGER)";



    public SQLiteCustom(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_DOSSIERS);
        db.execSQL(CREATE_TABLE_CHAMBRES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(METIER_DROP_DOSSIERS);
        db.execSQL(METIER_DROP_CHAMBRES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // super.onDowngrade(db, oldVersion, newVersion);
        onUpgrade(db,oldVersion,newVersion);
    }
}
