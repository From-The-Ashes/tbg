package dev.blue.tbg;

public class Pair<A, B> {
	private final A first;
	private final B second;

	public Pair(A first, B second) {
		this.first = first;
		this.second = second;
	}

	public A A() {
		return first;
	}

	public B B() {
		return second;
	}

	@Override
	public String toString() {
		return "Pair[" + first + ", " + second + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Pair))
			return false;
		Pair<?, ?> other = (Pair<?, ?>) o;
		return (first == null ? other.first == null : first.equals(other.first))
				&& (second == null ? other.second == null : second.equals(other.second));
	}

	@Override
	public int hashCode() {
		return (first == null ? 0 : first.hashCode()) * 31 + (second == null ? 0 : second.hashCode());
	}
}