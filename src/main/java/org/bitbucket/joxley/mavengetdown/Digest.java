package org.bitbucket.joxley.mavengetdown;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;

import com.threerings.getdown.tools.Digester;

/**
 * Create the digest
 * 
 * @goal digest
 */
public class Digest extends AbstractMojo {
	/**
	 * Application directory
	 * 
	 * @parameter default-value="target"
	 */
	private File appdir;

	public void execute() {
		Digester.createDigest(appdir);
	}
}
