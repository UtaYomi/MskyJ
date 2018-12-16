package mskyj.auth;

import mskyj;

abstract class MisskeyClientFactory {
	private String apiKey;

	public MisskeyClient getInstance() {
		return new MisskeyClient(apiKey);
	}
}
