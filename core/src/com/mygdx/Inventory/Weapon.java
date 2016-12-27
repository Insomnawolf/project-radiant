package com.mygdx.Inventory;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.StreamUtils;

/**
 * Created by Clifford Hill on 12/26/2016.
 */

/*
This class is to be the overhead for all weapons.
it keeps track of attack power, and buffs it may gain.
It also keeps track of its elements, and more.

Still incomplete as a sprite is missing

this class is meant to be the base for any weapon to be made
 */

public abstract class Weapon extends Item {

    protected String extraAbility;      //any attribute added to strikes, such as knock back, stun, etc.
    protected String weaponClass;       //the name of what the weapon goes by, basic bow, broad sword, legendary etc.
    protected int attackPower;          //damage number
    protected String mElement;          //any magical element, wind, ice, earth etc...
    protected String pElement;          //any physical element slashing, piercing, blunt...
    protected int attackBoost;          //attack power boosted by refineing or upgrades
    protected int attackBuff;           //attack power boosted by skills or buffs.

    public Weapon (Vector2 position){
        super(position);
        extraAbility = "None";
        weaponClass = "None";
        attackPower = 0;
        mElement = "None";
        pElement = "None";
        attackBoost = 0;
        attackBuff = 0;
    }

    public void setmElement(String mElement) {
        this.mElement = mElement;
    }

    public void setpElement(String pElement) {
        this.pElement = pElement;
    }

    public void setAttackBoost(int attackBoost) {
        this.attackBoost = attackBoost;
    }

    public void setAttackBuff(int attackBuff) {
        this.attackBuff = attackBuff;
    }

    public void setExtraAbility(String extraAbility) {
        this.extraAbility = extraAbility;
    }

    public String getExtraAbility() {
        return extraAbility;
    }

    public String getWeaponClass() {
        return weaponClass;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getmElement() {
        return mElement;
    }

    public String getpElement() {
        return pElement;
    }

    public int getAttackBoost() {
        return attackBoost;
    }

    public int getAttackBuff() {
        return attackBuff;
    }





}
