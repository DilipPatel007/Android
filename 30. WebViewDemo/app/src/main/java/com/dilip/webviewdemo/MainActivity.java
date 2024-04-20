package com.dilip.webviewdemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // This variable holds a reference to the WebView element in our layout
    WebView webView;

    // This variable holds a reference to the ProgressBar element in our layout
    ProgressBar pgBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the WebView and ProgressBar objects by finding their IDs in the layout
        webView = findViewById(R.id.webView);
        pgBar = findViewById(R.id.pgBar);

        // Load the Google homepage URL into the WebView
        webView.loadUrl("https://www.google.com");

        // Set a WebViewClient to handle web view behavior
        webView.setWebViewClient(new WebViewClient() {

            // This method is called when a new URL is clicked within the WebView
            // It allows us to handle whether to open the URL inside the WebView or in the browser
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                // You can add logic here to decide how to handle different URLs
                // For example, you could open certain links in the browser for specific cases
                return super.shouldOverrideUrlLoading(view, request);
            }

            // This method is called when a web page starts loading
            // We can use it to show a progress bar for a better user experience
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                pgBar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            // This method is called when a web page finishes loading
            // We can use it to hide the progress bar
            @Override
            public void onPageFinished(WebView view, String url) {
                pgBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });
    }

    // Handle the back button press
    @Override
    public void onBackPressed() {
        // Check if the WebView can navigate back to a previous page
        if (webView.canGoBack()) {
            webView.goBack();  // Go back to the previous page
        } else {
            // If there are no more pages to go back to, exit the activity
            super.onBackPressed();
        }
    }
}


//    Class Declaration and Inheritance:
//        The MainActivity class extends AppCompatActivity, which is part of the Android framework for creating activities.
//        Activities represent individual screens or UI components in an Android app.
//    Member Variables:
//        WebView webView: This variable holds a reference to the WebView element in your app’s layout. The WebView is used to display web content within the app.
//        ProgressBar pgBar: This variable holds a reference to the ProgressBar element in your layout. The ProgressBar is used to show loading progress while web pages are being loaded.
//        onCreate() Method:
//    The onCreate() method is called when the activity is created.
//        It initializes the activity, sets the content view (layout), and performs other setup tasks.
//        In this case, it sets the content view to the layout defined in activity_main.xml.
//        Initializing WebView and ProgressBar:
//        The following lines initialize the webView and pgBar objects by finding their IDs in the layout:
//        Java
//        webView = findViewById(R.id.webView);
//        pgBar = findViewById(R.id.pgBar);
//
//    Loading Google Homepage:
//        The next line loads the Google homepage URL into the WebView:
//        Java
//        webView.loadUrl("https://www.google.com");
//
//     Setting a WebViewClient:
//        A WebViewClient is responsible for handling web view behavior.
//        The following code sets a custom WebViewClient for the WebView:
//        Java
//        webView.setWebViewClient(new WebViewClient() {
//        // ...
//        });

//     shouldOverrideUrlLoading() Method:
//        This method is called when a new URL is clicked within the WebView.
//        You can add custom logic here to decide whether to open the URL inside the WebView or in the browser.
//        The default implementation simply returns super.shouldOverrideUrlLoading(view, request).
//     onPageStarted() Method:
//        This method is called when a web page starts loading.
//        It’s used to show the progress bar (pgBar) for a better user experience.
//        In this case, it sets the progress bar’s visibility to VISIBLE.
//     onPageFinished() Method:
//        This method is called when a web page finishes loading.
//        It’s used to hide the progress bar (pgBar).
//        In this case, it sets the progress bar’s visibility to GONE.
//     Handling Back Button Press:
//        The onBackPressed() method is overridden to handle the back button press.
//        If the WebView can go back to a previous page, it calls webView.goBack() to navigate back.
//        Otherwise, if there are no more pages to go back to, it exits the activity.