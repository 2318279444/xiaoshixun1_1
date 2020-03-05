package com.bawei.rikaoday1_02_21.database;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.bawei.rikaoday1_02_21.greend.GreenDaoweizhi;

import com.bawei.rikaoday1_02_21.database.GreenDaoweizhiDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig greenDaoweizhiDaoConfig;

    private final GreenDaoweizhiDao greenDaoweizhiDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        greenDaoweizhiDaoConfig = daoConfigMap.get(GreenDaoweizhiDao.class).clone();
        greenDaoweizhiDaoConfig.initIdentityScope(type);

        greenDaoweizhiDao = new GreenDaoweizhiDao(greenDaoweizhiDaoConfig, this);

        registerDao(GreenDaoweizhi.class, greenDaoweizhiDao);
    }
    
    public void clear() {
        greenDaoweizhiDaoConfig.clearIdentityScope();
    }

    public GreenDaoweizhiDao getGreenDaoweizhiDao() {
        return greenDaoweizhiDao;
    }

}