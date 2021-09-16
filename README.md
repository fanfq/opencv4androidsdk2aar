# opencv4androidsdk2aar
build aar lib


# opencv-android-sdk453-aar



opencv sdk download:
https://opencv.org/releases/

copy `[opencv-sdk-dir]/sdk/java/src/org/opencv/engine/OpenCVEngineInterface.aidl` to `[opencv-module]/src/main/aidl/org/opencv/engine/OpenCVEngineInterface.aidl`
copy `[opencv-sdk-dir]/sdk/java/src/` to `[opencv-module]/src/main/java`
copy `[opencv-sdk-dir]/sdk/native/libs/` to `[opencv-module]/src/main/jniLibs`
copy `[opencv-sdk-dir]/sdk/java/res/values/attrs.xml` to `[opencv-module]/src/main/res/values/attrs.xml`

change 


build:
`gradlew assembleRelease`




issues:
W/System.err: java.lang.UnsatisfiedLinkError: dlopen failed: library "libc++_shared.so" not found
