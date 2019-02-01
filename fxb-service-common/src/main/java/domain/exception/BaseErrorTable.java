package domain.exception;
import domain.util.ClassUtil;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交易错误代码表基础类
 * 
 */
public class BaseErrorTable extends Object {

    /**存储代码与代码对象关系*/
    private static Map<String, ErrorCode> map = new HashMap<String, ErrorCode>();

    /**
     * 根据代码取得代码对应消息
     * @param code
     * @return
     */

    public static String getMessage(String code) {
        synchronized (map) {
            if (map.isEmpty()) {

                List<Class<Object>> clazzList = ClassUtil.getAllClassByInterface(BaseErrorTable.class);

                for (Class<Object> clazz : clazzList) {
                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        try {
                            if (field.get(clazz) instanceof ErrorCode) {
                                ErrorCode errorCode = (ErrorCode) field.get(clazz);
                                map.put(errorCode.getCode(), errorCode);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
            ErrorCode errorCode = map.get(code);
            if (errorCode == null)
                return "";
            return errorCode.getMsg();
        }
    }
}
