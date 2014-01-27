package cz.cvut.fit.dajbi.instruction.conditions;

import cz.cvut.fit.dajbi.heap.Heap;
import cz.cvut.fit.dajbi.heap.HeapHandle;
import cz.cvut.fit.dajbi.instruction.Instruction;
import cz.cvut.fit.dajbi.stack.Frame;

public class IFNONNULL extends Instruction {

	public IFNONNULL(Frame f) {
		super(f);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		HeapHandle handle = (HeapHandle) frame.pop();
		
		int jump = frame.getReader().readShort();
		if(handle.getDataOffset() != Heap.NULL) {
			frame.getReader().move(jump);
			frame.getReader().move(-3);
		}
		
		handle.DecReferences();
	}

}
