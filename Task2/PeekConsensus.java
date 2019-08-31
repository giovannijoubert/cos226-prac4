//Task 2 - complete consensus protocol that uses a FIFO queue with peek()
import java.util.LinkedList;
import java.util.Queue;

public class PeekConsensus extends ConsensusProtocol<Integer>	{

	Queue<Integer> queue;
	public PeekConsensus(int threadCount)	{
		super(threadCount);
		queue = new LinkedList<Integer>();	
	}

	public Integer decide(Integer value)	{
		this.propose(value);
		queue.add(ThreadID.get());
		return proposed.elementAt(queue.peek());
	}
}
