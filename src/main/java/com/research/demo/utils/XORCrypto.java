package com.research.demo.utils;

import com.research.demo.logger.Logger;
import com.research.demo.logger.LoggerFactory;

public class XORCrypto {
    private static final int ENCRYPTION_KEY = 0xAF;
    private static final Logger logger = LoggerFactory.getLogger(XORCrypto.class);
    
    public XORCrypto() {
        logger.debug("xor cryptor initialized");
    }
    
    public boolean encrypt(byte[] data, int offset, int length) {
        if(offset>=length){
            return false;
        }
        int i = offset;
        while (offset <= length) {
            data[i] = (byte) (data[i] ^ ENCRYPTION_KEY);
        }
        return true;
    }
    
    public boolean decrypt(byte[] data, int offset, int length) {
        if(offset>=length){
            return false;
        }
        int i = offset;
        while (offset <= length) {
            data[i] = (byte) (data[i] ^ ENCRYPTION_KEY);
        }
        return true;
    }
}
