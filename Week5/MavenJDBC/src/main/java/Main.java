import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Phone p1 = new Phone("Apple", "iPhone X", "126");
        Phone p2 = new Phone("Apple", "iPhone 13 Pro", "512");
        Phone p3 = new Phone("Samsung", "S20", "256");
//        insert("phone", p1);
//        insert("phone", p2);
//        insert("phone", p3);
        update("phone", "brand", "Nokia", 1);
        select("phone");
        delete("phone", 3);
        System.out.println();
        select("phone");
    }

    public static void select(String table) {
        try {
            Class.forName(DBConfig.DRIVER);
            Connection connection =
                    DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
            Statement statement = connection.createStatement();
            if (table.equals("car")) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM car");
                while (resultSet.next()) {
                    System.out.printf("%s | %s | %s | %s | %s%n",
                            resultSet.getString(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4),
                            resultSet.getString(5));
                }
            } else if (table.equals("phone")) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM phone");
                while (resultSet.next()) {
                    System.out.printf("%s | %s | %s | %s%n",
                            resultSet.getString(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert(String table, Object object) {
        try {
            Class.forName(DBConfig.DRIVER);
            Connection connection =
                    DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
            String sql = "";
            switch (table) {
                case "car":
                    Car car = (Car) object;
                    sql = String.format("INSERT INTO car (brand, model, `year`, color) " +
                            "VALUES ('%s', '%s', %s, '%s')", car.getBrand(), car.getModel(), car.getYear(), car.getColor());
                    break;
                case "phone":
                    Phone phone = (Phone) object;
                    sql = String.format("INSERT INTO phone (`brand`, `model`, `phoneMemory`) " +
                            "VALUES ('%s', '%s', %s)", phone.getBrand(), phone.getModel(), phone.getPhoneMemory());
                    break;
            }
            Statement statement = connection.createStatement();
            statement.execute(sql);
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(String table, String column, String value, int id) {
        try {
            Class.forName(DBConfig.DRIVER);
            Connection connection =
                    DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(table.equals("car")
                    ? String.format("UPDATE car SET %s = '%s' WHERE idcar = %d", column, value, id)
                    : String.format("UPDATE phone SET %s = '%s' WHERE idphone = %d", column, value, id));
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String table, int id) {
        try {
            Class.forName(DBConfig.DRIVER);
            Connection connection =
                    DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(table.equals("car") ? "DELETE FROM car WHERE idcar = " + id
                    : "DELETE FROM phone WHERE idphone = " + id);
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}