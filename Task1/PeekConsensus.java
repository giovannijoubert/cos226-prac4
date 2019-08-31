//Task 2 - complete consensus protocol that uses a FIFO queue with peek()

public class PeekConsensus extends ConsensusProtocol<Integer>	{
	
	public PeekConsensus(int threadCount)	{
		super(threadCount);
		
		
	
	}

	public Integer decide(Integer value)	{
		this.propose(value);
		
		return 1; //stubbed for task 1
	}
}
