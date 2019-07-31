#### ReentrantLock
 ReentrantLock提供了tryLock方法，tryLock调用的时候，如果锁被其他线程持有，那么tryLock会立即返回，返回结果为false；如果锁没有被其他线程持有，那么当前调用线程会持有锁，并且tryLock返回的结果为true

#### ReentrantLock其他方法
1. int getHoldCount()：查询当前线程保持此锁定的个数，也就是调用lock()方法的次数。
2. int getQueueLength()：返回正等待获取此锁定的线程估计数。比如有5个线程，1个线程首先执行await()方法，那么在调用getQueueLength方法后返回值是4，说明有4个线程在等待lock的释放。
3. int getWaitQueueLength(Condition condition)：返回等待此锁定相关的给定条件Condition的线程估计数。比如有5个线程，每个线程都执行了同一个condition对象的await方法，则调用getWaitQueueLength(Condition condition)方法时返回的int值是5。
4. boolean hasQueuedThread(Thread thread)：查询指定线程是否正在等待获取此锁定。
5. boolean hasQueuedThreads()：查询是否有线程正在等待获取此锁定。
6. boolean hasWaiters(Condition condition)：查询是否有线程正在等待与此锁定有关的condition条件。
7. boolean isFair()：判断是不是公平锁。
8. boolean isHeldByCurrentThread()：查询当前线程是否保持此锁定。
9. boolean isLocked()：查询此锁定是否由任意线程保持。
10. void lockInterruptibly()：如果当前线程未被中断，则获取锁定，如果已经被中断则出现异常。