import mskyj.Misskey;

class SetAPIKey {
	public static void main(String[] args) {
		final String APIKEY = "THIS_IS_APIKEY";

		Misskey msky = new Misskey(APIKEY);

		System.out.println(msky.getAPIKey());
	}
}
