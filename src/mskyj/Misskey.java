package mskyj;

import java.util.Objects;
import mskyj.util.annotation.Secret;
import mskyj.util.exception.NotBuildableException;
import mskyj.data.*;
import mskyj.exception.MisskeyException;

public class Misskey {
	private String apiKey;

	public Misskey(String apiKey) {
		this.apiKey = apiKey;
	}

	@Secret
	public String getAPIKey() {
		return apiKey;
	}

	public String request(String endpoint, Parameter parameter) {
		return "";
	}
}
