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
 * @create: 2019/7/25 12:32
 */
public class SingletonLazyDobuleCheck {
    /**
     * 双重检测，如果不适用volatile会出现指令重排的情况
     * 那么也就无法确保多线程安全情况
     * */
    private static volatile SingletonLazyDobuleCheck instance;

    private SingletonLazyDobuleCheck(){}

    public static SingletonLazyDobuleCheck getInstance() {
        if (instance == null) {
            synchronized (SingletonLazyDobuleCheck.class) {
                instance = new SingletonLazyDobuleCheck();
            }
        }
        return instance;
    }
}