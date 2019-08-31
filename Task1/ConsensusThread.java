//Thread implementation for Consensus protocol

public class ConsensusThread extends Thread
{
	private Consensus<Integer> ConsensusObject;
	private Integer InputValue;
	private int Delay;

	public ConsensusThread(Consensus<Integer> consensusObject, int inputValue, int delay)	{
		ConsensusObject = consensusObject;
		InputValue = new Integer(inputValue);
		Delay = delay;
	}

	public void run()	{
		// Report before calling decide()
		System.out.println("Thread " + Integer.toString(ThreadID.get()) + 
			" calls decide() with " + InputValue.toString());
		
		//Once called decide, sleep for a random time
		try	{
			Thread.sleep(Delay);
		}
		catch (InterruptedException exception)	{
			System.out.println("Thread interrupted while sleeping.");
		}

		// Execute the consensus protocol
		Integer decision_value = ConsensusObject.decide(InputValue);

		// Report after calling decide()
		System.out.println("Thread " + Integer.toString(ThreadID.get()) + 
			" decided on " + decision_value.toString());
	}
}
