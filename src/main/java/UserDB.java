import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.lang.*;

public class UserDB {

    protected  MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    protected MongoDatabase db = mongoClient.getDatabase("userdb");



    public  void Registration(String username, long useRid){
        try{
            MongoCollection<org.bson.Document> collec = db.getCollection("userlist");
            FindIterable<org.bson.Document> check = collec.find(new org.bson.Document().append("Id:", useRid));

            MongoCursor<org.bson.Document> cursor = check.iterator();
            if(check == null){
            org.bson.Document doc = new org.bson.Document()
                    .append("Name:",username).append("Id:", useRid);
            collec.insertOne(doc);
            }

        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }

    }

}
