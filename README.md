# RajawaliCardboardExample

Example project for integration Rajawali and Cardboard SDK.

![image](http://ejeinc.github.io/RajawaliCardboardExample/image.jpg)

Sample photo is from http://eje-c.com/vr_promotion/.

There are 3 modules in this project.

* **rajawali** is a copy of [Rajawali](https://github.com/Rajawali/Rajawali) (see below).
* **rajawalicardboard** is a glue module which integrates Cardboard SDK and Rajawali. This module provides two classes `RajawaliCardboardView` and `RajawaliCardboardRenderer`. Your renderer should extend `RajawaliCardboardRenderer` and you should put `RajawaliCardboardView` to render your scene.
* **app** is an example app. This simply shows 360 panorama photo.

Your Activity should extends `CardboardActivity` and you have to associate your renderer and `RajawaliCardboardView`.

```java
public class MainActivity extends CardboardActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    RajawaliCardboardView view = new RajawaliCardboardView(this);
    setContentView(view);
    setCardboardView(view);

    RajawaliCardboardRenderer renderer = new MyRenderer(this);
    view.setRenderer(renderer);
    view.setSurfaceRenderer(renderer);
  }
}
```

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

