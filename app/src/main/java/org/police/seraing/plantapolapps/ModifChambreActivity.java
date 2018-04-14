package org.police.seraing.plantapolapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import org.police.seraing.plantapolapps.models.ChambreModel;
import org.police.seraing.plantapolapps.models.dao.DAOFactory;

public class ModifChambreActivity extends BaseChambreActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.modifchambre_layout);

        refreshFieldView();

        Button buttonModif = findViewById(R.id.buttonModifChambre);
        buttonModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                createModel();
                DAOFactory.getInstance(ModifChambreActivity.this).createCHAMBREDAO().update(model);
                intent.putExtra("CHAMBRE",model);
                setResult(BaseChambreActivity.RESULT_MODIFIER,intent);
                finish();
            }
        });

        Button buttonAnnuler = findViewById(R.id.buttonAnnulerChambre);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(BaseChambreActivity.RESULT_ANNULER,null);
                finish();
            }
        });


    }

    private void refreshFieldView() {

            ((EditText)findViewById(R.id.editNomChambre)).setText(model.getNom());
            ((EditText)findViewById(R.id.editLongueur)).setText(model.getLongueur());
            ((EditText)findViewById(R.id.editLargeur)).setText(model.getLargeur());
            ((EditText)findViewById(R.id.editNbPlants)).setText(model.getNbPlants());
            ((EditText)findViewById(R.id.editNbPlantsM2)).setText(model.getNbPlantsM2());
            ((EditText)findViewById(R.id.editNbLampes)).setText(model.getNbLampes());
            ((EditText)findViewById(R.id.editPuissanceLampes)).setText(model.getPuissanceLampes());
            ((EditText)findViewById(R.id.editInfoLampes)).setText(model.getMarqueLampes());

            if(model.getModifLampes().equals(ChambreModel.OUI_MODIF))
                ((RadioButton)findViewById(R.id.radioButtonOuiLampe)).setChecked(true);
            else
                ((RadioButton)findViewById(R.id.radioButtonOuiLampe)).setChecked(false);

            ((EditText)findViewById(R.id.editHauteurPlants)).setText(model.getHauteurPlants());
            ((EditText)findViewById(R.id.editTaillePots)).setText(model.getTaillePots());
            ((EditText)findViewById(R.id.editNbExtracteurs)).setText(model.getNbExtracteurs());
            ((EditText)findViewById(R.id.editInfoExtracteurs)).setText(model.getMarqueExtracteurs());
            ((EditText)findViewById(R.id.editNbFiltres)).setText(model.getNbFiltres());
            ((EditText)findViewById(R.id.editInfoFiltres)).setText(model.getMarqueFiltres());
            ((EditText)findViewById(R.id.editNbVentilateurs)).setText(model.getNbVentilateurs());
            ((EditText)findViewById(R.id.editInfoVentilateurs)).setText(model.getMarqueVentilateurs());
            ((EditText)findViewById(R.id.editPuissanceVentilateurs)).setText(model.getPuissanceVentilateurs());
            ((EditText)findViewById(R.id.editNbChauffages)).setText(model.getNbChauffages());
            ((EditText)findViewById(R.id.editInfoChauffages)).setText(model.getMarqueChauffages());
            ((EditText)findViewById(R.id.editPuissanceChauffages)).setText(model.getPuissanceChauffages());

    }
}
