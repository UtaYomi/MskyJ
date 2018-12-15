package mskyj.data;

import java.util.Objects;
import mskyj.util.annotation.Secret;
import mskyj.util.exception.NotBuildableException;

public class APIKey {
	private String apiKey;

	private APIKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public static class Builder {
		private String apiKey;

		public Builder setAPIKey(String apiKey) {
			this.apiKey = apiKey;
			return this;
		}

		@Secret
		public String getAPIKey() {
			return apiKey;
		}

		public APIKey build() throws NotBuildableException {
			if (Objects.isNull(apiKey))
				throw new NotBuildableException();
			return new APIKey(apiKey);
		}
	}

	@Secret
	public String getAPIKey() {
		return apiKey;
	}
}
