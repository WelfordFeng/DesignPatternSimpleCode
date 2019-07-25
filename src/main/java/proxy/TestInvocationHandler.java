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
package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p> Title: </p>
 *
 * <p> Description: </p>
 *
 * @author: Guo.Weifeng
 * @version: 1.0
 * @create: 2019/7/25 12:55
 */
public class TestInvocationHandler implements InvocationHandler {

    /** 代理对 */
    private Object target;

    /**构造函数带入*/
    public TestInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 这里可以加入执行前的逻辑
        System.out.println("执行方法之前：" + method.getName());

        Object result = method.invoke(target, args);

        // 加入执行后的逻辑
        System.out.println("执行方法之后：" + method.getName());

        return result;
    }

    public Object getProxy(){
        // 创建代理
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        TestInvocationHandler handler = new TestInvocationHandler(subject);
        Subject proxy = (Subject) handler.getProxy();

        // 调用方法
        proxy.operation();
    }
}