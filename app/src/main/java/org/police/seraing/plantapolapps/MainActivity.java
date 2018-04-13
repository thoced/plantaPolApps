package org.police.seraing.plantapolapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.police.seraing.plantapolapps.models.DossierModel;
import org.police.seraing.plantapolapps.models.dao.SQLiteCustom;

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
                    Intent intent = new Intent(MainActivity.this,NameNewDossierActivity.class);
                    DossierModel model = new DossierModel();
                    intent.putExtra("DOSSIER",model);
                    startActivity(intent);
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
}
