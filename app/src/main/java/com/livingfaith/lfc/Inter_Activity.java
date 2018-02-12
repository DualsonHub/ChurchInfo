package com.livingfaith.lfc;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Inter_Activity extends AppCompatActivity {
    private WebView webView;
    private ProgressBar pd;
   // private String url = "http://www.starthub.com.ng/";
 private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
            tv = (TextView) findViewById(R.id.error);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pd = (ProgressBar) findViewById(R.id.loading_spinner);

        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setDisplayZoomControls(true);

        if(isOnline()) {

            //webView.setWebChromeClient(new WebChromeClient());
            webView = (WebView) findViewById(R.id.webView1);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);

            webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            webView.setScrollbarFadingEnabled(false);
           webView.setWebViewClient(new WebViewClient(){
                   ProgressDialog prDialog;
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

               // prDialog = ProgressDialog.show(Inter_Activity.this, null, "loading, please wait...");
                //prDialog.setCancelable(true);
                pd.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);

            }
               @Override
                public void onReceivedError(WebView view, int errorCode, String description, String
                failingUrl) {

                   if(errorCode == -2 || errorCode == -8) {
                       view.loadData("There seems to be a problem with your Internet connection. Please try later", "text/html", "UTF-8");
                   tv.setText("Failed to connect to the internet, please refresh");
                   }


                   else if(errorCode == -14) {
                       view.loadData("Page cannot be found on server", "text/html", "UTF-8");
                       tv.setText("Failed to connect to the internet, please refresh");
                   }

                   else{
                       view.loadData("Page cannot be found on server", "text/html", "UTF-8");
                       tv.setText("Failed to connect to the internet, please refresh");
                       Toast.makeText(getApplicationContext(), "Network error , please contact service provider", Toast.LENGTH_SHORT).show();

                   }

            }


            @Override
            public void onPageFinished(WebView view, String url) {
              //  prDialog.dismiss();
                pd.setVisibility(View.INVISIBLE);
                super.onPageFinished(view, url);
            }
        });


            webView.loadUrl("https://favouritemall.com/service-group-units/");






        }else {
            new AlertDialog.Builder(this)
                    .setTitle("No Connection")
                    .setMessage("Sorry, the LFC App is unable to " +
                            "communicate with the server. please check your data connection and try again ")
                    .setPositiveButton(getResources().getString(R.string.retry), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete


                            webView.getSettings().setJavaScriptEnabled(true);
                            webView.getSettings().setLoadWithOverviewMode(true);
                            webView.getSettings().setUseWideViewPort(true);
                            webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
                            webView.setScrollbarFadingEnabled(false);
                            webView.setWebViewClient(new WebViewClient(){
                                ProgressDialog prDialog;
                                @Override
                                public void onPageStarted(WebView view, String url, Bitmap favicon) {

                                    // prDialog = ProgressDialog.show(Inter_Activity.this, null, "loading, please wait...");
                                    //prDialog.setCancelable(true);
                                    pd.setVisibility(View.VISIBLE);
                                    super.onPageStarted(view, url, favicon);

                                }
                                @Override
                                public void onReceivedError(WebView view, int errorCode, String description, String
                                        failingUrl) {

                                    if(errorCode == -2 || errorCode == -8) {
                                        view.loadData("There seems to be a problem with your Internet connection. Please try later", "text/html", "UTF-8");
                                        tv.setText("Failed to connect to the internet, please refresh");
                                    }


                                    if(errorCode == -14) {
                                        view.loadData("Page cannot be found on server", "text/html", "UTF-8");
                                     //   tv.setText("Failed to connect to the internet, please refresh");
                                    }

                                    else{
                                        view.loadData("Page cannot be found on server", "text/html", "UTF-8");
                                        // tv.setText("Failed to connect to the internet, please refresh");
                                        Toast.makeText(getApplicationContext(), "Network error , please contact service provider", Toast.LENGTH_SHORT).show();
                                    }

                                }


                                @Override
                                public void onPageFinished(WebView view, String url) {
                                    //  prDialog.dismiss();
                                    pd.setVisibility(View.INVISIBLE);
                                    super.onPageFinished(view, url);
                                }
                            });


                            webView.loadUrl("https://favouritemall.com/service-group-units/");





                        }
                    })
                    .setNegativeButton(getResources().getString(R.string.ignore), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })

                    .show();
            //tv.setText("Failed to connect to the Internet");
           Toast.makeText(this, "Network isn't available, check your internet connection", Toast.LENGTH_LONG).show();
        }



    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inter_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {



            if(isOnline()) {

                //webView.setWebChromeClient(new WebChromeClient());

                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setLoadWithOverviewMode(true);
                webView.getSettings().setUseWideViewPort(true);
                webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
                webView.setScrollbarFadingEnabled(false);
                webView.setWebViewClient(new WebViewClient(){
                    ProgressDialog prDialog;
                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon) {

                        // prDialog = ProgressDialog.show(Inter_Activity.this, null, "loading, please wait...");
                        //prDialog.setCancelable(true);
                        pd.setVisibility(View.VISIBLE);
                        super.onPageStarted(view, url, favicon);

                    }
                    @Override
                    public void onReceivedError(WebView view, int errorCode, String description, String
                            failingUrl) {

                        if(errorCode == -2 || errorCode == -8) {
                            view.loadData("There seems to be a problem with your Internet connection. Please try later", "text/html", "UTF-8");
                            tv.setText("Failed to connect to the internet, please refresh");
                        }


                        if(errorCode == -14) {
                            view.loadData("Page cannot be found on server", "text/html", "UTF-8");
                          //  tv.setText("Failed to connect to the internet, please refresh");
                        }

                        else{
                            view.loadData("Page cannot be found on server", "text/html", "UTF-8");
                           // tv.setText("Failed to connect to the internet, please refresh");
                            Toast.makeText(getApplicationContext(), "Network error , please contact service provider", Toast.LENGTH_SHORT).show();

                        }

                    }


                    @Override
                    public void onPageFinished(WebView view, String url) {
                        //  prDialog.dismiss();
                        pd.setVisibility(View.INVISIBLE);
                        super.onPageFinished(view, url);
                    }
                });


                webView.loadUrl("https://favouritemall.com/service-group-units/");






            }else {
                tv.setText("Failed to connect to the Internet");
                Toast.makeText(this, "Network isn't available, check your internet connection", Toast.LENGTH_LONG).show();
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}