#### ReentrantLock
 ReentrantLock�ṩ��tryLock������tryLock���õ�ʱ��������������̳߳��У���ôtryLock���������أ����ؽ��Ϊfalse�������û�б������̳߳��У���ô��ǰ�����̻߳������������tryLock���صĽ��Ϊtrue

#### ReentrantLock��������
1. int getHoldCount()����ѯ��ǰ�̱߳��ִ������ĸ�����Ҳ���ǵ���lock()�����Ĵ�����
2. int getQueueLength()���������ȴ���ȡ���������̹߳�������������5���̣߳�1���߳�����ִ��await()��������ô�ڵ���getQueueLength�����󷵻�ֵ��4��˵����4���߳��ڵȴ�lock���ͷš�
3. int getWaitQueueLength(Condition condition)�����صȴ���������صĸ�������Condition���̹߳�������������5���̣߳�ÿ���̶߳�ִ����ͬһ��condition�����await�����������getWaitQueueLength(Condition condition)����ʱ���ص�intֵ��5��
4. boolean hasQueuedThread(Thread thread)����ѯָ���߳��Ƿ����ڵȴ���ȡ��������
5. boolean hasQueuedThreads()����ѯ�Ƿ����߳����ڵȴ���ȡ��������
6. boolean hasWaiters(Condition condition)����ѯ�Ƿ����߳����ڵȴ���������йص�condition������
7. boolean isFair()���ж��ǲ��ǹ�ƽ����
8. boolean isHeldByCurrentThread()����ѯ��ǰ�߳��Ƿ񱣳ִ�������
9. boolean isLocked()����ѯ�������Ƿ��������̱߳��֡�
10. void lockInterruptibly()�������ǰ�߳�δ���жϣ����ȡ����������Ѿ����ж�������쳣��