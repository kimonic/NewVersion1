package dingw.com.newversion.bean;

import com.google.gson.annotations.SerializedName;

import dingw.com.newversion.base.BaseBean;

/**
 * Created by 12348 on 2017/4/14 0014.
 * 登录--绑定--解绑bean
 */

public class LoginBean extends BaseBean{
    private String state;
    private String type;
    private String name;
    private String id;
    private String office_type;
    private String session_id;

    public String[] getTemp() {
        return temp;
    }

    public void setTemp(String[] temp) {
        this.temp = temp;
    }

    private String[] temp;

    private String list;
    private String zero;
    private String one;
    private String one_office_name;
    private String one_office_id;
    private String zero_office_name;
    private String zero_office_id;
    @SerializedName(value = "error",alternate ={"Error","Error123"})//设置别名
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOffice_type() {
        return office_type;
    }

    public void setOffice_type(String office_type) {
        this.office_type = office_type;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getZero() {
        return zero;
    }

    public void setZero(String zero) {
        this.zero = zero;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getOne_office_name() {
        return one_office_name;
    }

    public void setOne_office_name(String one_office_name) {
        this.one_office_name = one_office_name;
    }

    public String getOne_office_id() {
        return one_office_id;
    }

    public void setOne_office_id(String one_office_id) {
        this.one_office_id = one_office_id;
    }

    public String getZero_office_name() {
        return zero_office_name;
    }

    public void setZero_office_name(String zero_office_name) {
        this.zero_office_name = zero_office_name;
    }

    public String getZero_office_id() {
        return zero_office_id;
    }

    public void setZero_office_id(String zero_office_id) {
        this.zero_office_id = zero_office_id;
    }
}
