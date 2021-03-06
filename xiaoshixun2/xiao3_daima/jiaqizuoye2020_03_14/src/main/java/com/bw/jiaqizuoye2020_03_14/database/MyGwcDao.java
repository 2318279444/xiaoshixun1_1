package com.bw.jiaqizuoye2020_03_14.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bw.jiaqizuoye2020_03_14.MyGwc;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MY_GWC".
*/
public class MyGwcDao extends AbstractDao<MyGwc, Void> {

    public static final String TABLENAME = "MY_GWC";

    /**
     * Properties of entity MyGwc.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Url = new Property(0, String.class, "url", false, "URL");
    }


    public MyGwcDao(DaoConfig config) {
        super(config);
    }
    
    public MyGwcDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MY_GWC\" (" + //
                "\"URL\" TEXT);"); // 0: url
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MY_GWC\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MyGwc entity) {
        stmt.clearBindings();
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(1, url);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MyGwc entity) {
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
    public MyGwc readEntity(Cursor cursor, int offset) {
        MyGwc entity = new MyGwc( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0) // url
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MyGwc entity, int offset) {
        entity.setUrl(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(MyGwc entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(MyGwc entity) {
        return null;
    }

    @Override
    public boolean hasKey(MyGwc entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
