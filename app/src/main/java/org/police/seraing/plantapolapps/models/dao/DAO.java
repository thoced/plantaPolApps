package org.police.seraing.plantapolapps.models.dao;

import android.content.Context;

import java.util.List;

public abstract class DAO<T> {
    private SQLiteCustom connection;

    private Context context;

    public DAO(SQLiteCustom connection, Context context) {
        this.connection = connection;
        this.context = context;
    }

    public SQLiteCustom getConnection() {
        return connection;
    }

    public void setConnection(SQLiteCustom connection) {
        this.connection = connection;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract T insert(T model);

    public abstract T update(T model);

    public abstract T delete(T model);

    public abstract T find(long id);

    public abstract List<T> selectAll();

    public abstract List<T> selectFromForeignKey(long foreignKey);

    public abstract void deleteFromForeignKey(long foreignKey);
}
