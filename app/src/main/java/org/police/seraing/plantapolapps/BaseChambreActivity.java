package org.police.seraing.plantapolapps;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.RadioButton;

import org.police.seraing.plantapolapps.models.ChambreModel;

public class BaseChambreActivity extends Activity {

    protected ChambreModel model;
    public final static int  RESULT_ENREGISTRER = 1;
    public final static int  RESULT_ANNULER = 0;
    public final static int  RESULT_MODIFIER = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = getIntent().getParcelableExtra("CHAMBRE");

        if(model == null)
            model = new ChambreModel();
    }

    protected void createModel() {

        model.setNom(((EditText)findViewById(R.id.editNomChambre)).getText().toString());
        model.setLongueur(((EditText)findViewById(R.id.editLongueur)).getText().toString());
        model.setLargeur(((EditText)findViewById(R.id.editLargeur)).getText().toString());
        model.setNbPlants(((EditText)findViewById(R.id.editNbPlants)).getText().toString());
        model.setNbPlantsM2(((EditText)findViewById(R.id.editNbPlantsM2)).getText().toString());
        model.setNbLampes(((EditText)findViewById(R.id.editNbLampes)).getText().toString());
        model.setPuissanceLampes(((EditText)findViewById(R.id.editPuissanceLampes)).getText().toString());
        model.setMarqueLampes(((EditText)findViewById(R.id.editInfoLampes)).getText().toString());

        if(((RadioButton)findViewById(R.id.radioButtonOuiLampe)).isChecked())
            model.setModifLampes(ChambreModel.OUI_MODIF);
        else
            model.setModifLampes(ChambreModel.NON_MODIF);

        model.setHauteurPlants(((EditText)findViewById(R.id.editHauteurPlants)).getText().toString());
        model.setTaillePots(((EditText)findViewById(R.id.editTaillePots)).getText().toString());
        model.setNbExtracteurs(((EditText)findViewById(R.id.editNbExtracteurs)).getText().toString());
        model.setMarqueExtracteurs(((EditText)findViewById(R.id.editInfoExtracteurs)).getText().toString());
        model.setNbFiltres(((EditText)findViewById(R.id.editNbFiltres)).getText().toString());
        model.setMarqueFiltres(((EditText)findViewById(R.id.editInfoFiltres)).getText().toString());
        model.setNbVentilateurs(((EditText)findViewById(R.id.editNbVentilateurs)).getText().toString());
        model.setPuissanceVentilateurs(((EditText)findViewById(R.id.editPuissanceVentilateurs)).getText().toString());
        model.setMarqueVentilateurs(((EditText)findViewById(R.id.editInfoVentilateurs)).getText().toString());
        model.setNbChauffages(((EditText)findViewById(R.id.editNbChauffages)).getText().toString());
        model.setMarqueChauffages(((EditText)findViewById(R.id.editInfoChauffages)).getText().toString());
        model.setPuissanceChauffages(((EditText)findViewById(R.id.editPuissanceChauffages)).getText().toString());

    }
}
