package com.zhou.nodepro_lib.protocal;

/**
 * Created by zhou on 2017/11/10.
 */

public class NBProtocal implements BaseProtocol {

    private NBMessageType mNBMessageType = NBMessageType.NONE;

    public void setType(NBMessageType type) {
        this.mNBMessageType = type;
    }

    @Override
    public String getHeadFrame() throws Exception {
        switch (mNBMessageType) {
            case SUB:
                return "ABAB010000FF05";
            case DATA_COMMAND:
                return "ABAB010000FD";
            case NONE:
                throw new Exception("必须设定NB协议类型");
        }
        return null;
    }
}
