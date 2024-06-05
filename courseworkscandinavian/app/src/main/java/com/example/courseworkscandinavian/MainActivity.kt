package com.example.courseworkscandinavian

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
package="com.example.nordiclanguages">

<application
android:allowBackup="true"
android:icon="@mipmap/ic_launcher"
android:label="@string/app_name"
android:roundIcon="@mipmap/ic_launcher_round"
android:supportsRtl="true"
android:theme="@style/Theme.AppCompat.Light.NoActionBar">

<activity android:name=".DictionaryActivity"/>
<activity android:name=".LanguageSelectionActivity"/>
<activity android:name=".MainActivity">
<intent-filter>
<action android:name="android.intent.action.MAIN"/>
<category android:name="android.intent.category.LAUNCHER"/>
</intent-filter>
</activity>
</application>

</manifest>

package com.example.nordiclanguages

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
            val intent = Intent(this, LanguageSelectionActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.example.nordiclanguages

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_language_selection.*

class LanguageSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_selection)

        btnSwedish.setOnClickListener {
            openDictionary("Swedish")
        }

        btnNorwegian.setOnClickListener {
            openDictionary("Norwegian")
        }

        btnFinnish.setOnClickListener {
            openDictionary("Finnish")
        }
    }

    private fun openDictionary(language: String) {
        val intent = Intent(this, DictionaryActivity::class.java)
        intent.putExtra("LANGUAGE", language)
        startActivity(intent)
    }
}

package com.example.nordiclanguages

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dictionary.*

class DictionaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dictionary)

        val language = intent.getStringExtra("LANGUAGE")
        tvLanguage.text = language

        // Here you would load the dictionary for the selected language
        // For simplicity, let's just show a static example
        tvWordList.text = when (language) {
            "Swedish" -> "Hej - Hello\nTack - Thank you"
            "Norwegian" -> "Hei - Hello\nTakk - Thank you"
            "Finnish" -> "Hej - Hello\nTak - Thank you"
            else -> "Language not found"
        }
    }
}

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"
android:gravity="center"
android:padding="16dp">

<TextView
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Learn Nordic Languages"
android:textSize="24sp"
android:layout_marginBottom="24dp"/>

<Button
android:id="@+id/btnStart"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Start"/>
</LinearLayout>


<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"
android:gravity="center"
android:padding="16dp">

<TextView
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Select a Language"
android:textSize="24sp"
android:layout_marginBottom="24dp"/>

<Button
android:id="@+id/btnSwedish"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Swedish"/>

<Button
android:id="@+id/btnNorwegian"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Norwegian"/>

<Button
android:id="@+id/btnFinnish"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Finnish"/>
</LinearLayout>

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"
android:padding="16dp">

<TextView
android:id="@+id/tvLanguage"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:textSize="24sp"
android:layout_marginBottom="24dp"/>

<TextView
android:id="@+id/tvWordList"

