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

import com.design.pattern.factory.PizzaIngredientFactory;

/**
 * 蛤蛎比萨。
 *
 * @author	lihg
 * @version 2013-12-28
 */
public class ClamPizza extends Pizza {

	private PizzaIngredientFactory ingredientFactory;
	
	public ClamPizza(PizzaIngredientFactory ingredientFactory) {
		if (ingredientFactory == null) {
			throw new IllegalArgumentException("ingredientFactory is null");
		}
		this.ingredientFactory = ingredientFactory;
	}
	
	@Override
	public void prepare() {
		/*
		 * 神奇的事情发生在这里！
		 */
		out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		// 如果是纽约工厂，就会使用新鲜的蛤蛎；如果是芝加哥工厂，就是冷冻的蛤蛎。
		clam = ingredientFactory.createClam();
	}

}
