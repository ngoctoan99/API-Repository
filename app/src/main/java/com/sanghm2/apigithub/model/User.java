package com.sanghm2.apigithub.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private String login;
    private long id;
    private String nodeID;
    private String avatar_url;
    private String gravatarID;
    private String url;
    private String html_url;
    private String followersURL;
    private String followingURL;
    private String gistsURL;
    private String starredURL;
    private String subscriptionsURL;
    private String organizationsURL;
    private String reposURL;
    private String eventsURL;
    private String receivedEventsURL;
    private String type;
    private boolean siteAdmin;
    private String name;
    private Object company;
    private String blog;
    private Object location;
    private Object email;
    private Object hireable;
    private String bio;
    private Object twitterUsername;
    private long publicRepos;
    private long publicGists;
    private long followers;
    private long following;
    private String createdAt;
    private String updatedAt;

    @JsonProperty("login")
    public String getLogin() { return login; }
    @JsonProperty("login")
    public void setLogin(String value) { this.login = value; }

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("node_id")
    public String getNodeID() { return nodeID; }
    @JsonProperty("node_id")
    public void setNodeID(String value) { this.nodeID = value; }

    @JsonProperty("avatar_url")
    public String getAvatarURL() { return avatar_url; }
    @JsonProperty("avatar_url")
    public void setAvatarURL(String value) { this.avatar_url = value; }

    @JsonProperty("gravatar_id")
    public String getGravatarID() { return gravatarID; }
    @JsonProperty("gravatar_id")
    public void setGravatarID(String value) { this.gravatarID = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("html_url")
    public String getHTMLURL() { return html_url; }
    @JsonProperty("html_url")
    public void setHTMLURL(String value) { this.html_url = value; }

    @JsonProperty("followers_url")
    public String getFollowersURL() { return followersURL; }
    @JsonProperty("followers_url")
    public void setFollowersURL(String value) { this.followersURL = value; }

    @JsonProperty("following_url")
    public String getFollowingURL() { return followingURL; }
    @JsonProperty("following_url")
    public void setFollowingURL(String value) { this.followingURL = value; }

    @JsonProperty("gists_url")
    public String getGistsURL() { return gistsURL; }
    @JsonProperty("gists_url")
    public void setGistsURL(String value) { this.gistsURL = value; }

    @JsonProperty("starred_url")
    public String getStarredURL() { return starredURL; }
    @JsonProperty("starred_url")
    public void setStarredURL(String value) { this.starredURL = value; }

    @JsonProperty("subscriptions_url")
    public String getSubscriptionsURL() { return subscriptionsURL; }
    @JsonProperty("subscriptions_url")
    public void setSubscriptionsURL(String value) { this.subscriptionsURL = value; }

    @JsonProperty("organizations_url")
    public String getOrganizationsURL() { return organizationsURL; }
    @JsonProperty("organizations_url")
    public void setOrganizationsURL(String value) { this.organizationsURL = value; }

    @JsonProperty("repos_url")
    public String getReposURL() { return reposURL; }
    @JsonProperty("repos_url")
    public void setReposURL(String value) { this.reposURL = value; }

    @JsonProperty("events_url")
    public String getEventsURL() { return eventsURL; }
    @JsonProperty("events_url")
    public void setEventsURL(String value) { this.eventsURL = value; }

    @JsonProperty("received_events_url")
    public String getReceivedEventsURL() { return receivedEventsURL; }
    @JsonProperty("received_events_url")
    public void setReceivedEventsURL(String value) { this.receivedEventsURL = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("site_admin")
    public boolean getSiteAdmin() { return siteAdmin; }
    @JsonProperty("site_admin")
    public void setSiteAdmin(boolean value) { this.siteAdmin = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("company")
    public Object getCompany() { return company; }
    @JsonProperty("company")
    public void setCompany(Object value) { this.company = value; }

    @JsonProperty("blog")
    public String getBlog() { return blog; }
    @JsonProperty("blog")
    public void setBlog(String value) { this.blog = value; }

    @JsonProperty("location")
    public Object getLocation() { return location; }
    @JsonProperty("location")
    public void setLocation(Object value) { this.location = value; }

    @JsonProperty("email")
    public Object getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(Object value) { this.email = value; }

    @JsonProperty("hireable")
    public Object getHireable() { return hireable; }
    @JsonProperty("hireable")
    public void setHireable(Object value) { this.hireable = value; }

    @JsonProperty("bio")
    public String getBio() { return bio; }
    @JsonProperty("bio")
    public void setBio(String value) { this.bio = value; }

    @JsonProperty("twitter_username")
    public Object getTwitterUsername() { return twitterUsername; }
    @JsonProperty("twitter_username")
    public void setTwitterUsername(Object value) { this.twitterUsername = value; }

    @JsonProperty("public_repos")
    public long getPublicRepos() { return publicRepos; }
    @JsonProperty("public_repos")
    public void setPublicRepos(long value) { this.publicRepos = value; }

    @JsonProperty("public_gists")
    public long getPublicGists() { return publicGists; }
    @JsonProperty("public_gists")
    public void setPublicGists(long value) { this.publicGists = value; }

    @JsonProperty("followers")
    public long getFollowers() { return followers; }
    @JsonProperty("followers")
    public void setFollowers(long value) { this.followers = value; }

    @JsonProperty("following")
    public long getFollowing() { return following; }
    @JsonProperty("following")
    public void setFollowing(long value) { this.following = value; }

    @JsonProperty("created_at")
    public String getCreatedAt() { return createdAt; }
    @JsonProperty("created_at")
    public void setCreatedAt(String value) { this.createdAt = value; }

    @JsonProperty("updated_at")
    public String getUpdatedAt() { return updatedAt; }
    @JsonProperty("updated_at")
    public void setUpdatedAt(String value) { this.updatedAt = value; }
}
