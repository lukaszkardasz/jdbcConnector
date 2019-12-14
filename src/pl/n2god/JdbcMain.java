package pl.n2god;

import java.sql.*;

/**
 * @author n2god on 14/12/2019
 * @project jdbcConnector
 */
public class JdbcMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		final String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);

		final String dbPath = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC"; //protokół://host_bazy:port/nazwa_bazy?parametry w postaci klucz=wartość
		Connection conn = DriverManager.getConnection(dbPath, "root", "46812123"); //DriverManager.getConnection(DriverManager.getConnection(dbPath, "root", "46812123")); //Connection conn = DriverManager.getConnection("sciezka_do_bazy_danych", nazwa_uzytkownika, haslo);
		Statement statement = conn.createStatement();

		final String sqlQuery = "SELECT Name, Population FROM city";


		ResultSet resultSet = statement.executeQuery(sqlQuery);
		//metoda, która zwraca w wyniku zbiór wyników otrzymanych w odpowiedzi z bazy w postaci obiektu ResultSet. Będzie więc użyteczna w przypadku zapytań typu SELECT.
		//executeUpdate(String sqlQuery)  - metoda przeznaczona do wykonywania zapytań aktualizacji danych - INSERT, UPDATE, DELETE. W wyniku zwraca ilość rekordów, które dotknęła zmiana
		String cityName = null;
		int cityPopulation = 0;
		while(resultSet.next()){
			cityName = resultSet.getString("Name");
			cityPopulation = resultSet.getInt("Population");
			System.out.println(cityName + " " + cityPopulation);
		}
		if (conn != null){
			conn.close();
		}

	}
}
