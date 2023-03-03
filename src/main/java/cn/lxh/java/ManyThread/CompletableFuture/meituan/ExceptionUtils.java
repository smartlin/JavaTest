package cn.lxh.java.ManyThread.CompletableFuture.meituan;

import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

public class ExceptionUtils {
   /**
    * ��ȡ�������쳣
    */
   public static Throwable extractRealException(Throwable throwable) {
       if (throwable instanceof CompletionException || throwable instanceof ExecutionException) {
           if (throwable.getCause() != null) {
               return throwable.getCause();
           }
       }
       return throwable;
   }
  }