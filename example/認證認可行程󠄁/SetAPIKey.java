import mskyj.Misskey;

class SetAPIKey {
	public static void main(String[] args) {
		final String APIKEY = "THIS_IS_APIKEY";

		MisskeyClient cli = new MisskeyClient.Builder()
			.setInstanceDomainName("misskey.xyz")
			.setAPIKey(APIKEY)
			.build();

		System.out.println(msky.getAPIKey());
	}
}
