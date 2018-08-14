import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.swing.text.Document;
import java.lang.*;

public class UserDB {
    public static void Registration(String username, long useRid){
        try{
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
            MongoDatabase db = mongoClient.getDatabase("userdb");
            MongoCollection<org.bson.Document> collec = db.getCollection("userlist");

            org.bson.Document doc = new org.bson.Document()
                    .append("Name:",username).append("Id:", useRid);
            collec.insertOne(doc);

        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }

    }

}
