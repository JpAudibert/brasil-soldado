package com.brasilsoldado.interfaces;

import java.util.ArrayList;

public interface IBasicController<T> {

    public ArrayList<T> index();

    public T show(int id);

    public boolean store(T o);

    public boolean update(T o, int id);

    public boolean delete(int id);
}
