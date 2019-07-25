/*
 * Copyright 2001-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package singleton;

/**
 * <p> Title: </p>
 *
 * <p> Description: </p>
 *
 * @author: Guo.Weifeng
 * @version: 1.0
 * @create: 2019/7/25 12:35
 * 静态内部类，也能起到延迟加载的功能
 */
public class SingletonInnerClass {
    /**
     * 私有的静态内部类，该静态内部类只会在newInstance()方法中被使用
     *
     * 第一次访问类的静态字段时，会触发类加载，并且同一个类只加载一次，静态内部类也一样。
     * 类加载过程中由类加载器负责加锁，从而保证线程安全
     * */
    private static class SingletonHolder{
        /**静态字段*/
        public static SingletonInnerClass instance = new SingletonInnerClass();
    }

    private SingletonInnerClass(){}

    public static SingletonInnerClass newInstance(){
        // 访问静态内部类中的静态字段
        return SingletonHolder.instance;
    }
}