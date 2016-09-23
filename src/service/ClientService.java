package service;

import model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class ClientService {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void addClient(Client client) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
    }

    public void updateClient(Client client) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(client);
        session.getTransaction().commit();
    }

    public List<Client> getAllClients() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Client> result = session.createQuery("from Client").list();
        session.getTransaction().commit();
        return result;
    }

    public Client getClientById(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Client client=(Client)session.get(Client.class, new Integer(id));
        session.getTransaction().commit();
        return client;
    }

    public void deleteClient(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Client client=(Client)session.load(Client.class, new Integer(id));
        if (client!=null)
            session.delete(client);
        session.getTransaction().commit();
    }
}
