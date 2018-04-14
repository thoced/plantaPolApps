package org.police.seraing.plantapolapps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.police.seraing.plantapolapps.models.DossierModel;
import org.police.seraing.plantapolapps.models.dao.DAOFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NameNewDossierActivity extends Activity {

    private DossierModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.newdossier_layout);


        Button buttonNext = findViewById(R.id.buttonNext);
        if(buttonNext != null){
            buttonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    model = new DossierModel();
                    TextView textView = findViewById(R.id.nameDossierTextField);
                    model.setNomDossier(textView.getText().toString());
                    model.setDateTime(getCurrentTimeStamp());

                    // enregistrement dans la base
                    model = (DossierModel) DAOFactory.getInstance(NameNewDossierActivity.this).createDOSSIERDAO().insert(model);

                    Intent intent = new Intent(NameNewDossierActivity.this,DossierActivity.class);
                    intent.putExtra("DOSSIER",model);
                    startActivity(intent);

                }
            });
        }

        Button buttonAnnuler = findViewById(R.id.buttonCancel);
        buttonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }


}
