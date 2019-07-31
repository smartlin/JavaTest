package cn.lxh.java.XStreamAlias;

import com.thoughtworks.xstream.XStream;

class RendezvousMessage1 {

   private int messageType;

   public RendezvousMessage1(int messageType) {
      this.messageType = messageType;
   }
}
public class XStreamTest3 {

   public static void main(String[] args) {
      XStream stream = new XStream();
      RendezvousMessage msg = new RendezvousMessage(15);
      System.out.println(stream.toXML(msg));
   }
}
