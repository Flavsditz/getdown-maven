What is it?
-----------

The maven getdown plugin adds a mcgafter to maven's build lifecycle that will 
generate [getdown's][1] digest.txt file.

Use
---

You need to make sure that there is a getdown.txt file copied to the target (or specified appdir) 
directory during the build process.  Then setup the plugin as shown below:

	<plugin>
		<groupId>org.bitbucket.joxley</groupId>
		<artifactId>getdown-maven-plugin</artifactId>
		<version>0.0.1</version>
		<configuration>
			<appdir>target/app</appdir> <!-- Defaults to target -->
		</configuration>
		<executions>
			<execution>
				<phase>package</phase>
				<goals>
					<goal>digest</goal>
				</goals>
			</execution>
		</executions>
	</plugin>



  [1]: http://code.google.com/p/getdown/