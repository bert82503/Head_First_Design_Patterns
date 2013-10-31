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
 * 观察者（订阅者）接口。
 *
 * @author	lihg
 * @version 2013-10-31
 */

public interface Observer {

	/**
	 * 当气象观测值改变时，主题会把这些状态值当作方法的参数，
	 * 传送给观察者。
	 * <p>
	 *
	 * @param temperature	最新天气温度
	 * @param humidity		最新天气湿度
	 * @param pressure		最新天气气压
	 */
	void update(float temperature, float humidity, float pressure);

}
