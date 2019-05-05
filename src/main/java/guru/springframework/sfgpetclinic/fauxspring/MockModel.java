package guru.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

public class MockModel implements Model {

    private Map<String, Object> model = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        model.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {

    }

    public Map<String, Object> getModel() {
        return model;
    }
}
