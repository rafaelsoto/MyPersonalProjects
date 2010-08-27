package br.com.rafaelsoto.myutilcode.chain;

import org.apache.log4j.Logger;

/**
 * Base class to implements a ChainOfResponsability pattern
 * @author Rafael Soto
 *
 */
public abstract class AbstractChainNode {

	Logger log = Logger.getLogger(AbstractChainNode.class);
	
	protected AbstractChainNode next;
	
	/**
	 * Process a chain node calling yours businessRule and invoke a next node.
	 * This method execute in recursively mode until chain node does not have a next node.
	 * @param objects
	 */
	public void processNode(Object... objects)
	{
		log.debug("Processing node -> " + this.getClass().getSimpleName());
		
		businessRule(objects);
		
		log.debug("Processed -> " + this.getClass().getSimpleName());
		
		if(next != null)
		log.debug("Next calling node -> " + this.getClass().getSimpleName());
		next.processNode(objects);
	}
	
	protected abstract void businessRule(Object... objects);
	
	/**
	 * Set the next node in chain.
	 * This method works to link one node to other
	 * @param next
	 * @return
	 */
	public AbstractChainNode setNext(AbstractChainNode next)
	{
		this.next = next;
		
		log.debug("Linking nodes in the chain [ " + this.getClass().getSimpleName() + " --> " + next.getClass().getSimpleName() + " ]");
		
		return next;
	}
	
}
