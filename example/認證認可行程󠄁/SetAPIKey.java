import mskyj.util.exception.NotBuildableException;
import mskyj.Misskey;
import mskyj.data.APIKey;

class SetAPIKey {
	public static void main(String[] args) {
		final String APIKEY = "THIS_IS_APIKEY";

		try {
			Misskey msky = new Misskey.Builder()
				.setAPIKey(
					new APIKey.Builder()
						.setAPIKey(APIKEY)
						.build()
				)
				.build();

			System.out.println(msky.getAPIKey().getAPIKey());
		} catch (NotBuildableException nbe) {
			nbe.printStackTrace();
		}
	}
}
