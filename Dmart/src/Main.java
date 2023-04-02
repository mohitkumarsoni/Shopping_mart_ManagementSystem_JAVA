import com.staff.manage.Staff;
import com.staff.manage.StaffDao;
import com.stock.manage.Stock;
import com.stock.manage.StockDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("welcome to Dmart backend system !");

        while (true) {
            System.out.println("what would you like to manage !!!");
            System.out.println("1. stock\n2. staff");
            int mainSelection = 0;
            try {
                mainSelection = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("you are allowed to enter only number (1 = stock) (2 = staff) ");
            }

            switch (mainSelection) {
                case 1 -> {
                    //manage stock
                    boolean flag = true;
                    while (flag) {
                        System.out.println("what would you like to do !!");
                        System.out.println("1. add new product");
                        System.out.println("2. increase product quantity");
                        System.out.println("3. decrease product quantity");
                        System.out.println("4. get total inventory stock value");
                        System.out.println("5. goto previous options");
                        System.out.println("6. exit application");
                        int stockChoice = 0;
                        try {
                            stockChoice = Integer.parseInt(br.readLine());
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("you are allowed to enter only number to select options");
                        }

                        switch (stockChoice) {
                            case 1 -> {
                                //add new product
                                System.out.println("enter details of product");
                                System.out.print("product name : ");
                                String name = br.readLine();
                                System.out.print("total quantity : ");
                                int quantity = Integer.parseInt(br.readLine());
                                System.out.print("item code : ");
                                int itemCode = Integer.parseInt(br.readLine());
                                System.out.print("item price : ");
                                int price = Integer.parseInt(br.readLine());

                                Stock stock = new Stock(name, quantity, itemCode, price);
                                boolean ans = StockDao.addNewProduct(name, quantity, itemCode, price);

                                if (ans) {
                                    System.out.println("item added successfully !!");
                                } else {
                                    System.out.println("oops.... try again !!!");
                                }

                                System.out.println(stock);


                            }
                            case 2 -> {
                                //increase product quantity
                                System.out.print("enter name of product to modify quantity : ");
                                String productName = br.readLine();
                                System.out.print("No. of quantity ypu want to add : ");
                                int addQuantity = Integer.parseInt(br.readLine());

                                boolean ans = StockDao.addProductQuantity(productName, addQuantity);

                                if (ans) {
                                    System.out.println("quantity updated");
                                } else {
                                    System.out.println("oops.... try again !!");
                                }

                            }
                            case 3 -> {
                                //decrease product quantity
                                System.out.print("enter name of product to modify quantity :");
                                String productName = br.readLine();
                                System.out.print("No. of quantity ypu want to decrease : ");
                                int lessQuantity = Integer.parseInt(br.readLine());

                                boolean ans = StockDao.lessNewProduct(productName, lessQuantity);

                                if (ans) {
                                    System.out.println("quantity updated  !!");
                                } else {
                                    System.out.println("oops.... try again !!");
                                }

                            }
                            case 4 -> {
                                //get total inventory stock value
                                System.out.println("1. get total of any particular product ");
                                System.out.println("2. get grand total of all your inventory !");
                                int totalChoice = Integer.parseInt(br.readLine());

                                StockDao.getTotal(totalChoice);
                            }
                            case 5 -> {
                                //previous options
                                flag=false;
                            }
                            case 6->{
                                //exit
                                System.exit(0);
                            }
                        }
                    }

                }
                case 2 -> {
                    //manage staff
                    boolean flag = true;
                    while (flag) {
                        System.out.println("1. add staff");
                        System.out.println("2. update staff details");
                        System.out.println("3. delete staff");
                        System.out.println("4. display staff");
                        System.out.println("5.  goto previous page");
                        System.out.println("6. exit application");

                        int staffAction = Integer.parseInt(br.readLine());

                        switch (staffAction) {
                            case 1 -> {
                                //add
                                System.out.print("enter name : ");
                                String name = br.readLine();
                                System.out.print("enter age : ");
                                int age = Integer.parseInt(br.readLine());
                                System.out.print("enter city : ");
                                String city = br.readLine();
                                System.out.println("enter id :");
                                int id = Integer.parseInt(br.readLine());
                                System.out.print("enter phone : ");
                                long phone = Long.parseLong(br.readLine());
                                System.out.print("enter salary : ");
                                long salary = Long.parseLong(br.readLine());

                                Staff obj = new Staff(name, age, city, id, phone, salary);
                                boolean ans = StaffDao.addNewStaff(obj);

                                if (ans) {
                                    System.out.println("employee added successfully");
                                } else {
                                    System.out.println("oops... try again !!");
                                }
                                System.out.println(obj);

                            }
                            case 2 -> {
                                //update detail
                                System.out.print("enter staff id for upgrade details : ");
                                int id = Integer.parseInt(br.readLine());

                                System.out.println("select field you wish to upgrade");
                                System.out.println("1.name\n2.age\n3.city\n4.phone\n5.salary");
                                int upgradeChoice = Integer.parseInt(br.readLine());

                                boolean ans = StaffDao.upgradeStaffDetails(id, upgradeChoice);

                                if (ans) {
                                    System.out.println("details updated successfully");
                                } else {
                                    System.out.println("oops... try again !!");
                                }

                            }
                            case 3 -> {
                                //delete
                                System.out.println("enter staff name and id to remove their details");
                                String name = br.readLine();
                                int id = Integer.parseInt(br.readLine());

                                boolean ans = StaffDao.removeOrDeleteStaff(name, id);

                                if (ans) {
                                    System.out.println("staff removed successfully");
                                } else {
                                    System.out.println("oops.. try again!!!");
                                    System.out.println("enter proper staff name and id");
                                }

                            }
                            case 4 -> {
                                //display all
                                StaffDao.displayAllStaff();
                            }
                            case 5 -> {
                                //exit staff
                                System.out.println("you are out of staff section");
                                flag = false;
                            }
                            case 6->{
                                //exit program
                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }
    }
}
