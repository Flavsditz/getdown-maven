What is it?
-----------

The maven getdown plugin to maven's build lifecycle to generate [getdown's][1] digest.txt file.

Originally develop by John Oxley, this version is his project (1-to-1) with the getdown version updated.
All merits go to him for build this project.

His project didn't allo for any pull requests so I created this one to fill my needs.

Use
---
Since this is not hosted in maven central or so, in order to use it:
* Clone it
* run *mvn clean install* in order to install it in your local repo
* add the information as in the POM below

You need to make sure that there is a getdown.txt file copied to the target (or specified appdir) 
directory during the build process.  Then setup the plugin as shown below:

	<plugin>
		<groupId>org.bitbucket.joxley</groupId>
		<artifactId>getdown-maven-plugin</artifactId>
		<version>1.0.2</version>
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