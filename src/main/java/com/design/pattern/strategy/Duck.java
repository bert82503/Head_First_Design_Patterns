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
package com.design.pattern.strategy;

import static java.lang.System.out;

import com.design.pattern.strategy.action.FlyBehavior;
import com.design.pattern.strategy.action.QuackBehavior;

/**
 * 鸭子超类。
 *
 * @author	lihg
 * @version 2013-10-30
 */

public abstract class Duck {

	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;

	public Duck() {
	}

	/**
	 * 展示鸭子的外观。
	 * 
	 * <p>
	 * 为什么定义成抽象的？ 
	 *    因为每一种鸭子的外观都不同。
	 */
	public abstract void display();


	// 委托给行为类

	/**
	 * 展示鸭子的飞行动作。
	 */
	public void performFly() {
		flyBehavior.fly();
	}

	/**
	 * 展示鸭子的叫声。
	 */
	public void performQuack() {
		quackBehavior.quack();
	}


	/**
	 * 鸭子开始游泳。
	 */
	public void swim() {
		out.println("All ducks float, even decoys!");
	}


	// 动态设定行为

	/**
	 * 动态地改变鸭子的飞行行为。
	 *
	 * @param flyBehavior 飞行行为
	 */
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	/**
	 * 动态地改变鸭子的叫声。
	 *
	 * @param quackBehavior 叫声
	 */
	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

}
