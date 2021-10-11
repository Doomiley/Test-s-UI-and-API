package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String login;
    private Integer id;
    private String avatar_url;
    private String node_id;
    private String gravatar_id;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private Boolean site_admin;
    private String name;
    private String blog;
    private String location;
    private String email;
    private String hireable;
    private String bio;
    private Integer public_repos;
    private Integer public_gists;
    private Integer followers;
    private Integer following;
    private String created_at;
    private String updated_at;
}