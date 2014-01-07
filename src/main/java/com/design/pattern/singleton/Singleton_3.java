/**
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.design.pattern.singleton;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 基于“同步方法”实现。
 * 
 * <p>迫使每个线程在进入这个方法之前，要先等候别的线程离开该方法。
 * 也就是说，不会有两个线程可以同时进入这个方法。
 * 
 * <p><font color="red"><b>必须知道：同步一个方法可能造成程序执行效率下降100倍！</b></font>
 *
 * @author	lihg
 * @version 2014-1-7
 */
public class Singleton_3 {

	// 1，静态变量
	private static Singleton_3 uniqueInstance;
	
	private Singleton_3() {
		// 2，私有构造器
	}
	
	/**
	 * 返回自身类的单个实例。
	 *
	 * @return
	 */
	public static synchronized Singleton_3 getInstance() {
		if (uniqueInstance == null) {
			/*
			 * 注意：如果我们不需要这个实例，它就永远不会产生。
			 * 这就是“延迟实例化”（Lazy Instantiate）。
			 */
			uniqueInstance = new Singleton_3(); // 在多线程下，可能会被实例化多次！
			instanceCount.incrementAndGet(); // 实例计数
			
			// 暂停50ms，模拟这里需要一定的处理时间！
			try {
				Thread.sleep(TimeUnit.MILLISECONDS.toMillis(50L));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return uniqueInstance;
	}
	
	/**
	 * 返回单件模式的实例化个数。
	 *
	 * @return
	 */
	public long getInstanceCount() {
		return instanceCount.get();
	}
	
	// Unit Test
	private static AtomicLong instanceCount = new AtomicLong(0L);

}
