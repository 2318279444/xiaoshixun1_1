package com.bawei.dengxianchao2020_03_09.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bawei.dengxianchao2020_03_09.MyMoviesj;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MY_MOVIESJ".
*/
public class MyMoviesjDao extends AbstractDao<MyMoviesj, Void> {

    public static final String TABLENAME = "MY_MOVIESJ";

    /**
     * Properties of entity MyMoviesj.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Url = new Property(0, String.class, "url", false, "URL");
    }


    public MyMoviesjDao(DaoConfig config) {
        super(config);
    }
    
    public MyMoviesjDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MY_MOVIESJ\" (" + //
                "\"URL\" TEXT);"); // 0: url
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MY_MOVIESJ\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MyMoviesj entity) {
        stmt.clearBindings();
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(1, url);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MyMoviesj entity) {
        stmt.clearBindings();
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(1, url);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public MyMoviesj readEntity(Cursor cursor, int offset) {
        MyMoviesj entity = new MyMoviesj( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0) // url
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MyMoviesj entity, int offset) {
        entity.setUrl(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(MyMoviesj entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(MyMoviesj entity) {
        return null;
    }

    @Override
    public boolean hasKey(MyMoviesj entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}