package org.police.seraing.plantapolapps;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.police.seraing.plantapolapps.models.DossierModel;
import org.police.seraing.plantapolapps.models.dao.DAOFactory;
import org.police.seraing.plantapolapps.models.dao.SQLiteCustom;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView text;

    private Button buttonNewPlantation;

    private Button buttonLoadPlantation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        buttonNewPlantation = findViewById(R.id.buttonNewPlantation);
        if(buttonNewPlantation != null){
            buttonNewPlantation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Intent intent = new Intent(MainActivity.this,NameNewDossierActivity.class);
                    //startActivity(intent);
                    final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    LayoutInflater inflater = MainActivity.this.getLayoutInflater();


                    builder.setView(inflater.inflate(R.layout.dialognewdossier_layout, null))
                            .setTitle("Nouveau dossier")
                            .setMessage("Veuillez inscrire le nom du dossier")
                            .setPositiveButton("Enregistrer", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    DossierModel model = new DossierModel();

                                    EditText editNomDossier = ((AlertDialog)dialog).findViewById(R.id.editNewNameDossier);
                                    model.setNomDossier(editNomDossier.getText().toString());
                                    model.setDateTime(getCurrentTimeStamp());

                                    // enregistrement dans la base
                                    model = (DossierModel) DAOFactory.getInstance(MainActivity.this).createDOSSIERDAO().insert(model);

                                    Intent intent = new Intent(MainActivity.this,DossierActivity.class);
                                    intent.putExtra("DOSSIER",model);
                                    startActivity(intent);
                                }
                            });


                    builder.create().show();


                }
            });
        }

        buttonLoadPlantation = findViewById(R.id.buttonLoadPlantation);
        if(buttonLoadPlantation != null){
            buttonLoadPlantation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,LoadDossierActivity.class);
                    startActivity(intent);
                }
            });
        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!! RESULT !!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!! RESUME !!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
}
