
import Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Test {

    static User user = new User();
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    private static SessionFactory buildSessionFactory() {
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

    public static void main(String[] args) {
        try {
            sessionFactoryObj = HIbernateUtil.getSessionFactory();
            sessionObj = sessionFactoryObj.getCurrentSession();

            sessionObj.beginTransaction();
            user.setId((Long.valueOf("123")));
            user.setUserName("cac");
            user.setPassWord("loz");
            sessionObj.save(user);

            System.out.println("\n.......Records Saved Successfully To The Database.......\n");

            sessionObj.getTransaction().commit();
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }

    }

    /* (non-Java-doc)
     * @see java.lang.Object#Object()
     */
    public Test() {
        super();
    }

}