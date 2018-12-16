package mskyj.data;

import java.util.Map;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import mskyj.util.annotation.Secret;
import mskyj.util.json.JSONManager;

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

	public String generateJSONText() {
		return JSONManager.encodeFromMap(parameter).toString();
	}
}
