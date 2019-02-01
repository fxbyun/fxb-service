package domain.type;

/**
 * 划转日志状态
 * @project coreservice-common
 * @author zhizhao
 * @date 2014年11月13日下午5:18:58
 */
public class TransferStatus {

	  /**0:刚创建,未开始*/
    public static int waiting = 0;
    
    /**1:转帐进行中*/
    public static int processing = 1;
    
//    /**2:已接到DataChange继续往下*/
//    public static int receiveMsg = 2;
    
    /**3:转账完成*/
    public static int finished = 3;
    
    /**4:转账遇错停止,需要故障恢复线程*/
    public static int stopped = 4;
    
    /**5:失败-说明这一笔金额资金转账作废*/
    public static int failed = 5;
     
    /**-93:逻辑删除*/
    public static int logicDelete = -93;
}
