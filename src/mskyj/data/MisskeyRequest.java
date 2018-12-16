package mskyj.data;

import static java.util.Objects.isNull;
import mskyj.util.exception.NotBuildableException;

public class MisskeyRequest {
	private String endpoint;
	private boolean apiKeyRequired;
	private Parameter parameter;

	private MisskeyRequest(String endpoint, boolean apiKeyRequired) {
		this.endpoint = endpoint;
		this.apiKeyRequired = apiKeyRequired;
		this.parameter = new Parameter();
	}

	private MisskeyRequest(String endpoint, boolean apiKeyRequired, Parameter parameter) {
			this.endpoint = endpoint;
			this.apiKeyRequired = apiKeyRequired;
			this.parameter = parameter;
	}

	public static class Builder {
		private String endpoint;
		private boolean apiKeyRequired;
		private Parameter parameter;

		public Builder() {
			this.apiKeyRequired = false;
		}

		public Builder setEndpoint(String endpoint) {
			this.endpoint = endpoint;
			return this;
		}

		public Builder setParameter(Parameter parameter) {
			this.parameter = parameter;
			return this;
		}

		public Builder setAPIKey() {
			this.apiKeyRequired = true;
			return this;
		}

		public MisskeyRequest build() throws NotBuildableException {
			if (
				isNull(endpoint) ||
				isNull(apiKeyRequired)
			)
				throw new NotBuildableException();

			return isNull(parameter) ?
				new MisskeyRequest(endpoint, apiKeyRequired) :
				new MisskeyRequest(endpoint, apiKeyRequired, parameter);
		}
	}

	public String getEndpoint() {
		return endpoint;
	}

	public boolean isAPIKeyRequired() {
		return apiKeyRequired;
	}

	public Parameter getParameter() {
		return parameter;
	}
}
