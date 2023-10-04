package vn.edu.usth.usthopendotaclient.Search.Model;

public class profiles {
    private int account_id;
    private String personaname;
    private String name;
    private boolean plus;
    private int cheese;
    private String steamid;
    private String avatar;
    private String avatarmedium;
    private String avatarfull;
    private String profileurl;
    private String last_login;
    private String loccountrycode;
    private String status;
    private boolean is_contributor;
    private boolean is_subscriber;

    public profiles(int account_id, String personaname, String name, boolean plus, int cheese, String steamid, String avatar, String avatarmedium, String avatarfull, String profileurl, String last_login, String loccountrycode, String status, boolean is_contributor, boolean is_subscriber) {
        this.account_id = account_id;
        this.personaname = personaname;
        this.name = name;
        this.plus = plus;
        this.cheese = cheese;
        this.steamid = steamid;
        this.avatar = avatar;
        this.avatarmedium = avatarmedium;
        this.avatarfull = avatarfull;
        this.profileurl = profileurl;
        this.last_login = last_login;
        this.loccountrycode = loccountrycode;
        this.status = status;
        this.is_contributor = is_contributor;
        this.is_subscriber = is_subscriber;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getPersonaname() {
        return personaname;
    }

    public void setPersonaname(String personaname) {
        this.personaname = personaname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPlus() {
        return plus;
    }

    public void setPlus(boolean plus) {
        this.plus = plus;
    }

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    public String getSteamid() {
        return steamid;
    }

    public void setSteamid(String steamid) {
        this.steamid = steamid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarmedium() {
        return avatarmedium;
    }

    public void setAvatarmedium(String avatarmedium) {
        this.avatarmedium = avatarmedium;
    }

    public String getAvatarfull() {
        return avatarfull;
    }

    public void setAvatarfull(String avatarfull) {
        this.avatarfull = avatarfull;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getLoccountrycode() {
        return loccountrycode;
    }

    public void setLoccountrycode(String loccountrycode) {
        this.loccountrycode = loccountrycode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isIs_contributor() {
        return is_contributor;
    }

    public void setIs_contributor(boolean is_contributor) {
        this.is_contributor = is_contributor;
    }

    public boolean isIs_subscriber() {
        return is_subscriber;
    }

    public void setIs_subscriber(boolean is_subscriber) {
        this.is_subscriber = is_subscriber;
    }
}
