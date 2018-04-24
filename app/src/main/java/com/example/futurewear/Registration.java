package com.example.futurewear;
import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
DatabaseHelper detail;
 android.widget.EditText mail;
 EditText phoneno;
EditText password;
EditText name;
 Button but;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        detail= new DatabaseHelper(this);
        mail = (EditText)findViewById(R.id.email);
        phoneno = (EditText)findViewById(R.id.phone);
        name = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.pwd);
        but= (Button) findViewById(R.id.buttonsub);
        add();

    }
    public void add()
    {
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String fullname= name.getText().toString();
                String pass= password.getText().toString();
                String email= mail.getText().toString();
                String phone= phoneno.getText().toString();
                boolean insertdata = detail.addData(fullname,pass,email,phone);
                if (insertdata == true)
                {
                    Toast.makeText(Registration.this,"Success!!!!",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(Registration.this,"srsly??",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}



