package com.demo.turbo.greendaodemo;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import demo.turbo.greendaodemo.dao.DaoMaster;
import demo.turbo.greendaodemo.dao.DaoSession;
import demo.turbo.greendaodemo.dao.Point;
import demo.turbo.greendaodemo.dao.PointDao;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private PointDao pointDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textviewid);

        helper = new DaoMaster.DevOpenHelper(MainActivity.this, "my_database.db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        pointDao = daoSession.getPointDao();

        for(Long i = 2L; i < 23; i++)
        {
            addPoint(i, Math.random(), Math.random());
        }

        deletePointByKey(5L);
        pointDao.update(new Point(1L, 23, 45));

        db.close();
    }

    private void addPoint(Long id, double x, double y)
    {
        Point point = new Point(id, x, y);
        pointDao.insertOrReplace(point);
    }

    private void deletePointByKey(Long id)
    {
        pointDao.deleteByKey(id);
    }
}
