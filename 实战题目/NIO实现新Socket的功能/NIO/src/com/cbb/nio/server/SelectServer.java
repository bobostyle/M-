package com.cbb.nio.server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * SelectServer.java
 * 2016年11月13日下午10:19:37
 * @author cbb
 * TODO NIO的服务端
 */
public class SelectServer {
	private static final String CHARSET = "UTF-8";
	private Selector selector;
	private ServerSocketChannel serverChannel;
	private ByteBuffer buffer;
	public SelectServer(){
		initalServer();
	}
	private void initalServer(){
		try{
			selector = Selector.open();
			serverChannel = ServerSocketChannel.open();
			serverChannel.configureBlocking(false);
			serverChannel.bind(new InetSocketAddress(8888));
		   //serverChannel.socket().bind(new InetSocketAddress(8888)); 
		    serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			buffer = ByteBuffer.allocate(1024);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void openServer() throws IOException{
		while(true){
			System.out.println("waitting next select operator ...");
			int keys = selector.select();
			if(keys > 0){
				Iterator<SelectionKey> itKeys = selector.selectedKeys().iterator();
				SelectionKey key = itKeys.next(); 
				while(itKeys.hasNext()){
					if(key.isAcceptable()){
						System.out.println("request form client, accept function is activaction!");
						ServerSocketChannel servrSocketChannel = (ServerSocketChannel)key.channel();  
						SocketChannel clientChannel = servrSocketChannel.accept();
						System.out.println("receive message from client:" + clientChannel.getRemoteAddress());
						channelBufferWrite(clientChannel, "Welcome!");
					}
					itKeys.remove();
				}
			}
		}
	}
	
	private void channelBufferWrite(SocketChannel socketChannel, String message) throws IOException{
		buffer.clear();
		buffer.put(message.getBytes(CHARSET));
		buffer.flip();
		socketChannel.write(buffer); 
	}
	
	public static void main(String[] args) throws IOException {
		SelectServer servrSelector = new SelectServer();
		servrSelector.openServer();
	}
}
