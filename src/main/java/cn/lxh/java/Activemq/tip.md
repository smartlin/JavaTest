### mq��Ҫ����
1. ���JMS connection factory. ͨ�������ṩ�ض�������������Ϣ������factory��
2. ����factory����JMS connection
3. ����connection
4. ͨ��connection����JMS session.
5. ָ��JMS destination.
6. ����JMS producer���ߴ���JMS message���ṩdestination.
7. ����JMS consumer��ע��JMS message listener.
8. ���ͺͽ���JMS message.
9. �ر�����JMS��Դ������connection, session, producer, consumer�ȡ�


����Sessionʱ�������ǳ���Ҫ�Ĳ�������һ��boolean���͵Ĳ���������ʾ�Ƿ����������Ϣ��
�����������Ϣ�����ڵĲ�������Ϊtrue����ʱ��Ϣ���ύ�Զ���comit������Ϣ�Ļع����Զ���rollback����
������Ϣ��������ģ����Ӧ�ĸò�������Ϊfalse����ʱ��Ϊ���������
1. Session.AUTO_ACKNOWLEDGE��ʾSession���Զ�ȷ�������յ�����Ϣ��
2. Session.CLIENT_ACKNOWLEDGE��ʾ�ɿͻ��˳���ͨ��������Ϣ��ȷ�Ϸ�����ȷ�������յ�����Ϣ��
3. Session.DUPS_OK_ACKNOWLEDGEʹ��Session�������衱��ȷ����Ϣ������������ȷ����Ϣ�������п��ܵ�����Ϣ�ظ�Ͷ��