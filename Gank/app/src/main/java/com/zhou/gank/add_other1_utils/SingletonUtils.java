package com.zhou.gank.add_other1_utils;

/**
 * Singleton helper class for lazily initialization.
 * 
 * @author <a href="http://www.trinea.cn/" target="_blank">Trinea</a>
 * 
 * @param <T>    泛型
 */
public abstract class SingletonUtils<T> {

    private T instance;

    protected abstract T newInstance();

    public final T getInstance() {
        if (instance == null) {
            synchronized (SingletonUtils.class) {
                if (instance == null) {
                    instance = newInstance();
                }
            }
        }
        return instance;
    }
}
