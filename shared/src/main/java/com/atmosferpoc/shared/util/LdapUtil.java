package com.atmosferpoc.shared.util;

import com.atmosferpoc.shared.config.properties.LdapConfigurationProperties;
import lombok.experimental.UtilityClass;

import javax.naming.Context;
import java.util.Properties;

@UtilityClass
public class LdapUtil {
    public static Properties generateLDAPConnectionProperty(String host, String username, String password, LdapConfigurationProperties ldapConfiguration) {
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, ldapConfiguration.getContextFactory());
        env.put(Context.PROVIDER_URL, host);
        env.put(Context.SECURITY_PRINCIPAL, username);
        env.put(Context.SECURITY_CREDENTIALS, password);
        env.put(ldapConfiguration.getConnectionTimeoutProperty(), ldapConfiguration.getConnectionMaxInterval());
        return env;
    }

    public static String escapeLDAPSearchFilter(String filter) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < filter.length(); i++) {
            char curChar = filter.charAt(i);
            switch (curChar) {
                case '\\':
                    sb.append("\\5c");
                    break;
                case '*':
                    sb.append("\\2a");
                    break;
                case '(':
                    sb.append("\\28");
                    break;
                case ')':
                    sb.append("\\29");
                    break;
                case '\u0000':
                    sb.append("\\00");
                    break;
                default:
                    sb.append(curChar);
            }
        }
        return sb.toString();
    }
}
