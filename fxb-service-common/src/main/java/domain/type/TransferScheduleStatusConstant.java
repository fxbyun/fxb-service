package domain.type;
/**
 * 划转日志状态
 * 0：刚创建,未分解transfer_log
 * 1：分解transfer_log 中
 * 2：分解transfer_log完成
 * 3：刚创建但不用预先分解transfer_log
 * */
public class TransferScheduleStatusConstant {
    
    /**刚创建,未分解transfer_log*/
    public static int waiting = 0;
    
    /**分解transfer_log*/
    public static int decompose = 1;
    
    /**分解transfer_log完成*/
    public static int finished = 2;
    
    /**刚创建,但不用预先分解transfer_log*/
    public static int noDecompose = 3;
    
    /**逻辑删除*/
    public static int logicDelete = -93;
}
