package demo.turbo.greendaodemo.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import demo.turbo.greendaodemo.dao.Point;
import demo.turbo.greendaodemo.dao.table1;
import demo.turbo.greendaodemo.dao.PersonTable;

import demo.turbo.greendaodemo.dao.PointDao;
import demo.turbo.greendaodemo.dao.table1Dao;
import demo.turbo.greendaodemo.dao.PersonTableDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig pointDaoConfig;
    private final DaoConfig table1DaoConfig;
    private final DaoConfig personTableDaoConfig;

    private final PointDao pointDao;
    private final table1Dao table1Dao;
    private final PersonTableDao personTableDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        pointDaoConfig = daoConfigMap.get(PointDao.class).clone();
        pointDaoConfig.initIdentityScope(type);

        table1DaoConfig = daoConfigMap.get(table1Dao.class).clone();
        table1DaoConfig.initIdentityScope(type);

        personTableDaoConfig = daoConfigMap.get(PersonTableDao.class).clone();
        personTableDaoConfig.initIdentityScope(type);

        pointDao = new PointDao(pointDaoConfig, this);
        table1Dao = new table1Dao(table1DaoConfig, this);
        personTableDao = new PersonTableDao(personTableDaoConfig, this);

        registerDao(Point.class, pointDao);
        registerDao(table1.class, table1Dao);
        registerDao(PersonTable.class, personTableDao);
    }
    
    public void clear() {
        pointDaoConfig.getIdentityScope().clear();
        table1DaoConfig.getIdentityScope().clear();
        personTableDaoConfig.getIdentityScope().clear();
    }

    public PointDao getPointDao() {
        return pointDao;
    }

    public table1Dao getTable1Dao() {
        return table1Dao;
    }

    public PersonTableDao getPersonTableDao() {
        return personTableDao;
    }

}