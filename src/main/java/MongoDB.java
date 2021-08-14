import com.google.gson.Gson;
import com.mongodb.client.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.bson.Document;

import java.util.ArrayList;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.eq;

public class MongoDB implements IMongoDB {

    Dotenv dotenv = Dotenv.load();
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;
    String uri = "mongodb+srv://mtomlinson:" + dotenv.get("PASSWORD") +
            "@cluster0.asoue.mongodb.net/blackjack?retryWrites=true&w=majority";

    public MongoDB() {
        this.mongoClient = MongoClients.create(uri);
        this.database = mongoClient.getDatabase("blackjack");
        this.collection = database.getCollection("players");
    }

    @Override
    public void create(Player player) {
        String playerJson = new Gson().toJson(player);
        Document document = Document.parse(playerJson);
        collection.insertOne(document);
    }

    @Override
    public ArrayList<Player> retrieveAllPlayers() {
        Gson gson = new Gson();
        ArrayList<Player> allPlayers = new ArrayList<Player>();
        FindIterable<Document> result = collection.find();
        result.forEach((Consumer<? super Document>) document -> {
            Player player = gson.fromJson(document.toJson(), Player.class);
            allPlayers.add(player);
        });
        return allPlayers;
    }

    @Override
    public Player retrievePlayer(String playerName) {
        Gson gson = new Gson();
        Document retrievedPlayer = collection.find(eq("name", playerName)).first();
        if (retrievedPlayer == null){
            return null;
        }
        Player player = gson.fromJson(retrievedPlayer.toJson(), Player.class);
        return player;
    }

    @Override
    public void updatePlayerChips(Player player) {
        collection.updateOne(eq("name", player.getName()),
                new Document("$set", new Document("chips", player.getChips())));
    }
}
