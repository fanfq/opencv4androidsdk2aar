# opencv4androidsdk2aar

opencv ver.4.5.3

demo testing in app

```
boolean success = OpenCVLoader.initDebug();
if (!success) {
    Log.e("TAG", "初始化失败");
    tv.setText("opencv 初始化失败 !!!");
    tv.setTextColor(Color.RED);
}else {
    tv.setText("opencv 初始化成功 !!! ver."+OpenCVLoader.OPENCV_VERSION);
    Log.e("TAG", "opencv 初始化成功 !! ver."+OpenCVLoader.OPENCV_VERSION);
    tv.setTextColor(Color.BLUE);
}
```


# guide line (build opencv other version you can changes as below)

opencv sdk download:
https://opencv.org/releases/

copy `[opencv-sdk-dir]/sdk/java/src/org/opencv/engine/OpenCVEngineInterface.aidl` 
to `[opencv-module]/src/main/aidl/org/opencv/engine/OpenCVEngineInterface.aidl`

copy `[opencv-sdk-dir]/sdk/java/src/` 
to `[opencv-module]/src/main/java`

copy `[opencv-sdk-dir]/sdk/native/libs/` 
to `[opencv-module]/src/main/jniLibs`

copy `[opencv-sdk-dir]/sdk/java/res/values/attrs.xml` 
to `[opencv-module]/src/main/res/values/attrs.xml`

change app build.gradle line 
```
externalNativeBuild {
    cmake {
        cppFlags ""
        arguments "-DANDROID_STL=c++_shared" //fix dlopen failed: library "libc++_shared.so" not found
    }
}
```

build:
`./gradlew assembleRelease`


outputs: 
`opencv/build/outputs/aar/opencv-release.aar`





