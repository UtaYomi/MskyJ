package mskyj;

import java.util.Objects;
import mskyj.util.annotation.Secret;
import mskyj.util.exception.NotBuildableException;
import mskyj.data.APIKey;

public class Misskey {
	private APIKey apiKey;

	private Misskey(APIKey apiKey) {
		this.apiKey = apiKey;
	}

	public static class Builder {
		private APIKey apiKey;

		public Builder setAPIKey(APIKey apiKey) {
			this.apiKey = apiKey;
			return this;
		}

		@Secret
		public APIKey getAPIKey() {
			return apiKey;
		}

		public Misskey build() throws NotBuildableException {
			if (Objects.isNull(apiKey))
				throw new NotBuildableException();
			return new Misskey(apiKey);
		}
	}

	@Secret
	public APIKey getAPIKey() {
		return apiKey;
	}
}
