package domain.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

@SuppressWarnings("unchecked")
public class ClassUtil {

    // 给一个接口，返回这个接口的所有实现类

    public static List<Class<Object>> getAllClassByInterface(@SuppressWarnings("rawtypes") Class c) {
        List<Class<Object>> returnClassList = new ArrayList<Class<Object>>();

        String packageName = c.getPackage().getName(); // 获得当前的包名
        try {
            List<Class<Object>> allClass = getClasses(packageName); // 获得当前包下以及子包下的所有类
            // 判断是否是同一个接口
            for (int i = 0; i < allClass.size(); i++) {
                if (c.isAssignableFrom(allClass.get(i))) { // 判断是不是一个接口
                    if (!c.equals(allClass.get(i))) { // 本身不加进去
                        returnClassList.add(allClass.get(i));
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnClassList;
    }

    // 从一个包中查找出所有的类，在jar包中不能查找
    private static List<Class<Object>> getClasses(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class<Object>> classes = new ArrayList<Class<Object>>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    private static List<Class<Object>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class<Object>> classes = new ArrayList<Class<Object>>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add((Class<Object>) Class.forName(packageName + '.'
                        + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
    
    public static Map<String, Object> object2Map(Object obj) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass());
		} catch (IntrospectionException e1) {
			return returnMap;
		}

		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			try {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(obj, new Object[0]);
					if (result != null) {
						returnMap.put(propertyName, result);
					}
				}
			} catch (NullPointerException e) {
				continue;
			} catch (Exception e) {
				break;
			}
		}
		return returnMap;
	}

}
