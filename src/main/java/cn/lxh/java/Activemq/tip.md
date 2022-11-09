### mq主要步骤
1. 获得JMS connection factory. 通过我们提供特定环境的连接信息来构造factory。
2. 利用factory构造JMS connection
3. 启动connection
4. 通过connection创建JMS session.
5. 指定JMS destination.
6. 创建JMS producer或者创建JMS message并提供destination.
7. 创建JMS consumer或注册JMS message listener.
8. 发送和接收JMS message.
9. 关闭所有JMS资源，包括connection, session, producer, consumer等。


创建Session时有两个非常重要的参数，第一个boolean类型的参数用来表示是否采用事务消息。
如果是事务消息，对于的参数设置为true，此时消息的提交自动有comit处理，消息的回滚则自动由rollback处理。
加入消息不是事务的，则对应的该参数设置为false，此时分为三种情况：
1. Session.AUTO_ACKNOWLEDGE表示Session会自动确认所接收到的消息。
2. Session.CLIENT_ACKNOWLEDGE表示由客户端程序通过调用消息的确认方法来确认所接收到的消息。
3. Session.DUPS_OK_ACKNOWLEDGE使得Session将“懒惰”地确认消息，即不会立即确认消息，这样有可能导致消息重复投递