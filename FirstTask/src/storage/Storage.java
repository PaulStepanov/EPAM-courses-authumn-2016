package storage;

import model.domain.Deritative;

public interface Storage {
    public void addDeritative(String name, Deritative deritative);

    public Deritative getDertitative(String name);
}
