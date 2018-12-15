package mskyj.data;

import java.util.Map;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import mskyj.util.annotation.Secret;

public class Parameter {
	private Map<String, String> parameter;

	public Parameter() {
		parameter = new LinkedHashMap<>();
	}

	public Parameter put(Object key, Object value) {
		parameter.put(key.toString(), value.toString());
		return this;
	}

	@Secret
	public Map<String, String> getParameter() {
		return parameter;
	}

	@Override
	public String toString() {
		if (parameter.isEmpty())
			return "";

		String text = "";
		for (Entry<String, String> entry : parameter.entrySet())
			text += "&" + entry.toString();

		return text.substring(1);
	}
}
