package fundoohr.com.todoapp1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText id;
    EditText pass;
    Button login;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText) findViewById(R.id.edittext1);
        pass = (EditText) findViewById(R.id.edittext2);
        login = (Button) findViewById(R.id.btn1);
        Register = (Button) findViewById(R.id.btn2);
    }

    public void login(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("smita", Context.MODE_PRIVATE);
        String id1 = sharedPreferences.getString("email_id", "value");
        String pass1 = sharedPreferences.getString("password", "value");
        if (id.getText().toString().equalsIgnoreCase(id1) && pass.getText().toString().equalsIgnoreCase(pass1))
        {
            Toast.makeText(this, "login successfully", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MyApp.class);
            startActivity(intent);
        } else
        {
            Toast.makeText(this, "invalid id or password", Toast.LENGTH_LONG).show();
        }

    }

    public void Register(View view) {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
}