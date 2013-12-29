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
import com.design.pattern.factory.bean.FreshClam;
import com.design.pattern.factory.bean.Garlic;
import com.design.pattern.factory.bean.MarinaraSauce;
import com.design.pattern.factory.bean.Mushroom;
import com.design.pattern.factory.bean.Onion;
import com.design.pattern.factory.bean.Pepperoni;
import com.design.pattern.factory.bean.ReggianoCheese;
import com.design.pattern.factory.bean.Sauce;
import com.design.pattern.factory.bean.SlicedPepperoni;
import com.design.pattern.factory.bean.ThinCrustDough;
import com.design.pattern.factory.bean.Veggie;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建纽约原料工厂。
 *
 * @author	lihg
 * @version 2013-12-28
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public List<Veggie> createVeggies() {
		List<Veggie> veggies = new ArrayList<>(3);
		veggies.add(new Garlic());
		veggies.add(new Onion());
		veggies.add(new Mushroom());
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clam createClam() {
		return new FreshClam();
	}

}
