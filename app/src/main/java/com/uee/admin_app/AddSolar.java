package com.example.myueeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myueeapp.Database.DBHandler;


public class AddSolar extends AppCompatActivity {

    EditText  productname ,  modelname  ,  wattage , price   ;
    Button pradd , prcancel ;
    RadioButton tenyear , twoyear ;
    String warranty;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_solar);



        pradd         = findViewById(R.id.ADDw);
        prcancel      = findViewById(R.id.Cnacela);
        productname     = findViewById(R.id.rfgt6);
        modelname      = findViewById(R.id.rhjui8);
        wattage      = findViewById(R.id.jnbg6);
        tenyear      = findViewById(R.id.fvbghy6);
        twoyear      = findViewById(R.id.dcvfg6);
        price        = findViewById(R.id.qazxcv4);


        //Connect add button to the firebase


        pradd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(tenyear.isChecked()){
                    warranty = "10 Years";

                }
                else{
                    warranty = "20 Years";
                }

                //get details from the userinput
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                long newID = dbHandler.addinfo(productname.getText().toString(),modelname.getText().toString(),wattage.getText().toString(),price.getText().toString(),warranty);



                Intent i = new Intent(getApplicationContext(),ManageProducts.class);
                startActivity(i);

                Toast.makeText(AddSolar.this, "Product added successfully", Toast.LENGTH_LONG).show();

            }
        });

        prcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),AdminHome.class);
                startActivity(i);
            }
        });
    }
}















//package com.example.my_project;
//
//        import androidx.appcompat.app.AppCompatActivity;
//
//        import android.content.Intent;
//        import android.os.Bundle;
//        import android.view.View;
//        import android.view.Window;
//        import android.view.WindowManager;
//        import android.widget.Button;
//        import android.widget.EditText;
//        import android.widget.ImageView;
//        import android.widget.Toast;
//
//        import com.google.firebase.database.DatabaseReference;
//        import com.google.firebase.database.FirebaseDatabase;
//
//public class contactPage extends AppCompatActivity {
//    ImageView back;
//    EditText Username,Useremail,Usermessage,UserPhone;
//    Button submit;
//
//    FirebaseDatabase rootNode;
//    DatabaseReference reference;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();
//        setContentView(R.layout.activity_contact_page);
//
//
//        //Create hooks
//        back = findViewById(R.id.img23);
//        Username = findViewById(R.id.edit_name);
//        Useremail = findViewById(R.id.edit_email);
//        Usermessage = findViewById(R.id.edit_message);
//        UserPhone = findViewById(R.id.edit_phone);
//        submit = findViewById(R.id.btn_submit);
//
//        //Connect submit button to the firebase
//
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                rootNode = FirebaseDatabase.getInstance();
//                reference = rootNode.getReference("Users");
//
//                //Get all the values
//                String name = Username.getText().toString();
//                String email = Useremail.getText().toString();
//                String phone = UserPhone.getText().toString();
//                String message = Usermessage.getText().toString();
//
//                userHelperClass userHelper = new userHelperClass(name,email,phone,message);
//                reference.child(phone).setValue(userHelper);
//
//                Toast.makeText(contactPage.this, "Your message added!", Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//
//
//
//        //Connect the back button
//
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent i =new  Intent(getApplicationContext(),homePage.class);
//                startActivity(i);
//
//            }
//        });
//
//
//
//    }
//}






