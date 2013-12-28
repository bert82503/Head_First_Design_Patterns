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
package com.design.pattern.factory;

import com.design.pattern.factory.bean.ChicagoStyleCheesePizza;
import com.design.pattern.factory.bean.NYStyleCheesePizza;
import com.design.pattern.factory.bean.Pizza;

/**
 * 简单比萨工厂。
 * 
 * <p>问题：
 * 压力来自于增加更多的比萨类型（变化的部分）
 * 
 * <p>工厂（factory）：处理创建对象的细节。<br>
 * 模式荣誉奖
 *
 * @author	lihg
 * @version 2013-12-27
 */
public class SimplePizzaFactory {

	/**
	 * 究竟实例化哪个类，要在运行时由一些条件来决定。
	 *
	 * @param type
	 * @return
	 */
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		
		// 用 枚举类型 替换
		if ("NY".equals(type)) {
			pizza = new NYStyleCheesePizza();
		} else if ("Chicago".equals(type)) {
			pizza = new ChicagoStyleCheesePizza();
		}
		
		return pizza;
	}
}
