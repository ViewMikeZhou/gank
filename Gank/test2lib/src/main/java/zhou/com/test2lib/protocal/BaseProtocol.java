package zhou.com.test2lib.protocal;

/**
 * Created by zhou on 2017/11/10.
 */

public interface BaseProtocol {

  public NBMessageType mNBMessageType = NBMessageType.NONE;


    /**
     *
     * @return
     */
    String getHeadFrame() throws Exception;
}
