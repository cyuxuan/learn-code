package club.beenest.blog.entity.blog;

/**
 * 最新推荐博客
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class NewBlog {
    private Long id;
    private String title;
    private String password;
    private Boolean privacy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
    }

    @Override
    public String toString() {
        return "NewBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", password='" + password + '\'' +
                ", privacy=" + privacy +
                '}';
    }
}
