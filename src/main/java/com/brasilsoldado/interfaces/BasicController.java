package com.brasilsoldado.interfaces;

import java.util.ArrayList;

public interface BasicController {

    public ArrayList<Object> index();

    public boolean store();

    public boolean update();

    public Object show();

    public boolean delete();
}
