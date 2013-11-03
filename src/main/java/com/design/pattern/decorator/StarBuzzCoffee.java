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

import static java.lang.System.out;

import com.design.pattern.decorator.component.Beverage;
import com.design.pattern.decorator.component.DarkRoast;
import com.design.pattern.decorator.component.Espresso;
import com.design.pattern.decorator.component.HouseBlend;

/**
 * 星巴兹咖啡。
 *
 * @author	lihg
 * @version 2013-11-3
 */

public class StarBuzzCoffee {

	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		out.println(beverage.getDescription() + 
				" $" + beverage.cost());
		
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		out.println(beverage2.getDescription() + 
				" $" + beverage2.cost());
		
		Beverage beverage3 = new HouseBlend();
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		out.println(beverage3.getDescription() + 
				" $" + beverage3.cost());
	}

}
