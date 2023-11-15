import data_db.PersonEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.net.URI;
import java.util.List;

public class GetUsersTest {
    private CloseableHttpClient httpClient;
    private final String apiUrl = "http://77.50.236.203:4879";
    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void setUp() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(PersonEntity.class);
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        httpClient = HttpClients.custom().build(); // Corrected here
    }

    @After
    public void tearDown() {
        if (session != null) {
            session.close();
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
        if (httpClient != null) {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void getUserNames() throws IOException {
        Query<PersonEntity> query = session.createQuery("FROM PersonEntity", PersonEntity.class);
        List<PersonEntity> resultList = query.list();
        for (PersonEntity user : resultList) {
            System.out.println("User ID: " + user.getId() + ", Name: " + user.getFirstName() + " " + user.getSecondName());
        }

        URI uri = URI.create(apiUrl + "/users");
        ClassicHttpRequest request = ClassicRequestBuilder.get().setUri(uri).build(); // Corrected here

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            if (response.getCode() == HttpStatus.SC_OK) {
                System.out.println("Request successful");
            } else {
                System.out.println("Request failed. Status code: " + response.getCode());
            }

            System.out.println("Response body: " + EntityUtils.toString(response.getEntity()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
