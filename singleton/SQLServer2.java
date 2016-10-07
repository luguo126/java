import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class Myobject {
	public enum MyEnumSingleton {
		connectionFactory;
		private Connection connection;
		private MyEnumSingleton() {
			try {
				String url = "jsbc:sqlserver://localhost:1079; databaseName=xxx";
				String username = "sa";
				String password = "";
				String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
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

	public static Connection getConnection() {
		return MyEnumSingleton.connectionFactory.getConnection();
	}
}


class Mythread extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(Myobject.getConnection().hashCode());
		}
	}
}



public class SQLServer2 {
	public static void main(String[] args) {
		Mythread t1 = new Mythread();
		Mythread t2 = new Mythread();
		Mythread t3 = new Mythread();

		t1.start();
		t2.start();
		t3.start();
	}
}
