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
package com.design.pattern.observer;

/**
 * 主题（出版者）接口。
 *
 * @author	lihg
 * @version 2013-10-31
 */

public interface Subject {

	/**
	 * 注册一个观察者。
	 *
	 * @param observer
	 */
	void registerObserver(Observer observer);
	
	/**
	 * 删除一个观察者。
	 *
	 * @param observer
	 */
	void removeObserver(Observer observer);
	
	/**
	 * 当 主题状态 改变时，这个方法会被调用，
	 * 以通知所有的观察者。
	 */
	void notifyObservers();

}
