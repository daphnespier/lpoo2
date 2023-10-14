package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectionFactory {

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM autor";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                System.out.println("ID: " + id + ", Nome: " + nome);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Connection getConnection() {
        try {
            String jdbcUrl = "jdbc:sqlite:C:\\Users\\mateu\\Downloads\\Tarefa6\\tarefa6bd.db";
            return DriverManager.getConnection(jdbcUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
