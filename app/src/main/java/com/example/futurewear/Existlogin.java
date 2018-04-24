package com.example.futurewear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Existlogin extends AppCompatActivity {
    DatabaseHelper check;
    EditText pw;
    EditText em;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existlogin);
        check = new DatabaseHelper(this);
         em = (EditText)findViewById(R.id.mailid);
        pw = (EditText)findViewById(R.id.password);
        login= (Button) findViewById(R.id.existlogin);
        ch();

        }

    public void ch()
    {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String username = em.getText().toString();
                String pass = pw.getText().toString();
                String password = check.verify(username);
                if (password.equals("Not Found"))
                    Toast.makeText(Existlogin.this,"NOtFound ",Toast.LENGTH_LONG).show();
                if(pass.equals(password))
                {
                    Toast.makeText(Existlogin.this,"Login Success:  "+username+"  ",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Existlogin.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Existlogin.this,"EMail and passwords do not match ",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
