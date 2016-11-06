package storage;

import domain.Deritative;

public interface Storage {
	public void addDeritative(String name, Deritative deritative);
	
	public Deritative getDertitative(String name);
}
