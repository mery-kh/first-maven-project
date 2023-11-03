import io.restassured.RestAssured;
import org.example.data_db.PersonEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class GetUsers {

    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void setUp() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Load your test Hibernate configuration
        configuration.addAnnotatedClass(PersonEntity.class);
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @After
    public void tearDown() {
        if (session != null) {
            session.close();
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    public void getUserNames() {
        Query<PersonEntity> query = session.createQuery("FROM PersonEntity", PersonEntity.class);
        List<PersonEntity> resultLіst = query.list();
        for (PersonEntity user : resultLіst) {
            System.out.println("User ID: " + user.getId() + ", Name: " + user.getFirstName() + " " + user.getSecondName());
        }
                RestAssured.baseURI = "http://77.50.236.203:4879";
                RestAssured.given()
                .when()
                .get("/users")
                .then()
                .statusCode(200);
    }
}