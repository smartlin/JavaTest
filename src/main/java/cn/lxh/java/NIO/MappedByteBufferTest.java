package cn.lxh.java.NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 采用ByteBuffer和MappedByteBuffer分别读取文件
 * Created by starlin
 * on 2017/03/23 15:59.
 */
public class MappedByteBufferTest {
    //利用MappedByteBuffer读物文件
    public static void BufferByte(){
        RandomAccessFile accessFile = null;
        FileChannel fileChannel = null;
        try{
            accessFile = new RandomAccessFile("d:/apache-tomcat-6.0.44-windows-i64.zip","rw");
            fileChannel = accessFile.getChannel();

            long timestart = System.currentTimeMillis();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) accessFile.length());
            byteBuffer.clear();
            fileChannel.read(byteBuffer);
            long timeend = System.currentTimeMillis();
            System.out.println("Read time: "+(timeend-timestart)+"ms");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(accessFile != null){
                    accessFile.close();
                }
                if(fileChannel != null){
                    fileChannel.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //利用ByteBuffer读取文件
    public static void MappedByteBuffer(){
        RandomAccessFile accessFile = null;
        FileChannel fileChannel = null;
        try{
            accessFile = new RandomAccessFile("d:/apache-tomcat-6.0.44-windows-i64.zip","rw");
            fileChannel = accessFile.getChannel();

            long timeStart = System.currentTimeMillis();
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,0,accessFile.length());
            long timeEnd = System.currentTimeMillis();
            System.out.println("Read time: "+(timeEnd-timeStart)+"ms");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(accessFile != null){
                    accessFile.close();
                }
                if(fileChannel != null){
                    fileChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MappedByteBufferTest.BufferByte();
        MappedByteBufferTest.MappedByteBuffer();
    }
}
