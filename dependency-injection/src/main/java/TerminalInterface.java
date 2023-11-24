import com.google.inject.Inject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalInterface {
    private MyDatabase database;

    @Inject
    public TerminalInterface(MyDatabase database) {
        this.database = database;
    }

    public void addUser() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Username:");
        String username = br.readLine();
        System.out.println("Password:");
        String password = br.readLine();

        database.put(username, password);
    }

    public void showPassword() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Username:");
        String username = br.readLine();
        String password = database.get(username);
        System.out.println("Password: " + password);
    }
}
