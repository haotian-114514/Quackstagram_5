import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRelationshipManager {

    private final String followersFilePath = "data/following.txt";

    public UserRelationshipManager() {
    }

    // Method to follow a user, and record in followers.txt file
    public void followUser(String follower, String followed) throws IOException {
        if (!isAlreadyFollowing(follower, followed)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(followersFilePath, true))) {
                writer.write(follower + ":" + followed);
                writer.newLine();
            }
        }
    }

    // Method to check if a user is already following another user
    private boolean isAlreadyFollowing(String follower, String followed) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(followersFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(follower + ":" + followed)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Method to get the list of followers for a user
    public List<String> getFollowers(String username) throws IOException {
        List<String> followers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(followersFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[1].equals(username)) {
                    followers.add(parts[0]);
                }
            }
        }
        return followers;
    }

    public boolean  checkFollowers(List<String> followers, String username) throws IOException {
        while(followers.iterator() != null){
            if(!followers.iterator().equals(username)){
                System.out.print("follow success");
                return true;
            }
        }
        return false;
    }
}
