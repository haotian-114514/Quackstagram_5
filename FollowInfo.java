public class FollowInfo{

    private String follower;
    private String followed;

    FollowInfo(String follower,String followed){
        this.followed=followed;
        this.follower=follower;
    }


    public String getFollower(){
        return follower;
    }
    public String getFollowed(){
        return followed;
    }
}