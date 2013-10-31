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

import static java.lang.System.out;

/**
 * 酷热指数布告板。（后期增加的）
 *
 * @author	lihg
 * @version 2013-10-31
 */

public class HeatIndexDisplay implements Observer, DisplayElement {

	private double heatIndex;
	
	private Subject weatherData;
	
	public HeatIndexDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		
		// 使用主题对象将自己注册为一个观察者
		this.weatherData.registerObserver(this);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		// 计算公式有些复杂，省略之
//		heatIndex = 16.923 + ...
	}

	@Override
	public void display() {
		out.println("Heat index is" + heatIndex);
	}

}
