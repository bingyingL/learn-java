package com.howe.learn.client.handler;

import com.howe.learn.client.Connection;
import com.howe.learn.common.response.CalcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author Karl
 * @Date 2016/10/28 14:35
 */
public class ResultHandler extends ChannelInboundHandlerAdapter {
    private Connection connection;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg);
        if (msg instanceof CalcResponse) {
            CalcResponse response = (CalcResponse) msg;
            connection.result(response.getReqId(), response);
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        super.exceptionCaught(ctx, cause);
    }
}
