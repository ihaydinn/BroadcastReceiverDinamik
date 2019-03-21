# BroadcastReceiverDinamik

Dinamik bir şekilde yapılan basit bir broadcast receiver örneği, uygulamalar arası iletişim vs.

UYGULAMALAR ARASI GÜVENLİK.
1.uygulama

public class MainActivity extends AppCompatActivity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
 
    public void sendBroadcastMesaj(View view) {
 
        Intent intent=new Intent("my.action.name");
       /*
       İzin tanımlanmadan broadcast mesaj gönderme
        sendBroadcast(intent);
        */
       
       //izin ve action name ile broadcast mesaj gönderme
        sendBroadcast(intent, "my.permission");
 
    }
}

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.emrealtunbilek.securitywithbroadcastapp1">
 
    <permission android:name="my.permission" android:protectionLevel="signature"></permission>
 
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
 
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
 
</manifest>

2.UYGULAMA

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
 
        Toast.makeText(context, "My Receiver çağrıldı", Toast.LENGTH_LONG).show();
 
    }
}

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.emrealtunbilek.securitywithbroadcastapp2">
 
    <uses-permission android:name="my.permission"></uses-permission>
 
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
 
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
 
        <receiver android:name=".MyReceiver" android:exported="true">
 
            <intent-filter>
 
                <action android:name="my.action.name"></action>
 
            </intent-filter>
 
        </receiver>
    </application>
 
</manifest>
