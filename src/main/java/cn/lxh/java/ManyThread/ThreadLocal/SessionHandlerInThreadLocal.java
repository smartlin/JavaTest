package cn.lxh.java.ManyThread.ThreadLocal;

import lombok.Data;

/**
 * Created by starlin
 * on 2018/7/18 18:03.
 *  π”√ThreadLocal
 */
public class SessionHandlerInThreadLocal {
    public static ThreadLocal<Session> session = new ThreadLocal<Session>();
    @Data
    public static class Session {
        private String id;
        private String user;
        private String status;
    }
    public void createSession() {
        session.set(new Session());
    }
    public String getUser() {
        return session.get().getUser();
    }
    public String getStatus() {
        return session.get().getStatus();
    }
    public void setStatus(String status) {
        session.get().setStatus(status);
    }

    public static void main(String[] args) {
        new Thread(() -> {
            SessionHandlerInThreadLocal handler = new SessionHandlerInThreadLocal();
            handler.getStatus();
            handler.getUser();
            handler.setStatus("close");
            handler.getStatus();
        }).start();
    }
}
