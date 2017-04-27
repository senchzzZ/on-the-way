package com.exp.zsq.netty.timexp.server;

import com.exp.zsq.netty.timexp.client.UnixTime;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by zhaoshengqi on 2017/4/13.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter{

    /*public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 默默地丢弃收到的数据
        ByteBuf in = (ByteBuf) msg;
        try{
            while (in.isReadable()){
                System.out.println(in.toString(CharsetUtil.US_ASCII));
                System.out.flush();
            }
        }finally {
            in.release();
            //ReferenceCountUtil.release(msg);
        }
    }*/

    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        ChannelFuture f = ctx.writeAndFlush(new UnixTime());
        System.out.println("new client :"+ctx.channel().remoteAddress());
        //System.out.println(f.);
        //f.channel().
        f.addListener(ChannelFutureListener.CLOSE);
       /*f.addListener( (ChannelFuture channelFuture) -> {
           assert f == channelFuture;
           Thread.sleep(10000);
           ctx.close();
       });// (4)*/
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.writeAndFlush(msg);
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
