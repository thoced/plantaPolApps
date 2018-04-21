package org.police.seraing.plantapolapps.models.dao.xml;

import android.content.Context;
import android.media.Image;
import android.os.Environment;
import android.widget.Toast;

import org.police.seraing.plantapolapps.NewChambreActivity;
import org.police.seraing.plantapolapps.models.ChambreModel;
import org.police.seraing.plantapolapps.models.DossierModel;
import org.police.seraing.plantapolapps.models.dao.DAO;
import org.police.seraing.plantapolapps.models.dao.SQLiteCustom;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Random;

public class DossierDAO extends DAO<DossierModel> {

    private static final String HAUTEUR_PLANTS = "HauteurPlants";
    private static final String TAILLE_POTS = "TaillePots";
    private static final String NB_LAMPES = "NbLampes";
    private static final String PUISSANCE_LAMPES = "PuissanceLampes";
    private static final String INFO_LAMPES = "InfoLampes";
    private static final String MODIF_LAMPES = "ModifLampes";
    private static final String NB_EXTRACTEURS = "NbExtracteurs";
    private static final String INFO_EXTRACTEURS = "InfoExtracteurs";
    private static final String NB_FILTRES = "NbFiltres";
    private static final String INFO_FILTRES = "InfoFiltres";
    private static final String NB_VENTILATEURS = "NbVentilateurs";
    private static final String PUISSANCE_VENTILATEURS = "PuissanceVentilateurs";
    private static final String INFO_VENTILATEURS = "InfoVentilateurs";
    private static final String NB_CHAUFFAGES = "NbChauffages";
    private static final String PUISSANCE_CHAUFFAGES = "PuissanceChauffages";
    private static final String INFO_CHAUFFAGES = "InfoChauffages";
    private  StringWriter writer = null;
    private  File file;
    private XmlPullParserFactory factory;
    private XmlSerializer serializer;

    public final static String NOMCHAMBRE = "Nom";
    public final static String LONGUEUR = "Longueur";
    public final static String LARGEUR = "Largeur";
    public final static String NBPLANTS = "NbPlants";
    public final static String NBPLANTSM2 = "NbPlantsM2";


    public final static String NAMESPACE = "cedric.test";



    public DossierDAO(SQLiteCustom connection, Context context)  {
        super(connection, context);

        try
        {
            factory = XmlPullParserFactory.newInstance( System.getProperty(XmlPullParserFactory.PROPERTY_NAME), null);
        } catch (XmlPullParserException e) {
            Toast.makeText(context,"erreur newInstance",Toast.LENGTH_LONG);
        }
        factory.setNamespaceAware(true);
        try {
            serializer = factory.newSerializer();

        } catch (XmlPullParserException e) {
            Toast.makeText(context,"erreur newSerializer",Toast.LENGTH_LONG);;
        }
        try {

            System.out.println(Environment.getExternalStorageDirectory());



            boolean dirIsPresent = true;
            File docFolder = new File( getContext().getExternalFilesDir(null),"PlantaPolOutput");
            if(!docFolder.exists()){
                dirIsPresent = docFolder.mkdirs();
            }
            if(dirIsPresent){
                file = new File(docFolder.getAbsolutePath(),"out.xml");
                serializer.setOutput(new PrintWriter(file));
            }



            //file = new File(Environment.getDataDirectory())
           // file = new File(String.valueOf(Environment.() + "/Documents/test.xml"));
           // file.createNewFile();

           // serializer.setOutput(new PrintWriter(file));


           /* File docsFolder = new File(Environment.getRootDirectory() + "/Documents");
            boolean isPresent = true;
            if (!docsFolder.exists()) {
                isPresent = docsFolder.mkdir();
            }
            if (isPresent) {
                file = new File(docsFolder.getAbsolutePath(),"test.xml");

                writer = new StringWriter();
                serializer.setOutput(writer);
               // serializer.setOutput(new PrintWriter(file));
            }
*/

        } catch (Exception e) {
            Toast.makeText(context,"erreur setOutput" + file.getAbsolutePath() ,Toast.LENGTH_LONG);
        }


    }

    @Override
    public DossierModel insert(DossierModel model) {

        try {
            serializer.startDocument("UTF-8",true);

            serializer.startTag(NAMESPACE,"Dossiers");
            serializer.startTag(NAMESPACE,"Dossier");

            serializer.startTag(NAMESPACE,"Nom");
            serializer.text(model.getNomDossier());
            serializer.endTag(NAMESPACE,"Nom");

            serializer.startTag(NAMESPACE,"Date");
            serializer.text(model.getDateTime());
            serializer.endTag(NAMESPACE,"Date");

            for(ChambreModel chambreModel : model.getListChambres()){

                serializer.startTag(NAMESPACE,"Chambre");

                    serializer.startTag(NAMESPACE,NOMCHAMBRE);
                    serializer.text(chambreModel.getNom());
                    serializer.endTag(NAMESPACE,NOMCHAMBRE);

                    serializer.startTag(NAMESPACE,LONGUEUR);
                    serializer.text(chambreModel.getLongueur());
                    serializer.endTag(NAMESPACE,LONGUEUR);

                    serializer.startTag(NAMESPACE,LARGEUR);
                    serializer.text(chambreModel.getLargeur());
                    serializer.endTag(NAMESPACE,LARGEUR);

                    serializer.startTag(NAMESPACE,NBPLANTS);
                    serializer.text(chambreModel.getNbPlants());
                    serializer.endTag(NAMESPACE,NBPLANTS);

                    serializer.startTag(NAMESPACE,NBPLANTSM2);
                    serializer.text(chambreModel.getNbPlantsM2());
                    serializer.endTag(NAMESPACE,NBPLANTSM2);

                    serializer.startTag(NAMESPACE,HAUTEUR_PLANTS);
                    serializer.text(chambreModel.getHauteurPlants());
                    serializer.endTag(NAMESPACE,HAUTEUR_PLANTS);

                    serializer.startTag(NAMESPACE,TAILLE_POTS);
                    serializer.text(chambreModel.getTaillePots());
                    serializer.endTag(NAMESPACE,TAILLE_POTS);

                    serializer.startTag(NAMESPACE,NB_LAMPES);
                    serializer.text(chambreModel.getNbLampes());
                    serializer.endTag(NAMESPACE,NB_LAMPES);

                    serializer.startTag(NAMESPACE,PUISSANCE_LAMPES);
                    serializer.text(chambreModel.getPuissanceLampes());
                    serializer.endTag(NAMESPACE,PUISSANCE_LAMPES);

                    serializer.startTag(NAMESPACE,INFO_LAMPES);
                    serializer.text(chambreModel.getMarqueLampes());
                    serializer.endTag(NAMESPACE,INFO_LAMPES);

                    serializer.startTag(NAMESPACE,MODIF_LAMPES);
                    serializer.text(chambreModel.getModifLampes());
                    serializer.endTag(NAMESPACE,MODIF_LAMPES);

                    serializer.startTag(NAMESPACE,NB_EXTRACTEURS);
                    serializer.text(chambreModel.getNbExtracteurs());
                    serializer.endTag(NAMESPACE,NB_EXTRACTEURS);

                    serializer.startTag(NAMESPACE,INFO_EXTRACTEURS);
                    serializer.text(chambreModel.getMarqueExtracteurs());
                    serializer.endTag(NAMESPACE,INFO_EXTRACTEURS);

                    serializer.startTag(NAMESPACE,NB_FILTRES);
                    serializer.text(chambreModel.getNbFiltres());
                    serializer.endTag(NAMESPACE,NB_FILTRES);

                    serializer.startTag(NAMESPACE,INFO_FILTRES);
                    serializer.text(chambreModel.getMarqueFiltres());
                    serializer.endTag(NAMESPACE,INFO_FILTRES);

                    serializer.startTag(NAMESPACE,NB_VENTILATEURS);
                    serializer.text(chambreModel.getNbVentilateurs());
                    serializer.endTag(NAMESPACE,NB_VENTILATEURS);

                    serializer.startTag(NAMESPACE,PUISSANCE_VENTILATEURS);
                    serializer.text(chambreModel.getPuissanceVentilateurs());
                    serializer.endTag(NAMESPACE,PUISSANCE_VENTILATEURS);

                    serializer.startTag(NAMESPACE,INFO_VENTILATEURS);
                    serializer.text(chambreModel.getMarqueVentilateurs());
                    serializer.endTag(NAMESPACE,INFO_VENTILATEURS);

                    serializer.startTag(NAMESPACE,NB_CHAUFFAGES);
                    serializer.text(chambreModel.getNbChauffages());
                    serializer.endTag(NAMESPACE,NB_CHAUFFAGES);

                    serializer.startTag(NAMESPACE,PUISSANCE_CHAUFFAGES);
                    serializer.text(chambreModel.getPuissanceChauffages());
                    serializer.endTag(NAMESPACE,PUISSANCE_CHAUFFAGES);

                    serializer.startTag(NAMESPACE,INFO_CHAUFFAGES);
                    serializer.text(chambreModel.getMarqueChauffages());
                    serializer.endTag(NAMESPACE,INFO_CHAUFFAGES);

                serializer.endTag(NAMESPACE,"Chambre");
            }

            serializer.endTag(NAMESPACE,"Dossier");
            serializer.endTag(NAMESPACE,"Dossiers");
            serializer.endDocument();



        } catch (Exception e) {
            Toast.makeText(this.getContext(),"erreur insert",Toast.LENGTH_LONG).show();
        }
        finally {
            return model;
        }


    }

    @Override
    public DossierModel update(DossierModel model) {
        return null;
    }

    @Override
    public DossierModel delete(DossierModel model) {
        return null;
    }

    @Override
    public DossierModel find(long id) {
        return null;
    }

    @Override
    public List<DossierModel> selectAll() {
        return null;
    }

    @Override
    public List<DossierModel> selectFromForeignKey(long foreignKey) {
        return null;
    }

    @Override
    public void deleteFromForeignKey(long foreignKey) {

    }
}
