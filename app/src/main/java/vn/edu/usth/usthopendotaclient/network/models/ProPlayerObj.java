package vn.edu.usth.usthopendotaclient.network.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProPlayerObj implements Serializable {

	@SerializedName("profileurl")
	private String profileurl;

	@SerializedName("is_locked")
	private boolean isLocked;

	@SerializedName("last_login")
	private Object lastLogin;

	@SerializedName("fantasy_role")
	private int fantasyRole;

	@SerializedName("avatarfull")
	private String avatarfull;

	@SerializedName("fh_unavailable")
	private boolean fhUnavailable;

	@SerializedName("team_tag")
	private String teamTag;

	@SerializedName("avatarmedium")
	private String avatarmedium;

	@SerializedName("locked_until")
	private Object lockedUntil;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("team_id")
	private int teamId;

	@SerializedName("personaname")
	private String personaname;

	@SerializedName("plus")
	private boolean plus;

	@SerializedName("team_name")
	private String teamName;

	@SerializedName("full_history_time")
	private String fullHistoryTime;

	@SerializedName("cheese")
	private int cheese;

	@SerializedName("steamid")
	private String steamid;

	@SerializedName("last_match_time")
	private String lastMatchTime;

	@SerializedName("country_code")
	private String countryCode;

	@SerializedName("account_id")
	private int accountId;

	@SerializedName("is_pro")
	private boolean isPro;

	@SerializedName("name")
	private String name;

	@SerializedName("loccountrycode")
	private String loccountrycode;

	@SerializedName("isFavorited")
	private boolean isFavorited;

	public boolean isFavorited() {
		return isFavorited;
	}

	public void setFavorited(boolean favorited) {
		isFavorited = favorited;
	}

	public void setProfileurl(String profileurl){
		this.profileurl = profileurl;
	}

	public String getProfileurl(){
		return profileurl;
	}

	public void setIsLocked(boolean isLocked){
		this.isLocked = isLocked;
	}

	public boolean isIsLocked(){
		return isLocked;
	}

	public void setLastLogin(Object lastLogin){
		this.lastLogin = lastLogin;
	}

	public Object getLastLogin(){
		return lastLogin;
	}

	public void setFantasyRole(int fantasyRole){
		this.fantasyRole = fantasyRole;
	}

	public int getFantasyRole(){
		return fantasyRole;
	}

	public void setAvatarfull(String avatarfull){
		this.avatarfull = avatarfull;
	}

	public String getAvatarfull(){
		return avatarfull;
	}

	public void setFhUnavailable(boolean fhUnavailable){
		this.fhUnavailable = fhUnavailable;
	}

	public boolean isFhUnavailable(){
		return fhUnavailable;
	}

	public void setTeamTag(String teamTag){
		this.teamTag = teamTag;
	}

	public String getTeamTag(){
		return teamTag;
	}

	public void setAvatarmedium(String avatarmedium){
		this.avatarmedium = avatarmedium;
	}

	public String getAvatarmedium(){
		return avatarmedium;
	}

	public void setLockedUntil(Object lockedUntil){
		this.lockedUntil = lockedUntil;
	}

	public Object getLockedUntil(){
		return lockedUntil;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return avatar;
	}

	public void setTeamId(int teamId){
		this.teamId = teamId;
	}

	public int getTeamId(){
		return teamId;
	}

	public void setPersonaname(String personaname){
		this.personaname = personaname;
	}

	public String getPersonaname(){
		return personaname;
	}

	public void setPlus(boolean plus){
		this.plus = plus;
	}

	public boolean isPlus(){
		return plus;
	}

	public void setTeamName(String teamName){
		this.teamName = teamName;
	}

	public String getTeamName(){
		return teamName;
	}

	public void setFullHistoryTime(String fullHistoryTime){
		this.fullHistoryTime = fullHistoryTime;
	}

	public String getFullHistoryTime(){
		return fullHistoryTime;
	}

	public void setCheese(int cheese){
		this.cheese = cheese;
	}

	public int getCheese(){
		return cheese;
	}

	public void setSteamid(String steamid){
		this.steamid = steamid;
	}

	public String getSteamid(){
		return steamid;
	}

	public void setLastMatchTime(String lastMatchTime){
		this.lastMatchTime = lastMatchTime;
	}

	public String getLastMatchTime(){
		return lastMatchTime;
	}

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public void setAccountId(int accountId){
		this.accountId = accountId;
	}

	public int getAccountId(){
		return accountId;
	}

	public void setIsPro(boolean isPro){
		this.isPro = isPro;
	}

	public boolean isIsPro(){
		return isPro;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLoccountrycode(String loccountrycode){
		this.loccountrycode = loccountrycode;
	}

	public String getLoccountrycode(){
		return loccountrycode;
	}

	@Override
	public String toString() {
		return "PlayerObj{" +
				"name='" + name + '\'' +
				'}';
	}
}