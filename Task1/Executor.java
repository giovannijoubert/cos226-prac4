import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class Executor
{
	private final int ThreadCount; //Number of threads received from command line

	private FIFOConsensus ConsensusObject; //Consensus protocol implemented - change to PeekConsensus for practical

	private LinkedList<ConsensusThread> Threads = new LinkedList<ConsensusThread>(); //Pool of Threads trying to reach consensus

	public Executor(int threadCount)
	{
		ThreadCount = threadCount;
		ConsensusObject = new FIFOConsensus(threadCount); //change to PeekConsensus for practical
	}

	public void run()
	{
		Random rng = new Random();
		
		//Create new threads and add them to the pool
		for (int i = 0; i < ThreadCount; i++)		{
			Threads.add(new ConsensusThread(ConsensusObject, rng.nextInt(50), (50 + rng.nextInt(50)))); 
		}

		// Start the consensus threads
		ListIterator<ConsensusThread> iterator = Threads.listIterator();
    
		while (iterator.hasNext())
			iterator.next().start();
    
		// Wait for the consensus threads to finish executing
		while (iterator.hasPrevious())	{
			try	{
				iterator.previous().join();
			} catch (InterruptedException exception)	{
				System.out.println("Thread interrupted while waiting for join.");
			}
		}
	}

	public static void main(String[] args)
	{
		Executor executor = new Executor(Integer.parseInt(args[0]));

		executor.run();
	}
}
