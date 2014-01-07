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
 * 使用“急切”创建实例。
 * 
 * <p>在静态初始化器中创建单件，这保证了线程安全（Thread Safe）。
 * 
 * <p>利用这个做法，依赖于JVM在加载这个类时马上创建此唯一的单件实例。
 * JVM保证在任何线程访问 {@code uniqueInstance} 静态变量之前，一定先创建此实例。
 *
 * @author	lihg
 * @version 2014-1-7
 */
public class Singleton {

	// 1，静态变量
	private static final Singleton uniqueInstance;
	static {
		uniqueInstance = new Singleton();
	}
	
	private Singleton() {
		// 2，私有构造器
	}
	
	/**
	 * 返回自身类的单个实例。
	 *
	 * @return
	 */
	public static Singleton getInstance() {
		// 已经有实例了，直接使用它。
		return uniqueInstance;
	}

}
