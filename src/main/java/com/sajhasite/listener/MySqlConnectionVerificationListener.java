package com.sajhasite.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MySqlConnectionVerificationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		String dbHost = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
		String dbPort = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
		String dbName = System.getenv("OPENSHIFT_APP_NAME");
		String user = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
		String pass = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
		
		String dbUrl = String.format("jdbc:mysql://%s:%s/%s", dbHost, dbPort, dbName);
		
		System.out.println("MySqlConnectionVerificationListener************************************************************");
		System.out.println("MySqlConnectionVerificationListener************************************************************");
		System.out.println("DB Url: " + dbUrl);
		System.out.println("User: " + user);
		System.out.println("Password: " + pass);
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(dbUrl, user, pass);
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from users");
			System.out.println(rs);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
