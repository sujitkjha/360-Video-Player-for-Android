# RajawaliCardboardExample

Example project for integration [Rajawali](https://github.com/Rajawali/Rajawali) and [Cardboard SDK](https://developers.google.com/cardboard/android/).

![image](http://ejeinc.github.io/RajawaliCardboardExample/image.jpg)

Sample photo is from http://eje-c.com/vr_promotion/.

There are 3 modules in this project.

* **rajawali** is a copy of [Rajawali](https://github.com/Rajawali/Rajawali) (see below).
* **rajawalicardboard** is a glue module which integrates Cardboard SDK and Rajawali. This module provides two classes `RajawaliCardboardView` and `RajawaliCardboardRenderer`. Your renderer should extend `RajawaliCardboardRenderer` and you should put `RajawaliCardboardView` to render your scene.
* **app** is an example app. This simply shows 360 panorama photo.

## How to create your project from scratch

1. Download in ZIP or clone this repository.
2. Create new project with Android Studio. Cardboard SDK requires SDK Level 16 so you should select API 16 or higher.
3. Select File->Import Module...
4. Browse to `rajawalicardboard` directory and click Finish button. `rajawali` directory is also required. But it is automatically imported when `rajawalicardboard` is imported.
5. Add module dependency in `app` module. Open `%Project ROOT%/app/build.gradle` and add `compile project(':rajawalicardboard')` in `dependencies` block.
6. Edit `AndroidManifest.xml` to launch `MainActivity` in landscape mode. Open `%Project ROOT%/app/src/main/AndroidManifest.xml` and add `android:screenOrientation="landscape"` attribute to `<activity>`.
7. Modify your `MainActivity` like this.

```java
public class MainActivity extends CardboardActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    RajawaliCardboardView view = new RajawaliCardboardView(this);
    setContentView(view);
    setCardboardView(view);

    RajawaliCardboardRenderer renderer = new MyRenderer(this); // your renderer
    view.setRenderer(renderer);        // required for CardboardView
    view.setSurfaceRenderer(renderer); // required for RajawaliSurfaceView
  }
  
  private static class MyRenderer extends RajawaliCardboardRenderer {
    
    public MyRenderer(Context context) {
      super(context);
    }

    @Override
    protected void initScene() {

      // create your scene

    }
  }
}
```

## Create your scene

Your renderer should extend `RajawaliCardboardRenderer` and create your scene in `initScene()`. Nothing is special. Just create an normal scene like you did in `RajawaliRenderer`.

Camera is automatically rotated with gyro sensor. You should not set camera's orientation manually.

## Why this project has rajawali module instead of gradle dependency

This project has own copy of [Rajawali](https://github.com/Rajawali/Rajawali) because I have to edit one line of codes. Edited line is #1011 line of `org.rajawali3d.scene.RajawaliScene`.

```java
...
} else {
  GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, 0);
  GLES20.glClearColor(mRed, mGreen, mBlue, mAlpha);
}
...
```

to

```java
...
} else {
  // GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, 0);
  GLES20.glClearColor(mRed, mGreen, mBlue, mAlpha);
}
...
```

I do not guarantee that my copy of rajawali is up to date. Rajawali will support VR soon. This project is considered for temporary use.

