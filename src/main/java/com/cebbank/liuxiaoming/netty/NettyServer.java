package com.cebbank.liuxiaoming.netty;

import com.cebbank.liuxiaoming.netty.handler.NettyServerHander;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void main(String[] args) throws Exception{
        //1.创建一个线程组，接收客户端连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //2.创建一个线程组，处理IO
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //3.创建服务器端启动助手，配置参数
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup)//4.设置两个线程组
                .channel(NioServerSocketChannel.class)//5.使用NioServerSocketChannel作为通道实现
        .option(ChannelOption.SO_BACKLOG,128)//6.设置线程队列中等待连接的数量
        .childOption(ChannelOption.SO_KEEPALIVE,true)  //7.保持连接活动状态;
        .childHandler(new ChannelInitializer<SocketChannel>() {//8.创建一个通道，初始化对象

            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new NettyServerHander());//9.往pipeline链中添加自定义handler
            }
        });

        System.out.println("......................Server is ready..................");
        ChannelFuture cf = serverBootstrap.bind(9999).sync();//10.绑定端口，非阻塞
        System.out.println("......................Server is starting..................");

        //11.关闭通道，关闭线程组
        cf.channel().closeFuture();
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
}
