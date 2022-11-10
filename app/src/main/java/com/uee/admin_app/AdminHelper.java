package com.example.myueeapp;

public class AdminHelper {

    String productname , modelname, wattage, price ;


    //Empty constructor
    public AdminHelper() {

    }


    //Create a constructor
    public AdminHelper(String productname, String modelname, String wattage, String price) {
        this.productname = productname;
        this.modelname = modelname;
        this.wattage = wattage;
        this.price = price;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
















//
//package com.example.my_project;
//
//public class userHelperClass {
//
//    String name,email,phone,message;
//
//    //Empty Constructor
//    public userHelperClass() {
//
//
//    }
//
//
//    //Create a constructor
//    public userHelperClass(String name, String email,String phone, String message) {
//        this.name = name;
//        this.email = email;
//        this.phone = phone;
//        this.message = message;
//
//    }
//
//    //Create getters and setters
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//        }
//}