/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class net_audumla_perio_i2c_rpi_jni_RPiI2CNative */

#ifndef _Included_net_audumla_perio_i2c_rpi_jni_RPiI2CNative
#define _Included_net_audumla_perio_i2c_rpi_jni_RPiI2CNative
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     net_audumla_perio_i2c_rpi_jni_RPiI2CNative
 * Method:    open
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_net_audumla_perio_i2c_rpi_jni_RPiI2CNative_open
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     net_audumla_perio_i2c_rpi_jni_RPiI2CNative
 * Method:    close
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_net_audumla_perio_i2c_rpi_jni_RPiI2CNative_close
  (JNIEnv *, jclass, jint);

/*
 * Class:     net_audumla_perio_i2c_rpi_jni_RPiI2CNative
 * Method:    setClock
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_net_audumla_perio_i2c_rpi_jni_RPiI2CNative_setClock
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     net_audumla_perio_i2c_rpi_jni_RPiI2CNative
 * Method:    getClock
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_net_audumla_perio_i2c_rpi_jni_RPiI2CNative_getClock
  (JNIEnv *, jclass, jint);

/*
 * Class:     net_audumla_perio_i2c_rpi_jni_RPiI2CNative
 * Method:    write
 * Signature: (IIBBB)I
 */
JNIEXPORT jint JNICALL Java_net_audumla_perio_i2c_rpi_jni_RPiI2CNative_write__IIBBB
  (JNIEnv *, jclass, jint, jint, jbyte, jbyte, jbyte);

/*
 * Class:     net_audumla_perio_i2c_rpi_jni_RPiI2CNative
 * Method:    read
 * Signature: (IIB)B
 */
JNIEXPORT jbyte JNICALL Java_net_audumla_perio_i2c_rpi_jni_RPiI2CNative_read__IIB
  (JNIEnv *, jclass, jint, jint, jbyte);

/*
 * Class:     net_audumla_perio_i2c_rpi_jni_RPiI2CNative
 * Method:    write
 * Signature: (IIBB)I
 */
JNIEXPORT jint JNICALL Java_net_audumla_perio_i2c_rpi_jni_RPiI2CNative_write__IIBB
  (JNIEnv *, jclass, jint, jint, jbyte, jbyte);

/*
 * Class:     net_audumla_perio_i2c_rpi_jni_RPiI2CNative
 * Method:    read
 * Signature: (II)B
 */
JNIEXPORT jbyte JNICALL Java_net_audumla_perio_i2c_rpi_jni_RPiI2CNative_read__II
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     net_audumla_perio_i2c_rpi_jni_RPiI2CNative
 * Method:    write
 * Signature: (IIII[BB)I
 */
JNIEXPORT jint JNICALL Java_net_audumla_perio_i2c_rpi_jni_RPiI2CNative_write__IIII_3BB
  (JNIEnv *, jclass, jint, jint, jint, jint, jbyteArray, jbyte);

/*
 * Class:     net_audumla_perio_i2c_rpi_jni_RPiI2CNative
 * Method:    write
 * Signature: (IIBIII[B[B)I
 */
JNIEXPORT jint JNICALL Java_net_audumla_perio_i2c_rpi_jni_RPiI2CNative_write__IIBIII_3B_3B
  (JNIEnv *, jclass, jint, jint, jbyte, jint, jint, jint, jbyteArray, jbyteArray);

/*
 * Class:     net_audumla_perio_i2c_rpi_jni_RPiI2CNative
 * Method:    read
 * Signature: (IIII[BB)I
 */
JNIEXPORT jint JNICALL Java_net_audumla_perio_i2c_rpi_jni_RPiI2CNative_read__IIII_3BB
  (JNIEnv *, jclass, jint, jint, jint, jint, jbyteArray, jbyte);

/*
 * Class:     net_audumla_perio_i2c_rpi_jni_RPiI2CNative
 * Method:    read
 * Signature: (IIBIII[B[B)I
 */
JNIEXPORT jint JNICALL Java_net_audumla_perio_i2c_rpi_jni_RPiI2CNative_read__IIBIII_3B_3B
  (JNIEnv *, jclass, jint, jint, jbyte, jint, jint, jint, jbyteArray, jbyteArray);

#ifdef __cplusplus
}
#endif
#endif
