package org.police.seraing.plantapolapps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import org.police.seraing.plantapolapps.models.ChambreModel;
import org.police.seraing.plantapolapps.models.DossierModel;
import org.police.seraing.plantapolapps.models.dao.DAOFactory;

public class NewChambreActivity extends BaseChambreActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.newchambre_layout);

       final DossierModel dossierModel = getIntent().getParcelableExtra("DOSSIER");

        findViewById(R.id.buttonEnregistrerChambre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                createModel();
                model.setRef_dossier(dossierModel.getId());
                model= (ChambreModel) DAOFactory.getInstance(NewChambreActivity.this).createCHAMBREDAO().insert(model);
                setResult(BaseChambreActivity.RESULT_ENREGISTRER,intent);
                finish();
            }
        });

        findViewById(R.id.buttonAnnulerChambre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(BaseChambreActivity.RESULT_ANNULER,null);
                finish();
            }
        });
    }







}
