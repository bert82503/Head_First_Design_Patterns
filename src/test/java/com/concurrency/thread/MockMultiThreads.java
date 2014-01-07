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

import java.util.concurrent.CountDownLatch;

/**
 * 模拟并发的多线程环境。
 *
 * @author	lihg
 * @version 2013-12-1
 */
public class MockMultiThreads {

	/**
	 * 模拟真实的并发运行环境。
	 *
	 * @param nThreads
	 * @param task
	 * @throws InterruptedException
	 */
	public static void run(int nThreads, final Runnable task) 
			throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1); // 起始门
		final CountDownLatch endGate = new CountDownLatch(nThreads); // 结束门
		
		for (int i = 0; i < nThreads; i++) {
			Thread t = new Thread() {
				@Override
				public void run() {
					try {
						startGate.await(); // 在启动门上等待
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException ignored) {
						// ignore
					}
				}
			};
			t.start();
		}
		
		startGate.countDown(); // 确保所有线程都就绪后才开始执行
		endGate.await(); // 主线程高效地等待直到所有工作线程都执行完成
	}

}
