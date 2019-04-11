package com.mahindra.mahindraapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.webkit.WebView
import android.widget.Toast
import android.widget.Toolbar
import com.mahindra.mahindraapp.R
import kotlinx.android.synthetic.main.activity_main.*
import android.webkit.WebChromeClient



class MainActivity : AppCompatActivity() {

   lateinit var webView: WebView;
    lateinit var toolbar: Toolbar;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



       webView=findViewById(R.id.web_view) as WebView

      web_view.settings.javaScriptEnabled=true
       webView.webChromeClient = object : WebChromeClient()
       {
           override fun onReceivedTitle(view: WebView?, title: String?) {
               webView.loadUrl("mahindra")
               webView.loadUrl("https://10.250.10.28:8000")

           }


       }



    }
    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce)
        {
            super.onBackPressed()
            return
        }
       this.doubleBackToExitPressedOnce=true
        Toast.makeText(this,"press again to exit",Toast.LENGTH_LONG).show()
        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false },2000)
    }
}




