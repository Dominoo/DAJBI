package cz.cvut.fit.dajbi.internal.attributes;

import cz.cvut.fit.dajbi.DAJBI;
import cz.cvut.fit.dajbi.parser.AttributeReader;

public class CodeAttribute extends Attribute {

	
	//DUMMY NA PRESKOCENI EXCEPTION
	static final int exceptionTable = 8;
	
	
	short maxStack;
	short maxLocals;
	int codeLength;
	byte[] code;
	short exceptionTableLength;
	short attributesCount;
	Attribute[] attributes;
	
	
	
	public CodeAttribute(AttributeReader attributeReader) {
		super(attributeReader);
		
		maxStack = attributeReader.getReader().readShort();
		maxLocals = attributeReader.getReader().readShort();
		codeLength = attributeReader.getReader().readInt();
		code = attributeReader.getReader().readBytes(codeLength);
		exceptionTableLength = attributeReader.getReader().readShort();
		//hack abysme nemuseli implementovat excpetiony zatim
		attributeReader.getReader().readBytes(exceptionTableLength*exceptionTable);
		
		attributesCount = attributeReader.getReader().readShort();
		
		DAJBI.logger.trace(" === Code ATTRIBUTE START ===");
		attributes =  new Attribute[attributesCount];
		for(int i = 0; i < attributesCount; i++) {
			attributes[i] = attributeReader.readAttribute();
		}
		DAJBI.logger.trace(" === Code ATTRIBUTE END ===");
		
				

	}



	/**
	 * @return the maxStack
	 */
	public short getMaxStack() {
		return maxStack;
	}



	/**
	 * @param maxStack the maxStack to set
	 */
	public void setMaxStack(short maxStack) {
		this.maxStack = maxStack;
	}



	/**
	 * @return the maxLocals
	 */
	public short getMaxLocals() {
		return maxLocals;
	}



	/**
	 * @param maxLocals the maxLocals to set
	 */
	public void setMaxLocals(short maxLocals) {
		this.maxLocals = maxLocals;
	}



	/**
	 * @return the code
	 */
	public byte[] getCode() {
		return code;
	}



	/**
	 * @param code the code to set
	 */
	public void setCode(byte[] code) {
		this.code = code;
	}



	/**
	 * @return the attributesCount
	 */
	public short getAttributesCount() {
		return attributesCount;
	}



	/**
	 * @param attributesCount the attributesCount to set
	 */
	public void setAttributesCount(short attributesCount) {
		this.attributesCount = attributesCount;
	}



	/**
	 * @return the attributes
	 */
	public Attribute[] getAttributes() {
		return attributes;
	}



	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(Attribute[] attributes) {
		this.attributes = attributes;
	}
	
	

}
