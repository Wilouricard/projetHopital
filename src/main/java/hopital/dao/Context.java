package hopital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import questJdbc.dao.FormationDaoImpl;

public class Context {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static Context singleton = null;

	public static Context getContext() {
		if (singleton == null) {
			singleton = new Context();
		}
		return singleton;
	}

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	private Context() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hopital", "root", "root123@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static DaoVisiteImpl daoVisite = new DaoVisiteImpl();

	public static DaoVisiteImpl getDaoVisite() {
		return daoVisite;
	}
	
	private static DaoCompteImpl daoCompte = new DaoCompteImpl();

	public static DaoCompteImpl getDaoCompte() {
		return daoCompte;
	}
	
	
	private static DaoPatientImpl daoPatient = new DaoPatientImpl();

	public static DaoPatientImpl getDaoPatient() {
		return daoPatient;
	}

	
	public static void destroy() {
		if (singleton != null) {
			singleton.close();
			singleton = null;
		}
	}

	private void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
