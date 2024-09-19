package com.control;

import com.to.User;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateMain {
    public static void main(String[] args) {
       try {
           Configuration configuration = new Configuration().configure();
           configuration.addAnnotatedClass(User.class);
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

//           // Demonstrate ID auto-generation by leaving the userID field empty
//           User user1 = new User("Alice", "Accounting", "CPA", 33);
//           User user2 = new User("Bob", "Human Resource", "Staff", 39);
//           User user3 = new User("Rob", "Sales", "Sales person", 35);
//           User user4 = new User("Amy", "Web", "Front-end Developer", 27);
//           User user5 = new User("Rebecca", "Web", "Graphic Designer", 23);
//           User user6 = new User("Owen", "Advertisement", "Account Manager", 42);
//           User user7 = new User("Lily", "Sales", "Sales person", 32);
//           User user8 = new User("Emily", "Web", "Back-end Developer", 30);
//           session.save(user1);
//           session.save(user2);
//           session.save(user3);
//           session.save(user4);
//           session.save(user5);
//           session.save(user6);
//           session.save(user7);
//           session.save(user8);

            // use HQL to do selection
           String hql = "from User where department=:department order by userName desc";
            Query query = session.createQuery(hql);
            query.setParameter("department", "Web");
            List<User> userList = query.list();
            System.out.println("User details");
            for (User user: userList) {
                System.out.println(user);
            }

           // commit will help to complete the changes in the table
           transaction.commit();
           session.close();
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
}
