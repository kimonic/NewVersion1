package dingw.com.newversion.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

import dingw.com.newversion.bean.wait.Chatbean;

/**
 * Created by 12348 on 2017/4/18 0018.
 * 数据库辅助类
 */

public class MyDbHelper {
    private static final String KEY_CONTENT = "content";    //数据表字段--聊天内容
    private static final String KEY_TIME = "time";    //数据表字段--聊天时间
    private static final String KEY_ROWID = "_id";    //数据表字段--id
    private static final String KEY_ICON = "icon";    //数据表字段--头像
    private static final String KEY_NAME = "name";    //数据表字段--姓名(对方聊天)
    private static final String KEY_FLAG = "flag";    //数据表字段--聊天布局标识
    private static final String KEY_XUHAO = "xuhao";    //和某个人聊天的信息记录序号,自增

    private DatabaseHelper mDbHelper;    //SQLiteOpenHelper实例对象
    private SQLiteDatabase mDb;    //数据库实例对象

    //数据表创建语句
    private static final String DATABASE_CREATE  = "create table chatcontent (_id integer primary key autoincrement, "
            + "content text , time text , name text , icon integer,flag integer,xuhao integer);";

    private static final String DATABASE_NAME = "data";    //数据库名
    private static final String DATABASE_TABLE = "chatcontent";    //数据库表名
    private static final int DATABASE_VERSION = 1;    //数据库版本号

    private final Context mCtx;    //上下文实例

    private static class DatabaseHelper extends SQLiteOpenHelper {    //数据库辅助类
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        /**创建数据库*/
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }
        /**更新数据库*/
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS chatcontent");
            onCreate(db);
        }
    }


    public MyDbHelper(Context ctx) {
        this.mCtx = ctx;
    }

    /**打开数据库*/
    public MyDbHelper open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();

        return this;
    }
    /**关闭数据库*/
    public void close() {
        mDbHelper.close();
    }


    /**插入数据*/
    public long createChatContent(Chatbean chatbean) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, chatbean.getName());
        initialValues.put(KEY_TIME, chatbean.getTime());
        initialValues.put(KEY_CONTENT, chatbean.getTitle());
        initialValues.put(KEY_ICON, chatbean.getResId());
        initialValues.put(KEY_FLAG, chatbean.getFlag());
        initialValues.put(KEY_XUHAO, chatbean.getXuhao());
        return mDb.insert(DATABASE_TABLE, null, initialValues);
    }

    /**删除数据--按照行编号*/
    public boolean deleteNote(long rowId) {
        return mDb.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    /**查询所有数据*/
    public Cursor fetchAllNotes() {
        return mDb.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_CONTENT,KEY_TIME,KEY_NAME,KEY_ICON,KEY_FLAG,KEY_XUHAO}, null, null, null, null, null);
    }

    /**查询操作*/
    public Cursor fetchNote(long rowId) throws SQLException {

        Cursor mCursor = mDb.query(true, DATABASE_TABLE, new String[] {KEY_ROWID, KEY_CONTENT,KEY_TIME,KEY_NAME,KEY_ICON,KEY_FLAG
                ,KEY_XUHAO}, KEY_ROWID + "=" + rowId, null, null, null, null, null);
//        if (mCursor != null) {
//            mCursor.moveToFirst();
//        }
        return mCursor;
    }

    /**根据姓名修改操作???*/
    public boolean updateNote(long rowId, String name, String time, String content, int icon,int flag,int xuhao) {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_TIME, time);
        args.put(KEY_CONTENT, content);
        args.put(KEY_ICON, icon);
        args.put(KEY_FLAG, flag);
        args.put(KEY_XUHAO, xuhao);
        return mDb.update(DATABASE_TABLE, args, KEY_NAME + "='" + name+"'", null) > 0;
    }

    /**根据姓名查询信息*/
    public Cursor getInfoByName(String name){
        Cursor mCursor=mDb.query(true,DATABASE_TABLE,new String[]{KEY_ROWID, KEY_CONTENT,KEY_TIME,KEY_NAME,KEY_ICON,KEY_FLAG,KEY_XUHAO},
                KEY_NAME+"='"+name+"'",null,null,null,null,null
                );
        return mCursor;
    }

    /**返回根据姓名查询到的信息总条数*/
    public int getTotalCount(String name){
        int count=0;
        Cursor mCursor=mDb.query(true,DATABASE_TABLE,new String[]{KEY_ROWID, KEY_CONTENT,KEY_TIME,KEY_NAME,KEY_ICON,KEY_FLAG,KEY_XUHAO},KEY_NAME+"='"+name+"'",null,null,null,null,null);
        if (mCursor!=null){
            while (mCursor.moveToNext()){
                count++;
            }
            mCursor.close();
        }
        return count;
    }

    /**返回根据姓名查询到的信息*/
    public List<Chatbean> getChatContent(String name){
        List<Chatbean> list=new ArrayList<Chatbean>();
        Cursor cursor=getInfoByName(name);
        if (cursor!=null){
            while (cursor.moveToNext()){
                Chatbean bean=new Chatbean();
                bean.setName(cursor.getString(cursor.getColumnIndex("name")));
                bean.setResId(cursor.getInt(cursor.getColumnIndex("icon")));

                bean.setTime(cursor.getString(cursor.getColumnIndex("time")));
//            bean.setDate(cursor.getString(cursor.getColumnIndex("name")));

                bean.setFlag(cursor.getInt(cursor.getColumnIndex("flag")));
                bean.setTitle(cursor.getString(cursor.getColumnIndex("content")));
                bean.setXuhao(cursor.getInt(cursor.getColumnIndex("xuhao")));
                list.add(bean);
            }
            cursor.close();

        }
        return list;
    }
    /**删除原聊天数据库表格,创建一个新表格------测试用*/
    public void delDb(){
        mDb.execSQL("DROP TABLE IF EXISTS chatcontent");
        mDb.execSQL(DATABASE_CREATE);
    }


}

