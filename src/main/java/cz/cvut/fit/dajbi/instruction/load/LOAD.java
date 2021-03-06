package cz.cvut.fit.dajbi.instruction.load;

import cz.cvut.fit.dajbi.heap.HeapHandle;
import cz.cvut.fit.dajbi.instruction.Instruction;
import cz.cvut.fit.dajbi.stack.Frame;

public class LOAD extends Instruction {

	int index;

	public LOAD(Frame f) {
		super(f);
		index = (int) frame.getReader().readByteToUInt();
		// TODO Auto-generated constructor stub
	}

	public LOAD(Frame f, int i) {
		super(f);
		index = i;
	}

	@Override
	public void execute() {
		Object obj = frame.getLocal(index);
		
		if (obj != null && obj instanceof HeapHandle) {
			((HeapHandle) obj).IncReferences();
		}
		
		frame.push(obj);
	}

}
