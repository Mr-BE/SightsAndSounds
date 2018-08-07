package c.codeblaq.alc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Proceed button
    public void proceed (View view){
        //Setup intent
        Intent proceedIntent = new Intent(this, Main2Activity.class);
        //Start Intent
        startActivity(proceedIntent);
        //Clear system memory
//        finish();

    }
}
