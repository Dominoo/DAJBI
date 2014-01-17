package cz.cvut.fit.dajbi.instruction.invoke;

import cz.cvut.fit.dajbi.instruction.Instruction;
import cz.cvut.fit.dajbi.stack.Frame;

public class RETURN extends Instruction {

	

	public RETURN(Frame f) {
		super(f);
	}

	@Override
	public void execute() {
		frame.pop();
	}

}
