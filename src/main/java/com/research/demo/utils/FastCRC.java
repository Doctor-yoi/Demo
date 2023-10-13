package com.research.demo.utils;

public class FastCRC {
    private byte[] data;
    public FastCRC(byte[] data){
    
    }
    public static byte crc4_itu(byte[] data, int offset,int length){
        byte i;
        byte crc = 0;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for (i = 0; i < 8; ++i){
                if ((crc & 1) != 0)
                    crc = (byte) (((crc & 0xff) >> 1 ) ^ 0x0C);
                else
                    crc = (byte) ((crc & 0xff) >> 1);
            }
        }
        return (byte) (crc & 0xf);
    }
    
    public static byte crc5_epc(byte data[],int offset,int length){
        byte i;
        byte crc = 0x48;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for ( i = 0; i < 8; i++ ){
                if ( (crc & 0x80) != 0)
                    crc = (byte) ((crc << 1) ^ 0x48);
                else
                    crc <<= 1;
            }
        }
        return (byte) (crc >> 3 & 0x1f);
    }
    
    public static byte crc5_itu(byte[] data,int offset,int length){
        byte i;
        byte crc = 0;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for (i = 0; i < 8; ++i){
                if ((crc & 1) == 0)
                    crc = (byte) ((crc&0xff) >> 1);
                else
                    crc = (byte) (((crc&0xff) >> 1) ^ 0x15);
            }
        }
        return (byte) (crc & 0x1f);
    }
    
    public static byte crc5_usb(byte[] data,int offset,int length){
        byte i;
        byte crc = 0x1F;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for (i = 0; i < 8; ++i){
                if ((crc & 1) == 0)
                    crc = (byte) ((crc&0xff) >> 1);
                else
                    crc = (byte) (((crc&0xff) >> 1) ^ 0x14);
            }
        }
        return (byte) (crc ^ 0x1F & 0x1f);
    }
    
    public static byte crc6_itu(byte[] data,int offset,int length){
        byte i;
        byte crc = 0;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for (i = 0; i < 8; ++i){
                if ((crc & 1) == 0)
                    crc = (byte) ((crc&0xff) >> 1);
                else
                    crc = (byte) (((crc&0xff) >> 1) ^ 0x30);
            }
        }
        return (byte) (crc & 0x3f);
    }
    
    public static byte crc7_mmc(byte[] data,int offset,int length){
        byte i;
        byte crc = 0;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for ( i = 0; i < 8; i++ )
            {
                if ( (crc & 0x80) ==0)
                    crc <<= 1;
                else
                    crc = (byte) ((crc << 1) ^ 0x12);
            }
        }
        return (byte) (crc >> 1 & 0x7f);
    }
    
    public static byte crc8(byte[] data,int offset,int length){
        byte i;
        byte crc = 0;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for ( i = 0; i < 8; i++ )
            {
                if ( (crc & 0x80) == 0)
                    crc <<= 1;
                else
                    crc = (byte) ((crc << 1) ^ 0x07);
            }
        }
        return crc;
    }
   
    public static byte crc8_itu(byte[] data,int offset,int length){
        byte i;
        byte crc = 0;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for ( i = 0; i < 8; i++ )
            {
                if ( (crc & 0x80) == 0)
                    crc <<= 1;
                else
                    crc = (byte) ((crc << 1) ^ 0x07);
            }
        }
        return (byte) (crc ^ 0x55);
    }
    
    public static byte crc8_rohc(byte[] data,int offset,int length){
        byte i;
        byte crc = 0;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for ( i = 0; i < 8; i++ )
            {
                if ( (crc & 0x80) == 0)
                    crc = (byte) ((crc&0xff) >> 1);
                else
                    crc = (byte) (((crc&0xff) >> 1) ^ 0xE0);
            }
        }
        return crc;
    }
    
    public static byte crc8_maxim(byte[] data,int offset,int length){
        byte i;
        byte crc = 0;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for ( i = 0; i < 8; i++ ){
                if ( (crc & 1) == 0)
                    crc = (byte) ((crc&0xff) >> 1);
                else
                    crc = (byte) (((crc&0xff) >> 1) ^ 0x8C);
            }
        }
        return crc;
    }
    
    public static short crc16_ibm(byte[] data,int offset,int length){
        byte i;
        short crc = 0;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for (i = 0; i < 8; ++i)
            {
                if ((crc & 1) == 0)
                    crc = (short) (crc >> 1);
                else
                    crc = (short) ((crc >> 1) ^ 0xA001);
            }
        }
        return crc;
    }
    
    public static short crc16_maxim(byte[] data,int offset,int length){
        byte i;
        short crc = 0;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for (i = 0; i < 8; ++i){
                if ((crc & 1) == 0)
                    crc = (short) (crc >> 1);
                else
                    crc = (short) ((crc >> 1) ^ 0xA001);
            }
        }
        return (short) ~crc;
    }
    
    public static short crc16_usb(byte[] data,int offset,int length){
        byte i;
        short crc = (short) 0xffff;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];            // crc ^= *data; data++;
            for (i = 0; i < 8; ++i)
            {
                if ((crc & 1) == 0)
                    crc = (short) (crc >> 1);
                else
                    crc = (short) ((crc >> 1) ^ 0xA001);
            }
        }
        return (short) ~crc;
    }
    
    public static int crc16_modbus(byte[] data,int offset,int length){
        int crc = 0xffff;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc = (crc ^ (data[j] & 0xff)) & 0xffff;  // crc ^= *data; data++;
            for(int i = 0; i < 8; i++){
                if ((crc & 1) == 0)
                    crc = crc >> 1;
                else
                    crc = ((crc >> 1) ^ 0xA001) & 0xffff;
            }
        }
        return crc ;
    }
    
    public static short crc16_ccitt(byte[] data,int offset,int length){
        byte i;
        short crc = 0;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for (i = 0; i < 8; ++i){
                if ((crc & 1) != 0)
                    crc = (short) ((crc >> 1) ^ 0x8408);
                else
                    crc = (short) (crc >> 1);
            }
        }
        return crc;
    }
    
    public static short crc16_ccitt_false(byte[] data,int offset,int length){
        byte i;
        short crc = (short) 0xffff;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= (short)(data[j]) << 8; // crc ^= (uint6_t)(*data)<<8; data++;
            for (i = 0; i < 8; ++i)
            {
                if ( (crc & 0x8000) != 0)
                    crc = (short) ((crc << 1) ^ 0x1021);
                else
                    crc <<= 1;
            }
        }
        return crc;
    }
    
    public static short crc16_x25(byte[] data,int offset,int length){
        byte i;
        short crc = (short) 0xffff;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for (i = 0; i < 8; ++i)
            {
                if ((crc & 1) != 0)
                    crc = (short) ((crc >> 1) ^ 0x8408);
                else
                    crc = (short) (crc >> 1);
            }
        }
        return (short) ~crc;
    }
    
    public static short crc16_xmodem(byte[] data, int offset,int length){
        byte i;
        short crc = 0;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= (short)data[j] << 8;
            for (i = 0; i < 8; ++i){
                if ( (crc & 0x8000) != 0)
                    crc = (short) ((crc << 1) ^ 0x1021);
                else
                    crc <<= 1;
            }
        }
        return crc;
    }
    
    public static short crc16_dnp(byte[] data, int offset,int length){
        byte i;
        short crc = 0;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for (i = 0; i < 8; ++i){
                if ((crc & 1) != 0)
                    crc = (short) ((crc >> 1) ^ 0xA6BC);
                else
                    crc = (short) (crc >> 1);
            }
        }
        return (short) ~crc;
    }
    
    public static int crc32(byte[] data, int offset,int length){
        byte i;
        int crc = 0xffffffff;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j];
            for (i = 0; i < 8; ++i){
                if ((crc & 1) != 0)
                    crc = (crc >> 1) ^ 0xEDB88320;
                else
                    crc = (crc >> 1);
            }
        }
        return ~crc;
    }
    
    public static int crc32_mpeg_2(byte[] data,int offset, int length){
        byte i;
        int crc = 0xffffffff;
        length += offset;
        for(int j=offset;j<length;j++) {
            crc ^= data[j] << 24;
            for (i = 0; i < 8; ++i){
                if ( (crc & 0x80000000) != 0)
                    crc = (crc << 1) ^ 0x04C11DB7;
                else
                    crc <<= 1;
            }
        }
        return crc;
    }
}
