package cz.cvut.fit.dajbi.parser;

import java.nio.ByteBuffer;

public class Reader {

	byte[] bytes;
	int index ;
	
	public Reader(byte[] byteArray) {
		index = 0;
		this.bytes = byteArray;
	}
	
	public byte peekByte() {
		return bytes[index];
	}
	

	public byte readByte() {
		return bytes[index++];
	}
	
	public short readShort() {
		short tmp = readByte();
		tmp = (short) (tmp << 8);
		tmp += readByte();
		return tmp;		
	}
	
	public int readInt() {
		int tmp = 0;
		for(int i = 0; i < 4; i++) {
			tmp = tmp << 8;
			tmp+= readByte();
		}
		return tmp;
	}
	
	public long readLong() {
		ByteBuffer buffer = ByteBuffer.allocate(8);
	    buffer.put(readBytes(8));
	    buffer.flip();//need flip 
	    return buffer.getLong();
	} 
	
	public double readDouble() {
		ByteBuffer buffer = ByteBuffer.allocate(8);
	    buffer.put(readBytes(8));
	    buffer.flip();//need flip 
	    return buffer.getDouble();
	}

	public byte[] readBytes(int i) {
		byte[] arr = new byte[i];
		for(int j = 0 ; j<i;j++) {
			arr[j] = readByte();
		}
		return arr;
	}

}