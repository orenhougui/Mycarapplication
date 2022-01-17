package co.il.dmobile.myapplication_2;

import java.io.Serializable;

public class Car implements Serializable {



        public int photo;
        public String brand;
         public String model;
         public String year;
        public String price;


        public Car(int photo,String brand, String model, String year, String price){
            this.photo = photo;
            this.brand = brand;
            this.model = model;
            this.year = year;
            this.price = price;

        }

        public int getPhoto() {return photo;}

        public String getBrand() {return brand;}

        public String getModel() {return model;}

        public String getYear() {return year;}

        public String getPrice() {return price;}


    }






