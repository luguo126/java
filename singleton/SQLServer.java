import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


enum Myobject {
	connectionFactory;

	private Connection connection;

	private Myobject() {
		try {
			String url = "jdbc:sqlserver://localhost:1079; databaseName=xxx";
			String username = "sa";
			String password = "";
			String driverName = 
				"com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driverName);
			connection = DriverManager.getConnection(
				url, username, password);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
}


class Mythread extends Thread {
	@Override
	public void run() {
		for(int i=0; i < 5; i++) {
			System.out.println(
			Myobject.connectionFactory.getConnection().hashCode());
		}
	}
}



public class SQLServer {
	public static void main(String[] args) {
		Mythread t1 = new Mythread();
		Mythread t2 = new Mythread();
		Mythread t3 = new Mythread();

		t1.start();
		t2.start();
		t3.start();
	} 
}












