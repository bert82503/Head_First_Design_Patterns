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

import com.design.pattern.factory.bean.Cheese;
import com.design.pattern.factory.bean.Clam;
import com.design.pattern.factory.bean.Dough;
import com.design.pattern.factory.bean.Pepperoni;
import com.design.pattern.factory.bean.Sauce;
import com.design.pattern.factory.bean.Veggie;

import java.util.List;

/**
 * 建造原料工厂，负责创建原料家族中的每一种原料。
 *
 * @author	lihg
 * @version 2013-12-28
 */
public interface PizzaIngredientFactory {

	/**
	 * 生产面团。
	 *
	 * @return
	 */
	Dough createDough();
	
	/**
	 * 生产酱料。
	 *
	 * @return
	 */
	Sauce createSauce();
	
	/**
	 * 生产芝士。
	 *
	 * @return
	 */
	Cheese createCheese();
	
	/**
	 * 生产蔬菜。
	 *
	 * @return
	 */
	List<Veggie> createVeggies();
	
	/**
	 * 生产腊肠。
	 *
	 * @return
	 */
	Pepperoni createPepperoni();
	
	/**
	 * 生产蛤蛎。
	 *
	 * @return
	 */
	Clam createClam();

}
