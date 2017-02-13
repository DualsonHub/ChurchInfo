package com.livingfaith.lfc;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class New_Update extends AppCompatActivity {
    private WebView webView;
    private ProgressBar pd;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        tv = (TextView) findViewById(R.id.error_news);
        //getting a refernce to the progressbar view
        pd = (ProgressBar) findViewById(R.id.loading_spinner4);


        Inter_Activity main = new Inter_Activity();
        //   if (main.isOnline()) {

        //webView.setWebChromeClient(new WebChromeClient());
        webView = (WebView) findViewById(R.id.webView4);
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
                super.onPageStarted(view, url, favicon);

            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String
                    failingUrl) {

                if (errorCode == -2 || errorCode == -8) {
                    view.loadData("There seems to be a problem with your Internet connection. Please try later", "text/html", "UTF-8");
                    tv.setText("Failed to connect to the internet, please refresh");
                } else if (errorCode == -14) {
                    view.loadData("Page cannot be found on server", "text/html", "UTF-8");
                    tv.setText("Failed to connect to the internet, please refresh");
                } else {
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


        webView.loadUrl("http://www.lfciyekogba.org/news/");


    }

}
