package com.example.tvappversion2

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class Webview : AppCompatActivity() {

    private lateinit var webview: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        var webview: WebView = findViewById(R.id.webview)

        var intent = intent
        var website = intent.getStringExtra("links")


        webview.webViewClient = WebViewClient()

        // this will load the url of the website
        webview.loadUrl(website!!)

        // this will enable the javascript settings, it can also allow xss vulnerabilities
        webview.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
        webview.settings.setSupportZoom(true)

    }

    override fun onBackPressed() {
        // if your webview can go back it will go back
        if (webview.canGoBack())
            webview.goBack()
        // if your webview cannot go back
        // it will exit the application
        else
            super.onBackPressed()
    }
}