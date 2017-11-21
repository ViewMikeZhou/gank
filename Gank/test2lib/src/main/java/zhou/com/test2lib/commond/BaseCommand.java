package zhou.com.test2lib.commond;


import zhou.com.test2lib.protocal.BaseProtocol;

/**
 * Created by zhou on 2017/11/10.
 */

public abstract class BaseCommand {
    protected BaseCommand mCommand;
    protected BaseProtocol mBaseProtocal;

    /**
     * 设置命令
     * @param command
     */
    protected void setCommandType(BaseCommand command) {
        mCommand = command;
    }

    protected void setProtocal(BaseProtocol baseProtocal) {
        mBaseProtocal = baseProtocal;
    }

    //生成命令
    protected abstract void creatCommand();

    //执行命令
    protected abstract void exec();

}
