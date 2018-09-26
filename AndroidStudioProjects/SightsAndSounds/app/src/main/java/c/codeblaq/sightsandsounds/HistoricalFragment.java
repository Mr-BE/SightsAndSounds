package c.codeblaq.sightsandsounds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoricalFragment extends Fragment {
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
        locations.add(new Location(getString(R.string.old_residency), getString(R.string.calabar), R.drawable.old_residency));
        locations.add(new Location(getString(R.string.hope_waddell), getString(R.string.calabar), R.drawable.hopewaddell));
        locations.add(new Location(getString(R.string.slave_history), getString(R.string.calabar), R.drawable.slavehistorymuseum1));

        //Setup ArrayAdapter
        LocationAdapter itemsAdapter = new LocationAdapter(
                getActivity(), locations, R.color.colorText_Icons);

        //Attach Butterknife
        ButterKnife.bind(this, rootView);

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
