package com.newitventure.mediaplayer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.ImageView;


import com.google.vrtoolkit.cardboard.CardboardActivity;
import com.google.vrtoolkit.cardboard.CardboardView;
import com.google.vrtoolkit.cardboard.Eye;
import com.google.vrtoolkit.cardboard.HeadTransform;
import com.google.vrtoolkit.cardboard.Viewport;

import javax.microedition.khronos.egl.EGLConfig;

/**
 * A Cardboard sample application.
 */
public class VrMagenetActivity  {

	/*extends CardboardActivity implements CardboardView.StereoRenderer
	private static final String TAG = "VrMagenetActivity";

	Uri fileUri = null;
	ImageView photoImage = null;

	private int mScore = 0;

	private Vibrator mVibrator;

	private MyRenderer mOverlayView;

	*//**
	 * Sets the view to our CardboardView and initializes the transformation
	 * matrices we will use to render our scene. //@param savedInstanceState
	 *//*
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_activity);
		CardboardView cardboardView = (CardboardView) findViewById(R.id.image);
		cardboardView.setRenderer(this);
		setCardboardView(cardboardView);

		mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		//mOverlayView = (MyRenderer) findViewById(R.id.overlay);

		//mOverlayView.show3DSplashImage();*//*

	}

	@Override
	public void onCardboardTrigger() {

		Log.i(TAG, "onRendererShutdown1");
		//mOverlayView.show3DImage(mScore++, VrMagenetActivity.this);
		// mScore++;
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);

		mVibrator.vibrate(50);
	}

	@Override
	public void onRendererShutdown() {
		Log.i(TAG, "onRendererShutdown");
	}

	@Override
	public void onSurfaceChanged(int width, int height) {
		Log.i(TAG, "onSurfaceChanged");
	}

	*//**
	 * Creates the buffers we use to store information about the 3D world.
	 * OpenGL doesn't use Java arrays, but rather needs data in a format it can
	 * understand. Hence we use ByteBuffers.
	 * 
	 * @param config
	 *            The EGL configuration used when creating the surface.
	 *//*
	@Override
	public void onSurfaceCreated(EGLConfig config) {
		Log.i(TAG, "onSurfaceCreated");
	}

	*//**
	 * Prepares OpenGL ES before we draw a frame.
	 *
	 * @param headTransform
	 *            The head transformation in the new frame.
	 *//*
	@Override
	public void onNewFrame(HeadTransform headTransform) {

	}

	@Override
	public void onDrawEye(Eye eye) {

	}

	@Override
	public void onFinishFrame(Viewport viewport) {

	}*/
}