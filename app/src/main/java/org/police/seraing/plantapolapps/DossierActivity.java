package org.police.seraing.plantapolapps;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.police.seraing.plantapolapps.models.ChambreModel;
import org.police.seraing.plantapolapps.models.DossierModel;
import org.police.seraing.plantapolapps.models.InstallationModel;

public class DossierActivity extends Activity {

    private DossierModel model;
    private ListView listViewChambres;
    private ListView listViewInstallations;
    private ArrayAdapter<ChambreModel> arrayAdapterChambres;
    private ArrayAdapter<InstallationModel> arrayAdapterInstallations;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dossier_layout);

        model = this.getIntent().getParcelableExtra("DOSSIER");
        TextView textViewNameDossier = findViewById(R.id.textViewNameDossier);
        textViewNameDossier.setText(model.getNomDossier());



        // Button Add
        Button buttonAddChambre = findViewById(R.id.buttonNewChambre);
        buttonAddChambre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DossierActivity.this,NewChambreActivity.class);
                ChambreModel chambreModel = new ChambreModel();
                intent.putExtra("CHAMBRE",chambreModel);
                startActivityForResult(intent,BaseChambreActivity.RESULT_ENREGISTRER);
            }
        });


        // ListView
        listViewChambres = findViewById(R.id.listViewChambres);
        if(listViewChambres != null){
            arrayAdapterChambres = new ArrayAdapter<ChambreModel>(this,android.R.layout.simple_list_item_1,model.getListChambres());
            listViewChambres.setAdapter(arrayAdapterChambres);
            listViewChambres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  ChambreModel chambreModel = model.getListChambres().get(position);

                  Intent intent = new Intent(DossierActivity.this,ModifChambreActivity.class);
                  intent.putExtra("CHAMBRE",chambreModel);
                  startActivityForResult(intent,BaseChambreActivity.RESULT_MODIFIER);
                }
            });
        }

        listViewInstallations = findViewById(R.id.listViewChambres);
        if(listViewInstallations != null){
            arrayAdapterInstallations = new ArrayAdapter<InstallationModel>(this,android.R.layout.simple_list_item_1,model.getListInstallations());
            listViewInstallations.setAdapter(arrayAdapterInstallations);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == BaseChambreActivity.RESULT_ENREGISTRER){
            if(data != null){
                ChambreModel chambreModel = data.getParcelableExtra("CHAMBRE");
                model.getListChambres().add(chambreModel);
                arrayAdapterChambres = new ArrayAdapter<ChambreModel>(this,android.R.layout.simple_list_item_1,model.getListChambres());
                listViewChambres.setAdapter(arrayAdapterChambres);
            }
        }

        if(resultCode == BaseChambreActivity.RESULT_MODIFIER)
        {
            if(data != null){
                ChambreModel chambreModel = data.getParcelableExtra("CHAMBRE");
              //  model.getListChambres().set(chambreModel.getPosition(),chambreModel);
                arrayAdapterChambres = new ArrayAdapter<ChambreModel>(this,android.R.layout.simple_list_item_1,model.getListChambres());
                listViewChambres.setAdapter(arrayAdapterChambres);



            }
        }

    }
}
