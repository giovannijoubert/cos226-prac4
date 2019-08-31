//Complete consensus protocol that uses FIFO queue for two threads
import java.util.Queue; 
import java.util.LinkedList; 

public class FIFOConsensus extends ConsensusProtocol<Integer>	{

	private Queue<Integer> queue;
	
	public FIFOConsensus(int threadCount)	{
		super(threadCount);
		this.queue = new LinkedList<>(); 
		this.queue.add(1); //REDBALL
		this.queue.add(0); //BLACKBALL
	}

  
	public Integer decide(Integer value)	{
		this.propose(value);
		
		int ball = this.queue.remove();
		if(ball == 1){
			return proposed.get(ThreadID.get());
		} else {
			return proposed.get(1-ThreadID.get());
		}
		
		
	}
}
