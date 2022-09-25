package com.demoROM.producingwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class ProducingWebServiceApplication {
	//
	public static final  String USER = "postgres";
	public static final  String PASSWORD = "12345678";

	public static void main(String[] args) {
		initPostgresDB();
		initTableInDB();
		SpringApplication.run(ProducingWebServiceApplication.class, args);
	}

	public static void initPostgresDB(){

		System.out.println("Create DataBase");
		try (Connection db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", USER, PASSWORD)) {
			String sqlCreateDB = new String("create database  test_soap_db");
			Statement stmt = db.createStatement();
			stmt.execute(sqlCreateDB);
		}
		catch(SQLException e){
			e.printStackTrace();
		}

	}

	public static void initTableInDB(){
		System.out.println("Create TABLES");
		//String sql = new String(Files.readAllBytes(Paths.get("script.sql")));

		try (Connection db = DriverManager.getConnection("jdbc:postgresql://localhost/test_soap_db", USER, PASSWORD)) {
			String sql = new String(Files.readAllBytes(Paths.get("src/main/resources/createDB.sql")));
			Statement stmt = db.createStatement();
			stmt.execute(sql);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
