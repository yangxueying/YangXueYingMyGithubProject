package com.entity;

public class Hunlicehua {
    private Integer id;
	private String cehuafangan;	private String jiage;	private String lianxidianhua;	private String dizhi;	private String tupian;	private String xiangxi;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getCehuafangan() {
        return cehuafangan;
    }
    public void setCehuafangan(String cehuafangan) {
        this.cehuafangan = cehuafangan == null ? null : cehuafangan.trim();
    }	public String getJiage() {
        return jiage;
    }
    public void setJiage(String jiage) {
        this.jiage = jiage == null ? null : jiage.trim();
    }	public String getLianxidianhua() {
        return lianxidianhua;
    }
    public void setLianxidianhua(String lianxidianhua) {
        this.lianxidianhua = lianxidianhua == null ? null : lianxidianhua.trim();
    }	public String getDizhi() {
        return dizhi;
    }
    public void setDizhi(String dizhi) {
        this.dizhi = dizhi == null ? null : dizhi.trim();
    }	public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? null : tupian.trim();
    }	public String getXiangxi() {
        return xiangxi;
    }
    public void setXiangxi(String xiangxi) {
        this.xiangxi = xiangxi == null ? null : xiangxi.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
