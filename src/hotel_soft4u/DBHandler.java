package hotel_soft4u;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBHandler extends Configs{
    String password, user_name;//This Varibale to save who is login
    private Connection connection;//Inislaize connect
    private DBHandler handler;
    private PreparedStatement pst;
    public Connection getConnection() {//Start Conniction
        try {
            //set Driver
            String con = "jdbc:mysql://" + this.dbhost + ":" + this.dbport + "/" + this.dbname + "?autoReconnect=true&useSSL=false";
            connection = DriverManager.getConnection(con, this.dbuser, this.dbpass);//start conniction
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("no");//if connection filed
        }
        return connection;
    }
    
    public void conStuff(String pass,String email) throws SQLException {
        try {
            String insert = "UPDATE stuff SET password=?  WHERE email=?";
            pst = connection.prepareStatement(insert);
            pst.setString(1, pass);
            pst.setString(2, email);
            pst.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    
    public void con(String pass,String email) throws SQLException {
        try {
            String insert = "UPDATE admin SET password=?  WHERE email=?";
            pst = connection.prepareStatement(insert);
            pst.setString(1, pass);
            pst.setString(2, email);
            pst.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    
    public void del_stuff(String ID) throws SQLException {
        try {
            String insert = "DELETE FROM stuff WHERE (id = ?)";
            pst = connection.prepareStatement(insert);
            pst.setString(1, ID);
            pst.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    
    public void del_client(String ID) throws SQLException {
        try {
            String insert = "DELETE FROM client WHERE (nationaltyID = ?)";
            pst = connection.prepareStatement(insert);
            pst.setString(1, ID);
            pst.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    
   
    
    public void insert_stuff(String firstname,String LastName,String email,String password,String id,String NID,String Npic,String gender,String salary,String age,String address,String phonenumber,String jop) throws SQLException {
        try {
            String insert = "INSERT INTO stuff (firstname, lastname, email,password,id,NationalID,NationalID_picutre,Gender,Salary,Age,Address,PhoneNumber,Jop) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(insert);
            pst.setString(1, firstname);
            pst.setString(2, LastName);
            pst.setString(3, email);
            pst.setString(4, password);
            pst.setString(5, id);
            pst.setString(6, NID);
            pst.setString(7, Npic);
            pst.setString(8, gender);
            pst.setString(9, salary);
            pst.setString(10, age);
            pst.setString(11, address);
            pst.setString(12, phonenumber);
            pst.setString(13, jop);
            pst.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    
    
    
    public void insert_client(String firstname,String LastName,String phoneNumber,String nationalty,String nationalid,String gender,String time,String startDate,String endDate,String roomid,String checkOut) throws SQLException {
        
        try {
            String insert = "INSERT INTO client (firstname, lastname, phonenumber,nationalty,nationaltyID,gender,time,startdate,enddate,roomID,out) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(insert);
            pst.setString(1, firstname);
            pst.setString(2, LastName);
            pst.setString(3, phoneNumber);
            pst.setString(4, nationalty);
            pst.setString(5, nationalid);
            pst.setString(6, gender);
            pst.setString(7, time);
            pst.setString(8, startDate);
            pst.setString(9, endDate);
            pst.setString(10, roomid);
            pst.setString(11, checkOut);
            pst.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    
    
}
