package com.example.webviewapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Récupération du WebView depuis le layout
        webView = findViewById(R.id.myWebView)

        // Configuration essentielle :
        // 1. Activer JavaScript (nécessaire pour 99% des sites web modernes)
        webView.settings.javaScriptEnabled = true

        // 2. Activer le stockage local/DOM (utile pour les sites complexes)
        webView.settings.domStorageEnabled = true

        // 3. Forcer les liens à s'ouvrir DANS le WebView et non dans le navigateur du téléphone
        webView.webViewClient = WebViewClient()

        // 4. Charger votre site web (remplacez l'URL par la vôtre)
        webView.loadUrl("https://www.google.com")
    }

    // Gérer le bouton "Retour" du téléphone pour naviguer dans l'historique du WebView
    // au lieu de fermer directement l'application
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
