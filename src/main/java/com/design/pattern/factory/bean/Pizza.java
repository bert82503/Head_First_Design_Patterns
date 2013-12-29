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

import java.util.List;

/**
 * 表示一个比萨。
 *
 * @author	lihg
 * @version 2013-12-27
 */
public abstract class Pizza {

	protected String name;	// 名称
	protected Dough dough;	// 面团类型
	protected Sauce sauce;	// 酱料类型
	
	protected List<Veggie> veggies;	// 一套佐料
	protected Cheese cheese;
	protected Pepperoni pepperoni;
	protected Clam clam;
	
	/**
	 * 收集比萨所需的原料，而这些原料当然是来自原料工厂了。
	 */
	public abstract void prepare();
	
	/**
	 * 烘烤比萨。
	 */
	public void bake() {
		out.println("Bake for 25 minutes at 350");
	}
	
	/**
	 * 切片比萨。
	 */
	public void cut() {
		// 将比萨切成菱形
		out.println("Cutting the Pizza into diagonal slices");
	}
	
	/**
	 * 装盒比萨。
	 */
	public void box() {
		out.println("Place Pizza in official PizzaStore box");
	}
	
	/**
	 * 返回比萨的名称。
	 *
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 设置比萨名。
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Pizza [")
		.append("name=").append(name)
		.append(']');
		return sb.toString();
	}

}
