package org.police.seraing.plantapolapps;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.police.seraing.plantapolapps.models.DossierModel;
import org.police.seraing.plantapolapps.models.dao.DAOFactory;
import org.police.seraing.plantapolapps.models.dao.SQLiteCustom;

import java.util.ArrayList;
import java.util.List;

public class LoadDossierActivity extends Activity {

    private ArrayList<DossierModel> listDossiers = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loaddossier_layout);

        Button buttonAnnuler = findViewById(R.id.buttonAnnuler);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        loadDossiers();

        updateListView();
    }

    private void updateListView() {

        ArrayAdapter<DossierModel> arrayAdapter = new ArrayAdapter<DossierModel>(this,android.R.layout.simple_list_item_1,listDossiers);
        ListView listDossiers = findViewById(R.id.listDossiers);
        listDossiers.setAdapter(arrayAdapter);
    }

    private void loadDossiers() {

        List<DossierModel> list = DAOFactory.getInstance(this).createDOSSIERDAO().selectAll();
        listDossiers.clear();
        listDossiers.addAll(list);


    }

}
