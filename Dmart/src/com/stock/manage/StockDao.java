package com.stock.manage;

import com.staff.manage.ConnectionBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StockDao {
    public static boolean addNewProduct(String name, int quantity, int itemCode, int price) {
        boolean f = false;
        try {
            Connection con = ConnectionBuilder.createConnection();
            String query = "insert into stock (product,quantity,item_code,price) values(?,?,?,?)";
            String total_value = "update stock set total_value = quantity * price";

            PreparedStatement prs = con.prepareStatement(query);
            prs.setString(1,name);
            prs.setInt(2,quantity);
            prs.setInt(3,itemCode);
            prs.setInt(4,price);

            prs.executeUpdate();

            Statement statement = con.createStatement();
            statement.execute(total_value);

            f=true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return  f;
    }
    public static boolean addProductQuantity(String productName, int addQuantity) {
        boolean f = false;
        try {
            Connection con = ConnectionBuilder.createConnection();
//            String stockQuery = "update stock set quantity=quantity+? where product=?";     //mistake
//            String valueQuery = "update stock set total_value = price * quantity";            //mistake

            String stockQuery = "update stock set quantity = quantity + ?, total_value = price*quantity where product = ?";

            PreparedStatement prs = con.prepareStatement(stockQuery);

//            Statement stmt = con.createStatement();               //mistake
//            stmt.execute(valueQuery);                             //mistake

            prs.setInt(1,addQuantity);
            prs.setString(2,productName);


            prs.executeUpdate();
            f=true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
    public static boolean lessNewProduct(String productName, int lessQuantity) {
        boolean f=false;
        try {
            Connection con = ConnectionBuilder.createConnection();
            String query ="update stock set quantity= quantity-? , total_value = quantity*price where product=?";

            PreparedStatement prs = con.prepareStatement(query);

            prs.setInt(1,lessQuantity);
            prs.setString(2,productName);

            prs.executeUpdate();
            f=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
    public static void getTotal(int totalChoice) {
        try {
            Connection con = ConnectionBuilder.createConnection();
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            switch (totalChoice){
                case 1->{
                    System.out.println("enter name of product to know total value of stock");
                    String proName = br.readLine();

                    String query = "select total_value from stock where product=?";
                    PreparedStatement prs = con.prepareStatement(query);
                    prs.setString(1,proName);

                    ResultSet resultSet = prs.executeQuery();
                    while (resultSet.next()){
                        int total = resultSet.getInt(1);
                        System.out.println("total value : "+total);
                    }
                }
                case 2->{
                    try {
                        String query = "select sum(total_value) from stock";
                        Statement st = con.createStatement();
                        ResultSet result = st.executeQuery(query);
                        while (result.next()){
                            int grandTotal = result.getInt(1);
                            System.out.println("Grand total inventory value : "+grandTotal);
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
