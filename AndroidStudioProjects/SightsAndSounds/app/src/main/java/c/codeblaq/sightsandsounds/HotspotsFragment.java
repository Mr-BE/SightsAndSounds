package c.codeblaq.sightsandsounds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HotspotsFragment extends Fragment {

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
        locations.add(new Location(getString(R.string.tinapa), getString(R.string.calabar), R.drawable.tinapa, getString(R.string.tinapa_dets)));
        locations.add(new Location(getString(R.string.marina_resort), getString(R.string.calabar), R.drawable.marina, getString(R.string.marina_dets)));

        //Setup ArrayAdapter
        LocationAdapter itemsAdapter = new LocationAdapter(
                getActivity(), locations, R.color.colorText_Icons);

        //Attach butterknife
        ButterKnife.bind(this, rootView);
        //       Set onItemClickListener for each item in list view
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

    //Called on when Fragment is closed
    @Override
    public void onStop() {
        super.onStop();
    }
}
