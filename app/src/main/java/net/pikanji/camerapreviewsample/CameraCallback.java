package net.pikanji.camerapreviewsample;

import android.hardware.Camera;

/**
 * Created by pinaki on 3/22/17.
 */

public interface CameraCallback {
    void opCameraOpen(Camera camera);
    void onPictureCapture();
}
