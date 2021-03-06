#include <jni.h>
#include <string>

#include "MD5.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_elseplus_opencv4android2arr_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {

    std::string hello = "Hello from C++";

    return env->NewStringUTF(hello.c_str());
}


extern "C" JNIEXPORT jstring JNICALL
Java_com_elseplus_opencv4android2arr_MainActivity_getSignKeyFromJNI(JNIEnv *env, jobject, jstring str) {
    const char *originStr;
    //将jstring转化成char *类型
    originStr = env->GetStringUTFChars(str, 0);
    MD5 md5 = MD5(originStr);
    std::string md5Result = md5.hexdigest();
    //将char *类型转化成jstring返回给Java层
    return env->NewStringUTF(md5Result.c_str());
}

