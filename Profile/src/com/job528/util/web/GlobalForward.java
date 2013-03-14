/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.job528.util.web;

/**
 */
public interface GlobalForward {

  
    static String FORWARD_TO_LOGIN = "forwardToLogin";

   
    static String FORWARD_TO_HOME = "forwardToHome";

  
    static String FORWARD_BY_XML = "forwardByXml";

 
    static String FORWARD_BY_URL = "forwardByURL";

    static String FORWARD_TO_ERROR = "forwardToError";

    
    static String FORWARD_TO_MSGBOX = "forwardToMsgBox";
 
    static String FORWARD_TO_MSG = "forwardToMsg";

  
    static String FORWARD_TO_MSG_EX = "forwardToMsgEx";
    
 
    static String FORWARD_TO_MSG_CLOSE = "forwardToMsgClose";

}
