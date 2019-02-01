package domain.service;

import java.util.List;
import java.util.Map;

public interface GenericDao {
    long generateSequence(String var1);

    <T> int insertAndReturnAffectedCount(String var1, T var2);

    <T> int insertAndSetupId(String var1, T var2);

    <T> int insertWithMultiValues(String var1, List<T> var2, int var3);

    int update(String var1, Map<String, Object> var2);

    int updateByObj(String var1, Object var2);

    <T> T queryUnique(String var1, long var2);

    <T> T queryUnique(String var1, String var2);

    <T> T queryUnique(String var1, Map<String, Object> var2);

    /** @deprecated */
    @Deprecated
    <T> T queryOne(String var1, long var2);

    /** @deprecated */
    @Deprecated
    <T> T queryOne(String var1, String var2);

    <T> T queryOne(String var1, String var2, int var3);

    /** @deprecated */
    @Deprecated
    <T> T queryOne(String var1, Map<String, Object> var2);

    <T> T queryOne(String var1, Map<String, Object> var2, int var3);

    Object queryObject(String var1, Map<String, Object> var2);

    /** @deprecated */
    @Deprecated
    <T> T queryOneWithPessimisticLock(String var1, long var2);

    <T> T queryOneByObject(String var1, String var2, Object var3);

    int queryCount(String var1, Map<String, Object> var2);

    int queryInt(String var1, Map<String, Object> var2);

    <T> List<T> queryList(String var1, Map<String, Object> var2);

    <T> List<T> queryList(String var1, Map<String, Object> var2, int var3);

    /** @deprecated */
    @Deprecated
    <T> List<T> queryListByMap(String var1, Map<String, Object> var2);

    <T> List<T> queryList(String var1);

    <T> List<T> queryIdIn(String var1, long[] var2);

    <T> List<T> queryIdIn(String var1, String[] var2);

    <K, V> Map<K, V> selectOneToMap(String var1, Map<K, V> var2);

}
