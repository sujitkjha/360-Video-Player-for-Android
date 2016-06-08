
package com.newitventure.mediaplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.MediaController;

import org.rajawali3d.animation.Animation;
import org.rajawali3d.animation.EllipticalOrbitAnimation3D;
import org.rajawali3d.animation.TranslateAnimation3D;
import org.rajawali3d.cardboard.RajawaliCardboardRenderer;
import org.rajawali3d.lights.PointLight;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.StreamingTexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Plane;
import org.rajawali3d.primitives.Sphere;

public class VideoPlayer extends MyRenderer {

    private static final String TAG = "VideoPlayer";
    Context mContext;

    private MediaPlayer mMediaPlayer;
    private StreamingTexture mVideoTexture;

    public VideoPlayer(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void initScene() {

        mMediaPlayer = MediaPlayer.create(getContext(), R.raw.test);
        //mMediaPlayer = MediaPlayer.create(getContext(), Uri.parse("http://nepal.cloudapp.net/video_portal/video.mp4"));
        mMediaPlayer.setLooping(true);


        mVideoTexture = new StreamingTexture("sintelTrailer", mMediaPlayer);
        Log.d("TextureSet","Texture");
        Material material = new Material();
        material.setColorInfluence(0);
        try {
            material.addTexture(mVideoTexture);
        } catch (ATexture.TextureException e) {
            e.printStackTrace();
        }

        Sphere sphere = new Sphere(50, 64, 32);
        sphere.setScaleX(-1);
        sphere.setMaterial(material);

        getCurrentScene().addChild(sphere);

        getCurrentCamera().setPosition(Vector3.ZERO);

        getCurrentCamera().setFieldOfView(75);

        EllipticalOrbitAnimation3D camAnim = new EllipticalOrbitAnimation3D(
                new Vector3(3, 2, 10), new Vector3(1, 0, 8), 0, 359);
        camAnim.setDurationMilliseconds(20000);
        camAnim.setRepeatMode(Animation.RepeatMode.INFINITE);
        camAnim.setTransformable3D(getCurrentCamera());
        getCurrentScene().registerAnimation(camAnim);
        camAnim.play();

        mMediaPlayer.start();


    }

    @Override
    protected void onRender(long ellapsedRealtime, double deltaTime) {
        super.onRender(ellapsedRealtime, deltaTime);
        mVideoTexture.update();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mMediaPlayer != null)
            mMediaPlayer.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mMediaPlayer != null)
            mMediaPlayer.start();
    }

    @Override
    public void onRenderSurfaceDestroyed(SurfaceTexture surfaceTexture) {
        super.onRenderSurfaceDestroyed(surfaceTexture);
        mMediaPlayer.stop();
        mMediaPlayer.release();
    }
}
