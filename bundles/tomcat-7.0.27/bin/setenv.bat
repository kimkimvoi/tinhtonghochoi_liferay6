if exist "%CATALINA_HOME%/jre${jdk.windows.version}/win" (
	if not "%JAVA_HOME%" == "" (
		set JAVA_HOME=
	)

	set "JRE_HOME=%CATALINA_HOME%/jre${jdk.windows.version}/win"
)

set JAVA_OPTS="-XX:MaxPermSize=900m"