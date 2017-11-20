package com.exa.pesa.core.util;

import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Created by Andres on 9/10/2017.
 */
public class ResourceBundleFactory {

    private final List<String> resourceBundleFiles;
    private ResourceBundle resourceBundle;


    public ResourceBundleFactory() {
        super();
        resourceBundleFiles = ResourceBundleDefinition.getResourceBundleBaseNames();
        resourceBundle = getResourceBundle();
    }

    private ResourceBundle getResourceBundle() {
        if (Objects.isNull(this.resourceBundleFiles))
            return null;
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(resourceBundleFiles.toArray(new String[resourceBundleFiles.size()]));
        return new MessageSourceResourceBundle(messageSource, Locale.getDefault());
    }

    public String getText(String bundleKey, Object... parameters) {
        if (Objects.isNull(bundleKey) || Objects.isNull(this.resourceBundle) || !this.resourceBundle.containsKey(bundleKey))
            return bundleKey;
        String boundleValue = this.resourceBundle.getString(bundleKey);
        if(parameters.length <= 0)
            return boundleValue;
        return String.format(boundleValue, parameters);
    }

}
