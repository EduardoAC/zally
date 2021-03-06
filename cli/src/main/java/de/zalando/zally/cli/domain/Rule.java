package de.zalando.zally.cli.domain;

import org.json.JSONObject;

public class Rule {
    private String title;
    private String code;
    private String type;
    private String url;
    private Boolean isActive;

    public Rule(final String title, final String code, final String type) {
        this.title = title;
        this.code = code;
        this.type = type;
    }

    public Rule(final JSONObject ruleJson) {
        title = ruleJson.getString("title");
        code = ruleJson.getString("code");
        type = ruleJson.getString("type");
        url = ruleJson.getString("url");
        isActive = ruleJson.getBoolean("is_active");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

}
