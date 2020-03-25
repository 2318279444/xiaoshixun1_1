package com.bw.dengxianchao2020_03_09.database;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.bw.dengxianchao2020_03_09.MyMoviesj;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig myMoviesjDaoConfig;

    private final MyMoviesjDao myMoviesjDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        myMoviesjDaoConfig = daoConfigMap.get(MyMoviesjDao.class).clone();
        myMoviesjDaoConfig.initIdentityScope(type);

        myMoviesjDao = new MyMoviesjDao(myMoviesjDaoConfig, this);

        registerDao(MyMoviesj.class, myMoviesjDao);
    }
    
    public void clear() {
        myMoviesjDaoConfig.clearIdentityScope();
    }

    public MyMoviesjDao getMyMoviesjDao() {
        return myMoviesjDao;
    }

}