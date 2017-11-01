#include "com_util_NativeUtil.h"
#include <stdlib.h>


const char *PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCqEbh14KvJ1UA+LJzA1IfLowlHgEJDi/4Ppkq6XF/Qe0u4JM4/bqLWfGp88I6uITz7/VOT5EED8fv5kVEGdaxgt2NRgEJsbjqveu7hZ9UK/f4lwjYy4Q58/r4tUgbXTs/AXCQRz4A7OO7UjNxRJPxfC3AwqzhH9sHCEUUZoEUoRwIDAQAB";

const char *PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKoRuHXgq8nVQD4snMDUh8ujCUeAQkOL/g+mSrpcX9B7S7gkzj9uotZ8anzwjq4hPPv9U5PkQQPx+/mRUQZ1rGC3Y1GAQmxuOq967uFn1Qr9/iXCNjLhDnz+vi1SBtdOz8BcJBHPgDs47tSM3FEk/F8LcDCrOEf2wcIRRRmgRShHAgMBAAECgYEAjxy8Wc2HIh/moKtP+WCfKTh3/YgrusWaNLcd2TcUlc67SCkIug4yz0UBI0QW/OcRd4eUhjYkk9pUzI2BXms1cwqJlshIgiOllElCp3gmjvY9sIoU8leictnpEsMXOUpnyBuZl5NKJXnxg1hCoOot4PJFcXUj31Edi9EQbhYjRJkCQQDTvmi/DeSu5CLeiJ42eDtg+n5P5weZWlEuErMfD//8A+54Rv/QDCAwNjs+Z32C1EuLr4g+fKVorCoL/rPvyiBzAkEAzZ13dXAHcVExV11G4SPPzMlRyOAGP5cxl7tV+O4ta3VoQEI7YH7GIJvUy1ujeB/dKzFQrMRz3bteQMsOA4wH3QJASyrAAnrLIK7KFheHmqyJ375s0q6gCvd99A4dWjyS0gMPR9FkhJWZY6QM2fVhH+1/OAJDKnOTQJpFfuaXN9uYMwJAc28ZFtRbSVH06oBSf6k0S1sm0Ch9OYwvamjg/kzxMOgMLC9C2IyzvLDfyX9cCd+RsmMQUL5F8lDzvFqDNpiR/QJAZZQGI8bWvCN2f9PVMR1xWFo3Sx3IJxFbV2le5opNwzPI8qYdO0MxmI0IRw5IteFTXXwf3BI2sdVzuPhqDLcKBg==";


JNIEXPORT jstring JNICALL Java_com_util_NativeUtil_myEncrypt
(JNIEnv *env, jclass jclass1, jstring jstr){
 if (jstr == NULL) {
        return NULL;
    }
    jstring key;
    jstring result;
    jclass RSAUtilClass;
    jmethodID methodName;

    RSAUtilClass = (*env)->FindClass(env, "com/util/RSAUtil");
    if (NULL == RSAUtilClass) {
        return NULL;
    }
    methodName = (*env)->GetStaticMethodID(env, RSAUtilClass, "encrypt",
                                    "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;");
    if (NULL == methodName) {
        (*env)->DeleteLocalRef(env, RSAUtilClass);
        return NULL;
    }
    key = (*env)->NewStringUTF(env, PUBLIC_KEY);
    result = (*env)->CallStaticObjectMethod(env, RSAUtilClass, methodName, key, jstr);
    (*env)->DeleteLocalRef(env, RSAUtilClass);
    (*env)->DeleteLocalRef(env, key);
    return result;
}

JNIEXPORT jstring JNICALL Java_com_util_NativeUtil_myDecrypt
(JNIEnv *env, jclass jclass1, jstring jstr){
 if (jstr == NULL) {
        return NULL;
    }
    jstring key;
    jstring result;
    jclass RSAUtilClass;
    jmethodID methodName;

    RSAUtilClass = (*env)->FindClass(env, "com/util/RSAUtil");
    if (NULL == RSAUtilClass) {
        return NULL;
    }
    methodName = (*env)->GetStaticMethodID(env, RSAUtilClass, "decrypt",
                                    "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;");
    if (NULL == methodName) {
        (*env)->DeleteLocalRef(env, RSAUtilClass);
        return NULL;
    }
    key = (*env)->NewStringUTF(env, PRIVATE_KEY);
    result = (*env)->CallStaticObjectMethod(env, RSAUtilClass, methodName, key, jstr);
    (*env)->DeleteLocalRef(env, RSAUtilClass);
    (*env)->DeleteLocalRef(env, key);
    return result;



}


