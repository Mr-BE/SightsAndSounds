package c.codeblaq.sightsandsounds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FullDetailsActivity extends AppCompatActivity {
    /*Constant for location*/
    public static final String LOCATION = "c.codeblaq.sightsandsounds.LOCATION";

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
    private Location mLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_details);

        /*Attach Butterknife*/
        ButterKnife.bind(this);
        //Read values from parcel
        readDisplayValues();
        //display read values
        displayValues(fullAttractionName, fullAttractionDetails, fullAttractionImage);
    }

    /**
     * Helper method to display values read from parcel
     *
     * @param attractionName    is the name of the location
     * @param attractionDetails is the details text associated with the location
     * @param attractionImage   is the image of the location
     */
    private void displayValues(TextView attractionName, TextView attractionDetails, ImageView attractionImage) {
        fullAttractionName.setText(mLocation.getmAttractionName());
        fullAttractionDetails.setText(mLocation.getmAtrractionDetails());
        fullAttractionImage.setImageResource(mLocation.getmPrimaryImageResource());
    }

    /**
     * Helper method to read values from parcel
     */
    private void readDisplayValues() {
        Intent intent = getIntent();
        mLocation = intent.getParcelableExtra(LOCATION);
    }
}
