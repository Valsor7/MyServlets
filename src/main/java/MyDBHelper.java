import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyDBHelper {

    Connection connection = null;
    Statement statement = null;

    public MyDBHelper(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "0409");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(ArrayList<String> params){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users " +
                    "(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)");
            int i = 1;
            for (String str : params)
                preparedStatement.setString(i++, str);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List get(String email, String pass){

        List data = new ArrayList<String>();
        try {
            String registr = "SELECT * FROM users WHERE EMAIL= '" + email + "'";
            String login = "SELECT * FROM users WHERE EMAIL= '" + email + "' AND PASSWORD= '" + pass + "'";
            String  sql = "";
            if (pass == null)
                sql = registr;
            else
                sql = login;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                data.add(resultSet.getString("FIRST_NAME"));
                data.add(resultSet.getString("LAST_NAME"));
                data.add(resultSet.getString("EMAIL"));
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void closeAll() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }


}
