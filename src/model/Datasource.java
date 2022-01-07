package model;

import java.sql.*;

public class Datasource {

    public static final String DB_NAME = "test.db";
    public static final String CONNECTION_STRING = "jdbc::sqlite:C:\\Users\\Kris\\Desktop\\DBS\\" + DB_NAME;

    public static final String TABLE_PERSON = "person";
    public static final String COLUMN_PERSON_ID = "_id";
    public static final String COLUMN_PERSON_NAME = "name";
    public static final String COLUMN_PERSON_PHONE = "phone";

    public static final String TABLE_PARCEL = "parcel";
    public static final String COLUMN_PARCEL_ID = "_id";
    public static final String COLUMN_PARCEL_SENDER = "sender";
    public static final String COLUMN_PARCEL_RECEIVER = "receiver";
    public static final String COLUMN_PARCEL_PRICE = "price";
    public static final String COLUMN_PARCEL_WEIGHT = "weight";
    public static final String COLUMN_PARCEL_DESTINATION = "destination";

    //SELECT person._id FROM person WHERE person.name =?, person.phone =?
    public static final String QUERY_PERSON = "SELECT " + COLUMN_PERSON_ID +
            " FROM " + TABLE_PERSON + " WHERE " + COLUMN_PERSON_NAME + " =?, " + COLUMN_PERSON_PHONE + " =?";

    //"INSERT INTO person (name, phone) VALUES (?, ?)
    public static final String INSERT_PERSON = "INSERT INTO " + TABLE_PERSON +
            "(" + COLUMN_PERSON_NAME + ", " + COLUMN_PERSON_PHONE + ") VALUES (?, ?)";

    //"INSERT INTO parcel (senderId, receiverId, price, weight, destination) VALUES (?, ?, ?, ?, ?)
    public static final String INSERT_PARCEL = "INSERT INTO " + TABLE_PARCEL +
            "(" + COLUMN_PARCEL_SENDER + ", " + COLUMN_PARCEL_RECEIVER + ", " + COLUMN_PARCEL_PRICE +
            ", " + COLUMN_PARCEL_WEIGHT + ", " + COLUMN_PARCEL_DESTINATION + ") VALUES (?, ?, ?, ?, ?)";

//    public static final String INSERT_PARCEL;

    private Connection connection;

    private PreparedStatement insertIntoPerson;
    private PreparedStatement insertIntoParcel;

    private PreparedStatement queryPerson;

    public boolean open() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);

            insertIntoPerson = connection.prepareStatement(INSERT_PERSON, Statement.RETURN_GENERATED_KEYS);
            insertIntoParcel = connection.prepareStatement(INSERT_PARCEL);

            queryPerson = connection.prepareStatement(QUERY_PERSON);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to DB " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }

            if(insertIntoPerson != null) {
                insertIntoPerson.close();
            }

            if(insertIntoParcel != null) {
                insertIntoParcel.close();
            }

            if(queryPerson != null) {
                queryPerson.close();
            }

        } catch (SQLException e) {
            System.out.println("Couldn't close the connection " + e.getMessage());
            e.printStackTrace();
        }
    }

    private int insertPerson(Client person) throws SQLException {
        String name = person.getName();
        String phone = person.getPhone();

        queryPerson.setString(1, name);
        queryPerson.setString(2, phone);
        ResultSet results = queryPerson.executeQuery();
        if (results.next()) {
            return results.getInt(1);
        } else {
            //Insert the person into DB
            insertIntoPerson.setString(1, name);
            insertIntoPerson.setString(2, phone);
            int affectedRows = insertIntoPerson.executeUpdate();

            if(affectedRows != 1) {
                throw new SQLException("Couldn't insert person");
            }

            ResultSet generatedKeys  = insertIntoPerson.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for person");
            }
        }
    }

    public void insertParcel(Parcel parcel) {
        try {
            int senderId = insertPerson(parcel.getSender());
            int receiverId = insertPerson(parcel.getReceiver());
            double price = parcel.getPrice();
            double weight = parcel.getWeight();
            String destination = parcel.getAddress();

            insertIntoParcel.setInt(1, senderId);
            insertIntoParcel.setInt(2, receiverId);
            insertIntoParcel.setDouble(3, price);
            insertIntoParcel.setDouble(4, weight);
            insertIntoParcel.setString(5, destination);
            int affectedRows = insertIntoPerson.executeUpdate();
            if(affectedRows != 1) {
                throw new SQLException("Parcel insert failed");
            }

        } catch (Exception e) {
            System.out.println("Insert parcel exception: " + e.getMessage());
        }

    }
}
