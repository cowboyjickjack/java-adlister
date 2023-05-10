package models;

public class Post {

    private String title;
    private String post;

    private String[] topics;

    public Post(String title, String post, String[] topics) {
        this.title = title;
        this.post = post;
        this.topics = topics;
    }

    public String[] getTopics() {
        return topics;
    }

    public void setTopics(String[] topics) {
        this.topics = topics;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Post() {
    }
}
