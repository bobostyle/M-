package com.cbb.nio.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * SelectorClient.java
 * 2016年11月13日下午10:19:26
 * @author cbb
 * TODO NIO(非阻塞IO)，客户端
 */
public class SelectorClient {
	private static final String CHARSET = "UTF-8";
	private SocketChannel socketChannel;
    private InetSocketAddress serverAddress; 
    private Selector selector;  
    private ByteBuffer buffer = ByteBuffer.allocate(1024);  
    public SelectorClient(){
    	initalClientSocket();
    }
    public void initalClientSocket(){
    	try{
    		serverAddress = new InetSocketAddress(InetAddress.getByName("127.0.0.1"),8888);
    		socketChannel = SocketChannel.open(serverAddress);
    		socketChannel.configureBlocking(false);
    		selector = Selector.open();
    		socketChannel.register(selector, SelectionKey.OP_READ);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    
    public void connectServer() throws IOException{    
        while(true){  
            int keys = selector.select() ;  
            System.out.println("检测到动态...");  
            if(keys > 0){  
                Iterator<SelectionKey> itKeys = selector.selectedKeys().iterator() ;  
                while(itKeys.hasNext()){  
                    SelectionKey key = itKeys.next() ;  
                    if(key.isReadable()){  
                        channelBufferRead() ;  
                    }  
                    itKeys.remove();  
                }  
            }  
        }  
  
    }  
    //encode:编码--String类型编程字节流(byte[])
    //decode:解码--字节流转成String对象
    private void channelBufferRead() throws IOException{
    	buffer.clear();
    	socketChannel.read(buffer);
    	buffer.flip();
    	String valueFromServer = new String(buffer.array(), 0, buffer.limit(), CHARSET);
        System.out.println("receive message from service:" + valueFromServer);    
    }
    
    public static void main(String[] args) throws IOException {
    	SelectorClient client = new SelectorClient();
    	client.connectServer();
	}
}
