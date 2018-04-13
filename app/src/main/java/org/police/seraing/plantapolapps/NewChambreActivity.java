package org.police.seraing.plantapolapps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import org.police.seraing.plantapolapps.models.ChambreModel;

public class NewChambreActivity extends BaseChambreActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.newchambre_layout);

        findViewById(R.id.buttonEnregistrerChambre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                createModel();
                intent.putExtra("CHAMBRE",model);
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
