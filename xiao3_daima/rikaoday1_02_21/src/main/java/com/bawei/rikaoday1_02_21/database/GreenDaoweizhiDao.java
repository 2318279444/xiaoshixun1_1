package com.bawei.rikaoday1_02_21.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bawei.rikaoday1_02_21.greend.GreenDaoweizhi;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "GREEN_DAOWEIZHI".
*/
public class GreenDaoweizhiDao extends AbstractDao<GreenDaoweizhi, Void> {

    public static final String TABLENAME = "GREEN_DAOWEIZHI";

    /**
     * Properties of entity GreenDaoweizhi.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Weizhi = new Property(0, String.class, "weizhi", false, "WEIZHI");
    }


    public GreenDaoweizhiDao(DaoConfig config) {
        super(config);
    }
    
    public GreenDaoweizhiDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"GREEN_DAOWEIZHI\" (" + //
                "\"WEIZHI\" TEXT);"); // 0: weizhi
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"GREEN_DAOWEIZHI\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, GreenDaoweizhi entity) {
        stmt.clearBindings();
 
        String weizhi = entity.getWeizhi();
        if (weizhi != null) {
            stmt.bindString(1, weizhi);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, GreenDaoweizhi entity) {
        stmt.clearBindings();
 
        String weizhi = entity.getWeizhi();
        if (weizhi != null) {
            stmt.bindString(1, weizhi);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public GreenDaoweizhi readEntity(Cursor cursor, int offset) {
        GreenDaoweizhi entity = new GreenDaoweizhi( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0) // weizhi
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, GreenDaoweizhi entity, int offset) {
        entity.setWeizhi(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(GreenDaoweizhi entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(GreenDaoweizhi entity) {
        return null;
    }

    @Override
    public boolean hasKey(GreenDaoweizhi entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}