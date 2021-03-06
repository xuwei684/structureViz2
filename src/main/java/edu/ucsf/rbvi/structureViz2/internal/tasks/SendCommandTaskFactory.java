package edu.ucsf.rbvi.structureViz2.internal.tasks;

import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

import edu.ucsf.rbvi.structureViz2.internal.model.StructureManager;

public class SendCommandTaskFactory extends AbstractTaskFactory implements TaskFactory {

	private StructureManager structureManager;

	public SendCommandTaskFactory(StructureManager structureManager) {
		this.structureManager = structureManager;
	}

	public TaskIterator createTaskIterator() {
		return new TaskIterator(new SendComandTask(structureManager));
	}

	public boolean isReady() {
		if (structureManager.getChimeraManager().isChimeraLaunched()) {
			return true;
		}
		return false;
	}
	
}
