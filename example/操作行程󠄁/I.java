import mskyj.util.exception.NotBuildableException;
import mskyj.exception.MisskeyRequestException;
import mskyj.data.MisskeyRequest;
import mskyj.Misskey;

class I {
	public static void main(String[] args) {
		final String APIKEY = "THIS_IS_APIKEY";

		MisskeyClient cli = new MisskeyClient.Builder()
			.setInstanceDomainName("misskey.xyz")
			.setAPIKey(APIKEY)
			.build();

		try {
			System.out.println(
				cli.request(
					new MisskeyRequest.Builder()
						.setEndpoint("notes/create")
						.setAPIKey()
						.build()
				)
			);
		} catch (MisskeyRequestException e) {
			e.printStackTrace();
		}
	}
}
