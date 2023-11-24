import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BasicModule());
        TerminalInterface iface = injector.getInstance(TerminalInterface.class);

        try {
            iface.addUser();
            iface.showPassword();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
