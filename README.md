# RajawaliCardboardExample

Example project for integration Rajawali and Cardboard SDK.

Sample photo is from http://eje-c.com/vr_promotion/.

## Note

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
