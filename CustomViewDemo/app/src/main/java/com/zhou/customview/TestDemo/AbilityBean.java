package com.zhou.customview.TestDemo;

/**
 * Created by zhou on 2017/11/10.
 */

public class AbilityBean {
    public static final String[] abilitys
            = {"击杀", "生存", "助攻", "物理",
            "魔法", "防御", "金钱"};
    //每个能力的值，范围0~100，单位%
    private int kill;
    private int survival;
    private int assist;
    private int ad;
    private int ap;
    private int defense;
    private int money;
    public AbilityBean(int kill, int survival,
                       int assist, int ad, int ap,
                       int defense, int money) {
        this.kill = kill;
        this.survival = survival;
        this.assist = assist;
        this.ad = ad;
        this.ap = ap;
        this.defense = defense;
        this.money = money;
    }

    public static String[] getAbilitys() {
        return abilitys;
    }

    public int getKill() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }

    public int getSurvival() {
        return survival;
    }

    public void setSurvival(int survival) {
        this.survival = survival;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
