package vn.edu.usth.usthopendotaclient.Search.Model;

public class players {
    private int solo_competitive_rank;
    private int competitive_rank;
    private int rank_tier;
    private int leaderboard_rank;
    private mmr_estimate mmr_estimate;
    private profiles profile;

    public players(int solo_competitive_rank, int competitive_rank, int rank_tier, int leaderboard_rank, vn.edu.usth.usthopendotaclient.Search.Model.mmr_estimate mmr_estimate, profiles profile) {
        this.solo_competitive_rank = solo_competitive_rank;
        this.competitive_rank = competitive_rank;
        this.rank_tier = rank_tier;
        this.leaderboard_rank = leaderboard_rank;
        this.mmr_estimate = mmr_estimate;
        this.profile = profile;
    }

    public int getSolo_competitive_rank() {
        return solo_competitive_rank;
    }

    public void setSolo_competitive_rank(int solo_competitive_rank) {
        this.solo_competitive_rank = solo_competitive_rank;
    }

    public int getCompetitive_rank() {
        return competitive_rank;
    }

    public void setCompetitive_rank(int competitive_rank) {
        this.competitive_rank = competitive_rank;
    }

    public int getRank_tier() {
        return rank_tier;
    }

    public void setRank_tier(int rank_tier) {
        this.rank_tier = rank_tier;
    }

    public int getLeaderboard_rank() {
        return leaderboard_rank;
    }

    public void setLeaderboard_rank(int leaderboard_rank) {
        this.leaderboard_rank = leaderboard_rank;
    }

    public vn.edu.usth.usthopendotaclient.Search.Model.mmr_estimate getMmr_estimate() {
        return mmr_estimate;
    }

    public void setMmr_estimate(vn.edu.usth.usthopendotaclient.Search.Model.mmr_estimate mmr_estimate) {
        this.mmr_estimate = mmr_estimate;
    }

    public profiles getProfile() {
        return profile;
    }

    public void setProfile(profiles profile) {
        this.profile = profile;
    }
}
