package app.portal.hva.semen.seyfullah.com.hva_portal_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UrlActivity extends AppCompatActivity {

    @BindView(R.id.portal_site_viewer)
    WebView mWebView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);

        ButterKnife.bind(this);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.loadUrl(getIntent().getStringExtra("url"));

    }
}
