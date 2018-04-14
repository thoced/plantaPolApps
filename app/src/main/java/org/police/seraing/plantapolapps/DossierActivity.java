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

import org.police.seraing.plantapolapps.adapters.AdapterListChambres;
import org.police.seraing.plantapolapps.models.ChambreModel;
import org.police.seraing.plantapolapps.models.DossierModel;
import org.police.seraing.plantapolapps.models.InstallationModel;
import org.police.seraing.plantapolapps.models.dao.DAOFactory;

public class DossierActivity extends Activity {

    private DossierModel model;
    private ListView listViewChambres;
    private ListView listViewInstallations;
    private AdapterListChambres arrayAdapterChambres;
    private ArrayAdapter<InstallationModel> arrayAdapterInstallations;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dossier_layout);

        model = this.getIntent().getParcelableExtra("DOSSIER");
        model = (DossierModel) DAOFactory.getInstance(this).createDOSSIERDAO().find(model.getId());

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
                intent.putExtra("DOSSIER",model);
                startActivityForResult(intent,BaseChambreActivity.RESULT_ENREGISTRER);
            }
        });

        // liste des chambres
        arrayAdapterChambres = new AdapterListChambres(this,model.getListChambres());
        listViewChambres = findViewById(R.id.listViewChambres);
        listViewChambres.setAdapter(arrayAdapterChambres);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // resume des listes des chambres
        arrayAdapterChambres.clear();
        arrayAdapterChambres.addAll(DAOFactory.getInstance(this).createCHAMBREDAO().selectFromForeignKey(model.getId()));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == BaseChambreActivity.RESULT_ENREGISTRER){
            if(data != null){
               // arrayAdapterChambres = new ArrayAdapter<ChambreModel>(this,android.R.layout.simple_list_item_1, DAOFactory.getInstance(this).createCHAMBREDAO().selectFromForeignKey(model.getId()));
             //   listViewChambres.setAdapter(arrayAdapterChambres);
            }
        }

        if(resultCode == BaseChambreActivity.RESULT_MODIFIER)
        {
            if(data != null){
               // ChambreModel chambreModel = data.getParcelableExtra("CHAMBRE");
              //  model.getListChambres().set(chambreModel.getPosition(),chambreModel);
              //  arrayAdapterChambres = new ArrayAdapter<ChambreModel>(this,android.R.layout.simple_list_item_1,DAOFactory.getInstance(this).createCHAMBREDAO().selectFromForeignKey(model.getId()));
                //listViewChambres.setAdapter(arrayAdapterChambres);

            }
        }

    }
}
