package com.example.salesforcegcp;

import com.example.salesforcegcp.repository.BrowserHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.data.datastore.repository.config.EnableDatastoreRepositories;

@SpringBootApplication
@EnableDatastoreRepositories
public class SalesforceGCPApplication {


	public static void main(String[] args) {
		SpringApplication.run(SalesforceGCPApplication.class, args);
	}
/**
	public void configure() throws Exception {
		moveAllFile();
	}

	private void moveAllFile() {

		Connection connection = null;
		try {
			System.out.println("DRIVER CONNECTING");
			connection = DriverManager.getConnection(
					"jdbc:sap://968d5dc9-b0b5-4b31-8601-bcee12b223bd.hana.trial-us10.hanacloud.ondemand.com:443/?autocommit=false", "DBADMIN", "Venu!123");

		} catch (SQLException e) {
			System.err.println("Connection Failed:");
			System.err.println(e);
			return;
		}
		if (connection != null) {
			try {
				System.out.println("Connection to HANA successful!");
				Statement stmt = connection.createStatement();
				ResultSet resultSet = stmt.executeQuery("Select * From Employee");
				resultSet.next();
				String hello = resultSet.getString(2);
				System.out.println(hello);
			} catch (SQLException e) {
				System.err.println("Query failed!");
			}
		}

		BrowserHistory abcd = new BrowserHistory();
		Long a = Long.valueOf(1);
		abcd.setId(a);
		abcd.setName("from gopal codew");
		abcd.setUrl("VENU Salesforce URL");
		browserHistoryRepo.save(abcd);

		System.out.println("SAVED TO GCP");

	}
 */
}
