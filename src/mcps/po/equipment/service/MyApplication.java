package mcps.po.equipment.service;

import com.sun.jersey.api.core.PackagesResourceConfig;

public class MyApplication extends PackagesResourceConfig {
	public MyApplication() {
        super("mcps.po.equipment.rest");
    }
}
