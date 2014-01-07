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
package com.concurrency.thread;

import static org.testng.Assert.*;

import com.design.pattern.singleton.Singleton_4;

import org.testng.annotations.Test;

/**
 * Unit Test for {@link Singleton_4}.
 *
 * @author	lihg
 * @version 2014-1-7
 */
public class Singleton_4Test {

	@Test
	public void getInstance() throws InterruptedException {
		MockMultiThreads.run(4, new SingletonRunnable());
		
		// 验证实例超过1个
		assertTrue(Singleton_4.getInstance().getInstanceCount() > 1);
	}
	
	private static class SingletonRunnable implements Runnable {

		@Override
		public void run() {
			Singleton_4.getInstance();
		}
		
	}

}
