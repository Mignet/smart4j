  package com.v5ent.plugin.netty;
  
  import io.netty.bootstrap.ServerBootstrap;
  import io.netty.channel.ChannelFuture;
  import io.netty.channel.ChannelInitializer;
  import io.netty.channel.ChannelOption;
  import io.netty.channel.ChannelPipeline;
  import io.netty.channel.EventLoopGroup;
  import io.netty.channel.nio.NioEventLoopGroup;
  import io.netty.channel.socket.SocketChannel;
  import io.netty.channel.socket.nio.NioServerSocketChannel;
  import io.netty.handler.logging.LogLevel;
  import io.netty.handler.logging.LoggingHandler;
  
  /**
   * Echoes back any received data from a client.
   */
  public final class EchoServer {
  
      static final int PORT = Integer.parseInt(System.getProperty("port", "8002"));
  
      public static void main(String[] args) throws Exception {
          // Configure the server.
          EventLoopGroup bossGroup = new NioEventLoopGroup(1);
          EventLoopGroup workerGroup = new NioEventLoopGroup();
          try {
              ServerBootstrap b = new ServerBootstrap();
              b.group(bossGroup, workerGroup)
               .channel(NioServerSocketChannel.class)
               .option(ChannelOption.SO_BACKLOG, 0)
               .handler(new LoggingHandler(LogLevel.INFO))
               .childHandler(new ChannelInitializer<SocketChannel>() {
                   @Override
                   public void initChannel(SocketChannel ch) throws Exception {
                       ChannelPipeline p = ch.pipeline();
                       //p.addLast(new LoggingHandler(LogLevel.INFO));
                       p.addLast(new EchoServerHandler());
                   }
               });
  
              // Start the server.
              ChannelFuture f = b.bind(PORT).sync();
  
              // Wait until the server socket is closed.
              f.channel().closeFuture().sync();
          } finally {
              // Shut down all event loops to terminate all threads.
              bossGroup.shutdownGracefully();
              workerGroup.shutdownGracefully();
          }
      }
  }
