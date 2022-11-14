package supermarket;

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
    
     public void con(String pass,String email) throws SQLException {
        try {
            String insert = "UPDATE admin SET password=?  WHERE email=?";
            pst = connection.prepareStatement(insert);
            pst.setString(1, pass);
            pst.setString(2, email);
            pst.executeUpdate();
            System.out.println("Update Password");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
     
     
     public void update_Item(String id,String price,String qty) throws SQLException {
        try {
            String insert = "UPDATE item SET price=? , Qty=?  WHERE id=?";
            pst = connection.prepareStatement(insert);
            pst.setString(1, price);
            pst.setString(2, qty);
            pst.setString(3, id);
            pst.executeUpdate();
            System.out.println("Update Password");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    
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
    public Admin get_admin() throws ClassNotFoundException{
        
        Admin ad=new Admin();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/supermarket", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin ");
            System.out.println("Done");
            while (rs.next()) {
                ad.setName(rs.getString("name"));
                ad.setEmail(rs.getString("email"));
                ad.setPass(rs.getString("password"));

            }
        } catch (SQLException e) {
            System.out.println("No");
        }
        return ad;
    }
    public Item get_item(String QR) throws ClassNotFoundException{
        
        Item it=new Item();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/supermarket", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from item ");
            System.out.println("Done");
            while (rs.next()) {
                it.setProductID(rs.getString("id"));
                it.setProductName(rs.getString("Name"));
                it.setProductPrice(rs.getString("price"));
                it.setCount(rs.getString("Qty"));
                if(it.getProductID().equals(QR)){
                    System.out.println(it.getProductID());
                    break;
                }

            }
        } catch (SQLException e) {
            System.out.println("No");
        }
        return it;
    }
    
    public ItemsView[] get_item_pay(String id) throws ClassNotFoundException, SQLException{
        int len=counter_Item_Pay();
        ItemsView[] it=new ItemsView[len];
        Double total=0.0;int q;
        int i=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/supermarket", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from item_pay ");
            System.out.println("Done");
            while (rs.next()) {
                it[i]=new ItemsView();
                it[i].setId(rs.getString("id_product"));
                it[i].setName(rs.getString("productName"));
                it[i].setPrice(rs.getString("productPrice"));
                it[i].setQty(rs.getString("productQty"));
                q=Integer.parseInt(it[i].getQty());
                total=q*Double.parseDouble(it[i].getPrice());
                it[i].setTotal(String.valueOf(total));
                it[i].invoic=rs.getString("inviceID");
                i++;
            }
        } catch (SQLException e) {
            System.out.println("No");
        }
        return it;
    }
    
    
    public ItemsView[] get_Allitem() throws ClassNotFoundException, SQLException{
        int len=counter();
        ItemsView[] it=new ItemsView[len];
        Double total=0.0;int q;
        int i=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/supermarket", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from item ");
            System.out.println("Done");
            while (rs.next()) {
                it[i]=new ItemsView();
                it[i].setId(rs.getString("id"));
                it[i].setName(rs.getString("Name"));
                it[i].setPrice(rs.getString("price"));
                it[i].setQty(rs.getString("Qty"));
                q=Integer.parseInt(it[i].getQty());
                total=q*Double.parseDouble(it[i].getPrice());
                it[i].setTotal(String.valueOf(total));
                i++;
            }
        } catch (SQLException e) {
            System.out.println("No");
        }
        return it;
    }
    
    
     public pay[] getALLINVOICE() throws ClassNotFoundException, SQLException{
         int len=counterPay();
         pay hh[]=new pay[len];
        int i=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/supermarket", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from invoice ");
            System.out.println("Done");
            while (rs.next()) {
                hh[i]=new pay();
                hh[i].setId(rs.getString("id"));
                hh[i].setPay(rs.getString("Pay"));
                hh[i].setBalance(rs.getString("Balance"));
                hh[i].setTotal(rs.getString("Total"));
                hh[i].setDate(rs.getString("Date"));                
            }
        } catch (SQLException e) {
            System.out.println("No");
        }
        return hh;
    }
    
    public void get(String DataIN) throws ClassNotFoundException, SQLException{
        String date;
        int i=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/supermarket", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from invoice ");
            System.out.println("Done");
            while (rs.next()) {
                date=(rs.getString("Date"));
                if(date.equals(DataIN)){
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("No");
        }
    }
    public int counterPay() throws ClassNotFoundException, SQLException {
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/supermarket", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(id) as count_stuff FROM invoice");
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
    
    public int counter_Item_Pay() throws ClassNotFoundException, SQLException {
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/supermarket", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(id_product) as count_stuff FROM item_pay");
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
    
    public int counter() throws ClassNotFoundException, SQLException {
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/supermarket", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(id) as count_stuff FROM item");
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
    
    
    
    public void insert_item(String id,String name,String price,String qty) throws SQLException {
        
        try {
            String insert = "INSERT INTO item (id,Name,price,Qty) VALUES (?,?,?,?)";
            pst = connection.prepareStatement(insert);
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, price);
            pst.setString(4, qty);
            pst.executeUpdate();
            System.out.println("Add Item");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    
    
    
}
