package org.police.seraing.plantapolapps;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import org.police.seraing.plantapolapps.models.ChambreModel;
import org.police.seraing.plantapolapps.models.DossierModel;
import org.police.seraing.plantapolapps.models.PhotoModel;
import org.police.seraing.plantapolapps.models.dao.DAOFactory;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class NewChambreActivity extends BaseChambreActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private LinearLayout linearPhotoLayout;

    private List<PhotoModel> listPhotos = new ArrayList<PhotoModel>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.newchambre_layout);

        linearPhotoLayout = findViewById(R.id.linearPhotoLayout);

       final DossierModel dossierModel = getIntent().getParcelableExtra("DOSSIER");

        findViewById(R.id.buttonEnregistrerChambre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                createModel();
                model.setRef_dossier(dossierModel.getId());
                for(PhotoModel m : listPhotos){
                    model.addPhoto(m);
                }
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

        findViewById(R.id.buttonAddPhoto).setOnClickListener((v) -> {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            byte[] bytes = new byte[imageBitmap.getByteCount()];
            imageBitmap.copyPixelsToBuffer(ByteBuffer.wrap(bytes));
            PhotoModel photoModel = new PhotoModel(bytes);
            photoModel.setWidth(imageBitmap.getWidth());
            photoModel.setHeight(imageBitmap.getHeight());
            listPhotos.add(photoModel);
            ImageView imageView = new ImageView(this);
            imageView.setPadding(16,16,16,16);
            imageView.setImageBitmap(imageBitmap);
            linearPhotoLayout.addView(imageView);

        }
    }
}
