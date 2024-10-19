package model;

public class Node <T> {
	
	private T e;
	private Node<T> lesser;
	private Node<T> greater;
	
	public Node(T e) {
		this.e = e;
		this.lesser = null;
		this.greater = null;
	}
	
	public Node() {
	}

	public T getElement() {
		return e;
	}

	public void setElement(T e) {
		this.e = e;
	}

	public Node<T> getLesser() {
		return lesser;
	}

	public void setLesser(Node<T> lesser) {
		this.lesser = lesser;
	}

	public Node<T> getGreater() {
		return greater;
	}

	public void setGreater(Node<T> greater) {
		this.greater = greater;
	}
	
}
