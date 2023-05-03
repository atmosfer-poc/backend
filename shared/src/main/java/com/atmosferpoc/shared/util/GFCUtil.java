package com.atmosferpoc.shared.util;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class GFCUtil {
    public static boolean strMatch(String str, String pattern)
    {
        // empty pattern can only match with
        // empty string
        if (pattern.length() == 0)
            return (str.length() == 0);

        // lookup table for storing results of
        // subproblems
        var lookup = new boolean[str.length() + 1][pattern.length() + 1];

        // initialize lookup table to false
        for (var i = 0; i < str.length() + 1; i++)
            Arrays.fill(lookup[i], false);

        // empty pattern can match with empty string
        lookup[0][0] = true;

        // Only '*' can match with empty string
        for (var j = 1; j <= pattern.length(); j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];

        // fill the table in bottom-up fashion
        for (var i = 1; i <= str.length(); i++)
        {
            for (var j = 1; j <= pattern.length(); j++)
            {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty
                //     sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j - 1) == '*')
                    lookup[i][j] = lookup[i][j - 1]
                            || lookup[i - 1][j];

                    // Current characters are considered as
                    // matching in two cases
                    // (a) current character of pattern is '?'
                    // (b) characters actually match
                else if (pattern.charAt(j - 1) == '?'
                        || str.charAt(i - 1)
                        == pattern.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1];

                    // If characters don't match
                else
                    lookup[i][j] = false;
            }
        }

        return lookup[str.length()][pattern.length()];
    }

}
