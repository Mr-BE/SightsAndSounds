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
        locations.add(new Location(getString(R.string.old_residency), getString(R.string.calabar), R.drawable.old_residency, getString(R.string.old_recidency_dets)));
        locations.add(new Location(getString(R.string.hope_waddell), getString(R.string.calabar), R.drawable.hopewaddell, getString(R.string.hope_waddell_dets)));
        locations.add(new Location(getString(R.string.slave_history), getString(R.string.calabar), R.drawable.slavehistorymuseum1, getString(R.string.slave_history_dets)));

        //Setup ArrayAdapter
        LocationAdapter itemsAdapter = new LocationAdapter(
                getActivity(), locations, R.color.colorText_Icons);

        //Attach Butterknife
        ButterKnife.bind(this, rootView);

        //Attach listview to adapter
        listView.setAdapter(itemsAdapter);
        //Set up onItemClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get ListView item position and cast to location object
                Location location = (Location) listView.getItemAtPosition(position);

                //Initialise intent
                Intent intent = new Intent(getActivity(), FullDetailsActivity.class);
                //put location as an extra
                intent.putExtra(FullDetailsActivity.LOCATION, location);
                startActivity(intent);
            }
        });
        return rootView;
    }

    //Called when fragment is closed
    @Override
    public void onStop() {
        super.onStop();
    }
}
