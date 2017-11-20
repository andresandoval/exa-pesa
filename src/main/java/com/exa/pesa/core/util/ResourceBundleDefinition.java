package com.exa.pesa.core.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres on 9/10/2017.
 */
public enum ResourceBundleDefinition {

    MESSAGES("messages");


    private String baseName;
    private final String pathPrefix = "/i18n/";

    ResourceBundleDefinition(String resourcePath) {
        this.baseName = resourcePath;
    }

    public String getFullPath() {
        StringBuffer pathBuffer = new StringBuffer();
        pathBuffer.append(this.pathPrefix);
        pathBuffer.append(this.baseName);
        return pathBuffer.toString();
    }

    public static final List<String> getResourceBundleBaseNames() {
        final List<String> bundleFiles = new ArrayList<>();
        for (ResourceBundleDefinition rbd : ResourceBundleDefinition.values()) {
            bundleFiles.add(rbd.getFullPath());
        }
        return bundleFiles;
    }
}
