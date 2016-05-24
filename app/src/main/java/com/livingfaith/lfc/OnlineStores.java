package com.livingfaith.lfc;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class OnlineStores extends android.support.v4.app.Fragment {
    // flag for Internet connection status
    Boolean isInternetPresent = false;

    // Connection detector class
    //ConnectorDetector cd;


    private WebView webView;
    private  ProgressBar pd;
    private TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_online_stores, container, false);

        setHasOptionsMenu(true);
        tv = (TextView) rootView.findViewById(R.id.error);
        //getting a refernce to the progressbar view
        pd = (ProgressBar) rootView.findViewById(R.id.loading_spinner);

        Inter_Activity main = new Inter_Activity();
     //   if (main.isOnline()) {

            //webView.setWebChromeClient(new WebChromeClient());
            webView = (WebView) rootView.findViewById(R.id.webView1);

            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setDisplayZoomControls(true);
            webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            webView.setScrollbarFadingEnabled(false);

            webView.setWebViewClient(new WebViewClient() {
                ProgressDialog prDialog;

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {

                    // prDialog = ProgressDialog.show(Inter_Activity.this, null, "loading, please wait...");
                    //prDialog.setCancelable(true);
                    pd.setVisibility(View.VISIBLE);
                    webView.setVisibility(View.VISIBLE);
                    super.onPageStarted(view, url, favicon);

                }

                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String
                        failingUrl) {

                    if (errorCode == -2 || errorCode == -8) {
                        view.loadData("There seems to be a problem with your Internet connection. Please try later", "text/html", "UTF-8");

                        tv.setText("Failed to connect to the internet, please refresh");
                            tv.setVisibility(View.VISIBLE);
                    } else if (errorCode == -14) {
                        view.loadData("Page cannot be found on server", "text/html", "UTF-8");
                        tv.setText("Failed to connect to the internet, please refresh");
                        tv.setVisibility(View.VISIBLE);
                    } else {
                        view.loadData("Page cannot be found on server", "text/html", "UTF-8");
                        tv.setText("Failed to connect to the internet, please refresh");
                        tv.setVisibility(View.VISIBLE);
                        Toast.makeText(getActivity(), "Network error , please contact service provider", Toast.LENGTH_SHORT).show();

                    }

                }



                @Override
                public void onPageFinished(WebView view, String url) {
                    //  prDialog.dismiss();
                    pd.setVisibility(View.INVISIBLE);
                    super.onPageFinished(view, url);
                }
            });


            webView.loadUrl("http://deliverancetrainingonline.com/?p=3512/");


       /* } else {
            new AlertDialog.Builder(getActivity())
                    .setTitle("No Connection")
                    .setMessage("Sorry, the LFC App is unable to " +
                            "communicate with the server. please check your data connection and try again ")
                    .setPositiveButton(getResources().getString(R.string.retry), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }





                    }
                    );*/
        //}



            return rootView;
        }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.inter_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();
        if(id == R.id.action_refresh){


            webView.loadUrl("http://deliverancetrainingonline.com/?p=3512/");

        }
        return super.onOptionsItemSelected(item);
    }
    }


