//Complete consensus protocol that uses FIFO queue for two threads

public class FIFOConsensus extends ConsensusProtocol<Integer>	{

	
	public FIFOConsensus(int threadCount)	{
		super(threadCount);
		
	}

  
	public Integer decide(Integer value)	{
		this.propose(value);
		
		
		
		
	}
}
