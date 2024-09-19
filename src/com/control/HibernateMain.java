package com.control;

import com.to.User;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
    public static void main(String[] args) {
       try {
           Configuration configuration = new Configuration().configure();
           configuration.addAnnotatedClass(com.to.User.class);
           StandardServiceRegistryBuilder builder =
                   new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
           // create a SessionFactory from cfg.xml
           SessionFactory factory = configuration.buildSessionFactory(builder.build());
           // open a session
           Session session = factory.openSession();
           // begin a transaction to perform any CRUD operation
           Transaction transaction = session.beginTransaction();
//           // create a user object
//           User user1 = new User(11, "Alice", "Accounting", "Accountant", 25);
//           // create another user object
//           User user2 = new User();
//           user2.setUserID(12);
//           user2.setUserName("Bob");
//           user2.setDepartment("Sales");
//           user2.setPosition("Sales person");
//           user2.setAge(34);
//           // create 3rd user object
//           User user3 = new User(13, "Paige", "Accounting", "CPA", 30);
//           // Just a save statement which automatically creates an insert statement
//           session.save(user1);
//           session.save(user2);
//           session.save(user3);

//           // print info of first existed objet
//           User u = session.get(User.class, 11);
//           System.out.println("The user's details: " + u);
//
//           // delete object from the user table
//           session.delete(u);

           // Demonstrate ID auto-generation by leaving the userID field empty
           User user1 = new User("Windsor", "Accounting", "Accountant", 27);
           User user2 = new User("Will", "Human Resource", "Manager", 45);
           session.save(user1);
           session.save(user2);

           // commit will help to complete the changes in the table
           transaction.commit();
           session.close();
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
}
