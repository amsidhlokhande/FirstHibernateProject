package org.amsidh.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.amsidh.mvc.dtos.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		/* start the transaction */
		session.beginTransaction();

		/* do the database operation */
		for(UserDetails user:getAllUserList())
		{
		session.save(user);
		}
		/* end the transaction */
		session.getTransaction().commit();
		session.close(); 
		new HibernateTest().display(sessionFactory);
		
	}
	@SuppressWarnings("unchecked")
	public void display(SessionFactory sessionFactory)
	{
		Session session = sessionFactory.openSession();

		/* start the transaction */
		session.beginTransaction();

		/* do the database operation */
		List<UserDetails> userList=session.createQuery("from UserDetails").list();
         for(UserDetails user:userList)
         {
        	 System.out.println(user.getUserId()+"  "+user.getUserName()+"   "+user.getJoinedDate()+"   "+user.getAddress()+"      "+user.getDescription());
         }
		/* end the transaction */
		session.getTransaction().commit();
		session.close(); 
	}
	
	public static List<UserDetails> getAllUserList()
	{
		List<UserDetails> userList=new ArrayList<UserDetails>();
		UserDetails user1=new UserDetails("UserName1",new Date(),"PUNE","JAVA");
		userList.add(user1);
		UserDetails user2=new UserDetails("UserName2",new Date(),"SATARA","DOTNET");
		userList.add(user2);
		UserDetails user3=new UserDetails("UserName3",new Date(),"SANGALI","VB");
		userList.add(user3);
		UserDetails user4=new UserDetails("UserName4",new Date(),"SANGAVI","JAVA");
		userList.add(user4);
		UserDetails user5=new UserDetails("UserName5",new Date(),"PIMPARI","C#");
		userList.add(user5);
		return userList;
	}
}
