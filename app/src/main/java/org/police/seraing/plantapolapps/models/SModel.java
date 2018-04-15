package org.police.seraing.plantapolapps.models;

import android.content.Context;
import android.provider.Telephony;

import org.police.seraing.plantapolapps.models.dao.DAOFactory;

class SModel {
    private static final SModel ourInstance = new SModel();

    private DossierModel currentDossierModel;

    private Context context;

    static SModel getInstance(Context context) {

        context = context;

        return ourInstance;
    }



    private SModel() {
    }

    public void newDossier(DossierModel model){
        currentDossierModel = model;
        DAOFactory.getInstance(context).createDOSSIERDAO().insert(currentDossierModel);
    }
}
