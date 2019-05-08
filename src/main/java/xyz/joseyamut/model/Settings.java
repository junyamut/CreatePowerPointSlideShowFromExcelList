package xyz.joseyamut.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Settings {
    @SerializedName("app")
    @Expose
    private App app;
    @SerializedName("presentation")
    @Expose
    private Presentation presentation;

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

	public Presentation getPresentation() {
		return presentation;
	}

	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
	}
}