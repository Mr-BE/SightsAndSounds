package c.codeblaq.sightsandsounds;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtFragment extends Fragment {
    /*Intent parameters*/
    final String ATTRACTION_KEY = "Attraction";
    final String ATTRACTION_DETAILS_KEY = "Details";
    final String ATTRACTION_PRI_IMAGE_KEY = "Image";

    //Locate view to be used for list items
    @BindView(R.id.list)
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container,
                false);

        //Create an arrayList of attractions
        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.ikom_monoliths), getString(R.string.ikom), R.drawable.monolith, getString(R.string.monolith_dets)));
        locations.add(new Location(getString(R.string.calabar_carnival), getString(R.string.calabar), R.drawable.calabar_festival, getString(R.string.carnival_dets)));
        locations.add(new Location(getString(R.string.leboku_fest), getString(R.string.ugep), R.drawable.leboku, getString(R.string.leboku_dets)));
        locations.add(new Location(getString(R.string.ekpe_festival), getString(R.string.calabar), R.drawable.ekpe_masquerade1, getString(R.string.ekpe_dets)));

        //Setup ArrayAdapter
        LocationAdapter itemsAdapter = new LocationAdapter(
                getActivity(), locations, R.color.colorText_Icons);

        //Attach Butterknife
        ButterKnife.bind(this, rootView);

        //Set onItemClickListener for each item in list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get each position in the list view and store it as a "Location" object
                Location location = locations.get(position);
                //Get Attraction name
                String attractionName = location.getmAttractionName();
                //Get Attraction Details
                String attractionDetails = location.getmAtrractionDetails();
                //Get Attraction primary image
                int attractionPrimImage = location.getmPrimaryImageResource();

                /*Initialize intent*/
                Intent detailsIntent = new Intent(getContext(), FullDetailsActivity.class);
                detailsIntent.putExtra(ATTRACTION_KEY, attractionName);
                detailsIntent.putExtra(ATTRACTION_DETAILS_KEY, attractionDetails);
                detailsIntent.putExtra(ATTRACTION_PRI_IMAGE_KEY, attractionPrimImage);
                startActivity(detailsIntent);
            }
        });

        //Attach listview to adapter
        listView.setAdapter(itemsAdapter);
        return rootView;
    }

    //Called when fragment is closed
    @Override
    public void onStop() {
        super.onStop();
    }
}
