package cn.weibin.springboot.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 集合工具类
 * @author weibin
 */
public abstract class CollectionUtils {

    /**
     * 集合是否为空
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * 集合是否非空
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 连接集合成字符串
     * @param stringList
     * @param separator
     * @return
     */
    public static String join(Collection<?> stringList, String separator) {
        StringBuilder sb = new StringBuilder();
        if(stringList != null) {
            boolean firstSetp = true;
            for(Object str : stringList) {
                if(firstSetp) {
                    sb.append(str);
                    firstSetp = false;
                } else {
                    sb.append(separator).append(str);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 将一个集合分隔成几个小集合
     * @param list - 集合数据
     * @param maxSize - 小集合的最多装载数
     * @param clazz - 类型
     * @return
     */
    public static <T> List<List<T>> split(List<T> list, int maxSize, Class<T> clazz){
        int total = list.size();
        List<List<T>> bigList = new ArrayList<>();
        if(total <= maxSize) {
            bigList.add(list);
        } else {
            int splitCount = total / maxSize;
            if(total % maxSize > 0) {
                splitCount++;
            }
            for(int i = 0; i < splitCount; i++) {
                int fromIndex = maxSize * i;
                int toIndex = fromIndex + maxSize;
                if(toIndex > total) {
                    toIndex = total;
                }
                bigList.add(list.subList(fromIndex, toIndex));
            }
        }
        return bigList;
    }

    /**
     * 去除重复元素
     * @param <T>
     * @param list
     * @return
     */
    public static <T> void removeDuplicates(List<T> list) {
        Set<T> sets = new HashSet<>(list.size());
        Iterator<T> iterator = list.iterator();
        T item = null;
        while(iterator.hasNext()) {
            item = iterator.next();
            if(sets.contains(item)) {
                iterator.remove();
            } else {
                sets.add(item);
            }
        }
    }
}
