package com.jiuye.sona.common.Lock;

import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.io.UnsupportedEncodingException;

/**
 * @Author: xinjian.hu
 * @Date: 2020/8/25 16:59
 * @Email: huxinjian@jiuyescm.com
 */
public class SonaZkSerializer implements ZkSerializer {

    /**
     * 字符集
     */
    private static final String CHARSET = "utf-8";

    /**
     * 序列化
     *
     * @param data
     * @return
     * @throws ZkMarshallingError
     */
    @Override
    public byte[] serialize(Object data) throws ZkMarshallingError {
        try {
            return String.valueOf(data).getBytes(CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new ZkMarshallingError(e);
        }
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @return
     * @throws ZkMarshallingError
     */
    @Override
    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
        try {
            return new String(bytes, CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new ZkMarshallingError(e);
        }
    }
}
