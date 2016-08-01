package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

/**
 * Created by turbo on 2016/7/9.
 */
public class CreateSchema
{
    public static void main(String[] args){
        //                    DB版本號  ,  目標 package name
        Schema schema = new Schema(1, "demo.turbo.greendaodemo.dao");
        createTable(schema);
        generateDaoFiles(schema);
    }

    private static void createTable(Schema schema){
        //一個Entity 對應一個 DB table
        Entity point = schema.addEntity("Point");
        Entity mytable = schema.addEntity("table1");
        Entity mytable1 = schema.addEntity("PersonTable");

        //add table column
        point.addIdProperty();
        point.addDoubleProperty("xPos").notNull();
        point.addDoubleProperty("yPos").notNull();

        mytable.addIntProperty("_id").primaryKey().notNull();
        mytable.addStringProperty("name").notNull();
        mytable.addStringProperty("address").notNull();

        mytable1.addLongProperty("_id").primaryKey().notNull();
        mytable1.addStringProperty("_name").notNull();
        mytable1.addStringProperty("_address").notNull();
    }

    private static void generateDaoFiles(Schema schema){
        try {
            DaoGenerator generator = new DaoGenerator();
            //建立到指定目錄
            generator.generateAll(schema, "../GreenDaoDemo/app/src/main/java");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
