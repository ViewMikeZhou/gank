package com.zhou.nodepro_lib.commond;

/**数据接受解析类
 * Created by zhou on 2017/11/10.
 */

public class CommandReceiver {

    //NodeType mNodeType;
    public void parsingCommand(byte[] data ,NodeType nodeType) throws Exception {
        if (data[0] == 170){
            //AA
            getStationData(data);
        }else {
            //AB
            getNodeData(data,nodeType);
        }
    }

    private void getNodeData(byte[] data,NodeType nodeType) throws Exception {
        byte[] deviceId = splitByteArray(data, 2, 3);
        byte  funcode=  0;
        if(nodeType == null)
            return;
        switch (funcode){
            case 95:
                nodeType.getParsingType(CommandType.PASS_CAR,new PassCarInfo(data));
                break;
        }

    }

    private void getStationData(byte[] data) {

    }

    public  byte[] splitByteArray(byte[]data, int offset , int length) throws Exception {
        if (data.length < offset){
            throw  new Exception("传入的数组长度与截取不符");
        }
        if (length > data.length){
            throw  new Exception("传入的数组长度与截取不符");
        }

        byte arr [] = new byte[length];
        for (int i= offset ; i < length+1 ; i ++){
            arr[i] = data[i];
        }
        return arr;
    }



    public interface NodeType{
        void getParsingType(CommandType type,Object o);
    }

    public  byte[] string2ByteArray(String str) {
        int offset = 0;
        byte[] dataArray = new byte[(str.length() + 1) / 2];
        for (int i = 0; i < str.length(); i += 2) {
            String temp;
            if (i + 2 > str.length()) {
                temp = str.substring(i, i + 1);
            } else {
                temp = str.substring(i, i + 2);
            }

            dataArray[offset] = Integer.valueOf(temp, 16).byteValue();
            offset++;
        }
        return dataArray;
    }
}
