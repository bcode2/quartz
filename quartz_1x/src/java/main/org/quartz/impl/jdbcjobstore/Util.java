/*
 * Copyright (c) 2004-2005 by OpenSymphony
 * All rights reserved.
 * 
 * Previously Copyright (c) 2001-2004 James House
 */
package org.quartz.impl.jdbcjobstore;

import java.text.MessageFormat;

/**
 * <p>
 * This class contains utility functions for use in all delegate classes.
 * </p>
 * 
 * @author <a href="mailto:jeff@binaryfeed.org">Jeffrey Wescott</a>
 */
public final class Util {

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 
     * Interface.
     * 
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    /**
     * <p>
     * Replace the table prefix in a query by replacing any occurrences of
     * "{0}" with the table prefix.
     * </p>
     * 
     * @param query
     *          the unsubstitued query
     * @param query
     *          the table prefix
     * @return the query, with proper table prefix substituted
     */
    public static final String rtp(String query, String tablePrefix) {
        return MessageFormat.format(query, new Object[]{tablePrefix});
    }

    /**
     * <p>
     * Obtain a unique key for a given job.
     * </p>
     * 
     * @param jobName
     *          the job name
     * @param groupName
     *          the group containing the job
     * @return a unique <code>String</code> key
     */
    static final String getJobNameKey(String jobName, String groupName) {
        return (groupName + "_$x$x$_" + jobName).intern();
    }

    /**
     * <p>
     * Obtain a unique key for a given trigger.
     * </p>
     * 
     * @param triggerName
     *          the trigger name
     * @param groupName
     *          the group containing the trigger
     * @return a unique <code>String</code> key
     */
    static final String getTriggerNameKey(String triggerName, String groupName) {
        return (groupName + "_$x$x$_" + triggerName).intern();
    }
}

// EOF