package org.police.seraing.plantapolapps.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import org.police.seraing.plantapolapps.DossierActivity;
import org.police.seraing.plantapolapps.ModifChambreActivity;
import org.police.seraing.plantapolapps.R;
import org.police.seraing.plantapolapps.models.ChambreModel;
import org.police.seraing.plantapolapps.models.DossierModel;
import org.police.seraing.plantapolapps.models.dao.DAOFactory;

import java.util.List;

public class AdapterListChambres extends ArrayAdapter<ChambreModel> {

    private ViewGroup parent;

    public AdapterListChambres(@NonNull Context context, @NonNull List<ChambreModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        this.parent = parent;
        ChambreModel model = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listchambre_items, parent, false);
        }

        TextView textNomChambre = convertView.findViewById(R.id.textNomChambre);
        final Button buttonDelChambre = convertView.findViewById(R.id.buttonDelChambre);
        buttonDelChambre.setTag(model);
        textNomChambre.setText(model.getNom());


        buttonDelChambre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Voulez-vous supprimer cette chambre ?");
                builder.setTitle("Suppression de la chambre").setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ChambreModel model = (ChambreModel) buttonDelChambre.getTag();
                        DAOFactory.getInstance(getContext()).createCHAMBREDAO().delete(model);
                        AdapterListChambres.this.clear();
                        AdapterListChambres.this.addAll(DAOFactory.getInstance(getContext()).createCHAMBREDAO().selectFromForeignKey(model.getRef_dossier()));
                    }
                });
                builder.show();

            }
        });


        convertView.setTag(model);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChambreModel chambreModel = (ChambreModel) v.getTag();
                Intent intent = new Intent(getContext(), ModifChambreActivity.class);
                intent.putExtra("CHAMBRE",chambreModel);
                getContext().startActivity(intent);
            }
        });
        return convertView;
    }
}
