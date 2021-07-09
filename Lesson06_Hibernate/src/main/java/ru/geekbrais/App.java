package ru.geekbrais;

import org.hibernate.cfg.Configuration;
import ru.geekbrais.entity.Contact;
import ru.geekbrais.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();
// INSERT for one to many
        em.getTransaction().begin();
        User user = new User(null, "user_with_contacts_2", 25);
        Contact contact1 = new Contact(null, "phone", "1245333", user);
        Contact contact2 = new Contact(null, "email", "user21@mail.com", user);
        Contact contact3 = new Contact(null, "address", "Land1, City2, Street", user);
        user.getContacts().add(contact1);
        user.getContacts().add(contact2);
        user.getContacts().add(contact3);

        em.persist(user);

        em.getTransaction().commit();

        // SELECT

        //User user = em.find(User.class, 11L);
//        User user = em.createQuery("select u from User u join fetch u.contacts where u.id = :id", User.class)
//                .setParameter("id", 11L)
//                .getSingleResult();
//        System.out.println(user);
//        user.getContacts().forEach(System.out::println);

        // N + 1
        //em.createQuery("select c from Contact c join fetch c.user", Contact.class).getResultList();

        em.close();
    }
}
