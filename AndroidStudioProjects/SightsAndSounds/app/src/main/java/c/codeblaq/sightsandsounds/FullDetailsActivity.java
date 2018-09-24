package c.codeblaq.sightsandsounds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FullDetailsActivity extends AppCompatActivity {
    /*Intent parameters*/
    final String ATTRACTION_KEY = "Attraction";
    final String ATTRACTION_DETAILS_KEY = "Details";
    final String ATTRACTION_PRI_IMAGE_KEY = "Image";

    /*Locate views to be populated by intent*/
    //Attraction name
    @BindView(R.id.attraction_name_detailed)
    TextView fullAttractionName;
    //Attraction Image resource
    @BindView(R.id.attractionImage_detailed)
    ImageView fullAttractionImage;
    //Full details of attraction
    @BindView(R.id.attraction_details)
    TextView fullAttractionDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_details);

        /*Attach Butterknife*/
        ButterKnife.bind(this);

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
