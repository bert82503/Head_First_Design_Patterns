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

import static java.lang.System.out;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 剖析经典的单件模式实现。
 * 
 * <p><font color="red"><b>有一些问题！</b></font>
 *
 * @author	lihg
 * @version 2014-1-7
 */
public class Singleton_4 {

	// 1，静态变量
	private static Singleton_4 uniqueInstance;
	
	private Singleton_4() {
		// 2，私有构造器
	}
	
	/**
	 * 通过静态方法返回自身类的实例。
	 *
	 * @return
	 */
	public static Singleton_4 getInstance() {
		if (uniqueInstance == null) {
			/*
			 * 注意：如果我们不需要这个实例，它就永远不会产生。
			 * 这就是“延迟实例化”（Lazy Instantiate）。
			 */
			uniqueInstance = new Singleton_4(); // 在多线程下，可能会被实例化多次！
			
			// 暂停10ms，模拟这里需要一定的处理时间！
			try {
				Thread.sleep(TimeUnit.MILLISECONDS.toMillis(10L));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			out.println("Create Singleton: " + Long.valueOf(
					instanceCount.incrementAndGet()));
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
