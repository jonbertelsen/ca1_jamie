package facades;

import dtos.PersonDTO;
import entities.Address;
import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Rename Class to a relevant name Add add relevant facade methods
     */



    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        System.out.println(query+ "også lige her vi mangler ole igen");
        List<Person> persons = query.getResultList();
        System.out.println("kiger her min seje ven, vi mangler ole"+ persons);

        return persons;
    }

    /*public PersonDTO getPerson(int id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p where p.id = :id", Person.class);
        query.setParameter("id", id);
        Person person = query.getSingleResult();

        return new PersonDTO(person);
    }

    public PersonDTO addPerson(String firstName, String lastName, String phone, String email, Address address) {
        EntityManager em = emf.createEntityManager();
        Person person = new Person(firstName, lastName, phone, email, address);
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();

        return new PersonDTO(person);
    }

    public PersonDTO editPerson(int id) {
        EntityManager em = emf.createEntityManager();
    }*/


}
