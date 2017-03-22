
package net.pikanji.camerapreviewsample;

/////////////////////////////////////////////////////////////////////////////
//Sample driver class to demonstrate the use of CameraPreview class.
/////////////////////////////////////////////////////////////////////////////

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final int REQUEST_CAMERA = 0;
    private View clickedButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);
        
        Button b1 = (Button) findViewById(R.id.button_sample);
        b1.setOnClickListener(this);
        Button b2 = (Button) findViewById(R.id.button_test);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        clickedButton = v;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            Log.i("MainActivity", "Requesting Camera Permissions");
            requestCameraPermission();
        } else {
            handleClick();
        }
    }

    private void requestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            // add some message here
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
        }
    }

    private void handleClick() {
        Intent intent;
        switch (clickedButton.getId()) {
            case R.id.button_sample:
                intent = new Intent(this, CameraPreviewSampleActivity.class);
                startActivity(intent);
                break;
            case R.id.button_test:
                intent = new Intent(this, CameraPreviewTestActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        Log.i("", "onReq permissions result");
        if (requestCode == REQUEST_CAMERA) {
            handleClick();
        }
    }
}
