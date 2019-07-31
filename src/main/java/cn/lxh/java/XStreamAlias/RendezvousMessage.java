package cn.lxh.java.XStreamAlias;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.Arrays;
import java.util.List;

//对类的别名性注解
@XStreamAlias("message")
class RendezvousMessage {

   public static void main(String[] args) {
      XStream stream = new XStream();
      //通知XStream对象读取并识别RendezvousMessage中的注解
      stream.processAnnotations(RendezvousMessage.class);
      RendezvousMessage msg = new RendezvousMessage(15,"first","second");
      System.out.println(stream.toXML(msg));
   }

   //对字段的别名性注解
   @XStreamAlias("type")
   private int messageType;

   @XStreamImplicit(itemFieldName = "part")
   private List<String> content;

   public RendezvousMessage(int messageType,String ...content) {
      this.messageType = messageType;
      this.content = Arrays.asList(content);
   }
}

