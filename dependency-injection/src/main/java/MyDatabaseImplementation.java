import java.util.HashMap;
import java.util.Map;

public class MyDatabaseImplementation implements MyDatabase {
    private static Map<String, String> database = new HashMap<>();

    @Override
    public void put(String key, String value) {
        database.put(key, value);
        System.out.println("Data saved to database!");
    }

    @Override
    public String get(String key) {
        System.out.println("Retrieving data from database ...");
        return database.get(key);
    }
}
