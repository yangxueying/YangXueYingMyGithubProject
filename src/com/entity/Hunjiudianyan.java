package com.entity;

public class Hunjiudianyan {
    private Integer id;
	private String jiudianbianhao;	private String jiudianmingcheng;	private String tupian;	private String xingji;	private String lianxidianhua;	private String dizhi;	private String jiudianjianjie;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getJiudianbianhao() {
        return jiudianbianhao;
    }
    public void setJiudianbianhao(String jiudianbianhao) {
        this.jiudianbianhao = jiudianbianhao == null ? null : jiudianbianhao.trim();
    }	public String getJiudianmingcheng() {
        return jiudianmingcheng;
    }
    public void setJiudianmingcheng(String jiudianmingcheng) {
        this.jiudianmingcheng = jiudianmingcheng == null ? null : jiudianmingcheng.trim();
    }	public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? null : tupian.trim();
    }	public String getXingji() {
        return xingji;
    }
    public void setXingji(String xingji) {
        this.xingji = xingji == null ? null : xingji.trim();
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
    }	public String getJiudianjianjie() {
        return jiudianjianjie;
    }
    public void setJiudianjianjie(String jiudianjianjie) {
        this.jiudianjianjie = jiudianjianjie == null ? null : jiudianjianjie.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
