package models;

public class User {

    private Long id;

    private String Login;

    private String password;

    private String posts;

    public User() {
    }

    public User(Long id, String login, String password, String posts) {
        this.id = id;
        Login = login;
        this.password = password;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosts() {
        return posts;
    }

    public void setPosts(String posts) {
        this.posts = posts;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Login='" + Login + '\'' +
                ", password='" + password + '\'' +
                ", posts='" + posts + '\'' +
                '}';
    }
}
