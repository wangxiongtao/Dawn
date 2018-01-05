package com.dawn.modules.Fingerprint;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v4.os.CancellationSignal;

import com.util.ToastUtil;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * Created by Administrator on 2017/11/27.
 */

public class MyFingerPrintManager {
    private static MyFingerPrintManager manager;
    private static KeyStore mKeyStore;
    private KeyGenerator mKeyGenerator;
   private FingerprintManagerCompat.CryptoObject cryptoObject;
    private CancellationSignal cancellationSignal;
    public static MyFingerPrintManager getInstance() {
        if (manager == null) {
            manager = new MyFingerPrintManager();
        }
        return manager;
    }

    private MyFingerPrintManager() {
        try {
            mKeyStore = KeyStore.getInstance("AndroidKeyStore");

            mKeyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");

            Cipher defaultCipher = Cipher.getInstance(KeyProperties.KEY_ALGORITHM_AES + "/" + KeyProperties.BLOCK_MODE_CBC + "/" + KeyProperties.ENCRYPTION_PADDING_PKCS7);
            createKey("default", false);
            initCipher(defaultCipher, "default");
            cryptoObject = new FingerprintManagerCompat.CryptoObject(defaultCipher);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void startListening(Context context) {
        FingerprintManagerCompat manager = FingerprintManagerCompat.from(context);
        if (!isFingerprintAuthAvailable(manager)) {
            return;
        }
        cancellationSignal = new CancellationSignal();
        manager.authenticate(cryptoObject, 0, cancellationSignal,new FingerprintManagerCompat.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                ToastUtil.showShort(context, "指纹错误--" + errString);
            }

            @Override
            public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                super.onAuthenticationHelp(helpCode, helpString);
                ToastUtil.showShort(context, "指纹帮助--" + helpString);
            }

            @Override
            public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                ToastUtil.showShort(context, "指纹成功");
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                ToastUtil.showShort(context, "指纹失败--");
            }
        }, null);

    }

    public void stopListening() {
        if (cancellationSignal != null) {
//            mSelfCancelled = true;
            cancellationSignal.cancel();
            cancellationSignal = null;
        }
    }

    public boolean isFingerprintAuthAvailable(FingerprintManagerCompat m) {
        return m.isHardwareDetected() && m.hasEnrolledFingerprints();
    }

    private void createKey(String keyName, boolean invalidatedByBiometricEnrollment) throws CertificateException, NoSuchAlgorithmException, IOException, InvalidAlgorithmParameterException {
        mKeyStore.load(null);
        KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(keyName,
                KeyProperties.PURPOSE_ENCRYPT |
                        KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                .setUserAuthenticationRequired(true)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            builder.setInvalidatedByBiometricEnrollment(invalidatedByBiometricEnrollment);
        }
        mKeyGenerator.init(builder.build());
        mKeyGenerator.generateKey();

    }

    private void initCipher(Cipher cipher, String keyName) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, InvalidKeyException, IOException, CertificateException {
        mKeyStore.load(null);
        SecretKey key = (SecretKey) mKeyStore.getKey(keyName, null);//1. 一个新的指纹image已经注册到系统中 2. 当前设备中的曾经注册过的指纹现在不存在了，可能是被全部删除了 3. 用户关闭了屏幕锁功能 4. 用户改变了屏幕锁的方式 时 得到的key为null
        cipher.init(Cipher.ENCRYPT_MODE, key);
    }

    public interface Callback {

        void onAuthenticated();

        void onError();
    }

}
