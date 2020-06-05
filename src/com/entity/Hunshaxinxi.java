package com.entity;

public class Hunshaxinxi {
    private Integer id;
	private String hunshabianhao;	private String hunshamingcheng;	private String hunshaleixing;	private String tupian;	private String lianxidianhua;	private String jiage;	private String xiangxi;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getHunshabianhao() {
        return hunshabianhao;
    }
    public void setHunshabianhao(String hunshabianhao) {
        this.hunshabianhao = hunshabianhao == null ? null : hunshabianhao.trim();
    }	public String getHunshamingcheng() {
        return hunshamingcheng;
    }
    public void setHunshamingcheng(String hunshamingcheng) {
        this.hunshamingcheng = hunshamingcheng == null ? null : hunshamingcheng.trim();
    }	public String getHunshaleixing() {
        return hunshaleixing;
    }
    public void setHunshaleixing(String hunshaleixing) {
        this.hunshaleixing = hunshaleixing == null ? null : hunshaleixing.trim();
    }	public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? null : tupian.trim();
    }	public String getLianxidianhua() {
        return lianxidianhua;
    }
    public void setLianxidianhua(String lianxidianhua) {
        this.lianxidianhua = lianxidianhua == null ? null : lianxidianhua.trim();
    }	public String getJiage() {
        return jiage;
    }
    public void setJiage(String jiage) {
        this.jiage = jiage == null ? null : jiage.trim();
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
