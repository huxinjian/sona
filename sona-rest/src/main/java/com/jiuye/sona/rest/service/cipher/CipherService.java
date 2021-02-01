package com.jiuye.sona.rest.service.cipher;

import com.alibaba.fastjson.JSON;
import com.jiuye.sona.rest.entity.CipherData;
import com.jiuye.sona.rest.entity.CipherResult;
import com.jiuye.sona.rest.entity.UserData;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.*;

/**
 * @Author: xinjian.hu
 * @Date: 2021/1/6 15:33
 * @Email: huxinjian@jiuyescm.com
 */
@Service
public class CipherService {

    /**
     * 密钥长度
     */
    public static final int AES_KEY_SIZE = 256;
    /**
     * 初始化向量长度
     */
    public static final int GCM_IV_LENGTH = 12;
    /**
     * GCM身份认证Tag长度
     */
    public static final int GCM_TAG_LENGTH = 16;

    /**
     * 内部加密算法
     *
     * @param plaintext
     * @param key
     * @param iv
     * @param aad
     * @return
     * @throws Exception
     */
    public static byte[] doEncrypt(byte[] plaintext, SecretKey key, byte[] iv, byte[] aad) throws Exception {
        //加密算法
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        //Key规范
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
        //GCM参数规范
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
        //加密模式
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);
        //设置aad
        if (aad != null) {
            //加密
            cipher.updateAAD(aad);
        }
        byte[] cipherText = cipher.doFinal(plaintext);
        return cipherText;
    }


    /**
     * 内部解密方法
     *
     * @param cipherText
     * @param key
     * @param iv
     * @param aad
     * @return
     * @throws Exception
     */
    public static String doDecrypt(byte[] cipherText, SecretKey key, byte[] iv, byte[] aad) throws Exception {
        // 加密算法
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        // Key规范
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
        //GCM参数规范
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
        //解密模式
        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);
        //设置aad
        if (aad != null) {
            cipher.updateAAD(aad);
        }
        //解密
        byte[] decryptedText = cipher.doFinal(cipherText);
        return new String(decryptedText);
    }

    /**
     * 加密入口
     *
     * @param data
     * @param aad
     * @throws Exception
     */
    public CipherResult encrypt(String data, String aad) throws Exception {
        //加密结果
        CipherResult encryptResult = new CipherResult();
        //密钥生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        //生成密钥
        keyGenerator.init(AES_KEY_SIZE);
        SecretKey key = keyGenerator.generateKey();
        //IV数据
        byte[] iv = new byte[GCM_IV_LENGTH];
        //随机生成IV
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        //处理aad
        byte[] aaddata = null;
        if (!StringUtils.isEmpty(aad)) {
            aaddata = aad.getBytes();
        }
        //获得密文
        //String cipherText = Base64.getEncoder().encodeToString(doEncrypt(data.getBytes(), key, iv, aaddata));
        encryptResult.setCipherText(Base64.getEncoder().encodeToString(doEncrypt(data.getBytes(), key, iv, aaddata)));
        //加密上下文数据
        CipherData cipherData = new CipherData();
        //保存IV
        cipherData.setIv(Base64.getEncoder().encodeToString(iv));
        //保存密钥
        cipherData.setSecureKey(Base64.getEncoder().encodeToString(key.getEncoded()));
        //cipherRepository.save(cipherData);
        //返回本地加密ID
        encryptResult.setId(cipherData.getId());
        return encryptResult;
    }

    /**
     * 解密入口
     *
     * @param cipherId
     * @param cipherText
     * @param aad
     * @return
     * @throws Exception
     */
    public String decrypt(long cipherId, String cipherText, String aad) throws Exception {
        //使用加密ID找到加密上下文数据
        //CipherData cipherData = cipherRepository.findById(cipherId).orElseThrow(() -> new IllegalArgumentException("invlaid cipherId"));
        CipherData cipherData = new CipherData();
        //加载密钥
        byte[] decodedKey = Base64.getDecoder().decode(cipherData.getSecureKey());
        //初始化密钥
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        //加载IV
        byte[] decodedIv = Base64.getDecoder().decode(cipherData.getIv());
        //处理aad
        byte[] aaddata = null;
        if (!StringUtils.isEmpty(aad)) {
            aaddata = aad.getBytes();
        }
        //解密
        return doDecrypt(Base64.getDecoder().decode(cipherText.getBytes()), originalKey, decodedIv, aaddata);
    }


    public static void main(String[] args) {
        UserData userData = new UserData();
        userData.setId(1L);
        userData.setName("123");
        Optional<UserData> userDataOptional = Optional.ofNullable(userData);
        System.out.println(userDataOptional.isPresent());
        System.out.println(userDataOptional.get());

        Optional<UserData> userDataOptional1 = userDataOptional.map((value) -> { value.setIdcard("12311"); return value;});
        System.out.println(userDataOptional1.get());

        UserData userData1 = null;
        Optional<UserData> userDataOptional2 = Optional.ofNullable(userData1);
        //Optional<UserData> userDataOptional2 = Optional.of(userData1);

        System.out.println(userDataOptional2.isPresent());
        System.out.println(userDataOptional2.orElse(userData));
        System.out.println(userDataOptional2.orElseGet(() -> {
            UserData userData2 = new UserData();
            userData2.setId(2L);
            userData2.setName("1234");
            return userData2;
        }));

        Optional<UserData> userDataOptional3 = Optional.empty();
        userDataOptional3.ifPresent(userData3 ->System.out.println(userData3));



//        List<UserData> userDataList = new ArrayList<>();
//        userDataList.add(new UserData());
//        userDataList.add(new UserData());
//        userDataList.add(null);
//        userDataList.add(new UserData());
//        userDataList.add(new UserData());
//        Optional.ofNullable(userDataList)
//            .orElseGet(()->{
//                System.out.println("personList为null！");
//                return new ArrayList<>();})
//            .stream().filter(Objects::nonNull)
//            .forEach(userData4 -> {
//                System.out.println(JSON.toJSONString(null));
//                System.out.println(JSON.toJSONString(userData4));
//        });
        UserData u6 = null;
        System.out.println(JSON.toJSONString(u6));
    }
}
