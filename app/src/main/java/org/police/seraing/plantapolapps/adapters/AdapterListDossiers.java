package org.police.seraing.plantapolapps.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.police.seraing.plantapolapps.DossierActivity;
import org.police.seraing.plantapolapps.R;
import org.police.seraing.plantapolapps.models.DossierModel;
import org.police.seraing.plantapolapps.models.dao.DAO;
import org.police.seraing.plantapolapps.models.dao.DAOFactory;

import java.util.List;

public class AdapterListDossiers extends ArrayAdapter<DossierModel> {

    private ViewGroup parent;

    public AdapterListDossiers(@NonNull Context context, @NonNull List<DossierModel> objects) {
        super(context,0,objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        this.parent = parent;
        DossierModel model = getItem(position);

    if(convertView == null){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.listdossier_items, parent, false);
    }

        TextView textNomDossier = convertView.findViewById(R.id.textNomDossier);
        Button   buttonDossier = convertView.findViewById(R.id.buttonDossier);
        buttonDossier.setTag(model);
        textNomDossier.setText(model.getNomDossier());

        buttonDossier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DossierModel model = (DossierModel) v.getTag();
                DAOFactory.getInstance(getContext()).createDOSSIERDAO().delete(model);
                AdapterListDossiers.this.clear();
                AdapterListDossiers.this.addAll(DAOFactory.getInstance(getContext()).createDOSSIERDAO().selectAll());

            }
        });

        convertView.setTag(model);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DossierModel model = (DossierModel) v.getTag();
               Intent  intent = new Intent(getContext(), DossierActivity.class);
               intent.putExtra("DOSSIER",model);
               getContext().startActivity(intent);
            }
        });
        return convertView;
    }
}
