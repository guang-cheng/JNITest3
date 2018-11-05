#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_ainm_jnitest3_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jintArray  JNICALL
Java_com_ainm_jnitest3_MainActivity_encodeArray(JNIEnv *env, jobject instance, jintArray arrs_) {
    jint *arrs = env->GetIntArrayElements(arrs_, NULL);

    // TODO
    //拿到整型数组的长度以及第0个元素的地址
    //jsize       (*GetArrayLength)(JNIEnv*, jarray);
    //获取 Java 传递下来 数组 的 长度
    //jsize len = (*jniEnv)->GetArrayLength(jniEnv, InCode);
    jsize length = env->GetArrayLength(arrs_);
    // jint*       (*GetIntArrayElements)(JNIEnv*, jintArray, jboolean*);
//    int* arrp = (*env)->GetIntArrayElements(env, arrs_, 0);
    //新建一个长度为len的jintArray数组
    //jintArray array = (*jniEnv)-> NewIntArray(jniEnv, len);
    jintArray array = env->NewIntArray(length);

    // 把 Java 传递下来的数组 用 jint* 存起来
    //jint *body = (*env)->GetIntArrayElements(env,InCode, 0);
    jint *body = env->GetIntArrayElements(arrs_, 0);
    jint num[length];
    int i;
    for(i = 0;i<length;i++){
//        *(arrp + i) += 10; //将数组中的每个元素加10
        num[i] = body[i] + 10;
        scanf("%d",*(arrs_+i));
        printf("%d",arrs_[i]);
    }
    //给 需要返回的数组赋值
    //(*jniEnv)->SetIntArrayRegion(jniEnv,array, 0, len, num);
    env->SetIntArrayRegion(array, 0, length, num);
    return array;
}