package com.atmosferpoc.shared.util;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class RemoveScriptUtil {
    public static String removeScriptTags(String msg){
        String scriptRegex= "<(/)?[ ]*script[ˆ>]*>";
        Pattern pattern= Pattern.compile(scriptRegex);

        if(msg!= null){
            Matcher matcher=pattern.matcher(msg);
            StringBuffer str= new StringBuffer(msg.length());
            while (matcher.find()){
                matcher.appendReplacement(str,Matcher.quoteReplacement(" "));
            }
            matcher.appendTail(str);
            msg=str.toString();
        }
        return msg;
    }
}
