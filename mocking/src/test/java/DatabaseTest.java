import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.*;

public class DatabaseTest {
    static Connection connection = Mockito.mock(Connection.class);
    static PreparedStatement statement = Mockito.mock(PreparedStatement.class);
    static ResultSet results = Mockito.mock(ResultSet.class);

    @BeforeClass
    public static void setUp() throws SQLException {
        Mockito.when(results.getString(
                Mockito.anyString())
        ).thenReturn("Foo Bar");

        // First call returns true, second call doesn't
        Mockito.when(results.next())
                .thenReturn(true)
                .thenReturn(false);

        Mockito.when(statement.executeQuery())
                .thenReturn(results);

        Mockito.when(connection.prepareStatement(
                "SELECT * FROM person WHERE age = 20")
        ).thenReturn(statement);
    }


    @Test
    public void queryTest() throws SQLException {
        String query = "SELECT * FROM person WHERE age = 20";

        Connection connection = this.connection;
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet results = statement.executeQuery();

        while (results.next()) {
            Assert.assertEquals("Foo Bar", results.getString("name"));
        }
    }
}
