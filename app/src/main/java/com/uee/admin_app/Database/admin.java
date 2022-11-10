package com.example.myueeapp.Database;

import android.provider.BaseColumns;

public class admin {


    private admin() {}

    public static class Orders implements BaseColumns {
        public static final String TABLE_NAME = "AdminData";
        public static final String COLUMN_1 = "ProductName";
        public static final String COLUMN_2 = "ModelName";
        public static final String COLUMN_3 = "Wattage";
        public static final String COLUMN_4 = "Warranty";
        public static final String COLUMN_5 = "Price";

    }




}


