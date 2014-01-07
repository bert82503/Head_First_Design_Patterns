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

/**
 * 使用“双重检查加锁”实现，在 {@code getInstance()} 中减少使用同步。
 * 
 * <p>首先检查是否实例已经创建了，如果尚未创建，“才”进行同步。
 * 这样一来，只有第一次会同步，这正是我们想要的。
 * 
 * <p>如果<font color="red"><b>性能是你关心的重点</b></font>，
 * 那么这个做法可以帮你大大地减少 {@code getInstance()} 的时间耗费。
 *
 * @author	lihg
 * @version 2014-1-7
 */
public class Singleton_1 {

	// 1，静态变量
	private volatile static Singleton_1 uniqueInstance;
	
	private Singleton_1() {
		// 2，私有构造器
	}
	
	/**
	 * 返回自身类的单个实例。
	 *
	 * @return
	 */
	public static Singleton_1 getInstance() {
		if (uniqueInstance == null) { // check 1
			// 注意，只有第一次才彻底执行这里的代码！
			synchronized (Singleton_1.class) { // lock
				// 进入区块后，再检查一次。如果仍是null，才创建实例。
				if (uniqueInstance == null) { // check 2
					uniqueInstance = new Singleton_1();
				}
			}
		}
		
		return uniqueInstance;
	}

}
