/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.apache.catalina.security;

/**
 * Static class used to preload java classes when using the
 * Java SecurityManager so that the defineClassInPackage
 * RuntimePermission does not trigger an AccessControlException.
 * 静态类用于在使用java SecurityManager时预加载java类
 * 以便defineClassInPackage RuntimePermission不会触发AccessControlException。
 *
 *
 * 为了安全加载类，Tomcat中通过org.apache.catalina.security.SecurityClassLoad来
 * 预加载Tomcat自身的核心类（如果启用了SecurityManager的话，通过Tomcat的参数-security来开启），
 * 以免在之后触发AccessControlException的RuntimePermission.
 *
 * 为什么用Security Manager可以达到安全沙箱的目的？这是因为在JDK底层所有的api中，都已经加上了这种检验处理。
 *
 * @author Glenn L. Nielsen
 * @author Jean-Francois Arcand
 */
public final class SecurityClassLoad {

    public static void securityClassLoad(ClassLoader loader)
        throws Exception {

        if( System.getSecurityManager() == null ){
            return;
        }

        loadCorePackage(loader);
        loadCoyotePackage(loader);
        loadLoaderPackage(loader);
        loadRealmPackage(loader);
        loadServletsPackage(loader);
        loadSessionPackage(loader);
        loadUtilPackage(loader);
        loadValvesPackage(loader);
        loadJavaxPackage(loader);
        loadConnectorPackage(loader);
        loadTomcatPackage(loader);
    }


    private static final void loadCorePackage(ClassLoader loader)
        throws Exception {
        final String basePackage = "org.apache.catalina.core.";
        loader.loadClass(basePackage + "AccessLogAdapter");
        loadAnonymousInnerClasses(loader, basePackage + "ApplicationContextFacade");
        loader.loadClass(basePackage + "ApplicationDispatcher$PrivilegedForward");
        loader.loadClass(basePackage + "ApplicationDispatcher$PrivilegedInclude");
        loader.loadClass(basePackage + "AsyncContextImpl");
        loader.loadClass(basePackage + "AsyncContextImpl$DebugException");
        loadAnonymousInnerClasses(loader, basePackage + "AsyncContextImpl");
        loader.loadClass(basePackage + "AsyncListenerWrapper");
        loader.loadClass(basePackage + "ContainerBase$PrivilegedAddChild");
        loadAnonymousInnerClasses(loader, basePackage + "DefaultInstanceManager");
        loader.loadClass(basePackage + "DefaultInstanceManager$AnnotationCacheEntry");
        loader.loadClass(basePackage + "DefaultInstanceManager$AnnotationCacheEntryType");
        loader.loadClass(basePackage + "ApplicationHttpRequest$AttributeNamesEnumerator");
    }


    private static final void loadLoaderPackage(ClassLoader loader)
        throws Exception {
        final String basePackage = "org.apache.catalina.loader.";
        loader.loadClass
            (basePackage +
             "ResourceEntry");
        loader.loadClass
            (basePackage +
             "WebappClassLoaderBase$PrivilegedFindResourceByName");
    }


    private static final void loadRealmPackage(ClassLoader loader)
            throws Exception {
        final String basePackage = "org.apache.catalina.realm.";
        loader.loadClass
            (basePackage + "LockOutRealm$LockRecord");
    }


    private static final void loadServletsPackage(ClassLoader loader)
            throws Exception {
        final String basePackage = "org.apache.catalina.servlets.";
        // Avoid a possible memory leak in the DefaultServlet when running with
        // a security manager. The DefaultServlet needs to load an XML parser
        // when running under a security manager. We want this to be loaded by
        // the container rather than a web application to prevent a memory leak
        // via web application class loader.
        loader.loadClass(basePackage + "DefaultServlet");
    }


    private static final void loadSessionPackage(ClassLoader loader)
        throws Exception {
        final String basePackage = "org.apache.catalina.session.";
        loader.loadClass(basePackage + "StandardSession");
        loadAnonymousInnerClasses(loader, basePackage + "StandardSession");
        loader.loadClass(basePackage + "StandardManager$PrivilegedDoUnload");
    }


    private static final void loadUtilPackage(ClassLoader loader)
        throws Exception {
        final String basePackage = "org.apache.catalina.util.";
        loader.loadClass(basePackage + "Enumerator");
        loader.loadClass(basePackage + "ParameterMap");
        loader.loadClass(basePackage + "RequestUtil");
    }


    private static final void loadValvesPackage(ClassLoader loader)
            throws Exception {
            final String basePackage = "org.apache.catalina.valves.";
            loader.loadClass(basePackage + "AccessLogValve$3");
        }


    private static final void loadCoyotePackage(ClassLoader loader)
            throws Exception {
        final String basePackage = "org.apache.coyote.";
        // Java 6 compiler creates helper *$1 classes because we use switch with an enum
        loadAnonymousInnerClasses(loader, basePackage + "http11.AbstractHttp11Processor");
        loadAnonymousInnerClasses(loader, basePackage + "http11.Http11Processor");
        loadAnonymousInnerClasses(loader, basePackage + "http11.Http11NioProcessor");
        loadAnonymousInnerClasses(loader, basePackage + "http11.Http11AprProcessor");
        loadAnonymousInnerClasses(loader, basePackage + "http11.AbstractOutputBuffer");
        loader.loadClass(basePackage + "http11.Constants");
        // Make sure system property is read at this point
        Class<?> clazz = loader.loadClass(basePackage + "Constants");
        clazz.newInstance();
    }


    private static final void loadJavaxPackage(ClassLoader loader)
        throws Exception {
        loader.loadClass("javax.servlet.http.Cookie");
    }


    private static final void loadConnectorPackage(ClassLoader loader)
        throws Exception {
        final String basePackage = "org.apache.catalina.connector.";
        loader.loadClass(basePackage + "RequestFacade$GetAttributePrivilegedAction");
        loader.loadClass(basePackage + "RequestFacade$GetParameterMapPrivilegedAction");
        loader.loadClass(basePackage + "RequestFacade$GetRequestDispatcherPrivilegedAction");
        loader.loadClass(basePackage + "RequestFacade$GetParameterPrivilegedAction");
        loader.loadClass(basePackage + "RequestFacade$GetParameterNamesPrivilegedAction");
        loader.loadClass(basePackage + "RequestFacade$GetParameterValuePrivilegedAction");
        loader.loadClass(basePackage + "RequestFacade$GetCharacterEncodingPrivilegedAction");
        loader.loadClass(basePackage + "RequestFacade$GetHeadersPrivilegedAction");
        loader.loadClass(basePackage + "RequestFacade$GetHeaderNamesPrivilegedAction");
        loader.loadClass(basePackage + "RequestFacade$GetCookiesPrivilegedAction");
        loader.loadClass(basePackage + "RequestFacade$GetLocalePrivilegedAction");
        loader.loadClass(basePackage + "RequestFacade$GetLocalesPrivilegedAction");
        loader.loadClass(basePackage + "ResponseFacade$SetContentTypePrivilegedAction");
        loader.loadClass(basePackage + "ResponseFacade$DateHeaderPrivilegedAction");
        loader.loadClass(basePackage + "RequestFacade$GetSessionPrivilegedAction");
        loadAnonymousInnerClasses(loader, basePackage + "ResponseFacade");
        loadAnonymousInnerClasses(loader, basePackage + "OutputBuffer");
        loadAnonymousInnerClasses(loader, basePackage + "CoyoteInputStream");
        loadAnonymousInnerClasses(loader, basePackage + "InputBuffer");
        loadAnonymousInnerClasses(loader, basePackage + "Response");
    }

    private static final void loadTomcatPackage(ClassLoader loader)
        throws Exception {
        final String basePackage = "org.apache.tomcat.";
        // buf
        loader.loadClass(basePackage + "util.buf.B2CConverter");
        loader.loadClass(basePackage + "util.buf.C2BConverter");
        loader.loadClass(basePackage + "util.buf.HexUtils");
        loader.loadClass(basePackage + "util.buf.StringCache");
        loader.loadClass(basePackage + "util.buf.StringCache$ByteEntry");
        loader.loadClass(basePackage + "util.buf.StringCache$CharEntry");
        loader.loadClass(basePackage + "util.buf.UriUtil");
        // http
        loader.loadClass(basePackage + "util.http.HttpMessages");
        // Make sure system property is read at this point
        Class<?> clazz = loader.loadClass(
                basePackage + "util.http.FastHttpDateFormat");
        clazz.newInstance();
        loader.loadClass(basePackage + "util.http.HttpMessages");
        loader.loadClass(basePackage + "util.http.parser.HttpParser");
        loader.loadClass(basePackage + "util.http.parser.HttpParser$AllowsEnd");
        loader.loadClass(basePackage + "util.http.parser.HttpParser$DomainParseState");
        loader.loadClass(basePackage + "util.http.parser.HttpParser$SkipResult");
        loader.loadClass(basePackage + "util.http.parser.MediaType");
        loader.loadClass(basePackage + "util.http.parser.MediaTypeCache");
        // jni
        loader.loadClass(basePackage + "jni.Status");
        // net
        loader.loadClass(basePackage + "util.net.Constants");
        loadAnonymousInnerClasses(loader, basePackage + "util.net.NioBlockingSelector$BlockPoller");
        loader.loadClass(basePackage + "util.net.SendfileState");
        loader.loadClass(basePackage + "util.net.SSLSupport$CipherData");
        // security
        loader.loadClass(basePackage + "util.security.PrivilegedGetTccl");
        loader.loadClass(basePackage + "util.security.PrivilegedSetTccl");
    }

    private static final void loadAnonymousInnerClasses(ClassLoader loader, String enclosingClass) {
        try {
            for (int i = 1;; i++) {
                loader.loadClass(enclosingClass + '$' + i);
            }
        } catch (ClassNotFoundException ignored) {
            //
        }
    }
}

