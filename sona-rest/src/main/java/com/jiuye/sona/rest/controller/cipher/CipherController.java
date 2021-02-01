package com.jiuye.sona.rest.controller.cipher;

import com.jiuye.sona.rest.entity.CipherResult;
import com.jiuye.sona.rest.entity.UserData;
import com.jiuye.sona.rest.service.cipher.CipherService;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xinjian.hu
 * @Date: 2021/1/6 15:50
 * @Email: huxinjian@jiuyescm.com
 */
@Log4j
@RestController
public class CipherController {


    @Autowired
    private CipherService cipherService;


    //加密
    @GetMapping("right")
    public UserData right(@RequestParam(value = "name", defaultValue = "朱晔") String name,
                          @RequestParam(value = "idcard", defaultValue = "300000000000001234") String idCard,
                          @RequestParam(value = "aad", required = false) String aad) throws Exception {
        UserData userData = new UserData();
        userData.setId(1L);
        //脱敏姓名
        userData.setName(chineseName(name));
        //脱敏身份证
        userData.setIdcard(idCard(idCard));
        //加密姓名
        CipherResult cipherResultName = cipherService.encrypt(name, aad);
        userData.setNameCipherId(cipherResultName.getId());
        userData.setNameCipherText(cipherResultName.getCipherText());
        //加密身份证
        CipherResult cipherResultIdCard = cipherService.encrypt(idCard, aad);
        userData.setIdcardCipherId(cipherResultIdCard.getId());
        userData.setIdcardCipherText(cipherResultIdCard.getCipherText());
        return userData;
    }

    //解密
    @GetMapping("read")
    public void read(@RequestParam(value = "aad", required = false) String aad) throws Exception {
        //查询用户信息
        //UserData userData = userRepository.findById(1L).get();
        UserData userData = new UserData();
        //使用AAD来解密姓名和身份证
        String name = cipherService.decrypt(userData.getNameCipherId(), userData.getNameCipherText(), aad);
        String IdCard = cipherService.decrypt(userData.getIdcardCipherId(), userData.getIdcardCipherText(), aad);
        log.info("name:" + name + "idcard:" + IdCard);
    }

    //脱敏身份证
    private static String idCard(String idCard) {
        String num = StringUtils.right(idCard, 4);
        return StringUtils.leftPad(num, StringUtils.length(idCard), "*");
    }

    //脱敏姓名
    public static String chineseName(String chineseName) {
        String name = StringUtils.left(chineseName, 1);
        return StringUtils.rightPad(name, StringUtils.length(chineseName), "*");
    }
}
