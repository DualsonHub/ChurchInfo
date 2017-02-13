package com.livingfaith.lfc;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class OfflineStores extends android.support.v4.app.Fragment {
    GridView gridview;
    Adapter_OfflineStore_Grid gridviewAdapter;
    ArrayList<GridViewItem_2> data = new ArrayList<GridViewItem_2>();
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.activity_offline_stores, container, false);
        gridview = (GridView) rootView.findViewById(R.id.gridView2);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    new AlertDialog.Builder(getActivity())
                            // .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Store Contact")
                            .setMessage("HEAD OFFICE \n" +
                                    "Shop 10-12, Ede Shopping Plaza, \n " + "Opposite Observer Newspapers, \n" + "Airport Road, Benin City. \n" + "Edo State. \n" + "Tel: +234 8033437096\n" +
                                    "\n")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }

                            })
                            .setNegativeButton("Cancel", null)
                            .show();

                } else {
                    new AlertDialog.Builder(getActivity())
                            // .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Store To Let!")
                            .setMessage("Contact\n"  + "Email: shops.listing.here@gmail.com \n" +
                                    "Phone: 08138667392")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }

                            })
                            .setNegativeButton("Cancel", null)
                            .show();

                }

            }
        });
       /* data.add(new GridViewItem_2(getResources().getString(R.string.marvelous), getResources().getDrawable(R.drawable.stores_holder)));
        data.add(new GridViewItem_2(getResources().getString(R.string.boldoz), getResources().getDrawable(R.drawable.stores_holder)));
        data.add(new GridViewItem_2(getResources().getString(R.string.boldoz), getResources().getDrawable(R.drawable.stores_holder)));
        data.add(new GridViewItem_2(getResources().getString(R.string.boldoz), getResources().getDrawable(R.drawable.stores_holder)));
*/
        setDataAdapter();


        return rootView;
    }
    private void setDataAdapter() {
        gridviewAdapter = new Adapter_OfflineStore_Grid(getActivity(), R.layout.activity_offline_store_list, data);
        gridview.setAdapter(gridviewAdapter);
    }

}
