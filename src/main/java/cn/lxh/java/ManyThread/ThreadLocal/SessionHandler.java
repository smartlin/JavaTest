package cn.lxh.java.ManyThread.ThreadLocal;

import lombok.Data;

/**
 * δʹ��ThreadLocal
 */
public class SessionHandler {
  @Data
  public static class Session {
    private String id;
    private String user;
    private String status;
  }
  public Session createSession() {
    return new Session();
  }
  public String getUser(Session session) {
    return session.getUser();
  }
  public String getStatus(Session session) {
    return session.getStatus();
  }
  public void setStatus(Session session, String status) {
    session.setStatus(status);
  }

  public static void main(String[] args) {
    new Thread(() -> {
      SessionHandler handler = new SessionHandler();
      Session session = handler.createSession();
      handler.getStatus(session);
      handler.getUser(session);
      handler.setStatus(session, "close");
      handler.getStatus(session);
    }).start();
  }
}