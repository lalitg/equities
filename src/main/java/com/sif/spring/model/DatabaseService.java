package com.sif.spring.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class DatabaseService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseService rec = new DatabaseService();
			rec.save_user_details("lalit","lalit","lalit0509@gmail.com","Software Developer");
			//rec.save_app_details("1","9990481558","a.b@gmail.com","1.2");
			//rec.save_app_details("2","9990481558","a.b@gmail.com","1.3");
			//rec.save_app_details("2","9990481560","a.b@gmail.com","1.4");			
		}
	
	public void save_user_details(String username, String password, String email, String profession){
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//User app = (User)session.get(User.class, username);
		//if(app==null){
		User	app = new User();
		//}
		app.setUsername(username);
		app.setPassword(password);
		app.setEmail(email);
		app.setProfession(profession);
		session.save(app);
		session.getTransaction().commit();
		session.close();
	}
	
	public boolean is_user(String username, String password){
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User app = (User)session.get(User.class, username);
		session.getTransaction().commit();
		session.close();
		if(app==null) return false;		
		else if (!app.getPassword().equals(password)) return false;
		else return true;
	}

}
