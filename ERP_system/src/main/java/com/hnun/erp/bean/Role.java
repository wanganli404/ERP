package com.hnun.erp.bean;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@JsonIgnoreProperties(value = {"handler"})
public class Role {
    private Long uuid;

    

	private String name;
	
	
	@JSONField(serialize = false)
	private List<Menu> menus;// 角色下的权限菜单
	
	@JSONField(serialize = false)
	private List<Emp> emps;//角色下的用户列表
	
	
	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    
    public boolean equals(Object obj) {
        if(this==obj)//地址相同
            return true;
        else if(obj!=null&&obj instanceof Role) {
        	Role r=(Role)obj;
            return this.getName().equals(r.getName())&&this.uuid.equals(r.uuid);
        }
        else
            return false;
    }
    
    
}