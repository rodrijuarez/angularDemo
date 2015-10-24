package ngdemo.dao;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import ngdemo.domain.Receta;

import java.net.UnknownHostException;

/**
 * Created by rodri on 10/24/2015.
 */
public class RecetaDao {
    public void create(Receta receta) {
        MongoClient mongo = null;
        try {
            mongo = new MongoClient("localhost",27017);
            DB db = mongo.getDB("angularDemo");
            DBCollection collection = db.getCollection("recetas");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
