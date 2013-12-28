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

import com.design.pattern.factory.bean.Pizza;

/**
 * 比萨店抽象类。
 * 
 * <p>新问题：
 * 但是区域的差异呢？每家加盟店都可能想要提供不同风味的比萨，
 * 这受到了开店地点及该地区比萨美食家口味的影响。
 * 
 * <p>目标：
 * 把加盟店和创建比萨捆绑在一起的同时，又保持一定的弹性。
 * 
 * <p><b>知识普及</b><br>
 * <pre>
 * 工厂方法模式（Factory Method Pattern）通过让子类决定该创建的对象是什么，
 * 来达到将对象创建的过程封装的目的。
 * 
 * 创建者（Creator）类
 *     定义了一个抽象的工厂方法，让子类实现此方法制造产品。
 * 产品类
 *     工厂生产产品
 * </pre>
 *
 * @author	lihg
 * @version 2013-12-28
 */
public abstract class PizzaStore {

//	private SimplePizzaFactory factory;

//	public PizzaStore(SimplePizzaFactory factory) {
//		if (factory == null) {
//			throw new IllegalArgumentException("factory is null");
//		}
//		
//		this.factory = factory;
//	}
	
	public final Pizza orderPizza(String type) {
//		// 使用工厂创建比萨
//		Pizza pizza = factory.createPizza(type);
		
		Pizza pizza = createPizza(type); // 使用“工厂方法”解耦
		if (pizza == null) {
			throw new IllegalArgumentException("Invalid Pizza type: " + type);
		}
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
	
	/**
	 * 把工厂对象移到这个方法中。（“工厂方法” 现在是抽象的）
	 * 
	 * <p>为每个区域风味创建一个PizzaStore的子类。
	 * 
	 * <p>工厂方法
	 * 用来处理对象的创建，并将这样的行为封装在子类中。
	 * 这样，客户程序中关于超类的代码就和子类对象创建代码解耦了。(p125)
	 *
	 * @param type
	 * @return
	 */
	protected abstract Pizza createPizza(String type);

//	/**
//	 * [对象组合] 在运行时动态地改变工厂的行为。
//	 *
//	 * @param factory
//	 */
//	public void setFactory(SimplePizzaFactory factory) {
//		this.factory = factory;
//	}

}
