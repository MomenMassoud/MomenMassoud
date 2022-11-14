package carstore_soft4u;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler extends Configs{
     private Connection connection;//Inislaize connect
    private DBHandler handler;
    private PreparedStatement pst;

    public Connection getConnection() {//Start Conniction
        try {
            //set Driver
            String con = "jdbc:mysql://" + this.dbhost + ":" + this.dbport + "/" + this.dbname + "?autoReconnect=true&useSSL=false";
            connection = DriverManager.getConnection(con, this.dbuser, this.dbpass);//start conniction
            System.out.println("Connected DataBase");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("no");//if connection filed
        }
        return connection;
    }
    public boolean cheeckEmail_Admin(String email) throws ClassNotFoundException{
        //Admin ad = new Admin();
        String emails;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/car", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin ");
            System.out.println("Done");
            while (rs.next()) {
                //ad.setName(rs.getString("name"));
                //ad.setPassword(rs.getString("password"));
                emails=(rs.getString("email"));
                if(emails.equals(email)){
                    return true;
                }

            }
        } catch (SQLException e) {
            System.out.println("No");
        }
       return false;
    }
    public Admin Get_Admin() throws ClassNotFoundException{
        Admin ad = new Admin();
        String emails;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/car", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin ");
            System.out.println("Done");
            while (rs.next()) {
                ad.setName(rs.getString("name"));
                ad.setPassword(rs.getString("password"));
                ad.setEmail((rs.getString("email")));
            }
        } catch (SQLException e) {
            System.out.println("No");
        }
       return ad;
    }
    
    public boolean cheeckPassword_Admin(String emails,String pass) throws ClassNotFoundException{
        //Admin ad = new Admin();
        String password;
        String email;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/car", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin ");
            System.out.println("Done");
            while (rs.next()) {
                //ad.setName(rs.getString("name"));
                //ad.setPassword(rs.getString("password"));
                email=(rs.getString("email"));
                password=(rs.getString("password"));
                if(password.equals(pass)&& email.equals(emails)){
                    return true;
                }

            }
        } catch (SQLException e) {
            System.out.println("No");
        }
       return false;
    }
    
    public boolean cheeck_car(String CarNumber) throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/car", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from car_info ");
            System.out.println("Done");
            while (rs.next()) {
                if(CarNumber.equals(rs.getString("carNumber"))){
                    return false;
                }

            }
        } catch (SQLException e) {
            System.out.println("No");
        }
       return true;
    }
    public boolean cheeck_ID_Stuff(String ID) throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/car", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from stuff ");
            System.out.println("Done");
            while (rs.next()) {
                if(ID.equals(rs.getString("id"))){
                    return false;
                }

            }
        } catch (SQLException e) {
            System.out.println("No");
        }
       return true;
    }
    public boolean cheeck_NID_Stuff(String NID) throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/car", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from stuff ");
            System.out.println("Done");
            while (rs.next()) {
                if(NID.equals(rs.getString("NationalID"))){
                    return false;
                }

            }
        } catch (SQLException e) {
            System.out.println("No");
        }
       return true;
    }
    
    public void update_Admin_Password(String password, String email) throws SQLException {
        try {
            String insert = "UPDATE admin SET password=?   WHERE email=?";
            pst = connection.prepareStatement(insert);
            pst.setString(1, password);
            pst.setString(2, email);
            pst.executeUpdate();
            System.out.println("Update Password");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    
    
    public void Insert_Car(CarData st) throws SQLException {
        try {
            String insert = "insert into car_info (carNumber,model,year,color,notes,price,ownerID,ownerName) values(?,?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(insert);
            pst.setString(1, st.getCarNumber());
            pst.setString(2, st.getCarModel());
            pst.setString(3, st.getCarYear());
            pst.setString(4, st.getCarColor());
            pst.setString(5, st.getCarNotes());
            pst.setString(6, st.getCarPay());
            pst.setString(7, st.getOwnerNationalID());
            pst.setString(8, st.getCarOwner());
            pst.executeUpdate();
            System.out.println("Add Car");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    public void Insert_Stuff(Stuff st) throws SQLException {
        try {
            String insert = "insert into stuff (id,email,password,name,age,salary,address,NationalID,pic) values(?,?,?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(insert);
            pst.setString(1,st.getId());
            pst.setString(2,st.getEmail());
            pst.setString(3,st.getPassword());
            pst.setString(4,st.getName());
            pst.setString(5,st.getAge());
            pst.setString(6,st.getSalary());
            pst.setString(7,st.getAddress());
            pst.setString(8,st.getNID());
            pst.setString(9,st.getPic());
            pst.executeUpdate();
            System.out.println("Add Car");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    public void del_Stuff(String id) throws SQLException {
        try {
            String insert = "DELETE FROM stuff WHERE (id = ?)";
            pst = connection.prepareStatement(insert);
            pst.setString(1,id);
            pst.executeUpdate();
            System.out.println("Delete Stuff");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    
    
    public int counterStuff() throws ClassNotFoundException, SQLException {
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/supermarket", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(id) as count_stuff FROM stuff");
            System.out.println("Done");
            while (rs.next()) {
                count = Integer.parseInt(rs.getString("count_stuff"));
                System.out.println("Count = " + count);
            }
        } catch (SQLException e) {

        }
        //SELECT COUNT(id) as count_pet FROM pet;
        return count;
    }
    
    public Stuff[] Get_Stuff() throws ClassNotFoundException, SQLException{
        int len=counterStuff();
         Stuff[] ad =new Stuff[len];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/car", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * stuff ");
            System.out.println("Done");
            for(int i=0;i<len;i++){
                
            }
            while (rs.next()) {
               
//                ad.setName(rs.getString("name"));
//                ad.setPassword(rs.getString("password"));
//                ad.setEmail((rs.getString("email")));
            }
        } catch (SQLException e) {
            System.out.println("No");
        }
       return ad;
    }
    
    
    public boolean cheeckIDStuff(String id) throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/car", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * stuff ");
            System.out.println("Done");
            
            while (rs.next()) {
               if(id.equals(rs.getString("id"))){
                   return true;
               }

            }
        }
         catch (SQLException e) {
            System.out.println("No");
        }
        return false;
    }
    
}
