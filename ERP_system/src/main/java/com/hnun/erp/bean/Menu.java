package com.hnun.erp.bean;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;



public class Menu {
    private String menuid;

    private String menuname;

    private String icon;

    private String url;
    @JSONField(serialize=false)
    private String pid;
    
    private List<Menu> menus;

    public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }
    
    public boolean equals(Object obj) {
        if(this==obj)//地址相同
            return true;
        else if(obj!=null&&obj instanceof Menu) {
        	Menu u=(Menu)obj;
            return this.menuname.equals(u.menuname)&&this.menuid.equals(u.menuid);
        }
        else
            return false;
    }

}