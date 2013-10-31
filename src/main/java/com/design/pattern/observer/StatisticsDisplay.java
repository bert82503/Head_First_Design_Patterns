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
 * 统计布告板。
 *
 * @author	lihg
 * @version 2013-10-31
 */

public class StatisticsDisplay implements Observer, DisplayElement {

	private float sum = 0.0f;
	private int num = 0;
	private float max = Float.MIN_VALUE;
	private float min = Float.MAX_VALUE;
	
	private Subject weatherData;
	
	public StatisticsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		
		// 使用主题对象将自己注册为一个观察者
		this.weatherData.registerObserver(this);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		// Average
		sum += temperature;
		num += 1;
		
		if (temperature > max) {
			max = temperature;
		}
		if (temperature < min) {
			min = temperature;
		}
		
		this.display();
	}

	@Override
	public void display() {
		float avg = sum / num;
		out.println("Avg/Max/Min temperature = " + avg + '/' + max + '/' + min);
	}

}
