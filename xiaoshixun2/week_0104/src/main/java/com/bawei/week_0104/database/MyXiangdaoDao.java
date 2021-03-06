package com.bawei.week_0104.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bawei.dao.MyXiangdao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MY_XIANGDAO".
*/
public class MyXiangdaoDao extends AbstractDao<MyXiangdao, Void> {

    public static final String TABLENAME = "MY_XIANGDAO";

    /**
     * Properties of entity MyXiangdao.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Xiangdao = new Property(0, String.class, "Xiangdao", false, "XIANGDAO");
    }


    public MyXiangdaoDao(DaoConfig config) {
        super(config);
    }
    
    public MyXiangdaoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MY_XIANGDAO\" (" + //
                "\"XIANGDAO\" TEXT);"); // 0: Xiangdao
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MY_XIANGDAO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MyXiangdao entity) {
        stmt.clearBindings();
 
        String Xiangdao = entity.getXiangdao();
        if (Xiangdao != null) {
            stmt.bindString(1, Xiangdao);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MyXiangdao entity) {
        stmt.clearBindings();
 
        String Xiangdao = entity.getXiangdao();
        if (Xiangdao != null) {
            stmt.bindString(1, Xiangdao);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public MyXiangdao readEntity(Cursor cursor, int offset) {
        MyXiangdao entity = new MyXiangdao( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0) // Xiangdao
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MyXiangdao entity, int offset) {
        entity.setXiangdao(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(MyXiangdao entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(MyXiangdao entity) {
        return null;
    }

    @Override
    public boolean hasKey(MyXiangdao entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
