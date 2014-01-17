package cz.cvut.fit.dajbi.stack;

import java.util.SortedMap;
import java.util.TreeMap;

import cz.cvut.fit.dajbi.Interpreter;
import cz.cvut.fit.dajbi.internal.ClassFile;
import cz.cvut.fit.dajbi.parser.Reader;

public class Frame extends Stack<Object> {
	
	
	Interpreter interpreter;
	SortedMap<Integer, Object> localVariables;
	ClassFile classFile;
	Reader reader;	
	
	public Frame() {
		super();
		localVariables = new TreeMap<Integer, Object>();	
		localVariables.clear();
	}
	
	public Object getLocal(int i) {
		return localVariables.get(i);
	}
	
	public void setLocal(int i, Object o) {
		localVariables.put(i, o);
	}

	/**
	 * @return the classFile
	 */
	public ClassFile getClassFile() {
		return classFile;
	}

	/**
	 * @param classFile the classFile to set
	 */
	public void setClassFile(ClassFile classFile) {
		this.classFile = classFile;
	}

	/**
	 * @return the reader
	 */
	public Reader getReader() {
		return reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Reader reader) {
		this.reader = reader;
	}

	/**
	 * @return the interpreter
	 */
	public Interpreter getInterpreter() {
		return interpreter;
	}

	/**
	 * @param interpreter the interpreter to set
	 */
	public void setInterpreter(Interpreter interpreter) {
		this.interpreter = interpreter;
	}
	
	

}
