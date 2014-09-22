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
 * “双重检查加锁”是指对单件实例进行双重null检查，对类型加锁。
 * 
 * <p>首先检查实例是否已经创建了，如果尚未创建，“才”进行类型同步。
 * 这样一来，只有第一次会同步，这正是我们想要的。
 * 
 * <p>如果<font color="red"><b>性能是你关心的重点</b></font>，
 * 那么这个做法可以帮你大大地减少 {@link #getInstance()} 的时间耗费。
 *
 * @author	lihg
 * @version 2014-1-7
 */
public class Singleton_1 {

	/**
	 * 1，使用{@code volatile}静态变量<p>
	 * 
	 * 被声明为volatile的所有变量的<b>读取</b>和<b>写入</b>是<font color="red"><b>原子的</b></font>。
	 * 原子操作不可能交错，所以使用它们时不必担心线程干扰的问题。<br>
	 * 
	 * 使用volatile变量减少了<font color="red">内存一致性错误</font>的风险，
	 * 因为volatile变量的<b>任何写入操作</b>都会和对同一个变量的<b>后续读取</b>建立</b>发生前关系</b>。
	 */
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
