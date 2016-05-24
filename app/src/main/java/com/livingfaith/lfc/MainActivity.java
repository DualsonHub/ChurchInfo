package com.livingfaith.lfc;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener {
    String _searchCurrentQuery;
    GridView gridview;
    AdapaterGridView gridviewAdapter;
    ArrayList<GridViewItem_2> data = new ArrayList<GridViewItem_2>();
    TextView textView;
    int[] names = {R.string.announcement,R.string.today,R.string.news,R.string.go_store,R.string.other_book_stores,R.string.service_groups,R.string.donation,R.string.appointment};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);









        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //   handleIntent(getIntent());

        gridview = (GridView) findViewById(R.id.gridView1);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position==0){
                    startActivity(new Intent(getApplicationContext(), Announcement.class));

                }
                else  if(position ==3){
                    startActivity(new Intent(getApplicationContext(), GoBookStores.class));

                }
                else if(position == 7)  {
                    startActivity(new Intent(getApplicationContext(), MeetAPastor.class));
                    // getActivity().overridePendingTransition (R.anim.open_next, R.anim.close_next);
                }
                else if(position == 5){
                    startActivity(new Intent(getApplicationContext(), Inter_Activity.class));
                }
                else if(position == 6){
                    new AlertDialog.Builder(MainActivity.this)
                            // .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Theme of the Month")
                            .setMessage("Financial Dominion is my Heritage in Christ Jesus.Isaiah 51:1-3 \n" +
                                    "Galatians 3:13-14")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }

                            })
                            .setNegativeButton("", null)
                            .show();
                }
                else if(position == 1){
                    startActivity(new Intent(getApplicationContext(), Events.class));

                }
                else  if(position == 2){

                    new AlertDialog.Builder(MainActivity.this)
                            // .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Faith Theater Project")
                            .setMessage("Please visit the Living Faith Church secretary at any branch worldwide to get the guild lines on sowing your seed. Thank you!")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }

                            })
                            .setNegativeButton("", null)
                            .show();

                }
                else if(position == 4){
                    startActivity(new Intent(getApplicationContext(), OtherBooks.class));

                }


            }
        });




        data.add(new GridViewItem_2("Service Announcement", getResources().getDrawable(R.drawable.icon_one)));
        data.add(new GridViewItem_2(getResources().getString(R.string.today), getResources().getDrawable(R.drawable.icon_two)));
        data.add(new GridViewItem_2(getResources().getString(R.string.news), getResources().getDrawable(R.drawable.icon_three)));
        data.add(new GridViewItem_2(getResources().getString(R.string.go_store), getResources().getDrawable(R.drawable.icon_four)));
        data.add(new GridViewItem_2(getResources().getString(R.string.other_book_stores), getResources().getDrawable(R.drawable.mony)));
        data.add(new GridViewItem_2(getResources().getString(R.string.service_groups), getResources().getDrawable(R.drawable.icon_six)));
        data.add(new GridViewItem_2(getResources().getString(R.string.donation), getResources().getDrawable(R.drawable.lfc_logo)));
        data.add(new GridViewItem_2(getResources().getString(R.string.appointment), getResources().getDrawable(R.drawable.icon_eight)));

        setDataAdapter();
    }
    private void setDataAdapter() {
        gridviewAdapter = new AdapaterGridView(this, R.layout.fragment_list_item_1, data);
        gridview.setAdapter(gridviewAdapter);
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {



            new AlertDialog.Builder(this)
                    // .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Exit!")
                    .setMessage("Are you sure you want to close?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();


        }
    }



    @Override
    public void onClick(final View v) {
        v.post(new Runnable() {
            @Override
            public void run() {
                showPopupMenu(v);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
       /* MenuItem searchItem = menu.findItem(R.id.search);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String data) {


                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                gridviewAdapter.getFilter().filter(s);

                return false;
            }
        });*/

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            startActivity(new Intent(MainActivity.this, About.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.international) {
            // Handle the camera action
            Intent intent = new Intent(MainActivity.this, Announcement.class);
            startActivity(intent);
        }
        else if (id == R.id.gostores)
        {
            Intent intent = new Intent(MainActivity.this, GoBookStores.class);
            startActivity(intent);
        }


        else if (id == R.id.service) {
            Intent intent = new Intent(MainActivity.this, Inter_Activity.class);
            startActivity(intent);
        }
        else if (id == R.id.meetPastor) {
            Intent intent = new Intent(MainActivity.this, MeetAPastor.class);
            startActivity(intent);
        }
        else if(id == R.id.news){
            new AlertDialog.Builder(MainActivity.this)
                    // .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Faith Theater Project")
                    .setMessage("Please visit the Living Faith Church secretary at any branch worldwide to get the guild lines on sowing your seed. Thank you!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }

                    })
                    .setNegativeButton("", null)
                    .show();

        }
        else if(id == R.id.todays_event){
            startActivity(new Intent(getApplicationContext(), Events.class));

        }
        else if(id == R.id.other_books){
            startActivity(new Intent(getApplicationContext(), OtherBooks.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void showPopupMenu(View view) {

        PopupMenu popup = new PopupMenu(getApplicationContext(), view);

        popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());

        popup.show();
    }
    private void doSearch(String queryStr) {
        // get a Cursor, prepare the ListAdapter
        // and set it
    }
    protected void searchAction(String query) {
        _searchCurrentQuery = query.toString();
        gridviewAdapter.getFilter().filter(_searchCurrentQuery);
    }
}
