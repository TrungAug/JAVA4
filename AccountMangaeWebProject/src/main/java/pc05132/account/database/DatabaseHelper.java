package pc05132.account.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import me.hsgamer.hscore.database.Setting;
import me.hsgamer.hscore.database.client.hibernate.HibernateClient;
import me.hsgamer.hscore.database.driver.sqlserver.SqlServerDriver;
import pc05132.account.entity.Account;

@WebListener
public class DatabaseHelper implements ServletContextListener {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Setting setting = Setting.create(new SqlServerDriver())
				.setHost("localhost")
				.setUsername("admin")
				.setPassword("123456")
				.setDatabaseName("AccountManageWebProject")
				.setDriverProperty("trustServerCertificate",true)
				.setClientProperty(AvailableSettings.HBM2DDL_AUTO, "update")
				;
		HibernateClient client = new HibernateClient(setting);
		client.addEntityClass(Account.class);
		sessionFactory=client.buildSessionFactory();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		sessionFactory.close();
	}
	
}
