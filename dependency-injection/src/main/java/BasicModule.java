import com.google.inject.AbstractModule;

public class BasicModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MyDatabase.class).to(MyDatabaseImplementation.class);
    }
}
