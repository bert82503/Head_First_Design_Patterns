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
package com.design.pattern.factory.bean;

import static java.lang.System.out;

/**
 * 芝加哥比萨，使用小番茄作为酱料，并使用厚饼。
 *
 * @author	lihg
 * @version 2013-12-27
 */
public class ChicagoStyleCheesePizza extends Pizza {

	public ChicagoStyleCheesePizza() {
		name = "Chicago Style Deep Dish Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		
		// 芝加哥风味的深盘比萨使用许多Mozzarella（意大利白干酪）！
		toppings.add("Shredded Mozzarella Cheese");
	}
	
	@Override
	public void cut() {
		// 将比萨切成正方形
		out.println("Cutting the Pizza into square slices");
	}

}
