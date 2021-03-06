package c.codeblaq.sightsandsounds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class NatureActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inflate the Categories activity
        setContentView(R.layout.activity_category);
        //Fragment contract
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new NatureFragment())
                .commit();
    }
}
