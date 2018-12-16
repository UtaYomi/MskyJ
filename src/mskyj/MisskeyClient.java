package mskyj;

import static java.util.Objects.isNull;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.io.IOException;
import mskyj.util.annotation.Secret;
import mskyj.util.exception.NotBuildableException;
import mskyj.data.*;
import mskyj.exception.*;

public class MisskeyClient {
	private String instanceDomainName;
	private String apiKey;

	private MisskeyClient(String instanceDomainName, String apiKey) {
		this.instanceDomainName = instanceDomainName;
		this.apiKey = apiKey;
	}

	public static class Builder {
		private String instanceDomainName;
		private String apiKey;

		public Builder setInstanceDomainName(String instanceDomainName) {
			this.instanceDomainName = instanceDomainName;
			return this;
		}

		public Builder setAPIKey(String apiKey) {
			this.apiKey = apiKey;
			return this;
		}

		public MisskeyClient build() throws NotBuildableException {
			if (
				isNull(instanceDomainName) ||
				isNull(apiKey)
			)
				throw new NotBuildableException();

			return new MisskeyClient(instanceDomainName, apiKey);
		}
	}

	@Secret
	public String getAPIKey() {
		return apiKey;
	}

	public String request(MisskeyRequest misskeyRequest) throws MisskeyClientRequestException {
		Parameter parameter = misskeyRequest.getParameter();
		if (misskeyRequest.isAPIKeyRequired())
			parameter.put("i", apiKey);

		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create("https://" + instanceDomainName + "/api/" + misskeyRequest.getEndpoint()))
			//.header("Content-Type", "application/json")
			.POST(BodyPublishers.ofString(parameter.generateJSONText()))
			.build();

		HttpClient client = HttpClient.newHttpClient();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			// swtich rescode
			return response.body();
		} catch (IOException | InterruptedException ioe) {
			throw new MisskeyClientRequestException();
		}
	}
}
