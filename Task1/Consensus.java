//Interface for Consensus protocol

public interface Consensus<T>
{
	T decide(T value);
}
