package c.codeblaq.sightsandsounds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FullDetailsActivity extends AppCompatActivity {
    final String ATTRACTION_KEY = "Attraction";
    final String ATTRACTION_DETAILS_KEY = "Details";
    final String ATTRACTION_PRI_IMAGE_KEY = "Image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_details);

        /*Locate views to be populated by intent*/
        //Attraction name
        TextView fullAttractionName = findViewById(R.id.attraction_name_detailed);
        //Attraction Image resource
        ImageView fullAttractionImage = findViewById(R.id.attractionImage_detailed);
        //Full details of attraction
        TextView fullAttractionDetails = findViewById(R.id.attraction_details);

        //Get intent values
        Intent detailsIntent = getIntent();
        // Locate attraction name from intent
        String receivedAttraction = detailsIntent.getStringExtra(ATTRACTION_KEY);
        int receivedImageResource = detailsIntent.getIntExtra(ATTRACTION_PRI_IMAGE_KEY, 0);
        String receivedDetails = detailsIntent.getStringExtra(ATTRACTION_DETAILS_KEY);

        /*Set received values to Views*/
        fullAttractionName.setText(receivedAttraction);
        fullAttractionDetails.setText(receivedDetails);
        fullAttractionImage.setImageResource(receivedImageResource);


    }
}
