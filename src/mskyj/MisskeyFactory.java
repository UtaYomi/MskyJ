package mskyj;

abstract class MisskeyFactory {
	private String apiKey;

	public Misskey getInstance() {
		return new Misskey(apiKey);
	}
}
