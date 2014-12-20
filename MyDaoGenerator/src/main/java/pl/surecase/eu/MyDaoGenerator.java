package pl.surecase.eu;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyDaoGenerator {

    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(3, "greendao");
        Entity catBearFact = schema.addEntity("CatBearFact");
        catBearFact.addIdProperty();
        catBearFact.addStringProperty("name");
        catBearFact.addIntProperty("rating");
        catBearFact.addStringProperty("comment");
        new DaoGenerator().generateAll(schema, args[0]);
    }
}
