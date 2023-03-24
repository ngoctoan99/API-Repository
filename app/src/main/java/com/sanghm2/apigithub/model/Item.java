package com.sanghm2.apigithub.model;

import androidx.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import retrofit2.converter.gson.GsonConverterFactory;

public class Item {
    private long id;
    private String nodeID;
    private String name;
    private String full_name;

    private boolean itemPrivate;

    private Owner owner;
    private String html_url;
    private Object description;
    private boolean fork;
    private String url;
    private String forksURL;
    private String keysURL;
    private String collaboratorsURL;
    private String teamsURL;
    private String hooksURL;
    private String issueEventsURL;
    private String eventsURL;
    private String assigneesURL;
    private String branchesURL;
    private String tagsURL;
    private String blobsURL;
    private String gitTagsURL;
    private String gitRefsURL;
    private String treesURL;
    private String statusesURL;
    private String languagesURL;
    private String stargazersURL;
    private String contributorsURL;
    private String subscribersURL;
    private String subscriptionURL;
    private String commitsURL;
    private String gitCommitsURL;
    private String commentsURL;
    private String issueCommentURL;
    private String contentsURL;
    private String compareURL;
    private String mergesURL;
    private String archiveURL;
    private String downloadsURL;
    private String issuesURL;
    private String pullsURL;
    private String milestonesURL;
    private String notificationsURL;
    private String labelsURL;
    private String releasesURL;
    private String deploymentsURL;
    private String created_at;
    private String updated_at;
    private String pushed_at;
    private String gitURL;
    private String sshURL;
    private String cloneURL;
    private String svnURL;
    private Object homepage;
    private long size;
    private long stargazersCount;
    private long watchersCount;
    private String language;
    private boolean hasIssues;
    private boolean hasProjects;
    private boolean hasDownloads;
    private boolean hasWiki;
    private boolean hasPages;
    private boolean hasDiscussions;
    private long forksCount;
    private Object mirrorURL;
    private boolean archived;
    private boolean disabled;
    private long openIssuesCount;
    private Object license;
    private boolean allowForking;
    private boolean isTemplate;
    private boolean webCommitSignoffRequired;
    private Object[] topics;
    private String visibility;
    private long forks;
    private long openIssues;
    private long watchers;
    private String defaultBranch;


    public static List<Item> FromJson(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            Gson gson = new Gson();
            return gson.fromJson(jsonObject.getString("items"), new TypeToken<List<Item>>() {
            }.getType());
        } catch (JSONException jse) {
            jse.printStackTrace();
        }
        return new ArrayList<>();
    }
    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("node_id")
    public String getNodeID() { return nodeID; }
    @JsonProperty("node_id")
    public void setNodeID(String value) { this.nodeID = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("full_name")
    public String getFullName() { return full_name; }
    @JsonProperty("full_name")
    public void setFullName(String value) { this.full_name = value; }

    @JsonProperty("private")
    public boolean getItemPrivate() { return itemPrivate; }
    @JsonProperty("private")
    public void setItemPrivate(boolean value) { this.itemPrivate = value; }

    @JsonProperty("owner")
    public Owner getOwner() { return owner; }
    @JsonProperty("owner")
    public void setOwner(Owner value) { this.owner = value; }

    @JsonProperty("html_url")
    public String getHTMLURL() { return html_url; }
    @JsonProperty("html_url")
    public void setHTMLURL(String value) { this.html_url = value; }

    @JsonProperty("description")
    public Object getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(Object value) { this.description = value; }

    @JsonProperty("fork")
    public boolean getFork() { return fork; }
    @JsonProperty("fork")
    public void setFork(boolean value) { this.fork = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("forks_url")
    public String getForksURL() { return forksURL; }
    @JsonProperty("forks_url")
    public void setForksURL(String value) { this.forksURL = value; }

    @JsonProperty("keys_url")
    public String getKeysURL() { return keysURL; }
    @JsonProperty("keys_url")
    public void setKeysURL(String value) { this.keysURL = value; }

    @JsonProperty("collaborators_url")
    public String getCollaboratorsURL() { return collaboratorsURL; }
    @JsonProperty("collaborators_url")
    public void setCollaboratorsURL(String value) { this.collaboratorsURL = value; }

    @JsonProperty("teams_url")
    public String getTeamsURL() { return teamsURL; }
    @JsonProperty("teams_url")
    public void setTeamsURL(String value) { this.teamsURL = value; }

    @JsonProperty("hooks_url")
    public String getHooksURL() { return hooksURL; }
    @JsonProperty("hooks_url")
    public void setHooksURL(String value) { this.hooksURL = value; }

    @JsonProperty("issue_events_url")
    public String getIssueEventsURL() { return issueEventsURL; }
    @JsonProperty("issue_events_url")
    public void setIssueEventsURL(String value) { this.issueEventsURL = value; }

    @JsonProperty("events_url")
    public String getEventsURL() { return eventsURL; }
    @JsonProperty("events_url")
    public void setEventsURL(String value) { this.eventsURL = value; }

    @JsonProperty("assignees_url")
    public String getAssigneesURL() { return assigneesURL; }
    @JsonProperty("assignees_url")
    public void setAssigneesURL(String value) { this.assigneesURL = value; }

    @JsonProperty("branches_url")
    public String getBranchesURL() { return branchesURL; }
    @JsonProperty("branches_url")
    public void setBranchesURL(String value) { this.branchesURL = value; }

    @JsonProperty("tags_url")
    public String getTagsURL() { return tagsURL; }
    @JsonProperty("tags_url")
    public void setTagsURL(String value) { this.tagsURL = value; }

    @JsonProperty("blobs_url")
    public String getBlobsURL() { return blobsURL; }
    @JsonProperty("blobs_url")
    public void setBlobsURL(String value) { this.blobsURL = value; }

    @JsonProperty("git_tags_url")
    public String getGitTagsURL() { return gitTagsURL; }
    @JsonProperty("git_tags_url")
    public void setGitTagsURL(String value) { this.gitTagsURL = value; }

    @JsonProperty("git_refs_url")
    public String getGitRefsURL() { return gitRefsURL; }
    @JsonProperty("git_refs_url")
    public void setGitRefsURL(String value) { this.gitRefsURL = value; }

    @JsonProperty("trees_url")
    public String getTreesURL() { return treesURL; }
    @JsonProperty("trees_url")
    public void setTreesURL(String value) { this.treesURL = value; }

    @JsonProperty("statuses_url")
    public String getStatusesURL() { return statusesURL; }
    @JsonProperty("statuses_url")
    public void setStatusesURL(String value) { this.statusesURL = value; }

    @JsonProperty("languages_url")
    public String getLanguagesURL() { return languagesURL; }
    @JsonProperty("languages_url")
    public void setLanguagesURL(String value) { this.languagesURL = value; }

    @JsonProperty("stargazers_url")
    public String getStargazersURL() { return stargazersURL; }
    @JsonProperty("stargazers_url")
    public void setStargazersURL(String value) { this.stargazersURL = value; }

    @JsonProperty("contributors_url")
    public String getContributorsURL() { return contributorsURL; }
    @JsonProperty("contributors_url")
    public void setContributorsURL(String value) { this.contributorsURL = value; }

    @JsonProperty("subscribers_url")
    public String getSubscribersURL() { return subscribersURL; }
    @JsonProperty("subscribers_url")
    public void setSubscribersURL(String value) { this.subscribersURL = value; }

    @JsonProperty("subscription_url")
    public String getSubscriptionURL() { return subscriptionURL; }
    @JsonProperty("subscription_url")
    public void setSubscriptionURL(String value) { this.subscriptionURL = value; }

    @JsonProperty("commits_url")
    public String getCommitsURL() { return commitsURL; }
    @JsonProperty("commits_url")
    public void setCommitsURL(String value) { this.commitsURL = value; }

    @JsonProperty("git_commits_url")
    public String getGitCommitsURL() { return gitCommitsURL; }
    @JsonProperty("git_commits_url")
    public void setGitCommitsURL(String value) { this.gitCommitsURL = value; }

    @JsonProperty("comments_url")
    public String getCommentsURL() { return commentsURL; }
    @JsonProperty("comments_url")
    public void setCommentsURL(String value) { this.commentsURL = value; }

    @JsonProperty("issue_comment_url")
    public String getIssueCommentURL() { return issueCommentURL; }
    @JsonProperty("issue_comment_url")
    public void setIssueCommentURL(String value) { this.issueCommentURL = value; }

    @JsonProperty("contents_url")
    public String getContentsURL() { return contentsURL; }
    @JsonProperty("contents_url")
    public void setContentsURL(String value) { this.contentsURL = value; }

    @JsonProperty("compare_url")
    public String getCompareURL() { return compareURL; }
    @JsonProperty("compare_url")
    public void setCompareURL(String value) { this.compareURL = value; }

    @JsonProperty("merges_url")
    public String getMergesURL() { return mergesURL; }
    @JsonProperty("merges_url")
    public void setMergesURL(String value) { this.mergesURL = value; }

    @JsonProperty("archive_url")
    public String getArchiveURL() { return archiveURL; }
    @JsonProperty("archive_url")
    public void setArchiveURL(String value) { this.archiveURL = value; }

    @JsonProperty("downloads_url")
    public String getDownloadsURL() { return downloadsURL; }
    @JsonProperty("downloads_url")
    public void setDownloadsURL(String value) { this.downloadsURL = value; }

    @JsonProperty("issues_url")
    public String getIssuesURL() { return issuesURL; }
    @JsonProperty("issues_url")
    public void setIssuesURL(String value) { this.issuesURL = value; }

    @JsonProperty("pulls_url")
    public String getPullsURL() { return pullsURL; }
    @JsonProperty("pulls_url")
    public void setPullsURL(String value) { this.pullsURL = value; }

    @JsonProperty("milestones_url")
    public String getMilestonesURL() { return milestonesURL; }
    @JsonProperty("milestones_url")
    public void setMilestonesURL(String value) { this.milestonesURL = value; }

    @JsonProperty("notifications_url")
    public String getNotificationsURL() { return notificationsURL; }
    @JsonProperty("notifications_url")
    public void setNotificationsURL(String value) { this.notificationsURL = value; }

    @JsonProperty("labels_url")
    public String getLabelsURL() { return labelsURL; }
    @JsonProperty("labels_url")
    public void setLabelsURL(String value) { this.labelsURL = value; }

    @JsonProperty("releases_url")
    public String getReleasesURL() { return releasesURL; }
    @JsonProperty("releases_url")
    public void setReleasesURL(String value) { this.releasesURL = value; }

    @JsonProperty("deployments_url")
    public String getDeploymentsURL() { return deploymentsURL; }
    @JsonProperty("deployments_url")
    public void setDeploymentsURL(String value) { this.deploymentsURL = value; }

    @JsonProperty("created_at")
    public String getCreatedAt() { return created_at; }
    @JsonProperty("created_at")
    public void setCreatedAt(String value) { this.created_at = value; }

    @JsonProperty("updated_at")
    public String getUpdatedAt() { return updated_at; }
    @JsonProperty("updated_at")
    public void setUpdatedAt(String value) { this.updated_at = value; }

    @JsonProperty("pushed_at")
    public String getPushedAt() { return pushed_at; }
    @JsonProperty("pushed_at")
    public void setPushedAt(String value) { this.pushed_at = value; }

    @JsonProperty("git_url")
    public String getGitURL() { return gitURL; }
    @JsonProperty("git_url")
    public void setGitURL(String value) { this.gitURL = value; }

    @JsonProperty("ssh_url")
    public String getSSHURL() { return sshURL; }
    @JsonProperty("ssh_url")
    public void setSSHURL(String value) { this.sshURL = value; }

    @JsonProperty("clone_url")
    public String getCloneURL() { return cloneURL; }
    @JsonProperty("clone_url")
    public void setCloneURL(String value) { this.cloneURL = value; }

    @JsonProperty("svn_url")
    public String getSvnURL() { return svnURL; }
    @JsonProperty("svn_url")
    public void setSvnURL(String value) { this.svnURL = value; }

    @JsonProperty("homepage")
    public Object getHomepage() { return homepage; }
    @JsonProperty("homepage")
    public void setHomepage(Object value) { this.homepage = value; }

    @JsonProperty("size")
    public long getSize() { return size; }
    @JsonProperty("size")
    public void setSize(long value) { this.size = value; }

    @JsonProperty("stargazers_count")
    public long getStargazersCount() { return stargazersCount; }
    @JsonProperty("stargazers_count")
    public void setStargazersCount(long value) { this.stargazersCount = value; }

    @JsonProperty("watchers_count")
    public long getWatchersCount() { return watchersCount; }
    @JsonProperty("watchers_count")
    public void setWatchersCount(long value) { this.watchersCount = value; }

    @JsonProperty("language")
    public String getLanguage() { return language; }
    @JsonProperty("language")
    public void setLanguage(String value) { this.language = value; }

    @JsonProperty("has_issues")
    public boolean getHasIssues() { return hasIssues; }
    @JsonProperty("has_issues")
    public void setHasIssues(boolean value) { this.hasIssues = value; }

    @JsonProperty("has_projects")
    public boolean getHasProjects() { return hasProjects; }
    @JsonProperty("has_projects")
    public void setHasProjects(boolean value) { this.hasProjects = value; }

    @JsonProperty("has_downloads")
    public boolean getHasDownloads() { return hasDownloads; }
    @JsonProperty("has_downloads")
    public void setHasDownloads(boolean value) { this.hasDownloads = value; }

    @JsonProperty("has_wiki")
    public boolean getHasWiki() { return hasWiki; }
    @JsonProperty("has_wiki")
    public void setHasWiki(boolean value) { this.hasWiki = value; }

    @JsonProperty("has_pages")
    public boolean getHasPages() { return hasPages; }
    @JsonProperty("has_pages")
    public void setHasPages(boolean value) { this.hasPages = value; }

    @JsonProperty("has_discussions")
    public boolean getHasDiscussions() { return hasDiscussions; }
    @JsonProperty("has_discussions")
    public void setHasDiscussions(boolean value) { this.hasDiscussions = value; }

    @JsonProperty("forks_count")
    public long getForksCount() { return forksCount; }
    @JsonProperty("forks_count")
    public void setForksCount(long value) { this.forksCount = value; }

    @JsonProperty("mirror_url")
    public Object getMirrorURL() { return mirrorURL; }
    @JsonProperty("mirror_url")
    public void setMirrorURL(Object value) { this.mirrorURL = value; }

    @JsonProperty("archived")
    public boolean getArchived() { return archived; }
    @JsonProperty("archived")
    public void setArchived(boolean value) { this.archived = value; }

    @JsonProperty("disabled")
    public boolean getDisabled() { return disabled; }
    @JsonProperty("disabled")
    public void setDisabled(boolean value) { this.disabled = value; }

    @JsonProperty("open_issues_count")
    public long getOpenIssuesCount() { return openIssuesCount; }
    @JsonProperty("open_issues_count")
    public void setOpenIssuesCount(long value) { this.openIssuesCount = value; }

    @JsonProperty("license")
    public Object getLicense() { return license; }
    @JsonProperty("license")
    public void setLicense(Object value) { this.license = value; }

    @JsonProperty("allow_forking")
    public boolean getAllowForking() { return allowForking; }
    @JsonProperty("allow_forking")
    public void setAllowForking(boolean value) { this.allowForking = value; }

    @JsonProperty("is_template")
    public boolean getIsTemplate() { return isTemplate; }
    @JsonProperty("is_template")
    public void setIsTemplate(boolean value) { this.isTemplate = value; }

    @JsonProperty("web_commit_signoff_required")
    public boolean getWebCommitSignoffRequired() { return webCommitSignoffRequired; }
    @JsonProperty("web_commit_signoff_required")
    public void setWebCommitSignoffRequired(boolean value) { this.webCommitSignoffRequired = value; }

    @JsonProperty("topics")
    public Object[] getTopics() { return topics; }
    @JsonProperty("topics")
    public void setTopics(Object[] value) { this.topics = value; }

    @JsonProperty("visibility")
    public String getVisibility() { return visibility; }
    @JsonProperty("visibility")
    public void setVisibility(String value) { this.visibility = value; }

    @JsonProperty("forks")
    public long getForks() { return forks; }
    @JsonProperty("forks")
    public void setForks(long value) { this.forks = value; }

    @JsonProperty("open_issues")
    public long getOpenIssues() { return openIssues; }
    @JsonProperty("open_issues")
    public void setOpenIssues(long value) { this.openIssues = value; }

    @JsonProperty("watchers")
    public long getWatchers() { return watchers; }
    @JsonProperty("watchers")
    public void setWatchers(long value) { this.watchers = value; }

    @JsonProperty("default_branch")
    public String getDefaultBranch() { return defaultBranch; }
    @JsonProperty("default_branch")
    public void setDefaultBranch(String value) { this.defaultBranch = value; }
    public static class Owner {
        private String login;
        private long id;
        private String nodeID;
        private String avatar_url;
        private String gravatarID;
        private String url;
        private String htmlURL;
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
        public String getHTMLURL() { return htmlURL; }
        @JsonProperty("html_url")
        public void setHTMLURL(String value) { this.htmlURL = value; }

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

        @NonNull
        @Override
        public String toString() {
            return "Owner{" +
                    "login='" + login + '\'' +
                    ", id=" + id +
                    ", nodeID='" + nodeID + '\'' +
                    ", avatarURL='" + avatar_url + '\'' +
                    ", gravatarID='" + gravatarID + '\'' +
                    ", url='" + url + '\'' +
                    ", htmlURL='" + htmlURL + '\'' +
                    ", followersURL='" + followersURL + '\'' +
                    ", followingURL='" + followingURL + '\'' +
                    ", gistsURL='" + gistsURL + '\'' +
                    ", starredURL='" + starredURL + '\'' +
                    ", subscriptionsURL='" + subscriptionsURL + '\'' +
                    ", organizationsURL='" + organizationsURL + '\'' +
                    ", reposURL='" + reposURL + '\'' +
                    ", eventsURL='" + eventsURL + '\'' +
                    ", receivedEventsURL='" + receivedEventsURL + '\'' +
                    ", type='" + type + '\'' +
                    ", siteAdmin=" + siteAdmin +
                    '}';
        }
    }
}
