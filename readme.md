What is it?
-----------

The maven getdown plugin adds a mcgafter to maven's build lifecycle that will 
generate [getdown's][1] digest.txt file.

Use
---
	<plugin>
		<groupId>org.bitbucket.joxley</groupId>
		<artifactId>getdown-maven-plugin</artifactId>
		<version>0.0.1-SNAPSHOT</version>
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