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
package com.design.pattern.decorator;

import com.design.pattern.decorator.component.Beverage;
import com.design.pattern.decorator.component.CoffeeCapacity;

/**
 * 豆浆。
 *
 * @author	lihg
 * @version 2013-11-3
 */

public class Soy extends CondimentDecorator {

	protected Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

//	@Override
//	public double cost() {
//		return 0.15 + beverage.cost();
//	}


	// 新需求：希望调料根据咖啡容量收费

	@Override
	public CoffeeCapacity getSize() {
		return beverage.getSize();
	}

	@Override
	public double cost() {
		return costSoy(getSize()) + beverage.cost();
	}
	
	/*
	 * 根据咖啡容量收费
	 */
	private static double costSoy(CoffeeCapacity size) {
		switch (size) {
			case TALL :
				return 0.10;
			case GRANDE :
				return 0.15;
			case VENTI :
				return 0.20;
			default :
				return 0;
		}
	}

}
