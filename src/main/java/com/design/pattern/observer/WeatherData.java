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

import java.util.ArrayList;
import java.util.List;

/**
 * 气象数据。
 *
 * @author	lihg
 * @version 2013-10-31
 */

public class WeatherData implements Subject {

	// 记录观察者（实际项目中使用 ConcurrentMap 与 ConcurrentHashMap）
	private List<Observer> observers;

	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	
	
	@Override
	public void registerObserver(Observer observer) {
		if (observer != null) { // 保证不会存在 null 元素
			observers.add(observer);
		}
	}

	@Override
	public void removeObserver(Observer observer) {
		if (observer != null) {
			observers.remove(observer);
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			// 具体使用什么方式传送数据？ 推(push) 还是 拉(pull) 模式，关键看这里是怎么实现的。
			// 现在采用的做法是 “推”
			o.update(temperature, humidity, pressure);
		}
	}
	
	/**
	 * 当从气象站得到更新观测值时，我们通知观察者。
	 */
	public void measurementsChanged() {
		notifyObservers();
	}
	
	/**
	 * 更新气象观测数据。
	 *
	 * @param temperature
	 * @param humidity
	 * @param pressure
	 */
	public void setMeasurements(float temperature, float humidity,
			float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;

		measurementsChanged();
	}
	
	
	/**
	 * 返回最新的天气温度。
	 *
	 * @return 最新天气温度
	 */
	public float getTemperature() {
		return temperature;
	}
	
	/**
	 * 返回最新的天气湿度。
	 *
	 * @return 最新天气湿度
	 */
	public float getHumidity() {
		return humidity;
	}
	
	/**
	 * 返回最新的天气气压。
	 *
	 * @return 最新天气气压
	 */
	public float getPressure() {
		return pressure;
	}

}
