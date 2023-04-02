package com.staff.manage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StaffDao {

    public static boolean addNewStaff(Staff obj) {
        boolean f=false;
        try {
            Connection con = ConnectionBuilder.createConnection();
            String query = "insert into staff(name,age,city,id,phone,salary) values (?,?,?,?,?,?)";

            PreparedStatement prs = con.prepareStatement(query);
            prs.setString(1, obj.getName());
            prs.setInt(2, obj.getAge());
            prs.setString(3, obj.getCity());
            prs.setInt(4,obj.getId());
            prs.setLong(5,obj.getPhone());
            prs.setLong(6,obj.getSalary());

            prs.executeUpdate();
            f=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
    public static boolean upgradeStaffDetails(int id, int upgradeChoice) {
        boolean f= false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Connection con = ConnectionBuilder.createConnection();
            switch (upgradeChoice){
                case 1 ->{
                    System.out.print("enter new name : ");
                    String newName = br.readLine();
                    String query = "update staff set name=? where id=?";

                    PreparedStatement prs = con.prepareStatement(query);
                    prs.setString(1,newName);
                    prs.setInt(2,id);

                    prs.executeUpdate();
                    f=true;
                }
                case 2->{
                    System.out.print("enter new age : ");
                    int newAge = Integer.parseInt(br.readLine());

                    String query = "update staff set age=? where id=?";
                    PreparedStatement prs= con.prepareStatement(query);

                    prs.setInt(1,newAge);
                    prs.setInt(2,id);

                    prs.executeUpdate();
                    f=true;
                }
                case 3->{
                    System.out.print("enter new city : ");
                    String newCity = br.readLine();

                    String query = "update staff set city=? where id=?";
                    PreparedStatement prs = con.prepareStatement(query);

                    prs.setString(1,newCity);
                    prs.setInt(2,id);

                    prs.executeUpdate();
                    f=true;
                }
                case 4->{
                    System.out.print("enter new phone num");
                    long newPhone = Long.parseLong(br.readLine());

                    String query = "update staff set phone=? where id=?";
                    PreparedStatement prs = con.prepareStatement(query);

                    prs.setLong(1,newPhone);
                    prs.setInt(2,id);

                    prs.executeUpdate();
                    f=true;
                }
                case 5->{
                    System.out.print("enter new salary amount : ");
                    long newSalary = Long.parseLong(br.readLine());

                    String query = "update staff set salary=? where id=? ";
                    PreparedStatement prs = con.prepareStatement(query);

                    prs.setLong(1,newSalary);
                    prs.setLong(2,id);

                    prs.executeUpdate();
                    f=true;
                }
                default -> {
                    System.out.println("choose from given options");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
    public static boolean removeOrDeleteStaff(String name, int id) {
        boolean f = false;
        try {
            Connection con = ConnectionBuilder.createConnection();
            String query = "delete from staff where name=? and id=?";

            PreparedStatement prs = con.prepareStatement(query);
            prs.setString(1,name);
            prs.setInt(2,id);

            prs.executeUpdate();
            f=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
    public static void displayAllStaff() {
        try {
            Connection con = ConnectionBuilder.createConnection();
            String query = "select * from staff";

            Statement stmt = con.createStatement();

            ResultSet result =stmt.executeQuery(query);

            while (result.next()){
                String name = result.getString(1);
                int age = result.getInt(2);
                String city = result.getString(3);
                int id = result.getInt(4);
                long phone = result.getLong(5);
                long salary = result.getLong(6);

                System.out.println("name : "+name);
                System.out.println("age : "+age);
                System.out.println("city : "+city);
                System.out.println("id : "+id);
                System.out.println("phone : "+phone);
                System.out.println("salary : "+salary);
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
